package com.yinhao.expandablelistview;

/**
 * Created by yinhao on 2017/9/13.
 */

public class Row {
    private String rowname;
    private int rowImg;

    public Row(String rowname, int rowImg) {
        this.rowname = rowname;
        this.rowImg = rowImg;
    }

    public int getRowImg() {
        return rowImg;
    }

    public void setRowImg(int rowImg) {
        this.rowImg = rowImg;
    }

    public String getRowname() {
        return rowname;
    }

    public void setRowname(String rowname) {
        this.rowname = rowname;
    }
}
