package com.zhuhe;

import java.awt.*;

/**
 * Created by zhuhe on 2018/4/26.
 */
public class ScreenInfo {
    private int index;
    private Point startPoint;
    private Double width;
    private Double height;
    private Rectangle rectangle;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public ScreenInfo() {

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public ScreenInfo(int index, Point point, Double width, Double height, Rectangle rectangle) {
        this.index = index;
        this.startPoint = point;
        this.width = width;
        this.height = height;
        this.rectangle = rectangle;
    }
}
