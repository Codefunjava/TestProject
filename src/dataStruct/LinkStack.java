package dataStruct;

public class LinkStack<T> {
	private class Node{
		//保存结点数据
		private T data;
		//指向下一个结点的引用 
		private Node next;
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	//栈顶元素
	private Node top;
	//链栈中的结点数
	private int size;
	public LinkStack(){
		top=null;
	}
	public LinkStack(T element){
		top =new Node(element,null);
		size++;
	}
	//返回链栈长度
	public int length(){
		return size;
	}
	//进栈
	public void push(T element){
		top=new Node(element,top);
		size++;
	}
	//出栈
	public T pop(){
		Node oldTop=top;
		top=top.next;
		//释放栈顶元素的next引用
		oldTop.next=null;
		size--;
		return oldTop.data;
	}
	//访问栈顶元素，但不删除栈顶元素
	public T peek(){
		return top.data;
	}
	//判断链栈是否为空栈
	public boolean empty(){
		return size==0;
	}
	//清空链栈
	public void clear(){
		//将底层数组的所有元素赋为null
		top =null;
		size=0;
	}
	public String toString(){
		//链栈为空链栈时
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for(Node current=top;current!=null;
                current=current.next){
				sb.append(current.data.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
	}	
}

