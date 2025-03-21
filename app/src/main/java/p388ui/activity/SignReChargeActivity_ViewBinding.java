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
public final class SignReChargeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignReChargeActivity f23139a;

    /* renamed from: b */
    private View f23140b;

    /* renamed from: ui.activity.SignReChargeActivity_ViewBinding$a */
    class C6588a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignReChargeActivity f23141a;

        C6588a(SignReChargeActivity signReChargeActivity) {
            this.f23141a = signReChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23141a.onClick(view);
        }
    }

    @UiThread
    public SignReChargeActivity_ViewBinding(SignReChargeActivity signReChargeActivity) {
        this(signReChargeActivity, signReChargeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignReChargeActivity signReChargeActivity = this.f23139a;
        if (signReChargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23139a = null;
        signReChargeActivity.mIvBack = null;
        signReChargeActivity.mTvTitle = null;
        signReChargeActivity.mRecycleView = null;
        this.f23140b.setOnClickListener(null);
        this.f23140b = null;
    }

    @UiThread
    public SignReChargeActivity_ViewBinding(SignReChargeActivity signReChargeActivity, View view) {
        this.f23139a = signReChargeActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signReChargeActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23140b = findRequiredView;
        findRequiredView.setOnClickListener(new C6588a(signReChargeActivity));
        signReChargeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signReChargeActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
