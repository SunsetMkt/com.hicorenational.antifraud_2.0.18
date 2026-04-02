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
public final class SignCommitVictimActivity_ViewBinding implements Unbinder {
    private SignCommitVictimActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13807b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignCommitVictimActivity a;

        a(SignCommitVictimActivity signCommitVictimActivity) {
            this.a = signCommitVictimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SignCommitVictimActivity_ViewBinding(SignCommitVictimActivity signCommitVictimActivity) {
        this(signCommitVictimActivity, signCommitVictimActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitVictimActivity signCommitVictimActivity = this.a;
        if (signCommitVictimActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signCommitVictimActivity.mIvBack = null;
        signCommitVictimActivity.mTvTitle = null;
        signCommitVictimActivity.mRecycleView = null;
        this.f13807b.setOnClickListener(null);
        this.f13807b = null;
    }

    @UiThread
    public SignCommitVictimActivity_ViewBinding(SignCommitVictimActivity signCommitVictimActivity, View view) {
        this.a = signCommitVictimActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitVictimActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13807b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitVictimActivity));
        signCommitVictimActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitVictimActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
