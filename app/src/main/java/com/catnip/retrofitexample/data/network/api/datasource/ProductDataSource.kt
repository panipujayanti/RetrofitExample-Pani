package com.catnip.retrofitexample.data.network.api.datasource

import com.catnip.retrofitexample.data.network.api.model.ProductsResponse
import com.catnip.retrofitexample.data.network.api.service.ProductService

interface ProductDataSource {
    suspend fun getProducts(): ProductsResponse
}
class MockProductDataSource(): ProductDataSource{
    override suspend fun getProducts(): ProductsResponse {
        return ProductsResponse(
            products = listOf(),
            limit = 10,
            skip = 10,
            total = 10
        )
    }
}

class ProductApiDataSource(
    private val service: ProductService
) : ProductDataSource {
    override suspend fun getProducts(): ProductsResponse {
        return service.getProducts()
    }

}