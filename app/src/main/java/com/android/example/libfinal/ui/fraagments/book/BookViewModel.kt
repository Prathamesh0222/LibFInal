package com.android.example.libfinal.ui.fraagments.book

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val firebaseUtil: FirebaseUtil,
    @ApplicationContext private val application: Context
) : BaseViewModel() {

    private var _response = MutableLiveData<Resource<Any>>()
    val response: LiveData<Resource<Any>> = _response

    /**
     * Gets the products from the Firestore db.
     */
    fun getProducts() {
        firebaseUtil.getProductsFromFireStore {
            _response.postValue(it)
        }
    }

    /**
     * Delete the specific product on Firestore,
     */
    fun deleteProduct(productId: String) {
        firebaseUtil.deleteProduct(productId) {
            _status.postValue(it)
        }
    }
}