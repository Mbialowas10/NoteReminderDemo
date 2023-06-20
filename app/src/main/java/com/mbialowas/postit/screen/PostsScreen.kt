package com.mbialowas.postit.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mbialowas.postit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(){
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

        ) {

        }
    }
}