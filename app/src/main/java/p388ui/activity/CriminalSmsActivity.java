package p388ui.activity;

import adapter.CommitSmsAdapter;
import adapter.CriminalSmsAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSmsBean;
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
import p388ui.callview.CriminalSmsCallView;
import p388ui.presenter.CriminalSmsPresenter;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class CriminalSmsActivity extends BaseActivity implements CriminalSmsCallView, BaseQuickAdapter.InterfaceC1895i {
    private CriminalSmsAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;
    private String mCaseInfoId;

    @BindView(C2113R.id.inc_complete)
    LinearLayout mIncComplete;

    @BindView(C2113R.id.inc_input)
    LinearLayout mIncInput;
    private CriminalSmsPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;
    private CommitSmsAdapter mShowAdapter;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(C2113R.id.tv_input_tip)
    TextView mTvInputTip;

    @BindView(C2113R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private List<CriminalSmsBean> mSmsList = new ArrayList();
    private int mMaxSelectNum = 20;
    private String mEndStr = "条涉诈短信";
    private String mSelectWarnStartStr = "最多可添加";
    private boolean mOnlyShow = false;

    /* renamed from: ui.activity.CriminalSmsActivity$a */
    class C6253a implements BaseQuickAdapter.InterfaceC1897k {
        C6253a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1897k
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            Intent intent = new Intent(CriminalSmsActivity.this, (Class<?>) (((CriminalSmsBean) CriminalSmsActivity.this.mSmsList.get(i2)).getIsInput() == 2 ? CriminalSmsSelectActivity.class : CriminalSmsAddActivity.class));
            intent.putExtra(C7292k1.f25391c, (Serializable) CriminalSmsActivity.this.mSmsList);
            intent.putExtra(C7292k1.f25397e, i2);
            intent.putExtra(C7292k1.f25338C0, CriminalSmsActivity.this.mCaseInfoId);
            intent.putExtra(C7292k1.f25394d, true);
            CriminalSmsActivity.this.startActivity(intent);
        }
    }

    /* renamed from: ui.activity.CriminalSmsActivity$b */
    class C6254b implements PermissionsListener {
        C6254b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(CriminalSmsActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(CriminalSmsActivity.this, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f23201h, 1);
            intent.putExtra("extra_select_can", 1);
            intent.putExtra(SmsRecordSelectActivity.f23204k, SmsRecordSelectActivity.f23205l);
            CriminalSmsActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25544w, C7308a.f25543v, C7308a.f25521A, C7308a.f25547z}, new C6254b());
    }

    private CriminalSmsAdapter initRecycler(RecyclerView recyclerView) {
        this.mIncInput.setVisibility(0);
        this.mIncComplete.setVisibility(0);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CriminalSmsAdapter criminalSmsAdapter = new CriminalSmsAdapter(this.mSmsList);
        criminalSmsAdapter.m5103a(recyclerView);
        recyclerView.setAdapter(criminalSmsAdapter);
        criminalSmsAdapter.setOnItemChildClickListener(this);
        return criminalSmsAdapter;
    }

    private CommitSmsAdapter showInitRecycler(RecyclerView recyclerView) {
        this.mIncInput.setVisibility(8);
        this.mIncComplete.setVisibility(8);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CommitSmsAdapter commitSmsAdapter = new CommitSmsAdapter(this.mSmsList);
        commitSmsAdapter.m5103a(recyclerView);
        recyclerView.setAdapter(commitSmsAdapter);
        commitSmsAdapter.setOnItemClickListener(new C6253a());
        return commitSmsAdapter;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("添加涉诈短信");
        this.mTvSelectTip.setText("选择短信");
        this.mTvSelectTip.setTextColor(Color.parseColor("#2D4AEB"));
        this.mTvInputTip.setText("手动输入");
        this.mTvInputTip.setTextColor(Color.parseColor("#2D4AEB"));
        this.mTvCommitTip.setText(this.mSelectWarnStartStr + this.mMaxSelectNum + this.mEndStr);
        this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        this.mOnlyShow = getIntent().getBooleanExtra(C7292k1.f25394d, false);
        this.mPresenter = new CriminalSmsPresenter(this.mActivity, this);
        if (!this.mOnlyShow) {
            this.mAdapter = initRecycler(this.mRecyclerview);
        } else {
            this.mTvTitle.setText("涉诈短信");
            this.mShowAdapter = showInitRecycler(this.mRecyclerview);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEvent(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 302) {
            return;
        }
        C6049c.m24987f().m25002f(c7265a);
        List list = (List) c7265a.m26300b();
        if (list == null || list.size() <= 0) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CriminalSmsSelectActivity.class);
        intent.putExtra(C7292k1.f25391c, (Serializable) this.mSmsList);
        intent.putExtra(C7292k1.f25388b, (Serializable) list.get(0));
        intent.putExtra(C7292k1.f25338C0, this.mCaseInfoId);
        startActivity(intent);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_clear) {
            CriminalSmsBean criminalSmsBean = this.mSmsList.get(i2);
            criminalSmsBean.setCaseInfoID(this.mCaseInfoId);
            this.mPresenter.deleteHttp(criminalSmsBean, i2);
        } else {
            if (id != C2113R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) (this.mSmsList.get(i2).getIsInput() == 2 ? CriminalSmsSelectActivity.class : CriminalSmsAddActivity.class));
            intent.putExtra(C7292k1.f25391c, (Serializable) this.mSmsList);
            intent.putExtra(C7292k1.f25397e, i2);
            intent.putExtra(C7292k1.f25338C0, this.mCaseInfoId);
            intent.putExtra(C7292k1.f25394d, this.mOnlyShow);
            startActivity(intent);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.http(this.mCaseInfoId);
    }

    @Override // p388ui.callview.CriminalSmsCallView
    public void onSuccess(List<CriminalSmsBean> list) {
        if (list != null) {
            this.mSmsList.clear();
            this.mSmsList.addAll(list);
            if (this.mOnlyShow) {
                this.mShowAdapter.notifyDataSetChanged();
            } else {
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // p388ui.callview.CriminalSmsCallView
    public void onSuccessDelete(int i2) {
        this.mSmsList.remove(i2);
        CriminalSmsAdapter criminalSmsAdapter = this.mAdapter;
        if (criminalSmsAdapter != null) {
            criminalSmsAdapter.notifyDataSetChanged();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.ll_input, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    finish();
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.ll_input /* 2131296950 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) CriminalSmsAddActivity.class);
                    intent.putExtra(C7292k1.f25391c, (Serializable) this.mSmsList);
                    intent.putExtra(C7292k1.f25338C0, this.mCaseInfoId);
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

    public boolean rejuctOperation() {
        List<CriminalSmsBean> list = this.mSmsList;
        if (list == null || list.size() != this.mMaxSelectNum) {
            return false;
        }
        C7331w1.m26688a(this.mSelectWarnStartStr + this.mMaxSelectNum + this.mEndStr);
        return true;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_criminal_sms;
    }
}
