package com.divyamoza.assesmentdemo.models.dbentity

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertar(vararg persona: PersonaEntity)

    @Update
    fun actualizar(vararg persona: PersonaEntity)

    @Query("DELETE FROM persona")
    fun eliminarTodo()

    @Query("SELECT * FROM persona LIMIT 1")
    fun obtener(): LiveData<PersonaEntity>

}