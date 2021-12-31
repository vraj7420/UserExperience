package com.example.assignmentUserExprieance

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var chbValue = ""
    private var rbGenderValue = ""
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private var cal: Calendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setListener()
    }

    private fun init() {
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
                tetFullName.error =getString(R.string.error_full_name)
                tetFullName.requestFocus()
            } else if (tetPhoneNumber.text.toString().trim().isEmpty()) {
                tetPhoneNumber.error =getString(R.string.error_phone_number_is_empty)
                tetPhoneNumber.requestFocus()
            } else if (tetPhoneNumber.text.toString().length != 10) {
                tetPhoneNumber.error =getString(R.string.error_phone_number_valid)
                tetPhoneNumber.requestFocus()

            } else if (tetEmailAddress.text.toString().trim().isEmpty()) {
                tetEmailAddress.error = getString(R.string.error_email_is_empty)
                tetEmailAddress.requestFocus()
            } else if (!tetEmailAddress.text.toString().trim().matches(emailPattern.toRegex())) {
                tetEmailAddress.error =getString(R.string.error_email_valid)
                tetEmailAddress.requestFocus()
            } else if (tetAddress.text.toString().trim().isEmpty()) {
                tetAddress.error = getString(R.string.error_address)
                tetAddress.requestFocus()
            } else if (tetBirthDate.text.toString().trim().isEmpty()) {
                tetBirthDate.error = getString(R.string.error_birth_is_empty)
                tetBirthDate.requestFocus()
            } else {
                setSelectedValues()
            }
        }
        skbPercentageSscHsc.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val seekbarData =getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                tvPercentageSscHsc.text = seekbarData

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val seekbarData = getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                tvPercentageSscHsc.text = seekbarData

            }

        })
        skbPercentageBComBCA.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val seekbarData = getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                tvPercentageBComBca.text = seekbarData
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val seekbarData = getString(R.string.percentage) + ":" + seekBar?.progress.toString() + "%"
                   tvPercentageBComBca.text = seekbarData

            }

        })


    }
    private fun setSelectedValues(){
        if (chbReading.isChecked) {
            chbValue += "\n" + chbReading.text.toString()
        }
        if (chbPlaying.isChecked) {
            chbValue += "\n" + chbPlaying.text.toString()
        }
        if (chbTraveling.isChecked) {
            chbValue += "\n" + chbTraveling.text.toString()
        }

        rbGenderValue = if (rbMale.isChecked) {
            getString(R.string.male)

        } else {
            getString(R.string.female)
        }
        var tempSelectedValue = getString(R.string.selected_values) + "\n" + ":" + spinnerCountry.selectedItem.toString() + chbValue + "\n" + rbGenderValue + "\n" + spinnerSscHsc.selectedItem.toString()
        tempSelectedValue += getString(R.string.percentage) + ":" + skbPercentageSscHsc.progress.toString() + "%"
        tempSelectedValue += "\n" + spinnerBComBCA.selectedItem.toString()
        tempSelectedValue += getString(R.string.percentage) + ":" + skbPercentageBComBCA.progress.toString() + "%"
        tvSelectedValues.text = tempSelectedValue
        rbGenderValue = ""
        chbValue = ""
    }
}

