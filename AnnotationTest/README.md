@FunctionalInterface:������֤�ӿ�Ϊ����ʽ�ӿ�,��ֻ����һ�����󷽷�

##### JDK��ԪAnnotation

1. @Retention:ֻ����������Annotation���壬����ָ�������ε�Annotation���Ա����೤ʱ��

2. @Target:Ҳֻ������һ��Annotation���壬����ָ�������ε�Annotation����������Щ����Ԫ

3. @Documented:����ָ������ԪAnnotation���ε�Annotation�ཫ��javadoc������ȡ���ĵ�

4. @Inherited:ָ���������ε�Annotation�����м̳��ԣ����ĳ����ʹ����@Xxx(�����Annotationʱ����@Inherited����)���������ཫ�Զ�ʹ��@Inherited����


--�Զ���Annotation--

Annotation���Դ���Ա����,����Ϊ��Ա������ֵ,����ʼֵ

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
