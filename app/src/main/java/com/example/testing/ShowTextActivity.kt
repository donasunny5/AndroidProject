package com.example.testing

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.common.base.Strings

class ShowTextActivity : Activity() {

    companion object {
        const val KEY_EXTRA_MESSAGE =
            "com.example.android.testing.espresso.basicsample.MESSAGE"

        fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)
        val intent = intent
        val message = Strings.nullToEmpty(intent.getStringExtra(KEY_EXTRA_MESSAGE))
        findViewById<TextView>(R.id.show_text_view).text = message
    }
}
