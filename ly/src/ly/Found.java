package ly;
import java.util.Arrays;
public class Found {
	public static void main(String[] args){
		Found found = new Found();
		int[] scores = {89,-23,64,91,119,52,73};
		found.show(scores);
	}
public void show(int[] scores){
	Arrays.sort(scores);
	int num=0;
	for(int i=0;i<scores.length;i++){
		if(scores[i] < 0||scores[i] > 100){
			continue;
		}
		num++;
		if(num > 3){
			break;
		}
		System.out.println(scores[i]);
	}
}

}
