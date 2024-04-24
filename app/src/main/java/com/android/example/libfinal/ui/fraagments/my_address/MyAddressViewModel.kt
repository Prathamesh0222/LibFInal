package com.android.example.libfinal.ui.fraagments.my_address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

@HiltViewModel
class MyAddressViewModel @Inject constructor(
    private val firebaseUtil: FirebaseUtil,
) : BaseViewModel() {

    private var _addressList = MutableLiveData<Resource<List<Address>>>()
    val addressList: LiveData<Resource<List<Address>>> = _addressList

    init {
        getMyAddresses()
    }

    /**
     * Get user addresses
     */
    fun getMyAddresses() {
        firebaseUtil.getMyAddressesFromFireStore {
            _addressList.postValue(it)
        }
    }

    /**
     * Delete user address.
     */
    fun deleteAddress(id: String) {
        firebaseUtil.deleteAddressOnFireStoreDb(id) {
            _status.postValue(it)
        }
    }
}