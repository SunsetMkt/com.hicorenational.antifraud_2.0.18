package p388ui.activity;

import adapter.CiminalSocialAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSocialBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p388ui.callview.CriminalSocialCallView;
import p388ui.presenter.CriminalSocinalPresenter;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CriminalSocialActivity extends BaseActivity implements CriminalSocialCallView, BaseQuickAdapter.InterfaceC1895i {
    private CiminalSocialAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.inc_complete)
    LinearLayout mIncComplete;

    @BindView(C2113R.id.ll_select)
    LinearLayout mLlSelect;
    private CriminalSocinalPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommit;

    @BindView(C2113R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(C2113R.id.tv_tip)
    TextView mTvTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private String mCaseInfoId = "";
    private List<CriminalSocialBean> mSocialList = new ArrayList();
    private boolean mOnlyShow = false;

    /* renamed from: ui.activity.CriminalSocialActivity$a */
    class C6270a implements BaseQuickAdapter.InterfaceC1897k {
        C6270a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1897k
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            Intent intent = new Intent(CriminalSocialActivity.this.mActivity, (Class<?>) CriminalSocialEditActivity.class);
            intent.putExtra(C7292k1.f25338C0, CriminalSocialActivity.this.mCaseInfoId);
            if (i2 != -1) {
                intent.putExtra(C7292k1.f25438v, i2);
                intent.putExtra(C7292k1.f25440w, (Serializable) CriminalSocialActivity.this.mSocialList.get(i2));
            }
            intent.putExtra(C7292k1.f25394d, CriminalSocialActivity.this.mOnlyShow);
            CriminalSocialActivity.this.startActivity(intent);
        }
    }

    private void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) CriminalSocialEditActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.mCaseInfoId);
        if (i2 != -1) {
            intent.putExtra(C7292k1.f25438v, i2);
            intent.putExtra(C7292k1.f25440w, this.mSocialList.get(i2));
        }
        startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        int i2;
        this.mTvTitle.setText("添加互联网账号");
        this.mTvSelectTip.setText("添加");
        this.mTvCommit.setText("最多可添加20个涉诈社交账号");
        this.mBtnCommit.setText("确定");
        this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        this.mOnlyShow = getIntent().getBooleanExtra(C7292k1.f25394d, false);
        this.mPresenter = new CriminalSocinalPresenter(this.mActivity, this);
        if (this.mOnlyShow) {
            i2 = C2113R.layout.item_criminal_social_show;
            this.mTvTitle.setText("互联网账号");
            this.mLlSelect.setVisibility(8);
            this.mIncComplete.setVisibility(8);
            this.mTvTip.setVisibility(8);
        } else {
            i2 = C2113R.layout.item_criminal_social;
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new CiminalSocialAdapter(i2, this.mSocialList);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        if (this.mOnlyShow) {
            this.mAdapter.setOnItemClickListener(new C6270a());
        } else {
            this.mAdapter.setOnItemChildClickListener(this);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == C2113R.id.iv_delete) {
            this.mPresenter.socialDeleteHttp(this.mCaseInfoId, this.mSocialList.get(i2).getNetAccountInfoID(), i2);
        } else {
            if (id != C2113R.id.iv_edit) {
                return;
            }
            forceActivity(i2);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.socialHttp(this.mCaseInfoId);
    }

    @Override // p388ui.callview.CriminalSocialCallView
    public void onSuccess(List<CriminalSocialBean> list) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.mSocialList.clear();
        this.mSocialList.addAll(list);
        CiminalSocialAdapter ciminalSocialAdapter = this.mAdapter;
        if (ciminalSocialAdapter != null) {
            ciminalSocialAdapter.notifyDataSetChanged();
        }
    }

    @Override // p388ui.callview.CriminalSocialCallView
    public void onSuccessDelete(int i2) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.mSocialList.remove(i2);
        CiminalSocialAdapter ciminalSocialAdapter = this.mAdapter;
        if (ciminalSocialAdapter != null) {
            ciminalSocialAdapter.notifyDataSetChanged();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.btn_commit) {
            finish();
            return;
        }
        if (id == C2113R.id.iv_back) {
            finish();
        } else {
            if (id != C2113R.id.ll_select) {
                return;
            }
            if (this.mSocialList.size() >= 20) {
                C7331w1.m26688a("最多可添加20个涉诈社交账号");
            } else {
                forceActivity(-1);
            }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_criminal_social;
    }
}
