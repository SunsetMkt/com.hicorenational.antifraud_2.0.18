package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportCaseBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ReportRecordView;
import p388ui.presenter.ReportRecordPresenter;
import p388ui.view.swip.SwipBackLayout;

/* compiled from: ReportRecordsActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0011H\u0007J\u0012\u00103\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00105\u001a\u00020/H\u0016J\b\u00106\u001a\u000207H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00068"}, m23546d2 = {"Lui/activity/ReportRecordsActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportRecordView;", "()V", "caseBean", "Lbean/ReportCaseBean;", "getCaseBean", "()Lbean/ReportCaseBean;", "setCaseBean", "(Lbean/ReportCaseBean;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlNodata", "Landroid/view/View;", "getMLlNodata", "()Landroid/view/View;", "setMLlNodata", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/ReportRecordPresenter;", "getMPresenter", "()Lui/presenter/ReportRecordPresenter;", "setMPresenter", "(Lui/presenter/ReportRecordPresenter;)V", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "getMRvList", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "initView", "onClick", "view", "onSuccessRequest", "beans", "onfailRequest", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportRecordsActivity extends BaseActivity implements ReportRecordView {

    @InterfaceC5817e
    private ReportCaseBean caseBean;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_nodata)
    @InterfaceC5816d
    public View mLlNodata;

    @InterfaceC5817e
    private ReportRecordPresenter mPresenter;

    @BindView(C2113R.id.swipe_refresh)
    @InterfaceC5816d
    public SmartRefreshLayout mRefreshLayout;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRvList;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* compiled from: ReportRecordsActivity.kt */
    /* renamed from: ui.activity.ReportRecordsActivity$a */
    static final class C6520a implements InterfaceC2884d {
        C6520a() {
        }

        @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
        /* renamed from: a */
        public final void mo8732a(@InterfaceC5816d InterfaceC2876j interfaceC2876j) {
            C5544i0.m22546f(interfaceC2876j, "it");
            ReportRecordPresenter mPresenter = ReportRecordsActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.reportUserCases();
            }
        }
    }

    @InterfaceC5817e
    public final ReportCaseBean getCaseBean() {
        return this.caseBean;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final View getMLlNodata() {
        View view = this.mLlNodata;
        if (view == null) {
            C5544i0.m22554k("mLlNodata");
        }
        return view;
    }

    @InterfaceC5817e
    public final ReportRecordPresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final SmartRefreshLayout getMRefreshLayout() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        return smartRefreshLayout;
    }

    @InterfaceC5816d
    public final RecyclerView getMRvList() {
        RecyclerView recyclerView = this.mRvList;
        if (recyclerView == null) {
            C5544i0.m22554k("mRvList");
        }
        return recyclerView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("报案记录");
        initView();
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8653e();
    }

    public final void initView() {
        this.mPresenter = new ReportRecordPresenter(this.mActivity, this);
        ReportRecordPresenter reportRecordPresenter = this.mPresenter;
        if (reportRecordPresenter != null) {
            RecyclerView recyclerView = this.mRvList;
            if (recyclerView == null) {
                C5544i0.m22554k("mRvList");
            }
            reportRecordPresenter.initRecyclePeop(recyclerView);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8622a((InterfaceC2873g) new ClassicsHeader(this));
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout2.mo8620a((InterfaceC2872f) new ClassicsFooter(this));
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout3.mo8682s(false);
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout4.mo8627a((InterfaceC2884d) new C6520a());
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.callview.ReportRecordView
    public void onSuccessRequest(@InterfaceC5817e ReportCaseBean reportCaseBean) {
        this.caseBean = reportCaseBean;
        if (reportCaseBean != null && reportCaseBean.getTotal() > 0) {
            View view = this.mLlNodata;
            if (view == null) {
                C5544i0.m22554k("mLlNodata");
            }
            view.setVisibility(8);
        }
        ReportRecordPresenter reportRecordPresenter = this.mPresenter;
        if (reportRecordPresenter != null) {
            reportRecordPresenter.setListData(reportCaseBean != null ? reportCaseBean.getRows() : null);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8658g();
    }

    @Override // p388ui.callview.ReportRecordView
    public void onfailRequest() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8658g();
    }

    public final void setCaseBean(@InterfaceC5817e ReportCaseBean reportCaseBean) {
        this.caseBean = reportCaseBean;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_record;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlNodata(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlNodata = view;
    }

    public final void setMPresenter(@InterfaceC5817e ReportRecordPresenter reportRecordPresenter) {
        this.mPresenter = reportRecordPresenter;
    }

    public final void setMRefreshLayout(@InterfaceC5816d SmartRefreshLayout smartRefreshLayout) {
        C5544i0.m22546f(smartRefreshLayout, "<set-?>");
        this.mRefreshLayout = smartRefreshLayout;
    }

    public final void setMRvList(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRvList = recyclerView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
