package com.TodoMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TodoItemController {
	@Autowired
	
	private TodoItemRepository todoItemRepository;
	
	@GetMapping(path="/getAllItems")
	public Iterable<TodoItem> getAllItems() {
		return todoItemRepository.findAll();
	}
	
	@GetMapping(path="/getItem")
	public TodoItem getItem(@RequestParam int id) {
		TodoItem todoItem = todoItemRepository.findById(id).get();
		return todoItem;
	}
	
	@PostMapping(path="/deleteItem")
	public void deleteItem(@RequestParam int id) {
		todoItemRepository.deleteById(id);
	}
	
	@PostMapping(path="/deleteCompletedItems")
	public void deleteCompletedItems() {
		Iterable<TodoItem> todoItemIterator = todoItemRepository.findAll();
		for(TodoItem t : todoItemIterator) {
			if(t.isCompleted()) {
				todoItemRepository.delete(t);
			}
		}
	}
	
	@PostMapping(path="/addItem")
	public int addItem (@RequestParam String todoText) {
		TodoItem t = new TodoItem();
		t.setTodoText(todoText);
		t.setCompleted(false);
		todoItemRepository.save(t);
		System.out.print(t.getId());
		return t.getId();
	}
	
	@PostMapping(path="/setCompleted")
	public void setCompleted (@RequestParam int id, @RequestParam boolean completed) {
		todoItemRepository.findById(id).get().setCompleted(completed);
	}
}
