package com.TrictSystem.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.TrictSystem.Application.LoadCallBack;
import com.TrictSystem.Application.OkHttpManager;
import com.TrictSystem.Beans.Login_Error;
import com.TrictSystem.Beans.User;
import com.TrictSystem.R;
import com.TrictSystem.Tools.Constant;
import com.TrictSystem.Tools.SpUtils;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private EditText main_ed_username;
    private EditText main_ed_password;
    private Button main_button_login_user;
    private TextView tv_company;
    private TextView main_domain_text;
    private String username;
    private String password;
    private String BaseUrl;
    private int falg = 0;
    private Gson gson;

    @Override
    public void initView() {
        main_ed_username = (EditText) findViewById(R.id.main_ed_username);
        main_ed_password = (EditText) findViewById(R.id.main_ed_password);
        main_button_login_user = (Button) findViewById(R.id.main_button_login_user);
        main_domain_text = (TextView) findViewById(R.id.main_domain_text);
        BaseUrl = main_domain_text.getText().toString();
        main_domain_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(falg == 1){ //家里网络
                    main_domain_text.setText(Constant.domain_home);
                    falg = 0;
                    BaseUrl = Constant.domain_home;
                }else{ // 公司网络
                    main_domain_text.setText(Constant.domain_compay);
                    falg = 1;
                    BaseUrl = Constant.domain_compay;
                }
            }
        });
        tv_company = (TextView) findViewById(R.id.tv_company);
    }

    @Override
    public void initData() {
        main_button_login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = main_ed_username.getText().toString();
                password = main_ed_password.getText().toString();
                int a = Judge_empty(LoginActivity.this,username,password,"用户名","密码");
                if (a != -1){
                    user_login(username,password,2);
                }
            }
        });
        tv_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://www.tbkt.cn");
                intent.setData(content_url);
                startActivity(intent);
            }
        });
    }

    /**
     * 登录方法
     * @param username 用户名
     * @param password 密码
     * @param i
     */
    private void user_login(String username, String password, int i) {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        Log.e("username",username);
        Log.e("password",password);
        gson = new Gson();
        OkHttpManager.getInstance().postRequest(BaseUrl+Constant.login_url, new LoadCallBack<String>(LoginActivity.this) {
                    @Override
                    protected void onSuccess(Call call, Response response, String s) {
                        if(s.contains("\"response\": \"fail\"")){
                            Login_Error login_error = gson.fromJson(s, Login_Error.class);
                            showToask(LoginActivity.this,login_error.getMessage(),3);
                        }else{ //登录成功,跳转主页
                            User user = gson.fromJson(s,User.class);
                            try {
                                save_info(user);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this,MainActivity.class);
                            intent.putExtra("user_name",user.getUser_bean().getUsername());
                            intent.putExtra("user_id",user.getUser_bean().getUser_id());
                            intent.putExtra("nickname",user.getUser_bean().getNickname());
                            intent.putExtra("mobile",user.getUser_bean().getMobile());
                            intent.putExtra("token_expired",user.getUser_bean().getToken_expired());
                            intent.putExtra("is_active",user.getUser_bean().getIs_active());
                            intent.putExtra("access_token",user.getUser_bean().getAccess_token());
                            intent.putExtra("proj_ids",user.getUser_bean().getProj_ids());
                            intent.putExtra("is_supper",user.getUser_bean().getIs_supper());
                            intent.putExtra("role_id",user.getUser_bean().getRole_id());
                            intent.putExtra("email",user.getUser_bean().getEmail());
                            intent.putExtra("password_hash",user.getUser_bean().getPassword_hash());
                            startActivity(intent);
                        }
                    }
                    @Override
                    protected void onEror(Call call, int statusCode, Exception e) {
                        Log.e("ljl", "Exception = " + statusCode);
                    }
                }
                , params);
    }

    /**
     * 保存用户数据到手机本地SP
     * @param user
     * @throws IOException
     */
    public void save_info(User user) throws IOException {

        SpUtils.save(LoginActivity.this,"user_name",user.getUser_bean().getUsername());
        SpUtils.save(LoginActivity.this,"nickname",user.getUser_bean().getNickname());
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }
}
