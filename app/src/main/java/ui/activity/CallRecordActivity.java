package ui.activity;

import adapter.CallSelectAdapter;
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
import event.CallEventBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ui.Hicore;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class CallRecordActivity extends BaseActivity implements CallSelectAdapter.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CallSelectAdapter f13161b;

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<CallBean> a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<CallBean> f13162c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13163d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<CallBean> f13164e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13165f = 100;

    class a implements Runnable {

        /* JADX INFO: renamed from: ui.activity.CallRecordActivity$a$a, reason: collision with other inner class name */
        class RunnableC0282a implements Runnable {
            RunnableC0282a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallRecordActivity.this.f13161b.notifyDataSetChanged();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CallRecordActivity.this.a.addAll(CallRecordActivity.this.a());
            if (CallRecordActivity.this.f13163d && CallRecordActivity.this.a != null) {
                Collections.reverse(CallRecordActivity.this.a);
                CallRecordActivity.this.f13163d = false;
            }
            CallRecordActivity.this.runOnUiThread(new RunnableC0282a());
        }
    }

    private void initData() {
        try {
            this.f13165f = getIntent().getIntExtra("extra_select_can", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f13165f = 0;
        }
        new Thread(new a()).start();
    }

    private void initView() {
        this.mTvTitle.setText("\u901a\u8bdd\u8bb0\u5f55\u9009\u62e9");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f13161b = new CallSelectAdapter(R.layout.recyclerview_call_select, this.a, this.f13164e);
        this.f13161b.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f13161b);
        this.f13161b.setOnItemClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
        initData();
    }

    @OnClick({R.id.iv_back, R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_report) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        List<CallBean> list = this.f13164e;
        if (list != null && list.size() > 0) {
            this.f13162c.addAll(this.f13164e);
        }
        if (this.f13162c.size() == 0) {
            e2.a("\u8fd8\u6ca1\u6709\u9009\u62e9\u7535\u8bdd");
        } else {
            org.greenrobot.eventbus.c.f().d(new CallEventBean(this.f13162c));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_record;
    }

    public List<CallBean> a() {
        try {
            ArrayList arrayList = new ArrayList();
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
                    arrayList.add(new CallBean(str, g2.b(Long.valueOf(j2)), str2, i2, false, j3));
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception unused) {
            showDlogPrimssExcept();
            return null;
        }
    }

    @Override // adapter.CallSelectAdapter.b
    public void a(int i2, List<CallBean> list, CallBean callBean) {
        if (i2 < 0) {
            return;
        }
        CallBean callBean2 = list.get(i2);
        if (!callBean2.isSelect()) {
            if (this.f13162c.size() == this.f13165f) {
                e2.a("\u6700\u591a\u9009\u62e9" + this.f13165f + "\u4e2a");
                return;
            }
            callBean2.setSelect(true);
            if (!this.f13162c.contains(callBean2)) {
                this.f13162c.add(callBean2);
            }
        } else {
            callBean2.setSelect(false);
            this.f13162c.remove(callBean2);
            if (callBean != null && this.f13164e.contains(callBean)) {
                this.f13164e.remove(callBean);
            }
        }
        this.f13161b.notifyDataSetChanged();
    }
}
