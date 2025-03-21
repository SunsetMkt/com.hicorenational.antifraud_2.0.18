package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AppUploadActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AppUploadActivity f21848a;

    /* renamed from: b */
    private View f21849b;

    /* renamed from: ui.activity.AppUploadActivity_ViewBinding$a */
    class C6131a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AppUploadActivity f21850a;

        C6131a(AppUploadActivity appUploadActivity) {
            this.f21850a = appUploadActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21850a.onViewClicked(view);
        }
    }

    @UiThread
    public AppUploadActivity_ViewBinding(AppUploadActivity appUploadActivity) {
        this(appUploadActivity, appUploadActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppUploadActivity appUploadActivity = this.f21848a;
        if (appUploadActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21848a = null;
        appUploadActivity.mTvTitle = null;
        appUploadActivity.mRecyclerview = null;
        this.f21849b.setOnClickListener(null);
        this.f21849b = null;
    }

    @UiThread
    public AppUploadActivity_ViewBinding(AppUploadActivity appUploadActivity, View view) {
        this.f21848a = appUploadActivity;
        appUploadActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        appUploadActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21849b = findRequiredView;
        findRequiredView.setOnClickListener(new C6131a(appUploadActivity));
    }
}
