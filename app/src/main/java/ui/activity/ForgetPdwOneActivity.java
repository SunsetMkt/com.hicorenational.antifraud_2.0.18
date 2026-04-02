package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.ForgetPwdCallView;
import ui.presenter.ForgetPresenter;
import ui.view.swip.SwipBackLayout;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class ForgetPdwOneActivity extends BaseActivity implements ForgetPwdCallView {
    ForgetPresenter forgetPresenter;

    @BindView(R.id.confirm)
    TextView mConfim;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.phone_code)
    EditText mPhoneCode;

    @BindView(R.id.phone_label)
    TextView mPhoneLable;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    class a implements IEditAfterListener {
        a() {
        }

        @Override // interfaces.IEditAfterListener
        public void editLength(int i2) {
            if (i2 > 0) {
                ForgetPdwOneActivity.this.mConfim.setEnabled(true);
                ForgetPdwOneActivity.this.mIvClean.setVisibility(0);
            } else {
                ForgetPdwOneActivity.this.mConfim.setEnabled(false);
                ForgetPdwOneActivity.this.mIvClean.setVisibility(4);
            }
        }
    }

    private void initListener() {
        util.h1.a(this.mPhoneCode, new a());
        this.phoneNum = getIntent().getStringExtra(util.p1.e0);
        if (TextUtils.isEmpty(this.phoneNum)) {
            return;
        }
        this.mPhoneCode.setText(this.phoneNum);
    }

    public /* synthetic */ void a() {
        this.forgetPresenter.verificationSubmit(this.mPhoneCode.getText().toString(), 3);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10205e);
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        initListener();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 23) {
            return;
        }
        finish();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) VerifyPhoneCodeActivity.class);
        intent.putExtra(util.p1.F, this.mPhoneCode.getText().toString());
        intent.putExtra(util.p1.E, i2);
        startActivity(intent);
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.confirm})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.confirm) {
            if (g2.a(util.u1.t, true)) {
                toYanzheng(new IOneClickListener() { // from class: ui.activity.r
                    @Override // interfaces.IOneClickListener
                    public final void clickOKBtn() {
                        this.a.a();
                    }
                });
                return;
            } else {
                this.forgetPresenter.verificationSubmit(this.mPhoneCode.getText().toString(), 3);
                return;
            }
        }
        if (id == R.id.iv_back) {
            finish();
        } else {
            if (id != R.id.iv_clear) {
                return;
            }
            this.mPhoneCode.setText("");
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_forger_one;
    }
}
