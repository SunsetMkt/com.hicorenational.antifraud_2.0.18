package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ReChargeActivity_ViewBinding implements Unbinder {
    private ReChargeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13614d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReChargeActivity a;

        a(ReChargeActivity reChargeActivity) {
            this.a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ReChargeActivity a;

        b(ReChargeActivity reChargeActivity) {
            this.a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ReChargeActivity a;

        c(ReChargeActivity reChargeActivity) {
            this.a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReChargeActivity_ViewBinding(ReChargeActivity reChargeActivity) {
        this(reChargeActivity, reChargeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReChargeActivity reChargeActivity = this.a;
        if (reChargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reChargeActivity.mIvBack = null;
        reChargeActivity.mTvTitle = null;
        reChargeActivity.mLlAddLayout = null;
        reChargeActivity.mTvAdd = null;
        reChargeActivity.mRecycleView = null;
        reChargeActivity.mTvCommitTip = null;
        reChargeActivity.mBtnCommit = null;
        this.f13612b.setOnClickListener(null);
        this.f13612b = null;
        this.f13613c.setOnClickListener(null);
        this.f13613c = null;
        this.f13614d.setOnClickListener(null);
        this.f13614d = null;
    }

    @UiThread
    public ReChargeActivity_ViewBinding(ReChargeActivity reChargeActivity, View view) {
        this.a = reChargeActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reChargeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13612b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reChargeActivity));
        reChargeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        reChargeActivity.mLlAddLayout = viewFindRequiredView2;
        this.f13613c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reChargeActivity));
        reChargeActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reChargeActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        reChargeActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        reChargeActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13614d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(reChargeActivity));
    }
}
