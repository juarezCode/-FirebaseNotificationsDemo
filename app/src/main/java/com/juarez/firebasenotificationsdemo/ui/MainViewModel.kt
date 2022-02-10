package com.juarez.firebasenotificationsdemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juarez.firebasenotificationsdemo.data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private var _age = MutableStateFlow<String?>("")
    val age: StateFlow<String?> = _age

    fun saveAge(key: String, value: String) {
        viewModelScope.launch { repository.saveAge(key, value) }
    }

    fun getAge(key: String) {
        viewModelScope.launch { _age.value = repository.getAge(key) }
    }
}