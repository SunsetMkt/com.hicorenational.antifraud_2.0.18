package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.presenter.UrlFraudPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class UrlFraudActivity extends BaseActivity {

    /* renamed from: a */
    private UrlFraudPresenter f23318a;

    /* renamed from: c */
    private ReportZPEleBean f23320c;

    @BindView(C2113R.id.et_case_describe)
    EditText mEtCaseDescribe;

    @BindView(C2113R.id.fraud_num)
    TextView mFraudNum;

    @BindView(C2113R.id.region)
    TextView mRegion;

    @BindView(C2113R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: b */
    public CheckFraudBean f23319b = null;

    /* renamed from: d */
    private int f23321d = -1;

    private void getIntentData() {
        this.f23319b = (CheckFraudBean) getIntent().getSerializableExtra(C7292k1.f25421m0);
        CheckFraudBean checkFraudBean = this.f23319b;
        if (checkFraudBean != null) {
            this.mFraudNum.setText(checkFraudBean.getContent());
        }
    }

    private void submitReport() {
        String str = getmRegionId();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String charSequence = this.mRegion.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        String charSequence2 = this.mTvDuperyType.getText().toString();
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        String obj = this.mEtCaseDescribe.getText().toString();
        String str2 = TextUtils.isEmpty(obj) ? "" : obj;
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic(str);
        reportPersonBean.setReportAdd(charSequence);
        reportPersonBean.setDupery(charSequence2);
        reportPersonBean.setDefraudType(this.f23321d);
        reportPersonBean.setCaseDis(str2);
        this.f23318a.oneKeyReportUrl(this.mFraudNum.getText().toString(), reportPersonBean);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("一键举报IP/网址");
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.f23318a = new UrlFraudPresenter(this.mActivity);
        getIntentData();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 3) {
            return;
        }
        this.f23320c = (ReportZPEleBean) c7265a.m26300b();
        ReportZPEleBean reportZPEleBean = this.f23320c;
        if (reportZPEleBean != null) {
            this.mTvDuperyType.setText(reportZPEleBean.getName());
            this.f23321d = this.f23320c.getCode();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_dupery_type, C2113R.id.region, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                if (!TextUtils.isEmpty(this.mTvDuperyType.getText().toString())) {
                    submitReport();
                    break;
                } else {
                    C7331w1.m26688a("请选择诈骗类型");
                    break;
                }
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.region /* 2131297159 */:
                regionShow(this.mRegion, this.mActivity);
                break;
            case C2113R.id.tv_dupery_type /* 2131297542 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                ReportZPEleBean reportZPEleBean = this.f23320c;
                if (reportZPEleBean != null) {
                    intent.putExtra(C7292k1.f25361O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_url_fraud;
    }
}
