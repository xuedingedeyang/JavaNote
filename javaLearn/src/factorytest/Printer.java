package factorytest;

public class Printer implements Output{
	public String[] printData = new String[20];
	private int dataNum = 0;

	@Override
	public void out() {
		// TODO Auto-generated method stub
		while(dataNum > 0){
			System.out.println("打印中:" +printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}
	
	public void getData(String msg){
		if(dataNum >= 20){
			System.out.println("输出队列已满，无法添加");
		}else{
			printData[dataNum++] = msg;
		}
	}

}
