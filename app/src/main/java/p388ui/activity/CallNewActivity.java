package p388ui.activity;

import adapter.CallNewAdapter;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import manager.LoginManager;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class CallNewActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i {

    /* renamed from: a */
    private CallNewAdapter f21930a;

    /* renamed from: b */
    private List<CallBean> f21931b = new ArrayList();

    /* renamed from: c */
    private int f21932c = 20;

    /* renamed from: d */
    private String f21933d = "条举报电话";

    /* renamed from: e */
    private String f21934e = "最多选择或添加";

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

    /* renamed from: ui.activity.CallNewActivity$a */
    class C6167a implements IClickListener {
        C6167a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CallNewActivity.this.m25213a();
            CallNewActivity.this.sendData();
            CallNewActivity.this.finish();
        }
    }

    /* renamed from: ui.activity.CallNewActivity$b */
    class C6168b implements PermissionsListener {
        C6168b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(CallNewActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = CallNewActivity.this.f21931b != null ? CallNewActivity.this.f21931b.size() : 0;
            Intent intent = new Intent(CallNewActivity.this, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_can", CallNewActivity.this.f21932c - size);
            CallNewActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25533l}, new C6168b());
    }

    private boolean hasYourselfPhone() {
        String visiblePhone = AccountManager.getVisiblePhone();
        Iterator<CallBean> it = this.f21931b.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(visiblePhone, it.next().getNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("添加诈骗电话");
        this.mTvSelectTip.setText("选择通话记录");
        this.mTvInputTip.setText("手动输入");
        this.mTvCommitTip.setText(getResources().getString(C2113R.string.commit_tip_start_str) + this.f21932c + this.f21933d);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f21930a = new CallNewAdapter(C2113R.layout.recyclerview_call_new, this.f21931b);
        this.f21930a.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f21930a);
        this.f21930a.setOnItemChildClickListener(this);
        redisplayData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (hasYourselfPhone()) {
            C7257b1.m26184a(this.mActivity, "添加的诈骗电话中包含您的登录号码，确定添加个人手机号为诈骗电话？", "", "取消", "确定", -1, -1, true, (IClickListener) new C6167a());
        } else {
            sendData();
            super.onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 300) {
                C6049c.m24987f().m25002f(c7265a);
                m25214a(this.f21931b, (List) c7265a.m26300b(), null);
                this.f21930a.setNewData(this.f21931b);
                return;
            }
            if (m26297a != 301) {
                return;
            }
            C6049c.m24987f().m25002f(c7265a);
            this.f21931b = (List) c7265a.m26300b();
            this.f21930a.setNewData(this.f21931b);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_clear) {
            this.f21931b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != C2113R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) CallEditActivity.class);
            intent.putExtra(C7292k1.f25391c, (Serializable) this.f21931b);
            intent.putExtra(C7292k1.f25397e, i2);
            startActivity(intent);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.ll_input, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    onBackPressed();
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.ll_input /* 2131296950 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) CallEditActivity.class);
                    intent.putExtra(C7292k1.f25391c, (Serializable) this.f21931b);
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
            list = (List) getIntent().getSerializableExtra(C7292k1.f25432s);
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((CallBean) it.next());
            }
        }
        if (arrayList.size() > 0) {
            this.f21931b.addAll(arrayList);
            this.f21930a.notifyDataSetChanged();
        }
    }

    public boolean rejuctOperation() {
        List<CallBean> list = this.f21931b;
        if (list == null || list.size() != this.f21932c) {
            return false;
        }
        C7331w1.m26688a(this.f21934e + this.f21932c + this.f21933d);
        return true;
    }

    public void sendData() {
        C6049c.m24987f().m25000d(new C7265a(9, this.f21931b));
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_new;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25213a() {
        List<CallBean> list = this.f21931b;
        String visiblePhone = AccountManager.getVisiblePhone();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(visiblePhone, list.get(i2).getNumber())) {
                this.f21931b.remove(i2);
            }
        }
    }

    /* renamed from: a */
    private void m25214a(List<CallBean> list, List<CallBean> list2, CallBean callBean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null || (list2.size() <= 0 && callBean != null)) {
            list2 = new ArrayList<>();
            list2.add(callBean);
        }
        for (CallBean callBean2 : list2) {
            if (list.size() > 0) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    CallBean callBean3 = list.get(i2);
                    if (TextUtils.equals(callBean2.getNumber(), callBean3.getNumber()) && TextUtils.equals(callBean2.getCrime_time(), callBean3.getCrime_time())) {
                        if (!TextUtils.isEmpty(callBean3.getVictimTel())) {
                            list.set(i2, callBean2);
                        }
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    list.add(callBean2);
                }
            } else {
                list.add(callBean2);
            }
        }
    }
}
