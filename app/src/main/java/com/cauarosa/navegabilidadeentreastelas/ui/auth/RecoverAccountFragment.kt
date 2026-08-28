package com.cauarosa.navegabilidadeentreastelas.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cauarosa.navegabilidadeentreastelas.R
import com.cauarosa.navegabilidadeentreastelas.databinding.FragmentRecoverAccountBinding
import com.cauarosa.navegabilidadeentreastelas.util.initToolbar
import com.cauarosa.navegabilidadeentreastelas.util.showBottomSheet

class RecoverAccountFragment : Fragment() {
    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {
        binding.buttonEnviar.setOnClickListener{
            validateData()
        }
    }

    private fun validateData() {
        val email = binding.editTextEmail.text.toString().trim()
        if (email.isNotBlank()){
            android.widget.Toast.makeText(requireContext(), "Tudo OK!", android.widget.Toast.LENGTH_SHORT).show()
        } else {
            showBottomSheet(message = R.string.email_empty)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}