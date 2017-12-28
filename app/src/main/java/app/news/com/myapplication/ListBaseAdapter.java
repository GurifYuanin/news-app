package app.news.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

/**
 * Created by newuser on 2017/12/26.
 */

public class ListBaseAdapter extends BaseAdapter {
    Context context;
    public ListBaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
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
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final String title = "Title" + position;
        final String content = "Content" + position;
        view = LayoutInflater.from(context).inflate(R.layout.item, null);
        TextView t1 = (TextView)view.findViewById(R.id.textView1);
        TextView t2 = (TextView)view.findViewById(R.id.textView2);
        ImageView img = (ImageView)view.findViewById(R.id.imageView);
        t1.setText(title); // 设置标题
        t2.setText(content); // 设置预览内容
        img.setImageResource(getImageId(context, "image" + (position + 1))); // 设置预览图片
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(context, ContentActivity.class);
                intent.putExtra("title", title); // 新闻标题
                intent.putExtra("content", content); // 新闻预览内容
                intent.putExtra("id", position); // 新闻ID
                context.startActivity(intent);
            }
        });
        return view;
    }
    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("mipmap/" + imageName, null, context.getPackageName());
    }
}
