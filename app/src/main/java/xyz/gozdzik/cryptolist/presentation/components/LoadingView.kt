package xyz.gozdzik.cryptolist.presentation.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import xyz.gozdzik.cryptolist.databinding.ViewLoadingBinding

class LoadingView : ConstraintLayout {

    private lateinit var binding: ViewLoadingBinding

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context) {
        binding = ViewLoadingBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

}