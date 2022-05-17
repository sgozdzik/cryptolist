package xyz.gozdzik.cryptolist.presentation.components.bottomsheets.singlechoice

interface SingleChoiceItem<T : Enum<T>> {
    val displayNameResId: String
    val enum: Enum<T>
}