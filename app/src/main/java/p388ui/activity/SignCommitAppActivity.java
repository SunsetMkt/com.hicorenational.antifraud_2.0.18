package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.SurveyAppBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p286h.C5190a0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ReportAppView;
import p388ui.presenter.SignCommitAppPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignCommitAppActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020&J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0007J\b\u0010+\u001a\u00020&H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.H\u0016J \u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020.2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u000102H\u0016J\b\u00103\u001a\u00020.H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00064"}, m23546d2 = {"Lui/activity/SignCommitAppActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportAppView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAppBeans", "Ljava/util/ArrayList;", "Lbean/SurveyAppBean;", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/SignCommitAppPresenter;", "getMPresenter", "()Lui/presenter/SignCommitAppPresenter;", "setMPresenter", "(Lui/presenter/SignCommitAppPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onFailRequest", "onItemDelet", "itemPos", "", "onSuccessHandle", "type", "list", "", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCommitAppActivity extends BaseActivity implements ReportAppView {

    @InterfaceC5816d
    private String caseInfoId = "";
    private ArrayList<SurveyAppBean> mAppBeans = new ArrayList<>();

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private SignCommitAppPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecycleView;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
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
    public final SignCommitAppPresenter getMPresenter() {
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
        textView.setText("诈骗APP");
        initView();
        SignCommitAppPresenter signCommitAppPresenter = this.mPresenter;
        if (signCommitAppPresenter != null) {
            signCommitAppPresenter.getReportAppList(this.caseInfoId);
        }
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new SignCommitAppPresenter(this.mActivity, this.caseInfoId, this);
        SignCommitAppPresenter signCommitAppPresenter = this.mPresenter;
        if (signCommitAppPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecycleView");
            }
            signCommitAppPresenter.initRecycleWeb(recyclerView);
        }
        SignCommitAppPresenter signCommitAppPresenter2 = this.mPresenter;
        if (signCommitAppPresenter2 != null) {
            signCommitAppPresenter2.setListData(this.mAppBeans);
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.callview.ReportAppView
    public void onFailRequest() {
        throw new C5190a0("An operation is not implemented: not implemented");
    }

    @Override // p388ui.callview.ReportAppView
    public void onItemDelet(int i2) {
        throw new C5190a0("An operation is not implemented: not implemented");
    }

    @Override // p388ui.callview.ReportAppView
    public void onSuccessHandle(int i2, @InterfaceC5817e List<SurveyAppBean> list) {
        if (i2 == 1) {
            ArrayList<SurveyAppBean> arrayList = this.mAppBeans;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<SurveyAppBean> arrayList2 = this.mAppBeans;
            if (arrayList2 != null) {
                if (list == null) {
                    C5544i0.m22545f();
                }
                arrayList2.addAll(list);
            }
            SignCommitAppPresenter signCommitAppPresenter = this.mPresenter;
            if (signCommitAppPresenter != null) {
                signCommitAppPresenter.setListData(this.mAppBeans);
            }
        }
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_sign_commit_apps;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e SignCommitAppPresenter signCommitAppPresenter) {
        this.mPresenter = signCommitAppPresenter;
    }

    public final void setMRecycleView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
