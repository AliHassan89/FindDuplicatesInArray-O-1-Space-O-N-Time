/*
Find a duplicate, Space Edition™ BEAST MODE
In Find a duplicate, Space Edition™, we were given an array of integers where:

the integers are in the range 1..n1..n
the array has a length of n+1n+1
These properties mean the array must have at least 1 duplicate. Our challenge 
was to find a duplicate number, while optimizing for space. We used a divide and 
conquer approach, iteratively cutting the array in half to find a duplicate 
integer in O(n\lg{n})O(nlgn) time and O(1) O(1) space (sort of a modified binary 
search).

But we can actually do better. We can find a duplicate integer in O(n)O(n) time 
while keeping our space cost at O(1)O(1).

This is a tricky one to derive (unless you have a strong background in graph 
theory), so we'll get you started:

Imagine each item in the array as a node in a linked list. In any linked list, 
↴ each node has a value and a "next" pointer. In this case:

The value is the integer from the array.
The "next" pointer points to the value-eth node in the list (numbered starting 
from 1). For example, if our value was 3, the "next" node would be the third node.

 */
package findduplicateinarray;

import java.util.*;

/**
 *
 * @author Ali
 */
public class FindDuplicateInArray 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] arr = {2,2,1};
        List<Integer> duplicates = findDuplicates(arr);
        
        Iterator it = duplicates.iterator();
        
        while (it.hasNext())
        {
            System.out.print(it.next()+", ");
        }
    }
    
    /**
     * The solution runs in O(1) space and O(N) time
     * it runs like a map traversal. We are marking every node that we have 
     * visited as negative value. Since all the values of the array are going 
     * to be greater than or equal to 1, thus we can mark visited value in array
     * as negative value. While traversing if we come across a negative value 
     * then that means this value is a duplicate.
     * 
     * @param arr
     * @return 
     */
    private static List<Integer> findDuplicates(int[] arr)
    {
        Set<Integer> result = new HashSet<>();
        
        for (int i = 0; i<arr.length; i++)
        {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0)
            {
                result.add(Math.abs(arr[i]));
            }
            else
            {
                arr[index] *= -1; 
            }
        }
        
        return new ArrayList(result);
    }
}
