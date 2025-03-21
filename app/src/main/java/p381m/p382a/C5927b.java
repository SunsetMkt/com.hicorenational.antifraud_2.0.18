package p381m.p382a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import zxing.android.C7347f;

/* compiled from: CameraConfigurationManager.java */
/* renamed from: m.a.b */
/* loaded from: classes2.dex */
final class C5927b {

    /* renamed from: d */
    private static final String f21374d = "CameraConfiguration";

    /* renamed from: a */
    private final Context f21375a;

    /* renamed from: b */
    private Point f21376b;

    /* renamed from: c */
    private Point f21377c;

    C5927b(Context context) {
        this.f21375a = context;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    void m24878a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.f21375a.getSystemService("window")).getDefaultDisplay();
        this.f21376b = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        String str = "Screen resolution: " + this.f21376b;
        Point point = new Point();
        Point point2 = this.f21376b;
        point.x = point2.x;
        point.y = point2.y;
        int i2 = point2.x;
        int i3 = point2.y;
        if (i2 < i3) {
            point.x = i3;
            point.y = point2.x;
        }
        this.f21377c = C5928c.m24882a(parameters, point);
        String str2 = "Camera resolution: " + this.f21377c;
    }

    /* renamed from: b */
    Point m24881b() {
        return this.f21376b;
    }

    /* renamed from: a */
    void m24880a(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            return;
        }
        String str = "Initial camera parameters: " + parameters.flatten();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21375a);
        C5928c.m24890a(parameters, defaultSharedPreferences.getBoolean(C7347f.f25865g, true), defaultSharedPreferences.getBoolean(C7347f.f25866h, true), z);
        Point point = this.f21377c;
        parameters.setPreviewSize(point.x, point.y);
        m24879a(camera, 90);
        String str2 = "Final camera parameters: " + parameters.flatten();
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f21377c;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            String str3 = "Camera said it supported preview size " + this.f21377c.x + 'x' + this.f21377c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height;
            Point point3 = this.f21377c;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    /* renamed from: a */
    void m24879a(Camera camera, int i2) {
        try {
            Method method = camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
                method.invoke(camera, Integer.valueOf(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    Point m24877a() {
        return this.f21377c;
    }
}
