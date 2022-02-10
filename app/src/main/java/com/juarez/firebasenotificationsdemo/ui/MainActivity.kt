package com.juarez.firebasenotificationsdemo.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.juarez.firebasenotificationsdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveData.setOnClickListener {
            viewModel.saveAge(
                binding.edtNewKey.text.toString(),
                binding.edtNewValue.text.toString()
            )
        }

        binding.btnReadData.setOnClickListener {
            viewModel.getAge(binding.edtKey.text.toString())
        }
        lifecycleScope.launchWhenStarted {
            viewModel.age.collect {
                binding.txtValue.text = it ?: "not found"
            }
        }
    }
}