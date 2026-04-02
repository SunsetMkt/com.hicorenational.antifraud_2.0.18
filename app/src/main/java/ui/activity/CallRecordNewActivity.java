package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ui.Hicore;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class CallRecordNewActivity extends BaseActivity implements CallSelectNewAdapter.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13170k = "extra_select_limite";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f13171l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13172m = "extra_select_can";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CallSelectNewAdapter f13174c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f13181j;

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_child_tab_me)
    TextView mTvChildTabMe;

    @BindView(R.id.tv_child_tab_other)
    TextView mTvChildTabOther;

    @BindView(R.id.tv_tip)
    TextView mTvTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.v_me)
    View mVMe;

    @BindView(R.id.v_other)
    View mVOther;
    private List<CallBean> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<CallBean> f13173b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<CallBean> f13175d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<CallBean> f13176e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13177f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<CallBean> f13178g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13179h = 100;

    class a implements Runnable {

        /* JADX INFO: renamed from: ui.activity.CallRecordNewActivity$a$a, reason: collision with other inner class name */
        class RunnableC0283a implements Runnable {
            RunnableC0283a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallRecordNewActivity.this.f13174c.setNewData(CallRecordNewActivity.this.f13173b);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CallRecordNewActivity.this.a();
            if (CallRecordNewActivity.this.f13177f) {
                if (CallRecordNewActivity.this.a != null) {
                    Collections.reverse(CallRecordNewActivity.this.a);
                }
                if (CallRecordNewActivity.this.f13173b != null) {
                    Collections.reverse(CallRecordNewActivity.this.f13173b);
                }
                CallRecordNewActivity.this.f13177f = false;
            }
            CallRecordNewActivity.this.runOnUiThread(new RunnableC0283a());
        }
    }

    private void changeTab(boolean z) {
        if (z) {
            if (this.mVMe.getVisibility() != 0) {
                a(this.mTvChildTabMe, this.mTvChildTabOther);
                this.mVMe.setVisibility(0);
                this.mVOther.setVisibility(4);
                this.f13174c.setNewData(this.f13173b);
                return;
            }
            return;
        }
        if (this.mVOther.getVisibility() != 0) {
            a(this.mTvChildTabOther, this.mTvChildTabMe);
            this.mVMe.setVisibility(4);
            this.mVOther.setVisibility(0);
            this.f13174c.setNewData(this.a);
        }
    }

    private void initData() {
        try {
            this.f13179h = getIntent().getIntExtra("extra_select_can", 20);
            this.f13176e = (List) getIntent().getSerializableExtra(util.p1.f15011c);
        } catch (Exception unused) {
        }
        new Thread(new a()).start();
    }

    private void initView() {
        this.mTvTitle.setText("\u901a\u8bdd\u8bb0\u5f55\u9009\u62e9");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f13174c = new CallSelectNewAdapter(R.layout.recyclerview_call_select_new, this.a, this.f13178g);
        this.f13174c.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f13174c);
        this.f13174c.setOnItemClickListener(this);
        changeTab(true);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
        initData();
        if (getIntent().getIntExtra("extra_select_limite", 0) == 1) {
            this.f13181j = getIntent().getStringExtra(util.p1.C0);
            this.f13180i = true;
            this.f13179h = 1;
            this.mBtnReport.setVisibility(8);
            this.mTvTip.setVisibility(8);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_child_tab_me, R.id.tv_child_tab_other, R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_report /* 2131296416 */:
                b();
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.tv_child_tab_me /* 2131297632 */:
                changeTab(true);
                break;
            case R.id.tv_child_tab_other /* 2131297633 */:
                changeTab(false);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_record_new;
    }

    private void b() {
        List<CallBean> list = this.f13178g;
        if (list != null && list.size() > 0) {
            this.f13175d.addAll(this.f13178g);
        }
        if (this.f13175d.size() == 0) {
            e2.a("\u8fd8\u6ca1\u6709\u9009\u62e9\u7535\u8bdd");
        } else {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(300, this.f13175d));
            finish();
        }
    }

    private void c() {
        this.f13176e.addAll(this.f13175d);
        Intent intent = new Intent(this.mActivity, (Class<?>) CriminalCallAddActivity.class);
        intent.putExtra(util.p1.C0, this.f13181j);
        intent.putExtra(util.p1.f15011c, (Serializable) this.f13176e);
        intent.putExtra(util.p1.f15013e, this.f13176e.size() - 1);
        startActivity(intent);
        finish();
    }

    public void a() {
        try {
            Cursor cursorQuery = getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", CommonNetImpl.NAME, "geocoded_location", "duration"}, null, null, null);
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                long j2 = cursorQuery.getLong(1);
                int i2 = cursorQuery.getInt(2);
                cursorQuery.getString(3);
                String string2 = cursorQuery.getString(4);
                long j3 = cursorQuery.getLong(5);
                if (string.contains("<") && !TextUtils.isEmpty(string)) {
                    string = string.substring(string.indexOf("<") + 1, string.lastIndexOf(">"));
                }
                String str = string;
                String str2 = string2 == null ? "" : string2;
                if (!TextUtils.isEmpty(str)) {
                    CallBean callBean = new CallBean(str, g2.b(Long.valueOf(j2)), str2, i2, false, j3);
                    callBean.setTalkTime(a(j3));
                    if (i2 == 2) {
                        this.a.add(callBean);
                    } else {
                        this.f13173b.add(callBean);
                    }
                }
            }
            cursorQuery.close();
        } catch (Exception unused) {
            showDlogPrimssExcept();
        }
    }

    public String a(long j2) {
        if (j2 < 60) {
            return j2 + "\u79d2";
        }
        if (j2 > 60 && j2 < 3600) {
            return ((j2 % 3600) / 60) + "\u5206\u949f";
        }
        return (j2 / 3600) + "\u5c0f\u65f6" + ((j2 % 3600) / 60) + "\u5206\u949f";
    }

    @Override // adapter.CallSelectNewAdapter.b
    public void a(int i2, List<CallBean> list, CallBean callBean) {
        if (i2 < 0) {
            return;
        }
        CallBean callBean2 = list.get(i2);
        if (!callBean2.isSelect()) {
            if (this.f13175d.size() == this.f13179h) {
                e2.a("\u6700\u591a\u9009\u62e9" + this.f13179h + "\u4e2a");
                return;
            }
            callBean2.setSelect(true);
            if (!this.f13175d.contains(callBean2)) {
                this.f13175d.add(callBean2);
            }
            if (this.f13180i) {
                String crime_time = callBean2.getCrime_time();
                if (crime_time.length() > 2) {
                    callBean2.setTalkTime(crime_time.substring(0, crime_time.length() - 3));
                }
                callBean2.setIsInput(1);
                callBean2.setSuspectMobile(callBean2.getNumber());
                callBean2.setCallDuration(callBean2.getDuration() + "\u79d2");
                c();
            }
        } else {
            callBean2.setSelect(false);
            this.f13175d.remove(callBean2);
            if (callBean != null && this.f13178g.contains(callBean)) {
                this.f13178g.remove(callBean);
            }
        }
        this.f13174c.notifyDataSetChanged();
    }

    private void a(TextView textView, TextView textView2) {
        textView.setTextColor(getResources().getColor(R.color.black_dark));
        textView2.setTextColor(getResources().getColor(R.color.colorGray));
    }
}
