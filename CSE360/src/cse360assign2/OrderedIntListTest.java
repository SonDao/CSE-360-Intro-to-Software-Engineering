package cse360assign2;
import static org.junit.Assert.*;
import org.junit.Test;
public class OrderedIntListTest {
	
	@Test
	public void testOrderedIntList() {
		OrderedIntList list0 = new OrderedIntList();
		// test if list0 was created 
		assertNotNull(list0);
		// test the size of the array
		assertEquals(10, list0.size());
		// test if the array is empty
		String expectedString = "";
		assertEquals(expectedString, list0.toString());
		
		list0.insert(10);
		list0.insert(11);
		list0.insert(12);
		assertEquals(3, list0.length());
		
		String ex = "10 11 12 ";
		assertEquals(ex, list0.toString());
	}

	@Test
	public void testInsert() {
		OrderedIntList list0 = new OrderedIntList(4);
		// insert positive number
		list0.insert(40);
		list0.insert(30);
		list0.insert(20);
		list0.insert(10);
		// test length of the array
		assertEquals(4, list0.length());
		// test if the size of list increases by 50%
		assertEquals(6, list0.size());
		// test the content of the array
		String expectedString = "10 20 30 40 ";
		assertEquals(expectedString, list0.toString());
		
		// insert negative number
		list0.insert(-10);
		list0.insert(-30);
		list0.insert(-40);
		list0.insert(-20);
		expectedString = "-40 -30 -20 -10 10 \n20 30 40 ";
		assertEquals(expectedString, list0.toString());
		
		// test insert duplicate number
		list0.insert(40);
		list0.insert(30);
		list0.insert(-10);
		list0.insert(-40);
		list0.insert(0);
		expectedString = "-40 -30 -20 -10 0 \n10 20 30 40 ";
		assertEquals(expectedString, list0.toString());
		
		// test length of the array
		assertEquals(9, list0.length());
		assertEquals(13, list0.size()); 
	
		
	}

	@Test
	public void testSize() {
		OrderedIntList list0 = new OrderedIntList();
		// by default, list should have size of 10
		
		assertEquals(10, list0.size()); 
		list0.insert(123);
		
		// test if the size changes after an integer is inserted
		assertEquals(10, list0.size()); 
		
		// test if the size change after an integer is deleted
		list0.delete(123);
		assertEquals(6, list0.size()); // array's size is decreased by 40%

		// test the size of the array initialized by the overloading constructor
		OrderedIntList list1 = new OrderedIntList(4);
		assertEquals(4, list1.size());
		// test if the size increases correctly if the array reached max capacity
		list1.insert(4);
		list1.insert(3);
		list1.insert(2);
		list1.insert(1);
		assertEquals(6, list1.size());
		
		// test if the size decreases correctly if the elements are removed
		list1.delete(4);
		list1.delete(3);
		list1.delete(2);
		assertEquals(1, list1.size());
	}

	@Test
	public void testLength() {
		OrderedIntList list0 = new OrderedIntList(3);
		list0.insert(100);
		// the list should have a length of 1 after an element is inserted
		assertEquals(1, list0.length());
		// insert positive numbers
		list0.insert(12);
		list0.insert(13);
		list0.insert(14);
		assertEquals(4, list0.length());
		
		// insert negative numbers
		list0.insert(-10);
		list0.insert(-11);
		list0.insert(-20);
		list0.insert(-4);
		assertEquals(8, list0.length());
		list0.insert(111);
	
		// test the length when insert duplicate
		list0.insert(111);
		assertEquals(12, list0.length());
		
		// test the length when elements are removed
		list0.delete(-20);
		list0.delete(20);
		assertEquals(10, list0.length());
	}

	@Test
	public void testDelete() {
		OrderedIntList list0 = new OrderedIntList();
		list0.insert(20);
		list0.insert(10);
		list0.insert(-1);
		list0.insert(5);
		list0.delete(5);
		
		// test the content of the array
		String expectedString = "-1 10 20";
		assertEquals(expectedString, list0.toString());
		
		// test the length of list0 after an element is deleted
		assertEquals(3, list0.length());
		// the size of list0 should be decreased by 40% after 5 is removed
		assertEquals(6, list0.size());
		
		// test if delete() could remove negative number
		list0.delete(-1);
		assertEquals(2, list0.length());

		// test deleting element that is not in the list
		list0.delete(100);
		assertEquals(2, list0.length()); // length stays the same
	}

	@Test
	public void testToString() {
		OrderedIntList list = new OrderedIntList();
		list.insert(99);
		list.insert(55);
		list.insert(23);
		list.insert(14);
		list.insert(100);
		String expectedString = "14 23 55 99 100 ";
		// test if toString shows the correct content of the array
		assertEquals(expectedString, list.toString());
		
		// insert more than 5 elements and negative number
		OrderedIntList list1 = new OrderedIntList(5);
		list1.insert(1);
		list1.insert(-1);
		list1.insert(-2);
		list1.insert(2);
		list1.insert(3);
		list1.insert(4);
		list1.insert(5);
		list1.insert(50);
		String expectedString1 = "-2 -1 1 2 3 \n4 5 50 ";
		// test if toString shows the correct content of the array
		assertEquals(expectedString1, list1.toString());
		
		// test empty array
		OrderedIntList list2 = new OrderedIntList();
		expectedString = " ";
		assertEquals(expectedString, list2.toString());
	}
}
  