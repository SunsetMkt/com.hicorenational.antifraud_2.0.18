package com.umeng.analytics.vshelper;

/* loaded from: classes2.dex */
public class PageNameMonitor implements InterfaceC3436a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    /* renamed from: com.umeng.analytics.vshelper.PageNameMonitor$a */
    private static class C3435a {

        /* renamed from: a */
        private static final PageNameMonitor f12325a = new PageNameMonitor();

        private C3435a() {
        }
    }

    public static PageNameMonitor getInstance() {
        return C3435a.f12325a;
    }

    @Override // com.umeng.analytics.vshelper.InterfaceC3436a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.InterfaceC3436a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.InterfaceC3436a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.InterfaceC3436a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            if (currentCustomPage != null) {
                return currentCustomPage;
            }
            if (currentActivity == null) {
                return null;
            }
            return currentActivity;
        }
    }

    public String getCurrentActivityName() {
        String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }

    private PageNameMonitor() {
    }
}
