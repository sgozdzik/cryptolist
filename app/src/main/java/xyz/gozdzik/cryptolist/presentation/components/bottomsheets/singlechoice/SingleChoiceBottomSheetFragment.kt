package xyz.gozdzik.cryptolist.presentation.components.bottomsheets.singlechoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import xyz.gozdzik.cryptolist.databinding.FragmentSingleChoiceBottomSheetBinding

abstract class SingleChoiceBottomSheetFragment<T : Enum<T>> : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSingleChoiceBottomSheetBinding
    private val choiceAdapter by lazy { ChoiceAdapter<T>() }

    abstract fun getChoiceItems(): List<SingleChoiceItem<T>>
    abstract fun setNavigationResult()
    abstract fun getTitle(): String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleChoiceBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.rvChoice.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = choiceAdapter
        }
        choiceAdapter.submitList(getChoiceItems())
        binding.bottomSheetTitle.text = getTitle()
        binding.closeButton.setOnClickListener {
            dismiss()
        }
        binding.sbvDone.setOnClickListener {
            setNavigationResult()
            dismiss()
        }
    }

}