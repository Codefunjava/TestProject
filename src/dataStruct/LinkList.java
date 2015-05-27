package dataStruct;

public class LinkList<T>{
	//定义一个内部类Node，Node实例代表链表的结点
	private class Node{
		//结点数据
		private T data;
		//指向下一个结点指针
		private Node next;		
		public Node(){	}
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
	}	
	//链表头结点
	private Node header;
	//链表尾结点
	private Node tail;
	//链表包含结点数
	private int size;
	//创建空链表
	public LinkList(){
		header=null;
		tail=null;
	}
	//以指定的数据元素来创建链表
	public LinkList(T element){
		header =new Node(element,null);
		tail=header;
		size++;
	}
	//返回链表长度
	public int length(){
		return size;
	}	
	//获取线性表中索引为index处的元素
	public T get(int index){
		return getNodeByIndex(index).data;
	}	
	//获取线性表中索引为index处的结点
	private Node getNodeByIndex(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("线性表索引越界！");
		}
		Node current=header;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(i==index){
				return current;
			}
		}
		return null;
	}
	//查找链式线性表中指定元素的索引
	public int locate(T element){
		Node current=header;
		for(int i=0;i<size&&current!=null;i++,current=current.next){
			if(current.data.equals(element)){
				return i;
			}
		}
		return -1;
	}	
	//指定位置前插入元素
	public void insert(T element,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("线性表索引越界！");
		}
		if(header==null){
			add(element);
		}else{
			if(index==0){
				addAtHeader(element);
			}else{
				Node prev  =getNodeByIndex(index-1);
				prev.next=new Node(element,prev.next);
				size++;
			}
		}
	}
	//尾插入法插入新结点
	public void add(T element){
		if(header==null){
			header=new Node(element,null);
			tail=header;
		}else{
			Node newNode=new Node(element,null);
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}	
	//采用头插入法为链表插入新结点
	public void addAtHeader(T element){
		header =new Node(element,header);
		if(tail==null){
			tail=header;
		}
		size++;
	}
	//删除链表指定索引处的元素
	public T delete(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("线性表索引越界！");
		}
		Node del=null;
		//如果被删除的是header结点
		if(index==0){
			del=header;
			header=header.next;
		}else{
			//获取删除点的前一个结点
			Node prev=getNodeByIndex(index-1);
			//获取将要删除的节点
			del=prev.next;
			//让被删除结点的next指向被删除结点的下一个结点 
			prev.next=del.next;
			//将被删除结点的next引用赋为null
			del.next=null;
		}
		size--;
		return del.data;
	}
	//删除链表中的最后一个元素
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
    public void reverse(){ //链表反转
		if (null == header) {   
            return;   
        }   
        Node pre = header;   
        Node cur = header.next;   
        Node next;   
        while (null != cur) {   
            next = cur.next;   
            cur.next=pre;   
            pre = cur;   
            cur = next;   
        }   
        //将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head      
        header.next=null;   
        header = pre;              
	}	
}

