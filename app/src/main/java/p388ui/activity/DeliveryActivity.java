package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.DeliveryView;
import p388ui.presenter.DeliveryPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* compiled from: DeliveryActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u001fH\u0007J\u0010\u0010@\u001a\u00020=2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010A\u001a\u00020=2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010B\u001a\u00020=H\u0014J\u0016\u0010C\u001a\u00020=2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060EH\u0016J\b\u0010F\u001a\u00020\u0013H\u0016R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001e\u00109\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105¨\u0006G"}, m23546d2 = {"Lui/activity/DeliveryActivity;", "Lui/activity/BaseActivity;", "Lui/callview/DeliveryView;", "()V", "arrayListBean", "Ljava/util/ArrayList;", "Lbean/DeliveryBean;", "Lkotlin/collections/ArrayList;", "getArrayListBean", "()Ljava/util/ArrayList;", "setArrayListBean", "(Ljava/util/ArrayList;)V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlAddLayout", "Landroid/view/View;", "getMLlAddLayout", "()Landroid/view/View;", "setMLlAddLayout", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/DeliveryPresenter;", "getMPresenter", "()Lui/presenter/DeliveryPresenter;", "setMPresenter", "(Lui/presenter/DeliveryPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvCommitTip", "getMTvCommitTip", "setMTvCommitTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onClick", "view", "onItemDelet", "onItemEdit", "onResume", "onSuccessList", "list", "", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class DeliveryActivity extends BaseActivity implements DeliveryView {
    private int itemPos;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_add)
    @InterfaceC5816d
    public View mLlAddLayout;

    @InterfaceC5817e
    private DeliveryPresenter mPresenter;

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

    @InterfaceC5816d
    private String caseInfoId = "";

    @InterfaceC5816d
    private ArrayList<DeliveryBean> arrayListBean = new ArrayList<>();

    /* compiled from: DeliveryActivity.kt */
    /* renamed from: ui.activity.DeliveryActivity$a */
    public static final class C6282a implements IClickListener {

        /* renamed from: b */
        final /* synthetic */ int f22258b;

        C6282a(int i2) {
            this.f22258b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            DeliveryPresenter mPresenter = DeliveryActivity.this.getMPresenter();
            if (mPresenter != null) {
                String caseInfoId = DeliveryActivity.this.getCaseInfoId();
                ArrayList<DeliveryBean> arrayListBean = DeliveryActivity.this.getArrayListBean();
                DeliveryBean deliveryBean = arrayListBean != null ? arrayListBean.get(this.f22258b) : null;
                C5544i0.m22521a((Object) deliveryBean, "arrayListBean?.get(itemPos)");
                mPresenter.removeDelivery(caseInfoId, deliveryBean.getMailingTelInfoid(), this.f22258b);
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @InterfaceC5816d
    public final ArrayList<DeliveryBean> getArrayListBean() {
        return this.arrayListBean;
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getItemPos() {
        return this.itemPos;
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

    @InterfaceC5817e
    public final DeliveryPresenter getMPresenter() {
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
        textView2.setText("添加寄递类嫌疑人电话");
        TextView textView3 = this.mTvCommitTip;
        if (textView3 == null) {
            C5544i0.m22554k("mTvCommitTip");
        }
        textView3.setText("最多可添加20条寄递类嫌疑人电话");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new DeliveryPresenter(this.mActivity, this);
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecycleView");
            }
            deliveryPresenter.initRecycle(recyclerView);
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
            finish();
            return;
        }
        if (id != C2113R.id.ll_add) {
            return;
        }
        ArrayList<DeliveryBean> arrayList = this.arrayListBean;
        if (arrayList == null) {
            C5544i0.m22545f();
        }
        if (arrayList.size() >= 20) {
            C7331w1.m26688a("最多可添加20条寄递类嫌疑人电话");
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) DeliveryAddActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        startActivity(intent);
    }

    @Override // p388ui.callview.DeliveryView
    public void onItemDelet(int i2) {
        C7257b1.m26211b(this.mActivity, "删除当前寄递类信息？", "", "确定", "取消", new C6282a(i2));
    }

    @Override // p388ui.callview.DeliveryView
    public void onItemEdit(int i2) {
        this.itemPos = i2;
        Intent intent = new Intent(this.mActivity, (Class<?>) DeliveryAddActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        ArrayList<DeliveryBean> arrayList = this.arrayListBean;
        intent.putExtra(C7292k1.f25391c, arrayList != null ? arrayList.get(i2) : null);
        this.mActivity.startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            deliveryPresenter.getDeliveryList(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.DeliveryView
    public void onSuccessList(@InterfaceC5816d List<? extends DeliveryBean> list) {
        C5544i0.m22546f(list, "list");
        this.arrayListBean = (ArrayList) list;
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            deliveryPresenter.setListData(this.arrayListBean);
        }
    }

    @Override // p388ui.callview.DeliveryView
    public void onSuccessPlatList(@InterfaceC5816d List<? extends DeliveryPlatBean> list) {
        C5544i0.m22546f(list, "list");
        DeliveryView.C6815a.m25464b(this, list);
    }

    @Override // p388ui.callview.DeliveryView
    public void onSuccessSave(@InterfaceC5816d DeliveryBean deliveryBean) {
        C5544i0.m22546f(deliveryBean, "bean");
        DeliveryView.C6815a.m25460a(this, deliveryBean);
    }

    @Override // p388ui.callview.DeliveryView
    public void onSuccessSaveFail(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "msg");
        DeliveryView.C6815a.m25461a(this, str);
    }

    public final void setArrayListBean(@InterfaceC5816d ArrayList<DeliveryBean> arrayList) {
        C5544i0.m22546f(arrayList, "<set-?>");
        this.arrayListBean = arrayList;
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
        return C2113R.layout.activity_delivery_list;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddLayout(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlAddLayout = view;
    }

    public final void setMPresenter(@InterfaceC5817e DeliveryPresenter deliveryPresenter) {
        this.mPresenter = deliveryPresenter;
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
