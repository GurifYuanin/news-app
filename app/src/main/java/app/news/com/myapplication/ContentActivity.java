package app.news.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class ContentActivity extends AppCompatActivity {
    TextView t1;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        t1 = (TextView)findViewById(R.id.title);
        t2 = (TextView)findViewById(R.id.content);
        Intent intent = getIntent();
        t1.setText(intent.getStringExtra("title"));
        t2.setText(intent.getStringExtra("content"));
    }
}
