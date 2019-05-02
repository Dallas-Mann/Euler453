package problem453;

public class Node<KeyType extends Comparable<KeyType>, ValueType>
{
	private KeyType key;
	private ValueType value;
	private Node<KeyType, ValueType> leftChild;
	private Node<KeyType, ValueType> rightChild;
	
	public Node(KeyType key, ValueType value)
	{
		this.key = key;
		this.value = value;
		leftChild = null;
		rightChild = null;
	}
	
	public KeyType getKey()
	{
		return key;
	}
	
	public ValueType getValue()
	{
		return value;
	}
	
	public void setKey(KeyType newKey)
	{
		this.key = newKey;
	}
	
	public void setValue(ValueType newValue)
	{
		this.value = newValue;
	}
	
	public Node<KeyType, ValueType> getLeftChild()
	{
		return leftChild;
	}
	
	public void setLeftChild(Node<KeyType, ValueType> newLeftChild)
	{
		this.leftChild = newLeftChild;
	}
	
	public Node<KeyType, ValueType> getRightChild()
	{
		return rightChild;
	}
	
	public void setRightChild(Node<KeyType, ValueType> newRightChild)
	{
		this.rightChild = newRightChild;
	}
	
	public String toString()
	{
		return "(" + key.toString() + ", " + value.toString() + ")";
	}
}
