package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CriminalSmsAddActivity_ViewBinding implements Unbinder {
    private CriminalSmsAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13309c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsAddActivity a;

        a(CriminalSmsAddActivity criminalSmsAddActivity) {
            this.a = criminalSmsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSmsAddActivity a;

        b(CriminalSmsAddActivity criminalSmsAddActivity) {
            this.a = criminalSmsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsAddActivity_ViewBinding(CriminalSmsAddActivity criminalSmsAddActivity) {
        this(criminalSmsAddActivity, criminalSmsAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsAddActivity criminalSmsAddActivity = this.a;
        if (criminalSmsAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        criminalSmsAddActivity.mTvTitle = null;
        criminalSmsAddActivity.mTvType = null;
        this.f13308b.setOnClickListener(null);
        this.f13308b = null;
        this.f13309c.setOnClickListener(null);
        this.f13309c = null;
    }

    @UiThread
    public CriminalSmsAddActivity_ViewBinding(CriminalSmsAddActivity criminalSmsAddActivity, View view) {
        this.a = criminalSmsAddActivity;
        criminalSmsAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_type, "field 'mTvType' and method 'onViewClicked'");
        criminalSmsAddActivity.mTvType = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_type, "field 'mTvType'", TextView.class);
        this.f13308b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSmsAddActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13309c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSmsAddActivity));
    }
}
