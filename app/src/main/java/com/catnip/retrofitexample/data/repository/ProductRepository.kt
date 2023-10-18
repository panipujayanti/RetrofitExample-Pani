package com.catnip.retrofitexample.data.repository

import com.catnip.firebaseauthexample.utils.ResultWrapper
import com.catnip.firebaseauthexample.utils.proceedFlow
import com.catnip.retrofitexample.data.network.api.datasource.ProductDataSource
import com.catnip.retrofitexample.data.network.api.model.ProductsResponse
import com.catnip.retrofitexample.model.ProductViewParam
import com.catnip.retrofitexample.model.toProductViewParams
import kotlinx.coroutines.flow.Flow


interface ProductRepository {
    suspend fun getProducts() : Flow<ResultWrapper<List<ProductViewParam>>>
}

class ProductRepositoryImpl(private val dataSource: ProductDataSource):ProductRepository {
    override suspend fun getProducts(): Flow<ResultWrapper<List<ProductViewParam>>> {
        return proceedFlow { dataSource.getProducts().products.toProductViewParams() }
    }

}