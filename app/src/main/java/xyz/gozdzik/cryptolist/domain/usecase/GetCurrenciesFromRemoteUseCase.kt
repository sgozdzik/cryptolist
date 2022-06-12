package xyz.gozdzik.cryptolist.domain.usecase

import xyz.gozdzik.cryptolist.core.UseCase
import xyz.gozdzik.cryptolist.data.remote.repository.CurrencyInfoRemoteRepository
import xyz.gozdzik.cryptolist.domain.model.CurrencyDetailedInfo
import javax.inject.Inject

class GetCurrenciesFromRemoteUseCase @Inject constructor(
    private val currencyInfoRepository: CurrencyInfoRemoteRepository
) : UseCase<List<CurrencyDetailedInfo>, GetCurrenciesFromRemoteUseCase.Parameters>() {

    override suspend fun getData(parameters: Parameters?): Result<List<CurrencyDetailedInfo>> =
        runCatching {
            currencyInfoRepository.getAll()
        }

    data class Parameters(val page: Int)
}