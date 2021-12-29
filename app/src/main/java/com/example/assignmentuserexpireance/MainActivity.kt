package com.example.assignmentuserexpireance

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var spinnerCountry: Spinner
    private lateinit var spinnerSscHsc: Spinner
    private lateinit var spinnerBComBCA: Spinner
    private lateinit var tetFullName: TextInputEditText
    private lateinit var tetPhoneNumber: TextInputEditText
    private lateinit var tetEmailAddress: TextInputEditText
    private lateinit var tetAddress: TextInputEditText
    private lateinit var tetBirthDate: TextInputEditText
    private lateinit var skbPercentageOne: SeekBar
    private lateinit var skbPercentageTwo: SeekBar
    private lateinit var btnSignup: Button
    private lateinit var tvPercentageSscHsc: TextView
    private lateinit var tvPercentageBComBCA: TextView
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private var cal: Calendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setListener()
    }

    private fun init() {
        spinnerCountry = findViewById(R.id.spinnerCountry)
        spinnerSscHsc = findViewById(R.id.spinnerSscHsc)
        spinnerBComBCA = findViewById(R.id.spinnerBComBCA)
        val dataSpinnerCountry = resources.getStringArray(R.array.Country)
        val adapterSpinnerCountry =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dataSpinnerCountry)
        spinnerCountry.adapter = adapterSpinnerCountry
        spinnerCountry.setPromptId(R.string.hint_Spinner_Country)
        val dataOfSpinnerEducationOne = resources.getStringArray(R.array.educationOne)
        val adapterSpinnerEducationOne = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            dataOfSpinnerEducationOne
        )
        spinnerSscHsc.adapter = adapterSpinnerEducationOne
        spinnerSscHsc.setPromptId(R.string.hint_Spinner_SSC_HSC)
        val adapterSpinnerEducationTwo = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.educationTwo)
        )
        spinnerBComBCA.setPromptId(R.string.hint_Spinner_BCA_BCom)
        spinnerBComBCA.adapter = adapterSpinnerEducationTwo
        tetFullName = findViewById(R.id.tetFullName)
        tetEmailAddress = findViewById(R.id.tetEmailAddress)
        tetBirthDate = findViewById(R.id.tetBirthDate)
        tetAddress = findViewById(R.id.tetAddress)
        tetPhoneNumber = findViewById(R.id.tetPhoneNumber)
        tetBirthDate = findViewById(R.id.tetBirthDate)
        skbPercentageOne = findViewById(R.id.skbPercentageFirst)
        tvPercentageBComBCA = findViewById(R.id.tvPercentageBComBca)
        tvPercentageSscHsc = findViewById(R.id.tvPercentageSscHsc)
        skbPercentageTwo = findViewById(R.id.skbPercentageTwo)
        btnSignup = findViewById(R.id.btnSignup)

    }

    private fun setListener() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "MM/dd/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                val tempDate = sdf.format(cal.time).toString()
                tetBirthDate.setText(tempDate)
            }
        tetBirthDate.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        btnSignup.setOnClickListener {
            if (tetFullName.text.toString().trim().isEmpty()) {
                tetFullName.error = "Please Enter Valid Name"

            } else if (tetPhoneNumber.text.toString().trim()
                    .isEmpty() || tetPhoneNumber.text.toString().length != 10
            ) {
                tetPhoneNumber.error = "Please Enter Valid Phone Number "
            } else if (!tetEmailAddress.text.toString().trim().matches(emailPattern.toRegex())) {
                tetEmailAddress.error = "Please Enter Valid Email Address"
            } else if (tetAddress.text.toString().trim().isEmpty()) {
                tetAddress.error = "Please Enter Address"
            } else if (tetBirthDate.text.toString().trim().isEmpty()) {
                tetBirthDate.error = "Please Enter Birth Date"
            }
        }
        skbPercentageOne.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val seekbarData =
                    resources.getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                tvPercentageSscHsc.text = seekbarData

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val seekbarData =
                    resources.getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                tvPercentageSscHsc.text = seekbarData

            }

        })
        skbPercentageTwo.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val seekbarData =
                    resources.getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                tvPercentageBComBCA.text = seekbarData
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val seekbarData =
                    resources.getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                tvPercentageBComBCA.text = seekbarData

            }

        })


    }
}

