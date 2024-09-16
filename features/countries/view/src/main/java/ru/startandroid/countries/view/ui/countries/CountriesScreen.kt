package ru.startandroid.countries.view.ui.countries

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.StateFlow
import ru.startandroid.core.navigation.SetResult
import ru.startandroid.core.ui.components.uistate.ShowUiState
import ru.startandroid.countries.api.constants.COUNTRIES_NAV_ARG_COUNTRY
import ru.startandroid.countries.domain.model.Country

@Composable
fun CountriesScreen(
    navController: NavController,
    viewModel: CountriesViewModel = hiltViewModel()
) {
    navController.SetResult(COUNTRIES_NAV_ARG_COUNTRY, viewModel.selectedCountry)
    Column(modifier = Modifier.fillMaxSize()) {
        Countries(viewModel)
    }
}

@Composable
private fun Countries(
    holder: CountriesHolder
) {
    ShowUiState(
        uiState = holder.countries,
        onRetry = holder::onRetry
    ) { countries ->
        LazyColumn {
            items(countries) {
                CountryItem(
                    country = it,
                    imageSize = holder.imageSize,
                    getImageLoadedState = holder::getImageLoadedState,
                    onClick = holder::onCountryClick
                )
            }
        }
    }
}

@Composable
private fun CountryItem(
    country: Country,
    imageSize: Int,
    getImageLoadedState: (String) -> StateFlow<Boolean>,
    onClick: (country: Country) -> Unit
) {
    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(country) }
            .padding(horizontal = 16.dp)
    ) {
        Box(modifier = Modifier
            .size(imageSize.dp)
            .padding(end = 16.dp)) {
            country.flag?.let { url ->
                val loaded = getImageLoadedState(url).collectAsState().value
                if (loaded) {
                    AsyncImage(
                        model = url,
                        contentDescription = "Country flag",
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
        Text(
            text = country.name,
            fontSize = 20.sp
        )
    }
}