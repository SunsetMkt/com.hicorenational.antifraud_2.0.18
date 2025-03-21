package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CallEditActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CallEditActivity f21917a;

    /* renamed from: b */
    private View f21918b;

    /* renamed from: c */
    private View f21919c;

    /* renamed from: d */
    private View f21920d;

    /* renamed from: e */
    private View f21921e;

    /* renamed from: ui.activity.CallEditActivity_ViewBinding$a */
    class C6163a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallEditActivity f21922a;

        C6163a(CallEditActivity callEditActivity) {
            this.f21922a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21922a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallEditActivity_ViewBinding$b */
    class C6164b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallEditActivity f21924a;

        C6164b(CallEditActivity callEditActivity) {
            this.f21924a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21924a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallEditActivity_ViewBinding$c */
    class C6165c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallEditActivity f21926a;

        C6165c(CallEditActivity callEditActivity) {
            this.f21926a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21926a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallEditActivity_ViewBinding$d */
    class C6166d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallEditActivity f21928a;

        C6166d(CallEditActivity callEditActivity) {
            this.f21928a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21928a.onViewClicked(view);
        }
    }

    @UiThread
    public CallEditActivity_ViewBinding(CallEditActivity callEditActivity) {
        this(callEditActivity, callEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallEditActivity callEditActivity = this.f21917a;
        if (callEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21917a = null;
        callEditActivity.mTvTitle = null;
        callEditActivity.mBtnConfirm = null;
        callEditActivity.mEtVictimPhone = null;
        callEditActivity.mEtPhone = null;
        callEditActivity.mTvOccurTime = null;
        callEditActivity.mTvDuration = null;
        this.f21918b.setOnClickListener(null);
        this.f21918b = null;
        this.f21919c.setOnClickListener(null);
        this.f21919c = null;
        this.f21920d.setOnClickListener(null);
        this.f21920d = null;
        this.f21921e.setOnClickListener(null);
        this.f21921e = null;
    }

    @UiThread
    public CallEditActivity_ViewBinding(CallEditActivity callEditActivity, View view) {
        this.f21917a = callEditActivity;
        callEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        callEditActivity.mBtnConfirm = (Button) Utils.castView(findRequiredView, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f21918b = findRequiredView;
        findRequiredView.setOnClickListener(new C6163a(callEditActivity));
        callEditActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        callEditActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_occur_time, "field 'mTvOccurTime' and method 'onViewClicked'");
        callEditActivity.mTvOccurTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        this.f21919c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6164b(callEditActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_duration, "field 'mTvDuration' and method 'onViewClicked'");
        callEditActivity.mTvDuration = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        this.f21920d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6165c(callEditActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21921e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6166d(callEditActivity));
    }
}
