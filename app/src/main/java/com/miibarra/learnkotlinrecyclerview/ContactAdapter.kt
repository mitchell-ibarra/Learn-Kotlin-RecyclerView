package com.miibarra.learnkotlinrecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miibarra.learnkotlinrecyclerview.ContactAdapter.ViewHolder
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(private val context: Context, private val contacts: List<Contact>)
    : RecyclerView.Adapter<ViewHolder>() {

    private val TAG = "ContactAdapter"

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contact: Contact) {
            itemView.tvName.text = contact._name
            itemView.tvAge.text = "Age: ${contact.age}"
            Glide.with(context).load(contact.imageUrl).into(itemView.ivProfile)
            itemView.ivProfile
        }
    }

    // Usually involves inflating a layout from XML and returning the holder - note: this is an expensive operation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        // can also pass in the single line above but keeping it this way so I can understand what is happening
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder - note: This is not expensive
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder at position $position")
        val contact = contacts[position]
        holder.bind(contact)
    }

    // Returns the total count of items in the list
    override fun getItemCount() = contacts.size
}