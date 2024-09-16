package ru.startandroid.countries.domain.usecase

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.countries.domain.model.Country
import ru.startandroid.countries.domain.repository.CountriesRepository
import javax.inject.Inject

interface GetCountriesUseCase {
    suspend fun getCountries(): DataResult<List<Country>>
}

suspend operator fun GetCountriesUseCase.invoke(): DataResult<List<Country>> = this.getCountries()
