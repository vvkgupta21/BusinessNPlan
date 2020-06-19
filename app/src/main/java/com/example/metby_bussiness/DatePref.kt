package com.example.metby_bussiness

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DatePref : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date_pref_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val nextimagetwo = findViewById<ImageView>(R.id.nextimagetwo)
        nextimagetwo.setOnClickListener {
            val i = Intent(this, wantmeet::class.java)
            startActivity(i)
        }

        val Education = resources.getStringArray(R.array.education_for_list)
        val Relationship = resources.getStringArray(R.array.relation_for_list)


        val spinnerEdu = findViewById<Spinner>(R.id.spinnerPrefEdu)
        if (spinnerEdu != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,Education)
            spinnerEdu.adapter = adapter

            spinnerEdu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@DatePref,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@DatePref, getString(R.string.education) + " " + "" + Education[position],
                        Toast.LENGTH_LONG).show()
                }
            }
        }

        val spinnerRel = findViewById<Spinner>(R.id.spinnerPrefRel)
        if (spinnerRel != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,Relationship)
            spinnerRel.adapter = adapter

            spinnerRel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@DatePref,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@DatePref, getString(R.string.relationship) + " " + "" + Relationship[position],
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_crate_plan, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.cancel) {
            Toast.makeText(this, "adduser is Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}