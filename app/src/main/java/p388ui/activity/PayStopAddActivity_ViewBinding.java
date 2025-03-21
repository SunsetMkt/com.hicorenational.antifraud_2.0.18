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
public class PayStopAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PayStopAddActivity f22614a;

    /* renamed from: b */
    private View f22615b;

    /* renamed from: c */
    private View f22616c;

    /* renamed from: d */
    private View f22617d;

    /* renamed from: e */
    private View f22618e;

    /* renamed from: ui.activity.PayStopAddActivity_ViewBinding$a */
    class C6407a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopAddActivity f22619a;

        C6407a(PayStopAddActivity payStopAddActivity) {
            this.f22619a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22619a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PayStopAddActivity_ViewBinding$b */
    class C6408b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopAddActivity f22621a;

        C6408b(PayStopAddActivity payStopAddActivity) {
            this.f22621a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22621a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PayStopAddActivity_ViewBinding$c */
    class C6409c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopAddActivity f22623a;

        C6409c(PayStopAddActivity payStopAddActivity) {
            this.f22623a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22623a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PayStopAddActivity_ViewBinding$d */
    class C6410d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopAddActivity f22625a;

        C6410d(PayStopAddActivity payStopAddActivity) {
            this.f22625a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22625a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopAddActivity_ViewBinding(PayStopAddActivity payStopAddActivity) {
        this(payStopAddActivity, payStopAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopAddActivity payStopAddActivity = this.f22614a;
        if (payStopAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22614a = null;
        payStopAddActivity.mTvTitle = null;
        payStopAddActivity.mTvSuspectType = null;
        payStopAddActivity.mEtSuspectAccountName = null;
        payStopAddActivity.mEtSuspectAccount = null;
        payStopAddActivity.mTvTransTime = null;
        payStopAddActivity.mEtTransMoy = null;
        payStopAddActivity.mBtnCommit = null;
        this.f22615b.setOnClickListener(null);
        this.f22615b = null;
        this.f22616c.setOnClickListener(null);
        this.f22616c = null;
        this.f22617d.setOnClickListener(null);
        this.f22617d = null;
        this.f22618e.setOnClickListener(null);
        this.f22618e = null;
    }

    @UiThread
    public PayStopAddActivity_ViewBinding(PayStopAddActivity payStopAddActivity, View view) {
        this.f22614a = payStopAddActivity;
        payStopAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_suspect_type, "field 'mTvSuspectType' and method 'onViewClicked'");
        payStopAddActivity.mTvSuspectType = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_suspect_type, "field 'mTvSuspectType'", TextView.class);
        this.f22615b = findRequiredView;
        findRequiredView.setOnClickListener(new C6407a(payStopAddActivity));
        payStopAddActivity.mEtSuspectAccountName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_account_name, "field 'mEtSuspectAccountName'", EditText.class);
        payStopAddActivity.mEtSuspectAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_account, "field 'mEtSuspectAccount'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTransTime' and method 'onViewClicked'");
        payStopAddActivity.mTvTransTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTransTime'", TextView.class);
        this.f22616c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6408b(payStopAddActivity));
        payStopAddActivity.mEtTransMoy = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_transfer_money, "field 'mEtTransMoy'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopAddActivity.mBtnCommit = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22617d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6409c(payStopAddActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22618e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6410d(payStopAddActivity));
    }
}
