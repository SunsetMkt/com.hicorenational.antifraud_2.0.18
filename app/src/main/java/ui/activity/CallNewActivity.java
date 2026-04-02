package ui.activity;

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
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import manager.LoginManager;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CallNewActivity extends BaseActivity implements BaseQuickAdapter.i {
    private CallNewAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<CallBean> f13149b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13150c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13151d = "\u6761\u4e3e\u62a5\u7535\u8bdd";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13152e = "\u6700\u591a\u9009\u62e9\u6216\u6dfb\u52a0";

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(R.id.tv_input_tip)
    TextView mTvInputTip;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CallNewActivity.this.a();
            CallNewActivity.this.sendData();
            CallNewActivity.this.finish();
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(CallNewActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = CallNewActivity.this.f13149b != null ? CallNewActivity.this.f13149b.size() : 0;
            Intent intent = new Intent(CallNewActivity.this, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_can", CallNewActivity.this.f13150c - size);
            CallNewActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f15035l}, new b());
    }

    private boolean hasYourselfPhone() {
        String visiblePhone = AccountManager.getVisiblePhone();
        Iterator<CallBean> it = this.f13149b.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(visiblePhone, it.next().getNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("\u6dfb\u52a0\u8bc8\u9a97\u7535\u8bdd");
        this.mTvSelectTip.setText("\u9009\u62e9\u901a\u8bdd\u8bb0\u5f55");
        this.mTvInputTip.setText("\u624b\u52a8\u8f93\u5165");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.f13150c + this.f13151d);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.a = new CallNewAdapter(R.layout.recyclerview_call_new, this.f13149b);
        this.a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.a);
        this.a.setOnItemChildClickListener(this);
        redisplayData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (hasYourselfPhone()) {
            util.f1.a(this.mActivity, "\u6dfb\u52a0\u7684\u8bc8\u9a97\u7535\u8bdd\u4e2d\u5305\u542b\u60a8\u7684\u767b\u5f55\u53f7\u7801\uff0c\u786e\u5b9a\u6dfb\u52a0\u4e2a\u4eba\u624b\u673a\u53f7\u4e3a\u8bc8\u9a97\u7535\u8bdd\uff1f", "", "\u53d6\u6d88", "\u786e\u5b9a", -1, -1, true, (IClickListener) new a());
        } else {
            sendData();
            super.onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(util.n2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 300) {
                org.greenrobot.eventbus.c.f().f(aVar);
                a(this.f13149b, (List) aVar.b(), null);
                this.a.setNewData(this.f13149b);
                return;
            }
            if (iA != 301) {
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            this.f13149b = (List) aVar.b();
            this.a.setNewData(this.f13149b);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_clear) {
            this.f13149b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) CallEditActivity.class);
            intent.putExtra(util.p1.f15011c, (Serializable) this.f13149b);
            intent.putExtra(util.p1.f15013e, i2);
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.ll_input, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    onBackPressed();
                    break;
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                onBackPressed();
                break;
            case R.id.ll_input /* 2131297000 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) CallEditActivity.class);
                    intent.putExtra(util.p1.f15011c, (Serializable) this.f13149b);
                    startActivity(intent);
                    break;
                }
                break;
            case R.id.ll_select /* 2131297034 */:
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
            list = (List) getIntent().getSerializableExtra(util.p1.s);
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
            this.f13149b.addAll(arrayList);
            this.a.notifyDataSetChanged();
        }
    }

    public boolean rejuctOperation() {
        List<CallBean> list = this.f13149b;
        if (list == null || list.size() != this.f13150c) {
            return false;
        }
        e2.a(this.f13152e + this.f13150c + this.f13151d);
        return true;
    }

    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.n2.a(9, this.f13149b));
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_new;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<CallBean> list = this.f13149b;
        String visiblePhone = AccountManager.getVisiblePhone();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(visiblePhone, list.get(i2).getNumber())) {
                this.f13149b.remove(i2);
            }
        }
    }

    private void a(List<CallBean> list, List<CallBean> list2, CallBean callBean) {
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
