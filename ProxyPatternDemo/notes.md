Dynamic Proxy是这样一种class

它是在运行时生成的class，该class需要一组interface，使用动态代理类时，必须实现InvocationHandler接口

动态代理实现步骤

1. 创建一个实现接口InvocationHandler的类，它必须实现invoke方法
2. 创建被代理的类以及接口
3. 调用Proxy的静态方法，创建一个代理类 
_newProxyInstance(ClassLoader loader,Class[] interfaces,InvocationHandler h)_
4. 通过代理调用方法