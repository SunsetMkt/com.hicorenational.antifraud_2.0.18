package ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.NoteListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import java.util.List;
import ui.callview.NoteListView;
import ui.presenter.NoteListPresenter;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: NoteListActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020)H\u0007J\u0016\u00103\u001a\u00020/2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0016J\b\u00107\u001a\u000208H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00069"}, d2 = {"Lui/activity/NoteListActivity;", "Lui/activity/BaseActivity;", "Lui/callview/NoteListView;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mNoImg", "getMNoImg", "setMNoImg", "mNoTxt", "Landroid/widget/TextView;", "getMNoTxt", "()Landroid/widget/TextView;", "setMNoTxt", "(Landroid/widget/TextView;)V", "mPresenter", "Lui/presenter/NoteListPresenter;", "getMPresenter", "()Lui/presenter/NoteListPresenter;", "setMPresenter", "(Lui/presenter/NoteListPresenter;)V", "mRecycle", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycle", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycle", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "noDateView", "Landroid/view/View;", "getNoDateView", "()Landroid/view/View;", "setNoDateView", "(Landroid/view/View;)V", "initPage", "", "initView", "onClick", "view", "onSuccessRequest", "beans", "", "Lbean/NoteListBean;", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class NoteListActivity extends BaseActivity implements NoteListView {

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.iv_img)
    @j.c.a.d
    public ImageView mNoImg;

    @BindView(R.id.tv_tip)
    @j.c.a.d
    public TextView mNoTxt;

    @j.c.a.e
    private NoteListPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecycle;

    @BindView(R.id.swipe_refresh)
    @j.c.a.d
    public SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.cl_no_data)
    @j.c.a.d
    public View noDateView;

    /* JADX INFO: compiled from: NoteListActivity.kt */
    static final class a implements com.scwang.smartrefresh.layout.d.d {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.d
        public final void a(@j.c.a.d com.scwang.smartrefresh.layout.b.j jVar) {
            i.q2.t.i0.f(jVar, "refreshLayout");
            NoteListPresenter mPresenter = NoteListActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.getNoteList();
            }
        }
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMNoImg() {
        ImageView imageView = this.mNoImg;
        if (imageView == null) {
            i.q2.t.i0.k("mNoImg");
        }
        return imageView;
    }

    @j.c.a.d
    public final TextView getMNoTxt() {
        TextView textView = this.mNoTxt;
        if (textView == null) {
            i.q2.t.i0.k("mNoTxt");
        }
        return textView;
    }

    @j.c.a.e
    public final NoteListPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final RecyclerView getMRecycle() {
        RecyclerView recyclerView = this.mRecycle;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecycle");
        }
        return recyclerView;
    }

    @j.c.a.d
    public final SmartRefreshLayout getMRefreshLayout() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            i.q2.t.i0.k("mRefreshLayout");
        }
        return smartRefreshLayout;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @j.c.a.d
    public final View getNoDateView() {
        View view = this.noDateView;
        if (view == null) {
            i.q2.t.i0.k("noDateView");
        }
        return view;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        textView.setText("\u6d88\u606f");
        initView();
    }

    public final void initView() {
        ImageView imageView = this.mNoImg;
        if (imageView == null) {
            i.q2.t.i0.k("mNoImg");
        }
        imageView.setImageResource(R.drawable.iv_no_feed_list);
        TextView textView = this.mNoTxt;
        if (textView == null) {
            i.q2.t.i0.k("mNoTxt");
        }
        textView.setText("\u6682\u65e0\u6570\u636e");
        this.mPresenter = new NoteListPresenter(this.mActivity, this);
        NoteListPresenter noteListPresenter = this.mPresenter;
        if (noteListPresenter != null) {
            RecyclerView recyclerView = this.mRecycle;
            if (recyclerView == null) {
                i.q2.t.i0.k("mRecycle");
            }
            noteListPresenter.initRecycleWeb(recyclerView);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            i.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            i.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout2.s(false);
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            i.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout3.a((com.scwang.smartrefresh.layout.d.d) new a());
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            i.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout4.e();
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.callview.NoteListView
    public void onSuccessRequest(@j.c.a.d List<? extends NoteListBean> list) {
        i.q2.t.i0.f(list, "beans");
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            i.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.g();
        if (!(!list.isEmpty())) {
            View view = this.noDateView;
            if (view == null) {
                i.q2.t.i0.k("noDateView");
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
            i.q2.t.i0.k("noDateView");
        }
        view2.setVisibility(8);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_note_list;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMNoImg(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mNoImg = imageView;
    }

    public final void setMNoTxt(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mNoTxt = textView;
    }

    public final void setMPresenter(@j.c.a.e NoteListPresenter noteListPresenter) {
        this.mPresenter = noteListPresenter;
    }

    public final void setMRecycle(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycle = recyclerView;
    }

    public final void setMRefreshLayout(@j.c.a.d SmartRefreshLayout smartRefreshLayout) {
        i.q2.t.i0.f(smartRefreshLayout, "<set-?>");
        this.mRefreshLayout = smartRefreshLayout;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setNoDateView(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.noDateView = view;
    }
}
