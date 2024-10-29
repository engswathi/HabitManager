package com.example.noteapp.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.feature.note.data.data_source.NoteDatabase
import com.example.noteapp.feature.note.data.repository.NoteRepositoryImpl
import com.example.noteapp.feature.note.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
object AppModule {

//
//    @Provides
//    @Singleton
//    fun provideNoteDatabase(application: NotesApplication) : NoteDatabase{
//
//        return Room.databaseBuilder(application,
//            NoteDatabase::class.java,
//            NoteDatabase.DATABASE_NAME).build()
//
//    }
//
//    @Provides
//    @Singleton
//    fun provideNoteRepository(db:NoteDatabase) : NoteRepository{
//
//        return NoteRepositoryImpl(db.noteDao)
//
//    }
}