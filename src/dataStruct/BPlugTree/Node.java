package dataStruct.BPlugTree;

public class Node {
	private int keyCount; 		//节点中已存储的记录个数
	private Record[] records;	//存储记录的数组
	private Node leftMostChild; //最左边子节点指针
	private Node left; 			//同层左侧节点
	private Node right;			//同层右侧节点
	private Node parent;		//父节点
}