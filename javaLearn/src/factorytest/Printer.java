package factorytest;

public class Printer implements Output{
	public String[] printData = new String[20];
	private int dataNum = 0;

	@Override
	public void out() {
		// TODO Auto-generated method stub
		while(dataNum > 0){
			System.out.println("��ӡ��:" +printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}
	
	public void getData(String msg){
		if(dataNum >= 20){
			System.out.println("��������������޷����");
		}else{
			printData[dataNum++] = msg;
		}
	}

}
