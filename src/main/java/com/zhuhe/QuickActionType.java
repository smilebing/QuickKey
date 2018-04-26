package com.zhuhe;

/**
 * Created by zhuhe on 2018/4/26.
 */
public enum QuickActionType {

    UNKOWN(0, ""),
    SHOW_WIN_TAB(1, "mission control"),
    SHOW_WIN_D(2, "显示桌面");

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    QuickActionType() {

    }

    QuickActionType(int value, String name) {
        this.value = value;
        this.name = name;
    }

//    public String[] getAllNames() {
//        String[] types = new String[QuickActionType.values().length];
//    }
}
