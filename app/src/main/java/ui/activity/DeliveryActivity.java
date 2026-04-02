package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import ui.callview.DeliveryView;
import ui.presenter.DeliveryPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: compiled from: DeliveryActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u001fH\u0007J\u0010\u0010@\u001a\u00020=2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010A\u001a\u00020=2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010B\u001a\u00020=H\u0014J\u0016\u0010C\u001a\u00020=2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060EH\u0016J\b\u0010F\u001a\u00020\u0013H\u0016R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0002018\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001e\u00109\u001a\u0002018\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105\u00a8\u0006G"}, d2 = {"Lui/activity/DeliveryActivity;", "Lui/activity/BaseActivity;", "Lui/callview/DeliveryView;", "()V", "arrayListBean", "Ljava/util/ArrayList;", "Lbean/DeliveryBean;", "Lkotlin/collections/ArrayList;", "getArrayListBean", "()Ljava/util/ArrayList;", "setArrayListBean", "(Ljava/util/ArrayList;)V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlAddLayout", "Landroid/view/View;", "getMLlAddLayout", "()Landroid/view/View;", "setMLlAddLayout", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/DeliveryPresenter;", "getMPresenter", "()Lui/presenter/DeliveryPresenter;", "setMPresenter", "(Lui/presenter/DeliveryPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvCommitTip", "getMTvCommitTip", "setMTvCommitTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onClick", "view", "onItemDelet", "onItemEdit", "onResume", "onSuccessList", "list", "", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class DeliveryActivity extends BaseActivity implements DeliveryView {
    private int itemPos;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_add)
    @j.c.a.d
    public View mLlAddLayout;

    @j.c.a.e
    private DeliveryPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecycleView;

    @BindView(R.id.tv_add)
    @j.c.a.d
    public TextView mTvAdd;

    @BindView(R.id.tv_commit_tip)
    @j.c.a.d
    public TextView mTvCommitTip;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @j.c.a.d
    private String caseInfoId = "";

    @j.c.a.d
    private ArrayList<DeliveryBean> arrayListBean = new ArrayList<>();

    /* JADX INFO: compiled from: DeliveryActivity.kt */
    public static final class a implements IClickListener {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f13337b;

        a(int i2) {
            this.f13337b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            DeliveryPresenter mPresenter = DeliveryActivity.this.getMPresenter();
            if (mPresenter != null) {
                String caseInfoId = DeliveryActivity.this.getCaseInfoId();
                ArrayList<DeliveryBean> arrayListBean = DeliveryActivity.this.getArrayListBean();
                DeliveryBean deliveryBean = arrayListBean != null ? arrayListBean.get(this.f13337b) : null;
                i.q2.t.i0.a((Object) deliveryBean, "arrayListBean?.get(itemPos)");
                mPresenter.removeDelivery(caseInfoId, deliveryBean.getMailingTelInfoid(), this.f13337b);
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @j.c.a.d
    public final ArrayList<DeliveryBean> getArrayListBean() {
        return this.arrayListBean;
    }

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getItemPos() {
        return this.itemPos;
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
    public final View getMLlAddLayout() {
        View view = this.mLlAddLayout;
        if (view == null) {
            i.q2.t.i0.k("mLlAddLayout");
        }
        return view;
    }

    @j.c.a.e
    public final DeliveryPresenter getMPresenter() {
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
    public final TextView getMTvCommitTip() {
        TextView textView = this.mTvCommitTip;
        if (textView == null) {
            i.q2.t.i0.k("mTvCommitTip");
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
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvAdd;
        if (textView == null) {
            i.q2.t.i0.k("mTvAdd");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u6dfb\u52a0");
        TextView textView2 = this.mTvTitle;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        textView2.setText("\u6dfb\u52a0\u5bc4\u9012\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd");
        TextView textView3 = this.mTvCommitTip;
        if (textView3 == null) {
            i.q2.t.i0.k("mTvCommitTip");
        }
        textView3.setText("\u6700\u591a\u53ef\u6dfb\u52a020\u6761\u5bc4\u9012\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd");
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new DeliveryPresenter(this.mActivity, this);
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                i.q2.t.i0.k("mRecycleView");
            }
            deliveryPresenter.initRecycle(recyclerView);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_add, R.id.btn_commit})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_commit) {
            finish();
            return;
        }
        if (id == R.id.iv_back) {
            finish();
            return;
        }
        if (id != R.id.ll_add) {
            return;
        }
        ArrayList<DeliveryBean> arrayList = this.arrayListBean;
        if (arrayList == null) {
            i.q2.t.i0.f();
        }
        if (arrayList.size() >= 20) {
            e2.a("\u6700\u591a\u53ef\u6dfb\u52a020\u6761\u5bc4\u9012\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd");
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) DeliveryAddActivity.class);
        intent.putExtra(util.p1.C0, this.caseInfoId);
        startActivity(intent);
    }

    @Override // ui.callview.DeliveryView
    public void onItemDelet(int i2) {
        util.f1.b(this.mActivity, "\u5220\u9664\u5f53\u524d\u5bc4\u9012\u7c7b\u4fe1\u606f\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", new a(i2));
    }

    @Override // ui.callview.DeliveryView
    public void onItemEdit(int i2) {
        this.itemPos = i2;
        Intent intent = new Intent(this.mActivity, (Class<?>) DeliveryAddActivity.class);
        intent.putExtra(util.p1.C0, this.caseInfoId);
        ArrayList<DeliveryBean> arrayList = this.arrayListBean;
        intent.putExtra(util.p1.f15011c, arrayList != null ? arrayList.get(i2) : null);
        this.mActivity.startActivity(intent);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            deliveryPresenter.getDeliveryList(this.caseInfoId);
        }
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessList(@j.c.a.d List<? extends DeliveryBean> list) {
        i.q2.t.i0.f(list, "list");
        this.arrayListBean = (ArrayList) list;
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            deliveryPresenter.setListData(this.arrayListBean);
        }
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessPlatList(@j.c.a.d List<? extends DeliveryPlatBean> list) {
        i.q2.t.i0.f(list, "list");
        DeliveryView.a.b(this, list);
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessSave(@j.c.a.d DeliveryBean deliveryBean) {
        i.q2.t.i0.f(deliveryBean, "bean");
        DeliveryView.a.a(this, deliveryBean);
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessSaveFail(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "msg");
        DeliveryView.a.a(this, str);
    }

    public final void setArrayListBean(@j.c.a.d ArrayList<DeliveryBean> arrayList) {
        i.q2.t.i0.f(arrayList, "<set-?>");
        this.arrayListBean = arrayList;
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
        return R.layout.activity_delivery_list;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddLayout(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlAddLayout = view;
    }

    public final void setMPresenter(@j.c.a.e DeliveryPresenter deliveryPresenter) {
        this.mPresenter = deliveryPresenter;
    }

    public final void setMRecycleView(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvAdd(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvCommitTip(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCommitTip = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
