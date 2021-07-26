package com.example.test

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding
import com.example.test.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: UserAdapter

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.userResponse.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.pbLoading.visibility = View.GONE
                    adapter = UserAdapter()
                    adapter.setData(it.data!!)
                    binding.rvUser.adapter = adapter
                }
                Status.LOADING -> {
                    binding.pbLoading.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.pbLoading.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.getAllArticle()
    }
}