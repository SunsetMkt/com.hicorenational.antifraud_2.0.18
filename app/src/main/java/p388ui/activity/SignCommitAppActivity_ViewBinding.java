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
public final class SignCommitAppActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignCommitAppActivity f23104a;

    /* renamed from: b */
    private View f23105b;

    /* renamed from: ui.activity.SignCommitAppActivity_ViewBinding$a */
    class C6581a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCommitAppActivity f23106a;

        C6581a(SignCommitAppActivity signCommitAppActivity) {
            this.f23106a = signCommitAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23106a.onClick(view);
        }
    }

    @UiThread
    public SignCommitAppActivity_ViewBinding(SignCommitAppActivity signCommitAppActivity) {
        this(signCommitAppActivity, signCommitAppActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitAppActivity signCommitAppActivity = this.f23104a;
        if (signCommitAppActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23104a = null;
        signCommitAppActivity.mIvBack = null;
        signCommitAppActivity.mTvTitle = null;
        signCommitAppActivity.mRecycleView = null;
        this.f23105b.setOnClickListener(null);
        this.f23105b = null;
    }

    @UiThread
    public SignCommitAppActivity_ViewBinding(SignCommitAppActivity signCommitAppActivity, View view) {
        this.f23104a = signCommitAppActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitAppActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23105b = findRequiredView;
        findRequiredView.setOnClickListener(new C6581a(signCommitAppActivity));
        signCommitAppActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitAppActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
