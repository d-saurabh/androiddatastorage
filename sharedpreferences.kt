package com.example.storagesinandroid

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_NAME = "myPrefs"
    var myPrefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get data back
        var databack:SharedPreferences = getSharedPreferences(PREFS_NAME, 0)
        if (databack.contains("message")){
            var message = databack.getString("message","")
            textView2.text = message
        }

        // adding to preferences
        button.setOnClickListener {
            myPrefs = getSharedPreferences(PREFS_NAME, 0)
            var editor: SharedPreferences.Editor = (myPrefs as SharedPreferences)!!.edit()

            var message = editText.text.toString()
            if (!TextUtils.isEmpty(message)) {
                // not empty edit text
                editor.putString("message", message)
                editor.commit()
            } else {
                Toast.makeText(this, "Please enter something", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
