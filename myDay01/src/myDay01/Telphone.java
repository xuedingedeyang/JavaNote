package myDay01;

public class Telphone {
	public float screen;
	public float cpu;
	public float mem;

	@Override
	public String toString() {
		return "Telphone [screen=" + screen + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telphone other = (Telphone) obj;
		if (Float.floatToIntBits(cpu) != Float.floatToIntBits(other.cpu))
			return false;
		if (Float.floatToIntBits(mem) != Float.floatToIntBits(other.mem))
			return false;
		if (Float.floatToIntBits(screen) != Float.floatToIntBits(other.screen))
			return false;
		return true;
	}
	
//	public float getCpu() {
//		return cpu;
//	}
//	public void setCpu(float cpu) {
//		this.cpu = cpu;
//	}
//	public float getMem() {
//		return mem;
//	}
//	public void setMem(float mem) {
//		this.mem = mem;
//	}
//	private float cpu;
//	private float mem;
//	
//	public float getScreen(){
//		return screen;
//	}
//	public void setScreen(float newScreen){
//		screen  = newScreen;
//		
//	}
//	
//	public Telphone(){
//		System.out.println("无参的构造方法执行了");
//	}
//	public Telphone(float newScreen,float newCpu,float newMem){
//		if(newScreen < 3.5){
//			System.out.println("手机屏幕必须大于3.5英寸");
//		}
//			else{
//			screen = newScreen;
//			}
//		cpu = newCpu;
//		mem = newMem;
//		System.out.println("有参的构造方法执行了");
//	}
}