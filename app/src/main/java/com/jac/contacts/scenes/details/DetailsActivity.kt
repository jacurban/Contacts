package com.jac.contacts.scenes.details

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jac.contacts.scenes.contacts.ContactListFragment
import com.jac.contacts.R
import com.jac.contacts.model.Person
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), Details.View {

    private lateinit var presenter: Details.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        presenter = DetailsPresenter (this)

        val contact: Person? = intent.getParcelableExtra(EXTRA_EDIT)
        if (contact == null){
            saveBTN.text = getString(R.string.save)
        }else{
            saveBTN?.text = getString(R.string.edit)
            nameEDT?.setText(contact.name)
            emailEDT?.setText(contact.email)
            phoneEDT?.setText(contact.phone)
        }

        saveBTN.setOnClickListener {

            if (!nameEDT?.text.isNullOrEmpty() && !emailEDT?.text.isNullOrEmpty() && !phoneEDT?.text.isNullOrEmpty()) {
                val name = nameEDT.text.toString()
                val email = emailEDT.text.toString()
                val phone = phoneEDT.text.toString()
                val newContact = Person(name, email, phone)
                if (contact == null) {
                    presenter.insertContact(newContact)
                } else {
                    presenter.updateContact(newContact)
                }
                val i = Intent()
                i.putExtra(ContactListFragment.EXTRA_CONTACT, newContact)
                setResult(Activity.RESULT_OK, i)
                finish()
            }
        }
    }
    companion object {
        const val EXTRA_EDIT = "EXTRA_EDIT"
    }

}
