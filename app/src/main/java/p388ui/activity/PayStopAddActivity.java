package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bean.AccountListBean;
import bean.CaseDivisonBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import java.util.Calendar;
import org.greenrobot.eventbus.C6049c;
import p023b.p024a.p025a.p027e.C0918d;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p388ui.Hicore;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class PayStopAddActivity extends BaseActivity {

    /* renamed from: a */
    private String f22610a;

    /* renamed from: b */
    private AccountListBean f22611b;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.et_suspect_account)
    EditText mEtSuspectAccount;

    @BindView(C2113R.id.et_suspect_account_name)
    EditText mEtSuspectAccountName;

    @BindView(C2113R.id.et_transfer_money)
    EditText mEtTransMoy;

    @BindView(C2113R.id.tv_suspect_type)
    TextView mTvSuspectType;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.tv_time)
    TextView mTvTransTime;

    /* renamed from: ui.activity.PayStopAddActivity$a */
    class C6405a implements IClickListener {
        C6405a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            PayStopAddActivity.this.finish();
        }
    }

    /* renamed from: ui.activity.PayStopAddActivity$b */
    class C6406b implements C0918d.m {
        C6406b() {
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public void mo880a(String str, String str2, String str3, String str4, String str5) {
            PayStopAddActivity.this.mTvTransTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + AbstractC1191a.f2568g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
    }

    /* renamed from: a */
    private String m25299a(String str) {
        if (!str.contains(".")) {
            return str + ".00";
        }
        int length = str.length() - str.lastIndexOf(".");
        if (length >= 3) {
            return str;
        }
        if (length >= 2) {
            return str + "0";
        }
        return str + "00";
    }

    private void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        C0918d c0918d = new C0918d(this, 0, 3);
        c0918d.mo869g(2018, 2055);
        c0918d.mo860a(i2, i3, i4, i5, i6);
        c0918d.setOnDateTimePickListener(new C6406b());
        c0918d.m1045m();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加止付账户");
        this.f22611b = (AccountListBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        C7337y1.m26752a(this.mEtTransMoy);
        AccountListBean accountListBean = this.f22611b;
        if (accountListBean != null) {
            this.f22610a = accountListBean.getSuspectAccountType();
            this.mTvSuspectType.setText(this.f22611b.getSuspectAccountTypeText());
            this.mEtSuspectAccountName.setText(this.f22611b.getSuspectName());
            this.mEtSuspectAccount.setText(this.f22611b.getSuspectAccount());
            this.mTvTransTime.setText(this.f22611b.getPaymentTime());
            this.mEtTransMoy.setText(this.f22611b.getTransferAmount());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        CaseDivisonBean caseDivisonBean;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 1001 || intent == null || (caseDivisonBean = (CaseDivisonBean) intent.getSerializableExtra(C7292k1.f25414j1)) == null) {
            return;
        }
        this.mTvSuspectType.setText(caseDivisonBean.getName());
        this.f22610a = caseDivisonBean.getId();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        m25300a();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_suspect_type, C2113R.id.tv_time, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                String trim = this.mTvSuspectType.getText().toString().trim();
                String trim2 = this.mEtSuspectAccountName.getText().toString().trim();
                String trim3 = this.mEtSuspectAccount.getText().toString().trim();
                String trim4 = this.mTvTransTime.getText().toString().trim();
                String trim5 = this.mEtTransMoy.getText().toString().trim();
                if (!TextUtils.isEmpty(this.f22610a) && !TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2) && !TextUtils.isEmpty(trim3) && !TextUtils.isEmpty(trim4) && !TextUtils.isEmpty(trim5)) {
                    if (this.f22611b == null) {
                        this.f22611b = new AccountListBean();
                        this.f22611b.setPosition(-1);
                    }
                    this.f22611b.setEdit(true);
                    this.f22611b.setSuspectAccountType(this.f22610a);
                    this.f22611b.setSuspectAccountTypeText(trim);
                    this.f22611b.setSuspectName(trim2);
                    this.f22611b.setSuspectAccount(trim3);
                    this.f22611b.setPaymentTime(trim4);
                    this.f22611b.setTransferAmount(m25299a(trim5));
                    C6049c.m24987f().m25000d(new C7265a(300, this.f22611b));
                    finish();
                    break;
                } else {
                    C7331w1.m26688a("请填写嫌疑人账户信息");
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.tv_suspect_type /* 2131297741 */:
                startActivityForResult(new Intent(this, (Class<?>) PaymentTypeActivity.class), 1001);
                break;
            case C2113R.id.tv_time /* 2131297752 */:
                showTimePiker();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_paystop_add;
    }

    /* renamed from: a */
    private void m25300a() {
        C7257b1.m26184a((Activity) this, "放弃本次编辑?", "", "取消", "确定", C2113R.color._2D4AEB, -1, true, (IClickListener) new C6405a());
    }
}
