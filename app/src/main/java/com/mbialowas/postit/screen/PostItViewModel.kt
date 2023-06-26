package com.mbialowas.postit.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbialowas.postit.data.PostsDatasource
import com.mbialowas.postit.model.Post
import com.mbialowas.postit.repository.PostItRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostItViewModel @Inject constructor(private val repository: PostItRepository): ViewModel() {
    // Central source of truth of data
   //var postList = mutableStateListOf<Post>()

    private val _postList = MutableStateFlow<List<Post>>(emptyList())
    val postList= _postList.asStateFlow()

    init{
        //postList.addAll(PostsDatasource().loadPosts())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllPosts().distinctUntilChanged()
                .collect{
                    listOfPosts ->
                    if (listOfPosts.isNullOrEmpty()){
                        Log.d("Empty", "Empty list")
                    }else{
                        _postList.value = listOfPosts
                    }
                }
        }
    }

    // add a post
    fun addPost(post: Post) = viewModelScope.launch {
        repository.addPost(post)
    }
    //remove a post
    fun removePost(post: Post) = viewModelScope.launch {
        repository.deletePost(post)
    }

    // update a post
    fun updatePost(post: Post) = viewModelScope.launch {
        repository.updatePost(post)
    }


}