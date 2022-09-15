package set;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTestCase 
{
	Node a = new Node("A");
	Node b = new Node("B");
	LinkedList testCheckExistence = new LinkedList(a);
	LinkedList empty = new LinkedList(null);
	
	@Test
	//Testing the testCheckExistence method
	public void testCheckExistance()
	{
	    //TESTING CHECKING FOR A EMPTY LIST
	   /*
		*empty.checkExistence(a) should return false because a is not the the list, so assertEquals will return true
		*/
		assertEquals(false, empty.checkExistence(a));
		
	    //TESTING CHECKING FOR A NODE THAT IS IN A NON - EMPTY LIST
		/*
		 *testCheckExistence.checkExistence(a) should return true because a is in the list, so assertEquals will return true
		 */
		System.out.println("SET: A");
		System.out.println("SEARCHING FOR 'A': " + testCheckExistence.checkExistence(a));	
		System.out.println();
		assertEquals(true, testCheckExistence.checkExistence(a));
		
		//TESTING CHECKING FOR A NODE THAT IS NOT IN A NON - EMPTY LIST
		/*
		 * testCheckExistence.checkExistence(b) should return false because b is not in the list
		 */
		System.out.println("SET: " + testCheckExistence.toString());
		System.out.println("SEARCHING FOR 'B': " + testCheckExistence.checkExistence(b));	
		System.out.println();
		assertEquals(false, testCheckExistence.checkExistence(b));
	}
 
	Node aa = new Node("AA");
	Node bb = new Node("BB");
	LinkedList testAddNode = new LinkedList(aa);
	LinkedList empty2 = new LinkedList(null);
	
	@Test
	//Testing the addNode method
	public void testAddNode()
	{
		
		//TESTING TRYING TO ADD A NODE THAT ALREADY EXISTS
		testAddNode.addNode(aa); //trying to add a node that already exists
		/*
		 * assertEquals will return true because aa should be the only node in the list, duplicates are not added and aa was the only item in the list
		 */
		assertEquals("AA", testAddNode.toString());
		
		System.out.println("SET: " + testAddNode.toString());
		System.out.println("Adding 'BB' to the set");
		testAddNode.addNode(bb); //trying to add a node that doesn't exist yet in the list
		System.out.println("SET: " + testAddNode.toString());
		System.out.println();
		
		/*
		 * assertEquals will return true because bb should be added into the list in front of aa because it did not yet exist in the list
		 */
		assertEquals("BB AA ", testAddNode.toString());
		
		//TESTING ADDING INTO AN EMPTY LIST
		empty2.addNode(aa); //trying to add into an empty list
		/*
		 * assertEquals will return true becuase aa should be added into the empty list, making it the only node in the list
		 */
		assertEquals("AA", empty2.toString());
	}
	
	Node one = new Node("One");
	Node two = new Node("Two");
	Node three = new Node("Three"); 
	Node four = new Node("Four");
	LinkedList testRemoveNode = new LinkedList(one);
	
	Node onlyOne = new Node("Only");
	LinkedList only = new LinkedList(onlyOne); //list with only one element
	@Test
	//Testing the removeNode method
	public void testRemoveNode()
	{
	    //TESTING REMOVING THE ONLY ELEMENT IN THE LIST
		only.removeNode(onlyOne);
		/*
		 * assertEquals should return true because there should be no more items in the list after removing the only element
		 */
		assertEquals(" ", only.toString());
		
		//TESTING REMOING FROM AN EMPTY LIST
		empty.removeNode(one);
		/*
		 * assertEquals should return true because there are no nodes to remove in the empty list
		 */
		assertEquals(" ", empty.toString());
		
		//TESTING REMOVING A NODE THAT IS NOT IN THE LIST
		testRemoveNode.addNode(two);
		testRemoveNode.addNode(three);
		testRemoveNode.removeNode(four);
		/*
		 * assertEquals should return true because the node "four" cannot be removed from the list as it was never in it
		 */
		assertEquals("Three Two One ", testRemoveNode.toString());
		
		//TESTING REMOVING FROM THE HEAD
		testRemoveNode.removeNode(testRemoveNode.getHead());
		/*
		 * assertEquals should return true because the head ("Three") should be removed
		 */
		assertEquals("Two One ", testRemoveNode.toString());
		
		//TESTING REMOVINNG FROM SOMEWHERE OTHER THAN THE HEAD
		System.out.println("SET: " + testRemoveNode.toString());
		
		testRemoveNode.removeNode(one); //removing the tail
		System.out.println("REMOVING 'One' from the set: " + testRemoveNode.toString());
		System.out.println();
		
		/*
		 * assertEquals should return true because a node other than the head should be removed
		 */
		assertEquals("Two", testRemoveNode.toString());
	}
	
	Node lone = new Node("Lone");
	LinkedList alone = new LinkedList(lone); //list with only one item
	Node first = new Node("First");
	Node second = new Node("Second");
	Node third = new Node("Third");
	LinkedList more = new LinkedList(first);
	@Test
	public void testNodeCount()
	{
		//TESTING THE COUNT FOR AN EMPTY LIST
		/*
		 * assertEquals should return true because there should be zero items in the list
		 */
		assertEquals(0, empty.nodeCount());
		
		//TESTING THE COUNT FOR A LIST WITH ONE ITEM
		/*
		 * assertEquals should return true because there should only be one item in the list
		 */
		assertEquals(1,alone.nodeCount());
		
		//TESTING THE COUNT FOR A LIST WITH MORE THAN ONE ITEM
		/*
		 * assertEquals should return true becuase there are 3 items in the list
		 */
		more.addNode(second);
		more.addNode(third);
		System.out.println("SET: " + more.toString());
		System.out.println("SIZE SIZE: " + more.nodeCount());
		System.out.println();
		assertEquals(3, more.nodeCount());
	}
	
	LinkedList emptyAgain = new LinkedList(null);
	Node cat = new Node("Cat");
	Node dog = new Node("Dog");
	Node fish = new Node("Fish");
	LinkedList pet1 = new LinkedList(cat);
    Node bird = new Node("Bird");
    Node snake = new Node("Snake");
    Node wolf = new Node("Wolf");
    LinkedList pet2 = new LinkedList(bird);
	@Test
	public void testGetUnion()
	{
		//TESTING THE UNION BETWEEN TWO EMPTY LISTS
		/*
		 * assertEquals should return true because the union should be blank between two empty lists
		 */
		assertEquals(" ", empty.getUnion(emptyAgain).toString());
		
		//TESTING THE UNION BETWEEN ONE EMPTY / ONE NON - EMPTY SET
		/*
		 * assertEquals should return true because the union should just be the non - empty set
		 */
		pet1.addNode(dog);
		pet1.addNode(fish);
	
		assertEquals("Fish Dog Cat ", empty.getUnion(pet1).toString());
		
		//TESTING THE UNION BETWEEN TWO NON - EMPTY SETS
		/*
		 * assertEquals should equal true because the union should be the elements of each set with no duplicates
		 */
		pet2.addNode(snake);
		pet2.addNode(wolf);
		pet2.addNode(cat); //testing: this should not appear twice in the union
		System.out.println("SET #1: " + pet1.toString());
		System.out.println("SET #2: " + pet2.toString());
		System.out.println("UNION BETWEEN SET #1 AND #2: " + pet1.getUnion(pet2).toString());
		System.out.println();
		assertEquals("Bird Snake Wolf Cat Dog Fish ", pet1.getUnion(pet2).toString());
	}
	
	Node golf = new Node("Golf");
	Node basketball = new Node("Basketball");
	Node baseball = new Node("Baseball");
	LinkedList sports1 = new LinkedList(golf);
	Node tennis = new Node("Tennis");
	Node swimming = new Node("Swimming");
	Node football = new Node("Football");
	LinkedList sports2 = new LinkedList(tennis);
	Node basketball2 = new Node("Basketball");
	Node baseball2 = new Node("Baseball");
	@Test
	public void testGetIntersection()
	{
		//TESTING THE INTERSECTION BETWEEN TWO EMPTY LISTS
		/*
		 * assertEquals should return true because the intersection between two empty sets is nothing
		 */
		
		assertEquals(" ", empty.getIntersection(emptyAgain).toString());
		
		//TESTING THE INTERSECTION BETWEEN ONE EMPTY LIST AND ONE NON EMPTY LIST
		/*
		 * assertEquals should return true because the intersection between an empty list and non - empty list is nothing
		 */
		assertEquals(" ", empty.getIntersection(sports1).toString());
		
		//TESTING THE INTERSECTION OF TWO NON EMPTY LISTS THAT HAVE NOTHING IN COMMON
		sports1.addNode(basketball);
		sports1.addNode(baseball);
		sports2.addNode(swimming);
		sports2.addNode(football);
		/*
		 * assertEquals should return true because the two sets have nothing in common
		 */
		assertEquals(" ", sports1.getIntersection(sports2).toString());
		
		//TESTING THE INSERSCTION OF TWO NON EMPTYS LISTS THAT HAVE THINGS IN COMMON
		sports2.addNode(baseball2);
		sports2.addNode(basketball2); //these are in sports1 as well, should be in intersection
		System.out.println("SET #1: " + sports1.toString());
		System.out.println("SET #2: " + sports2.toString());
		System.out.println("INTERSECTION BETWEEN SET #1 AND SET #2: " + sports1.getIntersection(sports2).toString());
		System.out.println();
		
		/*
		 * assertEquals should be true because both sets contian basketball and baseball
		 */
		assertEquals("Basketball Baseball ", sports1.getIntersection(sports2).toString());
	}
	
	Node searchFor = new Node("Hi");
	Node notThis = new Node("Hello");
	Node notThis2 = new Node("Hey");
	Node notIn = new Node("Bye");
	LinkedList testSearch = new LinkedList(searchFor);
	@Test
	public void testSearch()
	{
		//TESTING SERACHING AN EMPTY LIST
		/*
		 * assertEquals should return true because null should be returned if the node isn't found, which is the case if the list is empty
		 */
		assertEquals(null, empty.search(searchFor));
		
		//TESTING A SUCCESSFUL SEARCH
		testSearch.addNode(notThis);
		testSearch.addNode(notThis2);
		/*
		 * assertEquals should equal true because the node should be found
		 */
		System.out.println("SET: " + testSearch.toString());
		System.out.println("SEARCHING FOR 'Hi': " + testSearch.search(searchFor).getData());
		assertEquals(searchFor, testSearch.search(searchFor));
		System.out.println();
		
		//TESTING AN UNSUCCESSFUL SEARCH
		/*
		 * assertEquals should return true because null should be returned if the node isn't found, which is the case if the list doesn't have the node
		 */
		assertEquals(null, testSearch.search(notIn));
		
	}
}