package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.SignCommitCriminalView;
import p388ui.presenter.SignCommitCriminalPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignCommitCriminalActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020&J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0007J \u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/H\u0016J\b\u00100\u001a\u00020-H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00061"}, m23546d2 = {"Lui/activity/SignCommitCriminalActivity;", "Lui/activity/BaseActivity;", "Lui/callview/SignCommitCriminalView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAppBeans", "Ljava/util/ArrayList;", "Lbean/CriminalBean;", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/SignCommitCriminalPresenter;", "getMPresenter", "()Lui/presenter/SignCommitCriminalPresenter;", "setMPresenter", "(Lui/presenter/SignCommitCriminalPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onSuccessHandle", "type", "", "list", "", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCommitCriminalActivity extends BaseActivity implements SignCommitCriminalView {

    @InterfaceC5816d
    private String caseInfoId = "";
    private ArrayList<CriminalBean> mAppBeans = new ArrayList<>();

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private SignCommitCriminalPresenter mPresenter;

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
    public final SignCommitCriminalPresenter getMPresenter() {
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
        initView();
        SignCommitCriminalPresenter signCommitCriminalPresenter = this.mPresenter;
        if (signCommitCriminalPresenter != null) {
            signCommitCriminalPresenter.getCriminalList(this.caseInfoId);
        }
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("嫌疑人");
        this.mPresenter = new SignCommitCriminalPresenter(this.mActivity, this.caseInfoId, this);
        SignCommitCriminalPresenter signCommitCriminalPresenter = this.mPresenter;
        if (signCommitCriminalPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecycleView");
            }
            signCommitCriminalPresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.callview.SignCommitCriminalView
    public void onSuccessHandle(int i2, @InterfaceC5817e List<CriminalBean> list) {
        if (i2 == 1) {
            ArrayList<CriminalBean> arrayList = this.mAppBeans;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<CriminalBean> arrayList2 = this.mAppBeans;
            if (arrayList2 != null) {
                if (list == null) {
                    C5544i0.m22545f();
                }
                arrayList2.addAll(list);
            }
            SignCommitCriminalPresenter signCommitCriminalPresenter = this.mPresenter;
            if (signCommitCriminalPresenter != null) {
                signCommitCriminalPresenter.setListData(this.mAppBeans);
            }
        }
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_sign_commit_criminal;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e SignCommitCriminalPresenter signCommitCriminalPresenter) {
        this.mPresenter = signCommitCriminalPresenter;
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
