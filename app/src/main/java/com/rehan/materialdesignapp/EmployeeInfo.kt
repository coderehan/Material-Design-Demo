package com.rehan.materialdesignapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rehan.materialdesignapp.databinding.ActivityEmployeeInfoBinding

class EmployeeInfo : AppCompatActivity() {
    //DataBinding
    private lateinit var binding: ActivityEmployeeInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_employee_info)

        //getting edittext data from source activity and displaying in this destination activity
        val empName = intent.getStringExtra("empName")
        val empId = intent.getStringExtra("empId")
        val empEmailId = intent.getStringExtra("empEmailId")
        val empPhone = intent.getStringExtra("empPhone")
        val empCompany = intent.getStringExtra("empCompany")
        val empDesignation = intent.getStringExtra("empDesignation")

        //setting text in textview
        binding.tvEmpName.text = empName
        binding.tvEmpId.text = empId
        binding.tvEmpEmailId.text = empEmailId
        binding.tvEmpPhone.text = empPhone
        binding.tvEmpCompany.text = empCompany
        binding.tvEmpDesignation.text = empDesignation
    }
}