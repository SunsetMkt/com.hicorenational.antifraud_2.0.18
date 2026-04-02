package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class RecordHelpVideoActivity_ViewBinding implements Unbinder {
    private RecordHelpVideoActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13629b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ RecordHelpVideoActivity a;

        a(RecordHelpVideoActivity recordHelpVideoActivity) {
            this.a = recordHelpVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public RecordHelpVideoActivity_ViewBinding(RecordHelpVideoActivity recordHelpVideoActivity) {
        this(recordHelpVideoActivity, recordHelpVideoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecordHelpVideoActivity recordHelpVideoActivity = this.a;
        if (recordHelpVideoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        recordHelpVideoActivity.mIvBack = null;
        recordHelpVideoActivity.mTvTitle = null;
        this.f13629b.setOnClickListener(null);
        this.f13629b = null;
    }

    @UiThread
    public RecordHelpVideoActivity_ViewBinding(RecordHelpVideoActivity recordHelpVideoActivity, View view) {
        this.a = recordHelpVideoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        recordHelpVideoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13629b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(recordHelpVideoActivity));
        recordHelpVideoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    }
}
