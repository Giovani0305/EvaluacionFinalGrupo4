package com.divyamoza.assesmentdemo.data

import com.divyamoza.assesmentdemo.data.request.RequestLogin
import com.divyamoza.assesmentdemo.data.request.RequestRegistro
import com.divyamoza.assesmentdemo.data.response.ResponseLogin
import com.divyamoza.assesmentdemo.data.response.ResponseRegistro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface PatitasServicio {

    @POST("login.php")
    fun login(@Body requestLogin: RequestLogin)
    : Call<ResponseLogin>

    @PUT("persona.php")
    fun registro(@Body requestRegistro: RequestRegistro)
    : Call<ResponseRegistro>

}