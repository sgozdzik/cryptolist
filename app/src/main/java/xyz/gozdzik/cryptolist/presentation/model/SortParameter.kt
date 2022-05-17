package xyz.gozdzik.cryptolist.presentation.model

data class FilterParameters(
    val searchQuery: String? = null,
    val sortParameter: SortParameter = SortParameter.DEFAULT
)

enum class SortParameter {
    DEFAULT,
    BY_NAME_ASC,
    BY_NAME_DESC,
    BY_MARKET_CAP
}