package com.games.dragilus.aboutme

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.games.dragilus.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myname : Myname = Myname(name="Vinícius Oliveria")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        findViewById<Button>(R.id.done_btn).setOnClickListener { addNickname(it) }
        binding.doneBtn.setOnClickListener { addNickname(it) }
        binding.myName = myname
    }

    private fun addNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            myName?.nickname = binding.nicknameEdit.text.toString()

//            binding.nicknameText.text = binding.nicknameEdit.text
//        nicknameText.text = editText.text
            binding.nicknameEdit.visibility = View.GONE
//        editText.visibility = View.GONE
            binding.doneBtn.visibility = View.GONE
//        view.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
//        nicknameText.visibility = View.VISIBLE
            binding.invalidateAll()
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}
