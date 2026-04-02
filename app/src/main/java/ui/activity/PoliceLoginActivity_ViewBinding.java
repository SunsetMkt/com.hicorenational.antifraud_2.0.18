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
import ui.view.CodeCutTimeTextView;

/* JADX INFO: loaded from: classes2.dex */
public class PoliceLoginActivity_ViewBinding implements Unbinder {
    private PoliceLoginActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13578f;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PoliceLoginActivity a;

        a(PoliceLoginActivity policeLoginActivity) {
            this.a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PoliceLoginActivity a;

        b(PoliceLoginActivity policeLoginActivity) {
            this.a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ PoliceLoginActivity a;

        c(PoliceLoginActivity policeLoginActivity) {
            this.a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ PoliceLoginActivity a;

        d(PoliceLoginActivity policeLoginActivity) {
            this.a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ PoliceLoginActivity a;

        e(PoliceLoginActivity policeLoginActivity) {
            this.a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public PoliceLoginActivity_ViewBinding(PoliceLoginActivity policeLoginActivity) {
        this(policeLoginActivity, policeLoginActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PoliceLoginActivity policeLoginActivity = this.a;
        if (policeLoginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        policeLoginActivity.mIvBack = null;
        policeLoginActivity.mTvTitle = null;
        policeLoginActivity.mConfirm = null;
        policeLoginActivity.mPhone = null;
        policeLoginActivity.mIvclean = null;
        policeLoginActivity.mTvReset = null;
        policeLoginActivity.mCode = null;
        policeLoginActivity.mIvClearCode = null;
        this.f13574b.setOnClickListener(null);
        this.f13574b = null;
        this.f13575c.setOnClickListener(null);
        this.f13575c = null;
        this.f13576d.setOnClickListener(null);
        this.f13576d = null;
        this.f13577e.setOnClickListener(null);
        this.f13577e = null;
        this.f13578f.setOnClickListener(null);
        this.f13578f = null;
    }

    @UiThread
    public PoliceLoginActivity_ViewBinding(PoliceLoginActivity policeLoginActivity, View view) {
        this.a = policeLoginActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        policeLoginActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13574b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(policeLoginActivity));
        policeLoginActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        policeLoginActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView2, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f13575c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(policeLoginActivity));
        policeLoginActivity.mPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.phone, "field 'mPhone'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvclean' and method 'onViewClicked'");
        policeLoginActivity.mIvclean = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_clear, "field 'mIvclean'", ImageView.class);
        this.f13576d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(policeLoginActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvReset' and method 'onViewClicked'");
        policeLoginActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView4, R.id.tv_resend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f13577e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(policeLoginActivity));
        policeLoginActivity.mCode = (EditText) Utils.findRequiredViewAsType(view, R.id.code, "field 'mCode'", EditText.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_clear_code, "field 'mIvClearCode' and method 'onViewClicked'");
        policeLoginActivity.mIvClearCode = (ImageView) Utils.castView(viewFindRequiredView5, R.id.iv_clear_code, "field 'mIvClearCode'", ImageView.class);
        this.f13578f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(policeLoginActivity));
    }
}
