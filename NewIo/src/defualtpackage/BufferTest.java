package defualtpackage;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity：" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("加入三个元素后，position:" + buff.position());
		
		buff.flip();
		System.out.println("执行flip后，limit为:" + buff.limit());
		System.out.println("执行flip后，position为:" + buff.position());
		System.out.println("取出第一个元素:" + buff.get());
		
		buff.clear();
		
		System.out.println("执行clear()后，limit:" + buff.limit());
		System.out.println("执行clear后，position:" + buff.position());
		System.out.println("执行clear后，缓冲区内容并没有清除,第三个元素为：" + buff.get(2));
	}

}
