package com.example.noteapp.feature.note.domain.use_case

import com.example.noteapp.feature.note.domain.model.Note
import com.example.noteapp.feature.note.domain.repository.NoteRepository
import com.example.noteapp.feature.note.domain.utils.NoteOrder
import com.example.noteapp.feature.note.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Color(OrderType.Descending)): Flow<List<Note>> {

        return repository.getNotes().map {

                notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title }
//                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }

                }

                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title }
//                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }

            }
        }


    }
}