package p388ui.activity;

import adapter.SignCallAdapter;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
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
import p388ui.callview.CriminalPhoneView;
import p388ui.presenter.CriminalPhonePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignCallActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0016J*\u0010\u001d\u001a\u00020\u001b2\u0010\u0010\u001e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0014J\u0016\u0010%\u001a\u00020\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010)\u001a\u00020#H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006*"}, m23546d2 = {"Lui/activity/SignCallActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/CriminalPhoneView;", "()V", "caseInfoId", "", "mAdapter", "Ladapter/SignCallAdapter;", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mSelectList", "", "Lbean/CallBean;", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initAdapter", "", "initPage", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "", "onResume", "onSuccessList", "callBeans", "", "onViewClicked", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCallActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i, CriminalPhoneView {
    private String caseInfoId;
    private SignCallAdapter mAdapter;
    private CriminalPhonePresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyclerview;
    private final List<CallBean> mSelectList = new ArrayList();

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

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

    public final void initAdapter() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        if (recyclerView == null) {
            C5544i0.m22545f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new SignCallAdapter(C2113R.layout.sign_call_item, this.mSelectList);
        SignCallAdapter signCallAdapter = this.mAdapter;
        if (signCallAdapter == null) {
            C5544i0.m22545f();
        }
        RecyclerView recyclerView2 = this.mRecyclerview;
        if (recyclerView2 == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        signCallAdapter.m5103a(recyclerView2);
        RecyclerView recyclerView3 = this.mRecyclerview;
        if (recyclerView3 == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        if (recyclerView3 == null) {
            C5544i0.m22545f();
        }
        recyclerView3.setAdapter(this.mAdapter);
        SignCallAdapter signCallAdapter2 = this.mAdapter;
        if (signCallAdapter2 == null) {
            C5544i0.m22545f();
        }
        signCallAdapter2.setOnItemChildClickListener(this);
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
        textView.setText("通话类嫌疑人电话");
        this.caseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.mPresenter = new CriminalPhonePresenter(activity, this);
        initAdapter();
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            C5544i0.m22545f();
        }
        String str = this.caseInfoId;
        if (str == null) {
            C5544i0.m22545f();
        }
        criminalPhonePresenter.getCriminalCallList(str);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(@InterfaceC5817e BaseQuickAdapter<?, ?> baseQuickAdapter, @InterfaceC5816d View view, int i2) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == C2113R.id.cl_item) {
            Intent intent = new Intent(this.mActivity, (Class<?>) SignCallDetailActivity.class);
            intent.putExtra(C7292k1.f25391c, this.mSelectList.get(i2));
            startActivity(intent);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccess(@InterfaceC5816d List<String> list) {
        C5544i0.m22546f(list, "CNATelList");
        CriminalPhoneView.C6814a.m25457a(this, list);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessList(@InterfaceC5816d List<? extends CallBean> list) {
        C5544i0.m22546f(list, "callBeans");
        this.mSelectList.clear();
        this.mSelectList.addAll(list);
        SignCallAdapter signCallAdapter = this.mAdapter;
        if (signCallAdapter == null) {
            C5544i0.m22545f();
        }
        signCallAdapter.notifyDataSetChanged();
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@InterfaceC5816d CriminalPhoneNumBean criminalPhoneNumBean) {
        C5544i0.m22546f(criminalPhoneNumBean, "bean");
        CriminalPhoneView.C6814a.m25456a(this, criminalPhoneNumBean);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        CriminalPhoneView.C6814a.m25454a(this);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessSave(@InterfaceC5816d CallBean callBean) {
        C5544i0.m22546f(callBean, "callBeans");
        CriminalPhoneView.C6814a.m25455a(this, callBean);
    }

    @OnClick({C2113R.id.iv_back})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_sign_call;
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
