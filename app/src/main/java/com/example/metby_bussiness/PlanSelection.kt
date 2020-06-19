package com.example.metby_bussiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity

class PlanSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plan_selection_activity)

        val BusinessBtn = findViewById<Button>(R.id.BusinessPlanButton)
        val datePlanBtn = findViewById<Button>(R.id.DatePlanButton)

        BusinessBtn.setOnClickListener {
            val i = Intent(this,CreateBusinessPlan::class.java)
            startActivity(i)
        }

        datePlanBtn.setOnClickListener {
            val i = Intent(this,FindDate::class.java)
            startActivity(i)
        }
    }

//    fun OnBusinessClick(){
//        val i = Intent(this,CreateBusinessPlan::class.java)
//        startActivity(i)
//    }
//
//    fun OnPlanClick(){
//        val i = Intent(this,FindDate::class.java)
//        startActivity(i)
//    }
}