package com.project.calculatorcheckbox

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class CalculatorCheckbox(context: Context, resource: Int, arraypeople: ArrayList<DataModel>) :
    ArrayAdapter<DataModel?>(context, resource) {
    var mContext: Context
    var inflater: LayoutInflater
    var arrayData: ArrayList<DataModel>


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: ViewHolder
        var retView: View
        if (convertView == null) {
            retView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_checkbox, null)
            holder = ViewHolder()
            holder.edName = retView.findViewById(R.id.edtcheckbox)
            holder.cbShowName = retView.findViewById(R.id.checkboxItem)
            retView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            retView = convertView
        }
        val dataArrayPosition: DataModel = arrayData[position]
        holder.cbShowName!!.isChecked = dataArrayPosition.isShowCheckBox
        if (dataArrayPosition.isShowCheckBox) {
            holder.edName!!.visibility = View.VISIBLE
        } else {
            holder.edName!!.visibility = View.INVISIBLE
        }
        //Using setOnclickListener not setOnCheckedChangeListener
        holder.cbShowName!!.setOnClickListener {
            if (holder.cbShowName!!.isChecked) {
                arrayData[position].isShowCheckBox = true
                holder.edName!!.visibility = View.VISIBLE
            } else {
                arrayData[position].isShowCheckBox = false
                holder.edName!!.visibility = View.INVISIBLE

            }
        }

        holder.edName!!.setText(dataArrayPosition.value)
        holder.edName!!.id = position

        holder.edName!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                arrayData.get(position).value = holder.edName!!.getText().toString()
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        return retView
    }

    override fun getCount(): Int {
        return arrayData.size
    }

    internal class ViewHolder {
        var edName: EditText? = null
        var cbShowName: CheckBox? = null

    }

    init {
        mContext = context
        arrayData = arraypeople
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


}