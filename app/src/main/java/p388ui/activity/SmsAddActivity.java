package p388ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import p023b.p024a.p025a.p027e.C0918d;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p388ui.view.MyEdittext;
import util.C7292k1;
import util.C7328v1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class SmsAddActivity extends BaseActivity {

    /* renamed from: d */
    public static final String f23186d = "extra_sms_add";

    /* renamed from: a */
    private SmsBean f23187a = null;

    /* renamed from: b */
    private List<SmsBean> f23188b = new ArrayList();

    /* renamed from: c */
    private int f23189c = -1;

    @BindView(C2113R.id.confirm)
    TextView mBtnCommit;

    @BindView(C2113R.id.et_describe)
    MyEdittext mEtDescribe;

    @BindView(C2113R.id.et_phone)
    EditText mEtPhone;

    @BindView(C2113R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(C2113R.id.tv_time)
    TextView mTvTime;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.SmsAddActivity$a */
    class C6601a implements C0918d.m {
        C6601a() {
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public void mo880a(String str, String str2, String str3, String str4, String str5) {
            SmsAddActivity.this.mTvTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + AbstractC1191a.f2568g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
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
        c0918d.setOnDateTimePickListener(new C6601a());
        c0918d.m1045m();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加短信");
        try {
            this.f23188b = (List) getIntent().getSerializableExtra(C7292k1.f25391c);
            this.f23189c = getIntent().getIntExtra(C7292k1.f25397e, -1);
            if (this.f23188b != null && this.f23189c >= 0 && this.f23189c < this.f23188b.size()) {
                this.f23187a = this.f23188b.get(this.f23189c);
                if (this.f23187a != null) {
                    String victimTel = this.f23187a.getVictimTel();
                    String smsNum = this.f23187a.getSmsNum();
                    String stringDate = this.f23187a.getStringDate();
                    String smsContent = this.f23187a.getSmsContent();
                    if (!TextUtils.isEmpty(victimTel)) {
                        this.mEtVictimPhone.setText(victimTel);
                    }
                    if (!TextUtils.isEmpty(smsNum)) {
                        this.mEtPhone.setText(smsNum);
                    }
                    if (!TextUtils.isEmpty(stringDate)) {
                        this.mTvTime.setText(stringDate);
                    }
                    if (!TextUtils.isEmpty(smsContent)) {
                        this.mEtDescribe.setText(smsContent);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (this.f23187a == null) {
            this.f23187a = new SmsBean("", "", "", false);
        }
        if (this.mEtVictimPhone.length() <= 0) {
            String m26670j = C7328v1.m26670j();
            if (TextUtils.isEmpty(m26670j)) {
                return;
            }
            this.mEtVictimPhone.setText(m26670j);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_time, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            sendData();
        } else if (id == C2113R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != C2113R.id.tv_time) {
                return;
            }
            showTimePiker();
        }
    }

    public void sendData() {
        String obj = this.mEtPhone.getText().toString();
        String obj2 = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            C7331w1.m26688a("请输入或粘贴收件人短信号码");
            return;
        }
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请输入或粘贴诈骗短信号码");
            return;
        }
        if (this.mTvTime.length() == 0) {
            C7331w1.m26688a("请选择诈骗短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(obj2)) {
            C7331w1.m26688a("请输入短信内容");
            return;
        }
        if (this.f23187a == null) {
            this.f23187a = new SmsBean("", "", "", false);
        }
        this.f23187a.setVictimTel(this.mEtVictimPhone.getText().toString());
        this.f23187a.setSmsNum(obj);
        this.f23187a.setStringDate(this.mTvTime.getText().toString());
        this.f23187a.setSmsContent(obj2);
        this.f23187a.setVictimTel(this.mEtVictimPhone.getText().toString());
        this.f23187a.setStringDate(this.mTvTime.getText().toString());
        List<SmsBean> list = this.f23188b;
        if (list == null || list.size() <= 0) {
            if (this.f23188b == null) {
                this.f23188b = new ArrayList();
            }
            this.f23188b.add(this.f23187a);
        } else {
            int indexOf = this.f23188b.indexOf(this.f23187a);
            for (int i2 = 0; i2 < this.f23188b.size(); i2++) {
                if (i2 != this.f23189c && i2 != indexOf && TextUtils.equals(this.f23187a.getVictimTel(), this.f23188b.get(i2).getVictimTel()) && TextUtils.equals(this.f23187a.getSmsNum(), this.f23188b.get(i2).getSmsNum()) && TextUtils.equals(this.f23187a.getStringDate(), this.f23188b.get(i2).getStringDate()) && TextUtils.equals(this.f23187a.getSmsContent(), this.f23188b.get(i2).getSmsContent())) {
                    C7331w1.m26688a("输入信息重复，请重新输入");
                    return;
                }
            }
            if (indexOf == -1 && this.f23189c == -1) {
                this.f23188b.add(this.f23187a);
            }
        }
        if (this.f23188b.size() == 0) {
            C7331w1.m26688a("还没有填写信息");
        } else {
            C6049c.m24987f().m25000d(new C7265a(303, this.f23188b));
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_sms_add;
    }
}
