package yang.base;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[]{3,3,3,21,31,454,22,532,42,54,787,9,9,77564,53,5};
		SortTest test  = new SortTest();
		test.sort2(arr);
		for (int i : arr) {
			System.out.print(i+"  ");
		}
		
	}
	
	public void sort(int[] arr){
		for(int i = 0 ; i < arr.length - 1; i++){
			for(int j = i ; j < arr.length ; j++){
				if(arr[j] > arr[i]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
	public void sort2(int[] a){
		int k;
		for(int i = 1 ; i < a.length ; i++){
			for(int j = 0 ; j < a.length - i ; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

}
