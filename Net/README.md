# Socket通信

## 基于TCP的Socket的实现
- 服务端

 >1.创建ServerSocket对象

 >2.通过accept()方法监听客户端请求

 >3.连接建立后，通过输入流读取客户端发送的请求信息

 >4.通过输出流向客户端发送响应信息

 >5.关闭相关资源

- 客户端
 >1.创建Socket对象，指明需要连接的服务器的地址和端口号

 >2.连接建立后，通过输出流向服务端发送请求信息

 >3.通过输入流获取服务端响应的信息

 >4.关闭资源

![](https://github.com/xuedingedeyang/Image/blob/master/socket.png?raw=true)

## 应用多线程实现服务器与多客户端之间通信

>1.服务器端创建ServerSocket，循环调用accept()方法等待客户端连接

>2.客户端创建一个socket并请求和服务器端连接

>3.服务器端接受客户端请求，创建socket与该客户建立专线连接

>4.建立连接两个socket在一个单线程上的对话

>5.服务器端继续等待新的连接

![](https://github.com/xuedingedeyang/Image/blob/master/code01.png?raw=true)

## 基于UDP的Socket通信

- 服务端
  >1.创建DatagramSocket,指定端号

  >2.创建DatagramPacket

  >3.接收客户端发送的数据信息

  >4.读取数据

- 客户端

  >1.定义发送信息

  >2.创建DatagramPacket，包含要发送的信息

  >3.创建DatagramSocket

  >4.发送数据
