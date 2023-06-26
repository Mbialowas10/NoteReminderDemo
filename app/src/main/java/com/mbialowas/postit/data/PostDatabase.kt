package com.mbialowas.postit.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.mbialowas.postit.model.Post

@Database(entities = [Post::class],version = 1, exportSchema = false)
abstract class PostDatabase: RoomDatabase() {

    abstract fun postDao(): PostDatabaseDao
}