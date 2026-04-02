package ui.presenter;

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
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import manager.AccountManager;
import manager.BaseDialog;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.MinePersonalActivity;
import ui.callview.MineFagCallView;
import ui.callview.MinePersonalView;
import ui.model.ModelPresent;
import util.c2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class MineFagPresenter extends ModelPresent<MineFagCallView> implements MinePersonalView {
    private BaseDialog dlgComInfo;
    private UserInfoBean resultInfo;

    class a extends MiddleSubscriber<APIresult<RecordCountBean>> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
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
                ((MineFagCallView) MineFagPresenter.this.mvpView).onSuccessRequestReport(this.a, null);
            } else {
                ((MineFagCallView) MineFagPresenter.this.mvpView).onSuccessRequestReport(this.a, data);
            }
        }
    }

    public MineFagPresenter(Activity activity, MineFagCallView mineFagCallView) {
        super(activity, mineFagCallView);
    }

    private void spComInfoDlg(boolean z) {
        if (!z) {
            c2.b(c2.M, g2.d("yyyy-MM-dd"));
        }
        c2.b(c2.L, z);
    }

    public /* synthetic */ void a(View view) {
        this.dlgComInfo.dismiss();
    }

    public /* synthetic */ void b(View view) {
        Activity activity = this.mActivity;
        activity.startActivity(new Intent(activity, (Class<?>) MinePersonalActivity.class));
        this.dlgComInfo.dismiss();
    }

    public void getReportListSize(String str) {
        getReportNum(e.a.b(TextUtils.equals(str, "10111012") ? ModuelConfig.MODEL_REPORT : str, 8, f.b.X), new a(str));
    }

    @Override // ui.callview.MinePersonalView
    public void onFailRequest() {
    }

    @Override // ui.callview.MinePersonalView
    public void onSuccRequest(UserInfoBean userInfoBean) {
        if (userInfoBean != null) {
            this.resultInfo = userInfoBean;
            if (userInfoBean.getErfectProgress() < 100) {
                showComInfoDlg();
            }
        }
    }

    @Override // ui.callview.MinePersonalView
    public void onSuccess(CheckUserBean checkUserBean) {
    }

    public void showComInfo() {
        if (AccountManager.isLogin() && !c2.a(c2.L, false) && !TextUtils.equals(g2.d("yyyy-MM-dd"), c2.a(c2.M, "")) && this.resultInfo == null) {
            new MinePersonalPresenter(this.mActivity, this).getUserInfo();
        }
    }

    public void showComInfoDlg() {
        BaseDialog baseDialog = this.dlgComInfo;
        if (baseDialog == null || !baseDialog.isShowing()) {
            this.dlgComInfo = new BaseDialog(this.mActivity, R.style.base_dialog_style);
            this.dlgComInfo.setContentView(R.layout.complete_info);
            this.dlgComInfo.setGravityLayout(2);
            this.dlgComInfo.setWidthDialog(-2.0d);
            this.dlgComInfo.setHeightDialogdp(-2.0f);
            this.dlgComInfo.setCancelable(false);
            this.dlgComInfo.setCanceledOnTouchOutside(false);
            this.dlgComInfo.initOnCreate();
            this.dlgComInfo.show();
            ImageView imageView = (ImageView) this.dlgComInfo.findViewById(R.id.iv_close);
            CheckBox checkBox = (CheckBox) this.dlgComInfo.findViewById(R.id.cb_select);
            Button button = (Button) this.dlgComInfo.findViewById(R.id.btn_commit);
            spComInfoDlg(false);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(view);
                }
            });
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.presenter.j
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.a.a(compoundButton, z);
                }
            });
        }
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        spComInfoDlg(z);
    }
}
