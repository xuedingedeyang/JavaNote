
public class ChainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChainTest ct = new ChainTest();
		try{
			ct.test2();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void test1() throws DrunkException{
		throw new DrunkException("������Ⱦ�");
	}
	public void test2(){
		try{
			test1();
		}catch(DrunkException e){
			RuntimeException newExc = new RuntimeException("˾��һ�ξƣ�����������");
			//newExc.initCause(e);
			throw newExc;
		}
	}

}
