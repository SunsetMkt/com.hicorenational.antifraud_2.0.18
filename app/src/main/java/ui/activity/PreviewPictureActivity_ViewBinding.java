package ui.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewPictureActivity_ViewBinding implements Unbinder {
    private PreviewPictureActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13593b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PreviewPictureActivity a;

        a(PreviewPictureActivity previewPictureActivity) {
            this.a = previewPictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public PreviewPictureActivity_ViewBinding(PreviewPictureActivity previewPictureActivity) {
        this(previewPictureActivity, previewPictureActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        this.f13593b.setOnClickListener(null);
        this.f13593b = null;
    }

    @UiThread
    public PreviewPictureActivity_ViewBinding(PreviewPictureActivity previewPictureActivity, View view) {
        this.a = previewPictureActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onClick'");
        this.f13593b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(previewPictureActivity));
    }
}
