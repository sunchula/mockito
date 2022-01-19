package org.praveen.mockito.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.praveen.mockito.service.TodoService;
import org.praveen.mockito.service.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrievedTodosRelatedToSpring_usingStub() {
		
		TodoService todoServiceStub = new TodoServiceStub();

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
	}

}
