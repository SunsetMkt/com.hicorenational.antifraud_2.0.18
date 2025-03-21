package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class SignCallActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignCallActivity f23092a;

    /* renamed from: b */
    private View f23093b;

    /* renamed from: ui.activity.SignCallActivity_ViewBinding$a */
    class C6578a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCallActivity f23094a;

        C6578a(SignCallActivity signCallActivity) {
            this.f23094a = signCallActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23094a.onViewClicked(view);
        }
    }

    @UiThread
    public SignCallActivity_ViewBinding(SignCallActivity signCallActivity) {
        this(signCallActivity, signCallActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCallActivity signCallActivity = this.f23092a;
        if (signCallActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23092a = null;
        signCallActivity.mTvTitle = null;
        signCallActivity.mRecyclerview = null;
        this.f23093b.setOnClickListener(null);
        this.f23093b = null;
    }

    @UiThread
    public SignCallActivity_ViewBinding(SignCallActivity signCallActivity, View view) {
        this.f23092a = signCallActivity;
        signCallActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCallActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23093b = findRequiredView;
        findRequiredView.setOnClickListener(new C6578a(signCallActivity));
    }
}
