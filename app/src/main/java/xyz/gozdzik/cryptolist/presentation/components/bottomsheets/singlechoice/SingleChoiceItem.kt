package xyz.gozdzik.cryptolist.presentation.components.bottomsheets.singlechoice

interface SingleChoiceItem<T : Enum<T>> {
    val displayNameResId: Int
    val enum: Enum<T>
}