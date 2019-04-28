package com.jac.contacts.scenes.details

import com.jac.contacts.model.Person
import com.jac.contacts.persistence.ContactDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailsPresenter (view: Details.View): Details.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    override fun updateContact(person: Person) {
        launch {
            ContactDB.instance.personDAO().update(person)
        }
    }

    override fun insertContact(person: Person) {
        launch {
            ContactDB.instance.personDAO().insert(person)
        }
    }


}