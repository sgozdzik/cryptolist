![Screenshot](https://github.com/sgozdzik/cryptolist/blob/master/screenshot.jpg?raw=true)

# About application

## Purpose
This app was made to show programming skills and knowladge in Android development & Clean Architecture pattern. It's very small and compact.


## Functionality

- displaying crypto list from CoinGecko API
- searching by user input
- sorting by market cap or alphabetically

## UI
Most of UI components which are used in application are part of my other project - library Serfa Design. You can find more details here:

[**Serfa Design Repository**](https://github.com/sgozdzik/serfadesign) 

## Used technologies and libraries
- Retrofit
- Coroutines
- Clean Architecture
- Room database
- Navigation Graph

## Additional notes

- Circle CI (base implementation of unit and UI tests)
- StateEvent - I added this to handle single time events - like showing snackbars, toasts or navigating to different screens after fetching some data
- UseCase - base UseCase class that can be used globally 
- Dividing packages according to Clean Architecture pattern along with domain / data / presentation model mappers 

## Things to improve and to do in future

### Favourite 
One of the goals is to add user possibility to save favourites cryptos and display them in different tab / screen. Implementation of room database is partly ready.

### Crypto details
User should be able to enter crypto details screen after clicking on it on the list. In that screen app should display some additional details like for example charts.

