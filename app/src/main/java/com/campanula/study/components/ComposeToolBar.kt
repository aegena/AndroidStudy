package com.campanula.study.components

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.campanula.study.databinding.LayoutComposeToolbarBinding

class ComposeToolBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val imageByLeft: ImageView
    private val imageByRight: ImageView
    private val textView: TextView
    private val rootLayout: RelativeLayout
    private val backgroundColor = Color.BLUE
    private val textColor = Color.BLACK

    private val binding: LayoutComposeToolbarBinding

    init {
        binding = LayoutComposeToolbarBinding.inflate(
            LayoutInflater.from(context), this, true
        )
        rootLayout = binding.root
        imageByLeft = binding.imageLeft
        imageByRight = binding.imageRight
        textView = binding.text
        textView.setTextColor(textColor)
        rootLayout.setBackgroundColor(backgroundColor)
    }

    fun setText(title: String?) {
        title?.let { textView.text = it }
    }

    fun setLeftClickListener(listener: View.OnClickListener?) {
        imageByLeft.setOnClickListener(listener)
    }

    fun setRightClickListener(listener: View.OnClickListener?) {
        imageByRight.setOnClickListener(listener)
    }

}