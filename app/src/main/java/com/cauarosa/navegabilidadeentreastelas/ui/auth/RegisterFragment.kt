package com.cauarosa.navegabilidadeentreastelas.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cauarosa.navegabilidadeentreastelas.R
import com.cauarosa.navegabilidadeentreastelas.databinding.FragmentRegisterBinding
import com.cauarosa.navegabilidadeentreastelas.util.initToolbar
import com.cauarosa.navegabilidadeentreastelas.util.showBottomSheet

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.buttonEnviar.setOnClickListener {
            validateData()
        }
    }
    private fun validateData(){
        val email = binding.editTextEmail.text.toString().trim()
        val senha = binding.editTextSenha.text.toString().trim()


        if (email.isNotBlank()){
            if(senha.isNotBlank()){
                Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
            } else {
                showBottomSheet(message = R.string.password_empty_register_fragment)
            }
        } else {
            showBottomSheet(message = R.string.password_empty_register_fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}