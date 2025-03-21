package service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes2.dex */
public class FloatService extends AccessibilityService {

    /* renamed from: a */
    private static AccessibilityService f21719a;

    public FloatService() {
        f21719a = this;
    }

    /* renamed from: a */
    public static AccessibilityService m25192a() {
        AccessibilityService accessibilityService = f21719a;
        if (accessibilityService == null) {
            return null;
        }
        return accessibilityService;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }
}
