package ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.callview.LogoutConfirmView;
import ui.presenter.LogoutConfirmPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: compiled from: LogoutConfirmActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lui/activity/LogoutConfirmActivity;", "Lui/activity/BaseActivity;", "Lui/callview/LogoutConfirmView;", "()V", "mCancel", "Landroid/widget/Button;", "getMCancel", "()Landroid/widget/Button;", "setMCancel", "(Landroid/widget/Button;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLogout", "getMLogout", "setMLogout", "mPresenter", "Lui/presenter/LogoutConfirmPresenter;", "getMPresenter", "()Lui/presenter/LogoutConfirmPresenter;", "setMPresenter", "(Lui/presenter/LogoutConfirmPresenter;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "reaseon", "", "initPage", "", "onClick", "view", "Landroid/view/View;", "onSuccessRequest", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class LogoutConfirmActivity extends BaseActivity implements LogoutConfirmView {

    @BindView(R.id.btn_cancel)
    @j.c.a.d
    public Button mCancel;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.btn_logout)
    @j.c.a.d
    public Button mLogout;

    @j.c.a.e
    private LogoutConfirmPresenter mPresenter;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;
    private String reaseon = "";

    @j.c.a.d
    public final Button getMCancel() {
        Button button = this.mCancel;
        if (button == null) {
            i.q2.t.i0.k("mCancel");
        }
        return button;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final Button getMLogout() {
        Button button = this.mLogout;
        if (button == null) {
            i.q2.t.i0.k("mLogout");
        }
        return button;
    }

    @j.c.a.e
    public final LogoutConfirmPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        Activity activity = this.mActivity;
        i.q2.t.i0.a((Object) activity, "mActivity");
        this.mPresenter = new LogoutConfirmPresenter(activity, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u6ce8\u9500\u8d26\u53f7");
        String stringExtra = getIntent().getStringExtra(util.p1.f0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.reaseon = stringExtra;
    }

    @OnClick({R.id.iv_back, R.id.btn_logout, R.id.btn_cancel})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_cancel) {
            ui.c.i().f();
            finish();
        } else {
            if (id != R.id.btn_logout) {
                if (id != R.id.iv_back) {
                    return;
                }
                ui.c.i().f();
                finish();
                return;
            }
            LogoutConfirmPresenter logoutConfirmPresenter = this.mPresenter;
            if (logoutConfirmPresenter != null) {
                logoutConfirmPresenter.loginOff(this.reaseon);
            }
        }
    }

    @Override // ui.callview.LogoutConfirmView
    public void onSuccessRequest() {
        e2.a("\u6ce8\u9500\u6210\u529f~");
        startActivity(LogoutSuccActivity.class);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_logout_confirm;
    }

    public final void setMCancel(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mCancel = button;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLogout(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mLogout = button;
    }

    public final void setMPresenter(@j.c.a.e LogoutConfirmPresenter logoutConfirmPresenter) {
        this.mPresenter = logoutConfirmPresenter;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
