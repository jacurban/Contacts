package com.jac.contacts

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.jac.contacts.util.Person


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val contactList: MutableList<Person> by lazy { mutableListOf<Person>() }
    private var contactAdapter: ContactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab?.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            val intent = Intent(this, DetailsActivity::class.java) // intençao de abrir a DetailsActivity
            intent.putExtra(DetailsActivity.EXTRA_BUTTON, 1)
            startActivityForResult(intent, REQUEST_DETAILS) //startar a activity intencionada acim
        }

        contactAdapter = ContactAdapter(contactList, this) //criando o adapter
        listRV?.adapter = contactAdapter // definir o adapter do RecyclerView (o adapter eh um montador de coleções)
        listRV?.layoutManager = LinearLayoutManager(this)  // dizer que o recyclerView eh um Linear Layout
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_DETAILS) {
            if (resultCode == Activity.RESULT_OK) {
                val contact: Person = data?.getSerializableExtra(EXTRA_CONTACT) as Person
                contactList.add(contact)
                contactAdapter?.notifyDataSetChanged() // avisar pro contactAdapter que a lista foi alterada
                //Toast.makeText(this, contact.name, Toast.LENGTH_LONG).show() // testar pra aparecer na tela :)
                //Log.d("JAC", contact.name) // fazendo uma tag pra aparecer no Logcat

            }
        }
    }

    companion object {
        const val REQUEST_DETAILS = 1
        const val EXTRA_CONTACT = "EXTRA_CONTACT"
    }
}
