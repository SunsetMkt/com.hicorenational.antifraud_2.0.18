package p388ui.activity;

import adapter.IDVarfyListAdapter;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.IDVarfyBean;
import bean.VerifyAcceptBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2882b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import java.util.ArrayList;
import java.util.List;
import p388ui.callview.IdVartyCallView;
import p388ui.presenter.IDVarfyPresenter;
import p388ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class IDVarfyListActivity extends BaseActivity implements IdVartyCallView {
    private IDVarfyListAdapter mAdapter;

    @BindView(C2113R.id.ll_nodata)
    View mLlNodata;
    private IDVarfyPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.sm_refresh)
    SmartRefreshLayout mRefreshLayout;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private List<IDVarfyBean.Rows> callBeans = new ArrayList();
    public boolean isLoadmore = false;
    public int pageIndex = 1;
    public int pageSize = 10;

    private void initListener() {
        this.mRefreshLayout.mo8622a((InterfaceC2873g) new ClassicsHeader(this));
        this.mRefreshLayout.mo8682s(false);
        this.mRefreshLayout.mo8627a(new InterfaceC2884d() { // from class: ui.activity.a0
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
            /* renamed from: a */
            public final void mo8732a(InterfaceC2876j interfaceC2876j) {
                IDVarfyListActivity.this.m25257a(interfaceC2876j);
            }
        });
        this.mRefreshLayout.mo8625a(new InterfaceC2882b() { // from class: ui.activity.b0
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2882b
            /* renamed from: b */
            public final void mo8723b(InterfaceC2876j interfaceC2876j) {
                IDVarfyListActivity.this.m25258b(interfaceC2876j);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25257a(InterfaceC2876j interfaceC2876j) {
        pullToRefresh();
    }

    /* renamed from: b */
    public /* synthetic */ void m25258b(InterfaceC2876j interfaceC2876j) {
        pullToLoadMore();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("核实记录");
        this.mPresenter = new IDVarfyPresenter(this, this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new IDVarfyListAdapter(this.callBeans);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        initListener();
        this.mRefreshLayout.mo8653e();
    }

    @Override // p388ui.callview.IdVartyCallView
    public void onSuccessAccRequest(List<VerifyAcceptBean> list) {
    }

    @Override // p388ui.callview.IdVartyCallView
    public void onSuccessRequest(List<IDVarfyBean.Rows> list) {
        this.mRefreshLayout.mo8658g();
        this.mRefreshLayout.mo8637b();
        if (list != null && list.size() > 0) {
            if (this.isLoadmore) {
                this.mAdapter.m5134c().addAll(list);
                this.mAdapter.notifyDataSetChanged();
            } else {
                this.mAdapter.m253a(list);
                this.mRefreshLayout.mo8682s(true);
            }
            if (list.size() < this.pageSize) {
                this.mRefreshLayout.mo8682s(false);
            } else if (list.size() > this.pageSize) {
                this.mRefreshLayout.mo8682s(false);
            } else {
                this.mRefreshLayout.mo8682s(true);
            }
        } else if (this.isLoadmore) {
            this.mRefreshLayout.mo8682s(false);
        }
        if (this.mAdapter.m5134c().size() > 0) {
            this.mLlNodata.setVisibility(8);
        } else {
            this.mLlNodata.setVisibility(0);
        }
        this.isLoadmore = false;
    }

    @OnClick({C2113R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.callview.IdVartyCallView
    public void onfailRequest() {
        this.mRefreshLayout.mo8658g();
    }

    public void pullToLoadMore() {
        if (this.mRefreshLayout == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmore = true;
        int size = this.callBeans.size();
        int i2 = this.pageSize;
        this.pageIndex = (size / i2) + 1;
        this.mPresenter.ListPrincipalHttp(this.pageIndex, i2);
    }

    public void pullToRefresh() {
        IDVarfyPresenter iDVarfyPresenter;
        if (this.mRefreshLayout == null || (iDVarfyPresenter = this.mPresenter) == null) {
            return;
        }
        this.pageIndex = 1;
        this.isLoadmore = false;
        iDVarfyPresenter.ListPrincipalHttp(this.pageIndex, this.pageSize);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_idvarify_list;
    }
}
