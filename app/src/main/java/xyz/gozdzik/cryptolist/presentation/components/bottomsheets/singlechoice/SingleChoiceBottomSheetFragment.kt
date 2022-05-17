package xyz.gozdzik.cryptolist.presentation.components.bottomsheets.singlechoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import xyz.gozdzik.cryptolist.databinding.FragmentSingleChoiceBottomSheetBinding

open class SingleChoiceBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSingleChoiceBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleChoiceBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

}