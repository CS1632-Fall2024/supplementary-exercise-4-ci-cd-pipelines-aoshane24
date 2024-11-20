package edu.pitt.cs;

import org.mockito.Mockito;

import static org.mockito.Answers.valueOf;
import static org.mockito.Mockito.*; 

public interface Cat {
	public static Cat createInstance(InstanceType type, int id, String name) {
		switch (type) {
			case IMPL:
				return new CatImpl(id, name);
			case BUGGY:
				return new CatBuggy(id, name);
			case SOLUTION:
				return new CatSolution(id, name);
			case MOCK:
				Cat c = Mockito.mock(Cat.class);
				when(c.getId()).thenReturn(id);
        		when(c.getName()).thenReturn(name);
       		 	when(c.getRented()).thenReturn(false);
        		when(c.toString()).thenReturn("ID " + String.valueOf(id)+". " + name);
				doAnswer(invocation -> {
					when(c.getRented()).thenReturn(true);
					return null;
				}).when(c).rentCat();
				doAnswer(invocation -> {
					when(c.getRented()).thenReturn(false);
					return null;
				}).when(c).returnCat();
				doAnswer(invocation -> {
					when(c.getName()).thenReturn("Garfield");
					when(c.toString()).thenReturn("ID " + String.valueOf(id) +". Garfield");
					return null;
				}).when(c).renameCat("Garfield");
				return c;
			default:
				assert(false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.
	
	public void rentCat();

	public void returnCat();

	public void renameCat(String name);

	public String getName();

	public int getId();

	public boolean getRented();

	public String toString();
}
