package com.blu.bank.challenge.common.extentions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat


fun EditText.trimText() = this.text.toString().trim()


fun TextView.trimText() = this.text.toString().trim()


fun EditText.setOnTextChangeListener(onChange: (text: String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {


        override fun afterTextChanged(s: Editable?) {
            onChange(trimText())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })

}


fun String.getCardNumberInRows():String{
    val rowCounts = this.length/4
    return (0 until rowCounts).map { substring(it * 4, (it + 1) * 4) }.joinToString("\n \n")
}