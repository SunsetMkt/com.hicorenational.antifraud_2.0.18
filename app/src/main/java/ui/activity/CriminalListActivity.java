package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.CriminalsView;
import ui.presenter.CriminalsPresenter;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: CriminalListActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u000203J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H\u0007J\b\u00108\u001a\u000203H\u0014J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0007J\u0010\u0010<\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u000203H\u0014J \u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020\u000b2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.\u00a8\u0006C"}, d2 = {"Lui/activity/CriminalListActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalsView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mCriminalBeans", "Ljava/util/ArrayList;", "Lbean/CriminalBean;", "getMCriminalBeans", "()Ljava/util/ArrayList;", "setMCriminalBeans", "(Ljava/util/ArrayList;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/CriminalsPresenter;", "getMPresenter", "()Lui/presenter/CriminalsPresenter;", "setMPresenter", "(Lui/presenter/CriminalsPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onItemDelet", "onResume", "onSuccessHandle", "type", "list", "", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class CriminalListActivity extends BaseActivity implements CriminalsView {
    private int itemPos;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @j.c.a.e
    private CriminalsPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecycleView;

    @BindView(R.id.tv_add)
    @j.c.a.d
    public TextView mTvAdd;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @j.c.a.d
    private String caseInfoId = "";

    @j.c.a.d
    private ArrayList<CriminalBean> mCriminalBeans = new ArrayList<>();

    /* JADX INFO: compiled from: CriminalListActivity.kt */
    public static final class a implements IClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13293b;

        a(int i2) {
            this.f13293b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CriminalsPresenter mPresenter = CriminalListActivity.this.getMPresenter();
            if (mPresenter != null) {
                ArrayList<CriminalBean> mCriminalBeans = CriminalListActivity.this.getMCriminalBeans();
                CriminalBean criminalBean = mCriminalBeans != null ? mCriminalBeans.get(this.f13293b) : null;
                i.q2.t.i0.a((Object) criminalBean, "mCriminalBeans?.get(itemPos)");
                mPresenter.deleteReportCriminal(criminalBean.getId());
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getItemPos() {
        return this.itemPos;
    }

    @j.c.a.d
    public final ArrayList<CriminalBean> getMCriminalBeans() {
        return this.mCriminalBeans;
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
    public final CriminalsPresenter getMPresenter() {
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
    public final TextView getMTvAdd() {
        TextView textView = this.mTvAdd;
        if (textView == null) {
            i.q2.t.i0.k("mTvAdd");
        }
        return textView;
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
        org.greenrobot.eventbus.c.f().e(this);
        SwipBackLayout.a(this.mActivity).a();
        initView();
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
        TextView textView2 = this.mTvAdd;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvAdd");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        textView2.setText("\u5acc\u7591\u4eba\u4fe1\u606f");
        this.mPresenter = new CriminalsPresenter(this.mActivity, this.caseInfoId, this);
        CriminalsPresenter criminalsPresenter = this.mPresenter;
        if (criminalsPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                i.q2.t.i0.k("mRecycleView");
            }
            criminalsPresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_add})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@j.c.a.d util.n2.a aVar) {
        i.q2.t.i0.f(aVar, "refreshUIEvent");
        aVar.a();
    }

    @Override // ui.callview.CriminalsView
    public void onItemDelet(int i2) {
        this.itemPos = i2;
        util.f1.b(this.mActivity, "\u5220\u9664\u5f53\u524d\u5acc\u7591\u4eba\u4fe1\u606f\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", new a(i2));
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalsPresenter criminalsPresenter = this.mPresenter;
        if (criminalsPresenter != null) {
            criminalsPresenter.getCriminalList(this.caseInfoId);
        }
    }

    @Override // ui.callview.CriminalsView
    public void onSuccessHandle(int i2, @j.c.a.e List<CriminalBean> list) {
        if (i2 != 1) {
            if (i2 == 4) {
                this.mCriminalBeans.remove(this.itemPos);
                CriminalsPresenter criminalsPresenter = this.mPresenter;
                if (criminalsPresenter != null) {
                    criminalsPresenter.setListData(this.mCriminalBeans);
                    return;
                }
                return;
            }
            return;
        }
        ArrayList<CriminalBean> arrayList = this.mCriminalBeans;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<CriminalBean> arrayList2 = this.mCriminalBeans;
        if (arrayList2 != null) {
            if (list == null) {
                i.q2.t.i0.f();
            }
            arrayList2.addAll(list);
        }
        CriminalsPresenter criminalsPresenter2 = this.mPresenter;
        if (criminalsPresenter2 != null) {
            criminalsPresenter2.setListData(this.mCriminalBeans);
        }
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setItemPos(int i2) {
        this.itemPos = i2;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_criminal_list;
    }

    public final void setMCriminalBeans(@j.c.a.d ArrayList<CriminalBean> arrayList) {
        i.q2.t.i0.f(arrayList, "<set-?>");
        this.mCriminalBeans = arrayList;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e CriminalsPresenter criminalsPresenter) {
        this.mPresenter = criminalsPresenter;
    }

    public final void setMRecycleView(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvAdd(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
