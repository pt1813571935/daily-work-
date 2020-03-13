package com.umeng.shixunkaoshi.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.shixunkaoshi.Bean;
import com.umeng.shixunkaoshi.R;
import com.umeng.shixunkaoshi.adapter.RecAdapter;
import com.umeng.shixunkaoshi.presenter.MainPresenter;
import com.umeng.shixunkaoshi.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class TopicFragment extends Fragment implements MainView {
    private View view;
    private RecyclerView mRec;
    private MainPresenter presenter;

    private RecAdapter adapter;
    private ArrayList<Bean.DataBeanX.DataBean> dataBeans;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topic_layout, null);
        presenter = new MainPresenter(this);
        initView(view);
        initData();
        initRec();
        return view;
    }

    private void initRec() {
        dataBeans = new ArrayList<>();
        adapter = new RecAdapter(getContext(), dataBeans);
        mRec.setAdapter(adapter);
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
      /*  adapter.setOnClick(new RecAdapter.OnClick() {
            @Override
            public void onclick(int position) {
                Intent intent = new Intent(getContext(), ContentActivity.class);
                intent.putExtra("title",recentBeans.get(position).getTitle());
                startActivity(intent);
            }

            @Override
            public void onlongclick(final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("是否插入数据库");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RecentBeanDao beanDao = BaseApp.getInstance().getDaoSession().getRecentBeanDao();
                        beanDao.insertOrReplace(recentBeans.get(position));
                        Toast.makeText(getContext(), "插入成功", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();
              *//*  View view = View.inflate(getContext(), R.layout.pw_layout, null);
                PopupWindow pw = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                pw.showAtLocation(mRec,Gravity.CENTER,0,0);
                Button affrim = view.findViewById(R.id.affrim);
                affrim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        *//*
            }
        });*/
    }

    private void initData() {
        presenter.getData();
    }

    private void initView(View view) {
        mRec = (RecyclerView) view.findViewById(R.id.topic_rec);
    }


    @Override
    public void setData(Bean bean) {
        List<Bean.DataBeanX.DataBean> data = bean.getData().getData();
        dataBeans.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
