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
public class ManualPhoneActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ManualPhoneActivity f22560a;

    /* renamed from: b */
    private View f22561b;

    /* renamed from: c */
    private View f22562c;

    /* renamed from: d */
    private View f22563d;

    /* renamed from: ui.activity.ManualPhoneActivity_ViewBinding$a */
    class C6387a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualPhoneActivity f22564a;

        C6387a(ManualPhoneActivity manualPhoneActivity) {
            this.f22564a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22564a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ManualPhoneActivity_ViewBinding$b */
    class C6388b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualPhoneActivity f22566a;

        C6388b(ManualPhoneActivity manualPhoneActivity) {
            this.f22566a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22566a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ManualPhoneActivity_ViewBinding$c */
    class C6389c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualPhoneActivity f22568a;

        C6389c(ManualPhoneActivity manualPhoneActivity) {
            this.f22568a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22568a.onViewClicked(view);
        }
    }

    @UiThread
    public ManualPhoneActivity_ViewBinding(ManualPhoneActivity manualPhoneActivity) {
        this(manualPhoneActivity, manualPhoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ManualPhoneActivity manualPhoneActivity = this.f22560a;
        if (manualPhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22560a = null;
        manualPhoneActivity.mTvTitle = null;
        manualPhoneActivity.mPhoneCode = null;
        manualPhoneActivity.mConfim = null;
        manualPhoneActivity.mPhoneLable = null;
        manualPhoneActivity.mIvClean = null;
        this.f22561b.setOnClickListener(null);
        this.f22561b = null;
        this.f22562c.setOnClickListener(null);
        this.f22562c = null;
        this.f22563d.setOnClickListener(null);
        this.f22563d = null;
    }

    @UiThread
    public ManualPhoneActivity_ViewBinding(ManualPhoneActivity manualPhoneActivity, View view) {
        this.f22560a = manualPhoneActivity;
        manualPhoneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualPhoneActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        manualPhoneActivity.mConfim = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfim'", TextView.class);
        this.f22561b = findRequiredView;
        findRequiredView.setOnClickListener(new C6387a(manualPhoneActivity));
        manualPhoneActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        manualPhoneActivity.mIvClean = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f22562c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6388b(manualPhoneActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22563d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6389c(manualPhoneActivity));
    }
}
