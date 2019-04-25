package com.jac.contacts.model
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// tabela 'Person'
@Entity(tableName = "person") @Parcelize
data class Person(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "email") @PrimaryKey
    var email: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @Ignore
    var visible: Boolean = false
) : Parcelable