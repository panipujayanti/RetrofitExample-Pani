package com.catnip.retrofitexample.model

import com.catnip.retrofitexample.data.network.api.model.Product
import com.google.gson.annotations.SerializedName

data class ProductViewParam(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val desc: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("images")
    val images: List<String>
)

fun Product.toProductViewParam() = ProductViewParam(
    id = this.id,
    title = this.title,
    desc = this.desc,
    price = this.price,
    images = this.images
)
fun Collection<Product>.toProductViewParams() = this.map{
    it.toProductViewParam()
}
