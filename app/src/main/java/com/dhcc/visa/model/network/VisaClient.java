package com.dhcc.visa.model.network;

import com.dhcc.visa.model.api.Api;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Lituo on 2017/4/5 0005. 16:31 .
 * Mail：tony1994_vip@163.com
 * 统一网络访问客户端
 */

public class VisaClient {
    //单例模式
    private static VisaClient sClient;

    private final OkHttpClient mOkHttpClient;

    private VisaClient() {
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static VisaClient getInstance() {
        if (null == sClient) {
            synchronized (VisaClient.class) {
                if (null == sClient) {
                    sClient = new VisaClient();
                }
            }
        }
        return sClient;
    }


    /*
    * 网络请求全部放在这里
    *
    *
    * */

    /**
     * 以下为测试用  表单格式请求数据
     *
     * @return
     */
    public Call login(String username, String password) {

        RequestBody body = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(Api.URL_TEST)
                .post(body)
                .build();
        return mOkHttpClient.newCall(request);
    }
}
