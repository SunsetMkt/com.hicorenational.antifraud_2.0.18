package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class SmsActivity_ViewBinding implements Unbinder {
    private SmsActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13845e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SmsActivity a;

        a(SmsActivity smsActivity) {
            this.a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SmsActivity a;

        b(SmsActivity smsActivity) {
            this.a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ SmsActivity a;

        c(SmsActivity smsActivity) {
            this.a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ SmsActivity a;

        d(SmsActivity smsActivity) {
            this.a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsActivity_ViewBinding(SmsActivity smsActivity) {
        this(smsActivity, smsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsActivity smsActivity = this.a;
        if (smsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        smsActivity.mTvTitle = null;
        smsActivity.mRecyclerview = null;
        smsActivity.mTvSelectTip = null;
        smsActivity.mTvCommitTip = null;
        smsActivity.mBtnCommit = null;
        smsActivity.mTvInputTip = null;
        this.f13842b.setOnClickListener(null);
        this.f13842b = null;
        this.f13843c.setOnClickListener(null);
        this.f13843c = null;
        this.f13844d.setOnClickListener(null);
        this.f13844d = null;
        this.f13845e.setOnClickListener(null);
        this.f13845e = null;
    }

    @UiThread
    public SmsActivity_ViewBinding(SmsActivity smsActivity, View view) {
        this.a = smsActivity;
        smsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        smsActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        smsActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        smsActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        smsActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13842b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(smsActivity));
        smsActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13843c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(smsActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13844d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(smsActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f13845e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(smsActivity));
    }
}
