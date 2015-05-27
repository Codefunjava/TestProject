package sorted;
/**
 * 直接选择排序在每次比较中都会找出趟最小的数据与n-1位进行交换，
 * 第n趟至多交换一次,是不稳定的排序算法
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 */

public class SelectSort {
	public static void selectSort(DataWrap[] data){
		System.out.println("开始排序");
		int arrayLength =data.length;
		//依次进行n-1趟比较，第i趟比较将第i大的值选出放在i位置上
		for(int i=0;i<arrayLength-1;i++){
			//minIndex将永远保留本趟比较中最小值的索引
			int minIndex=i;
			//第i个数据只需要和它后面的数据比较
			for(int j=i+1;j<arrayLength;j++){
				//如果第minIndex位置的数据>位置的数据
				if(data[minIndex].compareTo(data[j])>0){
					//将j的值赋给minIndex
					minIndex=j;
				}
			}
			//每趟比较最多交换一次
			if(minIndex !=i){
				DataWrap tmp=data[i];
				data[i]=data[minIndex];
				data[minIndex]=tmp;
			}
			System.out.println(java.util.Arrays.toString(data));
		}
	}
	public static void main(String args[]){
		DataWrap[] data={
				new DataWrap(21,""),
				new DataWrap(30,""),
				new DataWrap(49,""),
				new DataWrap(30,"*"),
				new DataWrap(16,""),
				new DataWrap(9,"")
		};
		System.out.println("排序之前：\n"+java.util.Arrays.toString(data));
		selectSort(data);
		System.out.println("排序之后：\n"+java.util.Arrays.toString(data));
	}
}
