package com.cuna.hotdeal

data class Product(
    val name: String,   // 물건 이름
    var price: Int      // 가격
)

object ProductManager {
    private val productList = mutableListOf<Product>()

    // 동일한 이름의 Product가 존재하는지 확인하고 업데이트 또는 추가
    fun addOrUpdateProduct(name: String, price: Int) {
        val existingProduct = productList.find { it.name == name }
        if (existingProduct != null) {
            // 이미 존재하는 경우, 가격 업데이트
            existingProduct.price = price
        } else {
            // 존재하지 않는 경우, 새로 추가
            productList.add(Product(name, price))
        }
    }

    // Product 리스트 가져오기
    fun getProducts(): List<Product> {
        return productList
    }

    // 특정 이름의 Product 가져오기
    fun getProductByName(name: String): Product? {
        return productList.find { it.name == name }
    }

    // 전체 Product 초기화
    fun clearProducts() {
        productList.clear()
    }
}
