## Comments to tasks

### CurrencyListFragment should receive an array list of CurrencyInfo to create the ui.
I implemented as it was described - CurrencyListFragment is getting array from DemoFragment.
### DemoActivity should provide 1 dataset, Currency List A of CurrencyInfo to CurrencyListFragment and the dataset should be queried from local db
I used **Room** as a database. I added prepopulating it from Json file you provided. It would be easier to do it using Scheme and function from Room library - but I decided to add additional Json parsing and prepopulating from it as an additional example of coding skills. 
### DemoActivity should provide 2 buttons to do the demo. First button to load the data and display. Second button for sorting currency list
DemoFragment (I decided to put login into fragments instead of activity) has UI button to fetch data from DB, after that it goes to CurrencyListFragment. Sorting and searching is done after clicking buttons in toolbar in CurrencyListFragment.
### CurrencyListFragment should provide a hook of item click listener to the parent
After clicking an item toolbar is changing it's name to currency name.
### All the IO operations ​MUST NOT ​be in UI Thread.
IO operations were done using Kotlin Coroutines and Kotlin Flow.
### Please ​show how to handle ​multi threading operation​, and deal with ​concurrency issue​ when do sorting (fast double click of sorting button)
Concurrency is done by Kotlin Flow and also using it's update function. Like described here: https://proandroiddev.com/make-sure-to-update-your-stateflow-safely-in-kotlin-9ad023db12ba . Also I added StateEvent class for handling single time events in application (like showing some snackbar / toast or navigating to different screen after fetching some data)
### Search functionality is not required
I added it anyway. 


## Things that should be added
Application ofcourse is only demo example. It should also have things like:

- error handling
- UI tests
- UX for different sorting types (I added in code possibility to sort by name ascending, descending, but it's not implemented in UI).
- UI loader - for showing user that something is happening in background (like in fetching the data from database)

## Things added additionaly

- Circle CI (base implementation of unit and UI tests)
- StateEvent - I added this to handle single time events - like showing snackbars, toasts or navigating to different screens after fetching some data
- UseCase - base UseCase class that can be used globally 
- Dividing packages according to Clean Architecture pattern along with domain / data / presentation model mappers 
