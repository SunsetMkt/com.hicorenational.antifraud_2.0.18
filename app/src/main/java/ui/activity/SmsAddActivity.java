package ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import c.a.a.e.d;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ui.view.MyEdittext;
import util.d2;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class SmsAddActivity extends BaseActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13850d = "extra_sms_add";
    private SmsBean a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<SmsBean> f13851b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13852c = -1;

    @BindView(R.id.confirm)
    TextView mBtnCommit;

    @BindView(R.id.et_describe)
    MyEdittext mEtDescribe;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements d.m {
        a() {
        }

        @Override // c.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            SmsAddActivity.this.mTvTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + d.c.a.b.a.a.f10074g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
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
        dVar.setOnDateTimePickListener(new a());
        dVar.m();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u6dfb\u52a0\u77ed\u4fe1");
        try {
            this.f13851b = (List) getIntent().getSerializableExtra(util.p1.f15011c);
            this.f13852c = getIntent().getIntExtra(util.p1.f15013e, -1);
            if (this.f13851b != null && this.f13852c >= 0 && this.f13852c < this.f13851b.size()) {
                this.a = this.f13851b.get(this.f13852c);
                if (this.a != null) {
                    String victimTel = this.a.getVictimTel();
                    String smsNum = this.a.getSmsNum();
                    String stringDate = this.a.getStringDate();
                    String smsContent = this.a.getSmsContent();
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
        if (this.a == null) {
            this.a = new SmsBean("", "", "", false);
        }
        if (this.mEtVictimPhone.length() <= 0) {
            String strJ = d2.j();
            if (TextUtils.isEmpty(strJ)) {
                return;
            }
            this.mEtVictimPhone.setText(strJ);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_time, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            sendData();
        } else if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.tv_time) {
                return;
            }
            showTimePiker();
        }
    }

    public void sendData() {
        String string = this.mEtPhone.getText().toString();
        String string2 = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            e2.a("\u8bf7\u8f93\u5165\u6216\u7c98\u8d34\u6536\u4ef6\u4eba\u77ed\u4fe1\u53f7\u7801");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            e2.a("\u8bf7\u8f93\u5165\u6216\u7c98\u8d34\u8bc8\u9a97\u77ed\u4fe1\u53f7\u7801");
            return;
        }
        if (this.mTvTime.length() == 0) {
            e2.a("\u8bf7\u9009\u62e9\u8bc8\u9a97\u77ed\u4fe1\u63a5\u6536\u65f6\u95f4");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            e2.a("\u8bf7\u8f93\u5165\u77ed\u4fe1\u5185\u5bb9");
            return;
        }
        if (this.a == null) {
            this.a = new SmsBean("", "", "", false);
        }
        this.a.setVictimTel(this.mEtVictimPhone.getText().toString());
        this.a.setSmsNum(string);
        this.a.setStringDate(this.mTvTime.getText().toString());
        this.a.setSmsContent(string2);
        this.a.setVictimTel(this.mEtVictimPhone.getText().toString());
        this.a.setStringDate(this.mTvTime.getText().toString());
        List<SmsBean> list = this.f13851b;
        if (list == null || list.size() <= 0) {
            if (this.f13851b == null) {
                this.f13851b = new ArrayList();
            }
            this.f13851b.add(this.a);
        } else {
            int iIndexOf = this.f13851b.indexOf(this.a);
            for (int i2 = 0; i2 < this.f13851b.size(); i2++) {
                if (i2 != this.f13852c && i2 != iIndexOf && TextUtils.equals(this.a.getVictimTel(), this.f13851b.get(i2).getVictimTel()) && TextUtils.equals(this.a.getSmsNum(), this.f13851b.get(i2).getSmsNum()) && TextUtils.equals(this.a.getStringDate(), this.f13851b.get(i2).getStringDate()) && TextUtils.equals(this.a.getSmsContent(), this.f13851b.get(i2).getSmsContent())) {
                    e2.a("\u8f93\u5165\u4fe1\u606f\u91cd\u590d\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
                    return;
                }
            }
            if (iIndexOf == -1 && this.f13852c == -1) {
                this.f13851b.add(this.a);
            }
        }
        if (this.f13851b.size() == 0) {
            e2.a("\u8fd8\u6ca1\u6709\u586b\u5199\u4fe1\u606f");
        } else {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(303, this.f13851b));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sms_add;
    }
}
