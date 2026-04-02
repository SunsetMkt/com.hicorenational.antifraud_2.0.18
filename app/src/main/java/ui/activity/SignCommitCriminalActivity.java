package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.callview.SignCommitCriminalView;
import ui.presenter.SignCommitCriminalPresenter;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: SignCommitCriminalActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020&J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0007J \u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/H\u0016J\b\u00100\u001a\u00020-H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00061"}, d2 = {"Lui/activity/SignCommitCriminalActivity;", "Lui/activity/BaseActivity;", "Lui/callview/SignCommitCriminalView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAppBeans", "Ljava/util/ArrayList;", "Lbean/CriminalBean;", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/SignCommitCriminalPresenter;", "getMPresenter", "()Lui/presenter/SignCommitCriminalPresenter;", "setMPresenter", "(Lui/presenter/SignCommitCriminalPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onSuccessHandle", "type", "", "list", "", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class SignCommitCriminalActivity extends BaseActivity implements SignCommitCriminalView {

    @j.c.a.d
    private String caseInfoId = "";
    private ArrayList<CriminalBean> mAppBeans = new ArrayList<>();

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @j.c.a.e
    private SignCommitCriminalPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecycleView;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.e
    public final SignCommitCriminalPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final RecyclerView getMRecycleView() {
        RecyclerView recyclerView = this.mRecycleView;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecycleView");
        }
        return recyclerView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        initView();
        SignCommitCriminalPresenter signCommitCriminalPresenter = this.mPresenter;
        if (signCommitCriminalPresenter != null) {
            signCommitCriminalPresenter.getCriminalList(this.caseInfoId);
        }
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u5acc\u7591\u4eba");
        this.mPresenter = new SignCommitCriminalPresenter(this.mActivity, this.caseInfoId, this);
        SignCommitCriminalPresenter signCommitCriminalPresenter = this.mPresenter;
        if (signCommitCriminalPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                i.q2.t.i0.k("mRecycleView");
            }
            signCommitCriminalPresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.callview.SignCommitCriminalView
    public void onSuccessHandle(int i2, @j.c.a.e List<CriminalBean> list) {
        if (i2 == 1) {
            ArrayList<CriminalBean> arrayList = this.mAppBeans;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<CriminalBean> arrayList2 = this.mAppBeans;
            if (arrayList2 != null) {
                if (list == null) {
                    i.q2.t.i0.f();
                }
                arrayList2.addAll(list);
            }
            SignCommitCriminalPresenter signCommitCriminalPresenter = this.mPresenter;
            if (signCommitCriminalPresenter != null) {
                signCommitCriminalPresenter.setListData(this.mAppBeans);
            }
        }
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sign_commit_criminal;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e SignCommitCriminalPresenter signCommitCriminalPresenter) {
        this.mPresenter = signCommitCriminalPresenter;
    }

    public final void setMRecycleView(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
