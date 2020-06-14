package com.demo.myapplication1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val typeNum: String = "BTN_NUM"
    private val typeResult: String = "BTN_CAL"
    private val typeOprPub: String = "BTN_OPR_PUB"
    private val typeOprClear: String = "BTN_OPR_CLEAR"
    var dataList: MutableList<Double>? = ArrayList()
    var operationList: MutableList<Int>? = ArrayList()
    var numList: MutableList<String>? = ArrayList()
    private var lastOpr = ""
    private var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
        initGlobal(true)
    }

    /**
     * 通过numList来记录点击顺序和点击事件
     * */
    private fun onClickNum(num: String) {
        if (lastOpr == typeOprClear)
            initGlobal(true)
        lastOpr = typeNum
        numList?.add(num)
        refreshScreen(typeNum)
    }

    /**
     * 刷新显示器专用
     * typeNum时遍历数组 显示当前的数字
     * 等于时 计算完成
     * */
    private fun refreshScreen(type: String) {
        when (type) {
            typeNum -> {
                var num = ""
                numList?.forEach { it ->
                    num += it
                }
                screen.text = num
            }
            else -> {
                screen.text = content
                initGlobal(false)
            }
        }

    }

    /**
     * 点击了加减乘除等于
     * */
    private fun onOperation(type: Int) {
        if (lastOpr != typeOprPub) {
            when (type) {
                /**
                 * 加-1
                 * 减-2
                 * 乘-3
                 * 除-4
                 * 等于-5
                 * clear-6
                 * */
                5 -> {
                    screen.text = ""
                    manageOpr(type)
                }
                6 -> {
                    initGlobal(true)
                    return
                }
                else -> {
                    screen.text = ""
                    manageOpr(type)
                    operationList?.add(type)
                }
            }
            var num = "0"
            numList?.forEach { it ->
                num += it
            }
            dataList?.add(num.toDouble())
            numList?.clear()
            if (type == 5) {
                startCal()
            }
        } else {
            Toast.makeText(this, "非法操作", Toast.LENGTH_LONG).show()
        }
    }

    private fun startCal() {
        operationList?.forEachIndexed { index, opr ->
            var num_1 = dataList?.get(0)
            var num_2 = dataList?.get(1)
            num_1?.let {
                //do nothing
            } ?: kotlin.run {
                num_1 = "0".toDouble()
            }
            num_2?.let {
                //do nothing
            } ?: kotlin.run {
                num_2 = "0".toDouble()
            }
            when (opr) {
                1 -> {
                    content = (num_1!! + num_2!!).toString()
                }
                2 -> {
                    content = (num_1!! - num_2!!).toString()
                }
                3 -> {
                    content = (num_1!! * num_2!!).toString()
                }
                4 -> {
                    content = (num_1!! / num_2!!).toString()
                }
            }
            dataList?.removeAt(0)
            dataList?.removeAt(0)
            dataList?.add(0, content.toDouble())
        }
        refreshScreen(typeResult)
    }

    /**
     * 全局数组和显示初始化
     * */
    private fun initGlobal(status: Boolean) {
        content = ""
        lastOpr = ""
        dataList?.clear()
        numList?.clear()
        operationList?.clear()
        if (status)
            screen.text = ""
    }

    /**
     * 管理点击的具体是清屏还是其他操作
     * */
    private fun manageOpr(type: Int) {
        lastOpr = when (type) {
            6 -> {
                typeOprClear
            }
            else -> {
                typeOprPub
            }
        }
    }

    /**
     * 初始化listener
     * 集中处理
     * */
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
                onOperation(6)
            }
            R.id.btn_1 -> {
                onClickNum(getString(R.string.num_1))
            }
            R.id.btn_2 -> {
                onClickNum(getString(R.string.num_2))
            }
            R.id.btn_3 -> {
                onClickNum(getString(R.string.num_3))
            }
            R.id.btn_4 -> {
                onClickNum(getString(R.string.num_4))
            }
            R.id.btn_5 -> {
                onClickNum(getString(R.string.num_5))
            }
            R.id.btn_6 -> {
                onClickNum(getString(R.string.num_6))
            }
            R.id.btn_7 -> {
                onClickNum(getString(R.string.num_7))
            }
            R.id.btn_8 -> {
                onClickNum(getString(R.string.num_8))
            }
            R.id.btn_9 -> {
                onClickNum(getString(R.string.num_9))
            }
            R.id.opr_1 -> {
                onOperation(1)
            }
            R.id.opr_2 -> {
                onOperation(2)
            }
            R.id.opr_3 -> {
                onOperation(3)
            }
            R.id.opr_4 -> {
                onOperation(4)
            }
            R.id.opr_5 -> {
                onOperation(5)
            }
            else -> {
                onOperation(6)
            }
        }
    }
}
