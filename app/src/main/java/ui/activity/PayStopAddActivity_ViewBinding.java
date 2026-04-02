package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class PayStopAddActivity_ViewBinding implements Unbinder {
    private PayStopAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13532e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PayStopAddActivity a;

        a(PayStopAddActivity payStopAddActivity) {
            this.a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PayStopAddActivity a;

        b(PayStopAddActivity payStopAddActivity) {
            this.a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ PayStopAddActivity a;

        c(PayStopAddActivity payStopAddActivity) {
            this.a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ PayStopAddActivity a;

        d(PayStopAddActivity payStopAddActivity) {
            this.a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopAddActivity_ViewBinding(PayStopAddActivity payStopAddActivity) {
        this(payStopAddActivity, payStopAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopAddActivity payStopAddActivity = this.a;
        if (payStopAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        payStopAddActivity.mTvTitle = null;
        payStopAddActivity.mTvSuspectType = null;
        payStopAddActivity.mEtSuspectAccountName = null;
        payStopAddActivity.mEtSuspectAccount = null;
        payStopAddActivity.mTvTransTime = null;
        payStopAddActivity.mEtTransMoy = null;
        payStopAddActivity.mBtnCommit = null;
        this.f13529b.setOnClickListener(null);
        this.f13529b = null;
        this.f13530c.setOnClickListener(null);
        this.f13530c = null;
        this.f13531d.setOnClickListener(null);
        this.f13531d = null;
        this.f13532e.setOnClickListener(null);
        this.f13532e = null;
    }

    @UiThread
    public PayStopAddActivity_ViewBinding(PayStopAddActivity payStopAddActivity, View view) {
        this.a = payStopAddActivity;
        payStopAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_suspect_type, "field 'mTvSuspectType' and method 'onViewClicked'");
        payStopAddActivity.mTvSuspectType = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_suspect_type, "field 'mTvSuspectType'", TextView.class);
        this.f13529b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(payStopAddActivity));
        payStopAddActivity.mEtSuspectAccountName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_suspect_account_name, "field 'mEtSuspectAccountName'", EditText.class);
        payStopAddActivity.mEtSuspectAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_suspect_account, "field 'mEtSuspectAccount'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTransTime' and method 'onViewClicked'");
        payStopAddActivity.mTvTransTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTransTime'", TextView.class);
        this.f13530c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(payStopAddActivity));
        payStopAddActivity.mEtTransMoy = (EditText) Utils.findRequiredViewAsType(view, R.id.et_transfer_money, "field 'mEtTransMoy'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopAddActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13531d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(payStopAddActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13532e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(payStopAddActivity));
    }
}
