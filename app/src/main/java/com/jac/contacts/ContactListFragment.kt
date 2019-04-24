package com.jac.contacts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jac.contacts.util.Person
import kotlinx.android.synthetic.main.fragment_contact_list.*

class ContactListFragment : Fragment() {

    private val contactList: MutableList<Person> by lazy { mutableListOf<Person>() }
    private var contactAdapter: ContactAdapter? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_contact_list, container, false)

        fab?.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            val intent = Intent(activity, DetailsActivity::class.java) // intençao de abrir a DetailsActivity
            intent.putExtra(DetailsActivity.EXTRA_BUTTON, 1)
            startActivityForResult(intent, REQUEST_DETAILS) //startar a activity intencionada acima
        }

        activity?.let {
            contactAdapter = ContactAdapter(contactList, it) //criando o adapter
            listRV?.adapter = contactAdapter // definir o adapter do RecyclerView (o adapter eh um montador de coleções)
            listRV?.layoutManager = LinearLayoutManager(it)  // dizer que o recyclerView eh um Linear Layout
        }

        return v
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
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
        @JvmStatic
        fun newInstance() = ContactListFragment()
        const val REQUEST_DETAILS = 1
        const val EXTRA_CONTACT = "EXTRA_CONTACT"
    }
}