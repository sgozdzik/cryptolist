package xyz.gozdzik.cryptolist.domain.usecase

import xyz.gozdzik.cryptolist.core.UseCase
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo
import xyz.gozdzik.cryptolist.domain.repository.CurrencyInfoRepository
import javax.inject.Inject

class GetCurrenciesFromRemoteUseCase @Inject constructor(
    private val currencyInfoRepository: CurrencyInfoRepository
) : UseCase<List<CurrencyInfo>, GetCurrenciesFromRemoteUseCase.Parameters>() {

    override suspend fun getData(parameters: Parameters?): Result<List<CurrencyInfo>> =
        runCatching {
            currencyInfoRepository.getAll()
        }

    data class Parameters(val page: Int)
}