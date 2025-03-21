package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.RechargeBean;
import bean.RechargePlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.callview.RechargeView;
import p388ui.presenter.RechargePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* compiled from: ReChargeActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u0019H\u0007J\u0010\u00106\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u000203H\u0014J\u0016\u00109\u001a\u0002032\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060;H\u0016J\b\u0010<\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001e\u0010/\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+¨\u0006="}, m23546d2 = {"Lui/activity/ReChargeActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RechargeView;", "()V", "arrayListBean", "Ljava/util/ArrayList;", "Lbean/RechargeBean;", "Lkotlin/collections/ArrayList;", "caseInfoId", "", "itemPos", "", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlAddLayout", "Landroid/view/View;", "getMLlAddLayout", "()Landroid/view/View;", "setMLlAddLayout", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/RechargePresenter;", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvCommitTip", "getMTvCommitTip", "setMTvCommitTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onClick", "view", "onItemDelet", "onItemEdit", "onResume", "onSuccessList", "list", "", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReChargeActivity extends BaseActivity implements RechargeView {
    private int itemPos;

    @BindView(C2113R.id.btn_commit)
    @InterfaceC5816d
    public Button mBtnCommit;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_add)
    @InterfaceC5816d
    public View mLlAddLayout;
    private RechargePresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecycleView;

    @BindView(C2113R.id.tv_add)
    @InterfaceC5816d
    public TextView mTvAdd;

    @BindView(C2113R.id.tv_commit_tip)
    @InterfaceC5816d
    public TextView mTvCommitTip;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private String caseInfoId = "";
    private ArrayList<RechargeBean> arrayListBean = new ArrayList<>();

    /* compiled from: ReChargeActivity.kt */
    /* renamed from: ui.activity.ReChargeActivity$a */
    public static final class C6455a implements IClickListener {

        /* renamed from: b */
        final /* synthetic */ int f22759b;

        C6455a(int i2) {
            this.f22759b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RechargePresenter rechargePresenter = ReChargeActivity.this.mPresenter;
            if (rechargePresenter != null) {
                String str = ReChargeActivity.this.caseInfoId;
                ArrayList arrayList = ReChargeActivity.this.arrayListBean;
                RechargeBean rechargeBean = arrayList != null ? (RechargeBean) arrayList.get(this.f22759b) : null;
                C5544i0.m22521a((Object) rechargeBean, "arrayListBean?.get(itemPos)");
                rechargePresenter.deleteRecharge(str, rechargeBean.getChargeTelInfoID(), this.f22759b);
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @InterfaceC5816d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            C5544i0.m22554k("mBtnCommit");
        }
        return button;
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
    public final View getMLlAddLayout() {
        View view = this.mLlAddLayout;
        if (view == null) {
            C5544i0.m22554k("mLlAddLayout");
        }
        return view;
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
    public final TextView getMTvCommitTip() {
        TextView textView = this.mTvCommitTip;
        if (textView == null) {
            C5544i0.m22554k("mTvCommitTip");
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
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvAdd;
        if (textView == null) {
            C5544i0.m22554k("mTvAdd");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("添加");
        TextView textView2 = this.mTvTitle;
        if (textView2 == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setText("添加充值类嫌疑人电话");
        TextView textView3 = this.mTvCommitTip;
        if (textView3 == null) {
            C5544i0.m22554k("mTvCommitTip");
        }
        textView3.setText("最多可添加20条充值类嫌疑人电话");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new RechargePresenter(this.mActivity, this);
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecycleView");
            }
            rechargePresenter.initRecycle(recyclerView);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_add, C2113R.id.btn_commit})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.btn_commit) {
            finish();
            return;
        }
        if (id == C2113R.id.iv_back) {
            onBackPressed();
            return;
        }
        if (id != C2113R.id.ll_add) {
            return;
        }
        ArrayList<RechargeBean> arrayList = this.arrayListBean;
        if (arrayList == null) {
            C5544i0.m22545f();
        }
        if (arrayList.size() >= 20) {
            C7331w1.m26688a("最多可添加20条充值类嫌疑人电话");
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) RechargeAddActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        startActivity(intent);
    }

    @Override // p388ui.callview.RechargeView
    public void onItemDelet(int i2) {
        C7257b1.m26211b(this.mActivity, "删除当前充值类信息？", "", "确定", "取消", new C6455a(i2));
    }

    @Override // p388ui.callview.RechargeView
    public void onItemEdit(int i2) {
        this.itemPos = i2;
        Intent intent = new Intent(this.mActivity, (Class<?>) RechargeAddActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        ArrayList<RechargeBean> arrayList = this.arrayListBean;
        intent.putExtra(C7292k1.f25391c, arrayList != null ? arrayList.get(i2) : null);
        this.mActivity.startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter != null) {
            rechargePresenter.getReChargeList(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.RechargeView
    public void onSuccessList(@InterfaceC5816d List<? extends RechargeBean> list) {
        C5544i0.m22546f(list, "list");
        this.arrayListBean = (ArrayList) list;
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter != null) {
            rechargePresenter.setListData(this.arrayListBean);
        }
    }

    @Override // p388ui.callview.RechargeView
    public void onSuccessPlatList(@InterfaceC5816d List<? extends RechargePlatBean> list) {
        C5544i0.m22546f(list, "list");
        RechargeView.C6816a.m25469b(this, list);
    }

    @Override // p388ui.callview.RechargeView
    public void onSuccessSave() {
        RechargeView.C6816a.m25465a(this);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_recharg_list;
    }

    public final void setMBtnCommit(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddLayout(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlAddLayout = view;
    }

    public final void setMRecycleView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvAdd(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvCommitTip(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCommitTip = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
