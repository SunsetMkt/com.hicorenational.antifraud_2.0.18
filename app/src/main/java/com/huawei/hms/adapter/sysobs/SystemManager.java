package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SystemManager {

    /* renamed from: a */
    private static SystemManager f7091a = new SystemManager();

    /* renamed from: b */
    private static final Object f7092b = new Object();

    /* renamed from: c */
    private static SystemNotifier f7093c = new C2294a();

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return f7091a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f7093c;
    }

    public void notifyNoticeResult(int i2) {
        f7093c.notifyNoticeObservers(i2);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f7093c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i2) {
        f7093c.notifyObservers(i2);
    }

    /* renamed from: com.huawei.hms.adapter.sysobs.SystemManager$a */
    class C2294a implements SystemNotifier {

        /* renamed from: a */
        private final List<SystemObserver> f7094a = new ArrayList();

        C2294a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i2) {
            synchronized (SystemManager.f7092b) {
                Iterator<SystemObserver> it = this.f7094a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i2)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f7092b) {
                Iterator<SystemObserver> it = this.f7094a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f7094a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.f7092b) {
                this.f7094a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f7092b) {
                this.f7094a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i2) {
            synchronized (SystemManager.f7092b) {
                Iterator<SystemObserver> it = this.f7094a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i2)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
