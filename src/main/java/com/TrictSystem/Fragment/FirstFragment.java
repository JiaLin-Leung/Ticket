package com.TrictSystem.Fragment;

/**
 * Created by smile_raccoon on 2018/1/17.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.TrictSystem.Activity.TicketMainActivity;
import com.TrictSystem.Application.LoadCallBack;
import com.TrictSystem.Application.OkHttpManager;
import com.TrictSystem.Beans.Login_Error;
import com.TrictSystem.Beans.Ticket;
import com.TrictSystem.R;
import com.TrictSystem.Tools.Constant;
import com.TrictSystem.Tools.CustomDialog;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class FirstFragment extends Fragment
{

    private String username;
    private String user_id;
    private String nickname;
    private int tircket_num;
    private Ticket ticket;
//    private Button doms;
//    private Button worktile;
    private Intent intent;
    private ListView listview_f1;
    private String[] city = {"小明","小刚","帅男","万兴","老王","帅东","吕杨"} ;  //定义一个数组，作为数据源

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        username = getActivity().getIntent().getStringExtra("user_name");
//        user_id = getActivity().getIntent().getStringExtra("user_id");
//        nickname = getActivity().getIntent().getStringExtra("nickname");
//        getData(user_id,0+"",0);

    }

    @Override
    public void onStart() {
        super.onStart();
        initView(user_id);
    }

    private void initView(final String user_id) {

        intent = new Intent();
        listview_f1 = (ListView)getActivity().findViewById(R.id.listview_f1);
        listview_f1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("ljl","i ===="+i);
                Log.e("ljl","l ===="+l);
            }
        });
        listview_f1.setAdapter(new ArrayAdapter<String>(getActivity(),R.layout.item_text,R.id.it_f1,city));
//        doms = (Button) getActivity().findViewById(R.id.doms);
//        doms.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.setClass(getActivity(),TicketMainActivity.class);
//                intent.putExtra("user_id",user_id);
//                startActivity(intent);
//            }
//        });
//        worktile = (Button) getActivity().findViewById(R.id.worktile);
//        worktile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    /**
     * 获取用户工单数据
     * @param user_id 用户ID
     * @param status 要查询的状态值 0 未完成 1 已完成 2 全部
     * @param type 要查询的状态值 0 全部状态 1 响应状态 2 响应超时 3 响应错误 4 SQL慢查询 5 APP错误
     */
    private void getData(final String user_id, String status ,int type) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", user_id);
        params.put("status", status);
        params.put("type", type+"");
        final Gson gson = new Gson();
        OkHttpManager.getInstance().postRequest(Constant.domain_compay+ Constant.get_all_ticket, new LoadCallBack<String>(getActivity()) {
                    @Override
                    protected void onSuccess(Call call, Response response, String s) {
                        if(s.contains("\"response\": \"fail\"")){
                            Login_Error login_error = gson.fromJson(s, Login_Error.class);
                            Toast.makeText(getActivity(),login_error.getMessage(),Toast.LENGTH_LONG).show();
                        }else{
                            ticket = gson.fromJson(s,Ticket.class);
                            tircket_num = ticket.getData().size();
                            Log.e("ticket------------",ticket.getData().size()+"");
                        }
                        CustomDialog.Builder builder = new CustomDialog.Builder(getActivity());
                        builder.setMessage("你还有"+tircket_num+"条未处理工单!");
                        builder.setTitle("亲爱的"+nickname);
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                    @Override
                    protected void onEror(Call call, int statusCode, Exception e) {
                        Log.e("ljl", "Exception = " + statusCode);
                    }
                }
                , params);
    }
}