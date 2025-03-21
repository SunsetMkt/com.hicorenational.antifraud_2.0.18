package p388ui.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import bean.CheckUserBean;
import bean.RecordCountBean;
import bean.UserInfoBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import manager.AccountManager;
import manager.BaseDialog;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.MinePersonalActivity;
import p388ui.callview.MineFagCallView;
import p388ui.callview.MinePersonalView;
import p388ui.model.ModelPresent;
import util.C7325u1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class MineFagPresenter extends ModelPresent<MineFagCallView> implements MinePersonalView {
    private BaseDialog dlgComInfo;
    private UserInfoBean resultInfo;

    /* renamed from: ui.presenter.MineFagPresenter$a */
    class C7028a extends MiddleSubscriber<APIresult<RecordCountBean>> {

        /* renamed from: a */
        final /* synthetic */ String f24163a;

        C7028a(String str) {
            this.f24163a = str;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return RecordCountBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((MineFagCallView) MineFagPresenter.this.mvpView).onFailRequestReport();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<RecordCountBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            RecordCountBean data = aPIresult.getData();
            if (data == null) {
                ((MineFagCallView) MineFagPresenter.this.mvpView).onSuccessRequestReport(this.f24163a, null);
            } else {
                ((MineFagCallView) MineFagPresenter.this.mvpView).onSuccessRequestReport(this.f24163a, data);
            }
        }
    }

    public MineFagPresenter(Activity activity, MineFagCallView mineFagCallView) {
        super(activity, mineFagCallView);
    }

    private void spComInfoDlg(boolean z) {
        if (!z) {
            C7325u1.m26630b(C7325u1.f25646M, C7337y1.m26775d("yyyy-MM-dd"));
        }
        C7325u1.m26631b(C7325u1.f25645L, z);
    }

    /* renamed from: a */
    public /* synthetic */ void m25640a(View view) {
        this.dlgComInfo.dismiss();
    }

    /* renamed from: b */
    public /* synthetic */ void m25642b(View view) {
        Activity activity = this.mActivity;
        activity.startActivity(new Intent(activity, (Class<?>) MinePersonalActivity.class));
        this.dlgComInfo.dismiss();
    }

    public void getReportListSize(String str) {
        getReportNum(C4440a.m16395a(TextUtils.equals(str, "10111012") ? ModuelConfig.MODEL_REPORT : str, 8, C4445b.f17051W), new C7028a(str));
    }

    @Override // p388ui.callview.MinePersonalView
    public void onFailRequest() {
    }

    @Override // p388ui.callview.MinePersonalView
    public void onSuccRequest(UserInfoBean userInfoBean) {
        if (userInfoBean != null) {
            this.resultInfo = userInfoBean;
            if (userInfoBean.getErfectProgress() < 100) {
                showComInfoDlg();
            }
        }
    }

    @Override // p388ui.callview.MinePersonalView
    public void onSuccess(CheckUserBean checkUserBean) {
    }

    public void showComInfo() {
        if (AccountManager.isLogin() && !C7325u1.m26623a(C7325u1.f25645L, false) && !TextUtils.equals(C7337y1.m26775d("yyyy-MM-dd"), C7325u1.m26616a(C7325u1.f25646M, "")) && this.resultInfo == null) {
            new MinePersonalPresenter(this.mActivity, this).getUserInfo();
        }
    }

    public void showComInfoDlg() {
        BaseDialog baseDialog = this.dlgComInfo;
        if (baseDialog == null || !baseDialog.isShowing()) {
            this.dlgComInfo = new BaseDialog(this.mActivity, C2113R.style.base_dialog_style);
            this.dlgComInfo.setContentView(C2113R.layout.complete_info);
            this.dlgComInfo.setGravityLayout(2);
            this.dlgComInfo.setWidthDialog(-2.0d);
            this.dlgComInfo.setHeightDialogdp(-2.0f);
            this.dlgComInfo.setCancelable(false);
            this.dlgComInfo.setCanceledOnTouchOutside(false);
            this.dlgComInfo.initOnCreate();
            this.dlgComInfo.show();
            ImageView imageView = (ImageView) this.dlgComInfo.findViewById(C2113R.id.iv_close);
            CheckBox checkBox = (CheckBox) this.dlgComInfo.findViewById(C2113R.id.cb_select);
            Button button = (Button) this.dlgComInfo.findViewById(C2113R.id.btn_commit);
            spComInfoDlg(false);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineFagPresenter.this.m25640a(view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineFagPresenter.this.m25642b(view);
                }
            });
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.presenter.j
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    MineFagPresenter.this.m25641a(compoundButton, z);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25641a(CompoundButton compoundButton, boolean z) {
        spComInfoDlg(z);
    }
}
