package dataStruct;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public class HuffmanTree {
	//节点类
	public static class Node<E>{
		E data;
		double weight;       //权重
		Node<E> leftChild;
		Node<E> rightChild;
		public Node(E data,double weight){
			this.data=data;
			this.weight=weight;
		}
		public String toString(){
			return "Node[data="+data+",weight="+weight+"]";
		}
	}
	private static<E> Node<E> createTree(List<Node<E>> nodes){
		//只要nodes数组中有两个以上的节点
		while(nodes.size()>1){
			quickSort(nodes);
			//获取权值最小的两个节点
			Node<E> left=nodes.get(nodes.size()-1);
			Node<E> right=nodes.get(nodes.size()-2);
			//生成新节点，新节点权值为两个子节点之和
		Node<E> parent=new Node<>(null,left.weight+right.weight);
			//让新节点作为权值最小的两个节点的父节点
			parent.leftChild=left;
			parent.rightChild=right;
			//删除权值最小的两个节点
			nodes.remove(nodes.size()-1);
			nodes.remove(nodes.size()-1);
			//将新生成的父节点添加到集合中
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	private static<E> void swap(List<Node<E>> nodes,int i,int j){
		Node<E> tmp;
		tmp=nodes.get(i);
		nodes.set(i,nodes.get(j));
		nodes.set(j,tmp);
	}
	//实现快速排序算法，用于对节点进行排序（用其他的排序算法也可）
	private static <E> void subSort(List<Node<E>> nodes,
      int start,int end){
		if(start<end){
			Node base=nodes.get(start);
			int i=start;
			int j=end+1;
			while(true){
				while(i<end&&nodes.get(++i).weight>=base.weight);
	   	   while(j>start&&nodes.get(--j).weight<=base.weight);
				if(i<j){
					swap(nodes,i,j);
				}else{
					break;
				}
			}
			swap(nodes,start,j);
			subSort(nodes,start,j-1);
			subSort(nodes,j+1,end);
		}
	}
	public static<E> void quickSort(List<Node<E>> nodes){
		subSort(nodes,0,nodes.size()-1);
	}
	public static List<Node> breadthFirst(Node root){
		Queue<Node> queue=new ArrayDeque<Node>();
		List<Node> list=new ArrayList<Node>();
		if(root!=null){
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			list.add(queue.peek());
			Node p=queue.poll();
			if(p.leftChild!=null){
				queue.offer(p.leftChild);
			}
			if(p.rightChild!=null){
				queue.offer(p.rightChild);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		List<Node<String>> nodes=new ArrayList<>();
		nodes.add(new Node<String>("A",7.0));
		nodes.add(new Node<String>("B",5.0));
		nodes.add(new Node<String>("C",2.0));
		nodes.add(new Node<String>("D",4.0));
		Node<String> root=HuffmanTree.createTree(nodes);
		List<Node> list=breadthFirst(root);
		for(Node l:list){
			System.out.println(l);
		}
	}
}

 

