package xyz.gozdzik.cryptolist.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import xyz.gozdzik.cryptolist.R
import xyz.gozdzik.cryptolist.presentation.components.searchtoolbar.SearchToolbarMenuItem

enum class CurrencyListMenuItem(
    @StringRes val displayName: Int,
    @DrawableRes val icon: Int
) : SearchToolbarMenuItem<CurrencyListMenuItem> {
    SORT(
        R.string.search, R.drawable.ic_sort
    );

    override val displayNameResId: Int
        get() = displayName

    override val iconResId: Int
        get() = icon

    override val enum: Enum<CurrencyListMenuItem>
        get() = this
}

