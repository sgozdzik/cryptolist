package xyz.gozdzik.cryptolist.presentation.model

//TODO: Think about another name
data class CurrencyInfoItem(
    val id: String,
    //TODO: Change name?
    val capitalLetter: String,
    val name: String,
    val symbol: String
)