package com.example.todolist.presentation.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import androidx.core.widget.CompoundButtonCompat
import androidx.databinding.BindingAdapter
import com.example.todolist.R
import com.example.todolist.data.util.DateToString
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.chip.Chip
import com.google.android.material.textview.MaterialTextView
import java.util.*

@SuppressLint("SetTextI18n")
@BindingAdapter("count")
fun setCount(materialTextView: MaterialTextView, count: Int) {
    val resources = materialTextView.context.resources
    val text = resources.getQuantityString(R.plurals.task_count, count, count)
    materialTextView.text = text
}

@BindingAdapter("view_color")
fun setColor(view : View, color : String){
    view.setBackgroundColor(Color.parseColor(color))
}

@BindingAdapter("check_status", "view_color")
fun setCheckStatus(materialCheckBox: MaterialCheckBox, status : Boolean, color: String){
    materialCheckBox.setOnCheckedChangeListener(null)
    materialCheckBox.isChecked = status
    CompoundButtonCompat.setButtonTintList(materialCheckBox, ColorStateList.valueOf(Color.parseColor(color)))
}

@SuppressLint("SetTextI18n")
@BindingAdapter("set_date")
fun setDate(dueDate: MaterialTextView, date: Date) {
    val prefix = dueDate.context.getString(R.string.due_date_prefix)
    dueDate.text = prefix + DateToString.convertDateToString(date)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("priority", "view_color")
fun setPriority(chip: Chip, priority: Int, color: String) {
    val priorityText = when(priority) {
        0 -> chip.context.getString(R.string.low)
        1 -> chip.context.getString(R.string.medium)
        else -> chip.context.getString(R.string.high)
    }
    chip.text = priorityText
    chip.chipStrokeColor = ColorStateList.valueOf(Color.parseColor(color))
}