package com.demo.myapplication1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.clear


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()

    }

    private fun initListener() {
        clear.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        opr_1.setOnClickListener(this)
        opr_2.setOnClickListener(this)
        opr_3.setOnClickListener(this)
        opr_4.setOnClickListener(this)
        opr_5.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.clear -> {
            }
            R.id.btn_1 -> {
            }
            R.id.btn_2 -> {
            }
            R.id.btn_3 -> {
            }
            R.id.btn_4 -> {
            }
            R.id.btn_5 -> {
            }
            R.id.btn_6 -> {
            }
            R.id.btn_7 -> {
            }
            R.id.btn_8 -> {
            }
            R.id.btn_9 -> {
            }
            R.id.opr_1 -> {
            }
            R.id.opr_2 -> {
            }
            R.id.opr_3 -> {
            }
            R.id.opr_4 -> {
            }
            R.id.opr_5 -> {
            }
            else -> {
            }
        }
    }
}
