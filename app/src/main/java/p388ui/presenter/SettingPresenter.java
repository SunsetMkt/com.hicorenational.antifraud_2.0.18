package p388ui.presenter;

import adapter.CheckTimeAdapter;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CheckTimeBean;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import manager.BaseDialog;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.SettingView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7325u1;

/* loaded from: classes2.dex */
public class SettingPresenter extends ModelPresent<SettingView> {
    private BaseDialog dlg;
    private CheckTimeAdapter mAdapter;
    public String mDefaultStr;
    private RecyclerView mRecyclerview;

    /* renamed from: ui.presenter.SettingPresenter$a */
    class C7081a extends MiddleSubscriber<APIresult> {
        C7081a() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((SettingView) SettingPresenter.this.mvpView).onSuccessLoginOut(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            ((SettingView) SettingPresenter.this.mvpView).onSuccessLoginOut(aPIresult);
        }
    }

    public SettingPresenter(Activity activity, SettingView settingView) {
        super(activity, settingView);
        this.mDefaultStr = "每天9点";
    }

    private void initRecycleView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CheckTimeBean(this.mDefaultStr, 1));
        arrayList.add(new CheckTimeBean("每周一9点", 2));
        arrayList.add(new CheckTimeBean("每月初9点", 3));
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new CheckTimeAdapter(C2113R.layout.item_check_time, arrayList);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(new CheckTimeAdapter.InterfaceC0059b() { // from class: ui.presenter.x
            @Override // adapter.CheckTimeAdapter.InterfaceC0059b
            public final void onItemClickListener(int i2, List list) {
                SettingPresenter.this.m25662a(i2, list);
            }
        });
        CheckTimeBean checkTimeBean = (CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            for (CheckTimeBean checkTimeBean2 : this.mAdapter.m5134c()) {
                if (TextUtils.equals(checkTimeBean.getCode() + "", checkTimeBean2.getCode() + "")) {
                    checkTimeBean2.setSelect(true);
                } else {
                    checkTimeBean2.setSelect(false);
                }
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25663a(View view) {
        ((SettingView) this.mvpView).cancleTimeDlg();
        this.dlg.dismiss();
    }

    /* renamed from: b */
    public /* synthetic */ void m25664b(View view) {
        ((SettingView) this.mvpView).ensureTimeDlg();
        this.dlg.dismiss();
    }

    public void closeTimeDlg() {
        BaseDialog baseDialog = this.dlg;
        if (baseDialog == null || !baseDialog.isShowing()) {
            return;
        }
        this.dlg.dismiss();
    }

    public void requestLoginOut() {
        C7257b1.m26203a("退出中...", true, this.mActivity);
        requestLoginOut(C4440a.m16395a("", 1, C4445b.f17006H), new C7081a());
    }

    public void showSelectTimeDlg() {
        BaseDialog baseDialog = this.dlg;
        if (baseDialog != null) {
            baseDialog.show();
            return;
        }
        this.dlg = new BaseDialog(this.mActivity, C2113R.style.base_dialog_style);
        this.dlg.setContentView(C2113R.layout.layout_check_time_setting);
        this.dlg.setGravityLayout(0);
        this.dlg.setWidthDialog(-2.0d);
        this.dlg.setHeightDialogdp(-2.0f);
        this.dlg.setCancelable(false);
        this.dlg.setCanceledOnTouchOutside(false);
        this.dlg.initOnCreate();
        this.dlg.show();
        this.mRecyclerview = (RecyclerView) this.dlg.findViewById(C2113R.id.recyclerview);
        TextView textView = (TextView) this.dlg.findViewById(C2113R.id.cancle);
        TextView textView2 = (TextView) this.dlg.findViewById(C2113R.id.confirm);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingPresenter.this.m25663a(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingPresenter.this.m25664b(view);
            }
        });
        initRecycleView();
    }

    /* renamed from: a */
    public /* synthetic */ void m25662a(int i2, List list) {
        ((SettingView) this.mvpView).onItemClick((CheckTimeBean) list.get(i2));
    }
}
