package com.cauarosa.navegabilidade.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cauarosa.navegabilidade.R
import com.cauarosa.navegabilidade.data.model.Status
import com.cauarosa.navegabilidade.data.model.Task
import com.cauarosa.navegabilidade.databinding.FragmentTodoBinding
import com.cauarosa.navegabilidade.ui.adapter.TaskAdapter

class TodoFragment : Fragment() {

    private lateinit var taskAdapter: TaskAdapter

    private var _biding: FragmentTodoBinding? = null
    private val binding get() = _biding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initRecyclerViewTask()
        getTask()
    }

    private fun initListener(){
        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate((R.id.action_homeFragment_to_formTaskFragment))
        }
    }

    private fun initRecyclerViewTask() {
        taskAdapter = TaskAdapter(requireContext()) { task, option -> optionSelected(task, option) }

        with(binding.recyclerViewTask) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = taskAdapter
        }
    }

    private fun optionSelected(task: Task, option: Int) {
        when (option) {
            TaskAdapter.SELECT_REMOVER -> {
                Toast.makeText(requireContext(), "Removendo ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_EDIT -> {
                Toast.makeText(requireContext(), "Editando ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_DETAILS -> {
                Toast.makeText(requireContext(), "Detalhes ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_NEXT -> {
                Toast.makeText(requireContext(), "Próximo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getTask() {

        val taskList = listOf(
            Task("0", "Criar nova tela do app", Status.TODO),
            Task("1", "Validar informações na tela de login", Status.TODO),
            Task("2", "Adicionar nova funcionalidade no app", Status.TODO),
            Task("3", "Salvar token localmente", Status.TODO),
            Task("4", "Criar funcionalidade de logout no app", Status.TODO)
        )
        taskAdapter.submitList(taskList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }

}
