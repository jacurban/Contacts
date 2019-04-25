package com.jac.contacts.persistence

import android.arch.persistence.room.*
import com.jac.contacts.model.Person


// ponte que atua sobre o banco de dados
@Dao
interface PersonDAO {
    @Insert
    fun insert(person: Person)

    @Delete
    fun delete(person: Person)

    @Update
    fun update(person: Person)

    @Query ("SELECT * FROM person")
    fun getAll(): List<Person>?

    @Query ("SELECT * FROM person WHERE email == :email")
    fun getPerson(email: String): Person?
}