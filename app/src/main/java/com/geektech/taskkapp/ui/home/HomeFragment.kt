package com.geektech.taskkapp.ui.home

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
import com.geektech.taskkapp.R
import com.geektech.taskkapp.databinding.FragmentHomeBinding
import com.geektech.taskkapp.model.Task
import com.geektech.taskkapp.ui.home.adapter.TaskAdapter
import com.geektech.taskkapp.ui.task.TaskFragment


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter=TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root ?: binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter=adapter
        setFragmentResultListener(TaskFragment.TASK_REQUEST){ requestKey, bundle ->
val result=bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            adapter.addTask(result)
            Log.e("ololo","onViewCreated: "+result)
        }

        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }
    }
}