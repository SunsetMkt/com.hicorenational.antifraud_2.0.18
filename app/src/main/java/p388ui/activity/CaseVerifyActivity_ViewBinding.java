package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CaseVerifyActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CaseVerifyActivity f22076a;

    /* renamed from: b */
    private View f22077b;

    /* renamed from: c */
    private View f22078c;

    /* renamed from: ui.activity.CaseVerifyActivity_ViewBinding$a */
    class C6212a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseVerifyActivity f22079a;

        C6212a(CaseVerifyActivity caseVerifyActivity) {
            this.f22079a = caseVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22079a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseVerifyActivity_ViewBinding$b */
    class C6213b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseVerifyActivity f22081a;

        C6213b(CaseVerifyActivity caseVerifyActivity) {
            this.f22081a = caseVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22081a.onViewClicked(view);
        }
    }

    @UiThread
    public CaseVerifyActivity_ViewBinding(CaseVerifyActivity caseVerifyActivity) {
        this(caseVerifyActivity, caseVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CaseVerifyActivity caseVerifyActivity = this.f22076a;
        if (caseVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22076a = null;
        caseVerifyActivity.mTvTitle = null;
        caseVerifyActivity.mEtName = null;
        caseVerifyActivity.mEtID = null;
        this.f22077b.setOnClickListener(null);
        this.f22077b = null;
        this.f22078c.setOnClickListener(null);
        this.f22078c = null;
    }

    @UiThread
    public CaseVerifyActivity_ViewBinding(CaseVerifyActivity caseVerifyActivity, View view) {
        this.f22076a = caseVerifyActivity;
        caseVerifyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        caseVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_name, "field 'mEtName'", EditText.class);
        caseVerifyActivity.mEtID = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_ID, "field 'mEtID'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22077b = findRequiredView;
        findRequiredView.setOnClickListener(new C6212a(caseVerifyActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_start, "method 'onViewClicked'");
        this.f22078c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6213b(caseVerifyActivity));
    }
}
