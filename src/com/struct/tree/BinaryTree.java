package com.struct.tree;

public class BinaryTree<E extends Comparable<E>> {
	
	class TreeNode<E>{
		E element;
		TreeNode<E> left;
		TreeNode<E> right;
		
		public TreeNode(E e){
			element = e;
		}
	}
	
	protected TreeNode<E> root;
	protected int size = 0;
	
	public boolean search(E e){
		TreeNode<E> current = root;
		while(current != null){
			if(e.compareTo(current.element) < 0){
				current = current.left;
			}else if(e.compareTo(current.element) > 0){
				current = current.right;
			}else{
				return true;
			}
		}
		return false;
	}
	
	public boolean insert(E e){
		if(root == null){
			root = createNewNode(e);
		}else{
			TreeNode<E> parent = null;
			TreeNode<E> current = null;
			while(current != null){
				if(e.compareTo(current.element) < 0){
					parent = current;
					current = current.left;
				}else if(e.compareTo(current.element) > 0){
					parent = current;
					current = current.right;
				}else{
					return false;
				}
				if(e.compareTo(parent.element) < 0){
					parent.left = createNewNode(e);
				}else{
					parent.right = createNewNode(e);
				}
			}
			
		}
		size ++;
		return true;
	}
	
	public TreeNode<E> createNewNode(E e){
		return new TreeNode<E>(e);
	}
	
	public boolean delete(E e){
		TreeNode<E> parent = null;
		TreeNode<E> current = null;
		while(current != null){
			if(e.compareTo(current.element) < 0){
				parent = current;
				current = current.left;
			}else if(e.compareTo(current.element) > 0){
				parent = current;
				current = current.right;
			}else{
				break;
			}
			if(current == null){
				return false;
			}
			if(current.left == null){
				if(parent == null){
					root = current.right;
				}else{
					if(e.compareTo(parent.element) < 0){
						parent.left = current.right;
					}else{
						parent.right = current.right;
					}
				}
			}else{
				TreeNode<E> parentOfRightMost = current;
				TreeNode<E> rightMost = current.left;
				while(rightMost.right != null){
					parentOfRightMost = rightMost;
					rightMost = rightMost.right;
				}
				current.element = rightMost.element;
				if(parentOfRightMost.right == rightMost){
					parentOfRightMost.right = rightMost.left;
				}else{
					parentOfRightMost.left = rightMost.left;
				}
			}
		}
		size --;
		return true;
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}
	
}



