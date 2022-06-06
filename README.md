# suitability-score

Mobile SDE Code Exercise Platform Science Code Exercise

Project has:

UI

- An activity as entry point for the application: MainActivity
- One fragment for a screen which displays a list of drivers: DriversFragment
- Another one for displaying selected driver and assigning a shipment: ShipmentFragment

Data

- There are two main model data classes: Driver & Shipment
- There is a third data class for the Json response: ResponseData
- This project has only one data source: LocalData

Domain

- A class with functions to perform several actions from any other class: Utils
    - Get suitability score with either vowel or consonants
    - Get common factors of any given item
    - Get response as list of models
    - Etc

Assign shipment to driver only if one has not been assigned already. To assign a shipment:

- Cycle through available shipments. For each iteration, do:
    - Check whether street name length is even or odd. Then pick a base suitability score.
    - Apply 50% bonus suitability score if street name length & driver's name length share common
      factors.
    - If suitability score is the highest so far, save it.
- Pop assigned shipment from available shipments list.
- Set driver's assigned shipment.

Tools version:

- Android Studio: Chipmunk | 2021.2.1
- Kotlin: 1.6.21
- AGP: 7.2.0
- Target Sdk Version: 32
- Min API level: 21

Instructions to build:
- Open Android Studio.
- Select project.
- Please select "Trust project" if prompted to "Trust and open project?".
- Wait for project to load and sync
- Make sure selected configuration is 'app'
- Click on "Run 'app'" or press Shift + 10