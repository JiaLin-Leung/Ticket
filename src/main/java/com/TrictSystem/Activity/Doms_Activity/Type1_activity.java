package com.TrictSystem.Activity.Doms_Activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.TrictSystem.Activity.BaseActivity;
import com.TrictSystem.Application.LoadCallBack;
import com.TrictSystem.Application.OkHttpManager;
import com.TrictSystem.Beans.Login_Error;
import com.TrictSystem.Beans.Ticket;
import com.TrictSystem.R;
import com.TrictSystem.Tools.Constant;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by smile_raccoon on 2018/1/18.
 */

public class Type1_activity extends BaseActivity {

    private String user_id;
    private ListView type_1_listview;
    private Ticket ticket;
    private int tircket_num;
    private TextView all_title_text;
    private ImageView all_title_img;
    private Ticket.Ticket_Bean ticket_bean;
    private Ticket.Ticket_Bean ticket_detail;
    private Intent intent;

    @Override
    public void initView() {
        user_id = getIntent().getStringExtra("user_id");
        type_1_listview = (ListView) findViewById(R.id.type_1_listview);
        all_title_text = (TextView)findViewById(R.id.all_title_text);
        all_title_text.setText("响应状态");
        all_title_img = (ImageView)findViewById(R.id.all_title_img);
        all_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Type1_activity.this.finish();
            }
        });

    }

    @Override
    public void initData() {
        getData(user_id,2+"",1+"");
    }

    @Override
    public int getLayout() {
        return R.layout.type1_layout;
    }

    /**
     * 获取用户数据
     * @param user_id 用户ID
     * @param status 要查询的状态值 0 未完成 1 已完成 2 全部
     */
    private void getData(final String user_id, String status,String type) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", user_id);
        params.put("status", status);
        params.put("type", type);
        final Gson gson = new Gson();
        OkHttpManager.getInstance().postRequest(Constant.domain_compay+ Constant.get_all_ticket, new LoadCallBack<String>(this) {
                    @Override
                    protected void onSuccess(Call call, Response response, String s) {
                        if(s.contains("\"response\": \"fail\"")){
                            Login_Error login_error = gson.fromJson(s, Login_Error.class);
                            showToask(Type1_activity.this,login_error.getMessage(),3);
                        }else{
                            ticket = gson.fromJson(s,Ticket.class);
                            tircket_num = ticket.getData().size();
                            Log.e("ticket------------",ticket.getData().size()+"");
                        }
                        type_1_listview = (ListView) findViewById(R.id.type_1_listview);
                        type_1_listview.setAdapter(new BaseAdapter() {
                            @Override
                            public int getCount() {
                                return ticket.getData().size();
                            }

                            @Override
                            public Object getItem(int position) {
                                return null;
                            }

                            @Override
                            public long getItemId(int position) {
                                return 0;
                            }

                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {

                                View view = null;
                                //如果缓存为空，我们生成新的布局作为1个item
                                if(convertView==null){
                                    Log.i("info:", "没有缓存，重新生成"+position);
                                    LayoutInflater inflater = getLayoutInflater();
                                    //因为getView()返回的对象，adapter会自动赋给ListView
                                    view = inflater.inflate(R.layout.listview_item_layout, null);
                                }else{
                                    Log.i("info:", "有缓存，不需要重新生成"+position);
                                    view = convertView;
                                }

                                ticket_bean = ticket.getData().get(position);
                                TextView tv_userName = (TextView)view.findViewById(R.id.add_time);
                                Button status_button = (Button)view.findViewById(R.id.status_button);
                                tv_userName.setText(ticket_bean.getAdd_time());
                                TextView tv_lastMessage = (TextView)view.findViewById(R.id.url);
                                tv_lastMessage.setText(ticket_bean.getUrl());
                                if(ticket_bean.getStatus().equals("0")){
                                    status_button.setText("未完成");
                                    status_button.setBackgroundColor(Color.parseColor("#FF5E52"));
                                }
                                return view;
                            }
                        });
                    }
                    @Override
                    protected void onEror(Call call, int statusCode, Exception e) {
                        Log.e("ljl", "Exception = " + statusCode);
                    }
                }
                , params);
        type_1_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ticket_detail = (Ticket.Ticket_Bean) ticket.getData().get(position);
                intent = new Intent();
                intent.setClass(Type1_activity.this,Type1_activity_Detail.class);
                intent.putExtra("ticket_detail", ticket_detail);
                startActivity(intent);
            }
        });
    }
}
