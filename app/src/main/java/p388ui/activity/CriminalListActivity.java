package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.CriminalsView;
import p388ui.presenter.CriminalsPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.p395c2.C7265a;

/* compiled from: CriminalListActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u000203J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H\u0007J\b\u00108\u001a\u000203H\u0014J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0007J\u0010\u0010<\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u000203H\u0014J \u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020\u000b2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u0006C"}, m23546d2 = {"Lui/activity/CriminalListActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalsView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mCriminalBeans", "Ljava/util/ArrayList;", "Lbean/CriminalBean;", "getMCriminalBeans", "()Ljava/util/ArrayList;", "setMCriminalBeans", "(Ljava/util/ArrayList;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/CriminalsPresenter;", "getMPresenter", "()Lui/presenter/CriminalsPresenter;", "setMPresenter", "(Lui/presenter/CriminalsPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onItemDelet", "onResume", "onSuccessHandle", "type", "list", "", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CriminalListActivity extends BaseActivity implements CriminalsView {
    private int itemPos;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private CriminalsPresenter mPresenter;

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
    private String caseInfoId = "";

    @InterfaceC5816d
    private ArrayList<CriminalBean> mCriminalBeans = new ArrayList<>();

    /* compiled from: CriminalListActivity.kt */
    /* renamed from: ui.activity.CriminalListActivity$a */
    public static final class C6250a implements IClickListener {

        /* renamed from: b */
        final /* synthetic */ int f22176b;

        C6250a(int i2) {
            this.f22176b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CriminalsPresenter mPresenter = CriminalListActivity.this.getMPresenter();
            if (mPresenter != null) {
                ArrayList<CriminalBean> mCriminalBeans = CriminalListActivity.this.getMCriminalBeans();
                CriminalBean criminalBean = mCriminalBeans != null ? mCriminalBeans.get(this.f22176b) : null;
                C5544i0.m22521a((Object) criminalBean, "mCriminalBeans?.get(itemPos)");
                mPresenter.deleteReportCriminal(criminalBean.getId());
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
    public final ArrayList<CriminalBean> getMCriminalBeans() {
        return this.mCriminalBeans;
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
    public final CriminalsPresenter getMPresenter() {
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
        C6049c.m24987f().m25001e(this);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        initView();
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
        TextView textView2 = this.mTvAdd;
        if (textView2 == null) {
            C5544i0.m22554k("mTvAdd");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setText("嫌疑人信息");
        this.mPresenter = new CriminalsPresenter(this.mActivity, this.caseInfoId, this);
        CriminalsPresenter criminalsPresenter = this.mPresenter;
        if (criminalsPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecycleView");
            }
            criminalsPresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_add})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@InterfaceC5816d C7265a c7265a) {
        C5544i0.m22546f(c7265a, "refreshUIEvent");
        c7265a.m26297a();
    }

    @Override // p388ui.callview.CriminalsView
    public void onItemDelet(int i2) {
        this.itemPos = i2;
        C7257b1.m26211b(this.mActivity, "删除当前嫌疑人信息？", "", "确定", "取消", new C6250a(i2));
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalsPresenter criminalsPresenter = this.mPresenter;
        if (criminalsPresenter != null) {
            criminalsPresenter.getCriminalList(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.CriminalsView
    public void onSuccessHandle(int i2, @InterfaceC5817e List<CriminalBean> list) {
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
                C5544i0.m22545f();
            }
            arrayList2.addAll(list);
        }
        CriminalsPresenter criminalsPresenter2 = this.mPresenter;
        if (criminalsPresenter2 != null) {
            criminalsPresenter2.setListData(this.mCriminalBeans);
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
        return C2113R.layout.activity_criminal_list;
    }

    public final void setMCriminalBeans(@InterfaceC5816d ArrayList<CriminalBean> arrayList) {
        C5544i0.m22546f(arrayList, "<set-?>");
        this.mCriminalBeans = arrayList;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e CriminalsPresenter criminalsPresenter) {
        this.mPresenter = criminalsPresenter;
    }

    public final void setMRecycleView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
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
