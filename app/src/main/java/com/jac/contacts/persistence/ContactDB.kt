package com.jac.contacts.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.jac.contacts.model.Person


//O banco de dados
@Database(entities = [Person::class], version = 1)
abstract class ContactDB: RoomDatabase() {

    private fun ContactDB(){} // proibe criar uma instancia dessa classe fora dela

    abstract fun personDAO(): PersonDAO

    companion object {
        lateinit var instance: ContactDB //garantir unica instancia dessa classe
            private set // só é possivel modificar de dentro da propria classe

        fun initialize(context: Context) {
            instance = Room.databaseBuilder(context, ContactDB::class.java, "contact.db").apply {
                allowMainThreadQueries()
            }.build()        }
    }
}