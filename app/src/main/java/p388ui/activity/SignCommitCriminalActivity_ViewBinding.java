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
public final class SignCommitCriminalActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignCommitCriminalActivity f23108a;

    /* renamed from: b */
    private View f23109b;

    /* renamed from: ui.activity.SignCommitCriminalActivity_ViewBinding$a */
    class C6582a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCommitCriminalActivity f23110a;

        C6582a(SignCommitCriminalActivity signCommitCriminalActivity) {
            this.f23110a = signCommitCriminalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23110a.onClick(view);
        }
    }

    @UiThread
    public SignCommitCriminalActivity_ViewBinding(SignCommitCriminalActivity signCommitCriminalActivity) {
        this(signCommitCriminalActivity, signCommitCriminalActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitCriminalActivity signCommitCriminalActivity = this.f23108a;
        if (signCommitCriminalActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23108a = null;
        signCommitCriminalActivity.mIvBack = null;
        signCommitCriminalActivity.mTvTitle = null;
        signCommitCriminalActivity.mRecycleView = null;
        this.f23109b.setOnClickListener(null);
        this.f23109b = null;
    }

    @UiThread
    public SignCommitCriminalActivity_ViewBinding(SignCommitCriminalActivity signCommitCriminalActivity, View view) {
        this.f23108a = signCommitCriminalActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitCriminalActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23109b = findRequiredView;
        findRequiredView.setOnClickListener(new C6582a(signCommitCriminalActivity));
        signCommitCriminalActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitCriminalActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
