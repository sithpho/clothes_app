package com.up.clothes_app.webservice

import com.up.clothes_app.model.LoginRequestBody
import com.up.clothes_app.model.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ServiceApi
{
    // login
    @POST("back-end/auth/login")
    fun getAuthLoginRequestServices(@Body loginReq: LoginRequestBody): Observable<LoginResponse>

    // promotion list
//    @GET("api/v1/back-office/life-style/promotion/customer-promotion/list")
//    fun getPromotionListRequestServices(@Query("customerId") customerId: Int,
//                            @Query("size") size: Int,
//                            @Query("page") page: Int): Observable<PromotionResponse>

}