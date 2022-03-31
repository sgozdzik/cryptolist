package xyz.gozdzik.cryptolist.core

interface DataMapper<DOMAIN, DATA> {
    fun mapToDomain(data: DATA): DOMAIN
    fun mapToData(domain: DOMAIN): DATA
}