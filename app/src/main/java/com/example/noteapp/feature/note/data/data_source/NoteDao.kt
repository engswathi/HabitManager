package com.example.noteapp.feature.note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteapp.feature.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("Select * from note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM NOTE WHERE ID =:id")
    suspend fun getNoteById(id : Int) : Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)


}