package xyz.gozdzik.cryptolist.core

interface DataDomainMapper<DOMAIN, DATA> {
    fun mapToDomain(data: DATA): DOMAIN
    fun mapToData(domain: DOMAIN): DATA
}