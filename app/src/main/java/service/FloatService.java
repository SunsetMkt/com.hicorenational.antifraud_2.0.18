package service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes2.dex */
public class FloatService extends AccessibilityService {
    private static AccessibilityService a;

    public FloatService() {
        a = this;
    }

    public static AccessibilityService a() {
        AccessibilityService accessibilityService = a;
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
