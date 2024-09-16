# Test project

Small project for testing a few approaches.

Displays standings for selected football league/cup and season.

Displays players for selected teams.


## Tech stack
Kotlin, Compose, Hilt, Retrofit.


## Architecture
Every feature is implemented in separate module: countries, leagues, standings, teams, players
Every feature module has layer modules: data, domain, view and api.

## api feature module
The api module allows feature to be used by another features.

The main idea is the **api** module contains only interfaces (and models if needed).  All implementations are in **view** and **domain**.
For example, **api** contains Navigation interface to open some feature screen. Implementation is in **view** module.
Or **api** contains UseCase interface to get some feature data, with implementation in **domain**.

It allows features to use each other without circular dependency issue. For example:
Module **teams.view** uses Navigation from **players.api** to open players screen.
And **players.view** uses UseCase from **teams.api** to get data about seasons.
So, **teams** uses **players** and vice versa.

## network
Special adapter is created for Retrofit. It handles different errors: parsing, network or even error messages that included to server Json response. As a result, we avoid exceptions and get DataResult class with data or error.

## UI
On UI layer we convert DataResult to sealed class UiState: None, Loading, Empty, Data, Error.
There are composable function ShowUiState and class UiStateData. They cover base data fetching and displaying functionality and allow avoiding code duplication.
In the simple case, we have code in VM:

    val team = UiStateData { getTeamUseCase(teamId) }

and code in UI:

    ShowUiState(uiStateData = viewModel.team) { team ->  
      // composable code to display team's data
    }

This code:
- loads data only when there is a subscriber
- fetches data by passed UseCase function
- displays Loading indicator while fetching
- provides fetched data to your slot api function
- displays Error message and Retry button if there are some errors
- displays "No data" text if there is no data


## Result
To pass data between screens, savedStateHandle in BackStackEntry is used.
There are a couple of composable extension methods for NavController.
use SetResult to set data to savedState of previous BackStackEntry

    navController.SetResult(COUNTRIES_NAV_ARG_COUNTRY, viewModel.selectedCountry)
use GetResult to get this data

    navController.GetResult(COUNTRIES_NAV_ARG_COUNTRY, viewModel::onCountryChosen)

It works even for screens in different modules. You need to have only constant that is visible for both modules. It can be located in **api** module of called screen that sets Result.


## UseCase
For UseCase I tried to use the approach from this article:
https://dladukedev.com/articles/042_avoid_useless_cases_part_2/

UseCase is just an interface and repo implements it.

I wanted to check it somewhere, and I did it here. It doesn't look like a much better solution. We need to create and import invoke extension. And we need to create dagger Binds method to create an UseCase instance.


## TODO
Tests


## API links
https://www.api-football.com/documentation-v3

