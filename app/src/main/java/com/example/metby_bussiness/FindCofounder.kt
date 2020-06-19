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
import kotlinx.android.synthetic.main.find_co_founder_activity.*

class FindCofounder : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_co_founder_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbarBusCom)
        setSupportActionBar(toolbar)

        val Funding = resources.getStringArray(R.array.funding_list_item)
        val Phase = resources.getStringArray(R.array.phase_for_list)

        val findcofounderbutton = findViewById<Button>(R.id.FindCofounderNext)
        findcofounderbutton.setOnClickListener {
            val i = Intent(this, FindCofounderExt::class.java)
            startActivity(i)
        }

        val spinnerphase = findViewById<Spinner>(R.id.spinnerphase)
        if (spinnerphase != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,Phase)
            spinnerphase.adapter = adapter

            spinnerphase.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindCofounder,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindCofounder, getString(R.string.phase) + " " + "" + Phase[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val spinnerfund = findViewById<Spinner>(R.id.spinnercompen)
        if (spinnerfund != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,Funding)
            spinnerfund.adapter = adapter

            spinnerfund.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindCofounder,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindCofounder, getString(R.string.funding) + " " + "" + Funding[position],Toast.LENGTH_LONG).show()
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
    fun showSoftKeyboard(view:View) {
        if (view.requestFocus())
        {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
    fun hideSoftKeyboard(view:View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY)
    }
}
