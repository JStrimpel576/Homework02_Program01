package com.example.homework02_rgb;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import java.util.ArrayList;
//===========================================================================================
// Name : Joshua Strimpel
// Date : 09-24-24
// Desc : Allows the user to change red, blue, green, and hex values to affect the background
//===========================================================================================

public class MainActivity extends AppCompatActivity
{
    TextView tv_j_redValue;
    TextView tv_j_redLabel;
    TextView tv_j_greenValue;
    TextView tv_j_greenLabel;
    TextView tv_j_blueValue;
    TextView tv_j_blueLabel;
    TextView tv_j_hexValue;
    TextView tv_j_hexLabel;

    SeekBar sb_j_redSeekbar;
    SeekBar sb_j_blueSeekbar;
    SeekBar sb_j_greenSeekbar;

    Button btn_j_saveColor;

    ListView lv_j_savedColorList;

    View v_j_backgroundColor;

    ArrayList<ColorInfo> listOfColors;

    ColorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sb_j_redSeekbar = findViewById(R.id.sb_v_redSeekbar);
        sb_j_greenSeekbar = findViewById(R.id.sb_v_greenSeekbar);
        sb_j_blueSeekbar = findViewById(R.id.sb_v_blueSeekbar);

        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);

        lv_j_savedColorList = findViewById(R.id.lv_v_savedColorList);

        tv_j_redValue = findViewById(R.id.tv_v_redValue);
        tv_j_redLabel = findViewById(R.id.tv_v_redLabel);
        tv_j_greenValue = findViewById(R.id.tv_v_greenValue);
        tv_j_greenLabel = findViewById(R.id.tv_v_greenLabel);
        tv_j_blueValue = findViewById(R.id.tv_v_blueValue);
        tv_j_blueLabel = findViewById(R.id.tv_v_blueLabel);
        tv_j_hexValue = findViewById(R.id.tv_v_hexValue);
        tv_j_hexLabel = findViewById(R.id.tv_v_hexLabel);

        //create an ArrayList to help store values into the listView
        listOfColors = new ArrayList<>();

        v_j_backgroundColor = findViewById(R.id.v_v_backgroundColor);

        //set up adapter to help display the listView
        adapter = new ColorListAdapter(this, listOfColors);
        lv_j_savedColorList.setAdapter(adapter);

        // Set the max of the seekbars
        sb_j_redSeekbar.setMax(255);
        sb_j_greenSeekbar.setMax(255);
        sb_j_blueSeekbar.setMax(255);

        // Set the starting point of the seekbars
        sb_j_redSeekbar.setProgress(255);
        sb_j_greenSeekbar.setProgress(255);
        sb_j_blueSeekbar.setProgress(255);

        // Set red, green, blue, and hex to default values
        tv_j_redValue.setText(String.valueOf(sb_j_redSeekbar.getProgress()));
        tv_j_greenValue.setText(String.valueOf(sb_j_greenSeekbar.getProgress()));
        tv_j_blueValue.setText(String.valueOf(sb_j_blueSeekbar.getProgress()));
        tv_j_hexValue.setText("FFFFFF");

        // Set up seekbars to properly display values as it changes
        redSeekbarChangeListener();
        greenSeekbarChangeListener();
        blueSeekbarChangeListener();

        // Set up button to save colors
        saveColorButtonListener();

        //create an OnItemClickListener to make items in the listView clickable
        lv_j_savedColorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                ColorInfo colorInfo = (ColorInfo) adapterView.getItemAtPosition(i);

                //change current values of the seekbars
                sb_j_redSeekbar.setProgress(colorInfo.getRedValue());
                sb_j_greenSeekbar.setProgress(colorInfo.getGreenValue());
                sb_j_blueSeekbar.setProgress(colorInfo.getBlueValue());

                //change current value of hexadecimal
                tv_j_hexValue.setText(colorInfo.getHexValue());
            }
        });
    }

    //create SeekbarChangeListeners to set the r, g, b value
    private void redSeekbarChangeListener() {
        sb_j_redSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_j_redValue.setText(String.valueOf(i));
                updateHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void greenSeekbarChangeListener() {
        sb_j_greenSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_j_greenValue.setText(String.valueOf(i));
                updateHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void blueSeekbarChangeListener() {
        sb_j_blueSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_j_blueValue.setText(String.valueOf(i));
                updateHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    //use the r, g, b values to update the hex value
    private void updateHexValue()
    {
        //use "%02X%02X%02X" to correctly format the hex value
        String hexValue = String.format("%02X%02X%02X", sb_j_redSeekbar.getProgress(), sb_j_greenSeekbar.getProgress(), sb_j_blueSeekbar.getProgress());
        tv_j_hexValue.setText(hexValue);

        //send off hex value for use in changing the background color
        updateBackgroundColor(hexValue);
    }

    private void updateBackgroundColor(String hexValue)
    {
        //create a color variable to store the formated hex value
        int color = Color.parseColor("#" + hexValue);

        v_j_backgroundColor.setBackgroundColor(color);

        //calculate the luminance in order to determine whether the text should stay black, or change to white
        if (ColorUtils.calculateLuminance(color) > 0.5)
        {
           setTextColor(Color.BLACK);
        }

        else
        {
            setTextColor(Color.WHITE);
        }
    }

    private void setTextColor(int color)
    {
        //use int color to set the text colors to white or black
        tv_j_redValue.setTextColor(color);
        tv_j_redLabel.setTextColor(color);
        tv_j_greenValue.setTextColor(color);
        tv_j_greenLabel.setTextColor(color);
        tv_j_blueValue.setTextColor(color);
        tv_j_blueLabel.setTextColor(color);
        tv_j_hexValue.setTextColor(color);
        tv_j_hexLabel.setTextColor(color);
    }

    //add a button listener for the saveColor button
    private void saveColorButtonListener()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!tv_j_redValue.getText().toString().isEmpty() && !tv_j_greenValue.getText().toString().isEmpty() && !tv_j_blueValue.getText().toString().isEmpty() && !tv_j_hexValue.getText().toString().isEmpty())
                {
                    //create ColorInfo variable to store values into the listOfColors
                    ColorInfo colorToAdd = new ColorInfo();

                    colorToAdd.setRedValue(Integer.parseInt(tv_j_redValue.getText().toString()));
                    colorToAdd.setGreenValue(Integer.parseInt(tv_j_greenValue.getText().toString()));
                    colorToAdd.setBlueValue(Integer.parseInt(tv_j_blueValue.getText().toString()));
                    colorToAdd.setHexValue(tv_j_hexValue.getText().toString());

                    //Could not get background color in listView
                    //colorToAdd.setBackgroundColor(Color.parseColor("#" + colorToAdd.getHexValue()));

                    listOfColors.add(colorToAdd);

                    //notify the adapter that data has been added
                    adapter.notifyDataSetChanged();

                    //refresh GUI back to default values
                    refreshGUI();
                }
            }
        });
    }

    private void refreshGUI()
    {
        sb_j_redSeekbar.setProgress(255);
        sb_j_greenSeekbar.setProgress(255);
        sb_j_blueSeekbar.setProgress(255);
    }

}