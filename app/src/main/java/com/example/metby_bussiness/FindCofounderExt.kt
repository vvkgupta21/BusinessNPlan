package com.example.metby_bussiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar

class FindCofounderExt : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_co_founder_ext_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbarBusComEx)
        setSupportActionBar(toolbar)

        val location = resources.getStringArray(R.array.location_for_list)
        val Time = resources.getStringArray(R.array.timeline_for_list)
        val Education = resources.getStringArray(R.array.education_for_list)
        val ComAmtCoF = resources.getStringArray(R.array.compensationamount_for_list)


        val cofounderext = findViewById<Button>(R.id.CoFounderNextExt)
        cofounderext.setOnClickListener {
            val i = Intent(this, FindProjectPartner::class.java)
            startActivity(i)
        }

        val spinnerlocation = findViewById<Spinner>(R.id.spinnerloc)
        if (spinnerlocation != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,location)
            spinnerlocation.adapter = adapter

            spinnerlocation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindCofounderExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindCofounderExt, getString(R.string.location) + " " + "" + location[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val spinnertime = findViewById<Spinner>(R.id.spinnerTime)
        if (spinnertime != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,Time)
            spinnertime.adapter = adapter

            spinnertime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindCofounderExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindCofounderExt, getString(R.string.timeline) + " " + "" + Time[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val spinnereducation = findViewById<Spinner>(R.id.spinneredu)
        if (spinnereducation != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,Education)
            spinnereducation.adapter = adapter

            spinnereducation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindCofounderExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindCofounderExt, getString(R.string.education) + " " + "" + Education[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val spinnerCommAmTCof = findViewById<Spinner>(R.id.spinnercompAmt)
        if (spinnerCommAmTCof != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,ComAmtCoF)
            spinnerCommAmTCof.adapter = adapter

            spinnerCommAmTCof.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindCofounderExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindCofounderExt, getString(R.string.compensationamount) + " " + "" + ComAmtCoF[position],Toast.LENGTH_LONG).show()
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
