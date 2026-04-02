package ui.activity;

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
import c.a.a.e.d;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import java.util.Calendar;
import ui.Hicore;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class PayStopAddActivity extends BaseActivity {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AccountListBean f13528b;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.et_suspect_account)
    EditText mEtSuspectAccount;

    @BindView(R.id.et_suspect_account_name)
    EditText mEtSuspectAccountName;

    @BindView(R.id.et_transfer_money)
    EditText mEtTransMoy;

    @BindView(R.id.tv_suspect_type)
    TextView mTvSuspectType;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_time)
    TextView mTvTransTime;

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            PayStopAddActivity.this.finish();
        }
    }

    class b implements d.m {
        b() {
        }

        @Override // c.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            PayStopAddActivity.this.mTvTransTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + d.c.a.b.a.a.f10074g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
    }

    private String a(String str) {
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
        c.a.a.e.d dVar = new c.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new b());
        dVar.m();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u6dfb\u52a0\u6b62\u4ed8\u8d26\u6237");
        this.f13528b = (AccountListBean) getIntent().getSerializableExtra(util.p1.f15011c);
        g2.a(this.mEtTransMoy);
        AccountListBean accountListBean = this.f13528b;
        if (accountListBean != null) {
            this.a = accountListBean.getSuspectAccountType();
            this.mTvSuspectType.setText(this.f13528b.getSuspectAccountTypeText());
            this.mEtSuspectAccountName.setText(this.f13528b.getSuspectName());
            this.mEtSuspectAccount.setText(this.f13528b.getSuspectAccount());
            this.mTvTransTime.setText(this.f13528b.getPaymentTime());
            this.mEtTransMoy.setText(this.f13528b.getTransferAmount());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        CaseDivisonBean caseDivisonBean;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 1001 || intent == null || (caseDivisonBean = (CaseDivisonBean) intent.getSerializableExtra(util.p1.j1)) == null) {
            return;
        }
        this.mTvSuspectType.setText(caseDivisonBean.getName());
        this.a = caseDivisonBean.getId();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.tv_suspect_type, R.id.tv_time, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                String strTrim = this.mTvSuspectType.getText().toString().trim();
                String strTrim2 = this.mEtSuspectAccountName.getText().toString().trim();
                String strTrim3 = this.mEtSuspectAccount.getText().toString().trim();
                String strTrim4 = this.mTvTransTime.getText().toString().trim();
                String strTrim5 = this.mEtTransMoy.getText().toString().trim();
                if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2) || TextUtils.isEmpty(strTrim3) || TextUtils.isEmpty(strTrim4) || TextUtils.isEmpty(strTrim5)) {
                    e2.a("\u8bf7\u586b\u5199\u5acc\u7591\u4eba\u8d26\u6237\u4fe1\u606f");
                } else {
                    if (this.f13528b == null) {
                        this.f13528b = new AccountListBean();
                        this.f13528b.setPosition(-1);
                    }
                    this.f13528b.setEdit(true);
                    this.f13528b.setSuspectAccountType(this.a);
                    this.f13528b.setSuspectAccountTypeText(strTrim);
                    this.f13528b.setSuspectName(strTrim2);
                    this.f13528b.setSuspectAccount(strTrim3);
                    this.f13528b.setPaymentTime(strTrim4);
                    this.f13528b.setTransferAmount(a(strTrim5));
                    org.greenrobot.eventbus.c.f().d(new util.n2.a(300, this.f13528b));
                    finish();
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                onBackPressed();
                break;
            case R.id.tv_suspect_type /* 2131297902 */:
                startActivityForResult(new Intent(this, (Class<?>) PaymentTypeActivity.class), 1001);
                break;
            case R.id.tv_time /* 2131297913 */:
                showTimePiker();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_paystop_add;
    }

    private void a() {
        util.f1.a((Activity) this, "\u653e\u5f03\u672c\u6b21\u7f16\u8f91?", "", "\u53d6\u6d88", "\u786e\u5b9a", R.color._2D4AEB, -1, true, (IClickListener) new a());
    }
}
