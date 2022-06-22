package com.rehan.materialdesignapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.databinding.DataBindingUtil
import com.rehan.materialdesignapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //DataBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnEmp.setOnClickListener(View.OnClickListener {
            validation()
        })
    }

    private fun validation() {
        val empName = binding.etEmpName.editableText.toString()
        val empId = binding.etEmpId.editableText.toString()
        val empEmailId = binding.etEmpEmailId.editableText.toString()
        val empPhone = binding.etEmpPhone.editableText.toString()
        val empCompany = binding.etEmpCompany.editableText.toString()
        val empDesignation = binding.etEmpDesignation.editableText.toString()

        if (empName.isEmpty()){
            binding.etEmpName.error = "Employee Name is required"
            binding.etEmpName.requestFocus()
        }
        else if(empId.isEmpty()){
            binding.etEmpId.error = "Employee ID is required"
            binding.etEmpId.requestFocus()
        }
        else if(empEmailId.isEmpty()){
            binding.etEmpEmailId.error = "Email ID is required"
            binding.etEmpEmailId.requestFocus()
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(empEmailId).matches()){
            binding.etEmpEmailId.error = "Invalid Email ID"
            binding.etEmpEmailId.requestFocus()
        }
        else if(empPhone.isEmpty()){
            binding.etEmpPhone.error ="Phone Number is required"
            binding.etEmpPhone.requestFocus()
        }
        else if(empPhone.length<10 || empPhone.length>10){
            binding.etEmpPhone.error = "Invalid Phone Number"
            binding.etEmpPhone.requestFocus()
        }
        else if(empCompany.isEmpty()){
            binding.etEmpCompany.error = "Company Name is required"
            binding.etEmpCompany.requestFocus()
        }
        else if(empDesignation.isEmpty()){
            binding.etEmpDesignation.error = "Designation is required"
            binding.etEmpDesignation.requestFocus()
        }
        else{
            val intent = Intent(this, EmployeeInfo::class.java)
            //passing edittext data from this source activity to destination activity
            intent.putExtra("empName", empName)
            intent.putExtra("empId", empId)
            intent.putExtra("empEmailId", empEmailId)
            intent.putExtra("empPhone", empPhone)
            intent.putExtra("empCompany", empCompany)
            intent.putExtra("empDesignation", empDesignation)
            startActivity(intent)
        }
    }
}