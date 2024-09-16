package ru.startandroid.countries.view.mapping

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.countries.api.model.CountryExt
import ru.startandroid.countries.domain.model.Country
import javax.inject.Inject

class CountryUiToExtMapper @Inject constructor() : Mapper<Country, CountryExt> {
    override fun map(from: Country): CountryExt {
        return CountryExt(
            name = from.name,
            code = from.code,
            flag = from.flag
        )
    }
}