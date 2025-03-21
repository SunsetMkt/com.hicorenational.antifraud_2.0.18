package manager;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.presenter.WelocmPresenter;

/* compiled from: GrayManager.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m23546d2 = {"Lmanager/GrayManager;", "", "()V", "mGrayMatrix", "Landroid/graphics/ColorMatrix;", "getMGrayMatrix", "()Landroid/graphics/ColorMatrix;", "setMGrayMatrix", "(Landroid/graphics/ColorMatrix;)V", "mGrayPaint", "Landroid/graphics/Paint;", "getMGrayPaint", "()Landroid/graphics/Paint;", "setMGrayPaint", "(Landroid/graphics/Paint;)V", "initFilter", "", "flot", "", "setLayerGray", "view", "Landroid/view/View;", "Companion", "InstanceHelper", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class GrayManager {
    public static final Companion Companion = new Companion(null);

    @InterfaceC5817e
    private ColorMatrix mGrayMatrix;

    @InterfaceC5817e
    private Paint mGrayPaint;

    /* compiled from: GrayManager.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m23546d2 = {"Lmanager/GrayManager$Companion;", "", "()V", "getInstance", "Lmanager/GrayManager;", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        @InterfaceC5816d
        public final GrayManager getInstance() {
            return InstanceHelper.INSTANCE.getSSingle();
        }

        public /* synthetic */ Companion(C5586v c5586v) {
            this();
        }
    }

    /* compiled from: GrayManager.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m23546d2 = {"Lmanager/GrayManager$InstanceHelper;", "", "()V", "sSingle", "Lmanager/GrayManager;", "getSSingle", "()Lmanager/GrayManager;", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
    public static final class InstanceHelper {
        public static final InstanceHelper INSTANCE = new InstanceHelper();

        @InterfaceC5816d
        private static final GrayManager sSingle = new GrayManager();

        private InstanceHelper() {
        }

        @InterfaceC5816d
        public final GrayManager getSSingle() {
            return sSingle;
        }
    }

    private final void initFilter(float f2) {
        this.mGrayMatrix = new ColorMatrix();
        this.mGrayPaint = new Paint();
        ColorMatrix colorMatrix = this.mGrayMatrix;
        if (colorMatrix == null) {
            C5544i0.m22545f();
        }
        colorMatrix.setSaturation(f2);
        Paint paint = this.mGrayPaint;
        if (paint == null) {
            C5544i0.m22545f();
        }
        ColorMatrix colorMatrix2 = this.mGrayMatrix;
        if (colorMatrix2 == null) {
            C5544i0.m22545f();
        }
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix2));
    }

    @InterfaceC5817e
    public final ColorMatrix getMGrayMatrix() {
        return this.mGrayMatrix;
    }

    @InterfaceC5817e
    public final Paint getMGrayPaint() {
        return this.mGrayPaint;
    }

    public final void setLayerGray(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (TextUtils.isEmpty(WelocmPresenter.SKIN) || !TextUtils.equals(WelocmPresenter.SKIN, "1")) {
            setLayerGray(view, 1.0f);
        } else {
            setLayerGray(view, 0.0f);
        }
    }

    public final void setMGrayMatrix(@InterfaceC5817e ColorMatrix colorMatrix) {
        this.mGrayMatrix = colorMatrix;
    }

    public final void setMGrayPaint(@InterfaceC5817e Paint paint) {
        this.mGrayPaint = paint;
    }

    private final void setLayerGray(View view, float f2) {
        if (this.mGrayMatrix == null || this.mGrayPaint == null) {
            initFilter(f2);
        }
        view.setLayerType(2, this.mGrayPaint);
    }
}
