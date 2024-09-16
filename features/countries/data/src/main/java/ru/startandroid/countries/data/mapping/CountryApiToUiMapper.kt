package ru.startandroid.countries.data.mapping

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.countries.data.network.model.CountryApi
import ru.startandroid.countries.domain.model.Country
import javax.inject.Inject

class CountryApiToUiMapper @Inject constructor() : Mapper<CountryApi, Country> {

    override fun map(from: CountryApi): Country {
        return Country(
            name = from.name,
            code = from.code ?: "##",
            flag = from.flag
        )
    }
}