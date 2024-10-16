package com.practicum.androidhomeworktest

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.practicum.androidhomeworktest.databinding.ActivityMyNotesBinding

class MyNotesActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMyNotesBinding

    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMyNotesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(bindingClass.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val message = intent.getStringExtra("EXTRA_KEY_TEXT")
        bindingClass.tvWelcomeText.text = message


        val listView = findViewById<ListView>(R.id.listView)
        val userData: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button_add)


        val notes: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = listView.getItemAtPosition(i).toString()
            adapter.remove(text)

            Toast.makeText(this, "Note: $text deleted", Toast.LENGTH_LONG).show()
        }

        button.setOnClickListener {
            var text = userData.text.toString().trim()
            if (text != "")
                adapter.insert(text, 0)
        }

    }
}