package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.PolicBean;
import bean.PolicStistBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import network.http.StatisticsHttp;
import p245d.C4441b;
import p247e.C4447d;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.PolicInfoView;
import p388ui.presenter.PolicInfoPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7337y1;

/* compiled from: PoliceInfoActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\u0006\u0010-\u001a\u00020,J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0007J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0006\u0010:\u001a\u00020,J\b\u0010;\u001a\u000204H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u001e\u0010(\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001e¨\u0006<"}, m23546d2 = {"Lui/activity/PoliceInfoActivity;", "Lui/activity/BaseActivity;", "Lui/callview/PolicInfoView;", "()V", "mBean", "Lbean/PolicBean;", "getMBean", "()Lbean/PolicBean;", "setMBean", "(Lbean/PolicBean;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mIvRight", "getMIvRight", "setMIvRight", "mPresenter", "Lui/presenter/PolicInfoPresenter;", "getMPresenter", "()Lui/presenter/PolicInfoPresenter;", "setMPresenter", "(Lui/presenter/PolicInfoPresenter;)V", "mTvDownApp", "Landroid/widget/TextView;", "getMTvDownApp", "()Landroid/widget/TextView;", "setMTvDownApp", "(Landroid/widget/TextView;)V", "mTvInviteNum", "getMTvInviteNum", "setMTvInviteNum", "mTvPhoneNum", "getMTvPhoneNum", "setMTvPhoneNum", "mTvRegistNum", "getMTvRegistNum", "setMTvRegistNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSuccessRequest", "bean", "Lbean/PolicStistBean;", "onkeyback", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class PoliceInfoActivity extends BaseActivity implements PolicInfoView {

    @InterfaceC5817e
    private PolicBean mBean;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.iv_right)
    @InterfaceC5816d
    public ImageView mIvRight;

    @InterfaceC5817e
    private PolicInfoPresenter mPresenter;

    @BindView(C2113R.id.tv_doapp_num)
    @InterfaceC5816d
    public TextView mTvDownApp;

    @BindView(C2113R.id.tv_invite_num)
    @InterfaceC5816d
    public TextView mTvInviteNum;

    @BindView(C2113R.id.tv_phone_num)
    @InterfaceC5816d
    public TextView mTvPhoneNum;

    @BindView(C2113R.id.tv_regist_num)
    @InterfaceC5816d
    public TextView mTvRegistNum;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* compiled from: PoliceInfoActivity.kt */
    /* renamed from: ui.activity.PoliceInfoActivity$a */
    public static final class C6429a implements IClickListener {
        C6429a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            PolicInfoPresenter mPresenter = PoliceInfoActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.policUserLogout();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @InterfaceC5817e
    public final PolicBean getMBean() {
        return this.mBean;
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
    public final ImageView getMIvRight() {
        ImageView imageView = this.mIvRight;
        if (imageView == null) {
            C5544i0.m22554k("mIvRight");
        }
        return imageView;
    }

    @InterfaceC5817e
    public final PolicInfoPresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final TextView getMTvDownApp() {
        TextView textView = this.mTvDownApp;
        if (textView == null) {
            C5544i0.m22554k("mTvDownApp");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvInviteNum() {
        TextView textView = this.mTvInviteNum;
        if (textView == null) {
            C5544i0.m22554k("mTvInviteNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvPhoneNum() {
        TextView textView = this.mTvPhoneNum;
        if (textView == null) {
            C5544i0.m22554k("mTvPhoneNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvRegistNum() {
        TextView textView = this.mTvRegistNum;
        if (textView == null) {
            C5544i0.m22554k("mTvRegistNum");
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
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17162i);
        C7161b.m25698a((Activity) this, true, false);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        initView();
    }

    public final void initView() {
        ImageView imageView = this.mIvRight;
        if (imageView == null) {
            C5544i0.m22554k("mIvRight");
        }
        imageView.setBackgroundResource(C2113R.drawable.iv_polic_exit);
        this.mPresenter = new PolicInfoPresenter(this.mActivity, this);
        this.mBean = C4441b.m16412a();
        TextView textView = this.mTvPhoneNum;
        if (textView == null) {
            C5544i0.m22554k("mTvPhoneNum");
        }
        PolicBean policBean = this.mBean;
        textView.setText(C7337y1.m26787l(String.valueOf(policBean != null ? policBean.getTelNumber() : null)));
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_right, C2113R.id.tv_case_manger, C2113R.id.tv_manual, C2113R.id.tv_invite_qrcode})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case C2113R.id.iv_right /* 2131296826 */:
                C7257b1.m26211b(this.mActivity, "退出当前账号", "", "确定", "取消", new C6429a());
                break;
            case C2113R.id.tv_case_manger /* 2131297455 */:
                startActivity(new Intent(this, (Class<?>) CaseActivity.class));
                break;
            case C2113R.id.tv_invite_qrcode /* 2131297578 */:
                startActivity(new Intent(this, (Class<?>) InviteQrcodeActivity.class));
                break;
            case C2113R.id.tv_manual /* 2131297589 */:
                startActivity(ManualActivity.class);
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @InterfaceC5816d KeyEvent keyEvent) {
        C5544i0.m22546f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.callview.PolicInfoView
    public void onSuccessRequest(@InterfaceC5817e PolicStistBean policStistBean) {
        TextView textView = this.mTvInviteNum;
        if (textView == null) {
            C5544i0.m22554k("mTvInviteNum");
        }
        textView.setText(String.valueOf(policStistBean != null ? Integer.valueOf(policStistBean.getQrCodeScanCount()) : null));
        TextView textView2 = this.mTvDownApp;
        if (textView2 == null) {
            C5544i0.m22554k("mTvDownApp");
        }
        textView2.setText(String.valueOf(policStistBean != null ? Integer.valueOf(policStistBean.getDownloadCount()) : null));
        TextView textView3 = this.mTvRegistNum;
        if (textView3 == null) {
            C5544i0.m22554k("mTvRegistNum");
        }
        textView3.setText(String.valueOf(policStistBean != null ? Integer.valueOf(policStistBean.getRegisteCount()) : null));
    }

    public final void onkeyback() {
        onBackPressed();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_polic_info;
    }

    public final void setMBean(@InterfaceC5817e PolicBean policBean) {
        this.mBean = policBean;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMIvRight(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvRight = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e PolicInfoPresenter policInfoPresenter) {
        this.mPresenter = policInfoPresenter;
    }

    public final void setMTvDownApp(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvDownApp = textView;
    }

    public final void setMTvInviteNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvInviteNum = textView;
    }

    public final void setMTvPhoneNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPhoneNum = textView;
    }

    public final void setMTvRegistNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvRegistNum = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
