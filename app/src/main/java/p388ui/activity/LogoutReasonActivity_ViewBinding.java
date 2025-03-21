package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class LogoutReasonActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LogoutReasonActivity f22492a;

    /* renamed from: b */
    private View f22493b;

    /* renamed from: c */
    private View f22494c;

    /* renamed from: ui.activity.LogoutReasonActivity_ViewBinding$a */
    class C6360a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutReasonActivity f22495a;

        C6360a(LogoutReasonActivity logoutReasonActivity) {
            this.f22495a = logoutReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22495a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutReasonActivity_ViewBinding$b */
    class C6361b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutReasonActivity f22497a;

        C6361b(LogoutReasonActivity logoutReasonActivity) {
            this.f22497a = logoutReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22497a.onClick(view);
        }
    }

    @UiThread
    public LogoutReasonActivity_ViewBinding(LogoutReasonActivity logoutReasonActivity) {
        this(logoutReasonActivity, logoutReasonActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutReasonActivity logoutReasonActivity = this.f22492a;
        if (logoutReasonActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22492a = null;
        logoutReasonActivity.mIvBack = null;
        logoutReasonActivity.mTvTitle = null;
        logoutReasonActivity.mRbGroup = null;
        logoutReasonActivity.mFlOtherEdit = null;
        logoutReasonActivity.mEtOtherReson = null;
        logoutReasonActivity.mTvWords = null;
        logoutReasonActivity.mConfim = null;
        this.f22493b.setOnClickListener(null);
        this.f22493b = null;
        this.f22494c.setOnClickListener(null);
        this.f22494c = null;
    }

    @UiThread
    public LogoutReasonActivity_ViewBinding(LogoutReasonActivity logoutReasonActivity, View view) {
        this.f22492a = logoutReasonActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutReasonActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22493b = findRequiredView;
        findRequiredView.setOnClickListener(new C6360a(logoutReasonActivity));
        logoutReasonActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutReasonActivity.mRbGroup = (RadioGroup) Utils.findRequiredViewAsType(view, C2113R.id.rg_group, "field 'mRbGroup'", RadioGroup.class);
        logoutReasonActivity.mFlOtherEdit = Utils.findRequiredView(view, C2113R.id.fl_other_edit, "field 'mFlOtherEdit'");
        logoutReasonActivity.mEtOtherReson = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_other_reson, "field 'mEtOtherReson'", EditText.class);
        logoutReasonActivity.mTvWords = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_words, "field 'mTvWords'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfim' and method 'onClick'");
        logoutReasonActivity.mConfim = (Button) Utils.castView(findRequiredView2, C2113R.id.confirm, "field 'mConfim'", Button.class);
        this.f22494c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6361b(logoutReasonActivity));
    }
}
