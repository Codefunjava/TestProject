package com.fcy.test02;

import java.util.ArrayList;
import java.util.List;

class Node {
	public long data;
	public Node leftChild;
	public Node rightChild;
	/**
	 * 构造方法
	 * @param data
	 */
	public Node(long data){
		this.data=data;
	}
}

class Tree {
	//根节点
	Node root;
	/**
	 * 插入节点
	 * 
	 */
	public void insert(long value){
		Node newNode=new Node(value); 			//新建一个节点
		Node current=root;			//根节点为当前节点
		Node parent;				//定义父节点
		if(root==null){			//root为null，表示第一次插入
			root=newNode;
			return ;
		}else{
			while(true){				//循环到到插入点
				parent=current; 
				if(current.data>value){ //当前指向的节点数据比插入的要大时，插入到左子树
					current=current.leftChild;	//当前节点指向左子树
					if(current==null){		//表示左子树为空，此时可以插入了
						parent.leftChild=newNode;		//插入到左子树
						return;
					}
				}else{//当前指向的节点数据比插入的要小时，插入到右子树
					current=current.rightChild; //当前节点指向右子树	
					if(current==null){	//右子树不为空时，表示可以插入
						parent.rightChild=newNode; //插入到右子树
						return;
					}
				}
			}
		}
	}
	/**
	 * 查找节点
	 */
	public Node find(long value){
		Node current=root;	//当前节点指向根节点，引用传递
		while(current.data!=value){ //查找值不等于当前节点节点的数据项时，循环查找
			if(current.data>value){ //进行比较，比较查找值和当前节点的大小
				current=current.leftChild; //若大于，则在左子树上查找
			}else{//否则在右子树上进行查找
				current=current.rightChild;
			}
			//如果为空
			if(current==null){							//未找到
				return null;
			}
		}
		return current;
	}
	
	/**
	 * 中序遍历
	 */
	//递归中序遍历
	public List<Node> inOrder(Node localNode){
		List<Node> list=new ArrayList<Node>();
		if(localNode !=null){
			inOrder(localNode.leftChild);	//中序遍历左子树
			list.add(localNode);	//访问根节点
			inOrder(localNode.rightChild); //中序遍历右子树
		}
		return list;
	}
	
	public long fun(Node n){
		List<Node> list=inOrder(n);
		for(Node n0:list){
			System.out.println(n0.data);
		}
		return list.get(0).data-list.get(list.size()-1).data;
	}
}

public class Test06 {
	public static void main(String args[]){
		Tree tree=new Tree();
		tree.insert(10);
		tree.insert(20);
		tree.insert(15);
		System.out.println(tree.fun(tree.root));
	}
}
