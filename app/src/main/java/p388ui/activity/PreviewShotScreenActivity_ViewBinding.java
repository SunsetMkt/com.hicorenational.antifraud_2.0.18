package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class PreviewShotScreenActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PreviewShotScreenActivity f22726a;

    @UiThread
    public PreviewShotScreenActivity_ViewBinding(PreviewShotScreenActivity previewShotScreenActivity) {
        this(previewShotScreenActivity, previewShotScreenActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreviewShotScreenActivity previewShotScreenActivity = this.f22726a;
        if (previewShotScreenActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22726a = null;
        previewShotScreenActivity.ivShotScreenPreview = null;
    }

    @UiThread
    public PreviewShotScreenActivity_ViewBinding(PreviewShotScreenActivity previewShotScreenActivity, View view) {
        this.f22726a = previewShotScreenActivity;
        previewShotScreenActivity.ivShotScreenPreview = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_shot_screen_preview, "field 'ivShotScreenPreview'", ImageView.class);
    }
}
