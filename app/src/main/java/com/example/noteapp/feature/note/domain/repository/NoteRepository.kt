package com.example.noteapp.feature.note.domain.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteapp.feature.note.domain.model.Note
import kotlinx.coroutines.flow.Flow
import retrofit2.http.DELETE

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id : Int) : Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}