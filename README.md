# StargroupExercise
Coding assignment

Introduction
------------

Application to display Train Station information.
Search any station for Irish rail & get the desired train list. 
Click on the required station & get detailed information about the train.


Getting Started
---------------

This project uses the Gradle build system. To build this project, use the
`gradlew build` command or use "Import Project" in Android Studio.

Screenshots
-----------
![StationSearchScreen](https://github.com/aniketmane/StargroupExercise/blob/master/StarGroupExercise/screenshots/device-2020-06-01-221012.png "Station Search")


Libraries Used
--------------

* [Architecture][0] - A collection of libraries that help you design robust, testable, and
  maintainable apps.
  * [LiveData][1] - Build data objects that notify views when the underlying database changes.
  * [ViewModel][2] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
* [UI][3] - Details on why and how to use UI Components in your apps - together or separate
* Third party
  * [Retrofit][4] for network operation
  * [RxKotlin][5] for managing background threads with simplified code and reducing needs for callbacks

[0]: https://developer.android.com/jetpack/arch/
[1]: https://developer.android.com/topic/libraries/architecture/livedata
[2]: https://developer.android.com/topic/libraries/architecture/viewmodel
[3]: https://developer.android.com/guide/topics/ui
[4]: https://github.com/square/retrofit
[5]: https://github.com/ReactiveX/RxKotlin
[6]: https://developer.android.com/guide/topics/ui

Android Studio IDE setup
------------------------
For development, the latest version of Android Studio is required. The latest version can be
downloaded from [here](https://developer.android.com/studio/).

Improvements 
-----------------
* Add Dagger injection for dependencies 
* Add Test Cases

Author
------------------------
* **Aniket Mane**
