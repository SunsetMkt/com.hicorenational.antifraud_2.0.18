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
public class PayStopListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PayStopListActivity f22631a;

    /* renamed from: b */
    private View f22632b;

    /* renamed from: c */
    private View f22633c;

    /* renamed from: d */
    private View f22634d;

    /* renamed from: e */
    private View f22635e;

    /* renamed from: ui.activity.PayStopListActivity_ViewBinding$a */
    class C6413a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopListActivity f22636a;

        C6413a(PayStopListActivity payStopListActivity) {
            this.f22636a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22636a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PayStopListActivity_ViewBinding$b */
    class C6414b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopListActivity f22638a;

        C6414b(PayStopListActivity payStopListActivity) {
            this.f22638a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22638a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PayStopListActivity_ViewBinding$c */
    class C6415c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopListActivity f22640a;

        C6415c(PayStopListActivity payStopListActivity) {
            this.f22640a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22640a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PayStopListActivity_ViewBinding$d */
    class C6416d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopListActivity f22642a;

        C6416d(PayStopListActivity payStopListActivity) {
            this.f22642a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22642a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopListActivity_ViewBinding(PayStopListActivity payStopListActivity) {
        this(payStopListActivity, payStopListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopListActivity payStopListActivity = this.f22631a;
        if (payStopListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22631a = null;
        payStopListActivity.mTvTitle = null;
        payStopListActivity.mLine = null;
        payStopListActivity.mLlSelect = null;
        payStopListActivity.mLlInput = null;
        payStopListActivity.mRecyclerview = null;
        payStopListActivity.mBtnCommit = null;
        this.f22632b.setOnClickListener(null);
        this.f22632b = null;
        this.f22633c.setOnClickListener(null);
        this.f22633c = null;
        this.f22634d.setOnClickListener(null);
        this.f22634d = null;
        this.f22635e.setOnClickListener(null);
        this.f22635e = null;
    }

    @UiThread
    public PayStopListActivity_ViewBinding(PayStopListActivity payStopListActivity, View view) {
        this.f22631a = payStopListActivity;
        payStopListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        payStopListActivity.mLine = Utils.findRequiredView(view, C2113R.id.v_line, "field 'mLine'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.ll_select, "field 'mLlSelect' and method 'onViewClicked'");
        payStopListActivity.mLlSelect = findRequiredView;
        this.f22632b = findRequiredView;
        findRequiredView.setOnClickListener(new C6413a(payStopListActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_input, "field 'mLlInput' and method 'onViewClicked'");
        payStopListActivity.mLlInput = findRequiredView2;
        this.f22633c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6414b(payStopListActivity));
        payStopListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopListActivity.mBtnCommit = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22634d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6415c(payStopListActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22635e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6416d(payStopListActivity));
    }
}
