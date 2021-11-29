package com.lolblach333.onlineshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import android.content.Intent
import com.lolblach333.onlineshop.R

class AuthCheckActivity : AppCompatActivity(R.layout.activity_auth_check) {

    private val auth: FirebaseAuth by lazy { Firebase.auth }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkUserSignedIn()
    }

    private fun checkUserSignedIn() {
        lifecycleScope.launchWhenResumed {
            delay(1_500L)

            (auth.currentUser?.let { MainActivity::class.java } ?: LoginActivity::class.java)
                .let(::startNewRootActivity)
        }
    }

    private fun startNewRootActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
    }
}
