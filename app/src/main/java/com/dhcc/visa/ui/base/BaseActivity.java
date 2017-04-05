package com.dhcc.visa.ui.base;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by Lituo on 2017/4/5 0005. 16:05 .
 * Mail：tony1994_vip@163.com
 * Activity的基类
 */

public abstract class BaseActivity<V extends IBaseView, P extends MvpPresenter<V>> extends MvpActivity<V,P>{


}
