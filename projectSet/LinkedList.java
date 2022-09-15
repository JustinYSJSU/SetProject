package set;

public class LinkedList 
{
	private Node head;
	private Node tail;
	
	/*
	 * Constructs a LinkedList
	 * 
	 * @param head The first element (head) of the LinkedList
	 */
	public LinkedList(Node head)
	{
		//initializes the head and the tail 
		this.head = head;
		this.tail = head;
		
	}
	
	/*
	 * Checks to see if the given node already exists in the LinkedList
	 * Worst case: O(n) because you would have to go through every node
	 * PART D OF THE PROJECT OUTLINE
	 * 
	 * @param check The node to check for
	 * @return true If the given nodes already exists
	 * @return false If the given node does not yet exist
	 */
	public boolean checkExistence(Node check)
	{
		long time1 = System.currentTimeMillis();
		boolean found = false;
		if(this.head != null && this.tail != null) //making sure the list isn't empty
		{
			Node first = this.head; //start checking from the head
			if(first.getData().equalsIgnoreCase(check.getData())) //checks the head to see if it contains the data
			{
				return true;
			}
			while(found == false && first.getNextNode() != null) //if not in the head, check the rest of the list
			{
				if(found == true) //if the data is found, break the while loop
				{
					break;
				}
				first = first.getNextNode(); //goes through each node 
				if(first.getData().equalsIgnoreCase(check.getData())) //checking the current node to see if it contains the data 
				{
					found = true;
				}
			}
		}
		long time2 = System.currentTimeMillis();
		getTime(time1, time2);
		return found;
	}
	
	/*
	 * Adds a new node to the LinkedList. It will be added before the head and will not be added
	 * if it already exists in the LinkedList
	 * PART A OF THE PROJECT OUTLINE
	 * Worst Case: O(1), always adding to head 
	 * @param n Node to be added
	 * 
	 */
	public void addNode(Node n)
	{
		long time1 = System.currentTimeMillis();
		if(this.checkExistence(n) == false) //n is not already in the LinkedList, can add
		{ 
			if(this.isEmpty() == true) //list is empty
			{
				this.head = n;
				this.tail = n;
			}
			else //list is not empty
			{
				n.setNextNode(this.head); //sets the current head to be after n, putting n before the head
				this.head = n; //sets the new head to n
				if(n.getNextNode().getNextNode() == null) //if the node after the next is null, it means that n.next should be the tail
				{
				   tail = n.getNextNode();
				   tail.setNextNull(); //tail.next must be null
				}
			}
		}
		long time2 = System.currentTimeMillis();
		getTime(time1, time2);
	}

	/*
	 * Removes a specific node from the LinkedList
	 * PART B OF THE PROJECT OUTLINE
	 * Worst Case: O(n) since you would have to go to the very end of the list to remove
	 * @param s The data that the node to be removed contains
	 * 
	 */
	public void removeNode(Node n)
	{
		long time1 = System.currentTimeMillis();
		if(checkExistence(n) == false) //node is not in the list
		{
			return;
		}
		
		if(this.isEmpty() == true) //list is empty
		{
			return;
		}
		
		if(this.head.getData().equalsIgnoreCase(n.getData())) //data is in the head, so remove it
		{
			if(this.head.getData().equalsIgnoreCase(this.tail.getData())) //only one element in the list
			{
				//sets head and tail to null
				this.head = null;
				this.tail = null;
			}
			else //more than one element
			{
				this.head = this.head.getNextNode(); //sets the head to the next node
			}
		}
		else //data is not in the head
		{
			Node current = this.head;
			while(!(current.getNextNode().getData().equalsIgnoreCase(n.getData()))) //While the next node doesn't have the data
			{
				current = current.getNextNode(); //advance through the LinkedList	
			}
			//Sets the node after current to the node that was after current.next, essentially skips over current.next(the one that has the data)
			current.setNextNode(current.getNextNode().getNextNode()); 		
			if(head.getNextNode() == null) //only one node left after removing
			{
				//sets the head and the tail to be the same, and then null to be after the tail
				this.tail = this.head;
				this.tail.setNextNull();
			}
		}
		long time2 = System.currentTimeMillis();
		getTime(time1, time2);
	}
	
	/*
	 * Returns the number of nodes in the LinkedList
	 * PART C OF THE PROJECT OUTLINE
	 * Worse Case: O(n) because you need to count every node
	 * @return number of nodes in the LinkedList
	 * 
	 */
	public int nodeCount()
	{
		long time1 = System.currentTimeMillis();
		int counter = 0;
		if(this.isEmpty() == true) //list is empty, return 0
		{
			return 0;
		}
		else if(this.head.getData() == this.tail.getData()) //only one node, return 1
		{
			return 1;
		}
		else //more than one node 
		{
			Node current = this.head;
			counter++;
			while(current.getNextNode() != null)
			{
				current = current.getNextNode();		
				counter++;
			}
		}
		long time2 = System.currentTimeMillis();
		getTime(time1, time2);
		return counter;
	}
	
	/*
	 * Returns the union of two LinkedLists
	 * 
	 * PART F OF THE PROJECT OUTLINE
	 * Worst Case: O(m + n) because you would have to add every single element from both lists
	 * @return the union of two LinkedLists
	 * 
	 */
	public LinkedList getUnion(LinkedList l)
	{
		long time1 = System.currentTimeMillis();
		LinkedList union;
		if(this.isEmpty() == true && l.isEmpty() == true) //both lists are empty
		{
			return new LinkedList(null); //"union" is empty as well
		}
		else if(this.isEmpty() == true || l.isEmpty() == true) //One of the lists is empty, return the non empty one
		{
			if(this.isEmpty() != true)
			{
				return this;
			}
			return l;
		}
		
		//Neither of the lists are empty
		
		//getting items from first array
		String[] allItems = this.toString().split(" "); //create an array of the items in the linked list
		union = new LinkedList(new Node(allItems[0])); //initialize the union with the first item
		for(int i = 1; i < allItems.length; i++) //go through rest of array, items will be added if they're not duplicates
		{
			union.addNode(new Node(allItems[i]));
		}
		
		//getting items from second array
		String[] allItems2 = l.toString().split(" "); //create an array of the items in the linked list
		for(int i = 0; i < allItems2.length; i++) //go through the entire array, items will be added if they're not duplicates
		{
			union.addNode(new Node(allItems2[i]));
		}
		long time2 = System.currentTimeMillis();
		getTime(time1, time2);
		return union;
	}
	
	/*
	 * Returns the intersection of two LinkedLists
	 * PART F OF THE PROJECT OUTLINE
	 * Worst Case: O(n) because at worst, you have to go through every item of one set and check if it is in the other set
	 * @return the intersection of two LinkedLists
	 * 
	 */
	public LinkedList getIntersection(LinkedList l)
	{
		long time1 = System.currentTimeMillis();
		if(this.isEmpty() == true && l.isEmpty() == true) //both lists are empty
		{
			return new LinkedList(null); //"intersection" is empty as well
		}
		else if(this.isEmpty() == true || l.isEmpty() == true) //One of the lists is empty, intersection is empty
		{
			return new LinkedList(null);
		}
		
		//Neither of the lists are empty
		
		LinkedList intersection = new LinkedList(null);
		boolean firstAdd = true; //true if intersection hasn't had anything added to it, false otherwise
		String[] allItems = this.toString().split(" "); //creates an array of the items in the linked list 
		for(int i = 0; i < allItems.length; i++) //go through the first array
		{
			Node current = new Node(allItems[i]); //the node that has the data current being inspected by the for loop
			if(l.checkExistence(current) == true) //the node is in the first and second array, add to intersection
			{
			   if(firstAdd == true) //list is empty, need to get rid of the dummy node
			   {
				 intersection.head = current; //gets rid of the "dummy node" by setting the head / tail to the first item added into intersection
				 intersection.tail = current; 
				 firstAdd = false; //not the first add anymore
			   }
			   else //not the first addition, can add normally
			   {
					intersection.addNode(current);
			   }
			  
			}
		}
		long time2 = System.currentTimeMillis();
		getTime(time1, time2);
		return intersection;	
	}
	
	/*
	 * Returns a Node that contains the specified item
	 * PART E OF THE PROJECT OUTLINE
	 * Worst Case: O(n) because you would have to go to the end of the LinkedList
	 * @param n the node that is being searched for
	 * 
	 * @return node that contains the item
	 * @return null if the node is not found
	 * 
	 */
	public Node search(Node n)
	{
		long time1 = System.currentTimeMillis();
		if(this.head != null && this.tail != null) //making sure the list isn't empty
		{
			Node first = this.head; //start checking from the head
			if(first.getData().equalsIgnoreCase(n.getData())) //checks the head to see if it contains the data
			{
				  return first;
			}
			while(first.getNextNode() != null) //if not in the head, check the rest of the list
			{
				first = first.getNextNode(); //goes through each node 
				if(first.getData().equalsIgnoreCase(n.getData())) //checking the current node to see if it contains the data 
				{
				   return first;
				}
			}
		}
		long time2 = System.currentTimeMillis();
		getTime(time1, time2);
		return null;
	}
	
	/*
	 * Returns a String with each item's data in the LinkedList
	 * 	
	 * @return a String with each item's data in the LinkedList
	 * (Ex: If the LinkedList is [Hi -> I -> Am], then this method will return the string "Hi I am"
	 * 
	 */
	public String toString()
	{
		String toString = "";
		if(this.head == null && this.tail == null) //empty list
		{
			return " ";
		}
		else if(this.head.getData() == this.tail.getData()) //only one node
		{
			return this.head.getData();
		}
		else //more than one node
		{
			Node current = this.head;
			toString += current.getData() + " ";
			while(current.getNextNode() != null)
			{
				current = current.getNextNode();		
				toString += current.getData() + " ";
			}
		}
		return toString;
	}
	
	/*
	 * Returns the head of the LinkedList
	 * 
	 * @return head of the LinkedList
	 * 
	 */
	public Node getHead()
	{
		return this.head;
	}
	
	/*
	 * Returns the tail of the LinkedList
	 * 
	 * @return tail of the LinkedList
	 * 
	 */
	public Node getTail()
	{
		return this.tail;
	}
	
	/*
	 * Returns the time taken for a function to run in milliseconds
	 * 
	 * @param time1 the time before the function runs
	 * @param time2 the time after the function runs
	 * 
	 * @return the time from the start time to end time in milliseconds
	 * 
	 */
	public long getTime(long time1, long time2)
	{
		return time2 - time1;
	}
	
	/*
	 * Checks if the list is empty
	 * 
	 * @return true if empty
	 * @return false if not empty
	 * 
	 */
	public boolean isEmpty()
	{
		if(this.head == null && this.tail == null)
		{
			return true;
		}
		return false;
	}
}
