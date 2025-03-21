package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class RecordHelpActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private RecordHelpActivity f22788a;

    /* renamed from: b */
    private View f22789b;

    /* renamed from: ui.activity.RecordHelpActivity_ViewBinding$a */
    class C6467a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RecordHelpActivity f22790a;

        C6467a(RecordHelpActivity recordHelpActivity) {
            this.f22790a = recordHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22790a.onViewClicked(view);
        }
    }

    @UiThread
    public RecordHelpActivity_ViewBinding(RecordHelpActivity recordHelpActivity) {
        this(recordHelpActivity, recordHelpActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecordHelpActivity recordHelpActivity = this.f22788a;
        if (recordHelpActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22788a = null;
        recordHelpActivity.mIvBack = null;
        recordHelpActivity.mTvTitle = null;
        this.f22789b.setOnClickListener(null);
        this.f22789b = null;
    }

    @UiThread
    public RecordHelpActivity_ViewBinding(RecordHelpActivity recordHelpActivity, View view) {
        this.f22788a = recordHelpActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        recordHelpActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22789b = findRequiredView;
        findRequiredView.setOnClickListener(new C6467a(recordHelpActivity));
        recordHelpActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
    }
}
