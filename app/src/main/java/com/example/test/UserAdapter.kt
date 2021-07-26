package com.example.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemUserBinding
import com.example.test.model.UserDataResponseItem
import javax.inject.Inject

class UserAdapter @Inject constructor() :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userList: List<UserDataResponseItem> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    fun setData(userList: List<UserDataResponseItem>) {
        this.userList = userList
    }


    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val user = userList[position]
            binding.tvUser.apply {
                text = user.name
            }
        }
    }
}