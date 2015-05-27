package dataStruct;

class LinkQueue<T>{
	//定义一个内部类Node,Node实例代表链队列的结点
	private class Node{
		//保存结点的数据
		private T data;
		//指向下一个结点的引用
		private Node next;
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	//保存该链队的头结点
	private Node front;
	//保存该链队的尾结点
	private Node rear;
	//保存该链队列中已包含的结点数
	private int size;
	public LinkQueue(){
		//空链队列，front和rear都是null
		front=null;
		rear=null;
	}
	//以指定元素来创建链队列，该链队列只有一个元素
	public LinkQueue(T element){
		front=new Node(element,null);
		//只有一个结点，front、rear都指向该结点
		rear=front;
		size++;
	}
	//返回队列的长度
	public int length(){
		return size;
	}
	//将新元素加入队列
	public void add(T element){
		//如果该链队列还是空链队列
		if(front==null){
			front=new Node(element,null);
			//只有一个结点，front、rear都指向该结点
			rear=front;
		}else{
			//创建新结点
			Node newNode=new Node(element,null);
			//让尾结点的next指向新增的结点
			rear.next=newNode;
			//以新增结点作为新的尾结点
			rear=newNode;
		}
		size++;
	}
	//删除队列的front端元素
	public T remove(){
		Node oldFront=front;
		front=front.next;
		oldFront.next=null;
		size--;
		return oldFront.data;
	}
	//访问链队列中最后一个元素
	public T element(){
		return rear.data;
	}
	//判断链队列是否为空队列
	public boolean empty(){
		return size==0;
	}
	//清空链队列
	public void clear(){
		front=null;
		rear=null;
		size=0;
	}
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for(Node current=front;current!=null;current=current.next){
				sb.append(current.data.toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
	}
}
public class LinkQueueTest {
	public static void main(String[] args) {
		LinkQueue<String> queue=new LinkQueue<String>("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("队列满时的长度："+queue.length());
		queue.remove();
		queue.add("eeee");
		System.out.println(queue);
		
	}
}
 

