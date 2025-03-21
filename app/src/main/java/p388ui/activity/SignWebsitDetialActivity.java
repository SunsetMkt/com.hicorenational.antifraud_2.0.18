package p388ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.presenter.GridViewPicPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7337y1;

/* compiled from: SignWebsitDetialActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020+J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\nH\u0007J\b\u0010/\u001a\u000200H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00061"}, m23546d2 = {"Lui/activity/SignWebsitDetialActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlPic", "Landroid/view/View;", "getMLlPic", "()Landroid/view/View;", "setMLlPic", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/GridViewPicPresenter;", "getMPresenter", "()Lui/presenter/GridViewPicPresenter;", "setMPresenter", "(Lui/presenter/GridViewPicPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvWebUrl", "getMTvWebUrl", "setMTvWebUrl", "mWebBean", "Lbean/ReportWebsitBean;", "getMWebBean", "()Lbean/ReportWebsitBean;", "setMWebBean", "(Lbean/ReportWebsitBean;)V", "initPage", "", "initView", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignWebsitDetialActivity extends BaseActivity {

    /* renamed from: a */
    @InterfaceC5817e
    private GridViewPicPresenter f23157a;

    /* renamed from: b */
    @InterfaceC5817e
    private ReportWebsitBean f23158b;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_pic)
    @InterfaceC5816d
    public View mLlPic;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyView;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @BindView(C2113R.id.tv_weburl)
    @InterfaceC5816d
    public TextView mTvWebUrl;

    /* renamed from: a */
    public final void m25358a(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvWebUrl = textView;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final TextView m25360b() {
        TextView textView = this.mTvWebUrl;
        if (textView == null) {
            C5544i0.m22554k("mTvWebUrl");
        }
        return textView;
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
    public final GridViewPicPresenter getMPresenter() {
        return this.f23157a;
    }

    @InterfaceC5816d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyView");
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

    @InterfaceC5817e
    public final ReportWebsitBean getMWebBean() {
        return this.f23158b;
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
        textView.setText("网址信息");
        initView();
    }

    public final void initView() {
        this.f23158b = (ReportWebsitBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.f23157a = new GridViewPicPresenter(this.mActivity);
        GridViewPicPresenter gridViewPicPresenter = this.f23157a;
        if (gridViewPicPresenter != null) {
            RecyclerView recyclerView = this.mRecyView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecyView");
            }
            gridViewPicPresenter.initRecycleWeb(recyclerView);
        }
        ReportWebsitBean reportWebsitBean = this.f23158b;
        if (reportWebsitBean != null) {
            if (!TextUtils.isEmpty(reportWebsitBean != null ? reportWebsitBean.getUrl() : null)) {
                TextView textView = this.mTvWebUrl;
                if (textView == null) {
                    C5544i0.m22554k("mTvWebUrl");
                }
                ReportWebsitBean reportWebsitBean2 = this.f23158b;
                textView.setText(reportWebsitBean2 != null ? reportWebsitBean2.getUrl() : null);
            }
            ReportWebsitBean reportWebsitBean3 = this.f23158b;
            ArrayList<UploadFileBean> urlDetails = reportWebsitBean3 != null ? reportWebsitBean3.getUrlDetails() : null;
            if (urlDetails == null || urlDetails.size() <= 0) {
                View view = this.mLlPic;
                if (view == null) {
                    C5544i0.m22554k("mLlPic");
                }
                view.setVisibility(8);
                return;
            }
            GridViewPicPresenter gridViewPicPresenter2 = this.f23157a;
            if (gridViewPicPresenter2 != null) {
                gridViewPicPresenter2.setListData(urlDetails);
            }
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_websit_copy})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != C2113R.id.tv_websit_copy) {
                return;
            }
            TextView textView = this.mTvWebUrl;
            if (textView == null) {
                C5544i0.m22554k("mTvWebUrl");
            }
            C7337y1.m26794s(textView.getText().toString());
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_sign_weburl_detial;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlPic(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlPic = view;
    }

    public final void setMRecyView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMWebBean(@InterfaceC5817e ReportWebsitBean reportWebsitBean) {
        this.f23158b = reportWebsitBean;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final View m25357a() {
        View view = this.mLlPic;
        if (view == null) {
            C5544i0.m22554k("mLlPic");
        }
        return view;
    }

    /* renamed from: a */
    public final void m25359a(@InterfaceC5817e GridViewPicPresenter gridViewPicPresenter) {
        this.f23157a = gridViewPicPresenter;
    }
}
