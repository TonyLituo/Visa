package com.dhcc.visa.ui.view.user.login;

import com.dhcc.visa.ui.base.IBaseView;

/**
 * Created by Lituo on 2017/4/5 0005. 16:44 .
 * Mail：tony1994_vip@163.com
 *
 * 登录的视图接口,需要什么视图操作都可以定义相应的方法
 */

public interface ILoginView extends IBaseView {

    void loading();

    void loadingEnd();

}
