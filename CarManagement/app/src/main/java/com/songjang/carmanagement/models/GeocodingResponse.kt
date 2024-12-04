package com.songjang.carmanagement.models

data class GeocodingResponse(
    val status: String,
    val meta: Meta,
    val addresses: List<Address>
)
