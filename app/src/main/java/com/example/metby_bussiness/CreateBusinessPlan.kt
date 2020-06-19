package com.example.metby_bussiness

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.core.view.children
import kotlinx.android.synthetic.main.create_business_plan_activity.*

class CreateBusinessPlan : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_business_plan_activity)

        val edittext = findViewById<EditText>(R.id.extractEditText)
        showSoftKeyboard(edittext)
        hideSoftKeyboard(edittext)

        val TypesOfCompanion = resources.getStringArray(R.array.CompanionList)
        val LookingFor = resources.getStringArray(R.array.looking_for_list)


        val spinnerLooking = findViewById<Spinner>(R.id.spinnerLook)
        if (spinnerLooking != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned, LookingFor)
            spinnerLooking.adapter = adapter

            spinnerLooking.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@CreateBusinessPlan,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@CreateBusinessPlan, getString(R.string.looking_for) + " " + "" + LookingFor[position],Toast.LENGTH_LONG).show()
                }
            }
        }
        val spinner = findViewById<Spinner>(R.id.CreateSpinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned ,TypesOfCompanion)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@CreateBusinessPlan,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@CreateBusinessPlan, getString(R.string.TypeOfCompanion) + " " + "" + TypesOfCompanion[position],Toast.LENGTH_LONG).show()
                }



            }
        }

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val createplannext = findViewById<ImageView>(R.id.createPlanNext)

        createplannext.setOnClickListener {
            val i = Intent(this, FindCofounder::class.java)
            startActivity(i)
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
