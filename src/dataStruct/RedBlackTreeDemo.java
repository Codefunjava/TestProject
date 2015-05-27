package dataStruct;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class RedBlackTree<T extends Comparable>{
	//定义红黑树的颜色
	private static final boolean RED=false;
	private static final boolean BLACK=true;
	static class Node{
		Object data;
		Node parent;
		Node left;
		Node right;
		//节点的默认颜色是黑色
		boolean color=BLACK;
		public Node(Object data,Node parent,Node left,Node right){
			this.data=data;
			this.parent=parent;
			this.left=left;
			this.right=right;
		}
		public String toString(){
			return "[data="+data+",color="+color+"]";
		}
		public boolean equals(Object obj){
			if(this==obj){
				return true;
			}
			if(obj.getClass()==Node.class){
				Node target=(Node)obj;
				return data.equals(target.data)
						&& color==target.color
						&& left==target.left
						&& right==target.right
						&& parent==target.parent;
			}
			return false;
		}
	}
	private Node root;
	public RedBlackTree(){
		root=null;
	}
	public RedBlackTree(T o){
		root=new Node(o,null,null,null);
	}
	//添加节点
	public void add(T ele){
		//如果根节点为空
		if(root==null){
			root=new Node(ele,null,null,null);
		}else{
			Node current=root;
			Node parent=null;
			int cmp=0;
			//搜索合适的叶子节点，以该叶子节点作为父节点添加新节点
			do{
				parent=current;
				cmp=ele.compareTo(current.data);
				//如果新节点的值大于当前节点的值
				if(cmp>0){
					//以右子节点为当前节点
					current=current.right;
				}else{    //如果新节点的值小于当前节点的值
					//以左子节点作为当前节点
					current=current.left;
				}
			}while(current!=null);
			//创建新节点
			Node newNode=new Node(ele,parent,null,null);
			//如果新节点的值大于父节点的值
			if(cmp>0){
				//新节点作为父节点的右子节点
				parent.right=newNode;
			}else{  //如果新节点的值小于父节点的值
				//新节点作为父节点的左子节点
				parent.left=newNode;
			}
			//维护红黑树
			fixAfterInsertion(newNode);
		}
	}
	//删除节点
	public void remove(T ele){
		//获取要删除的节点
		Node target=getNode(ele);
		//如果要删除节点的左子树、右子树都不为空
		if(target.left!=null&&target.right!=null){
			//找到tarage节点中序遍历的前一个节点
			//s用于保存target节点的左子树中值最大节点
			Node s=target.left;
			//搜索target节点的左子树中值最大的节点
			while(s.right!=null){
				s=s.right;
			}
			//用s节点来代替p节点
			target.data=s.data;
			target=s;
		}
		//开始修复它的替换节点，如果该替换节点不为null
		Node replacement=(target.left!=null?target.left:target.right);
		if(replacement!=null){
			//让replacement的parent指向target的parent
			replacement.parent=target.parent;
			//如果target的parent是null,则表明target本身是根节点
			if(target.parent==null){
				root=replacement;
			//如果target是其父节点的左子节点
			}else if(target==target.parent.left){
				//让target的父节点的left指向replacement
				target.parent.left=replacement;
			//如果target是其父节点的右子节点
			}else{
				//让target的父节点的rigth指向replacement
				target.parent.right=replacement;
			}
			//彻底删除target节点
			target.left=target.right=target.parent=null;
			//修复红黑树
			if(target.color==BLACK){
				fixAfterDeletion(replacement);
			}
		//target本身是根节点
		}else if(target.parent==null){
			root=null;
		}else{
			//target没有子节点，把它当成虚的替换节点
			//修复红黑树
			if(target.color==BLACK){
				fixAfterDeletion(target);
			}
			if(target.parent!=null){
				//如果target是其父节点的左子节点
				if(target==target.parent.left){
					//将target的父节点的left设为null
					target.parent.left=null;
				//如果target是其父节点的右子节点
				}else if(target==target.parent.right){
					//将target的父节点rigth设为null
					target.parent.right=null;
				}
				//将target的parent设为null
				target.parent=null;
			}
		}
	}
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
	//插入节点后修复红黑树
	private void fixAfterInsertion(Node x){
		x.color=RED;
		//直到x节点的父节点是其父节点的左子节点
		while(x!=null && x!=root && x.parent.color==RED){
			//如果x的父节点是其父节点的左子节点
			if(parentOf(x)==leftOf(parentOf(parentOf(x)))){
				//获得x的父节点的兄弟节点
				Node y=rightOf(parentOf(parentOf(x)));
				//如果x的父节点的兄弟节点是红色
				if(colorOf(y)==RED){
					//将x的父节点设置为黑色
					setColor(parentOf(x),BLACK);
					//将x的父节点的兄弟节点设置为黑色
					setColor(y,BLACK);
					//将x的父节点的父节点设置为红色
					setColor(parentOf(parentOf(x)),RED);
					x=parentOf(parentOf(x));
				//如果x的父节点的兄弟节点是黑色
				}else{
					//如果x是其父节点的右子节点
					if(x==rightOf(parentOf(x))){
						//将x的父节点设为x
						x=parentOf(x);
						rotateLeft(x);
					}
					//把x的父节点设为黑色
					setColor(parentOf(x),BLACK);
					//把x的父节点的父节点设为红色
					setColor(parentOf(parentOf(x)),RED);
					rotateRight(parentOf(parentOf(x)));
				}
			//如果x的父节点是其父节点的右子节点
			}else{
				//获得x的父节点的兄弟节点
				Node y=leftOf(parentOf(parentOf(x)));
				//如果x的父节点的兄弟节点是红色
				if(colorOf(y)==RED){
					//将x的父节点设为黑色
					setColor(parentOf(x),BLACK);
					//将x的父节点的兄弟节点设为黑色
					setColor(y,BLACK);
					//将x的父节点设为红色
					setColor(parentOf(parentOf(x)),RED);
					//将x设为x的父节点的节点
					x=parentOf(parentOf(x));
				//如果x的父节点的兄弟节点是黑色
				}else{
					//如果x是其父节点的左子节点
					if(x==leftOf(parentOf(x))){
						//将x的父节点设为x
						x=parentOf(x);
						rotateRight(x);
					}
					//把x的父节点设为黑色
					setColor(parentOf(x), BLACK);
					//把x的父节点的父节点设为红色
					setColor(parentOf(parentOf(x)), RED);
					rotateLeft(parentOf(parentOf(x)));
				}
			}
			//将根节点设为黑色
			root.color=BLACK;
		}
	}
	
	//删除节点后修复红黑树
	private void fixAfterDeletion(Node x){
		//直到x不是根节点，且x的颜色是黑色
		while(x!=root && colorOf(x)==BLACK){
			//如果x是其父节点的左子节点
			if(x==leftOf(parentOf(x))){
				//获取x节点的兄弟节点
				Node sib=rightOf(parentOf(x));
				//如果sib节点是红色
				if(colorOf(sib)==RED){
					//将sib节点设为黑色
					setColor(sib,BLACK);
					//将x的父节点设为红色
					setColor(parentOf(x),RED);
					rotateLeft(parentOf(x));
					//再次将sib设为x的父节点的右子节点
					sib=rightOf(parentOf(x));
				}
				//如果sib的两个子节点都是黑色
				if(colorOf(leftOf(sib))==BLACK && colorOf(rightOf(sib))==BLACK){
					//将sib设为红色
					setColor(sib,RED);
					//让x等于x的父节点
					x=parentOf(x);
				}else{
					//如果sib只有右子节点是黑色
					if(colorOf(rightOf(sib))==BLACK){
						//将sib的左子节点也设为黑色
						setColor(leftOf(sib),BLACK);
						//将sib设为红色
						setColor(sib,RED);
						rotateRight(sib);
						sib=rightOf(parentOf(x));
					}
					//设置sib的颜色与x的父节点的颜色相同
					setColor(sib,colorOf(parentOf(x)));
					//将x的父节点设为黑色
					setColor(parentOf(x),BLACK);
					//将sib的右子节点设为黑色
					setColor(rightOf(sib),BLACK);
					rotateLeft(parentOf(x));
					x=root;
				}
			//如果x是其父节点的右子节点
			}else{
				//获得x节点的兄弟节点
				Node sib=leftOf(parentOf(x));
				//如果sib的颜色是红色
				if(colorOf(sib)==RED){
					//将sib的颜色设为黑色
					setColor(sib,BLACK);
					//将sib的父节点设为红色
					setColor(parentOf(x),RED);
					rotateRight(parentOf(x));
					sib=leftOf(parentOf(x));
				}
				//如果sib的两个子节点都是黑色
				if(colorOf(rightOf(sib))==BLACK && colorOf(leftOf(sib))==BLACK){
					//将sib设为红色
					setColor(sib,RED);
					//让x等于x的父节点
					x=parentOf(x);
				}else{
					//如果sib只有左子节点是黑色
					if(colorOf(leftOf(sib))==BLACK){
						//将sib的右子节点也设为黑色 
						setColor(rightOf(sib),BLACK);
						//将sib设为红色
						setColor(sib,RED);
						rotateLeft(sib);
						sib=leftOf(parentOf(x));
					}
					//将sib的颜色设为与x的父节点颜色相同
					setColor(sib,colorOf(parentOf(x)));
					//将x的父节点设为黑色
					setColor(parentOf(x),BLACK);
					//将sib的左子节点设为黑色
					setColor(leftOf(sib),BLACK);
					rotateRight(parentOf(x));
					x=root;
				}
			}
		}
		setColor(x,BLACK);
	}
	
	
	private boolean colorOf(Node p){
		return (p==null? BLACK : p.color);
	}
	private Node parentOf(Node p){
		return (p==null? null : p.parent);
	}
	private void setColor(Node p,boolean c){
		if(p!=null){
			p.color=c;
		}
	}
	private Node leftOf(Node p){
		return (p==null) ? null : p.left;
	} 
	private Node rightOf(Node p){
		return (p==null) ? null : p.right;
	}
	
	/**
	 * 执行如下转换：
	 * p				r
	 *     r   --> p
	 * q				q
	 */
	private void rotateLeft(Node p){
		if(p!=null){
			//取得p的右子节点
			Node r=p.right;
			Node q=p.left;
			//将r的左子节点链接到p的右节点链上
			p.right=q;
			//让r的左子节点的parent指向p节点
			if(q!=null){
				q.parent=p;
			}
			r.parent=p.parent;
			//如果p已经是根节点
			if(p.parent==null){
				root=r;
			//如果p是其父节点的左子节点
			}else if(p.parent.left==p){
				//将r设为p的父节点的左子节点
				p.parent.left=r;
			}else{
				//将r设为p的父节点的右子节点
				p.parent.right=r;
			}
			r.left=p;
			p.parent=r;
		}
	}
	
	/**
	 * 执行如下转换：
	 * 		p			l
	 *  l 		  --> 		p
	 * 		q			q
	 */
	private void rotateRight(Node p){
		if(p!=null){
			//取得p的左子节点
			Node l=p.left;
			Node q=l.right;
			//将l的右子节点链到p的左子节点链上
			p.left=q;
			//将l的右子节点的parent指向p节点
			if(q!=null){
				q.parent=p;
			}
			//如果p已经是根节点
			l.parent=p.parent;
			if(p.parent==null){
				root=l;
			//如果p是其父节点的右子节点
			}else if(p.parent.right==p){
				//将l设为p的父节点的右子节点
				p.parent.right=l;
			}else{
				//将l设为p的父节点的左子节点
				p.parent.left=l;
			}
			l.right=p;
			p.parent=l;
		}
	}
	public List<Node> inIterator(){
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
}
public class RedBlackTreeDemo {
	public static void main(String[] args) {
		
	}
}
