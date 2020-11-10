package com.project.calculatorcheckbox

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException


class MainActivity : AppCompatActivity() {
    var listView: ListView? = null
    var calculatorCheckbox: CalculatorCheckbox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<View>(R.id.recycleItems) as ListView
        var dataModel: DataModel
        val arrPeople: ArrayList<DataModel> = ArrayList()
        for (i in 0..2) {
            dataModel = DataModel()
            dataModel.value = ""
            dataModel.isShowCheckBox = true
            arrPeople.add(dataModel)
        }
        calculatorCheckbox = CalculatorCheckbox(this, R.layout.list_item_checkbox, arrPeople)
        listView!!.adapter = calculatorCheckbox

        add.setOnClickListener {

            var total = 0

            for(i in 0 until calculatorCheckbox!!.arrayData.size){

                if(calculatorCheckbox!!.arrayData.get(i).value == ""){
                    Toast.makeText(this, "Tidak boleh kosong!", Toast.LENGTH_LONG).show()
                }else{
                    total += calculatorCheckbox!!.arrayData.get(i).value!!.toInt()
                    hasil.text = total.toString()

                    Toast.makeText(this,"${calculatorCheckbox!!.arrayData.get(i).value!!.toInt()}", Toast.LENGTH_LONG).show()
                }


            }
        }

//        sub.setOnClickListener {
//            var total = 0
//
//            for(i in 0 until calculatorCheckbox!!.arrayData.size){
//
//                total -= calculatorCheckbox!!.arrayData.get(i).value!!.toInt()
//                hasil.text = total.toString()
//            }
//        }
//
//        division.setOnClickListener {
//            var total = 0
//
//            for(i in 0 until calculatorCheckbox!!.arrayData.size){
//
//                total /= calculatorCheckbox!!.arrayData.get(i).value!!.toInt()
//                hasil.text = total.toString()
//            }
//        }
//
//        multi.setOnClickListener {
//                var total = 0
//
//                for(i in 0 until calculatorCheckbox!!.arrayData.size){
//
//                    total = total * calculatorCheckbox!!.arrayData.get(i).value!!.toInt()
//                    hasil.text = total.toString()
//                }
//        }
    }
}