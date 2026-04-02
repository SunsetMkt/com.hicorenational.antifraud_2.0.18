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
public final class SignReChargeActivity_ViewBinding implements Unbinder {
    private SignReChargeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13822b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignReChargeActivity a;

        a(SignReChargeActivity signReChargeActivity) {
            this.a = signReChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public SignReChargeActivity_ViewBinding(SignReChargeActivity signReChargeActivity) {
        this(signReChargeActivity, signReChargeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignReChargeActivity signReChargeActivity = this.a;
        if (signReChargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signReChargeActivity.mIvBack = null;
        signReChargeActivity.mTvTitle = null;
        signReChargeActivity.mRecycleView = null;
        this.f13822b.setOnClickListener(null);
        this.f13822b = null;
    }

    @UiThread
    public SignReChargeActivity_ViewBinding(SignReChargeActivity signReChargeActivity, View view) {
        this.a = signReChargeActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signReChargeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13822b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signReChargeActivity));
        signReChargeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signReChargeActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
