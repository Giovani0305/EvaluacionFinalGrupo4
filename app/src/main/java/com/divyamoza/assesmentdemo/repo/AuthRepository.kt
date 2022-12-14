package com.divyamoza.assesmentdemo.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.divyamoza.assesmentdemo.data.PatitasCliente
import com.divyamoza.assesmentdemo.data.request.RequestLogin
import com.divyamoza.assesmentdemo.data.request.RequestRegistro
import com.divyamoza.assesmentdemo.data.response.ResponseLogin
import com.divyamoza.assesmentdemo.data.response.ResponseRegistro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {

    var loginReponse = MutableLiveData<ResponseLogin>()
    var registroReponse = MutableLiveData<ResponseRegistro>()

    fun autenticarUsuario(requestLogin: RequestLogin)
    : MutableLiveData<ResponseLogin>
    {
        val call: Call<ResponseLogin> = PatitasCliente
            .retrofitService.login(requestLogin)
        call.enqueue(object: Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                loginReponse.value = response.body()
            }
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }
        })
        return loginReponse
    }
    fun registroUsuario(requestRegistro: RequestRegistro)
            : MutableLiveData<ResponseRegistro>
    {
        val call: Call<ResponseRegistro> = PatitasCliente
            .retrofitService.registro(requestRegistro)
        call.enqueue(object: Callback<ResponseRegistro>{
            override fun onResponse(
                call: Call<ResponseRegistro>,
                response: Response<ResponseRegistro>
            ) {
                registroReponse.value = response.body()
            }
            override fun onFailure(call: Call<ResponseRegistro>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }

        })
        return registroReponse
    }

}