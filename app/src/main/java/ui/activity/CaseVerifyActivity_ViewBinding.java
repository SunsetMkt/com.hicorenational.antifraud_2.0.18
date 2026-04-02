package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CaseVerifyActivity_ViewBinding implements Unbinder {
    private CaseVerifyActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13239c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CaseVerifyActivity a;

        a(CaseVerifyActivity caseVerifyActivity) {
            this.a = caseVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CaseVerifyActivity a;

        b(CaseVerifyActivity caseVerifyActivity) {
            this.a = caseVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CaseVerifyActivity_ViewBinding(CaseVerifyActivity caseVerifyActivity) {
        this(caseVerifyActivity, caseVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CaseVerifyActivity caseVerifyActivity = this.a;
        if (caseVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        caseVerifyActivity.mTvTitle = null;
        caseVerifyActivity.mEtName = null;
        caseVerifyActivity.mEtID = null;
        this.f13238b.setOnClickListener(null);
        this.f13238b = null;
        this.f13239c.setOnClickListener(null);
        this.f13239c = null;
    }

    @UiThread
    public CaseVerifyActivity_ViewBinding(CaseVerifyActivity caseVerifyActivity, View view) {
        this.a = caseVerifyActivity;
        caseVerifyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        caseVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_name, "field 'mEtName'", EditText.class);
        caseVerifyActivity.mEtID = (EditText) Utils.findRequiredViewAsType(view, R.id.et_ID, "field 'mEtID'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13238b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(caseVerifyActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_start, "method 'onViewClicked'");
        this.f13239c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(caseVerifyActivity));
    }
}
