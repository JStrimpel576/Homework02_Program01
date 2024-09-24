package com.example.homework02_rgb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }

        //find GUI elements in custom cell
        TextView greenValue = view.findViewById(R.id.tv_v_cc_greenValue);
        TextView redValue   = view.findViewById(R.id.tv_v_cc_redValue);
        TextView blueValue  = view.findViewById(R.id.tv_v_cc_blueValue);
        TextView hexValue   = view.findViewById(R.id.tv_v_cc_hexValue);

        ColorInfo color = listOfColors.get(i);
        redValue.setText("Red: " + color.getRedValue());
        greenValue.setText("Green: " + color.getGreenValue());
        blueValue.setText("Blue: " + color.getBlueValue());
        hexValue.setText("Hex: " + color.getHexValue());

        return view;
    }
}
