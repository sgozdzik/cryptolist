package xyz.gozdzik.cryptolist.domain.usecase

import xyz.gozdzik.cryptolist.core.UseCase
import xyz.gozdzik.cryptolist.data.local.repository.CryptoCurrencyInfoRepository
import xyz.gozdzik.cryptolist.domain.model.CryptoCurrencyInfo
import javax.inject.Inject

class GetCryptoCurrenciesFromDatabaseUseCase @Inject constructor(
    private val cryptoCurrencyInfoRepository: CryptoCurrencyInfoRepository
) : UseCase<List<CryptoCurrencyInfo>, Unit>() {
    override suspend fun getData(parameters: Unit?): Result<List<CryptoCurrencyInfo>> =
        runCatching {
            cryptoCurrencyInfoRepository.getAll()
        }
}