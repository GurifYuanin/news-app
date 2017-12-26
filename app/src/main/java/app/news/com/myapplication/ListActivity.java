package app.news.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private ListView list;
    private ListBaseAdapter ListBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView)findViewById(R.id.list);
        ListBaseAdapter = new ListBaseAdapter(this);
        list.setAdapter(ListBaseAdapter);
    }
}
