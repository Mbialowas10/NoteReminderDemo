package com.mbialowas.postit.data

import com.mbialowas.postit.model.Post

class PostsDS {
    fun loadPosts(): List<Post>{
        return listOf(
            Post(title = "Kids", description = "Don't forgot to pickup kids from school" ),
            Post(title = "Grocery", description = "go shopping for groceries"),
            Post(title = "Exercise", description = "Jog 5 km"),
            Post(title = "Exercise", description = "Go for a bike ride"),
            Post(title = "Movie", description = "Go watch a movie")


        )
    }
}