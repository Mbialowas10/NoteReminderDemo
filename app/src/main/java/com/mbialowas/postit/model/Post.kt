package com.mbialowas.postit.model

import java.util.UUID

data class Post(
    val id: UUID = UUID.randomUUID(), // generate a random id
    val title: String,
    val description: String
)
