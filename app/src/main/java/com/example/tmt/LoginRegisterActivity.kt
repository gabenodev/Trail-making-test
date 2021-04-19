package com.example.tmt

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.util.*

open class LoginRegisterActivity : AppCompatActivity() {

    private val TAG = "LoginRegisterActivity"
    var AuthUI_REQUEST_CODE = 10001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        if (FirebaseAuth.getInstance().currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }


        val userSharedPreferences = getSharedPreferences("UserInfo",0)
        val editor = userSharedPreferences.edit()

        fun saveUserInfo() {

            if (FirebaseAuth.getInstance().currentUser.email == null) {
                val editor: SharedPreferences.Editor = userSharedPreferences.edit()
                editor.putString("UserInfo", "This is a default name")
                editor.apply()
            } else {

                editor.apply {
                    putString("UserInfo", FirebaseAuth.getInstance().currentUser.email.toString())
                }.apply()
            }
        }

        val provider: List<AuthUI.IdpConfig> = Arrays.asList(
            AuthUI.IdpConfig.EmailBuilder().build()
        )


        val intentUI = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(provider)
            .setTosAndPrivacyPolicyUrls(
                "https://gabenogamedev.blogspot.com/2020/09/privacy-notice-we-work-with-advertisers.html",
                "https://gabenogamedev.blogspot.com/2020/09/privacy-notice-we-work-with-advertisers.html"
            )
            .setLogo(R.drawable.logo)
            .setAlwaysShowSignInMethodScreen(true)
            .build()



        startActivityForResult(intentUI, AuthUI_REQUEST_CODE);

    }


        override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == AuthUI_REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    // We have signed in the user or we have a new user
                    val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
                    if (user != null) {
                        Log.d("onActivityResult:" , "This is the email " + user.email)

                    }
                    if (user?.metadata?.creationTimestamp   == user?.metadata?.lastSignInTimestamp ) {
                        Toast.makeText(this, "Welcome new User", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Welcome back again", Toast.LENGTH_SHORT).show()
                    }
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Signing in failed
                    val response: IdpResponse? = IdpResponse.fromResultIntent(data)
                    if (response == null) {
                        Log.d(TAG, "onActivityResult: the user has canceled the sign in request")
                    } else {
                        Log.e(TAG, "onActivityResult: ", response.getError())
                    }
                }
            }
        }


}


