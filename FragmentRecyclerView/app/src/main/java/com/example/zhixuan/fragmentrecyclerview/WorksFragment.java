package com.example.zhixuan.fragmentrecyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class WorksFragment extends Fragment {
    Button btPaint,btArticle,btRecord;
    private FragmentManager fragmentManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_works,container,false);

      btPaint=view.findViewById(R.id.btPaint);
        btArticle=view.findViewById(R.id.btArticle);
        btRecord=view.findViewById(R.id.btRecord);
        fragmentManager=getFragmentManager();
        btArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecordFragment recordFragment = new RecordFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame1,recordFragment);
                transaction.commit();
            }
        });

        btArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArticleFragment articleFragment = new ArticleFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame1, articleFragment);
                transaction.commit();
            }
        });

        btPaint.setOnClickListener(new View.OnClickListener() {
           @Override
    public void onClick(View v) {

               PaintFragment paintFragment = new PaintFragment();
               FragmentTransaction transaction = fragmentManager.beginTransaction();
               transaction.replace(R.id.frame1,paintFragment);
               transaction.commit();

    }
});

        PaintFragment paintFragment = new PaintFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame1,paintFragment);
        transaction.commit();
        return view;




        }

        }


