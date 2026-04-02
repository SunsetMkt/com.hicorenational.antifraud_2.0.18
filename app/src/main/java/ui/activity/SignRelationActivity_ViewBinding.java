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
public final class SignRelationActivity_ViewBinding implements Unbinder {
    private SignRelationActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13826b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignRelationActivity a;

        a(SignRelationActivity signRelationActivity) {
            this.a = signRelationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRelationActivity_ViewBinding(SignRelationActivity signRelationActivity) {
        this(signRelationActivity, signRelationActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRelationActivity signRelationActivity = this.a;
        if (signRelationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signRelationActivity.mTvTitle = null;
        signRelationActivity.mRecyclerview = null;
        this.f13826b.setOnClickListener(null);
        this.f13826b = null;
    }

    @UiThread
    public SignRelationActivity_ViewBinding(SignRelationActivity signRelationActivity, View view) {
        this.a = signRelationActivity;
        signRelationActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRelationActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13826b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signRelationActivity));
    }
}
