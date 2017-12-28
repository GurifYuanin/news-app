package app.news.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

public class ContentActivity extends Activity {
    TextView t1;
    TextView t2;
    TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        t1 = (TextView)findViewById(R.id.title);
        t2 = (TextView)findViewById(R.id.date);
        t3 = (TextView)findViewById(R.id.content);
        Intent intent = getIntent();
        t1.setText(intent.getStringExtra("title"));
        t3.setText(intent.getStringExtra("content"));
    }
}
