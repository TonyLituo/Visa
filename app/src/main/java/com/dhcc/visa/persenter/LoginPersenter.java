package com.dhcc.visa.persenter;

import com.dhcc.visa.ui.view.user.login.ILoginView;
import com.dhcc.visa.persenter.base.BasePersenter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Lituo on 2017/4/5 0005. 16:15 .
 * Mail：tony1994_vip@163.com
 */

public class LoginPersenter extends BasePersenter<ILoginView> {


    /*登陆的逻辑实现*/
    public void login() {
        getView().loading();
        /*
        *登录逻辑*/
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getView().loadingEnd();
            }
        }, 1500);

    }
}
