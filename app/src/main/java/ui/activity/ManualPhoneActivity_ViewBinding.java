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
public class ManualPhoneActivity_ViewBinding implements Unbinder {
    private ManualPhoneActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13504d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ManualPhoneActivity a;

        a(ManualPhoneActivity manualPhoneActivity) {
            this.a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ManualPhoneActivity a;

        b(ManualPhoneActivity manualPhoneActivity) {
            this.a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ManualPhoneActivity a;

        c(ManualPhoneActivity manualPhoneActivity) {
            this.a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ManualPhoneActivity_ViewBinding(ManualPhoneActivity manualPhoneActivity) {
        this(manualPhoneActivity, manualPhoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ManualPhoneActivity manualPhoneActivity = this.a;
        if (manualPhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        manualPhoneActivity.mTvTitle = null;
        manualPhoneActivity.mPhoneCode = null;
        manualPhoneActivity.mConfim = null;
        manualPhoneActivity.mPhoneLable = null;
        manualPhoneActivity.mIvClean = null;
        this.f13502b.setOnClickListener(null);
        this.f13502b = null;
        this.f13503c.setOnClickListener(null);
        this.f13503c = null;
        this.f13504d.setOnClickListener(null);
        this.f13504d = null;
    }

    @UiThread
    public ManualPhoneActivity_ViewBinding(ManualPhoneActivity manualPhoneActivity, View view) {
        this.a = manualPhoneActivity;
        manualPhoneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualPhoneActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        manualPhoneActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f13502b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(manualPhoneActivity));
        manualPhoneActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        manualPhoneActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f13503c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(manualPhoneActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13504d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(manualPhoneActivity));
    }
}
