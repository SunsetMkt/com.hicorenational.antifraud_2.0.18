package p388ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import bean.CheckUserBean;
import bean.UserInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import p388ui.callview.MinePersonalView;
import p388ui.presenter.MinePersonalPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7307p1;
import util.C7325u1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class MinePersonalActivity extends BaseActivity implements MinePersonalView {
    private boolean basicInfo = false;
    private boolean isFirstReq = true;

    @BindView(C2113R.id.area)
    TextView mArea;

    @BindView(C2113R.id.area_detail)
    TextView mAreaDetail;

    @BindView(C2113R.id.user_ID)
    TextView mIdentityCardNum;

    @BindView(C2113R.id.ll_idfine_var)
    View mLlIdFineVar;
    MinePersonalPresenter mPresenter;

    @BindView(C2113R.id.pb_progress)
    ProgressBar mProgress;

    @BindView(C2113R.id.ll_top_cointips)
    View mTopCoinTip;

    @BindView(C2113R.id.area_label)
    TextView mTvAreaLable;

    @BindView(C2113R.id.tv_idfine_var)
    TextView mTvIdFineVar;

    @BindView(C2113R.id.ID_label)
    TextView mTvIdLable;

    @BindView(C2113R.id.name_label)
    TextView mTvNameLable;

    @BindView(C2113R.id.tv_progress)
    TextView mTvProgress;

    @BindView(C2113R.id.reg_area)
    TextView mTvRegArea;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.user_name)
    TextView mUserName;
    private int pageType;
    UserInfoBean userInfo;

    /* renamed from: ui.activity.MinePersonalActivity$a */
    class C6390a implements IClickListener {
        C6390a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            MinePersonalActivity.this.veriFiedIntent();
        }
    }

    private void progressShow(UserInfoBean userInfoBean) {
        int erfectProgress = this.userInfo.getErfectProgress();
        if (TextUtils.isEmpty(this.userInfo.getName()) && !TextUtils.isEmpty(userInfoBean.getName())) {
            erfectProgress += 30;
        }
        if (TextUtils.isEmpty(this.userInfo.getIdNumber()) && !TextUtils.isEmpty(userInfoBean.getIdNumber())) {
            erfectProgress += 30;
        }
        if (TextUtils.isEmpty(this.userInfo.getRegion()) && !TextUtils.isEmpty(userInfoBean.getRegion())) {
            erfectProgress += 20;
        }
        if (TextUtils.isEmpty(this.userInfo.getAddr()) && !TextUtils.isEmpty(userInfoBean.getAddr())) {
            erfectProgress += 20;
        }
        if (erfectProgress >= 100) {
            erfectProgress = 100;
        }
        userInfoBean.setErfectProgress(erfectProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void veriFiedIntent() {
        C7325u1.m26628b(C7325u1.f25707x0, 4);
        startActivity(new Intent(this.mActivity, (Class<?>) VerifyFaceActivity.class));
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mPresenter = new MinePersonalPresenter(this, this);
        this.mTvTitle.setText("个人信息");
        this.pageType = getIntent().getIntExtra(C7292k1.f25394d, 0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.pageType == 1) {
            C7337y1.m26748a((Context) this.mActivity, (Class<?>) MainActivity.class);
        } else {
            C6049c.m24987f().m25000d(new C7265a(C7265a.f25265u0, null));
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 20) {
            return;
        }
        this.mPresenter.getUserInfo();
    }

    @Override // p388ui.callview.MinePersonalView
    public void onFailRequest() {
        veriFiedIntent();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        UserInfoBean userInfoBean = (UserInfoBean) C7307p1.m26476a(C7307p1.f25503l, UserInfoBean.class);
        if (this.userInfo == null) {
            this.mPresenter.getUserInfo();
        } else {
            progressShow(userInfoBean);
            onSuccRequest(userInfoBean);
        }
    }

    @Override // p388ui.callview.MinePersonalView
    public void onSuccRequest(UserInfoBean userInfoBean) {
        C7307p1.m26478a(C7307p1.f25503l, userInfoBean);
        this.userInfo = userInfoBean;
        this.mTvProgress.setText("已完善" + userInfoBean.getErfectProgress() + "%");
        this.mProgress.setProgress(userInfoBean.getErfectProgress());
        String name = userInfoBean.getName();
        String idNumber = userInfoBean.getIdNumber();
        String addr = TextUtils.isEmpty(userInfoBean.getAddr()) ? "" : userInfoBean.getAddr();
        String region = TextUtils.isEmpty(userInfoBean.getRegion()) ? "" : userInfoBean.getRegion();
        String registerRegion = TextUtils.isEmpty(userInfoBean.getRegisterRegion()) ? "" : userInfoBean.getRegisterRegion();
        this.mIdentityCardNum.setText(TextUtils.isEmpty(idNumber) ? "" : idNumber);
        this.mArea.setText(region);
        this.mAreaDetail.setText(addr);
        this.mUserName.setText(name);
        this.mTvRegArea.setText(registerRegion);
        if (userInfoBean.getAuditstatus() == 0) {
            this.mTvIdFineVar.setText("去身份认证");
            this.mTvIdFineVar.setVisibility(0);
            this.mLlIdFineVar.setVisibility(8);
            this.mUserName.setVisibility(8);
        } else if (userInfoBean.getAuditstatus() == 1) {
            this.mTvIdFineVar.setVisibility(8);
            this.mLlIdFineVar.setVisibility(0);
            this.mUserName.setVisibility(0);
        } else if (userInfoBean.getAuditstatus() == 2) {
            this.mUserName.setText("审核中");
            this.mUserName.setVisibility(0);
            this.mTvIdFineVar.setVisibility(8);
            this.mLlIdFineVar.setVisibility(8);
        } else if (userInfoBean.getAuditstatus() == 3) {
            this.mTvIdFineVar.setText("身份认证未通过");
            this.mTvIdFineVar.setTextColor(Color.parseColor("#FF0000"));
            this.mTvIdFineVar.setVisibility(0);
            this.mLlIdFineVar.setVisibility(8);
            this.mUserName.setVisibility(8);
        }
        String professionName = userInfoBean.getProfessionName();
        if (this.isFirstReq) {
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(idNumber) || TextUtils.isEmpty(region) || TextUtils.isEmpty(addr) || TextUtils.isEmpty(professionName)) {
                this.basicInfo = false;
            } else {
                this.basicInfo = true;
                this.mTopCoinTip.setVisibility(8);
            }
        } else if (this.basicInfo) {
            this.mTopCoinTip.setVisibility(8);
        } else if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(idNumber) && !TextUtils.isEmpty(region) && !TextUtils.isEmpty(addr) && !TextUtils.isEmpty(professionName)) {
            this.mTopCoinTip.setVisibility(8);
            this.basicInfo = true;
        }
        this.isFirstReq = false;
    }

    @Override // p388ui.callview.MinePersonalView
    public void onSuccess(CheckUserBean checkUserBean) {
        if (checkUserBean == null) {
            veriFiedIntent();
            return;
        }
        C7257b1.m26211b(this.mActivity, "实名认证未通过", "未通过原因：" + checkUserBean.getAuditMessage(), "我知道了", "重新验证", new C6390a());
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_idfine_var, C2113R.id.area, C2113R.id.area_detail})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.area /* 2131296352 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) PersonalInfoAddActivity.class);
                intent.putExtra(C7292k1.f25391c, this.userInfo);
                intent.putExtra(C7292k1.f25394d, 1);
                startActivity(intent);
                break;
            case C2113R.id.area_detail /* 2131296353 */:
                Intent intent2 = new Intent(this.mActivity, (Class<?>) PersonalInfoAddActivity.class);
                intent2.putExtra(C7292k1.f25391c, this.userInfo);
                intent2.putExtra(C7292k1.f25394d, 11);
                startActivity(intent2);
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.tv_idfine_var /* 2131297573 */:
                UserInfoBean userInfoBean = this.userInfo;
                if (userInfoBean != null && userInfoBean.getAuditstatus() == 3) {
                    this.mPresenter.checkisverify();
                    break;
                } else {
                    veriFiedIntent();
                    break;
                }
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_mine_personal;
    }
}
