package com.umeng.shixunkaoshi.presenter;


import com.umeng.shixunkaoshi.Bean;
import com.umeng.shixunkaoshi.api.ResultCallBack;
import com.umeng.shixunkaoshi.model.MainModel;
import com.umeng.shixunkaoshi.view.MainView;

public class MainPresenter {
    private MainView view;
    private final MainModel model;

    public MainPresenter(MainView view) {
        model = new MainModel();
        this.view = view;
    }

    public void getData() {
        model.getData(new ResultCallBack() {
            @Override
            public void OnSecuess(Bean bean) {
                if (bean!=null && bean.getData()!=null&& bean.getData().getData().size()>0&& view!=null){
                    view.setData(bean);
                }
            }

            @Override
            public void OnFail(String error) {

            }
        });
    }
}
