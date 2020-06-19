package com.example.metby_bussiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar

class FindProjectPartner : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_project_partner_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbarpartner)
        setSupportActionBar(toolbar)

        val TypesOfProject = resources.getStringArray(R.array.typesofproject_for_list)

        val spinnerproject = findViewById<Spinner>(R.id.spinnercompen)
        if (spinnerproject != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_aligned,TypesOfProject)
            spinnerproject.adapter = adapter

            spinnerproject.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@FindProjectPartner,"Nothing Is selected", Toast.LENGTH_LONG).show()
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@FindProjectPartner, getString(R.string.typesofproject) + " " + "" + TypesOfProject[position],Toast.LENGTH_LONG).show()
                }
            }
        }

        val ppplannext = findViewById<Button>(R.id.findppNextButton)

        ppplannext.setOnClickListener {
            val i = Intent(this, FindProjectPartnerExt::class.java)
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
}