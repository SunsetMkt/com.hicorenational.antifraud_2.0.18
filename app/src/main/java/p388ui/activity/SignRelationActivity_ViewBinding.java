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
public final class SignRelationActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignRelationActivity f23147a;

    /* renamed from: b */
    private View f23148b;

    /* renamed from: ui.activity.SignRelationActivity_ViewBinding$a */
    class C6590a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignRelationActivity f23149a;

        C6590a(SignRelationActivity signRelationActivity) {
            this.f23149a = signRelationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23149a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRelationActivity_ViewBinding(SignRelationActivity signRelationActivity) {
        this(signRelationActivity, signRelationActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRelationActivity signRelationActivity = this.f23147a;
        if (signRelationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23147a = null;
        signRelationActivity.mTvTitle = null;
        signRelationActivity.mRecyclerview = null;
        this.f23148b.setOnClickListener(null);
        this.f23148b = null;
    }

    @UiThread
    public SignRelationActivity_ViewBinding(SignRelationActivity signRelationActivity, View view) {
        this.f23147a = signRelationActivity;
        signRelationActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRelationActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23148b = findRequiredView;
        findRequiredView.setOnClickListener(new C6590a(signRelationActivity));
    }
}
