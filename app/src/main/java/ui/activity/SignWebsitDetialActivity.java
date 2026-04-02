package ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import ui.presenter.GridViewPicPresenter;
import ui.view.swip.SwipBackLayout;
import util.g2;

/* JADX INFO: compiled from: SignWebsitDetialActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020+J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\nH\u0007J\b\u0010/\u001a\u000200H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u00061"}, d2 = {"Lui/activity/SignWebsitDetialActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlPic", "Landroid/view/View;", "getMLlPic", "()Landroid/view/View;", "setMLlPic", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/GridViewPicPresenter;", "getMPresenter", "()Lui/presenter/GridViewPicPresenter;", "setMPresenter", "(Lui/presenter/GridViewPicPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvWebUrl", "getMTvWebUrl", "setMTvWebUrl", "mWebBean", "Lbean/ReportWebsitBean;", "getMWebBean", "()Lbean/ReportWebsitBean;", "setMWebBean", "(Lbean/ReportWebsitBean;)V", "initPage", "", "initView", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class SignWebsitDetialActivity extends BaseActivity {

    @j.c.a.e
    private GridViewPicPresenter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.e
    private ReportWebsitBean f13832b;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_pic)
    @j.c.a.d
    public View mLlPic;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecyView;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.tv_weburl)
    @j.c.a.d
    public TextView mTvWebUrl;

    public final void a(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvWebUrl = textView;
    }

    @j.c.a.d
    public final TextView b() {
        TextView textView = this.mTvWebUrl;
        if (textView == null) {
            i.q2.t.i0.k("mTvWebUrl");
        }
        return textView;
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
    public final GridViewPicPresenter getMPresenter() {
        return this.a;
    }

    @j.c.a.d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecyView");
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

    @j.c.a.e
    public final ReportWebsitBean getMWebBean() {
        return this.f13832b;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u7f51\u5740\u4fe1\u606f");
        initView();
    }

    public final void initView() {
        this.f13832b = (ReportWebsitBean) getIntent().getSerializableExtra(util.p1.f15011c);
        this.a = new GridViewPicPresenter(this.mActivity);
        GridViewPicPresenter gridViewPicPresenter = this.a;
        if (gridViewPicPresenter != null) {
            RecyclerView recyclerView = this.mRecyView;
            if (recyclerView == null) {
                i.q2.t.i0.k("mRecyView");
            }
            gridViewPicPresenter.initRecycleWeb(recyclerView);
        }
        ReportWebsitBean reportWebsitBean = this.f13832b;
        if (reportWebsitBean != null) {
            if (!TextUtils.isEmpty(reportWebsitBean != null ? reportWebsitBean.getUrl() : null)) {
                TextView textView = this.mTvWebUrl;
                if (textView == null) {
                    i.q2.t.i0.k("mTvWebUrl");
                }
                ReportWebsitBean reportWebsitBean2 = this.f13832b;
                textView.setText(reportWebsitBean2 != null ? reportWebsitBean2.getUrl() : null);
            }
            ReportWebsitBean reportWebsitBean3 = this.f13832b;
            ArrayList<UploadFileBean> urlDetails = reportWebsitBean3 != null ? reportWebsitBean3.getUrlDetails() : null;
            if (urlDetails == null || urlDetails.size() <= 0) {
                View view = this.mLlPic;
                if (view == null) {
                    i.q2.t.i0.k("mLlPic");
                }
                view.setVisibility(8);
                return;
            }
            GridViewPicPresenter gridViewPicPresenter2 = this.a;
            if (gridViewPicPresenter2 != null) {
                gridViewPicPresenter2.setListData(urlDetails);
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_websit_copy})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.tv_websit_copy) {
                return;
            }
            TextView textView = this.mTvWebUrl;
            if (textView == null) {
                i.q2.t.i0.k("mTvWebUrl");
            }
            g2.s(textView.getText().toString());
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sign_weburl_detial;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlPic(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlPic = view;
    }

    public final void setMRecyView(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMWebBean(@j.c.a.e ReportWebsitBean reportWebsitBean) {
        this.f13832b = reportWebsitBean;
    }

    @j.c.a.d
    public final View a() {
        View view = this.mLlPic;
        if (view == null) {
            i.q2.t.i0.k("mLlPic");
        }
        return view;
    }

    public final void a(@j.c.a.e GridViewPicPresenter gridViewPicPresenter) {
        this.a = gridViewPicPresenter;
    }
}
