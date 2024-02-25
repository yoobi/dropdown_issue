package io.yoobi.template.dropdownissue

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.button)?.setOnClickListener {
            createDialog(it.context)
        }

    }
}

private fun createDialog(context: Context) {
    val view = LayoutInflater.from(context).inflate(R.layout.dialog, null, false)
    val etReason = view.findViewById<AutoCompleteTextView>(R.id.et_dropdown)
    val adapter = ArrayAdapter(context, R.layout.item_dialog, listOf("One", "Two", "Three", "Four", "Five"))
    etReason.setAdapter(adapter)
    MaterialAlertDialogBuilder(context)
        .setView(view)
        .setTitle("Dialog Title")
        .setNegativeButton(android.R.string.cancel) { dialog, _ -> dialog.dismiss() }
        .setPositiveButton("ok", null)
        .create()
        .apply {
            setCanceledOnTouchOutside(false)
            show()
        }
}