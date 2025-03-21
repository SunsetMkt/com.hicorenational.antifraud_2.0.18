package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CriminalSmsSelectActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalSmsSelectActivity f22214a;

    /* renamed from: b */
    private View f22215b;

    /* renamed from: c */
    private View f22216c;

    /* renamed from: d */
    private View f22217d;

    /* renamed from: ui.activity.CriminalSmsSelectActivity_ViewBinding$a */
    class C6267a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsSelectActivity f22218a;

        C6267a(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.f22218a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22218a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSmsSelectActivity_ViewBinding$b */
    class C6268b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsSelectActivity f22220a;

        C6268b(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.f22220a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22220a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSmsSelectActivity_ViewBinding$c */
    class C6269c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsSelectActivity f22222a;

        C6269c(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.f22222a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22222a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsSelectActivity_ViewBinding(CriminalSmsSelectActivity criminalSmsSelectActivity) {
        this(criminalSmsSelectActivity, criminalSmsSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsSelectActivity criminalSmsSelectActivity = this.f22214a;
        if (criminalSmsSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22214a = null;
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
        this.f22215b.setOnClickListener(null);
        this.f22215b = null;
        this.f22216c.setOnClickListener(null);
        this.f22216c = null;
        this.f22217d.setOnClickListener(null);
        this.f22217d = null;
    }

    @UiThread
    public CriminalSmsSelectActivity_ViewBinding(CriminalSmsSelectActivity criminalSmsSelectActivity, View view) {
        this.f22214a = criminalSmsSelectActivity;
        criminalSmsSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSmsSelectActivity.mBtnCommit = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f22215b = findRequiredView;
        findRequiredView.setOnClickListener(new C6267a(criminalSmsSelectActivity));
        criminalSmsSelectActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        criminalSmsSelectActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        criminalSmsSelectActivity.mTvDescribe = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_describe, "field 'mTvDescribe'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        criminalSmsSelectActivity.mTvTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f22216c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6268b(criminalSmsSelectActivity));
        criminalSmsSelectActivity.mRbYes = (RadioButton) Utils.findRequiredViewAsType(view, C2113R.id.rb_yes, "field 'mRbYes'", RadioButton.class);
        criminalSmsSelectActivity.mRbNo = (RadioButton) Utils.findRequiredViewAsType(view, C2113R.id.rb_no, "field 'mRbNo'", RadioButton.class);
        criminalSmsSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSmsSelectActivity.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22217d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6269c(criminalSmsSelectActivity));
    }
}
