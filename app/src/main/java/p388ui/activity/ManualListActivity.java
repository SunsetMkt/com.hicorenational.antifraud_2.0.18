package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import bean.ManualListBean;
import bean.PageBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2882b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ManualListCallView;
import p388ui.presenter.ManualListPresenter;
import p388ui.view.swip.SwipBackLayout;

/* compiled from: ManualListActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010D\u001a\u00020EH\u0016J\u0006\u0010F\u001a\u00020EJ\u0010\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020IH\u0007J\u0018\u0010J\u001a\u00020E2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020'H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%¨\u0006N"}, m23546d2 = {"Lui/activity/ManualListActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ManualListCallView;", "()V", "isLoadmore", "", "()Z", "setLoadmore", "(Z)V", "mClNoData", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMClNoData", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMClNoData", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mList", "Ljava/util/ArrayList;", "Lbean/ManualListBean;", "Lkotlin/collections/ArrayList;", "getMList", "()Ljava/util/ArrayList;", "setMList", "(Ljava/util/ArrayList;)V", "mNoImg", "getMNoImg", "setMNoImg", "mNoTip", "Landroid/widget/TextView;", "getMNoTip", "()Landroid/widget/TextView;", "setMNoTip", "(Landroid/widget/TextView;)V", "mPageIndex", "", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "mPresenter", "Lui/presenter/ManualListPresenter;", "getMPresenter", "()Lui/presenter/ManualListPresenter;", "setMPresenter", "(Lui/presenter/ManualListPresenter;)V", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "getMRvList", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onSuccess", "beans", "Lbean/PageBean;", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ManualListActivity extends BaseActivity implements ManualListCallView {
    private boolean isLoadmore;

    @BindView(C2113R.id.cl_no_data)
    @InterfaceC5816d
    public ConstraintLayout mClNoData;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.iv_img)
    @InterfaceC5816d
    public ImageView mNoImg;

    @BindView(C2113R.id.tv_tip)
    @InterfaceC5816d
    public TextView mNoTip;

    @InterfaceC5817e
    private ManualListPresenter mPresenter;

    @BindView(C2113R.id.swipe_refresh)
    @InterfaceC5816d
    public SmartRefreshLayout mRefreshLayout;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRvList;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5817e
    private ArrayList<ManualListBean> mList = new ArrayList<>();
    private int mPageSize = 10;
    private int mPageIndex = 1;

    /* compiled from: ManualListActivity.kt */
    /* renamed from: ui.activity.ManualListActivity$a */
    static final class C6384a implements InterfaceC2884d {
        C6384a() {
        }

        @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
        /* renamed from: a */
        public final void mo8732a(@InterfaceC5817e InterfaceC2876j interfaceC2876j) {
            if (ManualListActivity.this.getMRefreshLayout() == null || ManualListActivity.this.getMPresenter() == null) {
                return;
            }
            ManualListActivity.this.setMPageIndex(1);
            ManualListActivity.this.setLoadmore(false);
            ManualListPresenter mPresenter = ManualListActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.manualListData(ManualListActivity.this.getMPageIndex(), ManualListActivity.this.getMPageSize());
            }
        }
    }

    /* compiled from: ManualListActivity.kt */
    /* renamed from: ui.activity.ManualListActivity$b */
    static final class C6385b implements InterfaceC2882b {
        C6385b() {
        }

        @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2882b
        /* renamed from: b */
        public final void mo8723b(@InterfaceC5817e InterfaceC2876j interfaceC2876j) {
            if (ManualListActivity.this.getMRefreshLayout() == null || ManualListActivity.this.getMPresenter() == null) {
                return;
            }
            ManualListActivity.this.setLoadmore(true);
            ManualListActivity manualListActivity = ManualListActivity.this;
            ArrayList<ManualListBean> mList = manualListActivity.getMList();
            if (mList == null) {
                C5544i0.m22545f();
            }
            manualListActivity.setMPageIndex((mList.size() / ManualListActivity.this.getMPageSize()) + 1);
            ManualListPresenter mPresenter = ManualListActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.manualListData(ManualListActivity.this.getMPageIndex(), ManualListActivity.this.getMPageSize());
            }
        }
    }

    @InterfaceC5816d
    public final ConstraintLayout getMClNoData() {
        ConstraintLayout constraintLayout = this.mClNoData;
        if (constraintLayout == null) {
            C5544i0.m22554k("mClNoData");
        }
        return constraintLayout;
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
    public final ArrayList<ManualListBean> getMList() {
        return this.mList;
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
    public final TextView getMNoTip() {
        TextView textView = this.mNoTip;
        if (textView == null) {
            C5544i0.m22554k("mNoTip");
        }
        return textView;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    @InterfaceC5817e
    public final ManualListPresenter getMPresenter() {
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
        textView.setText("审核记录");
        ImageView imageView = this.mNoImg;
        if (imageView == null) {
            C5544i0.m22554k("mNoImg");
        }
        imageView.setImageResource(C2113R.drawable.iv_no_feed_list);
        TextView textView2 = this.mNoTip;
        if (textView2 == null) {
            C5544i0.m22554k("mNoTip");
        }
        textView2.setText("暂无记录");
        initView();
    }

    public final void initView() {
        this.mPresenter = new ManualListPresenter(this.mActivity, this);
        ManualListPresenter manualListPresenter = this.mPresenter;
        if (manualListPresenter != null) {
            RecyclerView recyclerView = this.mRvList;
            if (recyclerView == null) {
                C5544i0.m22554k("mRvList");
            }
            manualListPresenter.initRecyclePeop(recyclerView);
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
        smartRefreshLayout4.mo8627a((InterfaceC2884d) new C6384a());
        SmartRefreshLayout smartRefreshLayout5 = this.mRefreshLayout;
        if (smartRefreshLayout5 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout5.mo8625a((InterfaceC2882b) new C6385b());
        SmartRefreshLayout smartRefreshLayout6 = this.mRefreshLayout;
        if (smartRefreshLayout6 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout6.mo8653e();
    }

    public final boolean isLoadmore() {
        return this.isLoadmore;
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            m8092a();
        }
    }

    @Override // p388ui.callview.ManualListCallView
    public void onSuccess(@InterfaceC5817e PageBean<ManualListBean> pageBean) {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout.mo8658g();
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            C5544i0.m22554k("mRefreshLayout");
        }
        smartRefreshLayout2.mo8637b();
        if (pageBean != null) {
            List<ManualListBean> rows = pageBean.getRows();
            if (pageBean.getTotal() > 0) {
                if (this.isLoadmore) {
                    ArrayList<ManualListBean> arrayList = this.mList;
                    if (arrayList == null) {
                        C5544i0.m22545f();
                    }
                    arrayList.addAll(rows);
                } else {
                    ArrayList<ManualListBean> arrayList2 = this.mList;
                    if (arrayList2 == null) {
                        C5544i0.m22545f();
                    }
                    arrayList2.clear();
                    ArrayList<ManualListBean> arrayList3 = this.mList;
                    if (arrayList3 == null) {
                        C5544i0.m22545f();
                    }
                    arrayList3.addAll(rows);
                    SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
                    if (smartRefreshLayout3 == null) {
                        C5544i0.m22554k("mRefreshLayout");
                    }
                    smartRefreshLayout3.mo8682s(true);
                }
                ManualListPresenter manualListPresenter = this.mPresenter;
                if (manualListPresenter != null) {
                    manualListPresenter.setListData(this.mList);
                }
                if (rows.size() < this.mPageSize) {
                    SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
                    if (smartRefreshLayout4 == null) {
                        C5544i0.m22554k("mRefreshLayout");
                    }
                    smartRefreshLayout4.mo8682s(false);
                } else if (rows.size() > this.mPageSize) {
                    SmartRefreshLayout smartRefreshLayout5 = this.mRefreshLayout;
                    if (smartRefreshLayout5 == null) {
                        C5544i0.m22554k("mRefreshLayout");
                    }
                    smartRefreshLayout5.mo8682s(false);
                } else {
                    SmartRefreshLayout smartRefreshLayout6 = this.mRefreshLayout;
                    if (smartRefreshLayout6 == null) {
                        C5544i0.m22554k("mRefreshLayout");
                    }
                    smartRefreshLayout6.mo8682s(true);
                }
            } else if (this.isLoadmore) {
                SmartRefreshLayout smartRefreshLayout7 = this.mRefreshLayout;
                if (smartRefreshLayout7 == null) {
                    C5544i0.m22554k("mRefreshLayout");
                }
                smartRefreshLayout7.mo8682s(false);
            } else {
                ArrayList<ManualListBean> arrayList4 = this.mList;
                if (arrayList4 == null) {
                    C5544i0.m22545f();
                }
                arrayList4.clear();
                ManualListPresenter manualListPresenter2 = this.mPresenter;
                if (manualListPresenter2 != null) {
                    manualListPresenter2.setListData(this.mList);
                }
            }
        }
        this.isLoadmore = false;
        ArrayList<ManualListBean> arrayList5 = this.mList;
        if (arrayList5 == null) {
            C5544i0.m22545f();
        }
        if (arrayList5.size() > 0) {
            ConstraintLayout constraintLayout = this.mClNoData;
            if (constraintLayout == null) {
                C5544i0.m22554k("mClNoData");
            }
            constraintLayout.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = this.mClNoData;
        if (constraintLayout2 == null) {
            C5544i0.m22554k("mClNoData");
        }
        constraintLayout2.setVisibility(0);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_manual_list;
    }

    public final void setLoadmore(boolean z) {
        this.isLoadmore = z;
    }

    public final void setMClNoData(@InterfaceC5816d ConstraintLayout constraintLayout) {
        C5544i0.m22546f(constraintLayout, "<set-?>");
        this.mClNoData = constraintLayout;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMList(@InterfaceC5817e ArrayList<ManualListBean> arrayList) {
        this.mList = arrayList;
    }

    public final void setMNoImg(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mNoImg = imageView;
    }

    public final void setMNoTip(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mNoTip = textView;
    }

    public final void setMPageIndex(int i2) {
        this.mPageIndex = i2;
    }

    public final void setMPageSize(int i2) {
        this.mPageSize = i2;
    }

    public final void setMPresenter(@InterfaceC5817e ManualListPresenter manualListPresenter) {
        this.mPresenter = manualListPresenter;
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
