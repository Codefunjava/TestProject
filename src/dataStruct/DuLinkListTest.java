package dataStruct;

public class DuLinkListTest {
	public static void main(String[] args) {
		DuLinkList<String> list=new DuLinkList<String>();
		list.insert("aaaa", 0);
		list.add("bbbb");
		list.insert("cccc", 0);
		list.insert("dddd", 1);
		System.out.println(list);
		list.delete(2);
		System.out.println(list);
		System.out.println(list.reverseToString());
		System.out.println("cccc在链表中位置："+list.locate("cccc"));
		System.out.println("链表索引处1的元素："+list.get(1));
		list.remove();
		System.out.println("调用remove()方法后的链表："+list);
		list.delete(0);
		System.out.println("调用delete()方法后的链表："+list);
	}
}

