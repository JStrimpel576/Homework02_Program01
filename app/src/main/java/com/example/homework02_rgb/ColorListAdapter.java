package com.example.homework02_rgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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

        ColorInfo color = listOfColors.get(i);

        //find GUI elements in custom_cell
        TextView redValue   = view.findViewById(R.id.tv_v_cc_redValue);
        TextView greenValue = view.findViewById(R.id.tv_v_cc_greenValue);
        TextView blueValue  = view.findViewById(R.id.tv_v_cc_blueValue);
        TextView hexValue   = view.findViewById(R.id.tv_v_cc_hexValue);

        //Could not get background color in listView
        //View backgroundColor = view.findViewById(R.id.v_v_backgroundColor);

        //set text of the GUI elements in custom_cell
        redValue.setText("Red: " + Integer.toString(color.getRedValue()));
        greenValue.setText("Green: " + Integer.toString(color.getGreenValue()));
        blueValue.setText("Blue: " + Integer.toString(color.getBlueValue()));
        hexValue.setText(("Hex: " + color.getHexValue()));

        //Could not get background color in listView
        //backgroundColor.setBackgroundColor(Color.parseColor("#" + color.getHexValue()));

        return view;
    }
}
