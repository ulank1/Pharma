package kg.pharma.network

import io.reactivex.Observable
import kg.pharma.model.ApiResponse
import kg.pharma.model.Product
import kg.pharma.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 */
interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

    @GET("index/products/last")
    fun getProducts(@Query("category_id") category_id: String, @Query("page") page: Int): Observable<Response<ApiResponse<Product>>>

}