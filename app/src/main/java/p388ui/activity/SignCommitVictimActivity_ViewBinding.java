package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class SignCommitVictimActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignCommitVictimActivity f23112a;

    /* renamed from: b */
    private View f23113b;

    /* renamed from: ui.activity.SignCommitVictimActivity_ViewBinding$a */
    class C6583a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCommitVictimActivity f23114a;

        C6583a(SignCommitVictimActivity signCommitVictimActivity) {
            this.f23114a = signCommitVictimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23114a.onClick(view);
        }
    }

    @UiThread
    public SignCommitVictimActivity_ViewBinding(SignCommitVictimActivity signCommitVictimActivity) {
        this(signCommitVictimActivity, signCommitVictimActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitVictimActivity signCommitVictimActivity = this.f23112a;
        if (signCommitVictimActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23112a = null;
        signCommitVictimActivity.mIvBack = null;
        signCommitVictimActivity.mTvTitle = null;
        signCommitVictimActivity.mRecycleView = null;
        this.f23113b.setOnClickListener(null);
        this.f23113b = null;
    }

    @UiThread
    public SignCommitVictimActivity_ViewBinding(SignCommitVictimActivity signCommitVictimActivity, View view) {
        this.f23112a = signCommitVictimActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitVictimActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23113b = findRequiredView;
        findRequiredView.setOnClickListener(new C6583a(signCommitVictimActivity));
        signCommitVictimActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitVictimActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
