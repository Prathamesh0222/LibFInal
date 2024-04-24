package com.android.example.libfinal.ui.activities.forgot_password

import android.util.Patterns
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val firebaseUtil: FirebaseUtil
) : BaseViewModel() {

    var observableEmail = ObservableString()

    /**
     * Method to validate user inputs for Login screen.
     */
    private fun validateEmail(): Boolean {
        return when {
            observableEmail.trimmed.isBlank() -> {
                _status.postValue(Resource.Error("Please Enter Email"))
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(observableEmail.trimmed).matches() -> {
                _status.postValue(Resource.Error("Please Enter Valid Email Id"))
                false
            }
            else -> true
        }
    }

    /**
     * Method responsible for sending an email to reset the user password.
     */
    fun onForgotPasswordTextClick() {
        if (validateEmail()) {
            _status.postValue(Resource.Loading())
            firebaseUtil.firebaseAuth.sendPasswordResetEmail(
                observableEmail.trimmed,
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _status.postValue(Resource.Success("Mail sent.Check your inbox."))
                } else {
                    _status.postValue(Resource.Error(task.exception?.message.toString()))
                }
            }
        }
    }
}