package com.miibarra.learnkotlinrecyclerview

data class Contact(val _name:String, val age:Int) {
    val imageUrl = "https://picsum.photos/150?random=$age"
}