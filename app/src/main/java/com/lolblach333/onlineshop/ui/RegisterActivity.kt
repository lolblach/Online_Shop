package com.lolblach333.onlineshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lolblach333.onlineshop.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private val auth: FirebaseAuth by lazy { Firebase.auth }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initUI()
    }

    private fun initUI() {
        llLogin.setOnClickListener {
            startNewRootActivity(LoginActivity::class.java)
        }

        btn_register.setOnClickListener {
            val email = et_register_email.text.toString().trim()
            val password = et_register_password.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "createUserWithEmail:success")

                            startNewRootActivity(MainActivity::class.java)
                        } else {
                            Log.e(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    private fun startNewRootActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
    }

    companion object {
        private val TAG = RegisterActivity::class.simpleName
    }
}
