package dataStruct;

public class DuLinkList<T> {
	//定义一个内部类Node
	private class Node{
		private T data;
		//指向上一个节点的引用
		private Node prev;
		//指向下一个节点的引用
		private Node next;
		public Node(){}
		public Node(T data,Node prev,Node next){
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
	}
	//保存该链表的头结点
	private Node header;
	//保存该链表的尾结点
	private Node tail;
	//保存该链表中已包含的结点数
	private int size;
	//创建空链表
	public DuLinkList(){
		header=null;
		tail=null;
	}
	//以指定数据元素来创建链表
	public DuLinkList(T element){
		header=new Node(element,null,null);
		tail=header;
		size++;
	}
	//返回链表长度
	public int length(){
		return size;
	}
	//获取链式线性表中索引为index处的元素
	public T get(int index){
		return getNodeByIndex(index).data;
	}	
	//根据索引index获取指定位置的结点
	private Node getNodeByIndex(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("线性表越界！");
		}
		if(index<=size/2){
			//从header结点开始
			Node current=header;
			for(int i=0;i<=size/2&&current!=null;i++,current=current.next){
				if(i==index){
					return current;
				}
			}
		}else{
			//从tail节点开始
			Node current=tail;
			for(int i=size-1;i>size/2&&current!=null;i++,current=current.prev){
				if(i==index){
					return current;
				}
			}
		}
		return null;
	}
	//查找链式线性表指定元素的索引
	public int locate(T element){
		//从头结点开始搜索
		Node current=header;
		for(int 
             i=0;i<size&&current!=null;i++,current=current.next){
			if(current.data.equals(element)){
				return i;
			}
		}
		return -1;
	}
	//插入一个元素
	public void insert(T element,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("线性表索引越界！");
		}
		if(header==null){
			add(element);
		}else{
			//index为0，也就是在链表头插入
			if(index==0){
				addAtHeader(element);
			}else{
				//获取插入点的前一个结点
				Node prev=getNodeByIndex(index-1);
				//获取插入点的结点
				Node next=prev.next;
				//让新结点的next引用指向next结点，prev引用指向prev结点
				Node newNode =new Node(element,prev,next);
				//让prev的next指向新结点
				prev.next=newNode;
				//让prev的下一个结点的prev指向新的节点
				next.prev=newNode;
				size++;
			}
		}
	}
	//采用尾插法为链表添加新结点
	public void add(T element){
		if(header==null){
			header=new Node(element,null,null);
			tail=header;
		}else{
			//创建新结点，新结点的prev引用指向原tail结点
			Node newNode=new Node(element,tail,null);
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}	
	//采用头插入法为链表添加新结点
	public void addAtHeader(T element){
		header=new Node(element,null,header);
		if(tail==null){
			tail=header;
		}
		size++;
	}
	//删除链表中指定索引处的元素
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("线性表索引越界！");
		}
		Node del=null;
		if(index==0){
			del=header;
			header=header.next;
			header.prev=null;
		}else{
			//获取删除点的前一个结点
			Node prev=getNodeByIndex(index-1);
			//获取将要被删除的结点
			del=prev.next;
			//让被删除的结点的next指向被删除被删除结点的下一个结点
			prev.next=del.next;
			///让被删除结点的下一个结点的prev指向prev结点
			if(del.next!=null){
				del.next.prev=prev;
			}
			//将被删除结点的prev、next引用赋为null
			del.prev=null;
			del.prev=null;
		}
		size--;
		return del.data;
	}
	//删除链表中最后一个元素
	public T remove(){
		return delete(size-1);
	}
	//判断链表是否为空
	public boolean empty(){
		return size==0;
	}	
	//清空链表
	public void clear(){
		header=null;
		tail=null;
		size=0;
	}	
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for(Node
                current=header;current!=null;current=current.next){
				sb.append(current.data.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
	}
	//反向输出链表
	public String reverseToString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for(Node current=tail;current!=null;current=current.prev){
				sb.append(current.data.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
	}
}
