package xyz.gozdzik.cryptolist.presentation.currencylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import xyz.gozdzik.cryptolist.R
import xyz.gozdzik.cryptolist.databinding.FragmentCurrencyListBinding
import xyz.gozdzik.cryptolist.presentation.model.SortParameter

@AndroidEntryPoint
class CurrencyListFragment : Fragment() {

    private val adapter: CurrencyListAdapter by lazy {
        CurrencyListAdapter {
            //TODO: Show snackbar or something similar
            TODO()
        }
    }
    private val args: CurrencyListFragmentArgs by navArgs()
    private val viewModel: CurrencyListViewModel by viewModels()
    private lateinit var binding: FragmentCurrencyListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initViewModel(args.currencies.toList())
        setupView()
        observeViewModel()
    }

    private fun setupView() {
        binding.apply {
            rvCryptoList.adapter = adapter
            searchToolbar.apply {
                setSearchCallback { searchQuery ->
                    viewModel.search(searchQuery)
                }
                leftButtonCallback {
                    findNavController().popBackStack()
                }
                rightButtonCallback {
                    viewModel.sortCurrencies(SortParameter.BY_NAME_ASC)
                }
                setRightButtonIcon(R.drawable.ic_sort)
            }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenResumed {
            viewModel.currenciesInfoItemsObservable
                .collect { currenciesInfoItems ->
                    adapter.submitList(currenciesInfoItems)
                }
        }
    }

}