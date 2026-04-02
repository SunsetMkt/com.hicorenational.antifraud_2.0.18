package ui.activity;

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
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CriminalSmsActivity_ViewBinding implements Unbinder {
    private CriminalSmsActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13301e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsActivity a;

        a(CriminalSmsActivity criminalSmsActivity) {
            this.a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsActivity a;

        b(CriminalSmsActivity criminalSmsActivity) {
            this.a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsActivity a;

        c(CriminalSmsActivity criminalSmsActivity) {
            this.a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsActivity a;

        d(CriminalSmsActivity criminalSmsActivity) {
            this.a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsActivity_ViewBinding(CriminalSmsActivity criminalSmsActivity) {
        this(criminalSmsActivity, criminalSmsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsActivity criminalSmsActivity = this.a;
        if (criminalSmsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        criminalSmsActivity.mTvTitle = null;
        criminalSmsActivity.mRecyclerview = null;
        criminalSmsActivity.mTvSelectTip = null;
        criminalSmsActivity.mTvCommitTip = null;
        criminalSmsActivity.mBtnCommit = null;
        criminalSmsActivity.mTvInputTip = null;
        criminalSmsActivity.mIncInput = null;
        criminalSmsActivity.mIncComplete = null;
        this.f13298b.setOnClickListener(null);
        this.f13298b = null;
        this.f13299c.setOnClickListener(null);
        this.f13299c = null;
        this.f13300d.setOnClickListener(null);
        this.f13300d = null;
        this.f13301e.setOnClickListener(null);
        this.f13301e = null;
    }

    @UiThread
    public CriminalSmsActivity_ViewBinding(CriminalSmsActivity criminalSmsActivity, View view) {
        this.a = criminalSmsActivity;
        criminalSmsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalSmsActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSmsActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        criminalSmsActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSmsActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13298b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSmsActivity));
        criminalSmsActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        criminalSmsActivity.mIncInput = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.inc_input, "field 'mIncInput'", LinearLayout.class);
        criminalSmsActivity.mIncComplete = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.inc_complete, "field 'mIncComplete'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13299c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSmsActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13300d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalSmsActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f13301e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(criminalSmsActivity));
    }
}
