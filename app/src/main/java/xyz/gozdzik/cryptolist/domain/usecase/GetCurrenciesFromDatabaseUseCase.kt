package xyz.gozdzik.cryptolist.domain.usecase

import xyz.gozdzik.cryptolist.core.UseCase
import xyz.gozdzik.cryptolist.domain.repository.CurrencyInfoRepository
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo
import javax.inject.Inject

class GetCurrenciesFromDatabaseUseCase @Inject constructor(
    private val currencyInfoRepository: CurrencyInfoRepository
) : UseCase<List<CurrencyInfo>, Unit>() {
    override suspend fun getData(parameters: Unit?): Result<List<CurrencyInfo>> =
        runCatching {
            currencyInfoRepository.getAll()
        }
}