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
public final class SignCommitCriminalActivity_ViewBinding implements Unbinder {
    private SignCommitCriminalActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13805b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignCommitCriminalActivity a;

        a(SignCommitCriminalActivity signCommitCriminalActivity) {
            this.a = signCommitCriminalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SignCommitCriminalActivity_ViewBinding(SignCommitCriminalActivity signCommitCriminalActivity) {
        this(signCommitCriminalActivity, signCommitCriminalActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitCriminalActivity signCommitCriminalActivity = this.a;
        if (signCommitCriminalActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signCommitCriminalActivity.mIvBack = null;
        signCommitCriminalActivity.mTvTitle = null;
        signCommitCriminalActivity.mRecycleView = null;
        this.f13805b.setOnClickListener(null);
        this.f13805b = null;
    }

    @UiThread
    public SignCommitCriminalActivity_ViewBinding(SignCommitCriminalActivity signCommitCriminalActivity, View view) {
        this.a = signCommitCriminalActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitCriminalActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13805b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitCriminalActivity));
        signCommitCriminalActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitCriminalActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
