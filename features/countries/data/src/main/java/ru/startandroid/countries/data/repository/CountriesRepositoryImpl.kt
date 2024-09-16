package ru.startandroid.countries.data.repository

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.countries.data.network.model.CountryApi
import ru.startandroid.countries.data.network.CountriesApiService
import ru.startandroid.countries.domain.model.Country
import ru.startandroid.countries.domain.repository.CountriesRepository
import java.util.logging.Logger
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val countriesApiService: CountriesApiService,
    private val apiToUiMapper: Mapper<CountryApi, Country>
) : CountriesRepository {

    override suspend fun getCountries(): DataResult<List<Country>> {
        return countriesApiService.getCountries().map { it.response.map { item -> apiToUiMapper.map(item) } }
    }

}