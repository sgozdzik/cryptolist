package xyz.gozdzik.cryptolist.domain.usecase

import xyz.gozdzik.cryptolist.core.UseCase
import xyz.gozdzik.cryptolist.domain.model.CurrencyDetailedInfo
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo
import xyz.gozdzik.cryptolist.domain.repository.CurrencyInfoRepository
import javax.inject.Inject

class GetCurrenciesFromRemoteUseCase @Inject constructor(
    private val currencyInfoRepository: CurrencyInfoRepository
) : UseCase<List<CurrencyDetailedInfo>, GetCurrenciesFromRemoteUseCase.Parameters>() {

    override suspend fun getData(parameters: Parameters?): Result<List<CurrencyDetailedInfo>> =
        runCatching {
            currencyInfoRepository.getAll()
                .filterIsInstance<CurrencyDetailedInfo>()
        }

    data class Parameters(val page: Int)
}