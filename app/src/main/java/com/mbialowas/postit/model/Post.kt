package com.mbialowas.postit.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName="tbl_posts")
data class Post(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(), // generate a random id
    @ColumnInfo(name ="post_title")
    val title: String,
    @ColumnInfo(name = "post_description")
    val description: String
)
