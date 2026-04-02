package ui.activity;

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
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import ui.Hicore;
import ui.callview.CriminalPhoneView;
import ui.presenter.CriminalPhonePresenter;
import util.e2;

/* JADX INFO: compiled from: CallActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020-J\b\u00101\u001a\u00020-H\u0016J*\u00102\u001a\u00020-2\u0010\u00103\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020-H\u0014J\u0016\u00109\u001a\u00020-2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c0;H\u0016J\b\u0010<\u001a\u00020-H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u00105\u001a\u000206H\u0007J\u0006\u0010>\u001a\u00020/J\b\u0010?\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u00107\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001e\u0010&\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001e\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"\u00a8\u0006A"}, d2 = {"Lui/activity/CallActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/CriminalPhoneView;", "()V", "caseInfoId", "", "itemPot", "", "mAdapter", "Ladapter/CallRecordSelectAdapter;", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mMaxSelectNum", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mSelectList", "", "Lbean/CallBean;", "mTvCommitTip", "Landroid/widget/TextView;", "getMTvCommitTip", "()Landroid/widget/TextView;", "setMTvCommitTip", "(Landroid/widget/TextView;)V", "mTvInputTip", "getMTvInputTip", "setMTvInputTip", "mTvSelectTip", "getMTvSelectTip", "setMTvSelectTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "checkPermission", "", "hasYourselfPhone", "", "initAdapter", "initPage", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "onResume", "onSuccessList", "callBeans", "", "onSuccessRemove", "onViewClicked", "rejuctOperation", "setLayoutView", "turnEditPage", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class CallActivity extends BaseActivity implements BaseQuickAdapter.i, CriminalPhoneView {
    private String caseInfoId;
    private int itemPot;
    private CallRecordSelectAdapter mAdapter;

    @BindView(R.id.btn_commit)
    @j.c.a.d
    public Button mBtnCommit;
    private CriminalPhonePresenter mPresenter;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    @j.c.a.d
    public TextView mTvCommitTip;

    @BindView(R.id.tv_input_tip)
    @j.c.a.d
    public TextView mTvInputTip;

    @BindView(R.id.tv_select_tip)
    @j.c.a.d
    public TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;
    private List<CallBean> mSelectList = new ArrayList();
    private final int mMaxSelectNum = 20;

    /* JADX INFO: compiled from: CallActivity.kt */
    public static final class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@j.c.a.d List<String> list, boolean z) {
            i.q2.t.i0.f(list, "deniedPermissions");
            util.permissionutil.c.a(CallActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = CallActivity.this.mSelectList != null ? CallActivity.this.mSelectList.size() : 0;
            Intent intent = new Intent(CallActivity.this.mActivity, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_limite", 1);
            intent.putExtra(util.p1.C0, CallActivity.this.caseInfoId);
            intent.putExtra("extra_select_can", CallActivity.this.mMaxSelectNum - size);
            List list = CallActivity.this.mSelectList;
            if (list == null) {
                throw new i.e1("null cannot be cast to non-null type java.io.Serializable");
            }
            intent.putExtra(util.p1.f15011c, (Serializable) list);
            CallActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: CallActivity.kt */
    public static final class b implements IClickListener {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f13130b;

        b(int i2) {
            this.f13130b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CallActivity.this.itemPot = this.f13130b;
            CallBean callBean = (CallBean) CallActivity.this.mSelectList.get(this.f13130b);
            CriminalPhonePresenter criminalPhonePresenter = CallActivity.this.mPresenter;
            if (criminalPhonePresenter == null) {
                i.q2.t.i0.f();
            }
            String str = CallActivity.this.caseInfoId;
            if (str == null) {
                i.q2.t.i0.f();
            }
            String callTelInfoID = callBean.getCallTelInfoID();
            i.q2.t.i0.a((Object) callTelInfoID, "bean.callTelInfoID");
            criminalPhonePresenter.removecalltel(str, callTelInfoID);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private final void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f15035l}, new a());
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
        intent.putExtra(util.p1.C0, this.caseInfoId);
        List<CallBean> list = this.mSelectList;
        if (list == null) {
            throw new i.e1("null cannot be cast to non-null type java.io.Serializable");
        }
        intent.putExtra(util.p1.f15011c, (Serializable) list);
        intent.putExtra(util.p1.f15013e, i2);
        startActivity(intent);
    }

    @j.c.a.d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            i.q2.t.i0.k("mBtnCommit");
        }
        return button;
    }

    @j.c.a.d
    public final RecyclerView getMRecyclerview() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecyclerview");
        }
        return recyclerView;
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
    public final TextView getMTvInputTip() {
        TextView textView = this.mTvInputTip;
        if (textView == null) {
            i.q2.t.i0.k("mTvInputTip");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvSelectTip() {
        TextView textView = this.mTvSelectTip;
        if (textView == null) {
            i.q2.t.i0.k("mTvSelectTip");
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

    public final void initAdapter() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecyclerview");
        }
        if (recyclerView == null) {
            i.q2.t.i0.f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new CallRecordSelectAdapter(R.layout.recyclerview_call_criminal, this.mSelectList);
        CallRecordSelectAdapter callRecordSelectAdapter = this.mAdapter;
        if (callRecordSelectAdapter == null) {
            i.q2.t.i0.f();
        }
        RecyclerView recyclerView2 = this.mRecyclerview;
        if (recyclerView2 == null) {
            i.q2.t.i0.k("mRecyclerview");
        }
        callRecordSelectAdapter.a(recyclerView2);
        RecyclerView recyclerView3 = this.mRecyclerview;
        if (recyclerView3 == null) {
            i.q2.t.i0.k("mRecyclerview");
        }
        if (recyclerView3 == null) {
            i.q2.t.i0.f();
        }
        recyclerView3.setAdapter(this.mAdapter);
        CallRecordSelectAdapter callRecordSelectAdapter2 = this.mAdapter;
        if (callRecordSelectAdapter2 == null) {
            i.q2.t.i0.f();
        }
        callRecordSelectAdapter2.setOnItemChildClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u6dfb\u52a0\u901a\u8bdd\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd");
        TextView textView2 = this.mTvSelectTip;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvSelectTip");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        textView2.setText("\u9009\u62e9\u901a\u8bdd\u8bb0\u5f55");
        TextView textView3 = this.mTvSelectTip;
        if (textView3 == null) {
            i.q2.t.i0.k("mTvSelectTip");
        }
        if (textView3 == null) {
            i.q2.t.i0.f();
        }
        textView3.setTextColor(Color.parseColor("#2D4AEB"));
        TextView textView4 = this.mTvInputTip;
        if (textView4 == null) {
            i.q2.t.i0.k("mTvInputTip");
        }
        if (textView4 == null) {
            i.q2.t.i0.f();
        }
        textView4.setText("\u624b\u52a8\u8f93\u5165");
        TextView textView5 = this.mTvInputTip;
        if (textView5 == null) {
            i.q2.t.i0.k("mTvInputTip");
        }
        if (textView5 == null) {
            i.q2.t.i0.f();
        }
        textView5.setTextColor(Color.parseColor("#2D4AEB"));
        TextView textView6 = this.mTvCommitTip;
        if (textView6 == null) {
            i.q2.t.i0.k("mTvCommitTip");
        }
        if (textView6 == null) {
            i.q2.t.i0.f();
        }
        textView6.setText("\u6700\u591a\u53ef\u6dfb\u52a0" + this.mMaxSelectNum + "\u6761\u901a\u8bdd\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd");
        this.caseInfoId = getIntent().getStringExtra(util.p1.C0);
        Activity activity = this.mActivity;
        i.q2.t.i0.a((Object) activity, "mActivity");
        this.mPresenter = new CriminalPhonePresenter(activity, this);
        initAdapter();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(@j.c.a.e BaseQuickAdapter<?, ?> baseQuickAdapter, @j.c.a.d View view, int i2) {
        i.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        i.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_clear) {
            util.f1.b(this.mActivity, "\u5220\u9664\u5f53\u524d\u901a\u8bdd\u7c7b\u4fe1\u606f\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", new b(i2));
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            turnEditPage(i2);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            i.q2.t.i0.f();
        }
        String str = this.caseInfoId;
        if (str == null) {
            i.q2.t.i0.f();
        }
        criminalPhonePresenter.getCriminalCallList(str);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccess(@j.c.a.d List<String> list) {
        i.q2.t.i0.f(list, "CNATelList");
        CriminalPhoneView.a.a(this, list);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessList(@j.c.a.d List<? extends CallBean> list) {
        i.q2.t.i0.f(list, "callBeans");
        this.mSelectList.clear();
        this.mSelectList.addAll(list);
        CallRecordSelectAdapter callRecordSelectAdapter = this.mAdapter;
        if (callRecordSelectAdapter == null) {
            i.q2.t.i0.f();
        }
        callRecordSelectAdapter.notifyDataSetChanged();
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@j.c.a.d CriminalPhoneNumBean criminalPhoneNumBean) {
        i.q2.t.i0.f(criminalPhoneNumBean, "bean");
        CriminalPhoneView.a.a(this, criminalPhoneNumBean);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        List<CallBean> list = this.mSelectList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mSelectList.remove(this.mSelectList.get(this.itemPot));
        CallRecordSelectAdapter callRecordSelectAdapter = this.mAdapter;
        if (callRecordSelectAdapter == null) {
            i.q2.t.i0.f();
        }
        callRecordSelectAdapter.notifyDataSetChanged();
        e2.a("\u5220\u9664\u6210\u529f");
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessSave(@j.c.a.d CallBean callBean) {
        i.q2.t.i0.f(callBean, "callBeans");
        CriminalPhoneView.a.a(this, callBean);
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.ll_input, R.id.btn_commit})
    public final void onViewClicked(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        i.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                finish();
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.ll_input /* 2131297000 */:
                if (!rejuctOperation()) {
                    turnEditPage(-1);
                    break;
                }
                break;
            case R.id.ll_select /* 2131297034 */:
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
        e2.a("\u6700\u591a\u53ef\u6dfb\u52a0" + this.mMaxSelectNum + "\u6761\u901a\u8bdd\u7c7b\u5acc\u7591\u4eba\u7535\u8bdd");
        return true;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call;
    }

    public final void setMBtnCommit(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMRecyclerview(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyclerview = recyclerView;
    }

    public final void setMTvCommitTip(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCommitTip = textView;
    }

    public final void setMTvInputTip(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvInputTip = textView;
    }

    public final void setMTvSelectTip(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvSelectTip = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
