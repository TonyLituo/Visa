package com.dhcc.visa.ui.view.user.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.LoginPersenter;
import com.dhcc.visa.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<ILoginView, LoginPersenter> implements ILoginView {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.pgb)
    ProgressBar mPgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
      presenter.login();
    }

    @NonNull
    @Override
    public LoginPersenter createPresenter() {
        return new LoginPersenter();
    }

    @Override
    public void loading() {
        mPgb.setVisibility(View.VISIBLE);
        Toast.makeText(this, "开始加载！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadingEnd() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPgb.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "加载完成！", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
