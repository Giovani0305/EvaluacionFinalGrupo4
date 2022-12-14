package com.divyamoza.assesmentdemo.repo

import androidx.lifecycle.LiveData
import com.divyamoza.assesmentdemo.models.dbentity.PersonaDao
import com.divyamoza.assesmentdemo.models.dbentity.PersonaEntity

class PersonaRepository(private val personaDao: PersonaDao) {

    suspend fun insertar(personaEntity: PersonaEntity){
        personaDao.insertar(personaEntity)
    }
    suspend fun actualizar(personaEntity: PersonaEntity){
        personaDao.actualizar(personaEntity)
    }
    suspend fun eliminarTodo(){
        personaDao.eliminarTodo()
    }

    fun obtener(): LiveData<PersonaEntity>{
        return personaDao.obtener()
    }

}