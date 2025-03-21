package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class WarnPrimessActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WarnPrimessActivity f23466a;

    /* renamed from: b */
    private View f23467b;

    /* renamed from: c */
    private View f23468c;

    /* renamed from: d */
    private View f23469d;

    /* renamed from: e */
    private View f23470e;

    /* renamed from: f */
    private View f23471f;

    /* renamed from: g */
    private View f23472g;

    /* renamed from: h */
    private View f23473h;

    /* renamed from: i */
    private View f23474i;

    /* renamed from: j */
    private View f23475j;

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$a */
    class C6696a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23476a;

        C6696a(WarnPrimessActivity warnPrimessActivity) {
            this.f23476a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23476a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$b */
    class C6697b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23478a;

        C6697b(WarnPrimessActivity warnPrimessActivity) {
            this.f23478a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23478a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$c */
    class C6698c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23480a;

        C6698c(WarnPrimessActivity warnPrimessActivity) {
            this.f23480a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23480a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$d */
    class C6699d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23482a;

        C6699d(WarnPrimessActivity warnPrimessActivity) {
            this.f23482a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23482a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$e */
    class C6700e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23484a;

        C6700e(WarnPrimessActivity warnPrimessActivity) {
            this.f23484a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23484a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$f */
    class C6701f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23486a;

        C6701f(WarnPrimessActivity warnPrimessActivity) {
            this.f23486a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23486a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$g */
    class C6702g extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23488a;

        C6702g(WarnPrimessActivity warnPrimessActivity) {
            this.f23488a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23488a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$h */
    class C6703h extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23490a;

        C6703h(WarnPrimessActivity warnPrimessActivity) {
            this.f23490a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23490a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity_ViewBinding$i */
    class C6704i extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnPrimessActivity f23492a;

        C6704i(WarnPrimessActivity warnPrimessActivity) {
            this.f23492a = warnPrimessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23492a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnPrimessActivity_ViewBinding(WarnPrimessActivity warnPrimessActivity) {
        this(warnPrimessActivity, warnPrimessActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnPrimessActivity warnPrimessActivity = this.f23466a;
        if (warnPrimessActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23466a = null;
        warnPrimessActivity.mRlTitle = null;
        warnPrimessActivity.mIvBack = null;
        warnPrimessActivity.mTvTitle = null;
        warnPrimessActivity.mIvIc = null;
        warnPrimessActivity.mTvLabel = null;
        warnPrimessActivity.mTvLabelSmall = null;
        warnPrimessActivity.mOpenFlow = null;
        warnPrimessActivity.mOpenPhone = null;
        warnPrimessActivity.mOpenPhoneRecord = null;
        warnPrimessActivity.mOpenSms = null;
        warnPrimessActivity.mOpenAuto = null;
        warnPrimessActivity.mOpenPower = null;
        warnPrimessActivity.mOpenLock = null;
        warnPrimessActivity.mLlContent = null;
        warnPrimessActivity.mConfirm = null;
        this.f23467b.setOnClickListener(null);
        this.f23467b = null;
        this.f23468c.setOnClickListener(null);
        this.f23468c = null;
        this.f23469d.setOnClickListener(null);
        this.f23469d = null;
        this.f23470e.setOnClickListener(null);
        this.f23470e = null;
        this.f23471f.setOnClickListener(null);
        this.f23471f = null;
        this.f23472g.setOnClickListener(null);
        this.f23472g = null;
        this.f23473h.setOnClickListener(null);
        this.f23473h = null;
        this.f23474i.setOnClickListener(null);
        this.f23474i = null;
        this.f23475j.setOnClickListener(null);
        this.f23475j = null;
    }

    @UiThread
    public WarnPrimessActivity_ViewBinding(WarnPrimessActivity warnPrimessActivity, View view) {
        this.f23466a = warnPrimessActivity;
        warnPrimessActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        warnPrimessActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23467b = findRequiredView;
        findRequiredView.setOnClickListener(new C6696a(warnPrimessActivity));
        warnPrimessActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        warnPrimessActivity.mIvIc = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_ic, "field 'mIvIc'", ImageView.class);
        warnPrimessActivity.mTvLabel = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_label, "field 'mTvLabel'", TextView.class);
        warnPrimessActivity.mTvLabelSmall = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_label_small, "field 'mTvLabelSmall'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.open_flow, "field 'mOpenFlow' and method 'onViewClicked'");
        warnPrimessActivity.mOpenFlow = (TextView) Utils.castView(findRequiredView2, C2113R.id.open_flow, "field 'mOpenFlow'", TextView.class);
        this.f23468c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6697b(warnPrimessActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.open_phone, "field 'mOpenPhone' and method 'onViewClicked'");
        warnPrimessActivity.mOpenPhone = (TextView) Utils.castView(findRequiredView3, C2113R.id.open_phone, "field 'mOpenPhone'", TextView.class);
        this.f23469d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6698c(warnPrimessActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.open_phone_record, "field 'mOpenPhoneRecord' and method 'onViewClicked'");
        warnPrimessActivity.mOpenPhoneRecord = (TextView) Utils.castView(findRequiredView4, C2113R.id.open_phone_record, "field 'mOpenPhoneRecord'", TextView.class);
        this.f23470e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6699d(warnPrimessActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.open_sms, "field 'mOpenSms' and method 'onViewClicked'");
        warnPrimessActivity.mOpenSms = (TextView) Utils.castView(findRequiredView5, C2113R.id.open_sms, "field 'mOpenSms'", TextView.class);
        this.f23471f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6700e(warnPrimessActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.open_auto, "field 'mOpenAuto' and method 'onViewClicked'");
        warnPrimessActivity.mOpenAuto = (TextView) Utils.castView(findRequiredView6, C2113R.id.open_auto, "field 'mOpenAuto'", TextView.class);
        this.f23472g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6701f(warnPrimessActivity));
        View findRequiredView7 = Utils.findRequiredView(view, C2113R.id.open_power, "field 'mOpenPower' and method 'onViewClicked'");
        warnPrimessActivity.mOpenPower = (TextView) Utils.castView(findRequiredView7, C2113R.id.open_power, "field 'mOpenPower'", TextView.class);
        this.f23473h = findRequiredView7;
        findRequiredView7.setOnClickListener(new C6702g(warnPrimessActivity));
        View findRequiredView8 = Utils.findRequiredView(view, C2113R.id.open_lock, "field 'mOpenLock' and method 'onViewClicked'");
        warnPrimessActivity.mOpenLock = (TextView) Utils.castView(findRequiredView8, C2113R.id.open_lock, "field 'mOpenLock'", TextView.class);
        this.f23474i = findRequiredView8;
        findRequiredView8.setOnClickListener(new C6703h(warnPrimessActivity));
        warnPrimessActivity.mLlContent = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_content, "field 'mLlContent'", LinearLayout.class);
        View findRequiredView9 = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        warnPrimessActivity.mConfirm = (TextView) Utils.castView(findRequiredView9, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f23475j = findRequiredView9;
        findRequiredView9.setOnClickListener(new C6704i(warnPrimessActivity));
    }
}
