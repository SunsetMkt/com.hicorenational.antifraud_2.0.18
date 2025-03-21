package p388ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.CodeCutTimeTextView;

/* loaded from: classes2.dex */
public class OauthRegisterActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private OauthRegisterActivity f22597a;

    /* renamed from: b */
    private View f22598b;

    /* renamed from: c */
    private View f22599c;

    /* renamed from: d */
    private View f22600d;

    /* renamed from: e */
    private View f22601e;

    /* renamed from: ui.activity.OauthRegisterActivity_ViewBinding$a */
    class C6401a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ OauthRegisterActivity f22602a;

        C6401a(OauthRegisterActivity oauthRegisterActivity) {
            this.f22602a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22602a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.OauthRegisterActivity_ViewBinding$b */
    class C6402b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ OauthRegisterActivity f22604a;

        C6402b(OauthRegisterActivity oauthRegisterActivity) {
            this.f22604a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22604a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.OauthRegisterActivity_ViewBinding$c */
    class C6403c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ OauthRegisterActivity f22606a;

        C6403c(OauthRegisterActivity oauthRegisterActivity) {
            this.f22606a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22606a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.OauthRegisterActivity_ViewBinding$d */
    class C6404d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ OauthRegisterActivity f22608a;

        C6404d(OauthRegisterActivity oauthRegisterActivity) {
            this.f22608a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22608a.onViewClicked(view);
        }
    }

    @UiThread
    public OauthRegisterActivity_ViewBinding(OauthRegisterActivity oauthRegisterActivity) {
        this(oauthRegisterActivity, oauthRegisterActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OauthRegisterActivity oauthRegisterActivity = this.f22597a;
        if (oauthRegisterActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22597a = null;
        oauthRegisterActivity.mUserCode = null;
        oauthRegisterActivity.mConfirm = null;
        oauthRegisterActivity.mClause = null;
        oauthRegisterActivity.mTCbSelect = null;
        oauthRegisterActivity.mAccount = null;
        oauthRegisterActivity.mIvClean = null;
        oauthRegisterActivity.mTvReset = null;
        this.f22598b.setOnClickListener(null);
        this.f22598b = null;
        this.f22599c.setOnClickListener(null);
        this.f22599c = null;
        this.f22600d.setOnClickListener(null);
        this.f22600d = null;
        this.f22601e.setOnClickListener(null);
        this.f22601e = null;
    }

    @UiThread
    public OauthRegisterActivity_ViewBinding(OauthRegisterActivity oauthRegisterActivity, View view) {
        this.f22597a = oauthRegisterActivity;
        oauthRegisterActivity.mUserCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_code, "field 'mUserCode'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        oauthRegisterActivity.mConfirm = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f22598b = findRequiredView;
        findRequiredView.setOnClickListener(new C6401a(oauthRegisterActivity));
        oauthRegisterActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.clause, "field 'mClause'", TextView.class);
        oauthRegisterActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, C2113R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        oauthRegisterActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.account, "field 'mAccount'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        oauthRegisterActivity.mIvClean = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f22599c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6402b(oauthRegisterActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_resend, "field 'mTvReset' and method 'onViewClicked'");
        oauthRegisterActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(findRequiredView3, C2113R.id.tv_resend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f22600d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6403c(oauthRegisterActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22601e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6404d(oauthRegisterActivity));
    }
}
