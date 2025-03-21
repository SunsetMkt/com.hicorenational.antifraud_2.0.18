package p388ui.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class PreviewPictureActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PreviewPictureActivity f22721a;

    /* renamed from: b */
    private View f22722b;

    /* renamed from: ui.activity.PreviewPictureActivity_ViewBinding$a */
    class C6441a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PreviewPictureActivity f22723a;

        C6441a(PreviewPictureActivity previewPictureActivity) {
            this.f22723a = previewPictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22723a.onClick(view);
        }
    }

    @UiThread
    public PreviewPictureActivity_ViewBinding(PreviewPictureActivity previewPictureActivity) {
        this(previewPictureActivity, previewPictureActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f22721a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22721a = null;
        this.f22722b.setOnClickListener(null);
        this.f22722b = null;
    }

    @UiThread
    public PreviewPictureActivity_ViewBinding(PreviewPictureActivity previewPictureActivity, View view) {
        this.f22721a = previewPictureActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onClick'");
        this.f22722b = findRequiredView;
        findRequiredView.setOnClickListener(new C6441a(previewPictureActivity));
    }
}
