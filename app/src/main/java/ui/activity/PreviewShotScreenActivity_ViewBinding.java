package ui.activity;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewShotScreenActivity_ViewBinding implements Unbinder {
    private PreviewShotScreenActivity a;

    @UiThread
    public PreviewShotScreenActivity_ViewBinding(PreviewShotScreenActivity previewShotScreenActivity) {
        this(previewShotScreenActivity, previewShotScreenActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreviewShotScreenActivity previewShotScreenActivity = this.a;
        if (previewShotScreenActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        previewShotScreenActivity.ivShotScreenPreview = null;
    }

    @UiThread
    public PreviewShotScreenActivity_ViewBinding(PreviewShotScreenActivity previewShotScreenActivity, View view) {
        this.a = previewShotScreenActivity;
        previewShotScreenActivity.ivShotScreenPreview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_shot_screen_preview, "field 'ivShotScreenPreview'", ImageView.class);
    }
}
