package com.umeng.shixunkaoshi.api;


import com.umeng.shixunkaoshi.Bean;

public interface ResultCallBack {
   void OnSecuess(Bean bean);
   void OnFail(String error);
}
