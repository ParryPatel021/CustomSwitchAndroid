package com.parrypatel.customswitch.design;

import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;

import com.parrypatel.customswitch.R;

public class CustomSwitch {
    private RelativeLayout custom_switch;
    private SwitchCompat mswitch;
    private AppCompatTextView textView;
    private SwitchClickInterface switchClickInterface;
    private Resources resources;

    private String textOn = "ON";
    private String textOff = "OFF";

    public CustomSwitch(View view, SwitchClickInterface switchClickInterface) {
        resources = Resources.getSystem();
        setType(view);
        setSwitchClick();
        this.switchClickInterface = switchClickInterface;
    }

    private void setType(View view) {
        custom_switch = view.findViewById(R.id.custom_switch);
        mswitch = view.findViewById(R.id.mswitch);
        textView = view.findViewById(R.id.textView);
    }

    private void setSwitchClick() {
        custom_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSwitchValue();
                switchClickInterface.getSwitchValue(mswitch.isChecked());
            }
        });
    }

    private void setSwitchValue() {
        if (mswitch.isChecked()) {
            mswitch.setChecked(false);
            setStateOffText();
        } else {
            mswitch.setChecked(true);
            setStateOnText();
        }
    }

    public void setDefault(boolean def) {
        mswitch.setChecked(def);
        if (mswitch.isChecked()) {
            setStateOnText();
        } else {
            setStateOffText();
        }
    }

    private void setStateOnText() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_START, mswitch.getId());
        params.removeRule(RelativeLayout.ALIGN_END);
        textView.setLayoutParams(params);
        textView.setText(getTextOn());
    }

    private void setStateOffText() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        params.removeRule(RelativeLayout.ALIGN_START);
        params.addRule(RelativeLayout.ALIGN_END, mswitch.getId());
        textView.setLayoutParams(params);
        textView.setText(getTextOff());
    }

    public String getTextOn() {
        return textOn;
    }

    public void setTextOn(String textOn) {
        this.textOn = textOn;
    }

    public String getTextOff() {
        return textOff;
    }

    public void setTextOff(String textOff) {
        this.textOff = textOff;
    }

    public interface SwitchClickInterface {
        void getSwitchValue(boolean value);
    }

}
