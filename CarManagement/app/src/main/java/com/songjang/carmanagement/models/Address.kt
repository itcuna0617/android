package com.songjang.carmanagement.models

data class Address(
    val roadAddress: String?,
    val jibunAddress: String?,
    val x: String, // 경도 (longitude)
    val y: String  // 위도 (latitude)
)
