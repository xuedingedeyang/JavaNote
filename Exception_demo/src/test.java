import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ѧϰjava���";
		//����ַ�������
		System.out.println("�ַ�������"+str.length());
		
		char c = '��';
		//�����ַ�'��'��λ��
		System.out.println(str.indexOf(c));
		//�����ַ���'java'��λ��
		System.out.println(str.indexOf("java"));
		//���ո����ַ������飬���������
		String[] arr = str.split(" ");
		System.out.println("���ո�������"+Arrays.toString(arr));
		System.out.println();
		//��ȡ����λ��[4,7)֮����Ӵ�
		System.out.println(str.substring(3,7));
		}

}
