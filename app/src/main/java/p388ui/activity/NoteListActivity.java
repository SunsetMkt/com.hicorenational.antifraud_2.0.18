package p388ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.NoteListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.NoteListView;
import p388ui.presenter.NoteListPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;

/* compiled from: NoteListActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020)H\u0007J\u0016\u00103\u001a\u00020/2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0016J\b\u00107\u001a\u000208H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00069"}, m23546d2 = {"Lui/activity/NoteListActivity;", "Lui/activity/BaseActivity;", "Lui/callview/NoteListView;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mNoImg", "getMNoImg", "setMNoImg", "mNoTxt", "Landroid/widget/TextView;", "getMNoTxt", "()Landroid/widget/TextView;", "setMNoTxt", "(Landroid/widget/TextView;)V", "mPresenter", "Lui/presenter/NoteListPresenter;", "getMPresenter", "()Lui/presenter/NoteListPresenter;", "setMPresenter", "(Lui/presenter/NoteListPresenter;)V", "mRecycle", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycle", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycle", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "noDateView", "Landroid/view/View;", "getNoDateView", "()Landroid/view/View;", "setNoDateView", "(Landroid/view/View;)V", "initPage", "", "initView", "onClick", "view", "onSuccessRequest", "beans", "", "Lbean/NoteListBean;", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class NoteListActivity extends BaseActivity implements NoteListView {

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.iv_img)
    @InterfaceC5816d
    public ImageView mNoImg;

    @BindView(C2113R.id.tv_tip)
    @InterfaceC5816d
    public TextView mNoTxt;

    @InterfaceC5817e
    private NoteListPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecycle;

    @BindView(C2113R.id.swipe_refresh)
    @InterfaceC5816d
    public SmartRefreshLayout mRefreshLayout;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @BindView(C2113R.id.cl_no_data)
    @InterfaceC5816d
    public View noDateView;

    /* compiled from: NoteListActivity.kt */
    /* renamed from: ui.activity.NoteListActivity$a */
    static final class C6397a implements InterfaceC2884d {
        C6397a() {
        }

        @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
        /* renamed from: a */
        public final void mo8732a(@InterfaceC5816d InterfaceC2876j interfaceC2876j) {
            C5544i0.m22546f(interfaceC2876j, "refreshLayout");
            NoteListPresenter mPresenter = NoteListActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.getNoteList();
            }
        }
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
    public final ImageView getMNoImg() {
        ImageView imageView = this.mNoImg;
        if (imageView == null) {
            C5544i0.m22554k("mNoImg");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final TextView getMNoTxt() {
        TextView textView = this.mNoTxt;
        if (textView == null) {
            C5544i0.m22554k("mNoTxt");
        }
        return textView;
    }

    @InterfaceC5817e
    public final NoteListPresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final RecyclerView getMRecycle() {
        RecyclerView recyclerView = this.mRecycle;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecycle");
        }
        return recyclerView;
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
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5816d
    public final View getNoDateView() {
        View view = this.noDateView;
        if (view == null) {
            C5544i0.m22554k("noDateView");
        }
        return view;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        textView.setText("公告");
        initView();
    }

    public final void initView() {
        ImageView imageView = this.mNoImg;
        if (imageView == null) {
            C5544i0.m22554k("mNoImg");
        }
        imageView.setImageResource(C2113R.drawable.iv_no_feed_list);
        TextView textView = this.mNoTxt;
        if (textView == null) {
            C5544i0.m22554k("mNoTxt");
        }
        textView.setText("暂无数据");
        this.mPresenter = new NoteListPresenter(this.mActivity, this);
        NoteListPresenter noteListPresenter = this.mPresenter;
        if (noteListPresenter != null) {
            RecyclerView recyclerView = this.mRecycle;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecycle");
            }
            noteListPresenter.initRecycleWeb(recyclerView);
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
        smartRefreshLayout2.mo8682s(false);
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout3.mo8627a((InterfaceC2884d) new C6397a());
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout4.mo8653e();
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            m8092a();
        }
    }

    @Override // p388ui.callview.NoteListView
    public void onSuccessRequest(@InterfaceC5816d List<? extends NoteListBean> list) {
        C5544i0.m22546f(list, "beans");
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8658g();
        if (!(!list.isEmpty())) {
            View view = this.noDateView;
            if (view == null) {
                C5544i0.m22554k("noDateView");
            }
            view.setVisibility(0);
            return;
        }
        NoteListPresenter noteListPresenter = this.mPresenter;
        if (noteListPresenter != null) {
            noteListPresenter.setListData(list);
        }
        View view2 = this.noDateView;
        if (view2 == null) {
            C5544i0.m22554k("noDateView");
        }
        view2.setVisibility(8);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_note_list;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMNoImg(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mNoImg = imageView;
    }

    public final void setMNoTxt(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mNoTxt = textView;
    }

    public final void setMPresenter(@InterfaceC5817e NoteListPresenter noteListPresenter) {
        this.mPresenter = noteListPresenter;
    }

    public final void setMRecycle(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecycle = recyclerView;
    }

    public final void setMRefreshLayout(@InterfaceC5816d SmartRefreshLayout smartRefreshLayout) {
        C5544i0.m22546f(smartRefreshLayout, "<set-?>");
        this.mRefreshLayout = smartRefreshLayout;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setNoDateView(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.noDateView = view;
    }
}
