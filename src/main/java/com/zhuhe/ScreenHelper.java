package com.zhuhe;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuhe on 2018/4/26.
 */
public class ScreenHelper {

    /**
     * 获取当前系统所有屏幕信息
     *
     * @return
     */
    public static Set<ScreenInfo> getScreensInfo() {
        Set<ScreenInfo> points = new HashSet<>();
        GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screenDevices = localGraphicsEnvironment.getScreenDevices();

        for (int i = 0; i < screenDevices.length; i++) {
            GraphicsDevice device = screenDevices[i];
            Dimension size = device.getDefaultConfiguration().getBounds().getSize();
            Point screenLocation = device.getDefaultConfiguration().getBounds().getLocation();
            ScreenInfo screenInfo = new ScreenInfo(i, screenLocation, size.getWidth(),
                    size.getHeight(), device.getDefaultConfiguration().getBounds());
            points.add(screenInfo);
        }

        return points;
    }
}
