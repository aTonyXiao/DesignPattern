package unittest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.Test;

import hw1.DatabaseManager;
import hw1.DestObserver;
import hw1.LibraryBook;
import hw1.SourceObserver;

//Typically test execution is arbitrary, this fixes the order
//to run Question1 -> 2 -> 3, which is needed to test the messages
//on singleton creation.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHW1Student {
	
	@Test
	public void Question1()
	{
		System.out.println("------------------------- Question 1 -------------------------");
		ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
		PrintStream old_out = System.out;
		System.setOut(new PrintStream(redirectedOut));
		
		//Tracking your output starts here.
		DatabaseManager dm = DatabaseManager.TheDatabaseMangaer();
		DatabaseManager dm2 = DatabaseManager.TheDatabaseMangaer();
		
		//Tracking your output ends here.
		String output = new String(redirectedOut.toByteArray());
		System.setOut(old_out);
		System.out.println(output);

		
		//The objects should be the same instance.
		assertEquals(dm, dm2);
		
		//Make sure the lines output match those in the file.
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ1Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> actual_lines = Arrays.asList(output.split("\n"));
		assertEquals(expected_lines.size(), actual_lines.size());
		for (int i = 0; i < expected_lines.size(); i++)
		{
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		System.out.println("------------------------- Question 1 -------------------------");

	}
	
	@Test
	public void Question2()
	{
		System.out.println("------------------------- Question 2 -------------------------");

		LibraryBook b = new LibraryBook("The Signal and The Noise");
		
		ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
		PrintStream old_out = System.out;
		System.setOut(new PrintStream(redirectedOut));
		
		//Tracking your output starts here.
		
		b.returnBook();
		b.shelf();
		b.borrow();
		b.extend();
		b.extend();
		b.extend();
		b.returnBook();
		b.extend();
		b.borrow();
		b.shelf();
		b.extend();
		
		//Tracking your output ends here.
		
		String output = new String(redirectedOut.toByteArray());
		// Go back to standard out.
		System.setOut(old_out);
		System.out.println(output);
		
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ2Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> actual_lines = Arrays.asList(output.split("\n"));
		
		System.out.println(expected_lines.size());
		System.out.println(actual_lines.size());
		assertEquals(expected_lines.size(), actual_lines.size());
		for (int i = 0; i < expected_lines.size(); i++)
		{
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		System.out.println("------------------------- Question 2 -------------------------");
	}

	@Test
	public void Question3() {
		System.out.println("------------------------- Question 3 -------------------------");

		LibraryBook b1 = new LibraryBook("The Signal And The Noise");
		LibraryBook b2 = new LibraryBook("Deep Learning");
		
		SourceObserver a = new SourceObserver("Alice");
		DestObserver b = new DestObserver("Bob");
		
		System.out.println("-------------------------");
		
		//Redirect output
		ByteArrayOutputStream redirectedOut = new ByteArrayOutputStream();
		PrintStream old_out = System.out;
		System.setOut(new PrintStream(redirectedOut));
		//Tracking your output starts here.
		
		b1.detach(b);
		b1.attach(a);
		b1.attach(b);
		b2.attach(b);
				
		b1.borrow();
		b1.extend();
		b1.detach(a);
		b1.extend();
		b1.returnBook();
		b1.shelf();
		
		b2.shelf();
		b2.borrow();
		b2.attach(a);
		b2.returnBook();
		b2.detach(b);
		b2.shelf();
		b2.borrow();
		
		//Tracking your output ends here.
		
		String output = new String(redirectedOut.toByteArray());
		// Go back to standard out.
		System.setOut(old_out);
		System.out.println(output);
		
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ3Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> actual_lines = Arrays.asList(output.split("\n"));
		assertEquals(expected_lines.size(), actual_lines.size());
		for (int i = 0; i < expected_lines.size(); i++)
		{
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		
		System.out.println("------------------------- Question 3 -------------------------");

	}

}
