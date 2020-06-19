package com.example.metby_bussiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.business_partner_ext_activity.*

class BusinessPartnerExt : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.business_partner_ext_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbarPartnerEx)
        setSupportActionBar(toolbar)

        val CompAmt = resources.getStringArray(R.array.compensationamount_for_list)
        val spinnerComAmt = findViewById<Spinner>(R.id.spinnercompAmt)
        if (spinnerComAmt != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned, CompAmt)
            spinnerComAmt.adapter = adapter

            spinnerComAmt.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@BusinessPartnerExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@BusinessPartnerExt, getString(R.string.compensationamount) + " " + "" + CompAmt[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val LocationBP = resources.getStringArray(R.array.location_for_list)
        val spinnerlocationbusext = findViewById<Spinner>(R.id.spinneredlocBP)
        if (spinnerlocationbusext != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,LocationBP)
            spinnerlocationbusext.adapter = adapter

            spinnerlocationbusext.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@BusinessPartnerExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@BusinessPartnerExt, getString(R.string.location) + " " + "" + LocationBP[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val TimeBP = resources.getStringArray(R.array.timeline_for_list)
        val spinnertimeBP = findViewById<Spinner>(R.id.spinnerTimeBP)
        if (spinnerTimeBP != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,TimeBP)
            spinnertimeBP.adapter = adapter

            spinnertimeBP.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@BusinessPartnerExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@BusinessPartnerExt, getString(R.string.timeline) + " " + "" + TimeBP[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val EduBPE = resources.getStringArray(R.array.education_for_list)
        val spinnereduBPE = findViewById<Spinner>(R.id.spinneredu)
        if (spinnereduBPE != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,EduBPE)
            spinnereduBPE.adapter = adapter

            spinnereduBPE.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@BusinessPartnerExt,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@BusinessPartnerExt, getString(R.string.education) + " " + "" + EduBPE[position],Toast.LENGTH_LONG).show()
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