package set;

public class Node 
{
	private String data;
	private Node next;
	
	/*
	 * Constructs a Node
	 * 
	 * @param data The data the Node will carry
	 * 
	 */
	public Node(String data)
	{
		this.data = data;
	}

	/*
	 * Sets the node after the current node
	 * 
	 * @param data The data that the next node will carry
	 * 
	 */
	public void setNextNode(String data)
	{
		this.next = new Node(data);
	}
	
	/*
	 * Sets the node after the current node
	 * 
	 * @param n The node that will be after the current node
	 * 
	 */
	public void setNextNode(Node n)
	{
		this.next = n;
	}
	
	/*
	 * Sets the next node to null
	 * 
	 */
	public void setNextNull()
	{
		this.next = null;
	}
	
	/*
	 * Gets the data from the current node
	 * 
	 * @return data from current node
	 * 
	 */
	public String getData()
	{
		return this.data;
	}
	
	/*
	 * Gets the next node
	 * 
	 */
	public Node getNextNode()
	{
		return this.next;
	}
}
