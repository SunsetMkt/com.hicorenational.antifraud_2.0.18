package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SignCommitAppActivity_ViewBinding implements Unbinder {
    private SignCommitAppActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13803b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignCommitAppActivity a;

        a(SignCommitAppActivity signCommitAppActivity) {
            this.a = signCommitAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SignCommitAppActivity_ViewBinding(SignCommitAppActivity signCommitAppActivity) {
        this(signCommitAppActivity, signCommitAppActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitAppActivity signCommitAppActivity = this.a;
        if (signCommitAppActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signCommitAppActivity.mIvBack = null;
        signCommitAppActivity.mTvTitle = null;
        signCommitAppActivity.mRecycleView = null;
        this.f13803b.setOnClickListener(null);
        this.f13803b = null;
    }

    @UiThread
    public SignCommitAppActivity_ViewBinding(SignCommitAppActivity signCommitAppActivity, View view) {
        this.a = signCommitAppActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitAppActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13803b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitAppActivity));
        signCommitAppActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitAppActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
