package com.dhcc.visa.persenter;

import com.dhcc.visa.model.network.VisaClient;
import com.dhcc.visa.ui.view.user.login.ILoginView;
import com.dhcc.visa.persenter.base.BasePersenter;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Lituo on 2017/4/5 0005. 16:15 .
 * Mail：tony1994_vip@163.com
 * <p>
 * 登陆的逻辑实现
 */

public class LoginPersenter extends BasePersenter<ILoginView> {

    private Call mCall;

    /*登陆的逻辑实现*/
    public void login() {
        getView().loading();
        /*
        *登录逻辑*/
        mCall = VisaClient.getInstance().login("annie", "123654");

        mCall.enqueue(new Callback() {//运行在子线程中，不能更新视图,一般用UICallBack(自定义)
            @Override
            public void onFailure(Call call, IOException e) {
                /* 失败*/
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
/*成功*/
            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getView().loadingEnd();
            }
        }, 1500);

    }
}
