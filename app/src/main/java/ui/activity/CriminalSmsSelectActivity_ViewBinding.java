package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CriminalSmsSelectActivity_ViewBinding implements Unbinder {
    private CriminalSmsSelectActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13314d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsSelectActivity a;

        a(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsSelectActivity a;

        b(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsSelectActivity a;

        c(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsSelectActivity_ViewBinding(CriminalSmsSelectActivity criminalSmsSelectActivity) {
        this(criminalSmsSelectActivity, criminalSmsSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsSelectActivity criminalSmsSelectActivity = this.a;
        if (criminalSmsSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        criminalSmsSelectActivity.mTvTitle = null;
        criminalSmsSelectActivity.mBtnCommit = null;
        criminalSmsSelectActivity.mEtVictimPhone = null;
        criminalSmsSelectActivity.mEtPhone = null;
        criminalSmsSelectActivity.mTvDescribe = null;
        criminalSmsSelectActivity.mTvTime = null;
        criminalSmsSelectActivity.mRbYes = null;
        criminalSmsSelectActivity.mRbNo = null;
        criminalSmsSelectActivity.mRecyclerview = null;
        criminalSmsSelectActivity.mLlPicture = null;
        this.f13312b.setOnClickListener(null);
        this.f13312b = null;
        this.f13313c.setOnClickListener(null);
        this.f13313c = null;
        this.f13314d.setOnClickListener(null);
        this.f13314d = null;
    }

    @UiThread
    public CriminalSmsSelectActivity_ViewBinding(CriminalSmsSelectActivity criminalSmsSelectActivity, View view) {
        this.a = criminalSmsSelectActivity;
        criminalSmsSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSmsSelectActivity.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f13312b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSmsSelectActivity));
        criminalSmsSelectActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        criminalSmsSelectActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        criminalSmsSelectActivity.mTvDescribe = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_describe, "field 'mTvDescribe'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        criminalSmsSelectActivity.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f13313c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSmsSelectActivity));
        criminalSmsSelectActivity.mRbYes = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_yes, "field 'mRbYes'", RadioButton.class);
        criminalSmsSelectActivity.mRbNo = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_no, "field 'mRbNo'", RadioButton.class);
        criminalSmsSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSmsSelectActivity.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13314d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalSmsSelectActivity));
    }
}
