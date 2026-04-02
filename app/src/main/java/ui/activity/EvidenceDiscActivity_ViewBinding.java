package ui.activity;

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
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class EvidenceDiscActivity_ViewBinding implements Unbinder {
    private EvidenceDiscActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13355c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ EvidenceDiscActivity a;

        a(EvidenceDiscActivity evidenceDiscActivity) {
            this.a = evidenceDiscActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ EvidenceDiscActivity a;

        b(EvidenceDiscActivity evidenceDiscActivity) {
            this.a = evidenceDiscActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public EvidenceDiscActivity_ViewBinding(EvidenceDiscActivity evidenceDiscActivity) {
        this(evidenceDiscActivity, evidenceDiscActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EvidenceDiscActivity evidenceDiscActivity = this.a;
        if (evidenceDiscActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        evidenceDiscActivity.mIvBack = null;
        evidenceDiscActivity.mTvTitle = null;
        evidenceDiscActivity.mEtCaseDescribe = null;
        evidenceDiscActivity.mBtnCommit = null;
        this.f13354b.setOnClickListener(null);
        this.f13354b = null;
        this.f13355c.setOnClickListener(null);
        this.f13355c = null;
    }

    @UiThread
    public EvidenceDiscActivity_ViewBinding(EvidenceDiscActivity evidenceDiscActivity, View view) {
        this.a = evidenceDiscActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        evidenceDiscActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13354b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(evidenceDiscActivity));
        evidenceDiscActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        evidenceDiscActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.ed_describe, "field 'mEtCaseDescribe'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        evidenceDiscActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13355c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(evidenceDiscActivity));
    }
}
