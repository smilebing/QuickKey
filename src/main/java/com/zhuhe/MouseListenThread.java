package com.zhuhe;

import java.awt.*;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhuhe on 2018/4/26.
 */
public class MouseListenThread {

    private final static Double TRIGGLE_HEIGHT = 50.0;
    private final static Double TRIGGLE_WIDTH = 50.0;

    Timer timer = new Timer();
    Set<ScreenInfo> screenInfos;
    //是否允许触发功能
    private boolean allowTrigger = true;

    public MouseListenThread() {
        //获取所有屏幕信息
        screenInfos = ScreenHelper.getScreensInfo();
    }

    private void getTriggerArea() {
    }

    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
                for (ScreenInfo screenInfo : screenInfos) {
                    if (screenInfo.getRectangle().contains(mouseLoc)) {
                        //判断四角
                        handleMouseLoc(screenInfo, mouseLoc);
                    }
                }
            }
        }, 100, 100);
    }

    /**
     * @param screenInfo
     * @param mousePoint
     */
    private void handleMouseLoc(ScreenInfo screenInfo, Point mousePoint) {
        Point screenPoint = screenInfo.getStartPoint();
        double x = mousePoint.getX();
        double y = mousePoint.getY();

        if (x <= screenPoint.getX() + TRIGGLE_WIDTH) {
            if (y <= screenPoint.getY() + TRIGGLE_HEIGHT) {
                //左上角
                //System.out.println("左上角");
            } else if (y >= screenPoint.getY() + screenInfo.getHeight() - TRIGGLE_HEIGHT) {
                //左下角
                showWinTab();
                //System.out.println("左下角");
            }
        } else if (x >= screenPoint.getX() + screenInfo.getWidth() - TRIGGLE_WIDTH) {
            if (y <= screenPoint.getY() + TRIGGLE_HEIGHT) {
                //右上角
                System.out.println("右上角");
            } else if (y >= screenPoint.getY() + screenInfo.getHeight() - TRIGGLE_HEIGHT) {
                //右下角
                System.out.println("右下角");
            }
        }else{
            allowTrigger=true;
        }
    }

    private void showWinTab(){
        if(allowTrigger){
            try {
                KeySenderHelper.sendWinTab();
//                System.out.println("do send win tab");
            } catch (AWTException e) {
                e.printStackTrace();
            }finally {
                allowTrigger=false;
            }
        }
    }

    private void showWinD(){
        if(allowTrigger){
            try {
                KeySenderHelper.sendWinD();
            } catch (AWTException e) {
                e.printStackTrace();
            }finally {
                allowTrigger=false;
            }
        }
    }
}
