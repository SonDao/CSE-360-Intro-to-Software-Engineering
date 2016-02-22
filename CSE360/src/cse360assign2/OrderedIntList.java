package cse360assign2;

/** 
 * Create an array with dynamic storage size that alters
 * depends on the number of integers stored in the array.
 * @author Debra Calliss, Vaul Demar Kranak, Son Dao
 * @version 2-8-16
 * 
 */
public class OrderedIntList
{
	private int[] array;
	private int count;
	
	/** Create an empty list */
	OrderedIntList()
	{
		array = new int[10];
		count = 0;
	}
	
	/** Create an empty list of a specify size */
	OrderedIntList(int size)
	{
		array = new int[size];
		count = 0;
	}
	
	/** 
	 * Insert unique integer into the array
	 *  @param value	integer added to array
	 */
	public void insert(int value) 
	{
		int insertIndex = 0;
		// find insert location
		for (int index = 0; index < count && value > array[index]; index++)
			insertIndex++;		
		// insert value, do nothing if value is not unique
		if (array[insertIndex] != value)
		{
			//shift memory down
			int startIndex = count; //the largest index to shift is 9
			for (int index = startIndex; index > insertIndex; index--)
				array[index] = array[index - 1];
			
			array[insertIndex] = value; // store data
			count ++; // increment count

			if (count == array.length)
			{	// create a temporary array 
				int[] temp = array.clone();
				int tempLength = array.length;
				// re-initialize array with new length
				array = new int[tempLength*3/2];
				// transfer data from temporary array to array
				for (int index = 0; index < count; index++)
					array[index] = temp[index];
			}
		}
	}
	
	/** 
	 * size - return the size of the array
	 * @return the size of the array
	 */
	public int size()
	{
		return array.length;	// return the number of elements in the array
	}
	
	/**
	 * length - return the current length of the list 
	 * @return count
	 */
	public int length()
	{
		return count; // return the length of the array
	}
	
	/**
	 * search - method that recursively search for integer in the array using 
	 * binary search method
	 * @param sortedArray is the array where search is performed on
	 * @param searchInt is the target search 
	 * @param low is the lower bound of search range
	 * @param high is the upper bound of search range
	 * @return the index where the integer is found, if index is not found return -1
	 */
	private int search (int[] sortedArray, int searchInt, int start, int end)
	{
		// base case 
		if (start > end)
			return -1;	
		// recursive case
		int mid = (start + end)/2;
		if (array[mid] == searchInt)
			return mid;		// returns the index where search is found
		else if (array[mid] < searchInt)
			// recursively call search in the (mid + 1) to high range
			return  search(sortedArray, searchInt, mid + 1, end);
		else
			// recursively call search in the low to (mid - 1) range
			return search(sortedArray, searchInt, start, mid - 1);
	}
	/**
	 * delete - use private method search to look for an integer in the array,
	 * if it is found, remove it from the array
	 * @param key
	 */
	
	public void delete (int key)
	{
		// call search() to find if key is in the array
		int location = search(array, key, 0, count);
		// if key is NOT in the array:
		if (location == -1)
			System.out.println("Integer " + key + " is not in the array");
		// else, if key is the array:
		else
		{
			// shift memory up
			for (int moveIndex = location; moveIndex < count; moveIndex++)
				array[moveIndex] = array [moveIndex + 1];
			count = count - 1; // adjust the size of the array
			
			// decreases the size of the array if count < (array.length)/2
			int tempLength = array.length;
			if ((count * 2) < tempLength)
			{	
				// create a temporary array
				int[] temp = array.clone();	
				// re-initialize array with new length
				array = new int[tempLength*6/10];
				for (int index = 0; index < count; index ++)
					// copy over the content of temporary array back to array
					array[index] = temp[index];			
			}
		}
	}
	
	/**
	 * toString - create a string the shows the content of the array
	 * @return the content of the array
	 */
	public String toString()
	{
		String str = "";
		for (int index = 0; index < count; index++)
		{
			if (index != 0 && index % 5 == 0)
				str += "\n";
			str += array[index];
			str += " ";
			
		}
		return str;
	}
}