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
public class CriminalSocialActivity_ViewBinding implements Unbinder {
    private CriminalSocialActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13320d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSocialActivity a;

        a(CriminalSocialActivity criminalSocialActivity) {
            this.a = criminalSocialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSocialActivity a;

        b(CriminalSocialActivity criminalSocialActivity) {
            this.a = criminalSocialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSocialActivity a;

        c(CriminalSocialActivity criminalSocialActivity) {
            this.a = criminalSocialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSocialActivity_ViewBinding(CriminalSocialActivity criminalSocialActivity) {
        this(criminalSocialActivity, criminalSocialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSocialActivity criminalSocialActivity = this.a;
        if (criminalSocialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        criminalSocialActivity.mTvTitle = null;
        criminalSocialActivity.mRecyclerview = null;
        criminalSocialActivity.mTvSelectTip = null;
        criminalSocialActivity.mTvCommit = null;
        criminalSocialActivity.mBtnCommit = null;
        criminalSocialActivity.mTvTip = null;
        criminalSocialActivity.mLlSelect = null;
        criminalSocialActivity.mIncComplete = null;
        this.f13318b.setOnClickListener(null);
        this.f13318b = null;
        this.f13319c.setOnClickListener(null);
        this.f13319c = null;
        this.f13320d.setOnClickListener(null);
        this.f13320d = null;
    }

    @UiThread
    public CriminalSocialActivity_ViewBinding(CriminalSocialActivity criminalSocialActivity, View view) {
        this.a = criminalSocialActivity;
        criminalSocialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalSocialActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSocialActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        criminalSocialActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSocialActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13318b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSocialActivity));
        criminalSocialActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTvTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_select, "field 'mLlSelect' and method 'onViewClicked'");
        criminalSocialActivity.mLlSelect = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_select, "field 'mLlSelect'", LinearLayout.class);
        this.f13319c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSocialActivity));
        criminalSocialActivity.mIncComplete = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.inc_complete, "field 'mIncComplete'", LinearLayout.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13320d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalSocialActivity));
    }
}
