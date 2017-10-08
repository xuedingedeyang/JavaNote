package defualtpackage;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity��" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("��������Ԫ�غ�position:" + buff.position());
		
		buff.flip();
		System.out.println("ִ��flip��limitΪ:" + buff.limit());
		System.out.println("ִ��flip��positionΪ:" + buff.position());
		System.out.println("ȡ����һ��Ԫ��:" + buff.get());
		
		buff.clear();
		
		System.out.println("ִ��clear()��limit:" + buff.limit());
		System.out.println("ִ��clear��position:" + buff.position());
		System.out.println("ִ��clear�󣬻��������ݲ�û�����,������Ԫ��Ϊ��" + buff.get(2));
	}

}
