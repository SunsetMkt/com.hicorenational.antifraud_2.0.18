package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class SmsActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SmsActivity f23173a;

    /* renamed from: b */
    private View f23174b;

    /* renamed from: c */
    private View f23175c;

    /* renamed from: d */
    private View f23176d;

    /* renamed from: e */
    private View f23177e;

    /* renamed from: ui.activity.SmsActivity_ViewBinding$a */
    class C6597a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsActivity f23178a;

        C6597a(SmsActivity smsActivity) {
            this.f23178a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23178a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SmsActivity_ViewBinding$b */
    class C6598b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsActivity f23180a;

        C6598b(SmsActivity smsActivity) {
            this.f23180a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23180a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SmsActivity_ViewBinding$c */
    class C6599c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsActivity f23182a;

        C6599c(SmsActivity smsActivity) {
            this.f23182a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23182a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SmsActivity_ViewBinding$d */
    class C6600d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsActivity f23184a;

        C6600d(SmsActivity smsActivity) {
            this.f23184a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23184a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsActivity_ViewBinding(SmsActivity smsActivity) {
        this(smsActivity, smsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsActivity smsActivity = this.f23173a;
        if (smsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23173a = null;
        smsActivity.mTvTitle = null;
        smsActivity.mRecyclerview = null;
        smsActivity.mTvSelectTip = null;
        smsActivity.mTvCommitTip = null;
        smsActivity.mBtnCommit = null;
        smsActivity.mTvInputTip = null;
        this.f23174b.setOnClickListener(null);
        this.f23174b = null;
        this.f23175c.setOnClickListener(null);
        this.f23175c = null;
        this.f23176d.setOnClickListener(null);
        this.f23176d = null;
        this.f23177e.setOnClickListener(null);
        this.f23177e = null;
    }

    @UiThread
    public SmsActivity_ViewBinding(SmsActivity smsActivity, View view) {
        this.f23173a = smsActivity;
        smsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        smsActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        smsActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        smsActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        smsActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f23174b = findRequiredView;
        findRequiredView.setOnClickListener(new C6597a(smsActivity));
        smsActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23175c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6598b(smsActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f23176d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6599c(smsActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_input, "method 'onViewClicked'");
        this.f23177e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6600d(smsActivity));
    }
}
