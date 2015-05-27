package dataStruct;

import java.util.Arrays;
class Queue<T>{
	private int DEFAULT_SIZE=10;
	//保存数组的长度
	private int capacity;
	//定义一个数组用于保存顺序队列的元素
	private Object[] elementData;
	//保存顺序队列中元素的当前个数
	private int front=0;
	private int rear=0;
	//以默认数组长度创建空顺序队列
	public Queue(){
		capacity=DEFAULT_SIZE;
		elementData=new Object[capacity];
	}
	//以一个初始化元素来创建顺序队列
	public Queue(T element){
		this();
		elementData[0]=element;
		rear++;
	}
	//以指定长度来创建顺序队列
	public Queue(T element,int initSize){
		this.capacity=initSize;
		elementData=new Object[capacity];
		elementData[0]=element;
		rear++;
	}
	//获取顺序队列的大小
	public int length(){
		return rear-front;
	}
	//插入队列
	public void add(T element){
		if(rear>capacity-1){
			throw new IndexOutOfBoundsException("队列已满！");
		}
		elementData[rear++]=element;
	}
	//移出队列
	public T remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("队列已空！");
		}
		//保留队列的front端元素的值
		T oldValue=(T)elementData[front];
		//释放队列的front端元素的值
		elementData[front++]=null;
		return oldValue;
	}
	//返回队列顶元素，但不删除队列顶元素
	public T element(){
		if(empty()){
			throw new IndexOutOfBoundsException("队列已空！");
		}
		return (T)elementData[front];
	}
	//判断顺序队列是否为空队列
	public boolean empty(){
		return rear==front;
	}
	//清空顺序队列
	public void clear(){
		Arrays.fill(elementData, null);
		front=0;
		rear=0;
	}
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for(int i=front;i<rear;i++){
				sb.append(elementData[i].toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
	}
}
public class SequenceQueue {
	public static void main(String[] args) {
		Queue<String> queue=new Queue<String>();
		queue.add("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("访问队列的front端元素："+queue.element());
		System.out.println("移除队列的front端元素："+queue.remove());
		System.out.println("移除队列的front端元素："+queue.remove());
		System.out.println("两次调用remove方法后的队列："+queue);
	}
}
 
