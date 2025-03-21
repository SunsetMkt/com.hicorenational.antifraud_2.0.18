package p357j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.load.p125r.p126d.C1739n;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1829h;
import com.hicorenational.antifraud.C2113R;
import java.io.File;
import p388ui.view.C7240r;

/* compiled from: ImageUtil.java */
/* renamed from: j.d */
/* loaded from: classes2.dex */
public class C5845d {

    /* compiled from: ImageUtil.java */
    /* renamed from: j.d$a */
    static class a extends ViewOutlineProvider {

        /* renamed from: a */
        final /* synthetic */ int f21122a;

        a(int i2) {
            this.f21122a = i2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f21122a);
        }
    }

    /* renamed from: a */
    public static void m24609a(String str, ImageView imageView) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(C2113R.drawable.default_pic).m4762b(C2113R.drawable.default_pic).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m24613b(ImageView imageView, String str) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public static void m24616c(String str, ImageView imageView) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(C2113R.drawable.iv_tool_default).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m24612b(ImageView imageView, Integer num) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3717a(num).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m24614b(String str, ImageView imageView) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) C1829h.m4837c(new C1739n()).m4742a(300, 300).m4777e(C2113R.drawable.iv_cricle_img_def).m4762b(C2113R.drawable.iv_cricle_img_def).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24605a(ImageView imageView, Integer num) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).m3794e().mo3717a(num).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24606a(ImageView imageView, String str) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).m3794e().mo3719a(str).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24603a(Context context, String str, ImageView imageView, int i2) {
        ComponentCallbacks2C1576b.m3649e(context).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(C2113R.drawable.default_pic).m4742a(300, 300).m4762b(C2113R.drawable.default_pic).m4753a(AbstractC1665j.f4537a)).m4764b((InterfaceC1600n<Bitmap>) new C7240r(i2)).m3768a(imageView);
    }

    /* renamed from: b */
    public static void m24615b(String str, ImageView imageView, Integer num) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) C1829h.m4837c(new C1739n()).m4742a(300, 300).m4777e(C2113R.drawable.iv_cricle_img_def).m4762b(num.intValue()).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24610a(String str, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(C2113R.mipmap.ic_launcher);
        }
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(num.intValue()).m4762b(num.intValue()).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24611a(String str, ImageView imageView, Integer num, int i2, int i3) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4742a(i2, i3).m4748a(EnumC1588b.PREFER_RGB_565).m4777e(num.intValue()).m4762b(num.intValue()).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24607a(Fragment fragment, String str, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(C2113R.mipmap.ic_launcher);
        }
        try {
            ComponentCallbacks2C1576b.m3637a(fragment).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(num.intValue()).m4762b(num.intValue()).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24602a(Activity activity, String str, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(C2113R.mipmap.ic_launcher);
        }
        try {
            ComponentCallbacks2C1576b.m3634a(activity).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(num.intValue()).m4762b(num.intValue()).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24608a(File file, ImageView imageView, Integer num) {
        if (num == null) {
            num = Integer.valueOf(C2113R.mipmap.ic_launcher);
        }
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3716a(file).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(num.intValue()).m4762b(num.intValue()).m4753a(AbstractC1665j.f4537a)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }

    @TargetApi(21)
    /* renamed from: a */
    public static void m24604a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21 && view != null && i2 > 0) {
            view.setOutlineProvider(new a(i2));
            view.setClipToOutline(true);
        }
    }

    /* renamed from: a */
    public static Bitmap m24600a(Bitmap bitmap, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        float f2 = i2;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        return Bitmap.createBitmap(createBitmap, 0, 0, width, height - i2);
    }

    /* renamed from: a */
    public static Bitmap m24601a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }
}
