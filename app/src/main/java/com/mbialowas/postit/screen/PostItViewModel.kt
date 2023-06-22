package com.mbialowas.postit.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.mbialowas.postit.data.PostsDatasource
import com.mbialowas.postit.model.Post

class PostItViewModel: ViewModel() {
    // Central source of truth of data
    var postList = mutableStateListOf<Post>()

    init{
        postList.addAll(PostsDatasource().loadPosts())
    }

    // add a post
    fun addPost(post: Post){
        postList.add(post)
    }
    //remove a post
    fun removePost(post: Post){
        postList.remove(post)
    }
    //get all posts
    fun getAllPosts(): List<Post>{
        return postList
    }
}