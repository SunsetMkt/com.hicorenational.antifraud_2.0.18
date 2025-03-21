package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReplyBean;
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
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5539g1;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ReportRecordsReplyCallview;
import p388ui.presenter.ReportRecordsReplyPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: ReportRecordsReplyActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020*J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u0010/\u001a\u00020*2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u00101\u001a\u00020*H\u0016J\b\u00102\u001a\u000203H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00064"}, m23546d2 = {"Lui/activity/ReportRecordsReplyActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportRecordsReplyCallview;", "()V", "mData", "", "Lbean/ReplyBean;", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/ReportRecordsReplyPresenter;", "getMPresenter", "()Lui/presenter/ReportRecordsReplyPresenter;", "setMPresenter", "(Lui/presenter/ReportRecordsReplyPresenter;)V", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "getMRvList", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onSuccessRequest", "result", "onfailRequest", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportRecordsReplyActivity extends BaseActivity implements ReportRecordsReplyCallview {

    @InterfaceC5817e
    private List<ReplyBean> mData;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private ReportRecordsReplyPresenter mPresenter;

    @BindView(C2113R.id.swipe_refresh)
    @InterfaceC5816d
    public SmartRefreshLayout mRefreshLayout;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRvList;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* compiled from: ReportRecordsReplyActivity.kt */
    /* renamed from: ui.activity.ReportRecordsReplyActivity$a */
    static final class C6522a implements InterfaceC2884d {

        /* renamed from: b */
        final /* synthetic */ C5539g1.h f22932b;

        C6522a(C5539g1.h hVar) {
            this.f22932b = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
        /* renamed from: a */
        public final void mo8732a(@InterfaceC5816d InterfaceC2876j interfaceC2876j) {
            C5544i0.m22546f(interfaceC2876j, "it");
            ReportRecordsReplyPresenter mPresenter = ReportRecordsReplyActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.getReply((String) this.f22932b.element);
            }
        }
    }

    @InterfaceC5817e
    public final List<ReplyBean> getMData() {
        return this.mData;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5817e
    public final ReportRecordsReplyPresenter getMPresenter() {
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
        textView.setText("报案反馈");
        initView();
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8653e();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    public final void initView() {
        this.mPresenter = new ReportRecordsReplyPresenter(this.mActivity, this);
        ReportRecordsReplyPresenter reportRecordsReplyPresenter = this.mPresenter;
        if (reportRecordsReplyPresenter != null) {
            RecyclerView recyclerView = this.mRvList;
            if (recyclerView == null) {
                C5544i0.m22554k("mRvList");
            }
            reportRecordsReplyPresenter.initRecyclePeop(recyclerView);
        }
        C5539g1.h hVar = new C5539g1.h();
        hVar.element = getIntent().getStringExtra(C7292k1.f25338C0);
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
        smartRefreshLayout4.mo8627a((InterfaceC2884d) new C6522a(hVar));
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            m8092a();
        }
    }

    @Override // p388ui.callview.ReportRecordsReplyCallview
    public void onSuccessRequest(@InterfaceC5817e List<ReplyBean> list) {
        this.mData = list;
        ReportRecordsReplyPresenter reportRecordsReplyPresenter = this.mPresenter;
        if (reportRecordsReplyPresenter != null) {
            reportRecordsReplyPresenter.setListData(list);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8658g();
    }

    @Override // p388ui.callview.ReportRecordsReplyCallview
    public void onfailRequest() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8658g();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_records_reply;
    }

    public final void setMData(@InterfaceC5817e List<ReplyBean> list) {
        this.mData = list;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e ReportRecordsReplyPresenter reportRecordsReplyPresenter) {
        this.mPresenter = reportRecordsReplyPresenter;
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
