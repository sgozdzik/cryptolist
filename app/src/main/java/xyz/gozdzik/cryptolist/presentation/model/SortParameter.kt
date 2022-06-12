package xyz.gozdzik.cryptolist.presentation.model

import androidx.annotation.StringRes
import xyz.gozdzik.cryptolist.R
import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceItem

data class FilterParameters(
    val searchQuery: String? = null,
    val sortParameter: SortParameter = SortParameter.BY_MARKET_CAP
)

enum class SortParameter(@StringRes val displayName: Int) : SingleChoiceItem<SortParameter> {
    BY_NAME_ASC(R.string.sort_by_asc),
    BY_NAME_DESC(R.string.sort_by_desc),
    BY_MARKET_CAP(R.string.sort_by_market_cap);

    override val displayNameResId: Int
        get() = displayName

    override val enum: Enum<SortParameter>
        get() = this
}
