package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ReportWebView;
import p388ui.presenter.ReportWebsitePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* compiled from: ReportWebsiteActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00108\u001a\u000209H\u0016J\u0006\u0010:\u001a\u000209J\u0010\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020\u0017H\u0007J\b\u0010=\u001a\u000209H\u0014J\u0010\u0010>\u001a\u0002092\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010?\u001a\u000209H\u0014J \u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\u000b2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016J\b\u0010C\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104¨\u0006D"}, m23546d2 = {"Lui/activity/ReportWebsiteActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportWebView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlAddLayout", "Landroid/view/View;", "getMLlAddLayout", "()Landroid/view/View;", "setMLlAddLayout", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/ReportWebsitePresenter;", "getMPresenter", "()Lui/presenter/ReportWebsitePresenter;", "setMPresenter", "(Lui/presenter/ReportWebsitePresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mReportWebBeans", "", "Lbean/ReportWebsitBean;", "getMReportWebBeans", "()Ljava/util/List;", "setMReportWebBeans", "(Ljava/util/List;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "onDestroy", "onItemDelet", "onResume", "onSuccessHandle", "type", "list", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportWebsiteActivity extends BaseActivity implements ReportWebView {
    private int itemPos;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_add)
    @InterfaceC5816d
    public View mLlAddLayout;

    @InterfaceC5817e
    private ReportWebsitePresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecycleView;

    @BindView(C2113R.id.tv_add)
    @InterfaceC5816d
    public TextView mTvAdd;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5816d
    private List<ReportWebsitBean> mReportWebBeans = new ArrayList();

    @InterfaceC5816d
    private String caseInfoId = "";

    /* compiled from: ReportWebsiteActivity.kt */
    /* renamed from: ui.activity.ReportWebsiteActivity$a */
    public static final class C6539a implements IClickListener {

        /* renamed from: b */
        final /* synthetic */ int f22983b;

        C6539a(int i2) {
            this.f22983b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportWebsitePresenter mPresenter = ReportWebsiteActivity.this.getMPresenter();
            if (mPresenter != null) {
                String caseInfoId = ReportWebsiteActivity.this.getCaseInfoId();
                List<ReportWebsitBean> mReportWebBeans = ReportWebsiteActivity.this.getMReportWebBeans();
                mPresenter.deleteCaseWebUrl(caseInfoId, (mReportWebBeans != null ? mReportWebBeans.get(this.f22983b) : null).getUrlInfoID());
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getItemPos() {
        return this.itemPos;
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
    public final View getMLlAddLayout() {
        View view = this.mLlAddLayout;
        if (view == null) {
            C5544i0.m22554k("mLlAddLayout");
        }
        return view;
    }

    @InterfaceC5817e
    public final ReportWebsitePresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final RecyclerView getMRecycleView() {
        RecyclerView recyclerView = this.mRecycleView;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecycleView");
        }
        return recyclerView;
    }

    @InterfaceC5816d
    public final List<ReportWebsitBean> getMReportWebBeans() {
        return this.mReportWebBeans;
    }

    @InterfaceC5816d
    public final TextView getMTvAdd() {
        TextView textView = this.mTvAdd;
        if (textView == null) {
            C5544i0.m22554k("mTvAdd");
        }
        return textView;
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
        TextView textView = this.mTvAdd;
        if (textView == null) {
            C5544i0.m22554k("mTvAdd");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("添加涉诈网址");
        TextView textView2 = this.mTvTitle;
        if (textView2 == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setText("添加涉诈网址");
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new ReportWebsitePresenter(this.mActivity, this.caseInfoId, this);
        ReportWebsitePresenter reportWebsitePresenter = this.mPresenter;
        if (reportWebsitePresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecycleView");
            }
            reportWebsitePresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_add})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != C2113R.id.ll_add) {
                return;
            }
            Intent intent = new Intent(this.mActivity, (Class<?>) ReportWebsiteAddActivity.class);
            intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
            startActivity(intent);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // p388ui.callview.ReportWebView
    public void onItemDelet(int i2) {
        this.itemPos = i2;
        C7257b1.m26211b(this.mActivity, "删除当前网址信息？", "", "确定", "取消", new C6539a(i2));
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ReportWebsitePresenter reportWebsitePresenter = this.mPresenter;
        if (reportWebsitePresenter != null) {
            reportWebsitePresenter.getSurveyWebList(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.ReportWebView
    public void onSuccessHandle(int i2, @InterfaceC5817e List<ReportWebsitBean> list) {
        if (i2 != 1) {
            if (i2 == 4) {
                C7331w1.m26688a("删除成功");
                this.mReportWebBeans.remove(this.itemPos);
                ReportWebsitePresenter reportWebsitePresenter = this.mPresenter;
                if (reportWebsitePresenter != null) {
                    reportWebsitePresenter.setListData(this.mReportWebBeans);
                    return;
                }
                return;
            }
            return;
        }
        List<ReportWebsitBean> list2 = this.mReportWebBeans;
        if (list2 != null) {
            list2.clear();
        }
        List<ReportWebsitBean> list3 = this.mReportWebBeans;
        if (list3 != null) {
            if (list == null) {
                C5544i0.m22545f();
            }
            list3.addAll(list);
        }
        ReportWebsitePresenter reportWebsitePresenter2 = this.mPresenter;
        if (reportWebsitePresenter2 != null) {
            reportWebsitePresenter2.setListData(this.mReportWebBeans);
        }
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setItemPos(int i2) {
        this.itemPos = i2;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_weburl_list;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddLayout(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlAddLayout = view;
    }

    public final void setMPresenter(@InterfaceC5817e ReportWebsitePresenter reportWebsitePresenter) {
        this.mPresenter = reportWebsitePresenter;
    }

    public final void setMRecycleView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMReportWebBeans(@InterfaceC5816d List<ReportWebsitBean> list) {
        C5544i0.m22546f(list, "<set-?>");
        this.mReportWebBeans = list;
    }

    public final void setMTvAdd(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
