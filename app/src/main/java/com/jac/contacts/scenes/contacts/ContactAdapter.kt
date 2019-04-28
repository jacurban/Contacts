package com.jac.contacts.scenes.contacts

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jac.contacts.R
import com.jac.contacts.model.Person
import com.jac.contacts.scenes.details.DetailsActivity
import kotlinx.android.synthetic.main.item_contact.view.*


//plota os itens da lista que eu declarei na tela
class ContactAdapter(private val contacts: MutableList<Person>, private val contactListFragment: ContactListFragment) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nameTV.text = contacts[position].name
        holder.itemView.emailTV.text = contacts[position].email
        holder.itemView.phoneTV.text = contacts[position].phone

        holder.itemView.editBTN.setOnClickListener {
            val intent = Intent(contactListFragment.activity, DetailsActivity::class.java) // intençao de abrir a DetailsActivity
            intent.putExtra(DetailsActivity.EXTRA_EDIT, contacts[position])
            contactListFragment.activity?.startActivity(intent)
        }
        holder.itemView.deleteBTN.setOnClickListener {
           // Toast.makeText(contactListFragment.activity, contacts[position].name, Toast.LENGTH_LONG).show()
            //ContactDB.instance.personDAO().delete(contacts[position])
            contactListFragment.deleteItem(position)
        }

        holder.itemView.itemBTN.setOnClickListener {
            if (contacts[position].visible) {
                holder.itemView.emailTV.visibility = View.GONE
                holder.itemView.phoneTV.visibility = View.GONE
                holder.itemView.editBTN.visibility = View.GONE
                holder.itemView.deleteBTN.visibility = View.GONE
                contacts[position].visible = false
            } else{
                holder.itemView.emailTV.visibility = View.VISIBLE
                holder.itemView.phoneTV.visibility = View.VISIBLE
                holder.itemView.editBTN.visibility = View.VISIBLE
                holder.itemView.deleteBTN.visibility = View.VISIBLE
                contacts[position].visible = true
            }
        }

    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item)
}