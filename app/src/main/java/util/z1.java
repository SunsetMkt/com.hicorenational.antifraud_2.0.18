package util;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import java.util.Arrays;

/* JADX INFO: compiled from: ScreenSharingDetector.java */
/* JADX INFO: loaded from: classes2.dex */
public class z1 {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DisplayManager f15118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DisplayManager.DisplayListener f15119c = new a();

    /* JADX INFO: compiled from: ScreenSharingDetector.java */
    class a implements DisplayManager.DisplayListener {
        a() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i2) {
            s1.a("hsc", "onDisplayAdded: " + i2);
            for (Display display : Arrays.asList(z1.this.f15118b.getDisplays())) {
                s1.a("hsc", "22222width: " + display.getWidth() + d.c.a.b.a.a.f10074g + display.getHeight());
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                s1.a("hsc", "333333density: " + displayMetrics.density + d.c.a.b.a.a.f10074g + displayMetrics.widthPixels + d.c.a.b.a.a.f10074g + displayMetrics.heightPixels + d.c.a.b.a.a.f10074g + displayMetrics.densityDpi);
            }
            z1.this.a(i2);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i2) {
            s1.a("hsc", "Display changed: " + i2);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
            s1.a("hsc", "Display removed: " + i2);
        }
    }

    public z1(Context context) {
        this.a = context;
        this.f15118b = (DisplayManager) context.getSystemService("display");
    }

    public void b() {
        this.f15118b.unregisterDisplayListener(this.f15119c);
    }

    public void a() {
        this.f15118b.registerDisplayListener(this.f15119c, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Display display = this.f15118b.getDisplay(i2);
        if (display == null || !a(display)) {
            return;
        }
        s1.a("hsc", "Screen sharing detected: Virtual Display added");
    }

    private boolean a(Display display) {
        display.getMetrics(new DisplayMetrics());
        s1.a("hsc", "00000widthPixels: " + this.a.getResources().getDisplayMetrics().widthPixels + d.c.a.b.a.a.f10074g + this.a.getResources().getDisplayMetrics().heightPixels);
        return ((display.getFlags() & 8) == 0 && (display.getFlags() & 2) == 0) ? false : true;
    }
}
