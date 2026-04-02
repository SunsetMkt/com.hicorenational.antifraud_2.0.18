package ui.activity;

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
import com.hicorenational.antifraud.R;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class SmsActivity extends BaseActivity implements BaseQuickAdapter.i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13837f = 1000;
    private SmsDeleteAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<SmsBean> f13838b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13839c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13840d = "\u6761\u77ed\u4fe1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13841e = "\u6700\u591a\u9009\u62e9\u6216\u6dfb\u52a0";

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

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(SmsActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = SmsActivity.this.f13838b != null ? SmsActivity.this.f13838b.size() : 0;
            Intent intent = new Intent(SmsActivity.this, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f13859h, 1);
            intent.putExtra("extra_select_can", SmsActivity.this.f13839c - size);
            SmsActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.w, util.permissionutil.a.v}, new a());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("\u6dfb\u52a0\u8bc8\u9a97\u77ed\u4fe1");
        this.mTvSelectTip.setText("\u9009\u62e9\u77ed\u4fe1");
        this.mTvInputTip.setText("\u624b\u52a8\u8f93\u5165");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.f13839c + this.f13840d);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.a = new SmsDeleteAdapter(R.layout.recyclerview_sms_record_select, this.f13838b);
        this.a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.a);
        this.a.setOnItemChildClickListener(this);
        redisplayData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEvent(util.n2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA != 302) {
                if (iA != 303) {
                    return;
                }
                org.greenrobot.eventbus.c.f().f(aVar);
                this.f13838b = (List) aVar.b();
                this.a.setNewData(this.f13838b);
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            List<SmsBean> list = (List) aVar.b();
            if (list == null || list.size() <= 0) {
                return;
            }
            a(this.f13838b, list);
            this.a.setNewData(this.f13838b);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_clear) {
            this.f13838b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) SmsAddActivity.class);
            intent.putExtra(util.p1.f15011c, (Serializable) this.f13838b);
            intent.putExtra(util.p1.f15013e, i2);
            startActivity(intent);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.ll_input, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    sendData();
                    finish();
                    break;
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                sendData();
                onBackPressed();
                break;
            case R.id.ll_input /* 2131297000 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) SmsAddActivity.class);
                    intent.putExtra(util.p1.f15011c, (Serializable) this.f13838b);
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
            list = (List) getIntent().getSerializableExtra(util.p1.u);
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f13838b.addAll(list);
        this.a.notifyDataSetChanged();
    }

    public boolean rejuctOperation() {
        List<SmsBean> list = this.f13838b;
        if (list == null || list.size() != this.f13839c) {
            return false;
        }
        e2.a(this.f13841e + this.f13839c + this.f13840d);
        return true;
    }

    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.n2.a(10, this.f13838b));
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_new;
    }

    private void a(List<SmsBean> list, List<SmsBean> list2) {
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
