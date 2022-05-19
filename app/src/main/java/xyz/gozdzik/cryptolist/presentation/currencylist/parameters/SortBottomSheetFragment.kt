package xyz.gozdzik.cryptolist.presentation.currencylist.parameters

import xyz.gozdzik.cryptolist.R
import xyz.gozdzik.cryptolist.presentation.components.bottomsheets.singlechoice.SingleChoiceBottomSheetFragment
import xyz.gozdzik.cryptolist.presentation.components.bottomsheets.singlechoice.SingleChoiceItem
import xyz.gozdzik.cryptolist.presentation.model.SortParameter

class SortBottomSheetFragment : SingleChoiceBottomSheetFragment<SortParameter>() {

    override fun getChoiceItems(): List<SingleChoiceItem<SortParameter>> = SortParameter
        .values()
        .toList()

    override fun setNavigationResult() {
        //TODO
    }

    override fun getTitle(): String = getString(R.string.sort)

}