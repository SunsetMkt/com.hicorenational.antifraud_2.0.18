package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class SignAppDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignAppDetailActivity f23082a;

    /* renamed from: b */
    private View f23083b;

    /* renamed from: c */
    private View f23084c;

    /* renamed from: d */
    private View f23085d;

    /* renamed from: ui.activity.SignAppDetailActivity_ViewBinding$a */
    class C6575a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignAppDetailActivity f23086a;

        C6575a(SignAppDetailActivity signAppDetailActivity) {
            this.f23086a = signAppDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23086a.onClick(view);
        }
    }

    /* renamed from: ui.activity.SignAppDetailActivity_ViewBinding$b */
    class C6576b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignAppDetailActivity f23088a;

        C6576b(SignAppDetailActivity signAppDetailActivity) {
            this.f23088a = signAppDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23088a.onClick(view);
        }
    }

    /* renamed from: ui.activity.SignAppDetailActivity_ViewBinding$c */
    class C6577c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignAppDetailActivity f23090a;

        C6577c(SignAppDetailActivity signAppDetailActivity) {
            this.f23090a = signAppDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23090a.onClick(view);
        }
    }

    @UiThread
    public SignAppDetailActivity_ViewBinding(SignAppDetailActivity signAppDetailActivity) {
        this(signAppDetailActivity, signAppDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignAppDetailActivity signAppDetailActivity = this.f23082a;
        if (signAppDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23082a = null;
        signAppDetailActivity.mIvBack = null;
        signAppDetailActivity.mTvTitle = null;
        signAppDetailActivity.mFlAppInfo = null;
        signAppDetailActivity.mTvAppName = null;
        signAppDetailActivity.mTvAppPkg = null;
        signAppDetailActivity.mTvAppVers = null;
        signAppDetailActivity.mIvAppIcon = null;
        signAppDetailActivity.mFlAppMnInfo = null;
        signAppDetailActivity.mTvAppNameMn = null;
        signAppDetailActivity.mFlAppZxing = null;
        signAppDetailActivity.mIvAppZxing = null;
        signAppDetailActivity.mFlAppLogo = null;
        signAppDetailActivity.mIvAppLogo = null;
        signAppDetailActivity.mEtVictimAccount = null;
        signAppDetailActivity.mEtVictimPwd = null;
        signAppDetailActivity.mEtInvitationCode = null;
        signAppDetailActivity.mLlInvitationCode = null;
        this.f23083b.setOnClickListener(null);
        this.f23083b = null;
        this.f23084c.setOnClickListener(null);
        this.f23084c = null;
        this.f23085d.setOnClickListener(null);
        this.f23085d = null;
    }

    @UiThread
    public SignAppDetailActivity_ViewBinding(SignAppDetailActivity signAppDetailActivity, View view) {
        this.f23082a = signAppDetailActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signAppDetailActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23083b = findRequiredView;
        findRequiredView.setOnClickListener(new C6575a(signAppDetailActivity));
        signAppDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signAppDetailActivity.mFlAppInfo = Utils.findRequiredView(view, C2113R.id.fl_app_view, "field 'mFlAppInfo'");
        signAppDetailActivity.mTvAppName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_name, "field 'mTvAppName'", TextView.class);
        signAppDetailActivity.mTvAppPkg = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_pkg, "field 'mTvAppPkg'", TextView.class);
        signAppDetailActivity.mTvAppVers = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_vers, "field 'mTvAppVers'", TextView.class);
        signAppDetailActivity.mIvAppIcon = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_app_icon, "field 'mIvAppIcon'", ImageView.class);
        signAppDetailActivity.mFlAppMnInfo = Utils.findRequiredView(view, C2113R.id.fl_app_mini, "field 'mFlAppMnInfo'");
        signAppDetailActivity.mTvAppNameMn = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_name_mini, "field 'mTvAppNameMn'", TextView.class);
        signAppDetailActivity.mFlAppZxing = Utils.findRequiredView(view, C2113R.id.fl_app_zxing, "field 'mFlAppZxing'");
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_zxing, "field 'mIvAppZxing' and method 'onClick'");
        signAppDetailActivity.mIvAppZxing = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_zxing, "field 'mIvAppZxing'", ImageView.class);
        this.f23084c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6576b(signAppDetailActivity));
        signAppDetailActivity.mFlAppLogo = Utils.findRequiredView(view, C2113R.id.fl_app_logo, "field 'mFlAppLogo'");
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_app_logo, "field 'mIvAppLogo' and method 'onClick'");
        signAppDetailActivity.mIvAppLogo = (ImageView) Utils.castView(findRequiredView3, C2113R.id.iv_app_logo, "field 'mIvAppLogo'", ImageView.class);
        this.f23085d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6577c(signAppDetailActivity));
        signAppDetailActivity.mEtVictimAccount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_app_victimAccount, "field 'mEtVictimAccount'", TextView.class);
        signAppDetailActivity.mEtVictimPwd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_app_victimPwd, "field 'mEtVictimPwd'", TextView.class);
        signAppDetailActivity.mEtInvitationCode = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_app_invitationCode, "field 'mEtInvitationCode'", TextView.class);
        signAppDetailActivity.mLlInvitationCode = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_invitationCode, "field 'mLlInvitationCode'", LinearLayout.class);
    }
}
