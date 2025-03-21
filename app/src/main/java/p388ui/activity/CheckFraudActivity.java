package p388ui.activity;

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
import com.google.gson.C2051e;
import com.hicorenational.antifraud.C2113R;
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
import p031c.p035b.p043c.C1107r;
import p245d.C4440a;
import p247e.C4447d;
import p357j.C5846e;
import p388ui.Hicore;
import p388ui.callview.CheckFraudCallView;
import p388ui.p391f.DialogC6827c;
import p388ui.presenter.CheckFraudPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7268d1;
import util.C7292k1;
import util.C7301n1;
import util.C7331w1;
import util.C7336y0;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class CheckFraudActivity extends BaseActivity implements CheckFraudCallView {

    @BindView(C2113R.id.et_content)
    EditText mEtContent;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvClear;

    @BindView(C2113R.id.iv_right)
    ImageView mIvRight;
    private CheckFraudPresenter mPresenter;

    @BindView(C2113R.id.rb_chat)
    RadioButton mRbChat;

    @BindView(C2113R.id.rb_pay)
    RadioButton mRbPay;

    @BindView(C2113R.id.rb_url)
    RadioButton mRbUrl;
    private DialogC6827c mShareDialog;

    @BindView(C2113R.id.tv_count_tip)
    TextView mTvCount_tip;

    @BindView(C2113R.id.ll_scan)
    LinearLayout mTvScan;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private ArrayList<Integer> source;
    private ShareConfigBean shareBean = new ShareConfigBean();
    private int model = 0;

    /* renamed from: ui.activity.CheckFraudActivity$a */
    class C6219a implements IEditAfterListener {
        C6219a() {
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

    /* renamed from: ui.activity.CheckFraudActivity$b */
    class C6220b implements PermissionsListener {
        C6220b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(CheckFraudActivity.this.mActivity, list, z, true, this);
            if (z) {
                CheckFraudActivity.this.resetPerssionChecking();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(CheckFraudActivity.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(1);
        }
    }

    private void changeState(boolean z) {
        this.mEtContent.setText("");
        int i2 = this.model;
        if (i2 == 1) {
            radioState(this.mRbUrl, this.mRbPay, this.mRbChat, C2113R.mipmap.ic_fraud_radio_center);
            this.mEtContent.setHint("请输入或粘贴要查询的IP或URL网址");
            this.mTvScan.setVisibility(0);
        } else if (i2 == 2) {
            radioState(this.mRbChat, this.mRbPay, this.mRbUrl, C2113R.mipmap.ic_fraud_radio_right);
            this.mEtContent.setHint("请输入或粘贴要查询的QQ或微信账号");
            this.mTvScan.setVisibility(8);
        } else {
            radioState(this.mRbPay, this.mRbUrl, this.mRbChat, C2113R.mipmap.ic_fraud_radio_left);
            this.mEtContent.setHint("请输入或粘贴要查询的银行卡号或支付账户");
            this.mTvScan.setVisibility(8);
        }
        if (z) {
            return;
        }
        this.mPresenter.checkFraudCount(this.model);
    }

    private void checkPermission() {
        this.isPerssionChecking = true;
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z, C7308a.f25524c}, new C6220b());
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
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getAuthority())) {
            return parse.getPath();
        }
        Cursor query = getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            if (query.moveToFirst()) {
                String string = query.getString(columnIndexOrThrow);
                query.close();
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
        C7268d1.m26310a(this.mEtContent, new C6219a());
        this.mPresenter = new CheckFraudPresenter(this.mActivity, this);
        this.mPresenter.requestShareConfig();
    }

    private void radioState(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, int i2) {
        radioButton.setBackground(getResources().getDrawable(i2));
        radioButton.setTextColor(getResources().getColor(C2113R.color.black_dark));
        radioButton2.setBackground(null);
        radioButton2.setTextColor(getResources().getColor(C2113R.color.colorWhite));
        radioButton3.setBackground(null);
        radioButton3.setTextColor(getResources().getColor(C2113R.color.colorWhite));
    }

    private void showCount(CheckFraudCountBean checkFraudCountBean) {
        int i2;
        int i3 = 0;
        if (checkFraudCountBean != null) {
            i3 = checkFraudCountBean.getUsableToDayCount();
            i2 = checkFraudCountBean.getUsableToWeekCount();
        } else {
            i2 = 0;
        }
        String str = "今日剩余可查询次数" + getColorStr(i3) + "次，本周剩余可查询次数" + getColorStr(i2) + "次";
        C7301n1.m26453a("fromHtml-->>" + str);
        this.mTvCount_tip.setText(Html.fromHtml(str));
    }

    private void showDialog(String str) {
        C7257b1.m26210b(this.mActivity, str, "确定", null);
    }

    private void startResultPage(CheckFraudBean checkFraudBean) {
        hideProgressDialog();
        checkFraudBean.setContent(this.mEtContent.getText().toString());
        checkFraudBean.setSource(this.source);
        Intent intent = new Intent(this, (Class<?>) CheckFraudResultActivity.class);
        intent.putExtra(C7292k1.f25421m0, checkFraudBean);
        intent.putExtra(C7292k1.f25423n0, this.shareBean);
        intent.putExtra(C7292k1.f25425o0, this.model);
        startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity
    public void changePath(List<LocalMedia> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17170q);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, false);
        this.mTvTitle.setText("风险查询");
        this.mIvRight.setImageResource(C2113R.drawable.iv_share_white);
        initView();
        changeState(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        List<LocalMedia> obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (intent == null || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(obtainMultipleResult);
        }
        String path = obtainMultipleResult.get(0).getPath();
        C7301n1.m26453a("扫描二维码--文件路径-->>" + path);
        C1107r m26727a = C7337y1.m26727a(C7336y0.m26712a(path));
        if (m26727a == null) {
            C7257b1.m26210b(this.mActivity, "未识别出二维码中的内容", "确定", null);
            return;
        }
        C7301n1.m26453a("扫描二维码-->>" + m26727a.m1917e());
        this.mEtContent.setText(m26727a.m1917e());
        this.mPresenter.checkFraudIpUrl(this.mEtContent.getText().toString());
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.checkFraudCount(this.model);
    }

    @Override // p388ui.callview.CheckFraudCallView
    public void onSuccessRequest(APIresult<CheckFraudBean> aPIresult) {
        hideProgressDialog();
        String msg = aPIresult.getMsg();
        if (aPIresult.getCode() != 0) {
            C7331w1.m26688a(msg);
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

    @Override // p388ui.callview.CheckFraudCallView
    public void onSuccessRequestCount(CheckFraudCountBean checkFraudCountBean) {
        showCount(checkFraudCountBean);
    }

    @Override // p388ui.callview.CheckFraudCallView
    public void onSuccessShareConfig(APIH5Bean aPIH5Bean) {
        if (aPIH5Bean != null) {
            try {
                if (TextUtils.isEmpty(aPIH5Bean.getValue())) {
                    return;
                }
                this.shareBean = (ShareConfigBean) new C2051e().m5569a(aPIH5Bean.getValue(), ShareConfigBean.class);
            } catch (Exception unused) {
            }
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_right, C2113R.id.rb_pay, C2113R.id.rb_url, C2113R.id.rb_chat, C2113R.id.iv_clear, C2113R.id.ll_scan, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                String obj = this.mEtContent.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    showProgressDialog("查询中...");
                    int i2 = this.model;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            this.mPresenter.checkFraud(obj);
                            break;
                        } else {
                            this.mPresenter.checkFraudChat(obj);
                            break;
                        }
                    } else {
                        this.mPresenter.checkFraudIpUrl(obj);
                        break;
                    }
                } else {
                    C7331w1.m26688a("查询内容不能为空");
                    break;
                }
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.iv_clear /* 2131296772 */:
                this.mEtContent.setText("");
                break;
            case C2113R.id.iv_right /* 2131296826 */:
                ShareConfigBean shareConfigBean = this.shareBean;
                if (shareConfigBean != null && !TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                    ShareConfigBean shareConfigBean2 = this.shareBean;
                    shareConfigBean2.downloadUrl = shareConfigBean2.downloadUrl.replace("{0}", C4440a.m16411m() + "");
                }
                this.mShareDialog = new DialogC6827c(this.mActivity, this.shareBean, 2, new DialogC6827c.b() { // from class: ui.activity.m
                    @Override // p388ui.p391f.DialogC6827c.b
                    /* renamed from: a */
                    public final void mo25436a() {
                        StatisticsShareHttp.getInstance().shareOtherHttp("3");
                    }
                });
                this.mShareDialog.show();
                break;
            case C2113R.id.ll_scan /* 2131296983 */:
                this.model = 1;
                this.mEtContent.setText("");
                checkPermission();
                break;
            case C2113R.id.rb_chat /* 2131297130 */:
                if (this.model != 2) {
                    this.model = 2;
                    changeState(false);
                    break;
                }
                break;
            case C2113R.id.rb_pay /* 2131297134 */:
                if (this.model != 0) {
                    this.model = 0;
                    changeState(false);
                    break;
                }
                break;
            case C2113R.id.rb_url /* 2131297140 */:
                if (this.model != 1) {
                    this.model = 1;
                    changeState(false);
                    break;
                }
                break;
        }
    }

    @Override // p388ui.callview.CheckFraudCallView
    public void onfailRequest() {
        hideProgressDialog();
        C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_system));
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_check_fraud;
    }
}
