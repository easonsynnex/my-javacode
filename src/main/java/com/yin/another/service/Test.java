package com.yin.another.service;

import com.yin.another.service.impls.TCPService;
import com.yin.another.service.impls.UDPService;

public class Test {
    public static void main(String[] args) {
        TCPService tcp = new TCPService();
        UDPService udp = new UDPService();
        tcp.start();
        udp.start();
    }
}
