package com.example.lyq.fragmenttabhost;

/**
 * Created by lyq on 2017/10/18.
 */

public class Movie {
    private String leftName;
    private String rightName;
    private int leftImage;
    private int rightImage;

    public Movie(String leftName, String rightName, int leftImage, int rightImage){
        this.leftName = leftName;
        this.leftImage = leftImage;
        this.rightName = rightName;
        this.rightImage = rightImage;
    }

    public String getLeftName() {
        return leftName;
    }

    public int getLeftImage() {
        return leftImage;
    }

    public String getRightName(){
        return rightName;
    }

    public int getRightImage() {
        return rightImage;
    }
}
