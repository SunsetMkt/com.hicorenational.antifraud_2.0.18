package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AppUploadActivity_ViewBinding implements Unbinder {
    private AppUploadActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13111b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AppUploadActivity a;

        a(AppUploadActivity appUploadActivity) {
            this.a = appUploadActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AppUploadActivity_ViewBinding(AppUploadActivity appUploadActivity) {
        this(appUploadActivity, appUploadActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppUploadActivity appUploadActivity = this.a;
        if (appUploadActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        appUploadActivity.mTvTitle = null;
        appUploadActivity.mRecyclerview = null;
        this.f13111b.setOnClickListener(null);
        this.f13111b = null;
    }

    @UiThread
    public AppUploadActivity_ViewBinding(AppUploadActivity appUploadActivity, View view) {
        this.a = appUploadActivity;
        appUploadActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        appUploadActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13111b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appUploadActivity));
    }
}
