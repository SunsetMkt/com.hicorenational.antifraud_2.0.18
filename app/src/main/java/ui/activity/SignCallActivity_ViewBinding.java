package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SignCallActivity_ViewBinding implements Unbinder {
    private SignCallActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13797b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignCallActivity a;

        a(SignCallActivity signCallActivity) {
            this.a = signCallActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SignCallActivity_ViewBinding(SignCallActivity signCallActivity) {
        this(signCallActivity, signCallActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCallActivity signCallActivity = this.a;
        if (signCallActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signCallActivity.mTvTitle = null;
        signCallActivity.mRecyclerview = null;
        this.f13797b.setOnClickListener(null);
        this.f13797b = null;
    }

    @UiThread
    public SignCallActivity_ViewBinding(SignCallActivity signCallActivity, View view) {
        this.a = signCallActivity;
        signCallActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCallActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13797b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCallActivity));
    }
}
