package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class EvidenceDiscActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private EvidenceDiscActivity f22290a;

    /* renamed from: b */
    private View f22291b;

    /* renamed from: c */
    private View f22292c;

    /* renamed from: ui.activity.EvidenceDiscActivity_ViewBinding$a */
    class C6296a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ EvidenceDiscActivity f22293a;

        C6296a(EvidenceDiscActivity evidenceDiscActivity) {
            this.f22293a = evidenceDiscActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22293a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.EvidenceDiscActivity_ViewBinding$b */
    class C6297b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ EvidenceDiscActivity f22295a;

        C6297b(EvidenceDiscActivity evidenceDiscActivity) {
            this.f22295a = evidenceDiscActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22295a.onViewClicked(view);
        }
    }

    @UiThread
    public EvidenceDiscActivity_ViewBinding(EvidenceDiscActivity evidenceDiscActivity) {
        this(evidenceDiscActivity, evidenceDiscActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EvidenceDiscActivity evidenceDiscActivity = this.f22290a;
        if (evidenceDiscActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22290a = null;
        evidenceDiscActivity.mIvBack = null;
        evidenceDiscActivity.mTvTitle = null;
        evidenceDiscActivity.mEtCaseDescribe = null;
        evidenceDiscActivity.mBtnCommit = null;
        this.f22291b.setOnClickListener(null);
        this.f22291b = null;
        this.f22292c.setOnClickListener(null);
        this.f22292c = null;
    }

    @UiThread
    public EvidenceDiscActivity_ViewBinding(EvidenceDiscActivity evidenceDiscActivity, View view) {
        this.f22290a = evidenceDiscActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        evidenceDiscActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22291b = findRequiredView;
        findRequiredView.setOnClickListener(new C6296a(evidenceDiscActivity));
        evidenceDiscActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        evidenceDiscActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.ed_describe, "field 'mEtCaseDescribe'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        evidenceDiscActivity.mBtnCommit = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22292c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6297b(evidenceDiscActivity));
    }
}
