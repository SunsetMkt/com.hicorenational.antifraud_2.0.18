package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class ForgetPdwOneActivity_ViewBinding implements Unbinder {
    private ForgetPdwOneActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13384d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ForgetPdwOneActivity a;

        a(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ForgetPdwOneActivity a;

        b(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ForgetPdwOneActivity a;

        c(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ForgetPdwOneActivity_ViewBinding(ForgetPdwOneActivity forgetPdwOneActivity) {
        this(forgetPdwOneActivity, forgetPdwOneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ForgetPdwOneActivity forgetPdwOneActivity = this.a;
        if (forgetPdwOneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        forgetPdwOneActivity.mTvTitle = null;
        forgetPdwOneActivity.mPhoneCode = null;
        forgetPdwOneActivity.mConfim = null;
        forgetPdwOneActivity.mPhoneLable = null;
        forgetPdwOneActivity.mIvClean = null;
        this.f13382b.setOnClickListener(null);
        this.f13382b = null;
        this.f13383c.setOnClickListener(null);
        this.f13383c = null;
        this.f13384d.setOnClickListener(null);
        this.f13384d = null;
    }

    @UiThread
    public ForgetPdwOneActivity_ViewBinding(ForgetPdwOneActivity forgetPdwOneActivity, View view) {
        this.a = forgetPdwOneActivity;
        forgetPdwOneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        forgetPdwOneActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        forgetPdwOneActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f13382b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(forgetPdwOneActivity));
        forgetPdwOneActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        forgetPdwOneActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f13383c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(forgetPdwOneActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13384d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(forgetPdwOneActivity));
    }
}
