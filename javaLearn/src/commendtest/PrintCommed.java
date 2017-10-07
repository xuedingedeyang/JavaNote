package commendtest;

public class PrintCommed implements Commend {

	@Override
	public void process(int[] target) {
		// TODO Auto-generated method stub
		for(int temp : target){
			System.out.println("迭代输出目标数组元素：" + temp);
		}
	}

}
