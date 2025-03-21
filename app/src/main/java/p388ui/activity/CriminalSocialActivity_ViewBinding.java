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
public class CriminalSocialActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalSocialActivity f22225a;

    /* renamed from: b */
    private View f22226b;

    /* renamed from: c */
    private View f22227c;

    /* renamed from: d */
    private View f22228d;

    /* renamed from: ui.activity.CriminalSocialActivity_ViewBinding$a */
    class C6271a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSocialActivity f22229a;

        C6271a(CriminalSocialActivity criminalSocialActivity) {
            this.f22229a = criminalSocialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22229a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSocialActivity_ViewBinding$b */
    class C6272b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSocialActivity f22231a;

        C6272b(CriminalSocialActivity criminalSocialActivity) {
            this.f22231a = criminalSocialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22231a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSocialActivity_ViewBinding$c */
    class C6273c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSocialActivity f22233a;

        C6273c(CriminalSocialActivity criminalSocialActivity) {
            this.f22233a = criminalSocialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22233a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSocialActivity_ViewBinding(CriminalSocialActivity criminalSocialActivity) {
        this(criminalSocialActivity, criminalSocialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSocialActivity criminalSocialActivity = this.f22225a;
        if (criminalSocialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22225a = null;
        criminalSocialActivity.mTvTitle = null;
        criminalSocialActivity.mRecyclerview = null;
        criminalSocialActivity.mTvSelectTip = null;
        criminalSocialActivity.mTvCommit = null;
        criminalSocialActivity.mBtnCommit = null;
        criminalSocialActivity.mTvTip = null;
        criminalSocialActivity.mLlSelect = null;
        criminalSocialActivity.mIncComplete = null;
        this.f22226b.setOnClickListener(null);
        this.f22226b = null;
        this.f22227c.setOnClickListener(null);
        this.f22227c = null;
        this.f22228d.setOnClickListener(null);
        this.f22228d = null;
    }

    @UiThread
    public CriminalSocialActivity_ViewBinding(CriminalSocialActivity criminalSocialActivity, View view) {
        this.f22225a = criminalSocialActivity;
        criminalSocialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalSocialActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSocialActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        criminalSocialActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSocialActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22226b = findRequiredView;
        findRequiredView.setOnClickListener(new C6271a(criminalSocialActivity));
        criminalSocialActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip, "field 'mTvTip'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_select, "field 'mLlSelect' and method 'onViewClicked'");
        criminalSocialActivity.mLlSelect = (LinearLayout) Utils.castView(findRequiredView2, C2113R.id.ll_select, "field 'mLlSelect'", LinearLayout.class);
        this.f22227c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6272b(criminalSocialActivity));
        criminalSocialActivity.mIncComplete = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.inc_complete, "field 'mIncComplete'", LinearLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22228d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6273c(criminalSocialActivity));
    }
}
