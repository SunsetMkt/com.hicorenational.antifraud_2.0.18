package com.lxj.xpopup.p187f;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.Toast;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.lxj.xpopup.p185d.EnumC2801a;
import com.lxj.xpopup.p186e.InterfaceC2816j;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: XPopupUtils.java */
/* renamed from: com.lxj.xpopup.f.c */
/* loaded from: classes.dex */
public class C2819c {

    /* renamed from: a */
    private static int f8736a;

    /* renamed from: b */
    private static Context f8737b;

    /* compiled from: XPopupUtils.java */
    /* renamed from: com.lxj.xpopup.f.c$a */
    static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f8738a;

        /* renamed from: b */
        final /* synthetic */ int f8739b;

        /* renamed from: c */
        final /* synthetic */ int f8740c;

        /* renamed from: d */
        final /* synthetic */ Runnable f8741d;

        a(ViewGroup viewGroup, int i2, int i3, Runnable runnable) {
            this.f8738a = viewGroup;
            this.f8739b = i2;
            this.f8740c = i3;
            this.f8741d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = this.f8738a.getLayoutParams();
            View childAt = this.f8738a.getChildAt(0);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            int measuredWidth = this.f8738a.getMeasuredWidth();
            if (layoutParams2.width == -2) {
                measuredWidth = Math.min(measuredWidth, childAt.getMeasuredWidth());
            }
            int i2 = this.f8739b;
            if (i2 != 0) {
                layoutParams.width = Math.min(measuredWidth, i2);
            }
            int measuredHeight = this.f8738a.getMeasuredHeight();
            if (layoutParams2.height == -1) {
                measuredHeight = ((ViewGroup) this.f8738a.getParent()).getMeasuredHeight();
                layoutParams.height = measuredHeight;
            }
            if (this.f8740c != 0) {
                int i3 = layoutParams.height;
                if (i3 == -1 || i3 == C2819c.m8466b(this.f8738a.getContext()) + C2819c.m8471c()) {
                    layoutParams2.height = Math.min(childAt.getMeasuredHeight(), this.f8740c);
                    childAt.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.height = Math.min(measuredHeight, this.f8740c);
                }
            }
            this.f8738a.setLayoutParams(layoutParams);
            Runnable runnable = this.f8741d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: XPopupUtils.java */
    /* renamed from: com.lxj.xpopup.f.c$b */
    static class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC2816j f8742a;

        /* renamed from: b */
        final /* synthetic */ Object f8743b;

        /* renamed from: c */
        final /* synthetic */ Handler f8744c;

        /* compiled from: XPopupUtils.java */
        /* renamed from: com.lxj.xpopup.f.c$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(C2819c.f8737b, "图片不存在！", 0).show();
                Context unused = C2819c.f8737b = null;
            }
        }

        /* compiled from: XPopupUtils.java */
        /* renamed from: com.lxj.xpopup.f.c$b$b, reason: collision with other inner class name */
        class C7370b implements MediaScannerConnection.OnScanCompletedListener {

            /* compiled from: XPopupUtils.java */
            /* renamed from: com.lxj.xpopup.f.c$b$b$a */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(C2819c.f8737b, "已保存到相册！", 0).show();
                    Context unused = C2819c.f8737b = null;
                }
            }

            C7370b() {
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                b.this.f8744c.post(new a());
            }
        }

        /* compiled from: XPopupUtils.java */
        /* renamed from: com.lxj.xpopup.f.c$b$c */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(C2819c.f8737b, "没有保存权限，保存功能无法使用！", 0).show();
                Context unused = C2819c.f8737b = null;
            }
        }

        b(InterfaceC2816j interfaceC2816j, Object obj, Handler handler) {
            this.f8742a = interfaceC2816j;
            this.f8743b = obj;
            this.f8744c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            File m8436a = this.f8742a.m8436a(C2819c.f8737b, this.f8743b);
            if (m8436a == null) {
                this.f8744c.post(new a());
                return;
            }
            String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Environment.DIRECTORY_PICTURES;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                String m8467b = C2819c.m8467b(C2817a.m8438a(new FileInputStream(m8436a)));
                File file2 = new File(str, System.currentTimeMillis() + "." + m8467b);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                C2819c.m8470b(file2, new FileInputStream(m8436a));
                MediaScannerConnection.scanFile(C2819c.f8737b, new String[]{file2.getAbsolutePath()}, new String[]{"image/" + m8467b}, new C7370b());
            } catch (IOException e2) {
                e2.printStackTrace();
                this.f8744c.post(new c());
            }
        }
    }

    /* compiled from: XPopupUtils.java */
    /* renamed from: com.lxj.xpopup.f.c$c */
    static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f8749a = new int[EnumC2801a.values().length];

        static {
            try {
                f8749a[EnumC2801a.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8749a[EnumC2801a.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8749a[EnumC2801a.PNG_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8749a[EnumC2801a.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8749a[EnumC2801a.WEBP_A.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8749a[EnumC2801a.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: a */
    public static void m8460a(EditText editText, int i2) {
    }

    /* renamed from: b */
    public static int m8466b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    /* renamed from: c */
    public static int m8472c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: d */
    public static boolean m8474d(Context context) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(context.getResources().getResourceEntryName(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i2++;
        }
        return z ? (viewGroup.getSystemUiVisibility() & 2) == 0 : z;
    }

    /* renamed from: b */
    public static int m8465b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: c */
    public static int m8471c() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    /* renamed from: a */
    public static int m8449a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static boolean m8468b(Activity activity) {
        return m8448a(activity) > 0;
    }

    /* renamed from: c */
    public static void m8473c(BasePopupView basePopupView) {
        boolean z = basePopupView instanceof PartShadowPopupView;
        if (z || !(basePopupView instanceof AttachPopupView)) {
            if (z && !m8463a(basePopupView)) {
                basePopupView.getPopupImplView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            } else {
                basePopupView.getPopupContentView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            }
        }
    }

    /* renamed from: a */
    public static void m8457a(View view, int i2, int i3) {
        if (i2 > 0 || i3 > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i2 > 0) {
                layoutParams.width = i2;
            }
            if (i3 > 0) {
                layoutParams.height = i3;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: b */
    private static boolean m8469b(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && !((PartShadowPopupView) basePopupView).f8605s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m8467b(EnumC2801a enumC2801a) {
        switch (c.f8749a[enumC2801a.ordinal()]) {
            case 1:
                return "gif";
            case 2:
            case 3:
                return "png";
            case 4:
            case 5:
                return "webp";
            case 6:
            default:
                return "jpeg";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m8470b(File file, InputStream inputStream) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 8192);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            throw th;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static void m8458a(ViewGroup viewGroup, int i2, int i3) {
        m8459a(viewGroup, i2, i3, null);
    }

    /* renamed from: a */
    public static void m8459a(ViewGroup viewGroup, int i2, int i3, Runnable runnable) {
        viewGroup.post(new a(viewGroup, i2, i3, runnable));
    }

    /* renamed from: a */
    public static BitmapDrawable m8452a(Resources resources, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, 20, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(i3);
        canvas.drawRect(0.0f, 0.0f, createBitmap.getWidth(), 4.0f, paint);
        paint.setColor(0);
        canvas.drawRect(0.0f, 4.0f, createBitmap.getWidth(), 20.0f, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, createBitmap);
        bitmapDrawable.setGravity(80);
        return bitmapDrawable;
    }

    /* renamed from: a */
    public static StateListDrawable m8453a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    /* renamed from: a */
    public static boolean m8462a(float f2, float f3, Rect rect) {
        return f2 >= ((float) rect.left) && f2 <= ((float) rect.right) && f3 >= ((float) rect.top) && f3 <= ((float) rect.bottom);
    }

    /* renamed from: a */
    public static int m8448a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= m8465b()) {
            f8736a = abs;
            return 0;
        }
        return abs - f8736a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
    
        if (r7 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ab, code lost:
    
        r11 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011b, code lost:
    
        if (r7 > 0) goto L37;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m8455a(int r11, com.lxj.xpopup.core.BasePopupView r12) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.p187f.C2819c.m8455a(int, com.lxj.xpopup.core.BasePopupView):void");
    }

    /* renamed from: a */
    private static boolean m8463a(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && ((PartShadowPopupView) basePopupView).f8605s;
    }

    /* renamed from: a */
    public static void m8461a(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                m8461a(arrayList, (ViewGroup) childAt);
            }
        }
    }

    /* renamed from: a */
    public static void m8456a(Context context, InterfaceC2816j interfaceC2816j, Object obj) {
        Handler handler = new Handler(Looper.getMainLooper());
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        f8737b = context;
        newSingleThreadExecutor.execute(new b(interfaceC2816j, obj, handler));
    }
}
