package dataStruct.BPlugTree;

public class Record {
	private Comparable key; 	//键
	private Object value; 		//叶节点使用，保存键对应的值
	private Node child; 		//内部节点使用，保存子节点指针
}