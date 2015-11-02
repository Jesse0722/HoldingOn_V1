package com.practice.xieweiba.holdingon_v1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

//    DatePicker datePicker;
    TextView dateView;
    ImageView imageView;
    TextView mottoView;
    Button holdingButton;
    ImageButton missionImageButton;


    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemTitle", "任务" + (i + 1));
            map.put("itemContent", "已坚持20天，还剩10天完成任务，继续坚持！");
            listItem.add(map);
        }
        //    datePicker= (DatePicker) findViewById(R.id.datePicker);
        dateView = (TextView) findViewById(R.id.dateView);
        imageView = (ImageView) findViewById(R.id.imageView);
        mottoView = (TextView) findViewById(R.id.mottoView);
        holdingButton = (Button) findViewById(R.id.button);
        missionImageButton = (ImageButton) findViewById(R.id.mission_imagebutton);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int monthofyear = calendar.get(Calendar.MONTH);
        int dayofmonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        //  datePicker.init(year,monthofyear,dayofmonth);
        dateView.setText(year + "年" + (monthofyear + 1) + "月" + dayofmonth + "日" + "  星期" + (dayofweek - 1));

        //   imageView.setImageResource(R.drawable.image1);
        imageView.setBackgroundResource(R.drawable.image1);
        mottoView.setText(R.string.motto_view);

        listView = (ListView) findViewById(R.id.listView);

        SimpleAdapter adapter = new SimpleAdapter(this, listItem, R.layout.listview, new String[]{"itemTitle", "itemContent", "CheckBox"}, new int[]{R.id.title_textview, R.id.detail_textview, R.id.certain_checkbox});

        listView.setAdapter(adapter);

        missionImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MissionActivity.class);//参数以当前上下文，参数2要传递的activity
                MainActivity.this.startActivity(intent);//从当前上下文启动“意图”
            }
        });

    }


}
