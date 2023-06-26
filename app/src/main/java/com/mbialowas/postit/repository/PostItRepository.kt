package com.mbialowas.postit.repository

import com.mbialowas.postit.data.PostDatabaseDao
import com.mbialowas.postit.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostItRepository @Inject constructor(private val postDatabaseDao: PostDatabaseDao){
    suspend fun addPost(post: Post)= postDatabaseDao.insert(post)

    suspend fun  updatePost(post: Post) = postDatabaseDao.update(post)

    suspend fun  deletePost(post: Post) = postDatabaseDao.delete(post)

    fun  getAllPosts(): Flow<List<Post>> = postDatabaseDao.getPosts().flowOn(Dispatchers.IO).conflate()
}