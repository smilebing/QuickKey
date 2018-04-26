package com.zhuhe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by zhuhe on 2018/4/26.
 */
public class MainFrame {
    String[] action = {QuickActionType.UNKOWN.getName(),
            QuickActionType.SHOW_WIN_TAB.getName(),
            QuickActionType.SHOW_WIN_D.getName()};

    JFrame f = new JFrame("鼠标快捷操作");

    public MainFrame() {
        //设置软件在托盘上显示的图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("a.png");//
        SystemTray systemTray = SystemTray.getSystemTray(); //获得系统托盘的实例
        TrayIcon trayIcon = null;

        try {
            trayIcon = new TrayIcon(img, "QuickKey");
            systemTray.add(trayIcon); //设置托盘的图标
            f.setIconImage(img);
            trayIcon.setImageAutoSize(true);
        } catch (AWTException e2) {
            e2.printStackTrace();
        }

        //窗口最小化时软件dispose
        f.addWindowListener(new WindowAdapter() {
            //图标化窗口时调用事件
            public void windowIconified(WindowEvent e) {
                f.dispose(); //窗口最小化时dispose该窗口
            }
        });

        //双击托盘图标，软件正常显示
        trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    //双击托盘窗口再现
                    //置此 frame 的状态。该状态表示为逐位掩码。
                    f.setExtendedState(Frame.NORMAL); //正常化状态
                    f.setVisible(true);
                }
            }
        });
    }


    public void show() {
        f.setSize(800, 600);
        f.setLocation(200, 200);

        f.setLayout(null);

        JPanel p1 = new JPanel();
        // 设置面板大小
        p1.setBounds(50, 50, 300, 70);
        // 设置面板背景颜色
        p1.setBackground(Color.RED);
//        p1.setLayout(new FlowLayout());

        JComboBox leftUpCbx = new JComboBox(action);
        JComboBox leftDownCbx = new JComboBox(action);
        JComboBox rightUPCbx = new JComboBox(action);
        JComboBox rightDownCbx = new JComboBox(action);

        p1.add(leftUpCbx);
        p1.add(leftDownCbx);
        p1.add(rightUPCbx);
        p1.add(rightDownCbx);

        // 把面板加入窗口
        f.add(p1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
