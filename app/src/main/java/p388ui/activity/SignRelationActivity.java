package p388ui.activity;

import adapter.RelationAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.RelationBean;
import bean.RelationPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.Hicore;
import p388ui.callview.RelationView;
import p388ui.presenter.RelationPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignRelationActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J*\u0010\u001e\u001a\u00020\u001c2\u0010\u0010\u001f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0007J\b\u0010)\u001a\u00020$H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m23546d2 = {"Lui/activity/SignRelationActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/RelationView;", "()V", "caseInfoId", "", "mAdapter", "Ladapter/RelationAdapter;", "mPresenter", "Lui/presenter/RelationPresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "platBeans", "Ljava/util/ArrayList;", "Lbean/RelationBean;", "Lkotlin/collections/ArrayList;", "initPage", "", "initRecycle", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "", "onSuccessList", "list", "", "onViewClicked", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignRelationActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i, RelationView {
    private RelationAdapter mAdapter;
    private RelationPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private String caseInfoId = "";
    private ArrayList<RelationBean> platBeans = new ArrayList<>();

    private final void initRecycle() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        if (recyclerView == null) {
            C5544i0.m22545f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new RelationAdapter(C2113R.layout.item_relation_acc, this.platBeans);
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter == null) {
            C5544i0.m22545f();
        }
        RecyclerView recyclerView2 = this.mRecyclerview;
        if (recyclerView2 == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        relationAdapter.m5103a(recyclerView2);
        RecyclerView recyclerView3 = this.mRecyclerview;
        if (recyclerView3 == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        if (recyclerView3 == null) {
            C5544i0.m22545f();
        }
        recyclerView3.setAdapter(this.mAdapter);
        RelationAdapter relationAdapter2 = this.mAdapter;
        if (relationAdapter2 == null) {
            C5544i0.m22545f();
        }
        relationAdapter2.setOnItemChildClickListener(this);
        RelationAdapter relationAdapter3 = this.mAdapter;
        if (relationAdapter3 == null) {
            C5544i0.m22545f();
        }
        relationAdapter3.m265k(true);
    }

    @InterfaceC5816d
    public final RecyclerView getMRecyclerview() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerview");
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
        textView.setText("关联类嫌疑人电话");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        initRecycle();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter != null) {
            relationPresenter.getRelationList(this.caseInfoId);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(@InterfaceC5817e BaseQuickAdapter<?, ?> baseQuickAdapter, @InterfaceC5816d View view, int i2) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == C2113R.id.cl_item) {
            Intent intent = new Intent(this.mActivity, (Class<?>) SignRelationDetialActivity.class);
            ArrayList<RelationBean> arrayList = this.platBeans;
            if (arrayList == null) {
                C5544i0.m22545f();
            }
            intent.putExtra(C7292k1.f25440w, arrayList.get(i2));
            startActivity(intent);
        }
    }

    @Override // p388ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.C6817a.m25471a(this, i2);
    }

    @Override // p388ui.callview.RelationView
    public void onItemEdit() {
        RelationView.C6817a.m25470a(this);
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessList(@InterfaceC5816d List<? extends RelationBean> list) {
        C5544i0.m22546f(list, "list");
        this.platBeans = (ArrayList) list;
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter != null) {
            relationAdapter.m264a((List<RelationBean>) this.platBeans);
        }
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessPlatList(@InterfaceC5816d List<? extends RelationPlatBean> list) {
        C5544i0.m22546f(list, "list");
        RelationView.C6817a.m25474b(this, list);
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessSave() {
        RelationView.C6817a.m25473b(this);
    }

    @OnClick({C2113R.id.iv_back})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_relation_sign;
    }

    public final void setMRecyclerview(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyclerview = recyclerView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
