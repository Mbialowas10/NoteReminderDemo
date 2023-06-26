package com.mbialowas.postit.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mbialowas.postit.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDatabaseDao {

    @Query("SELECT * FROM tbl_posts")
    fun getPosts(): Flow <List<Post>>

    @Query("SELECT  * FROM tbl_posts where id = :id")
    suspend fun getPostByID(id: String): Post

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Post)

    @Delete
    suspend fun delete(post: Post)

    @Update
    suspend fun update(post:Post)
}
