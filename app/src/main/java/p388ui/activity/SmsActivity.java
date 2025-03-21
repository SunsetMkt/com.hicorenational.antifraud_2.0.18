package p388ui.activity;

import adapter.SmsDeleteAdapter;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class SmsActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i {

    /* renamed from: f */
    public static final int f23166f = 1000;

    /* renamed from: a */
    private SmsDeleteAdapter f23167a;

    /* renamed from: b */
    private List<SmsBean> f23168b = new ArrayList();

    /* renamed from: c */
    private int f23169c = 20;

    /* renamed from: d */
    private String f23170d = "条短信";

    /* renamed from: e */
    private String f23171e = "最多选择或添加";

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(C2113R.id.tv_input_tip)
    TextView mTvInputTip;

    @BindView(C2113R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.SmsActivity$a */
    class C6596a implements PermissionsListener {
        C6596a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(SmsActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = SmsActivity.this.f23168b != null ? SmsActivity.this.f23168b.size() : 0;
            Intent intent = new Intent(SmsActivity.this, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f23201h, 1);
            intent.putExtra("extra_select_can", SmsActivity.this.f23169c - size);
            SmsActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25544w, C7308a.f25543v}, new C6596a());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("添加诈骗短信");
        this.mTvSelectTip.setText("选择短信");
        this.mTvInputTip.setText("手动输入");
        this.mTvCommitTip.setText(getResources().getString(C2113R.string.commit_tip_start_str) + this.f23169c + this.f23170d);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f23167a = new SmsDeleteAdapter(C2113R.layout.recyclerview_sms_record_select, this.f23168b);
        this.f23167a.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f23167a);
        this.f23167a.setOnItemChildClickListener(this);
        redisplayData();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEvent(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a != 302) {
                if (m26297a != 303) {
                    return;
                }
                C6049c.m24987f().m25002f(c7265a);
                this.f23168b = (List) c7265a.m26300b();
                this.f23167a.setNewData(this.f23168b);
                return;
            }
            C6049c.m24987f().m25002f(c7265a);
            List<SmsBean> list = (List) c7265a.m26300b();
            if (list == null || list.size() <= 0) {
                return;
            }
            m25362a(this.f23168b, list);
            this.f23167a.setNewData(this.f23168b);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_clear) {
            this.f23168b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != C2113R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) SmsAddActivity.class);
            intent.putExtra(C7292k1.f25391c, (Serializable) this.f23168b);
            intent.putExtra(C7292k1.f25397e, i2);
            startActivity(intent);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.ll_input, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    sendData();
                    finish();
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                sendData();
                onBackPressed();
                break;
            case C2113R.id.ll_input /* 2131296950 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) SmsAddActivity.class);
                    intent.putExtra(C7292k1.f25391c, (Serializable) this.f23168b);
                    startActivity(intent);
                    break;
                }
                break;
            case C2113R.id.ll_select /* 2131296984 */:
                if (!rejuctOperation()) {
                    checkPermission();
                    break;
                }
                break;
        }
    }

    public void redisplayData() {
        List list;
        try {
            list = (List) getIntent().getSerializableExtra(C7292k1.f25436u);
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f23168b.addAll(list);
        this.f23167a.notifyDataSetChanged();
    }

    public boolean rejuctOperation() {
        List<SmsBean> list = this.f23168b;
        if (list == null || list.size() != this.f23169c) {
            return false;
        }
        C7331w1.m26688a(this.f23171e + this.f23169c + this.f23170d);
        return true;
    }

    public void sendData() {
        C6049c.m24987f().m25000d(new C7265a(10, this.f23168b));
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_new;
    }

    /* renamed from: a */
    private void m25362a(List<SmsBean> list, List<SmsBean> list2) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (SmsBean smsBean : list2) {
            if (list.size() > 0) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    SmsBean smsBean2 = list.get(i2);
                    if (TextUtils.equals(smsBean.getSmsNum(), smsBean2.getSmsNum()) && TextUtils.equals(smsBean.getStringDate(), smsBean2.getStringDate())) {
                        if (!TextUtils.isEmpty(smsBean2.getVictimTel())) {
                            list.set(i2, smsBean);
                        }
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    list.add(smsBean);
                }
            } else {
                list.add(smsBean);
            }
        }
    }
}
