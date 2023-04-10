package com.younglords.noteappkmm.di

import com.younglords.noteappkmm.data.local.DatabaseDriverFactory
import com.younglords.noteappkmm.data.note.SqlDelightNoteDataSource
import com.younglords.noteappkmm.database.NoteDatabase
import com.younglords.noteappkmm.domain.note.NoteDataSource

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}