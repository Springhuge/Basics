package com.jihu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中又两个主要的问题：
 * 1.如何准确地定位网络上一台或多台主机，定位主机上的特定的应用
 * 2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路）
 *
 * 三、通信要素一：IP和端口号
 * 1.IP：唯一的标识Internet上的计算机（通信实体）
 * 2.在Java中使用InetAddress类代表IP
 * 3.IP分类：IPv4 和 IPv6 ；万维网 和 局域网
 * 4.域名： www.baidu.com www.mi.com
 * 5.本地回路地址：127.0.0.1 对应着：localhost
 * 6.如何实例化InetAdress 两个方法 getByName
 *      两个常用方法 getHostName() /getHostAddress()
 * 7.端口号：正在计算机上运行的进程
 * 要求：不同的进程有不同的端口号
 * 范围：被规定为一个16为的数字
 *
 * 8.端口号与IP地址的组合得出一个网络套接字：Socket
 *
 */
public class InetAddressTest {

    public static void main(String[] args) {

        try {
            //File file = new File("hello.txt");
            InetAddress inetAddress = InetAddress.getByName("192.168.10.14");
            System.out.println(inetAddress);

            InetAddress inetAddress2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inetAddress2);

            InetAddress inetAddress3= InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress3);

            //获取本地IP
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
