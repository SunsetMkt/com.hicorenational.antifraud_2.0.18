package p388ui.activity;

import adapter.IDVarfyAceptListAdapter;
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
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import java.util.ArrayList;
import java.util.List;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p247e.C4447d;
import p388ui.callview.IdVartyCallView;
import p388ui.presenter.IDVarfyPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class IDVarfyAceptListActivity extends BaseActivity implements IdVartyCallView {
    private List<VerifyAcceptBean> callBeans = new ArrayList();
    private IDVarfyAceptListAdapter mAdapter;

    @BindView(C2113R.id.ll_nodata)
    View mLlNodata;
    private IDVarfyPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.sm_refresh)
    SmartRefreshLayout mRefreshLayout;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    private void initListener() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17155b);
        this.mRefreshLayout.mo8622a((InterfaceC2873g) new ClassicsHeader(this));
        this.mRefreshLayout.mo8682s(false);
        this.mRefreshLayout.mo8627a(new InterfaceC2884d() { // from class: ui.activity.z
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
            /* renamed from: a */
            public final void mo8732a(InterfaceC2876j interfaceC2876j) {
                IDVarfyAceptListActivity.this.m25256a(interfaceC2876j);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25256a(InterfaceC2876j interfaceC2876j) {
        this.mPresenter.getVerifyAcceptList();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("身份核实请求列表");
        this.mPresenter = new IDVarfyPresenter(this, this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new IDVarfyAceptListAdapter(this.callBeans);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        initListener();
        this.mRefreshLayout.mo8653e();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 39) {
            return;
        }
        this.mPresenter.getVerifyAcceptList();
    }

    @Override // p388ui.callview.IdVartyCallView
    public void onSuccessAccRequest(List<VerifyAcceptBean> list) {
        this.mRefreshLayout.mo8658g();
        if (list != null) {
            if (list.size() > 0) {
                this.mAdapter.m252a(list);
            } else {
                this.mAdapter.m250G();
            }
        }
        if (this.mAdapter.m5134c().size() > 0) {
            this.mLlNodata.setVisibility(8);
        } else {
            this.mLlNodata.setVisibility(0);
        }
    }

    @Override // p388ui.callview.IdVartyCallView
    public void onSuccessRequest(List<IDVarfyBean.Rows> list) {
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
        this.mAdapter.m250G();
        this.mLlNodata.setVisibility(0);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_idvarify_acept_list;
    }
}
