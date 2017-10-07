package yang.iotest;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity:"+buff.capacity());
		System.out.println(buff.limit());
		System.out.println(buff.position());
		
		buff.put('a');
		buff.put('b');
		buff.put('c');
		
		System.out.println(buff.position());
		buff.flip();
		System.out.println(buff.position());
		
		System.out.println(buff.get());
		buff.clear();
		System.out.println(buff.limit());
		System.out.println(buff.position());
	}

}
