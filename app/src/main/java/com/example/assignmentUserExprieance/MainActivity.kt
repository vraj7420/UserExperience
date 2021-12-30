package com.example.assignmentUserExprieance

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
    private lateinit var skbPercentageSscHsc: SeekBar
    private lateinit var chbReading:CheckBox
    private lateinit var chbPlaying:CheckBox
    private lateinit var chbTraveling:CheckBox
    private lateinit var rbMale:RadioButton
    private lateinit var rbFemale:RadioButton
    private lateinit var skbPercentageBComBCA: SeekBar
    private lateinit var btnSignup: Button
    private lateinit var tvSelectedValues:TextView
    private lateinit var tvPercentageSscHsc: TextView
    private lateinit var tvPercentageBComBCA: TextView
    private  var chbValue=""
    private  var rbGenderValue=""
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
        tvSelectedValues=findViewById(R.id.tvSelectedValues)
        rbMale=findViewById(R.id.rbMale)
        rbFemale=findViewById(R.id.rbFemale)
        chbReading=findViewById(R.id.chbReading)
        chbPlaying=findViewById(R.id.chbPlaying)
        chbTraveling=findViewById(R.id.chbTraveling)
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
        skbPercentageSscHsc = findViewById(R.id.skbPercentageSscHsc)
        tvPercentageBComBCA = findViewById(R.id.tvPercentageBComBca)
        tvPercentageSscHsc = findViewById(R.id.tvPercentageSscHsc)
        skbPercentageBComBCA = findViewById(R.id.skbPercentageBComBCA)
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
                tetFullName.error =resources.getString(R.string.errorFullName)
                tetFullName.requestFocus()
            } else if (tetPhoneNumber.text.toString().trim().isEmpty() ) {
                tetPhoneNumber.error =resources.getString(R.string.errorPhoneNumberIsEmpty)
                tetPhoneNumber.requestFocus()
            }else if(tetPhoneNumber.text.toString().length != 10){
                tetPhoneNumber.error=resources.getString(R.string.errorPhoneNumberValid)
                tetPhoneNumber.requestFocus()

            }else if(tetEmailAddress.text.toString().trim().isEmpty()){
                tetEmailAddress.error=resources.getString(R.string.errorEmailIsEmpty)
                tetEmailAddress.requestFocus()
            }
            else if (!tetEmailAddress.text.toString().trim().matches(emailPattern.toRegex())) {
                tetEmailAddress.error = resources.getString(R.string.errorEmailValid)
                tetEmailAddress.requestFocus()
            } else if (tetAddress.text.toString().trim().isEmpty()) {
                tetAddress.error =resources.getString(R.string.errorAddress)
                tetAddress.requestFocus()
            } else if (tetBirthDate.text.toString().trim().isEmpty()) {
                tetBirthDate.error =resources.getString(R.string.errorBirthIsEmpty)
                tetBirthDate.requestFocus()
            }else{
                if(chbReading.isChecked){
                    chbValue += "\n"+chbReading.text.toString()
                }
                if(chbPlaying.isChecked){
                    chbValue+="\n"+chbPlaying.text.toString()
                }
                if(chbTraveling.isChecked){
                    chbValue+="\n"+chbTraveling.text.toString()
                }

                rbGenderValue += if(rbMale.isChecked){
                    resources.getString(R.string.male)

                } else{
                    resources.getString(R.string.female)
                }
                var temp=resources.getString(R.string.selected_values)+"\n"+":"+spinnerCountry.selectedItem.toString()+chbValue+"\n"+rbGenderValue+"\n"+spinnerSscHsc.selectedItem.toString()
                temp+=resources.getString(R.string.percentage)+":"+skbPercentageSscHsc.progress.toString()+"%"
                temp+="\n"+spinnerBComBCA.selectedItem.toString()
                temp+=resources.getString(R.string.percentage)+":"+skbPercentageBComBCA.progress.toString()+"%"
                tvSelectedValues.text=temp
                temp=""
                rbGenderValue=""
                chbValue=""
            }
        }
        skbPercentageSscHsc.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
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
        skbPercentageBComBCA.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
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

