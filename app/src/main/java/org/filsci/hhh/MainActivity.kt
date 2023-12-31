package org.filsci.hhh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    //结果
    private var currentInput = StringBuilder()
    //输入内容
    private var currentOperator: String? = null
    //运算符
    private var operand1: Double? = null
    //第一个数
    private var operand2 = currentInput.toString().toDouble()
    //第二个数
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        currentInput.append(button.text)
        updateResult()
    }

    fun onOperatorClick(view: View) {
        if (currentInput.isNotEmpty()) {
            operand1 = currentInput.toString().toDouble()
            currentInput.clear()
            currentOperator = (view as Button).text.toString()
        }
    }

    fun onEqualClick(view: View) {
        if (operand1 != null && currentInput.isNotEmpty() && currentOperator != null) {
            if (currentOperator == "C") {
                onClearClick(view)
            } else if (currentOperator == "CE") {
                onClearClick(view)
            } else {
                currentInput.clear()

                try {
                    when (currentOperator) {
                        "+" -> {
                            currentInput.append(operand1!! + operand2)
                        }

                        "-" -> {
                            currentInput.append(operand1!! - operand2)
                        }

                        "*" -> {
                            currentInput.append(operand1!! * operand2)
                        }

                        "/" -> {
                            currentInput.append(operand1!! / operand2)
                        }

                        else -> {
                            throw IllegalArgumentException("error")
                        }
                    }
                }catch(e: IllegalArgumentException) {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun onClearClick(view: View) {
        currentInput.clear()
        operand1 = null
        currentOperator = null
    }
    private fun updateResult() {
        resultTextView.text = currentInput.toString()
    }
}
/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}*/
