package com.jac.contacts.util
import java.io.Serializable


data class Person(var name: String, var email: String, val phone: String, var visible: Boolean = false) : Serializable