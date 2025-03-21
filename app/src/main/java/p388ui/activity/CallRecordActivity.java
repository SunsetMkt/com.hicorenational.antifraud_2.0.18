package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import event.CallEventBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import util.C7331w1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class CallRecordActivity extends BaseActivity implements CallSelectAdapter.InterfaceC0055b {

    /* renamed from: b */
    private CallSelectAdapter f21951b;

    @BindView(C2113R.id.btn_report)
    Button mBtnReport;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: a */
    private List<CallBean> f21950a = new ArrayList();

    /* renamed from: c */
    private List<CallBean> f21952c = new ArrayList();

    /* renamed from: d */
    private boolean f21953d = true;

    /* renamed from: e */
    private List<CallBean> f21954e = new ArrayList();

    /* renamed from: f */
    private int f21955f = 100;

    /* renamed from: ui.activity.CallRecordActivity$a */
    class RunnableC6173a implements Runnable {

        /* renamed from: ui.activity.CallRecordActivity$a$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallRecordActivity.this.f21951b.notifyDataSetChanged();
            }
        }

        RunnableC6173a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CallRecordActivity.this.f21950a.addAll(CallRecordActivity.this.m25222a());
            if (CallRecordActivity.this.f21953d && CallRecordActivity.this.f21950a != null) {
                Collections.reverse(CallRecordActivity.this.f21950a);
                CallRecordActivity.this.f21953d = false;
            }
            CallRecordActivity.this.runOnUiThread(new a());
        }
    }

    private void initData() {
        try {
            this.f21955f = getIntent().getIntExtra("extra_select_can", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f21955f = 0;
        }
        new Thread(new RunnableC6173a()).start();
    }

    private void initView() {
        this.mTvTitle.setText("通话记录选择");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f21951b = new CallSelectAdapter(C2113R.layout.recyclerview_call_select, this.f21950a, this.f21954e);
        this.f21951b.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f21951b);
        this.f21951b.setOnItemClickListener(this);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        initView();
        initData();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_report) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        List<CallBean> list = this.f21954e;
        if (list != null && list.size() > 0) {
            this.f21952c.addAll(this.f21954e);
        }
        if (this.f21952c.size() == 0) {
            C7331w1.m26688a("还没有选择电话");
        } else {
            C6049c.m24987f().m25000d(new CallEventBean(this.f21952c));
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_record;
    }

    /* renamed from: a */
    public List<CallBean> m25222a() {
        try {
            ArrayList arrayList = new ArrayList();
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
                    arrayList.add(new CallBean(str, C7337y1.m26765b(Long.valueOf(j2)), str2, i2, false, j3));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception unused) {
            showDlogPrimssExcept();
            return null;
        }
    }

    @Override // adapter.CallSelectAdapter.InterfaceC0055b
    /* renamed from: a */
    public void mo218a(int i2, List<CallBean> list, CallBean callBean) {
        if (i2 < 0) {
            return;
        }
        CallBean callBean2 = list.get(i2);
        if (!callBean2.isSelect()) {
            if (this.f21952c.size() == this.f21955f) {
                C7331w1.m26688a("最多选择" + this.f21955f + "个");
                return;
            }
            callBean2.setSelect(true);
            if (!this.f21952c.contains(callBean2)) {
                this.f21952c.add(callBean2);
            }
        } else {
            callBean2.setSelect(false);
            this.f21952c.remove(callBean2);
            if (callBean != null && this.f21954e.contains(callBean)) {
                this.f21954e.remove(callBean);
            }
        }
        this.f21951b.notifyDataSetChanged();
    }
}
