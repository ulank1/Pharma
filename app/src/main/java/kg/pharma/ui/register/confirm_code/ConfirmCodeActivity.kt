package kg.pharma.ui.register.confirm_code

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kg.pharma.App
import kg.pharma.R
import kg.pharma.databinding.ActivityConfirmCodeBinding
import kg.pharma.injection.ViewModelFactory

class ConfirmCodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmCodeBinding
    private lateinit var viewModel: ConfirmCodeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.activity = this

        binding = DataBindingUtil.setContentView(this, R.layout.activity_confirm_code)

        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(ConfirmCodeViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.getSmsCode(this,intent.getStringExtra("phone"),intent.getStringExtra("password"),intent.getIntExtra("isRegister",0))
    }

    override fun onResume() {
        super.onResume()
        App.activity = this
    }

}
