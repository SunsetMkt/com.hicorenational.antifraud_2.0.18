package n.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: CameraConfigurationManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12818d = "CameraConfiguration";
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Point f12819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Point f12820c;

    b(Context context) {
        this.a = context;
    }

    @SuppressLint({"NewApi"})
    void a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        this.f12819b = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        String str = "Screen resolution: " + this.f12819b;
        Point point = new Point();
        Point point2 = this.f12819b;
        point.x = point2.x;
        point.y = point2.y;
        int i2 = point2.x;
        int i3 = point2.y;
        if (i2 < i3) {
            point.x = i3;
            point.y = point2.x;
        }
        this.f12820c = c.a(parameters, point);
        String str2 = "Camera resolution: " + this.f12820c;
    }

    Point b() {
        return this.f12819b;
    }

    void a(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            return;
        }
        String str = "Initial camera parameters: " + parameters.flatten();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
        c.a(parameters, defaultSharedPreferences.getBoolean(zxing.android.f.f15168g, true), defaultSharedPreferences.getBoolean(zxing.android.f.f15169h, true), z);
        Point point = this.f12820c;
        parameters.setPreviewSize(point.x, point.y);
        a(camera, 90);
        String str2 = "Final camera parameters: " + parameters.flatten();
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f12820c;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            String str3 = "Camera said it supported preview size " + this.f12820c.x + 'x' + this.f12820c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height;
            Point point3 = this.f12820c;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    void a(Camera camera, int i2) {
        try {
            Method method = camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
                method.invoke(camera, Integer.valueOf(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    Point a() {
        return this.f12820c;
    }
}
