package org.praveen.mockito.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void arrayList_mockSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		
		assertEquals(2, listMock.size());
	}
	
	
	@Test
	public void arrayList_returnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void arrayList_mockGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("in28Minutes");
		
		assertEquals("in28Minutes", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	//Argument Matcher 
	@Test
	public void arrayList_argumentMatcher() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("in28Minutes");
		
		assertEquals("in28Minutes", listMock.get(0));
		assertEquals("in28Minutes", listMock.get(1));
	}
	
	//Exception Case
	@Test(expected = RuntimeException.class)
	public void arrayList_throwAnException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		
		listMock.get(0);
	}
}
