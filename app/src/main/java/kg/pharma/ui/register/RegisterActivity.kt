package kg.pharma.ui.register

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kg.pharma.App
import kg.pharma.R
import kg.pharma.databinding.ActivityRegisterBinding
import kg.pharma.injection.ViewModelFactory
import kg.pharma.ui.register.confirm_code.ConfirmCodeActivity
import kg.pharma.utils.extension.cursorToEnd

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.activity = this

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.phone.cursorToEnd()
        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(RegisterViewModel::class.java)

        binding.viewModel = viewModel

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==456){
            val intent = Intent(App.activity, ConfirmCodeActivity::class.java)
            intent.putExtra("phone", binding.phone.text.toString())
            intent.putExtra("password", binding.password.text.toString())
            intent.putExtra("isRegister", 0)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        App.activity = this
    }

}
