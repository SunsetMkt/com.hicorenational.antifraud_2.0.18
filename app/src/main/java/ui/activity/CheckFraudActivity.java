package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bean.APIH5Bean;
import bean.CheckFraudBean;
import bean.CheckFraudCountBean;
import bean.ShareConfigBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IEditAfterListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.List;
import network.account.APIresult;
import network.http.StatisticsHttp;
import network.http.StatisticsShareHttp;
import ui.Hicore;
import ui.callview.CheckFraudCallView;
import ui.f.c;
import ui.presenter.CheckFraudPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class CheckFraudActivity extends BaseActivity implements CheckFraudCallView {

    @BindView(R.id.et_content)
    EditText mEtContent;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_clear)
    ImageView mIvClear;

    @BindView(R.id.iv_right)
    ImageView mIvRight;
    private CheckFraudPresenter mPresenter;

    @BindView(R.id.rb_chat)
    RadioButton mRbChat;

    @BindView(R.id.rb_pay)
    RadioButton mRbPay;

    @BindView(R.id.rb_url)
    RadioButton mRbUrl;
    private ui.f.c mShareDialog;

    @BindView(R.id.tv_count_tip)
    TextView mTvCount_tip;

    @BindView(R.id.ll_scan)
    LinearLayout mTvScan;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private ArrayList<Integer> source;
    private ShareConfigBean shareBean = new ShareConfigBean();
    private int model = 0;

    class a implements IEditAfterListener {
        a() {
        }

        @Override // interfaces.IEditAfterListener
        public void editLength(int i2) {
            if (i2 > 0) {
                CheckFraudActivity.this.mIvClear.setVisibility(0);
            } else {
                CheckFraudActivity.this.mIvClear.setVisibility(8);
            }
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(CheckFraudActivity.this.mActivity, list, z, true, this);
            if (z) {
                CheckFraudActivity.this.resetPerssionChecking();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            k.e.a(CheckFraudActivity.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(1);
        }
    }

    private void changeState(boolean z) {
        this.mEtContent.setText("");
        int i2 = this.model;
        if (i2 == 1) {
            radioState(this.mRbUrl, this.mRbPay, this.mRbChat, R.mipmap.ic_fraud_radio_center);
            this.mEtContent.setHint("\u8bf7\u8f93\u5165\u6216\u7c98\u8d34\u8981\u67e5\u8be2\u7684IP\u6216URL\u7f51\u5740");
            this.mTvScan.setVisibility(0);
        } else if (i2 == 2) {
            radioState(this.mRbChat, this.mRbPay, this.mRbUrl, R.mipmap.ic_fraud_radio_right);
            this.mEtContent.setHint("\u8bf7\u8f93\u5165\u6216\u7c98\u8d34\u8981\u67e5\u8be2\u7684QQ\u6216\u5fae\u4fe1\u8d26\u53f7");
            this.mTvScan.setVisibility(8);
        } else {
            radioState(this.mRbPay, this.mRbUrl, this.mRbChat, R.mipmap.ic_fraud_radio_left);
            this.mEtContent.setHint("\u8bf7\u8f93\u5165\u6216\u7c98\u8d34\u8981\u67e5\u8be2\u7684\u94f6\u884c\u5361\u53f7\u6216\u652f\u4ed8\u8d26\u6237");
            this.mTvScan.setVisibility(8);
        }
        if (z) {
            return;
        }
        this.mPresenter.checkFraudCount(this.model);
    }

    private void checkPermission() {
        this.isPerssionChecking = true;
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f15026c}, new b());
    }

    private String getColorStr(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<font color=");
        sb.append(i2 > 0 ? "#1A57F3" : "#FF0000");
        sb.append(">");
        sb.append(i2);
        sb.append("</font>");
        return sb.toString();
    }

    private String getTruePath(String str) {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return uri.getPath();
        }
        Cursor cursorQuery = getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                cursorQuery.close();
                return string;
            }
        }
        return "";
    }

    private void initView() {
        this.mRbPay.setTypeface(this.typ_ME);
        this.mRbUrl.setTypeface(this.typ_ME);
        this.mRbChat.setTypeface(this.typ_ME);
        this.mEtContent.setTypeface(this.typ_ME);
        this.mIvClear.setVisibility(8);
        util.h1.a(this.mEtContent, new a());
        this.mPresenter = new CheckFraudPresenter(this.mActivity, this);
        this.mPresenter.requestShareConfig();
    }

    private void radioState(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, int i2) {
        radioButton.setBackground(getResources().getDrawable(i2));
        radioButton.setTextColor(getResources().getColor(R.color.black_dark));
        radioButton2.setBackground(null);
        radioButton2.setTextColor(getResources().getColor(R.color.colorWhite));
        radioButton3.setBackground(null);
        radioButton3.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    private void showCount(CheckFraudCountBean checkFraudCountBean) {
        int usableToWeekCount;
        int usableToDayCount = 0;
        if (checkFraudCountBean != null) {
            usableToDayCount = checkFraudCountBean.getUsableToDayCount();
            usableToWeekCount = checkFraudCountBean.getUsableToWeekCount();
        } else {
            usableToWeekCount = 0;
        }
        String str = "\u4eca\u65e5\u5269\u4f59\u53ef\u67e5\u8be2\u6b21\u6570" + getColorStr(usableToDayCount) + "\u6b21\uff0c\u672c\u5468\u5269\u4f59\u53ef\u67e5\u8be2\u6b21\u6570" + getColorStr(usableToWeekCount) + "\u6b21";
        util.s1.a("fromHtml-->>" + str);
        this.mTvCount_tip.setText(Html.fromHtml(str));
    }

    private void showDialog(String str) {
        util.f1.b(this.mActivity, str, "\u786e\u5b9a", null);
    }

    private void startResultPage(CheckFraudBean checkFraudBean) {
        hideProgressDialog();
        checkFraudBean.setContent(this.mEtContent.getText().toString());
        checkFraudBean.setSource(this.source);
        Intent intent = new Intent(this, (Class<?>) CheckFraudResultActivity.class);
        intent.putExtra(util.p1.m0, checkFraudBean);
        intent.putExtra(util.p1.n0, this.shareBean);
        intent.putExtra(util.p1.o0, this.model);
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public void changePath(List<LocalMedia> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(f.d.q);
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, false);
        this.mTvTitle.setText("\u98ce\u9669\u67e5\u8be2");
        this.mIvRight.setImageResource(R.drawable.iv_share_white);
        initView();
        changeState(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        List<LocalMedia> listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (intent == null || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(listObtainMultipleResult);
        }
        String path = listObtainMultipleResult.get(0).getPath();
        util.s1.a("\u626b\u63cf\u4e8c\u7ef4\u7801--\u6587\u4ef6\u8def\u5f84-->>" + path);
        d.b.c.r rVarA = g2.a(util.c1.a(path));
        if (rVarA == null) {
            util.f1.b(this.mActivity, "\u672a\u8bc6\u522b\u51fa\u4e8c\u7ef4\u7801\u4e2d\u7684\u5185\u5bb9", "\u786e\u5b9a", null);
            return;
        }
        util.s1.a("\u626b\u63cf\u4e8c\u7ef4\u7801-->>" + rVarA.e());
        this.mEtContent.setText(rVarA.e());
        this.mPresenter.checkFraudIpUrl(this.mEtContent.getText().toString());
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.checkFraudCount(this.model);
    }

    @Override // ui.callview.CheckFraudCallView
    public void onSuccessRequest(APIresult<CheckFraudBean> aPIresult) {
        hideProgressDialog();
        String msg = aPIresult.getMsg();
        if (aPIresult.getCode() != 0) {
            e2.a(msg);
        } else {
            if (aPIresult.getData() == null) {
                showDialog(aPIresult.getMsg());
                return;
            }
            CheckFraudBean data = aPIresult.getData();
            this.mEtContent.getText().toString();
            startResultPage(data);
        }
    }

    @Override // ui.callview.CheckFraudCallView
    public void onSuccessRequestCount(CheckFraudCountBean checkFraudCountBean) {
        showCount(checkFraudCountBean);
    }

    @Override // ui.callview.CheckFraudCallView
    public void onSuccessShareConfig(APIH5Bean aPIH5Bean) {
        if (aPIH5Bean != null) {
            try {
                if (TextUtils.isEmpty(aPIH5Bean.getValue())) {
                    return;
                }
                this.shareBean = (ShareConfigBean) new com.google.gson.e().a(aPIH5Bean.getValue(), ShareConfigBean.class);
            } catch (Exception unused) {
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.rb_pay, R.id.rb_url, R.id.rb_chat, R.id.iv_clear, R.id.ll_scan, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296501 */:
                String string = this.mEtContent.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    showProgressDialog("\u67e5\u8be2\u4e2d...");
                    int i2 = this.model;
                    if (i2 == 1) {
                        this.mPresenter.checkFraudIpUrl(string);
                    } else if (i2 != 2) {
                        this.mPresenter.checkFraud(string);
                    } else {
                        this.mPresenter.checkFraudChat(string);
                    }
                } else {
                    e2.a("\u67e5\u8be2\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.iv_clear /* 2131296818 */:
                this.mEtContent.setText("");
                break;
            case R.id.iv_right /* 2131296874 */:
                ShareConfigBean shareConfigBean = this.shareBean;
                if (shareConfigBean != null && !TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                    ShareConfigBean shareConfigBean2 = this.shareBean;
                    shareConfigBean2.downloadUrl = shareConfigBean2.downloadUrl.replace("{0}", e.a.m() + "");
                }
                this.mShareDialog = new ui.f.c(this.mActivity, this.shareBean, 2, new c.b() { // from class: ui.activity.o
                    @Override // ui.f.c.b
                    public final void a() {
                        StatisticsShareHttp.getInstance().shareOtherHttp("3");
                    }
                });
                this.mShareDialog.show();
                break;
            case R.id.ll_scan /* 2131297033 */:
                this.model = 1;
                this.mEtContent.setText("");
                checkPermission();
                break;
            case R.id.rb_chat /* 2131297270 */:
                if (this.model != 2) {
                    this.model = 2;
                    changeState(false);
                    break;
                }
                break;
            case R.id.rb_pay /* 2131297274 */:
                if (this.model != 0) {
                    this.model = 0;
                    changeState(false);
                    break;
                }
                break;
            case R.id.rb_url /* 2131297280 */:
                if (this.model != 1) {
                    this.model = 1;
                    changeState(false);
                    break;
                }
                break;
        }
    }

    @Override // ui.callview.CheckFraudCallView
    public void onfailRequest() {
        hideProgressDialog();
        e2.a(Hicore.getApp().getResources().getString(R.string.err_system));
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_check_fraud;
    }
}
