package p388ui.activity;

import adapter.CallSelectNewAdapter;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CallLog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class CallRecordNewActivity extends BaseActivity implements CallSelectNewAdapter.InterfaceC0057b {

    /* renamed from: k */
    public static final String f21965k = "extra_select_limite";

    /* renamed from: l */
    public static final int f21966l = 1;

    /* renamed from: m */
    public static final String f21967m = "extra_select_can";

    /* renamed from: c */
    private CallSelectNewAdapter f21970c;

    /* renamed from: i */
    private boolean f21976i;

    /* renamed from: j */
    private String f21977j;

    @BindView(C2113R.id.btn_report)
    Button mBtnReport;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(C2113R.id.tv_child_tab_me)
    TextView mTvChildTabMe;

    @BindView(C2113R.id.tv_child_tab_other)
    TextView mTvChildTabOther;

    @BindView(C2113R.id.tv_tip)
    TextView mTvTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.v_me)
    View mVMe;

    @BindView(C2113R.id.v_other)
    View mVOther;

    /* renamed from: a */
    private List<CallBean> f21968a = new ArrayList();

    /* renamed from: b */
    private List<CallBean> f21969b = new ArrayList();

    /* renamed from: d */
    private List<CallBean> f21971d = new ArrayList();

    /* renamed from: e */
    private List<CallBean> f21972e = new ArrayList();

    /* renamed from: f */
    private boolean f21973f = true;

    /* renamed from: g */
    private List<CallBean> f21974g = new ArrayList();

    /* renamed from: h */
    private int f21975h = 100;

    /* renamed from: ui.activity.CallRecordNewActivity$a */
    class RunnableC6176a implements Runnable {

        /* renamed from: ui.activity.CallRecordNewActivity$a$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallRecordNewActivity.this.f21970c.setNewData(CallRecordNewActivity.this.f21969b);
            }
        }

        RunnableC6176a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CallRecordNewActivity.this.m25232a();
            if (CallRecordNewActivity.this.f21973f) {
                if (CallRecordNewActivity.this.f21968a != null) {
                    Collections.reverse(CallRecordNewActivity.this.f21968a);
                }
                if (CallRecordNewActivity.this.f21969b != null) {
                    Collections.reverse(CallRecordNewActivity.this.f21969b);
                }
                CallRecordNewActivity.this.f21973f = false;
            }
            CallRecordNewActivity.this.runOnUiThread(new a());
        }
    }

    private void changeTab(boolean z) {
        if (z) {
            if (this.mVMe.getVisibility() != 0) {
                m25223a(this.mTvChildTabMe, this.mTvChildTabOther);
                this.mVMe.setVisibility(0);
                this.mVOther.setVisibility(4);
                this.f21970c.setNewData(this.f21969b);
                return;
            }
            return;
        }
        if (this.mVOther.getVisibility() != 0) {
            m25223a(this.mTvChildTabOther, this.mTvChildTabMe);
            this.mVMe.setVisibility(4);
            this.mVOther.setVisibility(0);
            this.f21970c.setNewData(this.f21968a);
        }
    }

    private void initData() {
        try {
            this.f21975h = getIntent().getIntExtra("extra_select_can", 20);
            this.f21972e = (List) getIntent().getSerializableExtra(C7292k1.f25391c);
        } catch (Exception unused) {
        }
        new Thread(new RunnableC6176a()).start();
    }

    private void initView() {
        this.mTvTitle.setText("通话记录选择");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f21970c = new CallSelectNewAdapter(C2113R.layout.recyclerview_call_select_new, this.f21968a, this.f21974g);
        this.f21970c.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f21970c);
        this.f21970c.setOnItemClickListener(this);
        changeTab(true);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        initView();
        initData();
        if (getIntent().getIntExtra("extra_select_limite", 0) == 1) {
            this.f21977j = getIntent().getStringExtra(C7292k1.f25338C0);
            this.f21976i = true;
            this.f21975h = 1;
            this.mBtnReport.setVisibility(8);
            this.mTvTip.setVisibility(8);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_child_tab_me, C2113R.id.tv_child_tab_other, C2113R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_report /* 2131296403 */:
                m25227b();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.tv_child_tab_me /* 2131297474 */:
                changeTab(true);
                break;
            case C2113R.id.tv_child_tab_other /* 2131297475 */:
                changeTab(false);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_record_new;
    }

    /* renamed from: b */
    private void m25227b() {
        List<CallBean> list = this.f21974g;
        if (list != null && list.size() > 0) {
            this.f21971d.addAll(this.f21974g);
        }
        if (this.f21971d.size() == 0) {
            C7331w1.m26688a("还没有选择电话");
        } else {
            C6049c.m24987f().m25000d(new C7265a(300, this.f21971d));
            finish();
        }
    }

    /* renamed from: c */
    private void m25229c() {
        this.f21972e.addAll(this.f21971d);
        Intent intent = new Intent(this.mActivity, (Class<?>) CriminalCallAddActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.f21977j);
        intent.putExtra(C7292k1.f25391c, (Serializable) this.f21972e);
        intent.putExtra(C7292k1.f25397e, this.f21972e.size() - 1);
        startActivity(intent);
        finish();
    }

    /* renamed from: a */
    public void m25232a() {
        try {
            Cursor query = getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", CommonNetImpl.NAME, "geocoded_location", "duration"}, null, null, null);
            while (query.moveToNext()) {
                String string = query.getString(0);
                long j2 = query.getLong(1);
                int i2 = query.getInt(2);
                query.getString(3);
                String string2 = query.getString(4);
                long j3 = query.getLong(5);
                if (string.contains("<") && !TextUtils.isEmpty(string)) {
                    string = string.substring(string.indexOf("<") + 1, string.lastIndexOf(">"));
                }
                String str = string;
                String str2 = string2 == null ? "" : string2;
                if (!TextUtils.isEmpty(str)) {
                    CallBean callBean = new CallBean(str, C7337y1.m26765b(Long.valueOf(j2)), str2, i2, false, j3);
                    callBean.setTalkTime(m25231a(j3));
                    if (i2 == 2) {
                        this.f21968a.add(callBean);
                    } else {
                        this.f21969b.add(callBean);
                    }
                }
            }
            query.close();
        } catch (Exception unused) {
            showDlogPrimssExcept();
        }
    }

    /* renamed from: a */
    public String m25231a(long j2) {
        if (j2 < 60) {
            return j2 + "秒";
        }
        if (j2 > 60 && j2 < 3600) {
            return ((j2 % 3600) / 60) + "分钟";
        }
        return (j2 / 3600) + "小时" + ((j2 % 3600) / 60) + "分钟";
    }

    @Override // adapter.CallSelectNewAdapter.InterfaceC0057b
    /* renamed from: a */
    public void mo222a(int i2, List<CallBean> list, CallBean callBean) {
        if (i2 < 0) {
            return;
        }
        CallBean callBean2 = list.get(i2);
        if (!callBean2.isSelect()) {
            if (this.f21971d.size() == this.f21975h) {
                C7331w1.m26688a("最多选择" + this.f21975h + "个");
                return;
            }
            callBean2.setSelect(true);
            if (!this.f21971d.contains(callBean2)) {
                this.f21971d.add(callBean2);
            }
            if (this.f21976i) {
                String crime_time = callBean2.getCrime_time();
                if (crime_time.length() > 2) {
                    callBean2.setTalkTime(crime_time.substring(0, crime_time.length() - 3));
                }
                callBean2.setIsInput(1);
                callBean2.setSuspectMobile(callBean2.getNumber());
                callBean2.setCallDuration(callBean2.getDuration() + "秒");
                m25229c();
            }
        } else {
            callBean2.setSelect(false);
            this.f21971d.remove(callBean2);
            if (callBean != null && this.f21974g.contains(callBean)) {
                this.f21974g.remove(callBean);
            }
        }
        this.f21970c.notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m25223a(TextView textView, TextView textView2) {
        textView.setTextColor(getResources().getColor(C2113R.color.black_dark));
        textView2.setTextColor(getResources().getColor(C2113R.color.colorGray));
    }
}
