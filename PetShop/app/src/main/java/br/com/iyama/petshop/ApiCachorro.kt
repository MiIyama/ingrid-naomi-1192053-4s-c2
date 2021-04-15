package br.com.iyama.petshop

import retrofit2.Call
import retrofit2.http.*

interface ApiCachorro {

    @GET("cachorros/{id}")
    fun get(@Path("id") id:String): Call<Cachorro>


}