package coreJava;

public class EncodeDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s = "Ľ��ABC";
		byte[] byte1 = s.getBytes();
		for(byte b:byte1){
			//���ֽڣ�ת������int����16���Ƶķ�ʽ��ʾ
			System.out.println(Integer.toHexString(b));
		}
		System.out.println();
		byte[] bytes2 = s.getBytes("gbk");
		//gbk��������ռ��2���ֽڣ�Ӣ��ռ��һ���ֽ�
		for(byte b : bytes2){
			System.out.println(Integer.toHexString(b));
		}
		System.out.println();
		byte [] bytes3 = s.getBytes("utf-8");
		//utf-8��������ռ��3���ֽڣ�Ӣ��ռ��һ���ֽ�
		for(byte b : bytes3){
			System.out.println(Integer.toHexString(b));
		}
		System.out.println();
		//Java��˫�ֽڱ���utf-16be
		byte [] bytes4 = s.getBytes("utf-16be");
		//utf-16be����ռ�������ֽڣ�Ӣ��ռ��2���ֽ�
		for(byte b : bytes4){
			System.out.println(Integer.toHexString(b));
		}
		/*
		 * ������ֽ�������ĳ�ֱ���ʱ�����ʱ������ֽ����б���ַ�����Ҳ��Ҫ���ֱ��뷽ʽ��
		 * ������������
		 */
		String str1 = new String (bytes4);//����ĿĬ�ϵı���
		System.out.println(str1);
		String str2 = new String(bytes4,"utf-16be");
		System.out.println(str2);
		/*
		 * �ı��ļ������ֽ�����
		 * ���������������ֽ�����
		 * ������������Ļ�����ֱ�Ӵ����ı��ļ�����ô���ı��ļ�ֻ��ʶANSI����
		 */
	}

}
