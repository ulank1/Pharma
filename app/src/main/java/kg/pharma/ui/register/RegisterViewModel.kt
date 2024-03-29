package kg.pharma.ui.register

import android.content.Intent
import android.util.Log
import android.widget.EditText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kg.pharma.App
import kg.pharma.base.BaseViewModel
import kg.pharma.network.PostApi
import kg.pharma.ui.register.confirm_code.ConfirmCodeActivity
import javax.inject.Inject

class RegisterViewModel : BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi


    private var subscription: CompositeDisposable = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        subscription = CompositeDisposable()
    }

    private fun onRetrievePostListError() {

    }

    fun onClickRegister(phone: EditText, password: EditText, repeatPassword: EditText) {
        val intent = Intent(App.activity, ConfirmCodeActivity::class.java)
        intent.putExtra("phone", phone.text.toString())
        intent.putExtra("password", password.text.toString())
        intent.putExtra("isRegister", 0)
        App.activity.startActivity(intent)
        App.activity.finish()
    }

    /*fun onClickRegister(phone: EditText, password: EditText, repeatPassword: EditText) {
        var isValidate = true

        if (!phone.validate({ s -> s.length>10}, "Поле не может быть пустым.")) isValidate = false
        if (!password.validate({ s -> s.isNotEmpty() }, "Поле не может быть пустым.")) isValidate = false
        if (!repeatPassword.validate({ s -> s == password.text.toString() }, "Пароли не совпадают.")) isValidate = false


        Log.e("DDDD", isValidate.toString())

        if (isValidate) {

            subscription.add(
                postApi.isUserExist(phone.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { showProgress() }
                    .doOnTerminate { hideProgress() }
                    .subscribe(
                        { result ->

                            if (result.isSuccessful) {
                                Log.e("Result",result.body().toString())
                                if (result.body()!!.is_profile_filled!=null) {

                                    App.activity?.toast("Вы уже зарестрированы")
                                    App.activity?.startActivity(
                                        Intent(
                                            App.activity!!,
                                            LoginActivity::class.java
                                        )
                                    )
                                    App.activity?.finish()
                                } else {
                                    if (result.body()!!.success!!) {
                                       App.activity?.startActivityForResult(Intent(App.activity,kg.docplus.qbwrtc.activities.LoginActivity::class.java).putExtra("login","dp${phone.text.toString().substring(1)}"),456)
                                    } else {
                                        App.activity?.toast(result.body()?.message.toString())
                                    }
                                }

                            } else {
                                var error = result.errorBody()!!.string()
                                Log.e("Error", error)

                                if (error.contains("Невозможно войти с", true)) {
                                    Log.e("TAF", "DDD")
                                    App.activity!!.toast("Невозможно войти с предоставленными учетными данными")
                                }
                            }
                        },
                        {
                            Log.e("DDD", it.toString())
                            onRetrievePostListError()
                        }
                    )
            )
        }
    }
*/

}