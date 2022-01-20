package org.praveen.mockito.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.praveen.mockito.service.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrievedTodosRelatedToSpring_usingMock() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
		
		when(todoServiceMock.retrieveTodos("Spring")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		assertEquals(2, filteredTodos.size());
	}  
	
	@Test
	public void testRetrievedTodosRelatedToSpring_withEmptyList() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}

}
