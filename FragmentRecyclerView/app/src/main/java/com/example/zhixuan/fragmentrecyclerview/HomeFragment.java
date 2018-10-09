package com.example.zhixuan.fragmentrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        getActivity(),LinearLayoutManager.HORIZONTAL,false));

        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(
                new LinearLayoutManager(
                        getActivity(),LinearLayoutManager.HORIZONTAL,false));

        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerView3);
        recyclerView3.setLayoutManager(
                new LinearLayoutManager(
                        getActivity(),LinearLayoutManager.HORIZONTAL,false));

        /*SnapHelper用於支持RecycleView的對齊方式，即通過計算對齊RecycleView中TargetView的指定點或容器中任何像素點*/
        /*  PageSnapHelper()限制只能滑動一頁    */
        SnapHelper snapHelper = new PagerSnapHelper();
        /*  attachToRecycleView(RecycleView recycleView) 將SnapHelper連接到RecycleView  */
        snapHelper.attachToRecyclerView(recyclerView);

        SnapHelper snapHelper2 = new PagerSnapHelper();
        snapHelper2.attachToRecyclerView(recyclerView2);

        SnapHelper snapHelper3 = new PagerSnapHelper();
        snapHelper3.attachToRecyclerView(recyclerView3);

        List<Drawings> drawingsList = getDrawingsList();
        List<User> userList = getUserList();
        List<User> recordList = getRecordList();
        recyclerView.setAdapter(new DrawingsAdapter(getActivity(),drawingsList));
        recyclerView2.setAdapter(new InverseDrawingsAdapter(getActivity(),userList));
        recyclerView3.setAdapter(new RecordAdapter(getActivity(),recordList));

        return view;
    }

    public List<Drawings> getDrawingsList() {
        List<Drawings> drawingsList = new ArrayList<>();
        drawingsList.add(new Drawings(R.drawable.biology,"John","Lorem ipsum dolor sit amet, sed molestie amet, habitasse est ipsum esse sed pede nulla, vivamus ullamcorper ligul"));
        drawingsList.add(new Drawings(R.drawable.businessman,"Anne","Ullamcorper interdum. Mauris vel pede fusce fusce lorem, massa nunc, eleifend duis velit porttitor viverra sed. Suspendisse justo rhoncus nullam phasellus. Augue ligula nunc nec pellentesque."));
        drawingsList.add(new Drawings(R.drawable.email,"Alex","equat libero lectus netus, fermentum ipsum quam vitae curabitur suspendisse consectetuer."));
        drawingsList.add(new Drawings(R.drawable.football,"Max","alesuada et, tortor dolor ligula eros nullam ultricies, morbi suscipit vel neque adipiscing sit pede. Duis aptent lacus, pede lorem taciti, justo vestibulum nunc, feugiat pellentesqu"));
        drawingsList.add(new Drawings(R.drawable.graduate,"Wendy","Curabitur justo, mus libero erat, consequat aliquam dolor nunc tortor. Nisl nec vestibulum felis"));
        drawingsList.add(new Drawings(R.drawable.printer,"William","Ut est ultrices sociosqu nec, libero et consectetuer, wisi sem id lacus, augue scelerisque ultrices et donec quam"));
        drawingsList.add(new Drawings(R.drawable.violin,"Lisa","suspendisse odio nonummy, lectus vestibulum eleifend iaculis dictum ut vel. Leo wisi sunt nostra velit in, ornare velit ullamcorper, eget turpis est interdum ante accumsan adipiscing, quis consectetuer. Nullam vel, nam adipiscing nullam odio elit, et pede facilisis vel, donec et sit cras rhoncus cras odio, id auctor.\n" +
                "\n"));
        return drawingsList;
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

    public List<User> getRecordList() {
        List<User> memberList2 = new ArrayList<>();
        memberList2.add(new User(R.drawable.play01, "Mim", "Lorem Ipsum is simply ever ."));
        memberList2.add(new User(R.drawable.play02, "Belief", "There are many of passages."));
        memberList2.add(new User(R.drawable.play03, "Pegasus", "Contrary to popular ."));
        memberList2.add(new User(R.drawable.play04, "Popular", "lorem Ipsum is simply ever ."));
        memberList2.add(new User(R.drawable.play05, "simply", "There are many of passages."));
        memberList2.add(new User(R.drawable.play09, "Contrary", "Contrary to popular belief."));
        memberList2.add(new User(R.drawable.play07, "Lorem", "Lorem Ipsum is simply ever ."));
        memberList2.add(new User(R.drawable.play08, "Winnie", "There are many of passages."));
        
        return memberList2;
    }

    private class DrawingsAdapter extends RecyclerView.Adapter<DrawingsAdapter.MyViewHolder> {
        private Context homeFragment;
        private List<Drawings> drawingsList;

        DrawingsAdapter(Context homeFragment, List<Drawings> drawingsList) {
            this.homeFragment = homeFragment;
            this.drawingsList = drawingsList;
        }

        @NonNull
        @Override
        public DrawingsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.home_item,viewGroup,false);
            return new MyViewHolder(itemView);
        }
        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView tvAuthor, tvContent;
            MyViewHolder(View itemView){
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                tvAuthor = itemView.findViewById(R.id.tvAuthor);
                tvContent = itemView.findViewById(R.id.tvContent);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull DrawingsAdapter.MyViewHolder myViewHolder, int i) {
            final Drawings drawings = drawingsList.get(i);
            myViewHolder.imageView.setImageResource(drawings.getImage());
            myViewHolder.tvAuthor.setText(drawings.getAuthor());
            myViewHolder.tvContent.setText(drawings.getContent());
//            myViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
//
//                @Override
//                public void onClick(View view) {
//
//                }
//            });

        }

        @Override
        public int getItemCount() {
            return drawingsList.size();
        }
    }

    private class InverseDrawingsAdapter extends RecyclerView.Adapter<InverseDrawingsAdapter.MysViewHolder>{
        private Context homeFragment;
        private List<User> userList;
        InverseDrawingsAdapter(Context homeFragment, List<User> userList){
            this.homeFragment = homeFragment;
            this.userList = userList;
        }
        @NonNull
        @Override
        public InverseDrawingsAdapter.MysViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.home_item2,viewGroup,false);
            return new MysViewHolder(itemView);
        }
        class MysViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView2;
            TextView tvAuthor2, tvContent2;
            MysViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView2 = itemView.findViewById(R.id.imageView2);
                tvAuthor2 = itemView.findViewById(R.id.tvAuthor2);
                tvContent2 = itemView.findViewById(R.id.tvContent2);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull InverseDrawingsAdapter.MysViewHolder mysViewHolder, int i) {
            final User users = userList.get(i);
            mysViewHolder.tvAuthor2.setText(users.getName());
            mysViewHolder.tvContent2.setText(users.getDescribe());
            mysViewHolder.imageView2.setImageResource(users.getImage());
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }

    private class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecViewHolder>{
        private Context homeFragment;
        private List<User> userList;
        RecordAdapter(Context homeFragment, List<User> userList){
            this.homeFragment = homeFragment;
            this.userList = userList;
        }
        @NonNull
        @Override
        public RecordAdapter.RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.home_item,viewGroup,false);
            return new RecViewHolder(itemView);
        }

        class RecViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView tvAuthor, tvContent;
            RecViewHolder(@NonNull View itemView){
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                tvAuthor = itemView.findViewById(R.id.tvAuthor);
                tvContent = itemView.findViewById(R.id.tvContent);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecordAdapter.RecViewHolder recViewHolder, int i) {
            final User users = userList.get(i);
            recViewHolder.imageView.setImageResource(users.getImage());
            recViewHolder.tvAuthor.setText(users.getName());
            recViewHolder.tvContent.setText(users.getDescribe());
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }
}

