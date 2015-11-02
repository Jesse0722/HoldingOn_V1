package com.practice.xieweiba.holdingon_v1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 佳俊 on 2015/11/2.
 */
public class MissionActivity extends Activity implements View.OnClickListener{
    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.missionview);
    }
}
