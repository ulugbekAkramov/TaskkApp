package com.geektech.taskkapp.data.local.db

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.room.*
import com.geektech.taskkapp.model.Task

@Dao
interface TaskDao {

   @Query("SELECT * FROM task ORDER BY id DESC")
   fun getAll(): List<Task>


    @Insert
    fun insert(task: Task)


    @Delete
    fun delete(task: Task)


    @Update
    fun update(task: Task)


}