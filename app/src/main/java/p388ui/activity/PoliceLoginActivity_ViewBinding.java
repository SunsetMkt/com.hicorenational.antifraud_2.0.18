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
import p388ui.view.CodeCutTimeTextView;

/* loaded from: classes2.dex */
public class PoliceLoginActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PoliceLoginActivity f22694a;

    /* renamed from: b */
    private View f22695b;

    /* renamed from: c */
    private View f22696c;

    /* renamed from: d */
    private View f22697d;

    /* renamed from: e */
    private View f22698e;

    /* renamed from: f */
    private View f22699f;

    /* renamed from: ui.activity.PoliceLoginActivity_ViewBinding$a */
    class C6435a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceLoginActivity f22700a;

        C6435a(PoliceLoginActivity policeLoginActivity) {
            this.f22700a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22700a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PoliceLoginActivity_ViewBinding$b */
    class C6436b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceLoginActivity f22702a;

        C6436b(PoliceLoginActivity policeLoginActivity) {
            this.f22702a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22702a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PoliceLoginActivity_ViewBinding$c */
    class C6437c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceLoginActivity f22704a;

        C6437c(PoliceLoginActivity policeLoginActivity) {
            this.f22704a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22704a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PoliceLoginActivity_ViewBinding$d */
    class C6438d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceLoginActivity f22706a;

        C6438d(PoliceLoginActivity policeLoginActivity) {
            this.f22706a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22706a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PoliceLoginActivity_ViewBinding$e */
    class C6439e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PoliceLoginActivity f22708a;

        C6439e(PoliceLoginActivity policeLoginActivity) {
            this.f22708a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22708a.onViewClicked(view);
        }
    }

    @UiThread
    public PoliceLoginActivity_ViewBinding(PoliceLoginActivity policeLoginActivity) {
        this(policeLoginActivity, policeLoginActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PoliceLoginActivity policeLoginActivity = this.f22694a;
        if (policeLoginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22694a = null;
        policeLoginActivity.mIvBack = null;
        policeLoginActivity.mTvTitle = null;
        policeLoginActivity.mConfirm = null;
        policeLoginActivity.mPhone = null;
        policeLoginActivity.mIvclean = null;
        policeLoginActivity.mTvReset = null;
        policeLoginActivity.mCode = null;
        policeLoginActivity.mIvClearCode = null;
        this.f22695b.setOnClickListener(null);
        this.f22695b = null;
        this.f22696c.setOnClickListener(null);
        this.f22696c = null;
        this.f22697d.setOnClickListener(null);
        this.f22697d = null;
        this.f22698e.setOnClickListener(null);
        this.f22698e = null;
        this.f22699f.setOnClickListener(null);
        this.f22699f = null;
    }

    @UiThread
    public PoliceLoginActivity_ViewBinding(PoliceLoginActivity policeLoginActivity, View view) {
        this.f22694a = policeLoginActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        policeLoginActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22695b = findRequiredView;
        findRequiredView.setOnClickListener(new C6435a(policeLoginActivity));
        policeLoginActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        policeLoginActivity.mConfirm = (TextView) Utils.castView(findRequiredView2, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f22696c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6436b(policeLoginActivity));
        policeLoginActivity.mPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.phone, "field 'mPhone'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvclean' and method 'onViewClicked'");
        policeLoginActivity.mIvclean = (ImageView) Utils.castView(findRequiredView3, C2113R.id.iv_clear, "field 'mIvclean'", ImageView.class);
        this.f22697d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6437c(policeLoginActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_resend, "field 'mTvReset' and method 'onViewClicked'");
        policeLoginActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(findRequiredView4, C2113R.id.tv_resend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f22698e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6438d(policeLoginActivity));
        policeLoginActivity.mCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.code, "field 'mCode'", EditText.class);
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.iv_clear_code, "field 'mIvClearCode' and method 'onViewClicked'");
        policeLoginActivity.mIvClearCode = (ImageView) Utils.castView(findRequiredView5, C2113R.id.iv_clear_code, "field 'mIvClearCode'", ImageView.class);
        this.f22699f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6439e(policeLoginActivity));
    }
}
