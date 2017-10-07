package commendtest;

public class CommendTest {
	public static void  main(String[] args){
		ProcessArray pa = new ProcessArray();
		int[] target = {3,-1,7,-3,2,4};
//		pa.process(target,new PrintCommed());
		pa.process(target, new Commend() {
			
			@Override
			public void process(int[] target) {
				// TODO Auto-generated method stub
				int sum = 0;
				for(int temp : target){
					sum+=temp;
				}
				System.out.println("数组的总和是:" + sum);
			}
		});
		
		pa.process(target, (int[] arr)->{
			int sum = 0;
			for(int temp : arr){
				sum+=temp;
			}
			System.out.println("数组的和是：" + sum);
		});
	}
	
}	
