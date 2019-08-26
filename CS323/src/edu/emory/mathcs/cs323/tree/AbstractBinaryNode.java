package edu.emory.mathcs.cs323.tree;

public abstract class AbstractBinaryNode<T extends Comparable<T>, 
								N extends AbstractBinaryNode<T,N>>
{
	protected T key;
	protected N parent;
	protected N right_child;
	protected N left_child;
	
	public AbstractBinaryNode(T key)
	{	
		setKey(key);
	}
	
	// ======================Getters===========================================
	
	public T getKey() 
	{
		return this.key;
	}
	
	public N getParent() 
	{
		return this.parent;
	}
	
	public N getLeftChild()
	{
		return this.left_child;
	}
	
	public N getRightChild()
	{
		return this.right_child;
	}
	
	public N getGrandParent()
	{
		if (this.parent.hasParent())
			return this.parent.getParent();
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public N getSibling() 
	{
		if (hasParent())
		{
			N parent = getParent();
			return parent.isLeftChild((N)this) ? parent.getRightChild() : parent.getLeftChild();
		}
		
		return null;
	}
	
	public N getUncle() 
	{
		return this.hasParent() ? this.parent.getSibling() : null;
	}
	
	//=======================Setters===========================================

	public void setKey(T key)
	{
		this.key = key;
	}
	
	public void setParent(N node)
	{
		this.parent = node;
	}
	
	public void setLeftChild(N node)
	{
		replaceParent(node);
		this.left_child = node;
	}
	
	public void setRightChild(N node) 
	{
		replaceParent(node);
		this.right_child = node;
	}
	
	@SuppressWarnings("unchecked")
	public void replaceParent(N node) 
	{
		if (node != null)
		{
			if (node.hasParent()) node.getParent().replaceChild(node, null);
			node.setParent((N)this);
		}
	}
	
	public void replaceChild(N oldChild, N newChild)
	{
		if 		(isLeftChild(oldChild)) 	setLeftChild(newChild);
		else if (isRightChild(oldChild)) 	setRightChild(newChild);
	}
	
	//=======================Checks=============================================
	
	public boolean hasParent()
	{
		return this.parent != null;
	}
	
	public boolean hasLeftChild()
	{
		return this.left_child != null;
	}
	
	public boolean hasRightChild()
	{
		return this.right_child != null;
	}
	
	public boolean hasBothChildren() 
	{
		if (this.hasRightChild() && this.hasLeftChild())
			return true;
		return false;
	}
	
	public boolean isLeftChild(N node) 
	{
		return this.left_child == node;
	}
	
	public boolean isRightChild(N node) 
	{
		return this.right_child == node;
	}
	
	@Override
	public String toString()
	{
		return this.key + " -> (" + this.right_child + ", " + this.left_child + ")";
	}
}
