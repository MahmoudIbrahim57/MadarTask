package com.example.madartask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madartask.R
import com.example.madartask.data.User

/**
 *
 * Created by: Mahmoud Ibrahim on 11/15/2024
 * Email: mahmoudibrahiem57@gmail.com
 *
 **/
class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
        private val jobTitleTextView: TextView = itemView.findViewById(R.id.jobTitleTextView)
        private val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)

        fun bind(user: User) {
            nameTextView.text = user.name
            ageTextView.text = user.age.toString()
            jobTitleTextView.text = user.jobTitle
            genderTextView.text = user.gender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}
