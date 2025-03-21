package p388ui.activity;

import adapter.CallRecordSelectAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.Hicore;
import p388ui.callview.CriminalPhoneView;
import p388ui.presenter.CriminalPhonePresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* compiled from: CallActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020-J\b\u00101\u001a\u00020-H\u0016J*\u00102\u001a\u00020-2\u0010\u00103\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020-H\u0014J\u0016\u00109\u001a\u00020-2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c0;H\u0016J\b\u0010<\u001a\u00020-H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u00105\u001a\u000206H\u0007J\u0006\u0010>\u001a\u00020/J\b\u0010?\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u00107\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001e\u0010&\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001e\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"¨\u0006A"}, m23546d2 = {"Lui/activity/CallActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/CriminalPhoneView;", "()V", "caseInfoId", "", "itemPot", "", "mAdapter", "Ladapter/CallRecordSelectAdapter;", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mMaxSelectNum", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mSelectList", "", "Lbean/CallBean;", "mTvCommitTip", "Landroid/widget/TextView;", "getMTvCommitTip", "()Landroid/widget/TextView;", "setMTvCommitTip", "(Landroid/widget/TextView;)V", "mTvInputTip", "getMTvInputTip", "setMTvInputTip", "mTvSelectTip", "getMTvSelectTip", "setMTvSelectTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "checkPermission", "", "hasYourselfPhone", "", "initAdapter", "initPage", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "onResume", "onSuccessList", "callBeans", "", "onSuccessRemove", "onViewClicked", "rejuctOperation", "setLayoutView", "turnEditPage", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CallActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i, CriminalPhoneView {
    private String caseInfoId;
    private int itemPot;
    private CallRecordSelectAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    @InterfaceC5816d
    public Button mBtnCommit;
    private CriminalPhonePresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    @InterfaceC5816d
    public TextView mTvCommitTip;

    @BindView(C2113R.id.tv_input_tip)
    @InterfaceC5816d
    public TextView mTvInputTip;

    @BindView(C2113R.id.tv_select_tip)
    @InterfaceC5816d
    public TextView mTvSelectTip;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private List<CallBean> mSelectList = new ArrayList();
    private final int mMaxSelectNum = 20;

    /* compiled from: CallActivity.kt */
    /* renamed from: ui.activity.CallActivity$a */
    public static final class C6155a implements PermissionsListener {
        C6155a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@InterfaceC5816d List<String> list, boolean z) {
            C5544i0.m22546f(list, "deniedPermissions");
            C7310c.m26513a(CallActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = CallActivity.this.mSelectList != null ? CallActivity.this.mSelectList.size() : 0;
            Intent intent = new Intent(CallActivity.this.mActivity, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_limite", 1);
            intent.putExtra(C7292k1.f25338C0, CallActivity.this.caseInfoId);
            intent.putExtra("extra_select_can", CallActivity.this.mMaxSelectNum - size);
            List list = CallActivity.this.mSelectList;
            if (list == null) {
                throw new C5226e1("null cannot be cast to non-null type java.io.Serializable");
            }
            intent.putExtra(C7292k1.f25391c, (Serializable) list);
            CallActivity.this.startActivity(intent);
        }
    }

    /* compiled from: CallActivity.kt */
    /* renamed from: ui.activity.CallActivity$b */
    public static final class C6156b implements IClickListener {

        /* renamed from: b */
        final /* synthetic */ int f21898b;

        C6156b(int i2) {
            this.f21898b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CallActivity.this.itemPot = this.f21898b;
            CallBean callBean = (CallBean) CallActivity.this.mSelectList.get(this.f21898b);
            CriminalPhonePresenter criminalPhonePresenter = CallActivity.this.mPresenter;
            if (criminalPhonePresenter == null) {
                C5544i0.m22545f();
            }
            String str = CallActivity.this.caseInfoId;
            if (str == null) {
                C5544i0.m22545f();
            }
            String callTelInfoID = callBean.getCallTelInfoID();
            C5544i0.m22521a((Object) callTelInfoID, "bean.callTelInfoID");
            criminalPhonePresenter.removecalltel(str, callTelInfoID);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private final void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25533l}, new C6155a());
    }

    private final boolean hasYourselfPhone() {
        String visiblePhone = AccountManager.getVisiblePhone();
        Iterator<CallBean> it = this.mSelectList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(visiblePhone, it.next().getNumber())) {
                return true;
            }
        }
        return false;
    }

    private final void turnEditPage(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) CriminalCallAddActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        List<CallBean> list = this.mSelectList;
        if (list == null) {
            throw new C5226e1("null cannot be cast to non-null type java.io.Serializable");
        }
        intent.putExtra(C7292k1.f25391c, (Serializable) list);
        intent.putExtra(C7292k1.f25397e, i2);
        startActivity(intent);
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
    public final TextView getMTvCommitTip() {
        TextView textView = this.mTvCommitTip;
        if (textView == null) {
            C5544i0.m22554k("mTvCommitTip");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvInputTip() {
        TextView textView = this.mTvInputTip;
        if (textView == null) {
            C5544i0.m22554k("mTvInputTip");
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

    public final void initAdapter() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        if (recyclerView == null) {
            C5544i0.m22545f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new CallRecordSelectAdapter(C2113R.layout.recyclerview_call_criminal, this.mSelectList);
        CallRecordSelectAdapter callRecordSelectAdapter = this.mAdapter;
        if (callRecordSelectAdapter == null) {
            C5544i0.m22545f();
        }
        RecyclerView recyclerView2 = this.mRecyclerview;
        if (recyclerView2 == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        callRecordSelectAdapter.m5103a(recyclerView2);
        RecyclerView recyclerView3 = this.mRecyclerview;
        if (recyclerView3 == null) {
            C5544i0.m22554k("mRecyclerview");
        }
        if (recyclerView3 == null) {
            C5544i0.m22545f();
        }
        recyclerView3.setAdapter(this.mAdapter);
        CallRecordSelectAdapter callRecordSelectAdapter2 = this.mAdapter;
        if (callRecordSelectAdapter2 == null) {
            C5544i0.m22545f();
        }
        callRecordSelectAdapter2.setOnItemChildClickListener(this);
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
        textView.setText("添加通话类嫌疑人电话");
        TextView textView2 = this.mTvSelectTip;
        if (textView2 == null) {
            C5544i0.m22554k("mTvSelectTip");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setText("选择通话记录");
        TextView textView3 = this.mTvSelectTip;
        if (textView3 == null) {
            C5544i0.m22554k("mTvSelectTip");
        }
        if (textView3 == null) {
            C5544i0.m22545f();
        }
        textView3.setTextColor(Color.parseColor("#2D4AEB"));
        TextView textView4 = this.mTvInputTip;
        if (textView4 == null) {
            C5544i0.m22554k("mTvInputTip");
        }
        if (textView4 == null) {
            C5544i0.m22545f();
        }
        textView4.setText("手动输入");
        TextView textView5 = this.mTvInputTip;
        if (textView5 == null) {
            C5544i0.m22554k("mTvInputTip");
        }
        if (textView5 == null) {
            C5544i0.m22545f();
        }
        textView5.setTextColor(Color.parseColor("#2D4AEB"));
        TextView textView6 = this.mTvCommitTip;
        if (textView6 == null) {
            C5544i0.m22554k("mTvCommitTip");
        }
        if (textView6 == null) {
            C5544i0.m22545f();
        }
        textView6.setText("最多可添加" + this.mMaxSelectNum + "条通话类嫌疑人电话");
        this.caseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.mPresenter = new CriminalPhonePresenter(activity, this);
        initAdapter();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(@InterfaceC5817e BaseQuickAdapter<?, ?> baseQuickAdapter, @InterfaceC5816d View view, int i2) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_clear) {
            C7257b1.m26211b(this.mActivity, "删除当前通话类信息？", "", "确定", "取消", new C6156b(i2));
        } else {
            if (id != C2113R.id.iv_edit) {
                return;
            }
            turnEditPage(i2);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
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
        CallRecordSelectAdapter callRecordSelectAdapter = this.mAdapter;
        if (callRecordSelectAdapter == null) {
            C5544i0.m22545f();
        }
        callRecordSelectAdapter.notifyDataSetChanged();
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@InterfaceC5816d CriminalPhoneNumBean criminalPhoneNumBean) {
        C5544i0.m22546f(criminalPhoneNumBean, "bean");
        CriminalPhoneView.C6814a.m25456a(this, criminalPhoneNumBean);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        List<CallBean> list = this.mSelectList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mSelectList.remove(this.mSelectList.get(this.itemPot));
        CallRecordSelectAdapter callRecordSelectAdapter = this.mAdapter;
        if (callRecordSelectAdapter == null) {
            C5544i0.m22545f();
        }
        callRecordSelectAdapter.notifyDataSetChanged();
        C7331w1.m26688a("删除成功");
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessSave(@InterfaceC5816d CallBean callBean) {
        C5544i0.m22546f(callBean, "callBeans");
        CriminalPhoneView.C6814a.m25455a(this, callBean);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.ll_input, C2113R.id.btn_commit})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                finish();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.ll_input /* 2131296950 */:
                if (!rejuctOperation()) {
                    turnEditPage(-1);
                    break;
                }
                break;
            case C2113R.id.ll_select /* 2131296984 */:
                if (!rejuctOperation()) {
                    checkPermission();
                    break;
                }
                break;
        }
    }

    public final boolean rejuctOperation() {
        List<CallBean> list = this.mSelectList;
        if (list == null || list.size() != this.mMaxSelectNum) {
            return false;
        }
        C7331w1.m26688a("最多可添加" + this.mMaxSelectNum + "条通话类嫌疑人电话");
        return true;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call;
    }

    public final void setMBtnCommit(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMRecyclerview(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyclerview = recyclerView;
    }

    public final void setMTvCommitTip(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCommitTip = textView;
    }

    public final void setMTvInputTip(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvInputTip = textView;
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
