# Cats-Project

## Hi there!

### Welcome to CatsApp.

This app follows the structure of MVVM (Model-View-ViewModel).
In the main activity, there is a nav host - a container that contains the different screens of the app and manages the navigation between different screens.

To load cat pictures, I used the following API https://developers.thecatapi.com/ .
To turn the HTTP cat API requests into a Kotlin interface, I used Retrofit (https://square.github.io/retrofit/).

For dependency injection, because this is a small project, I decided to use Koin. 