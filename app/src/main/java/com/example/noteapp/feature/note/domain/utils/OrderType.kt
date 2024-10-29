package com.example.noteapp.feature.note.domain.utils

sealed class OrderType {

    object Ascending : OrderType()
    object Descending : OrderType()

}