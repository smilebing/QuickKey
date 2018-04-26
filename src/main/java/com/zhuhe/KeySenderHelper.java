package com.zhuhe;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by zhuhe on 2018/4/26.
 */
public class KeySenderHelper {
    /**
     * 发送win+Tab键
     */
    public static void sendWinTab() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }

    /**
     * 发送win+D键
     * @throws AWTException
     */
    public static void sendWinD() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_D);

        robot.keyRelease(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }
}
