package com.devsul.a08_customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        String title;
        String desc;
        int icon;

        public MyData(String title, String desc, int icon) {
            this.title = title;
            this.desc = desc;
            this.icon = icon;
        }
    }


    // Custom Adapter 생성
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 사전에 만든 view 를 사용할 수 있게 해준다 convertView 로 넘오오게 된다 한번도 생성 되지 않으면 null
            if(convertView == null){
                // 보톤 공통적으로 사용 됨
                LayoutInflater inf =(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

                convertView = inf.inflate(R.layout.item_view, null);
            }

            // 데이터 설정
            // Activity 에서 있는 걸 사용 하지 않기 때문에 convertView 를 사용해야 한다
            TextView testViewTitle = (TextView)convertView.findViewById(R.id.listTitle);
            TextView testViewDesc = (TextView)convertView.findViewById(R.id.listDesc);
            ImageView item_icon = (ImageView)convertView.findViewById(R.id.itemIcon);

            MyData data = list.get(position);
            testViewTitle.setText(data.title);
            testViewDesc.setText(data.desc);
            item_icon.setImageResource(data.icon);

            return convertView;
        }
    }


    ArrayList<MyData> list = new ArrayList<MyData>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int icon = 0;
        for(int i = 0 ; i < 30 ; i++){
            switch(i%4){
                case 0: icon = android.R.drawable.ic_dialog_email;
                    break;
                case 1: icon = android.R.drawable.ic_lock_idle_alarm;
                    break;
                case 2: icon = android.R.drawable.ic_btn_speak_now;
                    break;
                case 3: icon = android.R.drawable.ic_lock_power_off;
                    break;
            }

            MyData data = new MyData("data"+i, "desc"+i , icon);
            list.add(data);
        }

        ListView listView = (ListView)findViewById(R.id.listView01);

        // Adapter 연결
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }


}
