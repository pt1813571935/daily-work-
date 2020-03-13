package com.umeng.shixunkaoshi.api;



import com.umeng.shixunkaoshi.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BaseUrl="https://cdwan.cn/api/";
    @GET("topic/list")
    Observable<Bean> getData();
}
