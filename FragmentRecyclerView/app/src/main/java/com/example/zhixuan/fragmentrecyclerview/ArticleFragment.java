package com.example.zhixuan.fragmentrecyclerview;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ArticleFragment extends Fragment {
    /*建立 Dialog 物件*/
    Dialog dialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*使dialog物件能於此視景(ArticleFragment)呈現*/
        dialog = new Dialog(getContext());
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article,container,false);
        GridView gridView = view.findViewById(R.id.gvUser);
        List<User> userList = getUserList();
        gridView.setAdapter(new UserAdapter(getContext(), userList));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                User user = (User) parent.getItemAtPosition(i);

                /* 功能：點擊作品及跳出該作品之小視窗(以Dialog模擬PopupWindow功能) */
                /* 建立變數 txtClose 為視窗右上角關閉圖示(可更換)，
                                                tvProductName為作品名稱，
                                                 tvIntroduction為作品簡介*/
                TextView txtClose, tvProductName, tvIntroduction;
                /* 建立變數 ivImg 為作品圖示，
                                                 ivCollection為點擊收藏按鈕(未具功能)*/
                ImageView ivImg, ivCollection;
                /*於res.layout之(custompopup.xml)設定小視窗的視景形式，並以dialog呈現*/
                dialog.setContentView(R.layout.custompopup);
                /*針對小視窗中呈現的各類View產生物件*/
                txtClose = (TextView)dialog.findViewById(R.id.txtclose);
                tvProductName = (TextView)dialog.findViewById(R.id.tvProductName);
                tvIntroduction = (TextView)dialog.findViewById(R.id.tvIntroduction);
                ivImg = (ImageView)dialog.findViewById(R.id.ivProductView);
                ivCollection = (ImageView)dialog.findViewById(R.id.ivCollectIcon);
                /*針對View設定內容(作品圖示、名稱、簡介)*/
                ivImg.setImageResource(user.getImage());
                tvProductName.setText(user.getName());
                tvIntroduction.setText(user.getDescribe());
                /*針對關閉圖示設定點擊事件*/
                txtClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*關閉小視窗(dialog)*/
                        dialog.dismiss();
                    }
                });
                /*針對收藏按鈕圖示設定點擊事件*/
                ivCollection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*預設為關閉小視窗(dialog)*/
                        dialog.dismiss();
                    }
                });
                /*啟動小視窗呈現的功能(經點擊特定作品後)*/
                dialog.show();

//                ImageView imageView = new ImageView(getContext());
//                imageView.setImageResource(user.getImage());
//                Toast toast = new Toast(getContext());
//                toast.setView(imageView);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.setDuration(Toast.LENGTH_LONG);
//                toast.setView(imageView);
//                toast.show();
            }
        });
        return view;
    }
    private class UserAdapter extends BaseAdapter {
        Context context;
        List<User> userList;

        UserAdapter(Context context, List<User> userList) {
            this.context = context;
            this.userList = userList;
        }

        @Override
        public int getCount() {
            return userList.size();
        }
        @Override
        public View getView(int position, View itemView, ViewGroup parent){
            if (itemView ==null){
                LayoutInflater layoutInflater=LayoutInflater.from(context);
                itemView=layoutInflater.inflate(R.layout.activity_user,parent,false);
            }
            User member = userList.get(position);
            ImageView ivImage = itemView
                    .findViewById(R.id.imgPaint);
            ivImage.setImageResource(member.getImage());

            TextView tvId = itemView
                    .findViewById(R.id.tvName);
            tvId.setText(String.valueOf(member.getName()));

            TextView tvName = itemView
                    .findViewById(R.id.tvDes);
            tvName.setText(member.getDescribe());
            // itemView.setBackgroundColor(Color.parseColor("#efc0c0"));
            return itemView;
        }

        @Override
        public Object getItem(int position) {
            return userList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return userList.get(position).getImage();
        }
    }

    public List<User> getUserList() {
        List<User> memberList = new ArrayList<>();
        memberList.add(new User(R.drawable.novel01, "Emma", "Lorem Ipsum is simply ever ."));
        memberList.add(new User(R.drawable.novel02, "Girl", "There are many of passages."));
        memberList.add(new User(R.drawable.novel03, "PigPig", "Contrary to popular ."));
        memberList.add(new User(R.drawable.novel04, "Ipsum", "lorem Ipsum is simply ever ."));
        memberList.add(new User(R.drawable.novel05, "simply", "There are many of passages."));
        memberList.add(new User(R.drawable.novel06, "Contrary", "Contrary to popular belief."));
        memberList.add(new User(R.drawable.novel07, "Lorem", "Lorem Ipsum is simply ever ."));
        memberList.add(new User(R.drawable.novel08, "Diary", "There are many of passages."));


        return memberList;
    }
}
