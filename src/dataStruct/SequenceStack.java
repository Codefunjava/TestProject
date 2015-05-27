package dataStruct;

import java.util.Arrays;
public class SequenceStack<T> {
	private int DEFAULT_SIZE=10;
	//保存数组的长度
	private int capacity;
	//定义当底层数组容量不够时，程序每次增加的数组长度
	private int capacityIncrement=0;
	//定义一个数组用于保存顺序栈的元素
	private Object[] elementData;
	//保存顺序栈中元素的当前个数
	private int size=0;
	//以默认数组长度创建空顺序栈
	public SequenceStack(){
		capacity=DEFAULT_SIZE;
		elementData=new Object[capacity];
	}
	//以一个初始化元素来创建顺序栈
	public SequenceStack(T element){
		this();
		elementData[0]=element;
		size++;
	}
	//以指定长度的数组来创建顺序栈
	public SequenceStack(T element,int initSize){
		this.capacity=initSize;
		elementData=new Object[capacity];
		elementData[0]=element;
		size++;
	}
	//以一个初始化元素来创建顺序栈
	public SequenceStack(T element,int initSize,int capacityIncrement){
		this.capacity=initSize;
		this.capacityIncrement=capacityIncrement;
		elementData=new Object[capacity];
		elementData[0]=element;
		size++;
	}
	//获取顺序栈的大小
	public int length(){
		return size;
	}
	//入栈
	public void push(T element){
		ensureCapacity(size+1);
		elementData[size++]=element;
	}
	//扩展数组大小
	private void ensureCapacity(int minCapacity){
		if(minCapacity>capacity){
			if(capacityIncrement>0){
				while(capacity<minCapacity){
					//不断地将capacity长度增加capacityIncrement
					capacity+=capacityIncrement;
				}
			}else{
				//不断地将capacity*2
				while(capacity<minCapacity){
					capacity<<=1;
				}
			}
		}
		elementData=Arrays.copyOf(elementData, capacity);
	}	
	//出栈
	@SuppressWarnings("unchecked")
	public T pop(){
		T oldValue=(T) elementData[size-1];
		//释放栈顶元素
		elementData[--size]=null;
		return oldValue;
	}
	//返回栈顶元素，但不删除栈顶元素
	@SuppressWarnings("unchecked")
	public T peek(){
		return (T)elementData[size-1];
	}	
	//判断顺序栈是否为空
	public boolean empty(){
		return size==0;
	}	
	//清空顺序栈
	public void clear(){
		//将底层数组的所有元素赋为null
		Arrays.fill(elementData, null);
		size=0;
	}	
	public String toString(){
		if(size==0){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder("[");
			for(int i=size-1;i>-1;i--){
				sb.append(elementData[i].toString()+",");
			}
			int len=sb.length();
			return sb.delete(len-1,len).append("]").toString();
		}		
	}	
}
