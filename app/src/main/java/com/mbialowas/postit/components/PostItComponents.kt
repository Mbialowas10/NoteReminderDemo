package com.mbialowas.postit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mbialowas.postit.model.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    onTextChange: (String) -> Unit
){
    TextField(
        value = text,
        label = {Text(text=label)},
        onValueChange = onTextChange,
        modifier=modifier
    )

}
@Composable
fun PostItButton(
    modifier: Modifier = Modifier,
    text:String,
    onClick: () -> Unit,
    enabled: Boolean = true
){
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
    ){
        Text(text)
    }
}

@Composable
fun PostItRow(
    modifier: Modifier = Modifier,
    post: Post,
    onPostClicked: (Post) -> Unit
){
    Surface(
        modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(bottomStart = 20.dp))
            .fillMaxWidth(),
        color= Color(0xF2EEFD),
        shadowElevation = 5.dp
    ) {
      Column(
        modifier = Modifier
            .clickable{
                onPostClicked(post)
            }
            .padding(horizontal = 10.dp, vertical=5.dp),
          horizontalAlignment = Alignment.Start
      ) {
          Text(
              text = post.title,
              style = MaterialTheme.typography.displayMedium
          )
          Text(
              text = post.description,
              style = MaterialTheme.typography.displaySmall
          )
      }
    }

}