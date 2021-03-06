package com.mycompany.myapplication.content;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewList extends LinearLayout{
    private static final String TAG = ReviewList.class.getSimpleName();//클래스이름 문자열로 얻는 방법
    private ListView listView;
    private List<Review> list=new ArrayList<>();
    private ItemAdapter itemAdapter;

    //context는 액티비티
    public ReviewList(Context context) {
        super(context);
        //Listview생성
        LayoutInflater inflater=LayoutInflater.from(context);
       listView=(ListView)inflater.inflate(R.layout.review_list,null);
        //어댑터생성
        itemAdapter=new ItemAdapter();
        //listView와 adapter를 매핑시키는 코드
        listView.setAdapter(itemAdapter);
        //ListView를 내용으로 추가
        addView(listView);
        //listView 이벤트 처리

        listView.setOnItemClickListener(itemClickListener);
    }
    private AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
//(아이템포함레이아웃,최상위레이아웃, , )
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Review review=(Review)itemAdapter.getItem(position);
            Log.i(TAG,review.getTitle());
            Log.i(TAG,review.getContent());
            Log.i(TAG,view.toString());
            Log.i(TAG,parent.toString());

        }
    };


    class ItemAdapter extends BaseAdapter{

        //전체 데이터가 몇개인지 알려주는 메소드
        @Override
        public int getCount() {

            return list.size();
        }
        //현재 위치에서의 데이터 객체가 무엇인가를 알려줌
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }
        //해당 객체의 식별 ID를 리턴해주는 메소드(EX. bno)
        //원래는 식별번호로 쓰고자 하는 필드를 사용하지만 연습할때는 List의 인덱스 번호로 대체함
        @Override
        public long getItemId(int position) {
            return position;
        }
        //Inflation을 해서 데이터를 세팅하는 메소드
        //(  ,재사용을 위해 사용하지 않게 된 객체(재사용할 것이 없을 시 null이 들어옴),
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null) {
                //Item UI 객체생성(inflation )
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView= inflater.inflate(R.layout.review_item, null); //content1의 최상위가 LineaaLayout이기때문에 리턴을 그것으로받음
            }
                //데이터 셋팅

            ImageView photo=(ImageView)convertView.findViewById(R.id.photo);
            TextView title=(TextView)convertView.findViewById(R.id.title);
            ImageView star=(ImageView)convertView.findViewById(R.id.star);
            TextView content=(TextView)convertView.findViewById(R.id.content);
            Review item=list.get(position);
            photo.setImageResource(item.getPhoto());
            title.setText(item.getTitle());
            star.setImageResource(item.getStar());
            content.setText(item.getContent());

            return convertView;
        }
    }

    public void addItem(Review item){
        list.add(item);
        //데이터 변경시에 어댑터에게 알려주기 위한 코드
        itemAdapter.notifyDataSetChanged();
    }
    public void removeItem(Review item){
        list.remove(item);
        itemAdapter.notifyDataSetChanged();
    }
}
