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
public final class SignCommitWebsiteActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignCommitWebsiteActivity f23116a;

    /* renamed from: b */
    private View f23117b;

    /* renamed from: ui.activity.SignCommitWebsiteActivity_ViewBinding$a */
    class C6584a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCommitWebsiteActivity f23118a;

        C6584a(SignCommitWebsiteActivity signCommitWebsiteActivity) {
            this.f23118a = signCommitWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23118a.onClick(view);
        }
    }

    @UiThread
    public SignCommitWebsiteActivity_ViewBinding(SignCommitWebsiteActivity signCommitWebsiteActivity) {
        this(signCommitWebsiteActivity, signCommitWebsiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitWebsiteActivity signCommitWebsiteActivity = this.f23116a;
        if (signCommitWebsiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23116a = null;
        signCommitWebsiteActivity.mIvBack = null;
        signCommitWebsiteActivity.mTvTitle = null;
        signCommitWebsiteActivity.mRecycleView = null;
        this.f23117b.setOnClickListener(null);
        this.f23117b = null;
    }

    @UiThread
    public SignCommitWebsiteActivity_ViewBinding(SignCommitWebsiteActivity signCommitWebsiteActivity, View view) {
        this.f23116a = signCommitWebsiteActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitWebsiteActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23117b = findRequiredView;
        findRequiredView.setOnClickListener(new C6584a(signCommitWebsiteActivity));
        signCommitWebsiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitWebsiteActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
