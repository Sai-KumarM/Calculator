package com.example.calculation

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        val options = arrayOf("sum", "subtract", "division", "multiply")

        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )

        button.setOnClickListener{ view ->
            val x: Int = edtxt1.text.toString().toInt()
            val y: Int = edtxt2.text.toString().toInt()
            val operation = spinnerVal.selectedItem.toString()

            val result = when (operation) {
                "sum" -> sum(x, y)
                "multiply" -> multiply(x, y)
                "subtract" -> subtract(x, y)
                "division" -> division(x, y)
                else -> throw IllegalArgumentException("Unsupported operation")
            }

            resultTV.text = result.toString()
        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // Nothing to change here since flag is not needed anymore
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Nothing to change here since flag is not needed anymore
            }
        }
    }

    // Moved these functions inside MainActivity for simplicity
    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun multiply(a: Int, b: Int): Int {
        return a * b
    }
    private fun subtract(a: Int, b: Int): Int{
        return a - b
    }
    private fun division(a: Int, b: Int): Int{
        return a / b
    }
}
