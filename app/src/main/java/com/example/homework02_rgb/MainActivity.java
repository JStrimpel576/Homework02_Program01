package com.example.homework02_rgb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//=========================================
// Name : Joshua Strimpel
// Date : 09-24-24
// Desc :
//=========================================

public class MainActivity extends AppCompatActivity
{
    TextView tv_j_redValue;
    TextView tv_j_greenValue;
    TextView tv_j_blueValue;

    SeekBar sb_j_redSeekbar;
    SeekBar sb_j_blueSeekbar;
    SeekBar sb_j_greenSeekbar;

    Button btn_j_saveColor;

    ListView lv_j_savedColorList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sb_j_redSeekbar      = findViewById(R.id.sb_v_redSeekbar);
        sb_j_greenSeekbar    = findViewById(R.id.sb_v_greenSeekbar);
        sb_j_blueSeekbar     = findViewById(R.id.sb_v_blueSeekbar);
        btn_j_saveColor      = findViewById(R.id.btn_v_saveColor);
        lv_j_savedColorList  = findViewById(R.id.lv_v_savedColorList);
        tv_j_redValue        = findViewById(R.id.tv_v_redValue);
        tv_j_greenValue      = findViewById(R.id.tv_v_greenValue);
        tv_j_blueValue       = findViewById(R.id.tv_v_blueValue);

        //set the max of the seekbars
        sb_j_redSeekbar.setMax(255);
        sb_j_greenSeekbar.setMax(255);
        sb_j_blueSeekbar.setMax(255);

        //set the starting point of the seekbars
        sb_j_redSeekbar.setProgress(255);
        sb_j_greenSeekbar.setProgress(255);
        sb_j_blueSeekbar.setProgress(255);
        
        //testing only
        tv_j_redValue.setText("Red: " + sb_j_redSeekbar.getProgress());
        tv_j_greenValue.setText("Green: " + sb_j_greenSeekbar.getProgress());
        tv_j_blueValue.setText("Blue: " + sb_j_blueSeekbar.getProgress());

        //set up seekbars to properly display values as it changes
        redSeekbarChangeListener();
        greenSeekbarChangeListener();
        blueSeekbarChangeListener();

        //set up button to save colors

    }

    private void redSeekbarChangeListener()
    {
        sb_j_redSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //make value visible
                //change background color?
                //change hex value?
                tv_j_redValue.setText("Red: " + String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void greenSeekbarChangeListener()
    {
        sb_j_greenSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //make value visible
                //change background color?
                //change hex value?
                tv_j_greenValue.setText("Green: " + String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void blueSeekbarChangeListener()
    {
        sb_j_blueSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //make value visible
                //change background color?
                //change hex value?
                tv_j_blueValue.setText("Blue: " + String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void saveColorButtonListener()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
}