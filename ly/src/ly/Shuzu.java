package ly;
import java.util.Arrays;

public class Shuzu {
	public static void main(String[] args){
	Shuzu shuzu = new Shuzu();
	int[] nums = shuzu.getArray(8);
	System.out.println(Arrays.toString(nums));
	
}
public int[] getArray(int length){
	int nums[] = new int[length];
	for(int i = 0;i < nums.length;i++){
		nums[i] = (int) (Math.random()*100);
	}
	return nums;
}
}
