package com.parrypatel.customswitch;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parrypatel.customswitch.design.CustomSwitch;

public class MainActivity extends AppCompatActivity implements CustomSwitch.SwitchClickInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomSwitch customSwitch = new CustomSwitch(findViewById(R.id.customSwitch), this);
        
    }

    @Override
    public void getSwitchValue(boolean value) {
        Toast.makeText(this, "Checked: " + value, Toast.LENGTH_SHORT).show();
    }
}