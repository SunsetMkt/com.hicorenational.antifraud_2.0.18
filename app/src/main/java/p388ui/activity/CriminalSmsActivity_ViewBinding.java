package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CriminalSmsActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalSmsActivity f22186a;

    /* renamed from: b */
    private View f22187b;

    /* renamed from: c */
    private View f22188c;

    /* renamed from: d */
    private View f22189d;

    /* renamed from: e */
    private View f22190e;

    /* renamed from: ui.activity.CriminalSmsActivity_ViewBinding$a */
    class C6255a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsActivity f22191a;

        C6255a(CriminalSmsActivity criminalSmsActivity) {
            this.f22191a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22191a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSmsActivity_ViewBinding$b */
    class C6256b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsActivity f22193a;

        C6256b(CriminalSmsActivity criminalSmsActivity) {
            this.f22193a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22193a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSmsActivity_ViewBinding$c */
    class C6257c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsActivity f22195a;

        C6257c(CriminalSmsActivity criminalSmsActivity) {
            this.f22195a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22195a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSmsActivity_ViewBinding$d */
    class C6258d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsActivity f22197a;

        C6258d(CriminalSmsActivity criminalSmsActivity) {
            this.f22197a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22197a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsActivity_ViewBinding(CriminalSmsActivity criminalSmsActivity) {
        this(criminalSmsActivity, criminalSmsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsActivity criminalSmsActivity = this.f22186a;
        if (criminalSmsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22186a = null;
        criminalSmsActivity.mTvTitle = null;
        criminalSmsActivity.mRecyclerview = null;
        criminalSmsActivity.mTvSelectTip = null;
        criminalSmsActivity.mTvCommitTip = null;
        criminalSmsActivity.mBtnCommit = null;
        criminalSmsActivity.mTvInputTip = null;
        criminalSmsActivity.mIncInput = null;
        criminalSmsActivity.mIncComplete = null;
        this.f22187b.setOnClickListener(null);
        this.f22187b = null;
        this.f22188c.setOnClickListener(null);
        this.f22188c = null;
        this.f22189d.setOnClickListener(null);
        this.f22189d = null;
        this.f22190e.setOnClickListener(null);
        this.f22190e = null;
    }

    @UiThread
    public CriminalSmsActivity_ViewBinding(CriminalSmsActivity criminalSmsActivity, View view) {
        this.f22186a = criminalSmsActivity;
        criminalSmsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalSmsActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSmsActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        criminalSmsActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSmsActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22187b = findRequiredView;
        findRequiredView.setOnClickListener(new C6255a(criminalSmsActivity));
        criminalSmsActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        criminalSmsActivity.mIncInput = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.inc_input, "field 'mIncInput'", LinearLayout.class);
        criminalSmsActivity.mIncComplete = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.inc_complete, "field 'mIncComplete'", LinearLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22188c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6256b(criminalSmsActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f22189d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6257c(criminalSmsActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_input, "method 'onViewClicked'");
        this.f22190e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6258d(criminalSmsActivity));
    }
}
