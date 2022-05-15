package xyz.gozdzik.cryptolist.presentation.currencylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import xyz.gozdzik.cryptolist.R
import xyz.gozdzik.cryptolist.databinding.FragmentCurrencyListBinding
import xyz.gozdzik.cryptolist.presentation.model.SortParameter

@AndroidEntryPoint
class CurrencyListFragment : Fragment() {

    private val adapter: CurrencyListAdapter by lazy {
        CurrencyListAdapter { currencyInfoItem ->
            binding.searchToolbar.setTitle(currencyInfoItem.name)
        }
    }
    private val currencyListViewModel: CurrencyListViewModel by viewModels()
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
        currencyListViewModel.fetchCurrencies()
        setupView()
        observeViewModel()
    }

    private fun setupView() {
        binding.apply {
            viewModel = currencyListViewModel
            lifecycleOwner = this@CurrencyListFragment
            rvCryptoList.adapter = adapter
            searchToolbar.apply {
                setSearchCallback { searchQuery ->
                    currencyListViewModel.search(searchQuery)
                }
                rightButtonCallback {
                    currencyListViewModel.sortCurrencies(SortParameter.BY_NAME_ASC)
                }
                setRightButtonIcon(R.drawable.ic_sort)
            }
            srRefresh.setOnRefreshListener {
                srRefresh.isRefreshing = false
                currencyListViewModel.fetchCurrencies()
            }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenResumed {
            currencyListViewModel.currenciesInfoItemsObservable
                .collect { currenciesInfoItems ->
                    adapter.submitList(currenciesInfoItems)
                }
        }
    }

}