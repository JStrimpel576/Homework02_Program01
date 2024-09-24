package com.example.homework02_rgb;

public class ColorInfo
{
    //green value, blue value, red value, and hex value
    private int redValue;
    private int greenValue;
    private int blueValue;
    private String hexValue;

    //constructor
    public ColorInfo()
    {

    }

    //overloaded constructor
    public ColorInfo(int r, int g, int b, String h)
    {
        redValue   = r;
        greenValue = g;
        blueValue  = b;
        hexValue   = h;
    }

    //======================
    //Getters and Setters
    //======================
    public int getRedValue()
    {
        return redValue;
    }

    public void setRedValue(int redValue)
    {
        this.redValue = redValue;
    }

    public int getGreenValue()
    {
        return greenValue;
    }

    public void setGreenValue(int greenValue)
    {
        this.greenValue = greenValue;
    }

    public int getBlueValue()
    {
        return blueValue;
    }

    public void setBlueValue(int blueValue)
    {
        this.blueValue = blueValue;
    }

    public String getHexValue()
    {
        return hexValue;
    }

    public void setHexValue(String hexValue)
    {
        this.hexValue = hexValue;
    }
}
