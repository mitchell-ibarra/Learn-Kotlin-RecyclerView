package com.miibarra.learnkotlinrecyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts =  createContacts()
        rvContacts.adapter = ContactAdapter(this, contacts)
        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.itemAnimator = SlideInUpAnimator()
    }

    /**
     * Create the list of contacts to return
     */
    private fun createContacts(): List<Contact>{
        val contacts = mutableListOf<Contact>()
        for (i in 1..150){
            contacts.add(Contact("Person #$i", i))
        }
        return contacts
    }
}