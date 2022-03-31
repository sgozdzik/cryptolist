package xyz.gozdzik.cryptolist.data.model.mappers

import xyz.gozdzik.cryptolist.core.DataMapper
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO
import xyz.gozdzik.cryptolist.domain.model.CryptoCurrencyInfo

class CryptoCurrencyMapper : DataMapper<CryptoCurrencyInfo, CryptoCurrencyInfoDTO> {

    override fun mapToDomain(data: CryptoCurrencyInfoDTO): CryptoCurrencyInfo =
        CryptoCurrencyInfo(
            data.id,
            data.name,
            data.symbol
        )

    override fun mapToData(domain: CryptoCurrencyInfo): CryptoCurrencyInfoDTO =
        CryptoCurrencyInfoDTO(
            domain.id,
            domain.name,
            domain.symbol
        )

}