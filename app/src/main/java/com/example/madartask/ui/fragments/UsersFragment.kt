package com.example.madartask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madartask.databinding.FragmentUsersBinding
import com.example.madartask.ui.adapter.UserAdapter
import com.example.madartask.ui.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeUsers()
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(emptyList()) // Initialize with empty list
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }
    }

    private fun observeUsers() {
        userViewModel.allUsers.observe(viewLifecycleOwner) { users ->
            userAdapter = UserAdapter(users)
            binding.recyclerView.adapter = userAdapter
        }
    }
}
