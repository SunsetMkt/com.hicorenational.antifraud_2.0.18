package ui.activity;

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
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class LogoutReasonActivity_ViewBinding implements Unbinder {
    private LogoutReasonActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13468c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ LogoutReasonActivity a;

        a(LogoutReasonActivity logoutReasonActivity) {
            this.a = logoutReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ LogoutReasonActivity a;

        b(LogoutReasonActivity logoutReasonActivity) {
            this.a = logoutReasonActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public LogoutReasonActivity_ViewBinding(LogoutReasonActivity logoutReasonActivity) {
        this(logoutReasonActivity, logoutReasonActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutReasonActivity logoutReasonActivity = this.a;
        if (logoutReasonActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        logoutReasonActivity.mIvBack = null;
        logoutReasonActivity.mTvTitle = null;
        logoutReasonActivity.mRbGroup = null;
        logoutReasonActivity.mFlOtherEdit = null;
        logoutReasonActivity.mEtOtherReson = null;
        logoutReasonActivity.mTvWords = null;
        logoutReasonActivity.mConfim = null;
        this.f13467b.setOnClickListener(null);
        this.f13467b = null;
        this.f13468c.setOnClickListener(null);
        this.f13468c = null;
    }

    @UiThread
    public LogoutReasonActivity_ViewBinding(LogoutReasonActivity logoutReasonActivity, View view) {
        this.a = logoutReasonActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutReasonActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13467b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutReasonActivity));
        logoutReasonActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutReasonActivity.mRbGroup = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.rg_group, "field 'mRbGroup'", RadioGroup.class);
        logoutReasonActivity.mFlOtherEdit = Utils.findRequiredView(view, R.id.fl_other_edit, "field 'mFlOtherEdit'");
        logoutReasonActivity.mEtOtherReson = (EditText) Utils.findRequiredViewAsType(view, R.id.et_other_reson, "field 'mEtOtherReson'", EditText.class);
        logoutReasonActivity.mTvWords = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_words, "field 'mTvWords'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onClick'");
        logoutReasonActivity.mConfim = (Button) Utils.castView(viewFindRequiredView2, R.id.confirm, "field 'mConfim'", Button.class);
        this.f13468c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutReasonActivity));
    }
}
