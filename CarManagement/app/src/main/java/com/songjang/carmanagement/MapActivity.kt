package com.songjang.carmanagement

import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import com.songjang.carmanagement.api.NaverGeocodingClient
import com.songjang.carmanagement.models.Address
import com.songjang.carmanagement.models.AddressAdapter
import com.songjang.carmanagement.models.GeocodingResponse
import retrofit2.Call

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap
    private lateinit var searchResultRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // RecyclerView 초기화
        searchResultRecyclerView = findViewById(R.id.searchResultList)
        searchResultRecyclerView.layoutManager = LinearLayoutManager(this)
        searchResultRecyclerView.adapter = AddressAdapter(emptyList()) { }

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as MapFragment
        mapFragment.getMapAsync(this)

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        val searchButton = findViewById<Button>(R.id.searchButton)

        // 지도 외부를 터치하면 검색 리스트 닫기
        findViewById<View>(R.id.map_fragment).setOnClickListener {
            if (searchResultRecyclerView.visibility == View.VISIBLE) {
                searchResultRecyclerView.visibility = View.GONE
            }
        }

        // 검색 이벤트 처리
        searchEditText.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                event?.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val query = searchEditText.text.toString()
                if (query.isNotBlank()) {
                    searchPlaces(query)
                } else {
                    Toast.makeText(this, "검색어를 입력하세요.", Toast.LENGTH_SHORT).show()
                }
                true
            } else {
                false
            }
        }

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotBlank()) {
                searchPlaces(query)
            } else {
                Toast.makeText(this, "검색어를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap

        // 위치 소스 설정
        naverMap.locationSource = locationSource

        // 내 위치 버튼 활성화
        val uiSettings = naverMap.uiSettings
        uiSettings.isLocationButtonEnabled = true

        // 위치 추적 모드 활성화
        naverMap.locationTrackingMode = LocationTrackingMode.Follow

        // Marker 설정(나중에 데이터 연결)
        val marker = Marker()
        marker.position = LatLng(37.481926, 126.882950)
        marker.map = naverMap
        marker.icon = OverlayImage.fromResource(R.drawable.caricon)
        marker.iconTintColor = Color.BLUE
        marker.width = 80
        marker.height = 80
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) {
                naverMap.locationTrackingMode = LocationTrackingMode.None
                Toast.makeText(this, "위치 권한이 필요합니다.", Toast.LENGTH_SHORT).show()
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun searchPlaces(query: String) {
        val clientId = "uvynrcnrp3" // 네이버 클라이언트 ID
        val clientSecret = "SdpUCvqNTW19NSZmxEIfJNn56uD8322KlrfehZLl" // 네이버 클라이언트 Secret

        val call = NaverGeocodingClient.api.getGeocode(clientId, clientSecret, query)
        call.enqueue(object : retrofit2.Callback<GeocodingResponse> {
            override fun onResponse(
                call: Call<GeocodingResponse>,
                response: retrofit2.Response<GeocodingResponse>
            ) {
                if (response.isSuccessful) {
                    val addresses = response.body()?.addresses ?: return
                    if (addresses.isNotEmpty()) {
                        val sortedAddresses = sortAddressesBySimilarity(query, addresses)
                        showAddressList(sortedAddresses) // 검색 결과 리스트 표시
                    } else {
                        Toast.makeText(this@MapActivity, "결과를 찾을 수 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MapActivity, "검색 실패: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<GeocodingResponse>, t: Throwable) {
                Toast.makeText(this@MapActivity, "네트워크 오류: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun sortAddressesBySimilarity(query: String, addresses: List<Address>): List<Address> {
        return addresses.sortedBy { address ->
            val roadAddressSimilarity = address.roadAddress?.let { levenshteinDistance(query, it) } ?: Int.MAX_VALUE
            val jibunAddressSimilarity = address.jibunAddress?.let { levenshteinDistance(query, it) } ?: Int.MAX_VALUE
            minOf(roadAddressSimilarity, jibunAddressSimilarity) // 가장 유사한 점수를 기준으로 정렬
        }
    }

    // 레벤슈타인 거리 계산 (문자열 유사도 측정)
    private fun levenshteinDistance(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }
        for (i in 0..s1.length) dp[i][0] = i
        for (j in 0..s2.length) dp[0][j] = j

        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                val cost = if (s1[i - 1] == s2[j - 1]) 0 else 1
                dp[i][j] = minOf(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost)
            }
        }
        return dp[s1.length][s2.length]
    }

private fun showAddressList(places: List<Address>) {
    searchResultRecyclerView.visibility = View.VISIBLE // 검색 결과 표시
    searchResultRecyclerView.layoutManager = LinearLayoutManager(this)
    searchResultRecyclerView.adapter = AddressAdapter(places) { place ->
        // 사용자가 항목 선택 시
        showPlaceOnMap(place)
        searchResultRecyclerView.visibility = View.GONE // 리스트 닫기
    }
}

    private fun showPlaceOnMap(place: Address) {
        val latitude = place.y.toDouble()
        val longitude = place.x.toDouble()

        // 마커 생성
        val marker = Marker()
        marker.position = LatLng(latitude, longitude)
        marker.map = naverMap

        // 지도 중심 이동
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(latitude, longitude))
        naverMap.moveCamera(cameraUpdate)
    }

    private fun showAddressOnMap(address: Address) {
        val latitude = address.y.toDouble()
        val longitude = address.x.toDouble()

        // 마커 생성
        val marker = Marker()
        marker.position = LatLng(latitude, longitude)
        marker.captionText = address.roadAddress ?: address.jibunAddress ?: "주소 없음"
        marker.map = naverMap

        // 지도 중심 이동
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(latitude, longitude))
        naverMap.moveCamera(cameraUpdate)
    }

    fun updateSearchResults(addresses: List<Address>) {
        val adapter = AddressAdapter(addresses) { address ->
            searchResultRecyclerView.visibility = View.GONE
            showAddressOnMap(address)
        }
        searchResultRecyclerView.adapter = adapter
        searchResultRecyclerView.visibility = View.VISIBLE
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}