package p388ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.C6813c;
import p388ui.callview.LogoutConfirmView;
import p388ui.presenter.LogoutConfirmPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7331w1;

/* compiled from: LogoutConfirmActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m23546d2 = {"Lui/activity/LogoutConfirmActivity;", "Lui/activity/BaseActivity;", "Lui/callview/LogoutConfirmView;", "()V", "mCancel", "Landroid/widget/Button;", "getMCancel", "()Landroid/widget/Button;", "setMCancel", "(Landroid/widget/Button;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLogout", "getMLogout", "setMLogout", "mPresenter", "Lui/presenter/LogoutConfirmPresenter;", "getMPresenter", "()Lui/presenter/LogoutConfirmPresenter;", "setMPresenter", "(Lui/presenter/LogoutConfirmPresenter;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "reaseon", "", "initPage", "", "onClick", "view", "Landroid/view/View;", "onSuccessRequest", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutConfirmActivity extends BaseActivity implements LogoutConfirmView {

    @BindView(C2113R.id.btn_cancel)
    @InterfaceC5816d
    public Button mCancel;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.btn_logout)
    @InterfaceC5816d
    public Button mLogout;

    @InterfaceC5817e
    private LogoutConfirmPresenter mPresenter;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private String reaseon = "";

    @InterfaceC5816d
    public final Button getMCancel() {
        Button button = this.mCancel;
        if (button == null) {
            C5544i0.m22554k("mCancel");
        }
        return button;
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
    public final Button getMLogout() {
        Button button = this.mLogout;
        if (button == null) {
            C5544i0.m22554k("mLogout");
        }
        return button;
    }

    @InterfaceC5817e
    public final LogoutConfirmPresenter getMPresenter() {
        return this.mPresenter;
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
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.mPresenter = new LogoutConfirmPresenter(activity, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("注销账号");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25401f0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.reaseon = stringExtra;
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_logout, C2113R.id.btn_cancel})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.btn_cancel) {
            C6813c.m25437i().m25451f();
            finish();
        } else {
            if (id != C2113R.id.btn_logout) {
                if (id != C2113R.id.iv_back) {
                    return;
                }
                C6813c.m25437i().m25451f();
                finish();
                return;
            }
            LogoutConfirmPresenter logoutConfirmPresenter = this.mPresenter;
            if (logoutConfirmPresenter != null) {
                logoutConfirmPresenter.loginOff(this.reaseon);
            }
        }
    }

    @Override // p388ui.callview.LogoutConfirmView
    public void onSuccessRequest() {
        C7331w1.m26688a("注销成功~");
        startActivity(LogoutSuccActivity.class);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_logout_confirm;
    }

    public final void setMCancel(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mCancel = button;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLogout(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mLogout = button;
    }

    public final void setMPresenter(@InterfaceC5817e LogoutConfirmPresenter logoutConfirmPresenter) {
        this.mPresenter = logoutConfirmPresenter;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
