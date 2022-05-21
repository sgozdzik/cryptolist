package xyz.gozdzik.cryptolist.presentation.components

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:text")
fun TextView.setResIdText(value: Int?) {
    value?.let {
        setText(value)
    }
}

@BindingAdapter("android:src")
fun ImageView.setResIdText(value: Int?) {
    value?.let {
        setImageResource(value)
    }
}