package com.divyamoza.assesmentdemo.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.divyamoza.assesmentdemo.models.dbentity.PatitasRoomDatabase
import com.divyamoza.assesmentdemo.models.dbentity.PersonaEntity
import com.divyamoza.assesmentdemo.repo.PersonaRepository

class PersonaViewModel(application: Application)
    : AndroidViewModel(application) {

        private val repository : PersonaRepository

        init {
            val personaDao = PatitasRoomDatabase.getDatabase(application)
                .personaDao()
            repository = PersonaRepository(personaDao)
        }

        fun insertar(personaEntity: PersonaEntity) =
            viewModelScope.launch(Dispatchers.IO){
                repository.insertar(personaEntity)
            }
            fun actualizar(personaEntity: PersonaEntity)=
                viewModelScope.launch(Dispatchers.IO) {
                    repository.actualizar(personaEntity)
                }

            fun eliminarTodo() =
                viewModelScope.launch(Dispatchers.IO){
                    repository.eliminarTodo()
                }
            fun obtener(): LiveData<PersonaEntity>{
                return repository.obtener()
            }

}