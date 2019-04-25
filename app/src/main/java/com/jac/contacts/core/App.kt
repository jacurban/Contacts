package com.jac.contacts.core

import android.app.Application
import com.jac.contacts.persistence.ContactDB

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        ContactDB.initialize(this) //inicializar o banco de dados

        //ContactDB.instance.personDAO().'funçao que eu quero'
    }
}