package com.zhuhe;

import java.awt.*;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MouseListenThread mouseListenThread=new MouseListenThread();
        mouseListenThread.start();
    }
}
