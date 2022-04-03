package xyz.gozdzik.cryptolist.core

interface PresentationDomainMapper<DOMAIN, PRESENTATION> {
    fun mapToDomain(item: PRESENTATION): DOMAIN
    fun mapToPresentationItem(domain: DOMAIN): PRESENTATION
}