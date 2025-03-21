package p388ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import bean.SocialAccBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.tencent.connect.common.Constants;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.callview.ChatFraudView;
import p388ui.presenter.ChatFraudPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class ChatFraudActivity extends BaseActivity implements ChatFraudView {
    private static final String FINATYPE = "其他类型";
    private ReportZPEleBean info;

    @BindView(C2113R.id.et_case_describe)
    EditText mEtCaseDescribe;
    private ChatFraudPresenter mPresenter;

    @BindView(C2113R.id.rb_qq)
    RadioButton mRbQQ;

    @BindView(C2113R.id.rb_wx)
    RadioButton mRbWx;

    @BindView(C2113R.id.region)
    TextView mRegion;

    @BindView(C2113R.id.rg_chat)
    RadioGroup mRgChat;

    @BindView(C2113R.id.trad_fraud_num)
    TextView mTvAccNum;

    @BindView(C2113R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private String accType = "微信";
    public CheckFraudBean mCheckFraudBean = null;
    private int mDefraudCode = -1;

    /* renamed from: ui.activity.ChatFraudActivity$a */
    class C6214a implements RadioGroup.OnCheckedChangeListener {
        C6214a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == C2113R.id.rb_wx) {
                ChatFraudActivity.this.accType = "微信";
            } else {
                ChatFraudActivity.this.accType = Constants.SOURCE_QQ;
            }
        }
    }

    private void getIntentData() {
        this.mCheckFraudBean = (CheckFraudBean) getIntent().getSerializableExtra(C7292k1.f25421m0);
        CheckFraudBean checkFraudBean = this.mCheckFraudBean;
        if (checkFraudBean != null) {
            this.mTvAccNum.setText(checkFraudBean.getContent());
            int type = this.mCheckFraudBean.getType();
            if (type == 2) {
                this.accType = "微信";
                this.mRbWx.setChecked(true);
            } else if (type == 3) {
                this.accType = Constants.SOURCE_QQ;
                this.mRbQQ.setChecked(true);
            } else if (type == 5) {
                this.accType = "微信";
                this.mRbWx.setChecked(true);
            }
        }
        this.mRgChat.setOnCheckedChangeListener(new C6214a());
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
        reportPersonBean.setDefraudType(this.mDefraudCode);
        reportPersonBean.setCaseDis(str2);
        SocialAccBean socialAccBean = new SocialAccBean();
        socialAccBean.setAccountName(this.accType);
        socialAccBean.setAccountNum(this.mTvAccNum.getText().toString());
        this.mPresenter.oneKeyReportTrad(socialAccBean, reportPersonBean);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("一键举报社交账号");
        this.mPresenter = new ChatFraudPresenter(this.mActivity, this);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
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
        this.info = (ReportZPEleBean) c7265a.m26300b();
        ReportZPEleBean reportZPEleBean = this.info;
        if (reportZPEleBean != null) {
            this.mTvDuperyType.setText(reportZPEleBean.getName());
            this.mDefraudCode = this.info.getCode();
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
                ReportZPEleBean reportZPEleBean = this.info;
                if (reportZPEleBean != null) {
                    intent.putExtra(C7292k1.f25361O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_chat_fraud;
    }
}
