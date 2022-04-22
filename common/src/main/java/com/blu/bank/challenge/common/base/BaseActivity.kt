package com.blu.bank.challenge.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
 import com.blu.bank.challenge.common.R


abstract class BaseActivity : AppCompatActivity() {

    abstract val rootView: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_layout)

        val mainLayout = findViewById<ViewGroup>(R.id.layout_main)
        val rootView = LayoutInflater.from(this).inflate(rootView, mainLayout, false)
        mainLayout.addView(rootView)

    }



}
