package p388ui.activity;

import adapter.RelationAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.RelationBean;
import bean.RelationPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.callview.RelationView;
import p388ui.presenter.RelationPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* compiled from: RelationActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020(H\u0002J(\u0010-\u001a\u00020(2\u000e\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030/2\u0006\u00100\u001a\u0002012\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020*H\u0016J\b\u00104\u001a\u00020(H\u0014J\u0016\u00105\u001a\u00020(2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000707H\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0007J\b\u00109\u001a\u00020*H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 ¨\u0006:"}, m23546d2 = {"Lui/activity/RelationActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/RelationView;", "()V", "accBeans", "Ljava/util/ArrayList;", "Lbean/RelationBean;", "Lkotlin/collections/ArrayList;", "caseInfoId", "", "mAdapter", "Ladapter/RelationAdapter;", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mPresenter", "Lui/presenter/RelationPresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvCommit", "Landroid/widget/TextView;", "getMTvCommit", "()Landroid/widget/TextView;", "setMTvCommit", "(Landroid/widget/TextView;)V", "mTvSelectTip", "getMTvSelectTip", "setMTvSelectTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "forceActivity", "", "position", "", "initPage", "initRecycle", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "onItemDelet", "itemPos", "onResume", "onSuccessList", "list", "", "onViewClicked", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RelationActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i, RelationView {
    private RelationAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    @InterfaceC5816d
    public Button mBtnCommit;
    private RelationPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    @InterfaceC5816d
    public TextView mTvCommit;

    @BindView(C2113R.id.tv_add)
    @InterfaceC5816d
    public TextView mTvSelectTip;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private String caseInfoId = "";
    private ArrayList<RelationBean> accBeans = new ArrayList<>();

    /* compiled from: RelationActivity.kt */
    /* renamed from: ui.activity.RelationActivity$a */
    public static final class C6477a implements IClickListener {

        /* renamed from: b */
        final /* synthetic */ int f22816b;

        C6477a(int i2) {
            this.f22816b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RelationPresenter relationPresenter = RelationActivity.this.mPresenter;
            if (relationPresenter != null) {
                String str = RelationActivity.this.caseInfoId;
                ArrayList arrayList = RelationActivity.this.accBeans;
                if (arrayList == null) {
                    C5544i0.m22545f();
                }
                Object obj = arrayList.get(this.f22816b);
                C5544i0.m22521a(obj, "accBeans!![position]");
                relationPresenter.removeRelationtel(str, ((RelationBean) obj).getLinkTelInfoID(), this.f22816b);
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private final void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) RelationAddActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        if (i2 != -1) {
            intent.putExtra(C7292k1.f25438v, i2);
            ArrayList<RelationBean> arrayList = this.accBeans;
            if (arrayList == null) {
                C5544i0.m22545f();
            }
            intent.putExtra(C7292k1.f25440w, arrayList.get(i2));
        }
        startActivity(intent);
    }

    private final void initRecycle() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        if (recyclerView == null) {
            C5544i0.m22545f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new RelationAdapter(C2113R.layout.item_relation_acc, this.accBeans);
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
    public final RecyclerView getMRecyclerview() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        return recyclerView;
    }

    @InterfaceC5816d
    public final TextView getMTvCommit() {
        TextView textView = this.mTvCommit;
        if (textView == null) {
            C5544i0.m22554k("mTvCommit");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvSelectTip() {
        TextView textView = this.mTvSelectTip;
        if (textView == null) {
            C5544i0.m22554k("mTvSelectTip");
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
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("添加关联类嫌疑人电话");
        TextView textView2 = this.mTvSelectTip;
        if (textView2 == null) {
            C5544i0.m22554k("mTvSelectTip");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setText("添加");
        TextView textView3 = this.mTvCommit;
        if (textView3 == null) {
            C5544i0.m22554k("mTvCommit");
        }
        if (textView3 == null) {
            C5544i0.m22545f();
        }
        textView3.setText("最多可添加20条关联类嫌疑人电话");
        Button button = this.mBtnCommit;
        if (button == null) {
            C5544i0.m22554k("mBtnCommit");
        }
        if (button == null) {
            C5544i0.m22545f();
        }
        button.setText("确定");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        initRecycle();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(@InterfaceC5816d BaseQuickAdapter<?, ?> baseQuickAdapter, @InterfaceC5816d View view, int i2) {
        C5544i0.m22546f(baseQuickAdapter, "adapter");
        C5544i0.m22546f(view, "view");
        int id = view.getId();
        if (id == C2113R.id.cl_item) {
            forceActivity(i2);
        } else if (id == C2113R.id.iv_delete) {
            C7257b1.m26211b(this.mActivity, "删除当前关联类信息？", "", "确定", "取消", new C6477a(i2));
        } else {
            if (id != C2113R.id.iv_edit) {
                return;
            }
            forceActivity(i2);
        }
    }

    @Override // p388ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.C6817a.m25471a(this, i2);
        this.accBeans.remove(i2);
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter == null) {
            C5544i0.m22545f();
        }
        relationAdapter.m264a((List<RelationBean>) this.accBeans);
    }

    @Override // p388ui.callview.RelationView
    public void onItemEdit() {
        RelationView.C6817a.m25470a(this);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter != null) {
            relationPresenter.getRelationList(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.RelationView
    public void onSuccessList(@InterfaceC5816d List<? extends RelationBean> list) {
        C5544i0.m22546f(list, "list");
        this.accBeans = (ArrayList) list;
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter == null) {
            C5544i0.m22545f();
        }
        relationAdapter.m264a((List<RelationBean>) this.accBeans);
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

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_add, C2113R.id.btn_commit})
    public final void onViewClicked(@InterfaceC5816d View view) {
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
        ArrayList<RelationBean> arrayList = this.accBeans;
        if (arrayList == null) {
            C5544i0.m22545f();
        }
        if (arrayList.size() >= 20) {
            C7331w1.m26688a("最多可添加20条关联类嫌疑人电话");
        } else {
            forceActivity(-1);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_relation_list;
    }

    public final void setMBtnCommit(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMRecyclerview(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyclerview = recyclerView;
    }

    public final void setMTvCommit(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCommit = textView;
    }

    public final void setMTvSelectTip(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvSelectTip = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
