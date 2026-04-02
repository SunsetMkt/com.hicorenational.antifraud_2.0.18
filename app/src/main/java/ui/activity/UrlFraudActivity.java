package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import org.greenrobot.eventbus.ThreadMode;
import ui.presenter.UrlFraudPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class UrlFraudActivity extends BaseActivity {
    private UrlFraudPresenter a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ReportZPEleBean f13936c;

    @BindView(R.id.et_case_describe)
    EditText mEtCaseDescribe;

    @BindView(R.id.fraud_num)
    TextView mFraudNum;

    @BindView(R.id.region)
    TextView mRegion;

    @BindView(R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CheckFraudBean f13935b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13937d = -1;

    private void getIntentData() {
        this.f13935b = (CheckFraudBean) getIntent().getSerializableExtra(util.p1.m0);
        CheckFraudBean checkFraudBean = this.f13935b;
        if (checkFraudBean != null) {
            this.mFraudNum.setText(checkFraudBean.getContent());
        }
    }

    private void submitReport() {
        String str = getmRegionId();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String string = this.mRegion.getText().toString();
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        String string2 = this.mTvDuperyType.getText().toString();
        if (TextUtils.isEmpty(string2)) {
            string2 = "";
        }
        String string3 = this.mEtCaseDescribe.getText().toString();
        String str2 = TextUtils.isEmpty(string3) ? "" : string3;
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic(str);
        reportPersonBean.setReportAdd(string);
        reportPersonBean.setDupery(string2);
        reportPersonBean.setDefraudType(this.f13937d);
        reportPersonBean.setCaseDis(str2);
        this.a.oneKeyReportUrl(this.mFraudNum.getText().toString(), reportPersonBean);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("\u4e00\u952e\u4e3e\u62a5IP/\u7f51\u5740");
        SwipBackLayout.a(this.mActivity).a();
        this.a = new UrlFraudPresenter(this.mActivity);
        getIntentData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 3) {
            return;
        }
        this.f13936c = (ReportZPEleBean) aVar.b();
        ReportZPEleBean reportZPEleBean = this.f13936c;
        if (reportZPEleBean != null) {
            this.mTvDuperyType.setText(reportZPEleBean.getName());
            this.f13937d = this.f13936c.getCode();
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_dupery_type, R.id.region, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                if (!TextUtils.isEmpty(this.mTvDuperyType.getText().toString())) {
                    submitReport();
                } else {
                    e2.a("\u8bf7\u9009\u62e9\u8bc8\u9a97\u7c7b\u578b");
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.region /* 2131297299 */:
                regionShow(this.mRegion, this.mActivity);
                break;
            case R.id.tv_dupery_type /* 2131297701 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                ReportZPEleBean reportZPEleBean = this.f13936c;
                if (reportZPEleBean != null) {
                    intent.putExtra(util.p1.O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_url_fraud;
    }
}
