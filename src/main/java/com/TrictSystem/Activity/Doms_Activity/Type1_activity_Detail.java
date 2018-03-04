package com.TrictSystem.Activity.Doms_Activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.TrictSystem.Activity.BaseActivity;
import com.TrictSystem.Beans.Ticket;
import com.TrictSystem.R;

/**
 * Created by smile_raccoon on 2018/1/22.
 */

public class Type1_activity_Detail extends BaseActivity{

    private Ticket.Ticket_Bean ticket_bean;
    private TextView domain_tv;
    private TextView from_user_name_tv;
    private TextView status_code_tv;
    private TextView url_tv;
    private TextView all_title_text;
    private ImageView all_title_img_back;
    private ImageView all_title_img_help;

    @Override
    public void initView() {

        Intent intent = getIntent();
        ticket_bean = (Ticket.Ticket_Bean) intent.getSerializableExtra("ticket_detail");

        domain_tv = (TextView) findViewById(R.id.domain_tv);
        from_user_name_tv = (TextView) findViewById(R.id.from_user_name_tv);
        status_code_tv = (TextView) findViewById(R.id.status_code_tv);
        url_tv = (TextView) findViewById(R.id.url_tv);
        all_title_text = (TextView) findViewById(R.id.all_title_text);
        all_title_img_back = (ImageView) findViewById(R.id.all_title_img_back);
        all_title_img_help = (ImageView) findViewById(R.id.all_title_img_help);
        all_title_img_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        all_title_text.setText("工单详情");
        all_title_img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Type1_activity_Detail.this.finish();
            }
        });
        domain_tv.append(ticket_bean.getDomain());
        from_user_name_tv.append(ticket_bean.getFrom_user_name());
        status_code_tv.append(ticket_bean.getStatus_code());
        url_tv.append(ticket_bean.getUrl());
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.type_1_activity_detail;
    }
}
