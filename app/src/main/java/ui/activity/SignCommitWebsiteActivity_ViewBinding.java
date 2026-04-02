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
public final class SignCommitWebsiteActivity_ViewBinding implements Unbinder {
    private SignCommitWebsiteActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13809b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignCommitWebsiteActivity a;

        a(SignCommitWebsiteActivity signCommitWebsiteActivity) {
            this.a = signCommitWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SignCommitWebsiteActivity_ViewBinding(SignCommitWebsiteActivity signCommitWebsiteActivity) {
        this(signCommitWebsiteActivity, signCommitWebsiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitWebsiteActivity signCommitWebsiteActivity = this.a;
        if (signCommitWebsiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signCommitWebsiteActivity.mIvBack = null;
        signCommitWebsiteActivity.mTvTitle = null;
        signCommitWebsiteActivity.mRecycleView = null;
        this.f13809b.setOnClickListener(null);
        this.f13809b = null;
    }

    @UiThread
    public SignCommitWebsiteActivity_ViewBinding(SignCommitWebsiteActivity signCommitWebsiteActivity, View view) {
        this.a = signCommitWebsiteActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitWebsiteActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13809b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitWebsiteActivity));
        signCommitWebsiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitWebsiteActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
