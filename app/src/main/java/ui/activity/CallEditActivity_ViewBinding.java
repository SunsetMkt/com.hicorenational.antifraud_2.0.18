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
public class CallEditActivity_ViewBinding implements Unbinder {
    private CallEditActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13144e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CallEditActivity a;

        a(CallEditActivity callEditActivity) {
            this.a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CallEditActivity a;

        b(CallEditActivity callEditActivity) {
            this.a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CallEditActivity a;

        c(CallEditActivity callEditActivity) {
            this.a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CallEditActivity a;

        d(CallEditActivity callEditActivity) {
            this.a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CallEditActivity_ViewBinding(CallEditActivity callEditActivity) {
        this(callEditActivity, callEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallEditActivity callEditActivity = this.a;
        if (callEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        callEditActivity.mTvTitle = null;
        callEditActivity.mBtnConfirm = null;
        callEditActivity.mEtVictimPhone = null;
        callEditActivity.mEtPhone = null;
        callEditActivity.mTvOccurTime = null;
        callEditActivity.mTvDuration = null;
        this.f13141b.setOnClickListener(null);
        this.f13141b = null;
        this.f13142c.setOnClickListener(null);
        this.f13142c = null;
        this.f13143d.setOnClickListener(null);
        this.f13143d = null;
        this.f13144e.setOnClickListener(null);
        this.f13144e = null;
    }

    @UiThread
    public CallEditActivity_ViewBinding(CallEditActivity callEditActivity, View view) {
        this.a = callEditActivity;
        callEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        callEditActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f13141b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callEditActivity));
        callEditActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        callEditActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_occur_time, "field 'mTvOccurTime' and method 'onViewClicked'");
        callEditActivity.mTvOccurTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        this.f13142c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callEditActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_duration, "field 'mTvDuration' and method 'onViewClicked'");
        callEditActivity.mTvDuration = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        this.f13143d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callEditActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13144e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callEditActivity));
    }
}
