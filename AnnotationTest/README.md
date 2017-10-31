@FunctionalInterface:用来保证接口为函数式接口,即只含有一个抽象方法

##### JDK的元Annotation

1. @Retention:只能用于修饰Annotation定义，用于指定被修饰的Annotation可以保留多长时间

2. @Target:也只能修饰一个Annotation定义，用于指定被修饰的Annotation可以修饰哪些程序单元

3. @Documented:用于指定被该元Annotation修饰的Annotation类将被javadoc工具提取成文档

4. @Inherited:指定被它修饰的Annotation将具有继承性，如果某个类使用了@Xxx(定义该Annotation时用了@Inherited修饰)，则其子类将自动使用@Inherited修饰


--自定义Annotation--

Annotation可以带成员变量,可以为成员变量赋值,赋初始值

```
public @interface ann_name
{
	String name() default "yang";
	int age() default 22;
}

public class test
{
	@ann_name(name="xx",age=8)
	public void info()
	{
		
	}
}
```
