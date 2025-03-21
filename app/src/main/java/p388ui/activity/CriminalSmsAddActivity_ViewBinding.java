package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CriminalSmsAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalSmsAddActivity f22204a;

    /* renamed from: b */
    private View f22205b;

    /* renamed from: c */
    private View f22206c;

    /* renamed from: ui.activity.CriminalSmsAddActivity_ViewBinding$a */
    class C6262a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsAddActivity f22207a;

        C6262a(CriminalSmsAddActivity criminalSmsAddActivity) {
            this.f22207a = criminalSmsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22207a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSmsAddActivity_ViewBinding$b */
    class C6263b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSmsAddActivity f22209a;

        C6263b(CriminalSmsAddActivity criminalSmsAddActivity) {
            this.f22209a = criminalSmsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22209a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsAddActivity_ViewBinding(CriminalSmsAddActivity criminalSmsAddActivity) {
        this(criminalSmsAddActivity, criminalSmsAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsAddActivity criminalSmsAddActivity = this.f22204a;
        if (criminalSmsAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22204a = null;
        criminalSmsAddActivity.mTvTitle = null;
        criminalSmsAddActivity.mTvType = null;
        this.f22205b.setOnClickListener(null);
        this.f22205b = null;
        this.f22206c.setOnClickListener(null);
        this.f22206c = null;
    }

    @UiThread
    public CriminalSmsAddActivity_ViewBinding(CriminalSmsAddActivity criminalSmsAddActivity, View view) {
        this.f22204a = criminalSmsAddActivity;
        criminalSmsAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_type, "field 'mTvType' and method 'onViewClicked'");
        criminalSmsAddActivity.mTvType = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_type, "field 'mTvType'", TextView.class);
        this.f22205b = findRequiredView;
        findRequiredView.setOnClickListener(new C6262a(criminalSmsAddActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22206c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6263b(criminalSmsAddActivity));
    }
}
