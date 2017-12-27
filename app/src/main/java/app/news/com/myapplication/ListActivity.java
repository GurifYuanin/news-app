package app.news.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends Activity {
    private ListView list;
    private ListBaseAdapter ListBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView)findViewById(R.id.list);
        ListBaseAdapter = new ListBaseAdapter(this); // 创建适配器
        list.setAdapter(ListBaseAdapter); // 执行适配器
    }
}
