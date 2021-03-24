package com.erikaosgue.sharedpreferencesapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.erikaosgue.sharedpreferencesapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // PREFS_NAME: the name of the file
    private val PREFS_NAME = "miPrefs"
    // Declare a variable of type SharePreferences as null "Global"
    var mySharedPrefObject: SharedPreferences? =null

    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        saveButtonId.setOnClickListener {

            // Instantiate an sharedPreference object Passing:
            // * the name of the file and
            // * mode: Context.MODE_PRIVATE or Number 0
            // mode indicate if the file is private or public
//            mySharedPrefObject = getSharedPreferences(PREFS_NAME, 0)

            //
            val editor: SharedPreferences.Editor? = getSharedPreferences(PREFS_NAME, 0).edit()

            if (!TextUtils.isEmpty(enterSomethingId.text.toString())) {
                val message = enterSomethingId.text.toString()
                editor?.putString("message", message)?.apply()
//                editor?.apply()

            } else {
                Toast.makeText(this, "Please enter Something", Toast.LENGTH_SHORT).show()
            }
        }

        //Get data Back from the Preferences file
        val dataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)

        if (dataBack.contains("message")) {
            val myMessage = dataBack.getString("message", "Data Not found")
            resultTextid.text = myMessage
        }

    }
}










