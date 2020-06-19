package com.example.metby_bussiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar

class FindProjectPartnerExt : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_project_partner_ex_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbarpartnerex)
        setSupportActionBar(toolbar)

        val projectextutton = findViewById<Button>(R.id.findprojectextnext)
        projectextutton.setOnClickListener {
            val i = Intent(this, BusinessPartner::class.java)
            startActivity(i)
        }

        val Compensation_amount = resources.getStringArray(R.array.compensationamount_for_list)

        val spinnercompensation = findViewById<Spinner>(R.id.spinnercompen)
        if (spinnercompensation != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,Compensation_amount)
            spinnercompensation.adapter = adapter

            spinnercompensation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindProjectPartnerExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindProjectPartnerExt, getString(R.string.compensationamount) + " " + "" + Compensation_amount[position],Toast.LENGTH_LONG).show()
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