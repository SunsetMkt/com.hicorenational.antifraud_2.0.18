package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.tencent.connect.common.Constants;
import interfaces.IClickListener;
import network.http.StatisticsShareHttp;
import ui.callview.CheckFraudResultCallView;
import ui.f.c;
import ui.presenter.CheckFraudResultPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CheckFraudResultActivity extends BaseActivity implements CheckFraudResultCallView {

    @BindView(R.id.tv_check_result)
    TextView mCheckResult;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_picture)
    ImageView mIvPicture;

    @BindView(R.id.iv_right)
    ImageView mIvRight;
    CheckFraudResultPresenter mPresent;
    private ui.f.c mShareDialog;

    @BindView(R.id.tv_appeal)
    TextView mTvAppeal;

    @BindView(R.id.tv_cotent)
    TextView mTvCotent;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_type)
    TextView mTvType;

    @BindView(R.id.warn_txt)
    TextView mWarnTxt;
    private ShareConfigBean shareBean = null;
    public CheckFraudBean mCheckFraudBean = null;
    private int model = 0;

    class a implements IClickListener {
        a() {
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void showResultData() {
        String str;
        String str2;
        CheckFraudBean checkFraudBean = this.mCheckFraudBean;
        if (checkFraudBean == null) {
            return;
        }
        int type = checkFraudBean.getType();
        if (this.mCheckFraudBean.getIsCheat() == 0) {
            this.mIvPicture.setImageResource(R.mipmap.ic_fraud_safe);
            this.mCheckResult.setText("\u672a\u77e5");
            this.mCheckResult.setTextColor(getResources().getColor(R.color.fraud_result_color));
            this.mWarnTxt.setVisibility(0);
            this.mTvAppeal.setVisibility(8);
        } else {
            this.mIvPicture.setImageResource(R.mipmap.ic_fraud);
            this.mCheckResult.setTextColor(getResources().getColor(R.color.red));
            this.mWarnTxt.setVisibility(8);
            int i2 = this.model;
            if (i2 == 1) {
                this.mTvAppeal.setVisibility(0);
                str = type == 2 ? "IP" : type == 3 ? "\u7f51\u5740" : "";
                if (this.mCheckFraudBean.getIsCheat() != 1) {
                    this.mCheckResult.setText("\u6d89\u8bc8" + str);
                } else if (this.mCheckFraudBean.getIsCheat() == 2) {
                    this.mCheckResult.setText("\u53ef\u7591" + str);
                }
            } else {
                if (i2 != 2) {
                    str = type != 1 ? "\u652f\u4ed8\u8d26\u6237" : "\u94f6\u884c\u5361\u53f7";
                } else if (type == 2) {
                    str = "\u5fae\u4fe1";
                } else if (type == 3) {
                    str = Constants.SOURCE_QQ;
                } else if (type == 5) {
                    str = "QQ/\u5fae\u4fe1";
                }
                if (this.mCheckFraudBean.getIsCheat() != 1) {
                }
            }
        }
        if (this.model == 0) {
            String bankName = this.mCheckFraudBean.getBankName();
            if (TextUtils.isEmpty(bankName)) {
                bankName = "";
            }
            TextView textView = this.mTvType;
            if (type != 1) {
                str2 = "\u8d26\u6237\u7c7b\u578b\uff1a";
            } else {
                str2 = "\u6240\u5c5e\u94f6\u884c\uff1a" + bankName;
            }
            textView.setText(str2);
        } else {
            this.mTvType.setVisibility(8);
        }
        String content = this.mCheckFraudBean.getContent();
        this.mTvCotent.setText("\u67e5\u8be2\u5185\u5bb9\uff1a" + content);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.mIvRight.setBackgroundResource(R.drawable.iv_share_dot);
        this.mPresent = new CheckFraudResultPresenter(this, this);
        this.model = getIntent().getIntExtra(util.p1.o0, 0);
        this.mCheckFraudBean = (CheckFraudBean) getIntent().getSerializableExtra(util.p1.m0);
        this.shareBean = (ShareConfigBean) getIntent().getSerializableExtra(util.p1.n0);
        int i2 = this.model;
        if (i2 == 1) {
            this.mTvTitle.setText("IP\u7f51\u5740\u67e5\u8be2");
        } else if (i2 == 2) {
            this.mTvTitle.setText("QQ/\u5fae\u4fe1\u67e5\u8be2");
        } else {
            this.mTvTitle.setText("\u652f\u4ed8\u98ce\u9669\u67e5\u8be2");
        }
        showResultData();
    }

    @Override // ui.callview.CheckFraudResultCallView
    public void onSuccessRequest() {
        e2.a("\u9519\u8bef\u4fe1\u606f\u4e0a\u62a5\u6210\u529f");
        this.mTvAppeal.setTextColor(Color.parseColor("#999999"));
        this.mTvAppeal.setEnabled(false);
    }

    @OnClick({R.id.iv_back, R.id.tv_report, R.id.tv_appeal, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back /* 2131296808 */:
                onBackPressed();
                break;
            case R.id.iv_right /* 2131296874 */:
                ShareConfigBean shareConfigBean = this.shareBean;
                if (shareConfigBean != null && !TextUtils.isEmpty(shareConfigBean.downloadUrl) && this.shareBean.downloadUrl.contains("{0}")) {
                    ShareConfigBean shareConfigBean2 = this.shareBean;
                    shareConfigBean2.downloadUrl = shareConfigBean2.downloadUrl.replace("{0}", e.a.m() + "");
                }
                this.mShareDialog = new ui.f.c(this.mActivity, this.shareBean, 2, new c.b() { // from class: ui.activity.p
                    @Override // ui.f.c.b
                    public final void a() {
                        StatisticsShareHttp.getInstance().shareOtherHttp("3");
                    }
                });
                this.mShareDialog.show();
                break;
            case R.id.tv_appeal /* 2131297584 */:
                util.f1.a(this.mActivity, "\u786e\u5b9a\u4e0a\u62a5\u67e5\u8be2\u9519\u8bef\u4fe1\u606f\u5417\uff1f", "", "\u53d6\u6d88", "\u786e\u5b9a", -1, -1, true, (IClickListener) new a());
                break;
            case R.id.tv_report /* 2131297848 */:
                Intent intent = new Intent();
                int i2 = this.model;
                if (i2 == 1) {
                    intent.setClass(this, UrlFraudActivity.class);
                } else if (i2 == 2) {
                    intent.setClass(this, ChatFraudActivity.class);
                } else {
                    intent.setClass(this, TradFraudActivity.class);
                }
                intent.putExtra(util.p1.m0, this.mCheckFraudBean);
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_check_fraud_result;
    }
}
