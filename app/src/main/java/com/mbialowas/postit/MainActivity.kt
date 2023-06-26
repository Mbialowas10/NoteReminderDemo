package com.mbialowas.postit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mbialowas.postit.model.Post
import com.mbialowas.postit.screen.PostItViewModel

import com.mbialowas.postit.screen.PostsScreen
import com.mbialowas.postit.ui.theme.PostItTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostItTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MainScreen()
                    PostItApp()
                }
            }
        }
    }
}
@Composable
fun PostItApp(postItViewModel: PostItViewModel = viewModel()){
    var postList = postItViewModel.postList.collectAsState().value

    PostsScreen(
        posts = postList,
        onPostAdd = {
            postItViewModel.addPost(it)
        }
    ) {
        postItViewModel.removePost(it)
    }
}

@Composable
fun MainScreen(){
    val posts= remember{
        mutableStateListOf<Post>()
    }
    //PostsScreen(PostsDatasource().loadPosts())
    PostsScreen(
        posts = posts,
        onPostAdd = {
            posts.add(it)
        }
    ) {
        posts.remove(it)
    }
}

