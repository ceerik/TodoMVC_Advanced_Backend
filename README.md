# TodoMVC_Advanced_Backend
Spring boot-based restful API for for interfacing between the TodoMVC_Advanced_Frontend and a MySQL database in which all important data is stored.

The calls available are the bare minimum required, with the addition of getItem for optimization purposes (one could otherwise hypothetically use getAllItems and iterate over them to get a specific item).  
  
There is perhaps a case to be made for putting the logic for toggling completion of all items in the backend (and creating a new call for that logic) instead of the frontend JS, similar to /deleteCompletedItems; it would probably result in less overhead as there would be only be a couple of API-calls from to frontend instead of n+1 where n is the number of items having their completed column toggled. In reality this is unlikely to have much of an impact on the end user experience as the number of todoItems present at any time is estimated to be no more man a couple of dozen or so; and so the decision was made to keep that bit of logic in the frontend as a time-saving measure (for the developer, that is).  

### Database columns:  
- id : int  
- todoText : String(140)  
- completed : binary(1)  
  
Other information such as viewState (showing all/active/completed items) are not stored as they do not contain any data relevant to each item, it's purely a view-focused sorting.  


## Available API calls (on localhost:8080 by default, also assumes a MySQL database on localhost:3306):

### /getAllItems
- Type: GET
- Keys:  
Returns all stored todoItems.

### /getItem
- Type: GET
- Keys: id : int  
Returns a single row with the id.

### /deleteItem
- Type: POST
- Keys: id : int  
Deletes a single row with the id.

### /deleteCompletedItems
- Type: POST
- Keys:  
Deletes all rows where completed == true.

### /addItem
- Type: POST
- Keys: todoText : String(140)  
Creates a new row with autogenerated id, todoText = todoText, and completed = false.  
Returns the id of the new row.

### /setCompleted
- Type: POST
- Keys: id : int, completed : boolean  
Sets the value of completed in the row with id.
