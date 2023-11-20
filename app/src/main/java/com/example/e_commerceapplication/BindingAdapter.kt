package com.example.e_commerceapplication

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:Error")
fun bindErrorOnTextInputLayout(
    textInputLayout: TextInputLayout,
    errorMessage: String?
) {
    textInputLayout.error = errorMessage
}

@BindingAdapter(value = ["app:url", "app:placeholder"])
fun bindImageWithUrl(imageView: ImageView, url: String, placeholder: Drawable?) {
    Glide.with(imageView)
        .load(url)
        .placeholder(placeholder)
        .into(imageView)
}

//@BindingAdapter("imageUrl")
//fun bindImageWithUrl(imageView: ImageView, url: String) {
//    Glide.with(imageView)
//        .load(url)
//        .into(imageView)
//}