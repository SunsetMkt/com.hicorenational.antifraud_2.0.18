package com.lxj.xpopup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.d.c;
import com.lxj.xpopup.d.d;
import com.lxj.xpopup.d.f;
import com.lxj.xpopup.e.e;
import com.lxj.xpopup.e.g;
import com.lxj.xpopup.e.i;
import com.lxj.xpopup.e.j;
import com.lxj.xpopup.impl.AttachListPopupView;
import com.lxj.xpopup.impl.BottomListPopupView;
import com.lxj.xpopup.impl.CenterListPopupView;
import com.lxj.xpopup.impl.ConfirmPopupView;
import com.lxj.xpopup.impl.InputConfirmPopupView;
import com.lxj.xpopup.impl.LoadingPopupView;
import java.util.List;

/* JADX INFO: compiled from: XPopup.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static int a = Color.parseColor("#121212");

    /* JADX INFO: renamed from: b */
    private static int f5397b = 360;

    /* JADX INFO: renamed from: c */
    public static int f5398c = Color.parseColor("#55000000");

    /* JADX INFO: renamed from: d */
    private static int f5399d = Color.parseColor("#9F000000");

    /* JADX INFO: compiled from: XPopup.java */
    public static class a {
        private final com.lxj.xpopup.core.a a = new com.lxj.xpopup.core.a();

        /* JADX INFO: renamed from: b */
        private Context f5400b;

        /* JADX INFO: renamed from: com.lxj.xpopup.b$a$a */
        /* JADX INFO: compiled from: XPopup.java */
        class ViewOnTouchListenerC0100a implements View.OnTouchListener {
            ViewOnTouchListenerC0100a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.a.f5449j != null && motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.a.f5449j = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
                return false;
            }
        }

        public a(Context context) {
            this.f5400b = context;
        }

        public a b(View view) {
            com.lxj.xpopup.core.a aVar = this.a;
            aVar.f5446g = view;
            aVar.f5446g.setOnTouchListener(new ViewOnTouchListenerC0100a());
            return this;
        }

        public a c(Boolean bool) {
            this.a.f5441b = bool;
            return this;
        }

        public a d(Boolean bool) {
            this.a.f5442c = bool;
            return this;
        }

        public a e(Boolean bool) {
            this.a.f5444e = bool;
            return this;
        }

        public a f(Boolean bool) {
            this.a.p = bool;
            return this;
        }

        public a a(f fVar) {
            this.a.a = fVar;
            return this;
        }

        public a c(boolean z) {
            this.a.r = Boolean.valueOf(z);
            return this;
        }

        public a d(int i2) {
            this.a.t = i2;
            return this;
        }

        public a e(boolean z) {
            this.a.w = z;
            return this;
        }

        public a a(Boolean bool) {
            this.a.f5443d = bool;
            return this;
        }

        public a b(int i2) {
            this.a.f5450k = i2;
            return this;
        }

        public a c(int i2) {
            this.a.s = i2;
            return this;
        }

        public a d(boolean z) {
            this.a.v = z;
            return this;
        }

        public a a(View view) {
            this.a.f5445f = view;
            return this;
        }

        public a b(Boolean bool) {
            this.a.f5452m = bool;
            return this;
        }

        public a a(c cVar) {
            this.a.f5447h = cVar;
            return this;
        }

        public a b(boolean z) {
            this.a.u = Boolean.valueOf(z);
            return this;
        }

        public a a(com.lxj.xpopup.c.b bVar) {
            this.a.f5448i = bVar;
            return this;
        }

        public CenterListPopupView b(String str, String[] strArr, int[] iArr, int i2, com.lxj.xpopup.e.f fVar) {
            a(f.Center);
            CenterListPopupView centerListPopupViewA = new CenterListPopupView(this.f5400b).a(str, strArr, iArr).c(i2).a(fVar);
            centerListPopupViewA.a = this.a;
            return centerListPopupViewA;
        }

        public a a(int i2) {
            this.a.f5451l = i2;
            return this;
        }

        public a a(d dVar) {
            this.a.q = dVar;
            return this;
        }

        public a a(boolean z) {
            this.a.x = z;
            return this;
        }

        public a a(i iVar) {
            this.a.f5453n = iVar;
            return this;
        }

        public ConfirmPopupView a(String str, String str2, String str3, String str4, com.lxj.xpopup.e.c cVar, com.lxj.xpopup.e.a aVar, boolean z) {
            a(f.Center);
            ConfirmPopupView confirmPopupView = new ConfirmPopupView(this.f5400b);
            confirmPopupView.a(str, str2, null);
            confirmPopupView.a(str3);
            confirmPopupView.b(str4);
            confirmPopupView.a(cVar, aVar);
            if (z) {
                confirmPopupView.v();
            }
            confirmPopupView.a = this.a;
            return confirmPopupView;
        }

        public CenterListPopupView b(String str, String[] strArr, com.lxj.xpopup.e.f fVar) {
            return b(str, strArr, null, -1, fVar);
        }

        public CenterListPopupView b(String str, String[] strArr, int[] iArr, com.lxj.xpopup.e.f fVar) {
            return b(str, strArr, iArr, -1, fVar);
        }

        public ConfirmPopupView a(String str, String str2, com.lxj.xpopup.e.c cVar, com.lxj.xpopup.e.a aVar) {
            return a(str, str2, null, null, cVar, aVar, false);
        }

        public ConfirmPopupView a(String str, String str2, com.lxj.xpopup.e.c cVar) {
            return a(str, str2, null, null, cVar, null, false);
        }

        public InputConfirmPopupView a(String str, String str2, String str3, String str4, e eVar, com.lxj.xpopup.e.a aVar) {
            a(f.Center);
            InputConfirmPopupView inputConfirmPopupView = new InputConfirmPopupView(this.f5400b);
            inputConfirmPopupView.a(str, str2, str4);
            inputConfirmPopupView.F = str3;
            inputConfirmPopupView.a(eVar, aVar);
            inputConfirmPopupView.a = this.a;
            return inputConfirmPopupView;
        }

        public InputConfirmPopupView a(String str, String str2, String str3, String str4, e eVar) {
            return a(str, str2, str3, str4, eVar, (com.lxj.xpopup.e.a) null);
        }

        public InputConfirmPopupView a(String str, String str2, String str3, e eVar) {
            return a(str, str2, (String) null, str3, eVar, (com.lxj.xpopup.e.a) null);
        }

        public InputConfirmPopupView a(String str, String str2, e eVar) {
            return a(str, str2, (String) null, (String) null, eVar, (com.lxj.xpopup.e.a) null);
        }

        public LoadingPopupView a(String str) {
            a(f.Center);
            LoadingPopupView loadingPopupViewA = new LoadingPopupView(this.f5400b).a(str);
            loadingPopupViewA.a = this.a;
            return loadingPopupViewA;
        }

        public LoadingPopupView a() {
            return a((String) null);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, int i2, boolean z, com.lxj.xpopup.e.f fVar) {
            a(f.Bottom);
            BottomListPopupView bottomListPopupViewA = new BottomListPopupView(this.f5400b).a(str, strArr, iArr).c(i2).a(fVar);
            bottomListPopupViewA.a = this.a;
            return bottomListPopupViewA;
        }

        public BottomListPopupView a(String str, String[] strArr, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, (int[]) null, -1, true, fVar);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, iArr, -1, true, fVar);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, int i2, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, iArr, i2, true, fVar);
        }

        public BottomListPopupView a(String str, String[] strArr, int[] iArr, boolean z, com.lxj.xpopup.e.f fVar) {
            return a(str, strArr, iArr, -1, z, fVar);
        }

        public AttachListPopupView a(String[] strArr, int[] iArr, int i2, int i3, com.lxj.xpopup.e.f fVar) {
            a(f.AttachView);
            AttachListPopupView attachListPopupViewA = new AttachListPopupView(this.f5400b).a(strArr, iArr).a(i2, i3).a(fVar);
            attachListPopupViewA.a = this.a;
            return attachListPopupViewA;
        }

        public AttachListPopupView a(String[] strArr, int[] iArr, com.lxj.xpopup.e.f fVar) {
            return a(strArr, iArr, 0, 0, fVar);
        }

        public ImageViewerPopupView a(ImageView imageView, Object obj, j jVar) {
            a(f.ImageViewer);
            ImageViewerPopupView imageViewerPopupViewA = new ImageViewerPopupView(this.f5400b).a(imageView, obj).a(jVar);
            imageViewerPopupViewA.a = this.a;
            return imageViewerPopupViewA;
        }

        public ImageViewerPopupView a(ImageView imageView, Object obj, boolean z, int i2, int i3, int i4, boolean z2, j jVar) {
            a(f.ImageViewer);
            ImageViewerPopupView imageViewerPopupViewA = new ImageViewerPopupView(this.f5400b).a(imageView, obj).a(z).a(i2).c(i3).b(i4).d(z2).a(jVar);
            imageViewerPopupViewA.a = this.a;
            return imageViewerPopupViewA;
        }

        public ImageViewerPopupView a(ImageView imageView, int i2, List<Object> list, g gVar, j jVar) {
            return a(imageView, i2, list, false, -1, -1, -1, true, gVar, jVar);
        }

        public ImageViewerPopupView a(ImageView imageView, int i2, List<Object> list, boolean z, int i3, int i4, int i5, boolean z2, g gVar, j jVar) {
            a(f.ImageViewer);
            ImageViewerPopupView imageViewerPopupViewA = new ImageViewerPopupView(this.f5400b).a(imageView, i2).a(list).a(z).a(i3).c(i4).b(i5).d(z2).a(gVar).a(jVar);
            imageViewerPopupViewA.a = this.a;
            return imageViewerPopupViewA;
        }

        public BasePopupView a(BasePopupView basePopupView) {
            if (basePopupView instanceof CenterPopupView) {
                a(f.Center);
            } else if (basePopupView instanceof BottomPopupView) {
                a(f.Bottom);
            } else if (basePopupView instanceof AttachPopupView) {
                a(f.AttachView);
            } else if (basePopupView instanceof ImageViewerPopupView) {
                a(f.ImageViewer);
            } else if (basePopupView instanceof PositionPopupView) {
                a(f.Position);
            }
            basePopupView.a = this.a;
            return basePopupView;
        }
    }

    private b() {
    }

    public static void a(int i2) {
        if (i2 >= 0) {
            f5397b = i2;
        }
    }

    public static void b(int i2) {
        a = i2;
    }

    public static void c(int i2) {
        f5399d = i2;
    }

    public static int a() {
        return f5397b;
    }

    public static int b() {
        return a;
    }

    public static int c() {
        return f5399d;
    }
}
