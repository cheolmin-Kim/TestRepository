package com.mycompany.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodListFragment extends Fragment {
    private ListView listView;
    private List<Food> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listView=(ListView)inflater.inflate(R.layout.food_list,null);
        itemAdapter=new ItemAdapter();
        //listView와 adapter를 매핑시키는 코드
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        return listView;
    }
    @Override
    public void onStart() {
        super.onStart();
        for(int i=1;i<=6;i++) {
            Food food=new Food();
            food.setFno(i);
            food.setFname("음식종류 :"+i);
            food.setFphoto(getResources().getIdentifier("food"+i,"drawable",getContext().getPackageName()));
            food.setFstar(getResources().getIdentifier("star"+i,"drawable",getContext().getPackageName()));
            food.setFdesc("한국음식 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
            addItem(food);
        }
    }


    private AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
        //(아이템포함레이아웃,최상위레이아웃, , )
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Food food=(Food) itemAdapter.getItem(position);


        }
    };

    class ItemAdapter extends BaseAdapter {

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
            return list.get(position).getFno();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView= inflater.inflate(R.layout.food_item, null);
            }
            ImageView fphoto= (ImageView)convertView.findViewById(R.id.fphoto);
            TextView fname= (TextView)convertView.findViewById(R.id.fname);;
            ImageView fstar= (ImageView)convertView.findViewById(R.id.fstar);;
            TextView fdesc= (TextView)convertView.findViewById(R.id.fdesc);;

            Food food=list.get(position);
            fphoto.setImageResource(food.getFphoto());
            fname.setText(food.getFname());
            fstar.setImageResource(food.getFstar());
            fdesc.setText(food.getFdesc());

            return convertView;
        }
    }

    public void addItem(Food item){
        list.add(item);
        //데이터 변경시에 어댑터에게 알려주기 위한 코드
        itemAdapter.notifyDataSetChanged();
    }
    public void removeItem(Food item){
        list.remove(item);
        itemAdapter.notifyDataSetChanged();
    }

}
