package com.jac.contacts.scenes.details

import com.jac.contacts.model.Person
import com.jac.contacts.scenes.Scene

interface Details {
    interface View: Scene.View {}
    interface Presenter: Scene.Presenter {

        fun insertContact(person: Person)
        fun updateContact(person: Person)
    }
}