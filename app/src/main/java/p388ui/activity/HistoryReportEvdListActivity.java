package p388ui.activity;

import adapter.HistoryReportEvdAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2882b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import java.util.List;
import network.HistoryListInfo;
import p388ui.callview.HistoryReportEvdCallView;
import p388ui.presenter.HistoryReportEvdPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;

/* loaded from: classes2.dex */
public class HistoryReportEvdListActivity extends BaseActivity implements HistoryReportEvdCallView, HistoryReportEvdAdapter.InterfaceC0065b {
    private HistoryReportEvdAdapter mAdapter;

    @BindView(C2113R.id.iv_right)
    ImageView mIvRight;
    private HistoryReportEvdPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.swipe_refresh)
    SmartRefreshLayout mRefreshLayout;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private List<HistoryListInfo.RowsBean> mList = new ArrayList();
    boolean isLoadmore = false;
    public int pageIndex = 1;
    public int pageSize = 10;

    private void initListener() {
        this.mRefreshLayout.mo8622a((InterfaceC2873g) new ClassicsHeader(this));
        this.mRefreshLayout.mo8620a((InterfaceC2872f) new ClassicsFooter(this));
        this.mRefreshLayout.mo8627a(new InterfaceC2884d() { // from class: ui.activity.x
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
            /* renamed from: a */
            public final void mo8732a(InterfaceC2876j interfaceC2876j) {
                HistoryReportEvdListActivity.this.m25254a(interfaceC2876j);
            }
        });
        this.mRefreshLayout.mo8625a(new InterfaceC2882b() { // from class: ui.activity.w
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2882b
            /* renamed from: b */
            public final void mo8723b(InterfaceC2876j interfaceC2876j) {
                HistoryReportEvdListActivity.this.m25255b(interfaceC2876j);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25254a(InterfaceC2876j interfaceC2876j) {
        pullToRefresh();
    }

    /* renamed from: b */
    public /* synthetic */ void m25255b(InterfaceC2876j interfaceC2876j) {
        pullToLoadMore();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("举报记录");
        this.mIvRight.setBackgroundResource(C2113R.mipmap.ic_help_blue);
        this.mPresenter = new HistoryReportEvdPresenter(this, this);
        initListener();
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new HistoryReportEvdAdapter(this.mList);
        this.mAdapter.setOnItemClickListener(this);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mRefreshLayout.mo8653e();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.mo8658g();
            this.mRefreshLayout.mo8637b();
        }
    }

    @Override // adapter.HistoryReportEvdAdapter.InterfaceC0065b
    public void onItemClickListener(HistoryListInfo.RowsBean rowsBean) {
        Intent intent = new Intent(this.mActivity, (Class<?>) HistoryDetailActivity.class);
        intent.putExtra(C7292k1.f25335B, rowsBean);
        startActivity(intent);
    }

    @Override // p388ui.callview.HistoryReportEvdCallView
    public void onSuccessRequest(HistoryListInfo historyListInfo) {
        this.mRefreshLayout.mo8658g();
        this.mRefreshLayout.mo8637b();
        if (historyListInfo != null) {
            List<HistoryListInfo.RowsBean> rows = historyListInfo.getRows();
            if (rows != null && rows.size() > 0) {
                if (this.isLoadmore) {
                    this.mAdapter.m5134c().addAll(rows);
                    this.mAdapter.notifyDataSetChanged();
                } else {
                    this.mAdapter.m244a(rows);
                    this.mRefreshLayout.mo8682s(true);
                }
                if (rows.size() < this.pageSize || rows.size() > this.pageSize) {
                    this.mRefreshLayout.mo8682s(false);
                } else {
                    this.mRefreshLayout.mo8682s(true);
                }
            } else if (this.isLoadmore) {
                this.mRefreshLayout.mo8682s(false);
            }
        }
        this.isLoadmore = false;
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_right})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
        } else {
            if (id != C2113R.id.iv_right) {
                return;
            }
            C7257b1.m26172a(this, 0, "110", getString(C2113R.string.report_time_tips), "", "我知道了", (IOneClickListener) null);
        }
    }

    @Override // p388ui.callview.HistoryReportEvdCallView
    public void onfailRequest() {
        this.isLoadmore = false;
        this.mRefreshLayout.mo8658g();
        this.mRefreshLayout.mo8637b();
    }

    public void pullToLoadMore() {
        if (this.mRefreshLayout == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmore = true;
        int size = this.mList.size();
        int i2 = this.pageSize;
        this.pageIndex = (size / i2) + 1;
        this.mPresenter.getReportList(this.pageIndex, i2);
    }

    public void pullToRefresh() {
        HistoryReportEvdPresenter historyReportEvdPresenter;
        if (this.mRefreshLayout == null || (historyReportEvdPresenter = this.mPresenter) == null) {
            return;
        }
        this.pageIndex = 1;
        this.isLoadmore = false;
        historyReportEvdPresenter.getReportList(this.pageIndex, this.pageSize);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_history_report;
    }
}
