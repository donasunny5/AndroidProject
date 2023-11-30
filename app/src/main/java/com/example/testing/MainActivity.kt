package com.example.testing

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity(), View.OnClickListener {
    private lateinit var mTextView: TextView
    private lateinit var mEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.changeTextBt).setOnClickListener(this)
        findViewById<View>(R.id.activityChangeTextBtn).setOnClickListener(this)

        mTextView = findViewById(R.id.textToBeChanged)
        mEditText = findViewById(R.id.editTextUserInput)
    }

    override fun onClick(view: View) {
        val text = mEditText.text.toString()

        val changeTextBtId = R.id.changeTextBt
        val activityChangeTextBtnId = R.id.activityChangeTextBtn

        when (view.id) {
            changeTextBtId -> {
                mTextView.text = text
            }
            activityChangeTextBtnId -> {
                val intent = ShowTextActivity.newStartIntent(this, text)
                startActivity(intent)
            }
        }
    }
}
