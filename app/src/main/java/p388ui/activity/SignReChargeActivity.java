package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.RechargeBean;
import bean.RechargePlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.callview.RechargeView;
import p388ui.presenter.RechargePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignReChargeActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060(H\u0016J\b\u0010)\u001a\u00020%H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, m23546d2 = {"Lui/activity/SignReChargeActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RechargeView;", "()V", "arrayListBean", "Ljava/util/ArrayList;", "Lbean/RechargeBean;", "Lkotlin/collections/ArrayList;", "caseInfoId", "", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/RechargePresenter;", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "onClick", "view", "Landroid/view/View;", "onItemEdit", "itemPos", "", "onSuccessList", "list", "", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignReChargeActivity extends BaseActivity implements RechargeView {

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;
    private RechargePresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecycleView;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private String caseInfoId = "";
    private ArrayList<RechargeBean> arrayListBean = new ArrayList<>();

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
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
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("充值类嫌疑人电话");
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
        RechargePresenter rechargePresenter2 = this.mPresenter;
        if (rechargePresenter2 == null) {
            C5544i0.m22545f();
        }
        rechargePresenter2.isOnlySee(true);
        RechargePresenter rechargePresenter3 = this.mPresenter;
        if (rechargePresenter3 != null) {
            rechargePresenter3.getReChargeList(this.caseInfoId);
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.callview.RechargeView
    public void onItemDelet(int i2) {
        RechargeView.C6816a.m25466a(this, i2);
    }

    @Override // p388ui.callview.RechargeView
    public void onItemEdit(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) SignRechargeDetialActivity.class);
        ArrayList<RechargeBean> arrayList = this.arrayListBean;
        intent.putExtra(C7292k1.f25391c, arrayList != null ? arrayList.get(i2) : null);
        this.mActivity.startActivity(intent);
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
        return C2113R.layout.activity_sign_recharg;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
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
