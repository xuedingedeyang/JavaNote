package lambdatest;

public interface Converter {
	Integer converter(String from);

}

class test{
	public static void main(String[] args){
		Converter c = from -> Integer.valueOf(from);
		System.out.println(c.converter("134"));
	}
}