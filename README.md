# TodoMVC_Advanced_Backend
Spring boot-based restful API for for interfacing between the TodoMVC_Advanced_Frontend and a MySQL database in which all important data is stored.

Database columns:  
- id : int  
- todoText : String(140)  
- completed : binary(1) 

Available API calls (on localhost:8080 by default, also assumes a MySQL database on localhost:3306):

## /getAllItems
- Type: GET
- Keys:  
Returns all stored todoItems.

## /getItem
- Type: GET
- Keys: id : int  
Returns a single row with the id.

## /deleteItem
- Type: POST
- Keys: id : int  
Deletes a single row with the id.

## /deleteCompletedItems
- Type: POST
- Keys:  
Deletes all rows where completed == true.

## /addItem
- Type: POST
- Keys: todoText : String(140)  
Creates a new row with autogenerated id, todoText = todoText, and completed = false.

## /setCompleted
- Type: POST
- Keys: id : int, completed : boolean  
Sets the value of completed in the row with id.
