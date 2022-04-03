package xyz.gozdzik.cryptolist.presentation.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import xyz.gozdzik.cryptolist.core.utils.collectEvent
import xyz.gozdzik.cryptolist.databinding.FragmentDemoBinding

@AndroidEntryPoint
class DemoFragment : Fragment() {

    private lateinit var binding: FragmentDemoBinding
    private val viewModel: DemoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onStop() {
        super.onStop()
        viewModel.clearEvents()
    }

    private fun setupView() {
        binding.btnFetchData.setOnClickListener {
            viewModel.getCurrenciesFromDatabase()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.currenciesInfoItemsObservable
                .collectEvent { currenciesInfoItems ->
                    findNavController().navigate(
                        DemoFragmentDirections.navigateToFragmentCurrencyList(
                            currenciesInfoItems.toTypedArray()
                        )
                    )
                }
        }
    }

}