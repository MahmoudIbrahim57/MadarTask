package com.example.madartask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madartask.R
import com.example.madartask.data.User
import com.example.madartask.databinding.FragmentAddNewUserBinding
import com.example.madartask.ui.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class AddNewUserFragment : Fragment() {
    private lateinit var binding: FragmentAddNewUserBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNewUserBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // fill spinner
        val genderOptions = listOf("Gender", "Male", "Female")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spGender.adapter = adapter
        // Click on button
        binding.btAddNewUser.setOnClickListener {
            if (validateData()) {
                val user = User(
                    name = binding.etName.text.toString(),
                    age = binding.etAge.text.toString().toInt(),
                    jobTitle = binding.etJob.text.toString(),
                    gender =binding.spGender.selectedItem.toString()
                )
                userViewModel.addUser(user)
                findNavController().navigate(R.id.action_addNewUserFragment_to_usersFragment)
            }else
                Toast.makeText(context, "Please fill all data!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateData(): Boolean {
        return  binding.etName.text.toString()!=""
                &&binding.etAge.text.toString()!=""
                &&binding.etJob.text.toString()!=""
                &&binding.spGender.selectedItem.toString()!="Gender"
    }
}
