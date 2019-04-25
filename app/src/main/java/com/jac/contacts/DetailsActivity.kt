package com.jac.contacts

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jac.contacts.model.Person
import com.jac.contacts.persistence.ContactDB
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private val addTaskRequest = 1  //use this immutable value to reference your request to add new tasks later on

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val status = intent.getIntExtra(EXTRA_BUTTON, 0)
        if (status == 1){
            saveBTN.text = getString(R.string.save)
        }else{
            saveBTN.text = getString(R.string.edit)
        }

//        val info = intent.extras
//        if (info!=null){
//            ContactDB.instance.delete()
//        }

        saveBTN.setOnClickListener {
            if (!nameEDT.text.isNullOrEmpty() && !emailEDT.text.isNullOrEmpty() && !phoneEDT.text.isNullOrEmpty()) {
                val name = nameEDT.text.toString()
                val email = emailEDT.text.toString()
                val phone = phoneEDT.text.toString()
                val person = Person(name, email, phone)
                ContactDB.instance.personDAO().insert(person)

                val i = Intent()
                i.putExtra(ContactListFragment.EXTRA_CONTACT, person)
                setResult(Activity.RESULT_OK, i)
                finish()
            }
        }
    }
    companion object {
        const val EXTRA_BUTTON = "EXTRA_BUTTON"
        const val EXTRA_EDIT = "EXTRA_EDIT"
    }

}
