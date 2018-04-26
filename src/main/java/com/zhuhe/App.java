package com.zhuhe;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MouseListenThread mouseListenThread=new MouseListenThread();
        mouseListenThread.start();
        MainFrame mainFrame=new MainFrame();
        mainFrame.show();

        try {
            System.out.println(ConfigFileHelper.readPro("asdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
