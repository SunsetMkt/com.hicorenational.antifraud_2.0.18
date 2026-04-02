package com.lxj.xpopup.f;

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
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.core.DrawerPopupView;
import com.lxj.xpopup.e.j;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: XPopupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static int a;

    /* JADX INFO: renamed from: b */
    private static Context f5468b;

    /* JADX INFO: compiled from: XPopupUtils.java */
    static class a implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f5469b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ int f5470c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ Runnable f5471d;

        a(ViewGroup viewGroup, int i2, int i3, Runnable runnable) {
            this.a = viewGroup;
            this.f5469b = i2;
            this.f5470c = i3;
            this.f5471d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            View childAt = this.a.getChildAt(0);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            int measuredWidth = this.a.getMeasuredWidth();
            if (layoutParams2.width == -2) {
                measuredWidth = Math.min(measuredWidth, childAt.getMeasuredWidth());
            }
            int i2 = this.f5469b;
            if (i2 != 0) {
                layoutParams.width = Math.min(measuredWidth, i2);
            }
            int measuredHeight = this.a.getMeasuredHeight();
            if (layoutParams2.height == -1) {
                measuredHeight = ((ViewGroup) this.a.getParent()).getMeasuredHeight();
                layoutParams.height = measuredHeight;
            }
            if (this.f5470c != 0) {
                int i3 = layoutParams.height;
                if (i3 == -1 || i3 == c.b(this.a.getContext()) + c.c()) {
                    layoutParams2.height = Math.min(childAt.getMeasuredHeight(), this.f5470c);
                    childAt.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.height = Math.min(measuredHeight, this.f5470c);
                }
            }
            this.a.setLayoutParams(layoutParams);
            Runnable runnable = this.f5471d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: compiled from: XPopupUtils.java */
    static class b implements Runnable {
        final /* synthetic */ j a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object f5472b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Handler f5473c;

        /* JADX INFO: compiled from: XPopupUtils.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(c.f5468b, "\u56fe\u7247\u4e0d\u5b58\u5728\uff01", 0).show();
                Context unused = c.f5468b = null;
            }
        }

        /* JADX INFO: renamed from: com.lxj.xpopup.f.c$b$b */
        /* JADX INFO: compiled from: XPopupUtils.java */
        class C0104b implements MediaScannerConnection.OnScanCompletedListener {

            /* JADX INFO: renamed from: com.lxj.xpopup.f.c$b$b$a */
            /* JADX INFO: compiled from: XPopupUtils.java */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(c.f5468b, "\u5df2\u4fdd\u5b58\u5230\u76f8\u518c\uff01", 0).show();
                    Context unused = c.f5468b = null;
                }
            }

            C0104b() {
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                b.this.f5473c.post(new a());
            }
        }

        /* JADX INFO: renamed from: com.lxj.xpopup.f.c$b$c */
        /* JADX INFO: compiled from: XPopupUtils.java */
        class RunnableC0105c implements Runnable {
            RunnableC0105c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(c.f5468b, "\u6ca1\u6709\u4fdd\u5b58\u6743\u9650\uff0c\u4fdd\u5b58\u529f\u80fd\u65e0\u6cd5\u4f7f\u7528\uff01", 0).show();
                Context unused = c.f5468b = null;
            }
        }

        b(j jVar, Object obj, Handler handler) {
            this.a = jVar;
            this.f5472b = obj;
            this.f5473c = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            File fileA = this.a.a(c.f5468b, this.f5472b);
            if (fileA == null) {
                this.f5473c.post(new a());
                return;
            }
            String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Environment.DIRECTORY_PICTURES;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                String strB = c.b(com.lxj.xpopup.f.a.a(new FileInputStream(fileA)));
                File file2 = new File(str, System.currentTimeMillis() + "." + strB);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                c.b(file2, new FileInputStream(fileA));
                MediaScannerConnection.scanFile(c.f5468b, new String[]{file2.getAbsolutePath()}, new String[]{"image/" + strB}, new C0104b());
            } catch (IOException e2) {
                e2.printStackTrace();
                this.f5473c.post(new RunnableC0105c());
            }
        }
    }

    /* JADX INFO: renamed from: com.lxj.xpopup.f.c$c */
    /* JADX INFO: compiled from: XPopupUtils.java */
    static /* synthetic */ class C0106c {
        static final /* synthetic */ int[] a = new int[com.lxj.xpopup.d.a.values().length];

        static {
            try {
                a[com.lxj.xpopup.d.a.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.lxj.xpopup.d.a.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.lxj.xpopup.d.a.PNG_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.lxj.xpopup.d.a.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.lxj.xpopup.d.a.WEBP_A.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.lxj.xpopup.d.a.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void a(EditText editText, int i2) {
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static boolean d(Context context) {
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

    public static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int c() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean b(Activity activity) {
        return a(activity) > 0;
    }

    public static void c(BasePopupView basePopupView) {
        boolean z = basePopupView instanceof PartShadowPopupView;
        if (z || !(basePopupView instanceof AttachPopupView)) {
            if (z && !a(basePopupView)) {
                basePopupView.getPopupImplView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            } else {
                basePopupView.getPopupContentView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            }
        }
    }

    public static void a(View view, int i2, int i3) {
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

    private static boolean b(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && !((PartShadowPopupView) basePopupView).s;
    }

    public static String b(com.lxj.xpopup.d.a aVar) {
        switch (C0106c.a[aVar.ordinal()]) {
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

    public static boolean b(File file, InputStream inputStream) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = inputStream.read(bArr, 0, 8192);
                        if (i2 == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, i2);
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

    public static void a(ViewGroup viewGroup, int i2, int i3) {
        a(viewGroup, i2, i3, null);
    }

    public static void a(ViewGroup viewGroup, int i2, int i3, Runnable runnable) {
        viewGroup.post(new a(viewGroup, i2, i3, runnable));
    }

    public static BitmapDrawable a(Resources resources, int i2, int i3) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, 20, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(i3);
        canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), 4.0f, paint);
        paint.setColor(0);
        canvas.drawRect(0.0f, 4.0f, bitmapCreateBitmap.getWidth(), 20.0f, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmapCreateBitmap);
        bitmapDrawable.setGravity(80);
        return bitmapDrawable;
    }

    public static StateListDrawable a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static boolean a(float f2, float f3, Rect rect) {
        return f2 >= ((float) rect.left) && f2 <= ((float) rect.right) && f3 >= ((float) rect.top) && f3 <= ((float) rect.bottom);
    }

    public static int a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs <= b()) {
            a = iAbs;
            return 0;
        }
        return iAbs - a;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x00ab A[PHI: r7
  0x00ab: PHI (r7v5 int) = (r7v3 int), (r7v7 int) binds: [B:152:0x011b, B:118:0x00a9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i2, BasePopupView basePopupView) {
        int i3;
        int measuredHeight;
        int i4;
        int i5;
        int i6;
        if (basePopupView.a.p.booleanValue()) {
            ArrayList arrayList = new ArrayList();
            a((ArrayList<EditText>) arrayList, basePopupView);
            EditText editText = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EditText editText2 = (EditText) it.next();
                if (editText2.isFocused()) {
                    editText = editText2;
                    break;
                }
            }
            int height = basePopupView.getPopupContentView().getHeight();
            int width = basePopupView.getPopupContentView().getWidth();
            if (basePopupView.getPopupImplView() != null) {
                height = Math.min(height, basePopupView.getPopupImplView().getMeasuredHeight());
                width = Math.min(width, basePopupView.getPopupImplView().getMeasuredWidth());
            }
            int iB = b(basePopupView.getContext());
            if (editText != null) {
                int[] iArr = new int[2];
                editText.getLocationInWindow(iArr);
                i3 = iArr[1];
                measuredHeight = editText.getMeasuredHeight() + i3;
            } else {
                i3 = 0;
                measuredHeight = 0;
            }
            if ((basePopupView instanceof PartShadowPopupView) || !(basePopupView instanceof AttachPopupView)) {
                boolean z = basePopupView instanceof FullScreenPopupView;
                if ((z || (width == c(basePopupView.getContext()) && height == b(basePopupView.getContext()) + c())) && measuredHeight + i2 < iB) {
                    return;
                }
                if (z) {
                    i4 = (measuredHeight + i2) - iB;
                    i2 = (editText == null || i4 <= 0) ? 0 : i4;
                } else if (basePopupView instanceof CenterPopupView) {
                    int iC = i2 - (((iB - height) + c()) / 2);
                    if (editText != null && (i6 = i3 - iC) < 0) {
                        iC += i6 - c();
                    }
                    i2 = Math.max(0, iC);
                } else if (!(basePopupView instanceof BottomPopupView)) {
                    if (a(basePopupView) || (basePopupView instanceof DrawerPopupView)) {
                        i4 = (measuredHeight + i2) - iB;
                        if (editText == null || i4 <= 0) {
                        }
                    } else if (b(basePopupView)) {
                        int i7 = (measuredHeight + i2) - iB;
                        if (editText == null || i7 <= 0) {
                            i7 = 0;
                        }
                        if (i7 != 0) {
                            basePopupView.getPopupImplView().animate().translationY(-i7).setDuration(200L).setInterpolator(new OvershootInterpolator(0.0f)).start();
                            return;
                        }
                        return;
                    }
                } else if (editText != null && (i5 = i3 - i2) < 0) {
                    i2 += i5 - c();
                }
                if (i2 != 0 || basePopupView.getPopupContentView().getTranslationY() == 0.0f) {
                    basePopupView.getPopupContentView().animate().translationY(-i2).setDuration(200L).setInterpolator(new OvershootInterpolator(0.0f)).start();
                }
            }
        }
    }

    private static boolean a(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && ((PartShadowPopupView) basePopupView).s;
    }

    public static void a(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(arrayList, (ViewGroup) childAt);
            }
        }
    }

    public static void a(Context context, j jVar, Object obj) {
        Handler handler = new Handler(Looper.getMainLooper());
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        f5468b = context;
        executorServiceNewSingleThreadExecutor.execute(new b(jVar, obj, handler));
    }
}
