package sorted;

import java.util.Arrays;

/**
 * 归并排序需要递归地分解、合并
 * 时间复杂度：O(n*logn)
 * 空间效率较差，需要一个与原始序列同样大小的辅助序列
 */
public class MergeSort {
	//利用归并排序算法对数组data进行排序
	public static void mergeSort(DataWrap[] data){
		//归并排序
		sort(data,0,data.length-1);
	}
	/**
	 * 将索引从left到right范围内的数组元素进行归并排序
	 * @param data 待排序的数组
	 * @param left  待排序的数组的第一个元的索引
	 * @param right	待排序的数组的最后一个元素的索引
	 */
	private static void sort(DataWrap[] data,int left,int right){
		if(left<right){
			//找出中间索引
			int center=(left+right)/2;
			//对左边数组进行递归
			sort(data,left,center);
			//对右边的数组进行递归
			sort(data,center+1,right);
			//合并
			merge(data,left,center,right);
		}
	}
	/**
	 * 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
	 * @param data 数组对象
	 * @param left 左数组的第一个元素的索引
	 * @param center 右数组的最后一个元素的索引，center+1是右数组的第一个元素的索引
	 * @param right 右数组的最后一个元素的索引
	 */
	private static void merge (DataWrap[] data,int left,int center,int right){
		//定义一个与待排序序列长度相同的临时数组
		DataWrap[] tmpArr=new DataWrap[data.length];
		int mid=center+1;
		//third记录中间数组的索引
		int third=left;
		int tmp=left;
		while(left<=center && mid<=right){
			//从两个数组中取出小的放入中间数组
			if(data[left].compareTo(data[mid])<=0){
				tmpArr[third++]=data[left++];
			}else{
				tmpArr[third++]=data[mid++];
			}
		}
		//剩余部分依次放入中间数组
		while(mid<=right){
			tmpArr[third++]=data[mid++];
		}
		while(left<=center){
			tmpArr[third++]=data[left++];
		}
		//将中间数组的内容复制加回原数组
		//（原left至right范围的内容复制回原数组）
		while(tmp<=right){
			data[tmp]=tmpArr[tmp++];
		}
		
	}
	
	public static void main(String[] args){
		DataWrap[] data={
			new DataWrap(9,""),
			new DataWrap(-16,""),
			new DataWrap(21,"*"),
			new DataWrap(23,""),
			new DataWrap(-30,""),
			new DataWrap(-49,""),
			new DataWrap(21,""),
			new DataWrap(30,"*"),
			new DataWrap(30,"")
		};
		System.out.println("排序之前：\n"+Arrays.toString(data));
		mergeSort(data);
		System.out.println("排序之后：\n"+Arrays.toString(data));
	}
	
}
