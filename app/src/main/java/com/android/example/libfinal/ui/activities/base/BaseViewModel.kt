package com.android.example.libfinal.ui.activities.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    var _status = MutableLiveData<Resource<String>>()
    val status: LiveData<Resource<String>> = _status
}