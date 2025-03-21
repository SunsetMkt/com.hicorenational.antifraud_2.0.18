package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ShareConfigBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import network.http.StatisticsShareHttp;
import p245d.C4440a;
import p388ui.callview.CheckFraudResultCallView;
import p388ui.p391f.DialogC6827c;
import p388ui.presenter.CheckFraudResultPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CheckFraudResultActivity extends BaseActivity implements CheckFraudResultCallView {

    @BindView(C2113R.id.tv_check_result)
    TextView mCheckResult;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.iv_picture)
    ImageView mIvPicture;

    @BindView(C2113R.id.iv_right)
    ImageView mIvRight;
    CheckFraudResultPresenter mPresent;
    private DialogC6827c mShareDialog;

    @BindView(C2113R.id.tv_appeal)
    TextView mTvAppeal;

    @BindView(C2113R.id.tv_cotent)
    TextView mTvCotent;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.tv_type)
    TextView mTvType;

    @BindView(C2113R.id.warn_txt)
    TextView mWarnTxt;
    private ShareConfigBean shareBean = null;
    public CheckFraudBean mCheckFraudBean = null;
    private int model = 0;

    /* renamed from: ui.activity.CheckFraudResultActivity$a */
    class C6229a implements IClickListener {
        C6229a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CheckFraudResultActivity checkFraudResultActivity = CheckFraudResultActivity.this;
            checkFraudResultActivity.mPresent.reportFraudIpUrlHttp(checkFraudResultActivity.mCheckFraudBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void showResultData() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p388ui.activity.CheckFraudResultActivity.showResultData():void");
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, true);
        this.mIvRight.setBackgroundResource(C2113R.drawable.iv_share_dot);
        this.mPresent = new CheckFraudResultPresenter(this, this);
        this.model = getIntent().getIntExtra(C7292k1.f25425o0, 0);
        this.mCheckFraudBean = (CheckFraudBean) getIntent().getSerializableExtra(C7292k1.f25421m0);
        this.shareBean = (ShareConfigBean) getIntent().getSerializableExtra(C7292k1.f25423n0);
        int i2 = this.model;
        if (i2 == 1) {
            this.mTvTitle.setText("IP网址查询");
        } else if (i2 == 2) {
            this.mTvTitle.setText("QQ/微信查询");
        } else {
            this.mTvTitle.setText("支付风险查询");
        }
        showResultData();
    }

    @Override // p388ui.callview.CheckFraudResultCallView
    public void onSuccessRequest() {
        C7331w1.m26688a("错误信息上报成功");
        this.mTvAppeal.setTextColor(Color.parseColor("#999999"));
        this.mTvAppeal.setEnabled(false);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_report, C2113R.id.tv_appeal, C2113R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.iv_right /* 2131296826 */:
                ShareConfigBean shareConfigBean = this.shareBean;
                if (shareConfigBean != null && !TextUtils.isEmpty(shareConfigBean.downloadUrl) && this.shareBean.downloadUrl.contains("{0}")) {
                    ShareConfigBean shareConfigBean2 = this.shareBean;
                    shareConfigBean2.downloadUrl = shareConfigBean2.downloadUrl.replace("{0}", C4440a.m16411m() + "");
                }
                this.mShareDialog = new DialogC6827c(this.mActivity, this.shareBean, 2, new DialogC6827c.b() { // from class: ui.activity.n
                    @Override // p388ui.p391f.DialogC6827c.b
                    /* renamed from: a */
                    public final void mo25436a() {
                        StatisticsShareHttp.getInstance().shareOtherHttp("3");
                    }
                });
                this.mShareDialog.show();
                break;
            case C2113R.id.tv_appeal /* 2131297426 */:
                C7257b1.m26184a(this.mActivity, "确定上报查询错误信息吗？", "", "取消", "确定", -1, -1, true, (IClickListener) new C6229a());
                break;
            case C2113R.id.tv_report /* 2131297687 */:
                Intent intent = new Intent();
                int i2 = this.model;
                if (i2 == 1) {
                    intent.setClass(this, UrlFraudActivity.class);
                } else if (i2 == 2) {
                    intent.setClass(this, ChatFraudActivity.class);
                } else {
                    intent.setClass(this, TradFraudActivity.class);
                }
                intent.putExtra(C7292k1.f25421m0, this.mCheckFraudBean);
                startActivity(intent);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_check_fraud_result;
    }
}
