
public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryCatchTest trc = new TryCatchTest();
		int result = trc.test();
		System.out.println(result);
		TryCatchTest trc2 = new TryCatchTest();
		int result2 = trc2.test2();
	}
	/*
	 * divider(����)
	 * result�������
	 * trycatch����whileѭ��
	 * ÿ��ѭ����divider��һ��result=result +100/divider
	 * ����������쳣����ӡ������׳��쳣�ˣ�����������-1
	 * ���򣬷���result
	 */
	public int test(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ѭ���׳��쳣��������");
			return -1;
		}
	
	}
	public int test2(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ѭ���׳��쳣��������");
			return result=999;
		}finally{
			System.out.println("����finally ��������");
			System.out.println("����result�ҵ�ֵ�ǣ�"+result);
		}
	}
	public int test3(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ѭ���׳��쳣��������");
			return result=999;
		}finally{
			System.out.println("����finally ��������");
			System.out.println("����result�ҵ�ֵ�ǣ�"+result);
		}
	}
}
