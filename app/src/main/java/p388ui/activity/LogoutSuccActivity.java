package p388ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Arrays;
import manager.AccountManager;
import manager.LoginManager;
import network.account.AccountInfo;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5557m1;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7337y1;

/* compiled from: LogoutSuccActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0013R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001a"}, m23546d2 = {"Lui/activity/LogoutSuccActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mTvAccTips", "Landroid/widget/TextView;", "getMTvAccTips", "()Landroid/widget/TextView;", "setMTvAccTips", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "unBindOuthLogin", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutSuccActivity extends BaseActivity {

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.tv_acc_tips)
    @InterfaceC5816d
    public TextView mTvAccTips;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5816d
    /* renamed from: a */
    public final TextView m25282a() {
        TextView textView = this.mTvAccTips;
        if (textView == null) {
            C5544i0.m22554k("mTvAccTips");
        }
        return textView;
    }

    /* renamed from: b */
    public final void m25284b() {
        if (AccountManager.getAccountInfo() != null) {
            AccountInfo accountInfo = AccountManager.getAccountInfo();
            C5544i0.m22521a((Object) accountInfo, "AccountManager.getAccountInfo()");
            int loginType = accountInfo.getLoginType();
            if (loginType > 0) {
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (loginType == AccountManager.LOGIN_QQ) {
                    share_media = SHARE_MEDIA.QQ;
                } else if (loginType == AccountManager.LOGIN_WX) {
                    share_media = SHARE_MEDIA.WEIXIN;
                } else if (loginType == AccountManager.LOGIN_SINA) {
                    share_media = SHARE_MEDIA.SINA;
                }
                UMShareAPI.get(this.mActivity).deleteOauth(this.mActivity, share_media, null);
            }
        }
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
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("注销账号");
        TextView textView2 = this.mTvAccTips;
        if (textView2 == null) {
            C5544i0.m22554k("mTvAccTips");
        }
        C5557m1 c5557m1 = C5557m1.f20400a;
        String string = getResources().getString(C2113R.string.succ_logout_tips);
        C5544i0.m22521a((Object) string, "resources.getString(R.string.succ_logout_tips)");
        Object[] objArr = {C7337y1.m26787l(AccountManager.getAccountPhone())};
        String format = String.format(string, Arrays.copyOf(objArr, objArr.length));
        C5544i0.m22521a((Object) format, "java.lang.String.format(format, *args)");
        textView2.setText(format);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_confirm})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.btn_confirm) {
            m25284b();
            LoginManager.getInstance().exitoLoginNoPhone();
        } else {
            if (id != C2113R.id.iv_back) {
                return;
            }
            m25284b();
            LoginManager.getInstance().exitoLoginNoPhone();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_logout_succ;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    /* renamed from: a */
    public final void m25283a(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAccTips = textView;
    }
}
