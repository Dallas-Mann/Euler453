package problem453;

public class BinarySearchTree<KeyType extends Comparable<KeyType>, ValueType>
{
	private boolean debugFlag = false;
	private Node<KeyType, ValueType> rootNode;
	
	public BinarySearchTree()
	{
		this.rootNode = null;
	}
	
	public BinarySearchTree(KeyType rootKey, ValueType rootValue)
	{
		this.rootNode = new Node<KeyType, ValueType>(rootKey, rootValue);
	}
	
	public void setDebug(boolean debugFlag)
	{
		this.debugFlag = debugFlag;
	}
	
	public void insert(KeyType key, ValueType value)
	{
		rootNode = insertHelper(rootNode, key, value);
	}
	
	public void remove(KeyType key)
	{
		rootNode = removeHelper(rootNode, key);
	}
	
	public Node<KeyType, ValueType> search(KeyType key)
	{
		return searchHelper(rootNode, key);
	}
	
	private Node<KeyType, ValueType> insertHelper(Node<KeyType, ValueType> parentNode, KeyType key, ValueType value)
	{
		if(parentNode == null)
		{
			Node<KeyType, ValueType> newNode = new Node<KeyType, ValueType>(key, value);
			if(debugFlag)
			{
				System.out.println("New Node: " + newNode.getValue() + "\n");
			}
			return newNode;
		}
		else
		{
			int compare = key.compareTo(parentNode.getKey());
			if(compare < 0)
			{
				if(debugFlag)
				{
					System.out.println("Insert Visit: " + parentNode.toString() + " setting left child.");
				}
				parentNode.setLeftChild(insertHelper(parentNode.getLeftChild(), key, value));
			}
			else if(compare > 0)
			{
				if(debugFlag)
				{
					System.out.println("Insert Visit: " + parentNode.toString() + " setting right child.");
				}
				parentNode.setRightChild(insertHelper(parentNode.getRightChild(), key, value));
			}
			else
			{
				if(debugFlag)
				{
					System.out.println("Insert Visit: " + parentNode.toString() + " replacing value.\n");
				}
				parentNode.setValue(value);
			}
			return parentNode;
		}
	}
	
	private Node<KeyType, ValueType> removeHelper(Node<KeyType, ValueType> parentNode, KeyType key)
	{
		if(parentNode == null)
		{
			if(debugFlag)
			{
				System.out.println("Remove: value not found");
			}
		}
		else
		{
			int compare = key.compareTo(parentNode.getKey());
			if(compare < 0)
			{
				if(debugFlag)
				{
					System.out.println("Remove Visit: " + parentNode.toString() + " descending left.");
				}
				parentNode.setLeftChild(removeHelper(parentNode.getLeftChild(), key));
			}
			else if(compare > 0)
			{
				if(debugFlag)
				{
					System.out.println("Remove Visit: " + parentNode.toString() + " descending right.");
				}
				parentNode.setLeftChild(removeHelper(parentNode.getRightChild(), key));
			}
			else
			{
				if(debugFlag)
				{
					System.out.println("Remove Visit: " + parentNode.toString() + " deleting value.\n");
				}
				
				// Case 1: Node has 0 children (Leaf Node)
				if(parentNode.getLeftChild() == null && parentNode.getRightChild() == null)
				{
					return null;
				}
				
				// Case 2: Node has 2 children
				else if(parentNode.getLeftChild() != null && parentNode.getRightChild() != null)
				{
					Node<KeyType, ValueType> predecessorNode = getMaxValue(parentNode.getLeftChild());
					
					parentNode.setKey(predecessorNode.getKey());
					parentNode.setValue(predecessorNode.getValue());
					
					parentNode.setLeftChild(removeHelper(parentNode.getLeftChild(), predecessorNode.getKey()));
					
					return parentNode;
				}
				
				// Case 3: Node has 1 child
				else
				{
					Node<KeyType, ValueType> childNode = parentNode.getLeftChild() != null ? parentNode.getLeftChild(): 
																							 parentNode.getRightChild();
					return childNode;
				}
			}
		}
		return parentNode;
	}
	
	private Node<KeyType, ValueType> searchHelper(Node<KeyType, ValueType> parentNode, KeyType key)
	{
		if(parentNode == null)
		{
			if(debugFlag)
			{
				System.out.println("Search Visit: missing value.\n");
			}
			return parentNode;
		}
		else
		{
			int compare = key.compareTo(parentNode.getKey());
			if(compare < 0)
			{
				if(debugFlag)
				{
					System.out.println("Search Visit: " + parentNode.toString() + " descending left.");
				}
				return searchHelper(parentNode.getLeftChild(), key);
			}
			else if(compare > 0)
			{
				if(debugFlag)
				{
					System.out.println("Search Visit: " + parentNode.toString() + " descending right.");
				}
				return searchHelper(parentNode.getRightChild(), key);
			}
			else
			{
				if(debugFlag)
				{
					System.out.println("Found Node: " + parentNode.toString() + "\n");
				}
				return parentNode;
			}
		}

	}
	
	private Node<KeyType, ValueType> getMaxValue(Node<KeyType, ValueType> parentNode)
	{
		while(parentNode.getRightChild() != null)
		{
			parentNode = parentNode.getRightChild();
		}
		return parentNode;
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree<Integer, Integer> BST = new BinarySearchTree<>();
		BST.setDebug(true);
		
		BST.insert(11,11);
		BST.insert(2,2);
		BST.insert(29,29);
		BST.insert(1,1);
		BST.insert(7,7);
		BST.insert(15,15);
		BST.insert(40,40);
		BST.insert(35,35);
		
		BST.search(35);
		BST.remove(11);
		BST.search(35);
		BST.remove(29);
		BST.search(40);
		System.out.println("done");
	}
}
