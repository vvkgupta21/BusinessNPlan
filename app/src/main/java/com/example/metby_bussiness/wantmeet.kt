package com.example.metby_bussiness

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class wantmeet : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wantmeet_activity)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

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