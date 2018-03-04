package com.TrictSystem.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.TrictSystem.Activity.Doms_Activity.Type1_activity;
import com.TrictSystem.R;

/**
 * Created by smile_raccoon on 2018/1/20.
 */

public class TicketMainActivity extends BaseActivity {

    private String username;
    private String user_id;
    private String nickname;
    private Button xyzt_button;
    private Button xycc_button;
    private Button xycw_button;
    private Button sql_button;
    private Button app_button;
    private TextView all_title_text;
    private ImageView all_title_img;
    private Intent intent;


    @Override
    public void initView() {
        username = getIntent().getStringExtra("user_name");
        user_id = getIntent().getStringExtra("user_id");
        nickname = getIntent().getStringExtra("nickname");
        intent = new Intent();
        xyzt_button = (Button)findViewById(R.id.xyzt_button);
        all_title_text = (TextView)findViewById(R.id.all_title_text);
        all_title_text.setText("运维平台");
        all_title_img = (ImageView)findViewById(R.id.all_title_img);
        all_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TicketMainActivity.this.finish();
            }
        });
        xyzt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(TicketMainActivity.this,Type1_activity.class);
                intent.putExtra("user_id",user_id);
                startActivity(intent);
            }
        });
        xycc_button = (Button)findViewById(R.id.xycc_button);
        xycc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        xycw_button = (Button)findViewById(R.id.xycw_button);
        xycw_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sql_button = (Button)findViewById(R.id.sql_button);
        sql_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        app_button = (Button)findViewById(R.id.app_button);
        app_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.ticketmain_activity;
    }
}
