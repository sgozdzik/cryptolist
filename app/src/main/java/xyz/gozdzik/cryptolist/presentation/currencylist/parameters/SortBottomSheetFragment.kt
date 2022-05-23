package xyz.gozdzik.cryptolist.presentation.currencylist.parameters

import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import xyz.gozdzik.cryptolist.R
import xyz.gozdzik.cryptolist.presentation.model.SortParameter
import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceBottomSheetFragment
import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceItem

class SortBottomSheetFragment : SingleChoiceBottomSheetFragment<SortParameter>() {

    private val args: SortBottomSheetFragmentArgs by navArgs()

    override fun getChoiceItems(): List<SingleChoiceItem<SortParameter>> = SortParameter
        .values()
        .toList()

    override fun setNavigationResult(choice: SingleChoiceItem<SortParameter>) {
        setFragmentResult(
            REQUEST_KEY, bundleOf(
                CHOICE to choice.enum
            )
        )
    }

    override fun getTitle(): String = getString(R.string.sort)

    override fun getPreselectedItem(): SingleChoiceItem<SortParameter> = args.preselectedChoiceItem

    companion object {

        val REQUEST_KEY = "SortBottomSheetRequestKey"
        val CHOICE = "Choice"

    }

}