package xyz.gozdzik.cryptolist.presentation.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import xyz.gozdzik.cryptolist.R
import xyz.gozdzik.cryptolist.core.utils.addOnTextChangedListener
import xyz.gozdzik.cryptolist.databinding.ViewSearchToolbarBinding

class SearchToolbarView : ConstraintLayout {

    private lateinit var binding: ViewSearchToolbarBinding

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet? = null) {
        binding = ViewSearchToolbarBinding.inflate(LayoutInflater.from(context), this, true)
        val attrs = attrs ?: return
        context.obtainStyledAttributes(attrs, R.styleable.SearchToolbar).apply {
            if (hasValue(R.styleable.SearchToolbar_toolbar_title)) {
                binding.toolbarTitle.text = getString(R.styleable.SearchToolbar_toolbar_title)
            }
            if (hasValue(R.styleable.SearchToolbar_show_search)) {
                if (getBoolean(R.styleable.SearchToolbar_show_search, false)) {
                    binding.searchBar.visibility = View.VISIBLE
                } else {
                    binding.searchBar.visibility = View.GONE
                }
            }
            if (hasValue(R.styleable.SearchToolbar_show_back_button)) {
                if (getBoolean(R.styleable.SearchToolbar_show_back_button, false)) {
                    binding.leftButton.visibility = View.VISIBLE
                } else {
                    binding.leftButton.visibility = View.GONE
                }
            }
            recycle()
        }
    }

    fun setSearchCallback(searchCallback: (String) -> Unit) {
        binding.searchBar.addOnTextChangedListener {
            searchCallback(it)
        }
    }

    fun leftButtonCallback(clickCallback: () -> Unit) {
        binding.leftClick.setOnClickListener {
            clickCallback.invoke()
        }
    }

    fun rightButtonCallback(clickCallback: () -> Unit) {
        binding.rightClick.setOnClickListener {
            clickCallback.invoke()
        }
    }

    fun setRightButtonIcon(iconResId: Int) {
        binding.rightButton.setImageResource(iconResId)
    }

}