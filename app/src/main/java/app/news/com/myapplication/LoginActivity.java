package app.news.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;



public class LoginActivity extends Activity {
    private Button loginButton;
    private Button regiterButton;
    private EditText usernameText;
    private EditText passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button)findViewById(R.id.login_button);
        regiterButton = (Button)findViewById(R.id.regiter_button);
        usernameText = (EditText)findViewById(R.id.username);
        passwordText = (EditText)findViewById(R.id.password);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = String.valueOf(usernameText.getText()); // 获取用户名
                String password = String.valueOf(passwordText.getText()); // 获取密码

                // 连接数据库

                // 页面跳转
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, ListActivity.class); // 设置跳转页面
                LoginActivity.this.startActivity(intent); // 进行跳转
            }
        });
        regiterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        
    }

}
