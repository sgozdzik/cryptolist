package xyz.gozdzik.cryptolist.presentation.currencylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import xyz.gozdzik.cryptolist.databinding.FragmentCurrencyListBinding

class CurrencyListFragment : Fragment() {

    private val adapter: CurrencyListAdapter by lazy {
        CurrencyListAdapter {
            //TODO: Show snackbar or something similar
            TODO()
        }
    }
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
        setupView()
    }

    private fun setupView() {
        binding.apply {
            rvCryptoList.adapter = adapter
        }
    }

}