package com.divyamoza.assesmentdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.divyamoza.assesmentdemo.repo.AuthRepository
import com.divyamoza.assesmentdemo.data.request.RequestLogin
import com.divyamoza.assesmentdemo.data.request.RequestRegistro
import com.divyamoza.assesmentdemo.data.response.ResponseLogin
import com.divyamoza.assesmentdemo.data.response.ResponseRegistro

class AuthViewModel : ViewModel() {

    var responseLogin: LiveData<ResponseLogin>
    var responseRegistro: LiveData<ResponseRegistro>
    private var repository = AuthRepository()

    init {
        responseLogin = repository.loginReponse
        responseRegistro = repository.registroReponse
    }

    fun autenticarUsuario(usuario: String, password: String){
        responseLogin = repository.autenticarUsuario(
            RequestLogin(usuario, password)
        )
    }
    fun registrarUsuario(nombres: String, apellidos: String,
    email: String, celular: String, usuario: String, password: String){
        responseRegistro = repository.registroUsuario(
            RequestRegistro(nombres, apellidos, email,
                celular, usuario, password)
        )
    }


}