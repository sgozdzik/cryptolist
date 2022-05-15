package xyz.gozdzik.cryptolist.core.utils

import java.math.BigDecimal

fun BigDecimal.toUsdCurrency() = "$this USD"

fun Double.toUsdCurrency() = "$this USD"

fun Double.toPercentageValue() = "${String.format("%.2f", this)}%"