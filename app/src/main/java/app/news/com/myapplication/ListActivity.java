package app.news.com.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class ListActivity extends Activity {
    private ListView list;
    private ListBaseAdapter ListBaseAdapter;
    private LinkedList<News> newsList = new LinkedList<News>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list); // 设置布局
        new GetNewsList(newsList).execute(); // 获取所有消息列表
        list = (ListView)findViewById(R.id.list);
        SystemClock.sleep(1000); // 当前线程暂停，等待适配器设置
        ListBaseAdapter = new ListBaseAdapter(this, newsList); // 创建适配器
        list.setAdapter(ListBaseAdapter); // 执行适配器
    }
}

class GetNewsList extends AsyncTask{
    private static LinkedList<News> list;
    public GetNewsList(LinkedList<News> list) {
        this.list = list;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        readNews();
        return null;
    }

    // 读取新闻消息
    static void readNews() {
        try {
            URL url = new URL("http://192.168.2.43:5678/getallnews");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000 /* milliseconds */);
            connection.setConnectTimeout(15000 /* milliseconds */);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            String string = readInputStream(connection.getInputStream()); // 获取JSON字符串
            parse(string, list); // 解析JSON
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 讀取數據
    public static String readInputStream(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            is.close();
            baos.close();
            byte[] result = baos.toByteArray();
            return new String(result, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // 解析字符串
    static void parse(String string, LinkedList<News> list) {
        try {
            JSONArray array = new JSONArray(string);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                News news = new News();
                news.setTitle(object.getString("title"));
                news.setContent(object.getString("content"));
                news.setId(object.getInt("id"));
                list.add(news);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
