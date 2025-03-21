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
import com.lxj.xpopup.core.C2800a;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.impl.AttachListPopupView;
import com.lxj.xpopup.impl.BottomListPopupView;
import com.lxj.xpopup.impl.CenterListPopupView;
import com.lxj.xpopup.impl.ConfirmPopupView;
import com.lxj.xpopup.impl.InputConfirmPopupView;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p185d.EnumC2804d;
import com.lxj.xpopup.p185d.EnumC2806f;
import com.lxj.xpopup.p186e.InterfaceC2807a;
import com.lxj.xpopup.p186e.InterfaceC2809c;
import com.lxj.xpopup.p186e.InterfaceC2811e;
import com.lxj.xpopup.p186e.InterfaceC2812f;
import com.lxj.xpopup.p186e.InterfaceC2813g;
import com.lxj.xpopup.p186e.InterfaceC2815i;
import com.lxj.xpopup.p186e.InterfaceC2816j;
import java.util.List;

/* compiled from: XPopup.java */
/* renamed from: com.lxj.xpopup.b */
/* loaded from: classes.dex */
public class C2768b {

    /* renamed from: a */
    private static int f8562a = Color.parseColor("#121212");

    /* renamed from: b */
    private static int f8563b = 360;

    /* renamed from: c */
    public static int f8564c = Color.parseColor("#55000000");

    /* renamed from: d */
    private static int f8565d = Color.parseColor("#9F000000");

    /* compiled from: XPopup.java */
    /* renamed from: com.lxj.xpopup.b$a */
    public static class a {

        /* renamed from: a */
        private final C2800a f8566a = new C2800a();

        /* renamed from: b */
        private Context f8567b;

        /* compiled from: XPopup.java */
        /* renamed from: com.lxj.xpopup.b$a$a, reason: collision with other inner class name */
        class ViewOnTouchListenerC7369a implements View.OnTouchListener {
            ViewOnTouchListenerC7369a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.f8566a.f8697j != null && motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.f8566a.f8697j = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
                return false;
            }
        }

        public a(Context context) {
            this.f8567b = context;
        }

        /* renamed from: b */
        public a m8332b(View view) {
            C2800a c2800a = this.f8566a;
            c2800a.f8694g = view;
            c2800a.f8694g.setOnTouchListener(new ViewOnTouchListenerC7369a());
            return this;
        }

        /* renamed from: c */
        public a m8339c(Boolean bool) {
            this.f8566a.f8689b = bool;
            return this;
        }

        /* renamed from: d */
        public a m8342d(Boolean bool) {
            this.f8566a.f8690c = bool;
            return this;
        }

        /* renamed from: e */
        public a m8344e(Boolean bool) {
            this.f8566a.f8692e = bool;
            return this;
        }

        /* renamed from: f */
        public a m8346f(Boolean bool) {
            this.f8566a.f8703p = bool;
            return this;
        }

        /* renamed from: a */
        public a m8306a(EnumC2806f enumC2806f) {
            this.f8566a.f8688a = enumC2806f;
            return this;
        }

        /* renamed from: c */
        public a m8340c(boolean z) {
            this.f8566a.f8705r = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: d */
        public a m8341d(int i2) {
            this.f8566a.f8707t = i2;
            return this;
        }

        /* renamed from: e */
        public a m8345e(boolean z) {
            this.f8566a.f8710w = z;
            return this;
        }

        /* renamed from: a */
        public a m8308a(Boolean bool) {
            this.f8566a.f8691d = bool;
            return this;
        }

        /* renamed from: b */
        public a m8331b(int i2) {
            this.f8566a.f8698k = i2;
            return this;
        }

        /* renamed from: c */
        public a m8338c(int i2) {
            this.f8566a.f8706s = i2;
            return this;
        }

        /* renamed from: d */
        public a m8343d(boolean z) {
            this.f8566a.f8709v = z;
            return this;
        }

        /* renamed from: a */
        public a m8302a(View view) {
            this.f8566a.f8693f = view;
            return this;
        }

        /* renamed from: b */
        public a m8333b(Boolean bool) {
            this.f8566a.f8700m = bool;
            return this;
        }

        /* renamed from: a */
        public a m8304a(EnumC2803c enumC2803c) {
            this.f8566a.f8695h = enumC2803c;
            return this;
        }

        /* renamed from: b */
        public a m8334b(boolean z) {
            this.f8566a.f8708u = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public a m8303a(AbstractC2770b abstractC2770b) {
            this.f8566a.f8696i = abstractC2770b;
            return this;
        }

        /* renamed from: b */
        public CenterListPopupView m8336b(String str, String[] strArr, int[] iArr, int i2, InterfaceC2812f interfaceC2812f) {
            m8306a(EnumC2806f.Center);
            CenterListPopupView m8489a = new CenterListPopupView(this.f8567b).m8490a(str, strArr, iArr).m8492c(i2).m8489a(interfaceC2812f);
            m8489a.f8617a = this.f8566a;
            return m8489a;
        }

        /* renamed from: a */
        public a m8301a(int i2) {
            this.f8566a.f8699l = i2;
            return this;
        }

        /* renamed from: a */
        public a m8305a(EnumC2804d enumC2804d) {
            this.f8566a.f8704q = enumC2804d;
            return this;
        }

        /* renamed from: a */
        public a m8309a(boolean z) {
            this.f8566a.f8711x = z;
            return this;
        }

        /* renamed from: a */
        public a m8307a(InterfaceC2815i interfaceC2815i) {
            this.f8566a.f8701n = interfaceC2815i;
            return this;
        }

        /* renamed from: a */
        public ConfirmPopupView m8324a(String str, String str2, String str3, String str4, InterfaceC2809c interfaceC2809c, InterfaceC2807a interfaceC2807a, boolean z) {
            m8306a(EnumC2806f.Center);
            ConfirmPopupView confirmPopupView = new ConfirmPopupView(this.f8567b);
            confirmPopupView.m8496a(str, str2, null);
            confirmPopupView.m8495a(str3);
            confirmPopupView.m8497b(str4);
            confirmPopupView.m8494a(interfaceC2809c, interfaceC2807a);
            if (z) {
                confirmPopupView.m8499v();
            }
            confirmPopupView.f8617a = this.f8566a;
            return confirmPopupView;
        }

        /* renamed from: b */
        public CenterListPopupView m8335b(String str, String[] strArr, InterfaceC2812f interfaceC2812f) {
            return m8336b(str, strArr, null, -1, interfaceC2812f);
        }

        /* renamed from: b */
        public CenterListPopupView m8337b(String str, String[] strArr, int[] iArr, InterfaceC2812f interfaceC2812f) {
            return m8336b(str, strArr, iArr, -1, interfaceC2812f);
        }

        /* renamed from: a */
        public ConfirmPopupView m8323a(String str, String str2, InterfaceC2809c interfaceC2809c, InterfaceC2807a interfaceC2807a) {
            return m8324a(str, str2, null, null, interfaceC2809c, interfaceC2807a, false);
        }

        /* renamed from: a */
        public ConfirmPopupView m8322a(String str, String str2, InterfaceC2809c interfaceC2809c) {
            return m8324a(str, str2, null, null, interfaceC2809c, null, false);
        }

        /* renamed from: a */
        public InputConfirmPopupView m8328a(String str, String str2, String str3, String str4, InterfaceC2811e interfaceC2811e, InterfaceC2807a interfaceC2807a) {
            m8306a(EnumC2806f.Center);
            InputConfirmPopupView inputConfirmPopupView = new InputConfirmPopupView(this.f8567b);
            inputConfirmPopupView.m8496a(str, str2, str4);
            inputConfirmPopupView.f8797F = str3;
            inputConfirmPopupView.m8500a(interfaceC2811e, interfaceC2807a);
            inputConfirmPopupView.f8617a = this.f8566a;
            return inputConfirmPopupView;
        }

        /* renamed from: a */
        public InputConfirmPopupView m8327a(String str, String str2, String str3, String str4, InterfaceC2811e interfaceC2811e) {
            return m8328a(str, str2, str3, str4, interfaceC2811e, (InterfaceC2807a) null);
        }

        /* renamed from: a */
        public InputConfirmPopupView m8326a(String str, String str2, String str3, InterfaceC2811e interfaceC2811e) {
            return m8328a(str, str2, (String) null, str3, interfaceC2811e, (InterfaceC2807a) null);
        }

        /* renamed from: a */
        public InputConfirmPopupView m8325a(String str, String str2, InterfaceC2811e interfaceC2811e) {
            return m8328a(str, str2, (String) null, (String) null, interfaceC2811e, (InterfaceC2807a) null);
        }

        /* renamed from: a */
        public LoadingPopupView m8330a(String str) {
            m8306a(EnumC2806f.Center);
            LoadingPopupView m8503a = new LoadingPopupView(this.f8567b).m8503a(str);
            m8503a.f8617a = this.f8566a;
            return m8503a;
        }

        /* renamed from: a */
        public LoadingPopupView m8329a() {
            return m8330a((String) null);
        }

        /* renamed from: a */
        public BottomListPopupView m8319a(String str, String[] strArr, int[] iArr, int i2, boolean z, InterfaceC2812f interfaceC2812f) {
            m8306a(EnumC2806f.Bottom);
            BottomListPopupView m8483a = new BottomListPopupView(this.f8567b).m8484a(str, strArr, iArr).m8486c(i2).m8483a(interfaceC2812f);
            m8483a.f8617a = this.f8566a;
            return m8483a;
        }

        /* renamed from: a */
        public BottomListPopupView m8317a(String str, String[] strArr, InterfaceC2812f interfaceC2812f) {
            return m8319a(str, strArr, (int[]) null, -1, true, interfaceC2812f);
        }

        /* renamed from: a */
        public BottomListPopupView m8320a(String str, String[] strArr, int[] iArr, InterfaceC2812f interfaceC2812f) {
            return m8319a(str, strArr, iArr, -1, true, interfaceC2812f);
        }

        /* renamed from: a */
        public BottomListPopupView m8318a(String str, String[] strArr, int[] iArr, int i2, InterfaceC2812f interfaceC2812f) {
            return m8319a(str, strArr, iArr, i2, true, interfaceC2812f);
        }

        /* renamed from: a */
        public BottomListPopupView m8321a(String str, String[] strArr, int[] iArr, boolean z, InterfaceC2812f interfaceC2812f) {
            return m8319a(str, strArr, iArr, -1, z, interfaceC2812f);
        }

        /* renamed from: a */
        public AttachListPopupView m8315a(String[] strArr, int[] iArr, int i2, int i3, InterfaceC2812f interfaceC2812f) {
            m8306a(EnumC2806f.AttachView);
            AttachListPopupView m8478a = new AttachListPopupView(this.f8567b).m8479a(strArr, iArr).m8477a(i2, i3).m8478a(interfaceC2812f);
            m8478a.f8617a = this.f8566a;
            return m8478a;
        }

        /* renamed from: a */
        public AttachListPopupView m8316a(String[] strArr, int[] iArr, InterfaceC2812f interfaceC2812f) {
            return m8315a(strArr, iArr, 0, 0, interfaceC2812f);
        }

        /* renamed from: a */
        public ImageViewerPopupView m8313a(ImageView imageView, Object obj, InterfaceC2816j interfaceC2816j) {
            m8306a(EnumC2806f.ImageViewer);
            ImageViewerPopupView m8415a = new ImageViewerPopupView(this.f8567b).m8413a(imageView, obj).m8415a(interfaceC2816j);
            m8415a.f8617a = this.f8566a;
            return m8415a;
        }

        /* renamed from: a */
        public ImageViewerPopupView m8314a(ImageView imageView, Object obj, boolean z, int i2, int i3, int i4, boolean z2, InterfaceC2816j interfaceC2816j) {
            m8306a(EnumC2806f.ImageViewer);
            ImageViewerPopupView m8415a = new ImageViewerPopupView(this.f8567b).m8413a(imageView, obj).m8417a(z).m8411a(i2).m8423c(i3).m8421b(i4).m8425d(z2).m8415a(interfaceC2816j);
            m8415a.f8617a = this.f8566a;
            return m8415a;
        }

        /* renamed from: a */
        public ImageViewerPopupView m8311a(ImageView imageView, int i2, List<Object> list, InterfaceC2813g interfaceC2813g, InterfaceC2816j interfaceC2816j) {
            return m8312a(imageView, i2, list, false, -1, -1, -1, true, interfaceC2813g, interfaceC2816j);
        }

        /* renamed from: a */
        public ImageViewerPopupView m8312a(ImageView imageView, int i2, List<Object> list, boolean z, int i3, int i4, int i5, boolean z2, InterfaceC2813g interfaceC2813g, InterfaceC2816j interfaceC2816j) {
            m8306a(EnumC2806f.ImageViewer);
            ImageViewerPopupView m8415a = new ImageViewerPopupView(this.f8567b).m8412a(imageView, i2).m8416a(list).m8417a(z).m8411a(i3).m8423c(i4).m8421b(i5).m8425d(z2).m8414a(interfaceC2813g).m8415a(interfaceC2816j);
            m8415a.f8617a = this.f8566a;
            return m8415a;
        }

        /* renamed from: a */
        public BasePopupView m8310a(BasePopupView basePopupView) {
            if (basePopupView instanceof CenterPopupView) {
                m8306a(EnumC2806f.Center);
            } else if (basePopupView instanceof BottomPopupView) {
                m8306a(EnumC2806f.Bottom);
            } else if (basePopupView instanceof AttachPopupView) {
                m8306a(EnumC2806f.AttachView);
            } else if (basePopupView instanceof ImageViewerPopupView) {
                m8306a(EnumC2806f.ImageViewer);
            } else if (basePopupView instanceof PositionPopupView) {
                m8306a(EnumC2806f.Position);
            }
            basePopupView.f8617a = this.f8566a;
            return basePopupView;
        }
    }

    private C2768b() {
    }

    /* renamed from: a */
    public static void m8295a(int i2) {
        if (i2 >= 0) {
            f8563b = i2;
        }
    }

    /* renamed from: b */
    public static void m8297b(int i2) {
        f8562a = i2;
    }

    /* renamed from: c */
    public static void m8299c(int i2) {
        f8565d = i2;
    }

    /* renamed from: a */
    public static int m8294a() {
        return f8563b;
    }

    /* renamed from: b */
    public static int m8296b() {
        return f8562a;
    }

    /* renamed from: c */
    public static int m8298c() {
        return f8565d;
    }
}
