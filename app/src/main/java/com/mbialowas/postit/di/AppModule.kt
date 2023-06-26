package com.mbialowas.postit.di

import android.content.Context

import androidx.room.Room
import com.mbialowas.postit.data.PostDatabase
import com.mbialowas.postit.data.PostDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module // bindings to hilt
object AppModule {

    @Singleton
    @Provides
    fun providePostsDao(postDatabase: PostDatabase): PostDatabaseDao = postDatabase.postDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): PostDatabase=Room.databaseBuilder(
        context,
    PostDatabase:: class.java,
    "postIt_db")
        .fallbackToDestructiveMigration()
        .build()
}