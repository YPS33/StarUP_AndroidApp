package com.example.zhixuan.fragmentrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class User  {
    private int image;
    private String name;
    private String describe;

    public User(){super();}

    public User(int image ,String name, String describe){
        super();
        this.image=image;
        this.name=name;
        this.describe=describe;

    }

    public int getImage(){return image;}

    public void setImage(int image){this.image=image;}

    public String getName(){return name;}

   public void setName(String name){this.name=name;}

   public String getDescribe(){return describe;}

   public void setDescribe(String describe){this.describe=describe;}

}
