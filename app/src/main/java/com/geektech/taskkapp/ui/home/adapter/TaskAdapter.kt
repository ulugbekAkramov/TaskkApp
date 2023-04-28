package com.geektech.taskkapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.taskkapp.databinding.ItemTaskBinding
import com.geektech.taskkapp.model.Task

class TaskAdapter(private val onLongClick:(task: Task)->Unit) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
private val data = arrayListOf<Task>()


    fun deleteTask(task: Task){
        data.remove(task)
        notifyDataSetChanged()
    }

    fun addTasks(task: List<Task>){
        data.clear()
        data.addAll(task)
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data.get(position))

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {

            itemView.setOnLongClickListener {
                onLongClick(task)
                true
            }
            binding.tvTitle.text=task.title
            binding.tvDesk.text=task.desc

        }

    }
}