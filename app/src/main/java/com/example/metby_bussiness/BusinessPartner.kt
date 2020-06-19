package com.example.metby_bussiness

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.create_business_plan_activity.*

class BusinessPartner : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.business_partner_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbarBusPartner)
        setSupportActionBar(toolbar)

        val FundingforBus = resources.getStringArray(R.array.funding_list_item)
        val PhaseforBus = resources.getStringArray(R.array.phase_for_list)


        val nextbutton = findViewById<Button>(R.id.nextbutton)
        nextbutton.setOnClickListener {
            val i = Intent(this, BusinessPartnerExt::class.java)
            startActivity(i)
        }

        val spinnerphasebus = findViewById<Spinner>(R.id.spinnerphasebus)
        if (spinnerphasebus != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,PhaseforBus)
            spinnerphasebus.adapter = adapter

            spinnerphasebus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@BusinessPartner,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@BusinessPartner, getString(R.string.phase) + " " + "" + PhaseforBus[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val spinnerfundbus = findViewById<Spinner>(R.id.spinnerfundbus)
        if (spinnerfundbus != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,FundingforBus)
            spinnerfundbus.adapter = adapter

            spinnerfundbus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@BusinessPartner,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@BusinessPartner, getString(R.string.phase) + " " + "" + FundingforBus[position],Toast.LENGTH_LONG).show()
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
            Toast.makeText(this, "Cancle is clicked", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}