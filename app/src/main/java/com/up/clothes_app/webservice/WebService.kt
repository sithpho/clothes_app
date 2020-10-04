package com.up.clothes_app.webservice

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object WebService {

    const val BASE_LOCAL_URL: String = "http://localhost:8081/"
    private val mContentType: String = "Content-Type"
    private val mContentTypeValue: String = "application/json"

    private fun customOkHttpClient(): OkHttpClient {
        try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                @SuppressLint("TrustAllX509TrustManager")
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                }
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                }
                override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
            })

            // Install the all-trusting trust manager
            val mSSLContext = SSLContext.getInstance("SSL")
            mSSLContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = mSSLContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { _, _ -> true }

            return builder.build()

        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun requestLocal(): ServiceApi {
        val mOkHttpClientBuilder = customOkHttpClient().newBuilder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val mOkHttpClient = mOkHttpClientBuilder
                .addInterceptor { chain ->
                    var mRequest = chain.request()
                    mRequest = mRequest.newBuilder()
                        .header(mContentType, mContentTypeValue)
//                        .header(mAuthorizationType, mAuthorizationValue + "")
//                        .header(mAuthorizationType, mAuthorizationValue + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0fGJhY2stb2ZmaWNlIiwiaWF0IjoxNTk3MDQzMjg0LCJleHAiOjE2MDIzMTM2ODR9.r_QcwtUH5ScYrBdgAKetHwRtJoccgMbt7YXEYwhPdCDpBdbIXQlHaTzwHHSOS-w2Gd9g938UqDlNDoMoMK93TA")
                        .build()

                    chain.proceed(mRequest)
                }
            .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build()

        return Retrofit.Builder()
                .baseUrl(BASE_LOCAL_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build()
                .create(ServiceApi::class.java)
    }









}

data class ErrorMessage(var mStatusCode: Int, var xmessage: String = "")