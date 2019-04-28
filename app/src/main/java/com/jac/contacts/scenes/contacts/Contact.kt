package com.jac.contacts.scenes.contacts

import com.jac.contacts.model.Person
import com.jac.contacts.scenes.Scene


interface Contact {
    interface View: Scene.View {
        fun loadList(listOfContacts: List<Person>?)
    }
    interface Presenter: Scene.Presenter {
        fun gelAll()
        fun kill()
    }
}