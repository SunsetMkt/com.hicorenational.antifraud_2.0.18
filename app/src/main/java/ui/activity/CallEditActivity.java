package ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bean.CallBean;
import butterknife.BindView;
import butterknife.OnClick;
import c.a.a.e.d;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ui.Hicore;
import ui.view.y;
import util.d2;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CallEditActivity extends BaseActivity {
    private CallBean a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<CallBean> f13139b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13140c = -1;

    @BindView(R.id.btn_confirm)
    Button mBtnConfirm;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.et_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.tv_duration)
    TextView mTvDuration;

    @BindView(R.id.tv_occur_time)
    TextView mTvOccurTime;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements d.m {
        a() {
        }

        @Override // c.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            CallEditActivity.this.mTvOccurTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + d.c.a.b.a.a.f10074g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
    }

    class b implements y.l {
        b() {
        }

        @Override // ui.view.y.l
        public void a(String str, String str2, String str3) {
            int i2;
            int i3;
            String str4;
            int i4 = 0;
            try {
                i2 = Integer.parseInt(str);
                i3 = Integer.parseInt(str2);
                i4 = Integer.parseInt(str3);
            } catch (Exception unused) {
                i2 = 0;
                i3 = 0;
            }
            if (i2 > 0) {
                str4 = i2 + "\u5c0f\u65f6" + i3 + "\u5206\u949f" + i4 + "\u79d2";
            } else if (i3 > 0) {
                str4 = i3 + "\u5206\u949f" + i4 + "\u79d2";
            } else {
                str4 = i4 + "\u79d2";
            }
            CallEditActivity.this.mTvDuration.setText(str4);
        }
    }

    private void initData() {
        try {
            this.f13139b = (List) getIntent().getSerializableExtra(util.p1.f15011c);
            this.f13140c = getIntent().getIntExtra(util.p1.f15013e, -1);
            if (this.f13139b != null && this.f13140c >= 0 && this.f13140c < this.f13139b.size()) {
                this.a = this.f13139b.get(this.f13140c);
                if (this.a != null) {
                    this.mEtVictimPhone.setText(this.a.getVictimTel());
                    this.mEtPhone.setText(this.a.getNumber());
                    this.mTvOccurTime.setText(this.a.getCrime_time());
                    this.mTvDuration.setText(this.a.getTalkTime());
                }
            }
        } catch (Exception unused) {
            this.a = null;
        }
        if (this.mEtVictimPhone.length() <= 0) {
            String strJ = d2.j();
            if (TextUtils.isEmpty(strJ)) {
                return;
            }
            this.mEtVictimPhone.setText(strJ);
        }
    }

    private void initView() {
        this.mTvTitle.setText("\u6dfb\u52a0\u7535\u8bdd");
    }

    private void showDurationPiker() {
        ui.view.y yVar = new ui.view.y(this, -1, 3);
        yVar.c(23, 59, 59);
        yVar.a(0, 0, 0, 0, 0);
        yVar.setOnDateTimePickListener(new b());
        yVar.m();
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
        initView();
        initData();
    }

    @OnClick({R.id.iv_back, R.id.tv_occur_time, R.id.tv_duration, R.id.btn_confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_confirm /* 2131296408 */:
                if (this.mEtVictimPhone.length() == 0) {
                    e2.a("\u8bf7\u8f93\u5165\u53d7\u5bb3\u4eba\u7535\u8bdd");
                } else if (this.mEtPhone.length() == 0) {
                    e2.a("\u8bf7\u586b\u5199\u8bc8\u9a97\u7535\u8bdd");
                } else if (this.mTvOccurTime.length() == 0) {
                    e2.a("\u8bf7\u9009\u62e9\u901a\u8bdd\u5f00\u59cb\u65f6\u95f4");
                } else if (this.mTvDuration.length() == 0) {
                    e2.a("\u8bf7\u9009\u62e9\u901a\u8bdd\u65f6\u957f");
                } else {
                    if (this.a == null) {
                        this.a = new CallBean();
                    }
                    this.a.setVictimTel(this.mEtVictimPhone.getText().toString());
                    this.a.setNumber(this.mEtPhone.getText().toString());
                    this.a.setCrime_time(this.mTvOccurTime.getText().toString());
                    this.a.setTalkTime(this.mTvDuration.getText().toString());
                    List<CallBean> list = this.f13139b;
                    if (list == null || list.size() <= 0) {
                        if (this.f13139b == null) {
                            this.f13139b = new ArrayList();
                        }
                        this.f13139b.add(this.a);
                    } else {
                        int iIndexOf = this.f13139b.indexOf(this.a);
                        for (int i2 = 0; i2 < this.f13139b.size(); i2++) {
                            if (i2 != this.f13140c && i2 != iIndexOf && TextUtils.equals(this.a.getNumber(), this.f13139b.get(i2).getNumber()) && TextUtils.equals(this.a.getCrime_time(), this.f13139b.get(i2).getCrime_time())) {
                                e2.a("\u8f93\u5165\u4fe1\u606f\u91cd\u590d\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
                            }
                            break;
                        }
                        if (iIndexOf == -1 && this.f13140c == -1) {
                            this.f13139b.add(this.a);
                        }
                    }
                    if (this.f13139b.size() != 0) {
                        org.greenrobot.eventbus.c.f().d(new util.n2.a(301, this.f13139b));
                        finish();
                    } else {
                        e2.a("\u8fd8\u6ca1\u6709\u586b\u5199\u4fe1\u606f");
                    }
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.tv_duration /* 2131297702 */:
                showDurationPiker();
                break;
            case R.id.tv_occur_time /* 2131297780 */:
                showTimePiker();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_edit;
    }
}
