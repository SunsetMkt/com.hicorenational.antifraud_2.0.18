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
public class RecordHelpVideoActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private RecordHelpVideoActivity f22792a;

    /* renamed from: b */
    private View f22793b;

    /* renamed from: ui.activity.RecordHelpVideoActivity_ViewBinding$a */
    class C6468a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RecordHelpVideoActivity f22794a;

        C6468a(RecordHelpVideoActivity recordHelpVideoActivity) {
            this.f22794a = recordHelpVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22794a.onViewClicked(view);
        }
    }

    @UiThread
    public RecordHelpVideoActivity_ViewBinding(RecordHelpVideoActivity recordHelpVideoActivity) {
        this(recordHelpVideoActivity, recordHelpVideoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecordHelpVideoActivity recordHelpVideoActivity = this.f22792a;
        if (recordHelpVideoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22792a = null;
        recordHelpVideoActivity.mIvBack = null;
        recordHelpVideoActivity.mTvTitle = null;
        this.f22793b.setOnClickListener(null);
        this.f22793b = null;
    }

    @UiThread
    public RecordHelpVideoActivity_ViewBinding(RecordHelpVideoActivity recordHelpVideoActivity, View view) {
        this.f22792a = recordHelpVideoActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        recordHelpVideoActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22793b = findRequiredView;
        findRequiredView.setOnClickListener(new C6468a(recordHelpVideoActivity));
        recordHelpVideoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
    }
}
