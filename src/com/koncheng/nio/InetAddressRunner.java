package com.koncheng.nio;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

public class InetAddressRunner {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(address);
        System.out.println(Objects.requireNonNull(address).getHostName());
        System.out.println(address.getHostAddress());
    }
}
