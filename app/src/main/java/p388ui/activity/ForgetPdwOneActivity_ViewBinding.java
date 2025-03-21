package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class ForgetPdwOneActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ForgetPdwOneActivity f22341a;

    /* renamed from: b */
    private View f22342b;

    /* renamed from: c */
    private View f22343c;

    /* renamed from: d */
    private View f22344d;

    /* renamed from: ui.activity.ForgetPdwOneActivity_ViewBinding$a */
    class C6316a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ForgetPdwOneActivity f22345a;

        C6316a(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.f22345a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22345a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ForgetPdwOneActivity_ViewBinding$b */
    class C6317b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ForgetPdwOneActivity f22347a;

        C6317b(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.f22347a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22347a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ForgetPdwOneActivity_ViewBinding$c */
    class C6318c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ForgetPdwOneActivity f22349a;

        C6318c(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.f22349a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22349a.onViewClicked(view);
        }
    }

    @UiThread
    public ForgetPdwOneActivity_ViewBinding(ForgetPdwOneActivity forgetPdwOneActivity) {
        this(forgetPdwOneActivity, forgetPdwOneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ForgetPdwOneActivity forgetPdwOneActivity = this.f22341a;
        if (forgetPdwOneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22341a = null;
        forgetPdwOneActivity.mTvTitle = null;
        forgetPdwOneActivity.mPhoneCode = null;
        forgetPdwOneActivity.mConfim = null;
        forgetPdwOneActivity.mPhoneLable = null;
        forgetPdwOneActivity.mIvClean = null;
        this.f22342b.setOnClickListener(null);
        this.f22342b = null;
        this.f22343c.setOnClickListener(null);
        this.f22343c = null;
        this.f22344d.setOnClickListener(null);
        this.f22344d = null;
    }

    @UiThread
    public ForgetPdwOneActivity_ViewBinding(ForgetPdwOneActivity forgetPdwOneActivity, View view) {
        this.f22341a = forgetPdwOneActivity;
        forgetPdwOneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        forgetPdwOneActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        forgetPdwOneActivity.mConfim = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfim'", TextView.class);
        this.f22342b = findRequiredView;
        findRequiredView.setOnClickListener(new C6316a(forgetPdwOneActivity));
        forgetPdwOneActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        forgetPdwOneActivity.mIvClean = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f22343c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6317b(forgetPdwOneActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22344d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6318c(forgetPdwOneActivity));
    }
}
