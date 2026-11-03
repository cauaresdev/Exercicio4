package com.cauarosa.navegabilidade.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cauarosa.navegabilidade.R
import com.cauarosa.navegabilidade.databinding.FragmentHomeBinding
import com.cauarosa.navegabilidade.ui.adapter.ViewPageAdapter
import com.cauarosa.navegabilidade.util.FirebaseHelper
import com.cauarosa.navegabilidade.util.showBottomSheet
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _biding: FragmentHomeBinding? = null
    private val binding get() = _biding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabs()
        initListeners()
    }

    private fun initListeners() {
        binding.btnLogout.setOnClickListener {
            showBottomSheet(
                titleButton = R.string.text_button_dialog_confirm_logout,
                titleDialog = R.string.text_title_dialog_confirm_logout,
                message = getString(R.string.text_message_dialog_confirm_logout),
                onClick = {
                    FirebaseHelper.getAuth().signOut()
                    findNavController().navigate(R.id.action_homeFragment_to_authentication)
                }
            )
        }
    }

    private fun initTabs() {
        val pageAdapter = ViewPageAdapter(requireActivity())
        binding.viewPager.adapter = pageAdapter
        pageAdapter.addFragment(TodoFragment(), R.string.status_task_todo)
        pageAdapter.addFragment(DoingFragment(), R.string.status_task_doing)
        pageAdapter.addFragment(DoneFragment(), R.string.status_task_done)

        binding.viewPager.offscreenPageLimit = pageAdapter.itemCount

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = getString(pageAdapter.getTitle(position))
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }
}
