package com.android.example.libfinal.ui.activities.forgot_password

import android.os.Bundle

@AndroidEntryPoint
class ForgotPasswordActivity : BaseActivity() {

    lateinit var mBinding: ActivityForgotPasswordBinding

    private val mViewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)
        mBinding.viewModel = mViewModel

        mBinding.ivBackArrow.setOnClickListener { onBackPressed() }

        observeLiveEvents()
    }

    /**
     * Observe changes in the LiveData.
     */
    private fun observeLiveEvents() {
        mViewModel.status.observe(this) { status ->
            when (status) {
                is Resource.Success -> {
                    showSnackBar(mBinding.root, status.data ?: "Success", false)
                    hideProgressbar()
                    onBackPressed()
                }
                is Resource.Error -> {
                    showSnackBar(mBinding.root, status.message ?: "An unknown error occurred.", true)
                    hideProgressbar()
                }
                is Resource.Loading -> {
                    showProgressbar()
                }
            }
        }
    }
}