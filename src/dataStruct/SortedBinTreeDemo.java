package dataStruct;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
class SortedBinTree<T extends Comparable>{
	//节点类
	static class Node{
		Object data;     //数据域
		Node parent;     //父节点
		Node left;       //左子节点
		Node right;		 //右子节点
		public Node(Object data,Node parent,Node left,Node right){
			this.data=data;
			this.parent=parent;
			this.left=left;
			this.right=right;
		}
		public String toString(){
			return "[data="+data+"]";
		}
		public boolean equals(Object obj){
			if(this==obj){
				return true;
			}
			if(obj.getClass()==Node.class){
				Node target=(Node) obj;
				return data.equals(target.data)
						&& left==target.left
						&& right==target.right
						&& parent==target.parent;
			}
			return false;
		}
	}
	private Node root;
	public SortedBinTree(){
		root=null;
	}
	public SortedBinTree(T o){
		root=new Node(o,null,null,null);
	}
	//添加节点
	public void add(T ele){
		if(root==null){   //根节点为空
			root=new Node(ele ,null,null,null);
		}else{
			Node current=root;
			Node parent=null;
			int cmp=0;
			//搜索合适的叶子节点，以该叶子节点为父节点添加新节点
			do{
				parent=current;
				cmp=ele.compareTo(current.data);
				if(cmp>0){
					//以右子节点为当前节点
					current=current.right;
				}else{
					//以左子节点为当前节点
					current=current.left;
				}
			}while(current!=null);
			//创建节点
			Node newNode=new Node(ele,parent,null,null);
			if(cmp>0){
				//新节点作为父节点的右子节点
				parent.right=newNode;
			}else{
				//新节点作为父节点的左子节点
				parent.left=newNode;
			}
		}
	}
	//删除结点
	public void remove(T ele){
		//获取要删除的节点
		Node target=getNode(ele);
		if(target==null){
			return;
		}
		//要删除节点的左、右子树都为空
		if(target.left==null&&target.right==null){
			if(target==root){  //删除的是根节点
				root=null;
			}else{
				//要删除节点是父节点的左子节点
				if(target==target.parent.left){
					//将target的父节点的left设为null
					target.parent.left=null;
				}else{ //要删除节点是父节点的右子节点
					//将target的父节点的right设为null
 					target.parent.right=null;
				}
				target.parent=null;
			}
		//要删除节点只有右子树
		}else if(target.left==null&&target.right!=null){
			if(target==root){   //删除的是根节点
				root=target.right;
			}else{
				//要删除节点是父节点的左子节点
				if(target==target.parent.left){
					//让target的父节点的left指向target的右子树
					target.parent.left=target.right;
				}else{//要删除节点是父节点的右子节点
					//让target的父节点的right指向target的右子树
					target.parent.right=target.right;
				}
				//让target的右子树的parent指向taregt的parent
				target.right.parent=target.parent;
			}
		//如果要删除节点只有左子树
		}else if(target.left!=null && target.right==null){
			if(target==root){  //删除的是根节点
				root=target.left;
			}else{ 
				//被删除节点的父节点是左子节点
				if(target==target.parent.left){
					//让target的父节点的left指向target的左子树
					target.parent.left=target.left;
				}else{
					//让target的父节点的right指向target的右子树
					target.parent.right=target.left;
				}
				//让target的左子树的parent指向target的parent
				target.left.parent=target.parent;
			}
		//要删除节点既有左子树，又有右子树
		}else{
			Node leftMaxNode=target.left;	//找左子节点
			if(leftMaxNode.right!=null){    //左子节点的右子树不为空
				while(leftMaxNode.right!=null){
					leftMaxNode=leftMaxNode.right;
				}
				if(leftMaxNode.left!=null){
					Node currentNode=leftMaxNode;
					while(currentNode.left!=null){
						currentNode=currentNode.left;
					}
					currentNode.left=target.left;
				}else{
					leftMaxNode.left=target.left;  
				}
				leftMaxNode.parent.right=null;
			}
			if(target!=root){            //删除节点为根节点
				leftMaxNode.parent=target.parent;
				if(target==target.parent.left){
					target.parent.left=leftMaxNode;
				}else{
					target.parent.right=leftMaxNode;
				}
				target.parent=null;
			}else{
				root=leftMaxNode;
			}
			leftMaxNode.right=target.right;
			target.left=target.right=null;
		}
		
	}
	//根据给定的值搜索节点
	public Node getNode(T ele){
		Node p=root;
		while(p!=null){
			int cmp=ele.compareTo(p.data);
			if(cmp<0){
				p=p.left;
			}else if(cmp>0){
				p=p.right;
			}else{
				return p;
			}
		}
		return null;
	}
	//求二叉樹高
	public int HeightBT(){
		return HeightBT(root);
	}
	private int HeightBT(Node root) {
		if (root == null) {
			return 0;
		} else {
			int LH = HeightBT(root.left); // 求根节点左子树的高度
			int RH = HeightBT(root.right); // 求根节点右子树的高度
			if (LH > RH) {
				return LH + 1;
			} else {
				return RH + 1;
			}
		}
	}
	//广度优先遍历
	public List<Node> breadthFirst(){
		Queue<Node> queue=new ArrayDeque<Node>();
		List<Node> list=new ArrayList<Node>();
		if(root!=null){
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			list.add(queue.peek());
			Node p=queue.poll();
			if(p.left!=null){
				queue.offer(p.left);
			}
			if(p.right!=null){
				queue.offer(p.right);
			}
		}
		return list;
	}
	
	//树的递归先序遍历
	public List<Node>preIterator(){
		return preIterator(root);
	}
	private List<Node> preIterator(Node node){
		List<Node> list=new ArrayList<Node>();
		list.add(node);
		if(node.left!=null){
			list.addAll(preIterator(node.left));
		}
		if(node.right!=null){
			list.addAll(preIterator(node.right));
		}
		return list;
	}
	//树的递归中序遍历
	public List<Node>inIterator(){
		return inIterator(root);
	}
	private List<Node> inIterator(Node node){
		List<Node> list=new ArrayList<Node>();
		if(node.left!=null){
			list.addAll(inIterator(node.left));
		}
		list.add(node);
		if(node.right!=null){
			list.addAll(inIterator(node.right));
		}
		return list;
	}
	//树的递归后序遍历
	public List<Node>postIterator(){
		return postIterator(root);
	}
	private List<Node> postIterator(Node node){
		List<Node> list=new ArrayList<Node>();
		if(node.left!=null){
			list.addAll(postIterator(node.left));
		}
		if(node.right!=null){
			list.addAll(postIterator(node.right));
		}
		list.add(node);
		return list;
	}
	
	//非递归先序遍历
	public List<Node> preOrder(){
		return preOrder(root);
	}
	private List<Node> preOrder(Node localNode){
		Stack<Node> s=new Stack<Node>();
		List<Node> list=new ArrayList<Node>();
		while(localNode!=null||!s.isEmpty()){
			if(localNode!=null){
				list.add(localNode);
				s.push(localNode);
				localNode=localNode.left;
			}else{
				localNode=(Node) s.pop();
				localNode=localNode.right;
			}
		}
		return list;
	}
	//非递归中序遍历
	public List<Node> inOrder(){
		return inOrder(root);
	}
	private List<Node> inOrder(Node localNode){
		Stack<Node> s=new Stack<Node>();
		List<Node> list=new ArrayList<Node>();
		while(localNode!=null||!s.isEmpty()){
			if(localNode!=null){ //根指针进栈，遍历左子树
				s.push(localNode);
				localNode=localNode.left;
			}else{                 //根指针退栈
				localNode=(Node) s.pop();
				list.add(localNode);
				localNode=localNode.right; //遍历右子树
			}
		}
		return list;
	}
	//非递归后序遍历
	public List<Node> afterOrder(){
		return afterOrder(root);
	}
	private List<Node> afterOrder(Node localNode){
		Stack<Node> s=new Stack<Node>();
		List<Node> list=new ArrayList<Node>();
		Node q=null; //已经访问过且前一次栈的节点，若两者都不满足，则为null
		while(localNode!=null||!s.isEmpty()){
			if(localNode!=null){
				s.push(localNode);
				localNode=localNode.left;
			}else{
				localNode=(Node) s.peek();
				if(localNode.right==q){ //当前节点的右子树为空或已经访问过且已出栈，则访问当前节点
					q=(Node) s.peek();
					localNode=null;
					s.pop();
					list.add(q);
				}else{//右子树未访问，则访问右子树
					localNode=localNode.right;
					q=null;
				}
			}
		}
	   return  list;
	}	
}
public class SortedBinTreeDemo {
	public static void main(String[] args) {
		SortedBinTree<Integer> tree=new SortedBinTree<Integer>();
		tree.add(20);
		tree.add(40);
		tree.add(30);
		tree.add(50);
		tree.add(25);
		System.out.println(tree.breadthFirst());
		tree.remove(40);
		System.out.println(tree.breadthFirst());
		List<SortedBinTree.Node> list=tree.inIterator();
		for(SortedBinTree.Node n:list){
			System.out.print(n.data+" ");
		}
		System.out.println("\n"+tree.HeightBT());
	}
}

