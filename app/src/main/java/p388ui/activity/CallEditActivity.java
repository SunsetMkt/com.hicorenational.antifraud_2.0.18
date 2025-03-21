package p388ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bean.CallBean;
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
import p388ui.Hicore;
import p388ui.view.C7247w;
import util.C7292k1;
import util.C7328v1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class CallEditActivity extends BaseActivity {

    /* renamed from: a */
    private CallBean f21912a = null;

    /* renamed from: b */
    private List<CallBean> f21913b = new ArrayList();

    /* renamed from: c */
    private int f21914c = -1;

    @BindView(C2113R.id.btn_confirm)
    Button mBtnConfirm;

    @BindView(C2113R.id.et_phone)
    EditText mEtPhone;

    @BindView(C2113R.id.et_victim_phone)
    EditText mEtVictimPhone;

    @BindView(C2113R.id.tv_duration)
    TextView mTvDuration;

    @BindView(C2113R.id.tv_occur_time)
    TextView mTvOccurTime;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.CallEditActivity$a */
    class C6161a implements C0918d.m {
        C6161a() {
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public void mo880a(String str, String str2, String str3, String str4, String str5) {
            CallEditActivity.this.mTvOccurTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + AbstractC1191a.f2568g + str4 + Constants.COLON_SEPARATOR + str5 + ":00");
        }
    }

    /* renamed from: ui.activity.CallEditActivity$b */
    class C6162b implements C7247w.l {
        C6162b() {
        }

        @Override // p388ui.view.C7247w.l
        /* renamed from: a */
        public void mo25212a(String str, String str2, String str3) {
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
                str4 = i2 + "小时" + i3 + "分钟" + i4 + "秒";
            } else if (i3 > 0) {
                str4 = i3 + "分钟" + i4 + "秒";
            } else {
                str4 = i4 + "秒";
            }
            CallEditActivity.this.mTvDuration.setText(str4);
        }
    }

    private void initData() {
        try {
            this.f21913b = (List) getIntent().getSerializableExtra(C7292k1.f25391c);
            this.f21914c = getIntent().getIntExtra(C7292k1.f25397e, -1);
            if (this.f21913b != null && this.f21914c >= 0 && this.f21914c < this.f21913b.size()) {
                this.f21912a = this.f21913b.get(this.f21914c);
                if (this.f21912a != null) {
                    this.mEtVictimPhone.setText(this.f21912a.getVictimTel());
                    this.mEtPhone.setText(this.f21912a.getNumber());
                    this.mTvOccurTime.setText(this.f21912a.getCrime_time());
                    this.mTvDuration.setText(this.f21912a.getTalkTime());
                }
            }
        } catch (Exception unused) {
            this.f21912a = null;
        }
        if (this.mEtVictimPhone.length() <= 0) {
            String m26670j = C7328v1.m26670j();
            if (TextUtils.isEmpty(m26670j)) {
                return;
            }
            this.mEtVictimPhone.setText(m26670j);
        }
    }

    private void initView() {
        this.mTvTitle.setText("添加电话");
    }

    private void showDurationPiker() {
        C7247w c7247w = new C7247w(this, -1, 3);
        c7247w.m26112c(23, 59, 59);
        c7247w.m26108a(0, 0, 0, 0, 0);
        c7247w.setOnDateTimePickListener(new C6162b());
        c7247w.m1045m();
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
        c0918d.setOnDateTimePickListener(new C6161a());
        c0918d.m1045m();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        initView();
        initData();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_occur_time, C2113R.id.tv_duration, C2113R.id.btn_confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_confirm /* 2131296396 */:
                if (this.mEtVictimPhone.length() == 0) {
                    C7331w1.m26688a("请输入受害人电话");
                    break;
                } else if (this.mEtPhone.length() == 0) {
                    C7331w1.m26688a("请填写诈骗电话");
                    break;
                } else if (this.mTvOccurTime.length() == 0) {
                    C7331w1.m26688a("请选择通话开始时间");
                    break;
                } else if (this.mTvDuration.length() == 0) {
                    C7331w1.m26688a("请选择通话时长");
                    break;
                } else {
                    if (this.f21912a == null) {
                        this.f21912a = new CallBean();
                    }
                    this.f21912a.setVictimTel(this.mEtVictimPhone.getText().toString());
                    this.f21912a.setNumber(this.mEtPhone.getText().toString());
                    this.f21912a.setCrime_time(this.mTvOccurTime.getText().toString());
                    this.f21912a.setTalkTime(this.mTvDuration.getText().toString());
                    List<CallBean> list = this.f21913b;
                    if (list == null || list.size() <= 0) {
                        if (this.f21913b == null) {
                            this.f21913b = new ArrayList();
                        }
                        this.f21913b.add(this.f21912a);
                    } else {
                        int indexOf = this.f21913b.indexOf(this.f21912a);
                        for (int i2 = 0; i2 < this.f21913b.size(); i2++) {
                            if (i2 != this.f21914c && i2 != indexOf && TextUtils.equals(this.f21912a.getNumber(), this.f21913b.get(i2).getNumber()) && TextUtils.equals(this.f21912a.getCrime_time(), this.f21913b.get(i2).getCrime_time())) {
                                C7331w1.m26688a("输入信息重复，请重新输入");
                                break;
                            }
                        }
                        if (indexOf == -1 && this.f21914c == -1) {
                            this.f21913b.add(this.f21912a);
                        }
                    }
                    if (this.f21913b.size() != 0) {
                        C6049c.m24987f().m25000d(new C7265a(301, this.f21913b));
                        finish();
                        break;
                    } else {
                        C7331w1.m26688a("还没有填写信息");
                        break;
                    }
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.tv_duration /* 2131297543 */:
                showDurationPiker();
                break;
            case C2113R.id.tv_occur_time /* 2131297619 */:
                showTimePiker();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_edit;
    }
}
