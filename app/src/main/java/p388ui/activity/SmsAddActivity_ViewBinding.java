package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.MyEdittext;

/* loaded from: classes2.dex */
public class SmsAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SmsAddActivity f23191a;

    /* renamed from: b */
    private View f23192b;

    /* renamed from: c */
    private View f23193c;

    /* renamed from: d */
    private View f23194d;

    /* renamed from: ui.activity.SmsAddActivity_ViewBinding$a */
    class C6602a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsAddActivity f23195a;

        C6602a(SmsAddActivity smsAddActivity) {
            this.f23195a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23195a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SmsAddActivity_ViewBinding$b */
    class C6603b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsAddActivity f23197a;

        C6603b(SmsAddActivity smsAddActivity) {
            this.f23197a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23197a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SmsAddActivity_ViewBinding$c */
    class C6604c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsAddActivity f23199a;

        C6604c(SmsAddActivity smsAddActivity) {
            this.f23199a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23199a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsAddActivity_ViewBinding(SmsAddActivity smsAddActivity) {
        this(smsAddActivity, smsAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsAddActivity smsAddActivity = this.f23191a;
        if (smsAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23191a = null;
        smsAddActivity.mTvTitle = null;
        smsAddActivity.mBtnCommit = null;
        smsAddActivity.mEtPhone = null;
        smsAddActivity.mEtDescribe = null;
        smsAddActivity.mEtVictimPhone = null;
        smsAddActivity.mTvTime = null;
        this.f23192b.setOnClickListener(null);
        this.f23192b = null;
        this.f23193c.setOnClickListener(null);
        this.f23193c = null;
        this.f23194d.setOnClickListener(null);
        this.f23194d = null;
    }

    @UiThread
    public SmsAddActivity_ViewBinding(SmsAddActivity smsAddActivity, View view) {
        this.f23191a = smsAddActivity;
        smsAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        smsAddActivity.mBtnCommit = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f23192b = findRequiredView;
        findRequiredView.setOnClickListener(new C6602a(smsAddActivity));
        smsAddActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        smsAddActivity.mEtDescribe = (MyEdittext) Utils.findRequiredViewAsType(view, C2113R.id.et_describe, "field 'mEtDescribe'", MyEdittext.class);
        smsAddActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        smsAddActivity.mTvTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f23193c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6603b(smsAddActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23194d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6604c(smsAddActivity));
    }
}
