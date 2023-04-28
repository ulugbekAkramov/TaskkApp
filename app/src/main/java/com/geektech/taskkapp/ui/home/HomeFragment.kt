package com.geektech.taskkapp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.geektech.taskkapp.App
import com.geektech.taskkapp.R
import com.geektech.taskkapp.databinding.FragmentHomeBinding
import com.geektech.taskkapp.model.Task
import com.geektech.taskkapp.ui.home.adapter.TaskAdapter
import com.geektech.taskkapp.ui.task.TaskFragment


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter:TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root ?: binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::onLongClickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.adapter=adapter
  val list = App.db.taskDao().getAll()

        adapter.addTasks(list)
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }
    }

    private fun onLongClickListener(task: Task){

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Вы действительно хотите удалить ?")
        builder.setMessage("Сообщение ${task.title} будет удалено")
        builder.setPositiveButton("Да") { dialog, which ->
           App.db.taskDao().delete(task)
            adapter.deleteTask(task)

            // Обработка нажатия на кнопку "Да"
        }
        builder.setNegativeButton("Нет") { dialog, which ->
            // Обработка нажатия на кнопку "Нет"
        }
        builder.setNeutralButton("Отмена") { dialog, which ->
            // Обработка нажатия на кнопку "Отмена"
        }
        val alertDialog = builder.create()
        alertDialog.show()


    }
}