package com.jac.contacts.scenes.contacts

import com.jac.contacts.persistence.ContactDB
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ContactPresenter (val view: Contact.View): Contact.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null

    override fun gelAll() {
        job = launch {
            val contacts = withContext(Dispatchers.IO) { ContactDB.instance.personDAO().getAll() }
            view.loadList(contacts)
        }
    }

    override fun kill() {
        job?.cancel()
    }
}