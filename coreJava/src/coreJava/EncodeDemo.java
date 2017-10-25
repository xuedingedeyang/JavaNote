package coreJava;

public class EncodeDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s = "慕课ABC";
		byte[] byte1 = s.getBytes();
		for(byte b:byte1){
			//把字节（转换成了int）以16进制的方式显示
			System.out.println(Integer.toHexString(b));
		}
		System.out.println();
		byte[] bytes2 = s.getBytes("gbk");
		//gbk编码中文占用2个字节，英文占用一个字节
		for(byte b : bytes2){
			System.out.println(Integer.toHexString(b));
		}
		System.out.println();
		byte [] bytes3 = s.getBytes("utf-8");
		//utf-8编码中文占用3个字节，英文占用一个字节
		for(byte b : bytes3){
			System.out.println(Integer.toHexString(b));
		}
		System.out.println();
		//Java是双字节编码utf-16be
		byte [] bytes4 = s.getBytes("utf-16be");
		//utf-16be中文占用两个字节，英文占用2个字节
		for(byte b : bytes4){
			System.out.println(Integer.toHexString(b));
		}
		/*
		 * 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要这种编码方式，
		 * 否则会出现乱码
		 */
		String str1 = new String (bytes4);//用项目默认的编码
		System.out.println(str1);
		String str2 = new String(bytes4,"utf-16be");
		System.out.println(str2);
		/*
		 * 文本文件就是字节序列
		 * 可以是任意编码的字节序列
		 * 如果我们在中文机器上直接创建文本文件，那么该文本文件只认识ANSI编码
		 */
	}

}
