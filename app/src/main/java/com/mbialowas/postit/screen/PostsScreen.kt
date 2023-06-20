package com.mbialowas.postit.screen

import android.widget.Toast
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mbialowas.postit.R
import com.mbialowas.postit.components.PostInputText
import com.mbialowas.postit.components.PostItButton
import com.mbialowas.postit.components.PostItRow
import com.mbialowas.postit.model.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    posts: List<Post>,
    onPostAdd: (Post) -> Unit,
    onRemovePost: (Post) -> Unit
){
    var title by remember{
        mutableStateOf("")
    }
    var description by remember{
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(4.dp)
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon displayed on screen"
                )
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Green)
        )
        Column(
             modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Content
            PostInputText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 5.dp,
                        bottom = 5.dp
                    ),
                text = title,
                label = "I'm a label :)",
                onTextChange = {
                    title= it
                }
            )
            PostInputText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 5.dp,
                        bottom = 5.dp
                    ),
                text = description,
                label = "Winnipeg Jets:)",
                onTextChange = {
                    description = it
                }
            )
            PostItButton(
                text = "Save",
                onClick = {
                    // todo
                    onPostAdd(Post(title=title, description = description))
                    // clear the input fields
                    title=""
                    description=""
                    Toast.makeText(context, "You inserted a new post", Toast.LENGTH_SHORT).show()
                }
            )
        }
        Divider(
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn{
            items(posts){ post->
                PostItRow(post = post, onPostClicked = {
                    onRemovePost(post)
                })
                Divider(
                    modifier = Modifier.padding(5.dp)
                )
            }


        }
    }
}