package sorted;
/**
 *	Shell排序是直接插入排序的改进
 *	时间复杂度：O(n^(7/6)~n^(3/2))之间
 *	空间复杂度：O(1) 
 *	算法稳定性：稳定的排序算法 
 */
public class ShellSortDemo {
	public static void shellSort(DataWrap data[]){
		System.out.println("开始排序：\n");
		int arrayLength =data.length;
		//h变量保存可变增量
		int h=1;
		//按h*3+1得到增量序列的最大值
		while(h<=arrayLength/3){
			h=h*3+1;
		}
		while(h>0){
			System.out.println("===h的值："+h+"===");
			for(int i=h;i<arrayLength;i++){
				//当整体后移时，保证data[i的值不会丢失
				DataWrap tmp=data[i];
				//i索引处的值已经比前面的所有值都大，表明已经有序，无须插入
				//(i-1索引之前的数据已经有序，i-1索引处元素的值就是最大值)
				if(data[i].compareTo(data[i-h])<0){
					int j=i-h;
					//整体后移h格
					for(;j>=0&&data[j].compareTo(tmp)>0;j-=h){
						data[j+h]=data[j];
					}
					//将tmp的值插入到合适的位置
					data[j+h]=tmp;
				}
				System.out.println(java.util.Arrays.toString(data));
			}
			h=(h-1)/3;
		}
	}
	
	public static void main(String args[]){
		DataWrap data[]={
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
		System.out.println("排序之前：\n"+java.util.Arrays.toString(data));
		shellSort(data);
		System.out.println("排序之后：\n"+java.util.Arrays.toString(data));
	}
	
}
