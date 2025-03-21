package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5226e1;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: View.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a2\u0010\u0019\u001a\u00020\u001a*\u00020\u00032#\b\u0004\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\b\u001a2\u0010 \u001a\u00020\u001a*\u00020\u00032#\b\u0004\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\b\u001a2\u0010!\u001a\u00020\u001a*\u00020\u00032#\b\u0004\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\b\u001a\u0014\u0010\"\u001a\u00020#*\u00020\u00032\b\b\u0002\u0010$\u001a\u00020%\u001a%\u0010&\u001a\u00020'*\u00020\u00032\u0006\u0010(\u001a\u00020)2\u000e\b\u0004\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0*H\u0086\b\u001a%\u0010+\u001a\u00020'*\u00020\u00032\u0006\u0010(\u001a\u00020)2\u000e\b\u0004\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0*H\u0087\b\u001a\u0017\u0010,\u001a\u00020\u001a*\u00020\u00032\b\b\u0001\u0010-\u001a\u00020\fH\u0086\b\u001a7\u0010.\u001a\u00020\u001a\"\n\b\u0000\u0010/\u0018\u0001*\u000200*\u00020\u00032\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b2H\u0087\b¢\u0006\u0002\b3\u001a&\u0010.\u001a\u00020\u001a*\u00020\u00032\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b2H\u0086\b\u001a5\u00104\u001a\u00020\u001a*\u00020\u00032\b\b\u0003\u00105\u001a\u00020\f2\b\b\u0003\u00106\u001a\u00020\f2\b\b\u0003\u00107\u001a\u00020\f2\b\b\u0003\u00108\u001a\u00020\fH\u0086\b\u001a5\u00109\u001a\u00020\u001a*\u00020\u00032\b\b\u0003\u0010:\u001a\u00020\f2\b\b\u0003\u00106\u001a\u00020\f2\b\b\u0003\u0010;\u001a\u00020\f2\b\b\u0003\u00108\u001a\u00020\fH\u0087\b\"*\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"*\u0010\u0007\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006\"*\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006\"\u0016\u0010\u000b\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0016\u0010\u0011\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\"\u0016\u0010\u0013\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\"\u0016\u0010\u0015\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000e\"\u0016\u0010\u0017\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000e¨\u0006<"}, m23546d2 = {SurveyH5Bean.VALUE, "", "isGone", "Landroid/view/View;", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnLayout", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "view", "doOnNextLayout", "doOnPreDraw", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnLayout(@InterfaceC5816d View view, @InterfaceC5816d final InterfaceC5506l<? super View, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(view, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@InterfaceC5816d View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    C5544i0.m22546f(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    InterfaceC5506l.this.invoke(view2);
                }
            });
        } else {
            interfaceC5506l.invoke(view);
        }
    }

    public static final void doOnNextLayout(@InterfaceC5816d View view, @InterfaceC5816d final InterfaceC5506l<? super View, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(view, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@InterfaceC5816d View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                C5544i0.m22546f(view2, "view");
                view2.removeOnLayoutChangeListener(this);
                InterfaceC5506l.this.invoke(view2);
            }
        });
    }

    public static final void doOnPreDraw(@InterfaceC5816d final View view, @InterfaceC5816d final InterfaceC5506l<? super View, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(view, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        final ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                interfaceC5506l.invoke(view);
                ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
                C5544i0.m22521a((Object) viewTreeObserver2, "vto");
                if (viewTreeObserver2.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    return true;
                }
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    @InterfaceC5816d
    public static final Bitmap drawToBitmap(@InterfaceC5816d View view, @InterfaceC5816d Bitmap.Config config) {
        C5544i0.m22546f(view, "$receiver");
        C5544i0.m22546f(config, "config");
        if (!ViewCompat.isLaidOut(view)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        C5544i0.m22521a((Object) createBitmap, "Bitmap.createBitmap(width, height, config)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return createBitmap;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final int getMarginBottom(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "$receiver");
        return view.getVisibility() == 0;
    }

    @InterfaceC5816d
    public static final Runnable postDelayed(@InterfaceC5816d View view, long j2, @InterfaceC5816d final InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(view, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC5495a.this.invoke();
            }
        };
        view.postDelayed(runnable, j2);
        return runnable;
    }

    @RequiresApi(16)
    @InterfaceC5816d
    public static final Runnable postOnAnimationDelayed(@InterfaceC5816d View view, long j2, @InterfaceC5816d final InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(view, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC5495a.this.invoke();
            }
        };
        view.postOnAnimationDelayed(runnable, j2);
        return runnable;
    }

    public static final void setGone(@InterfaceC5816d View view, boolean z) {
        C5544i0.m22546f(view, "$receiver");
        view.setVisibility(z ? 8 : 0);
    }

    public static final void setInvisible(@InterfaceC5816d View view, boolean z) {
        C5544i0.m22546f(view, "$receiver");
        view.setVisibility(z ? 4 : 0);
    }

    public static final void setPadding(@InterfaceC5816d View view, @Px int i2) {
        C5544i0.m22546f(view, "$receiver");
        view.setPadding(i2, i2, i2, i2);
    }

    public static final void setVisible(@InterfaceC5816d View view, boolean z) {
        C5544i0.m22546f(view, "$receiver");
        view.setVisibility(z ? 0 : 8);
    }

    public static final void updateLayoutParams(@InterfaceC5816d View view, @InterfaceC5816d InterfaceC5506l<? super ViewGroup.LayoutParams, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(view, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new C5226e1("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        interfaceC5506l.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    @InterfaceC5481e(name = "updateLayoutParamsTyped")
    private static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(@InterfaceC5816d View view, InterfaceC5506l<? super T, C5715y1> interfaceC5506l) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C5544i0.m22518a(1, ExifInterface.GPS_DIRECTION_TRUE);
        interfaceC5506l.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@InterfaceC5816d View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        C5544i0.m22546f(view, "$receiver");
        view.setPadding(i2, i3, i4, i5);
    }

    public static /* bridge */ /* synthetic */ void updatePadding$default(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingLeft();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingRight();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        C5544i0.m22546f(view, "$receiver");
        view.setPadding(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(@InterfaceC5816d View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        C5544i0.m22546f(view, "$receiver");
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static /* bridge */ /* synthetic */ void updatePaddingRelative$default(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingStart();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        C5544i0.m22546f(view, "$receiver");
        view.setPaddingRelative(i2, i3, i4, i5);
    }
}
