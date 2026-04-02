package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile w f8109b;
    private final LinkedList<ac> a = new LinkedList<>();

    private w() {
    }

    public static w a() {
        if (f8109b == null) {
            synchronized (w.class) {
                if (f8109b == null) {
                    f8109b = new w();
                }
            }
        }
        return f8109b;
    }

    public final ac b() {
        ac acVarPollFirst;
        synchronized (this.a) {
            acVarPollFirst = this.a.pollFirst();
        }
        return acVarPollFirst;
    }

    public final int c() {
        int size;
        synchronized (this.a) {
            size = this.a.size();
        }
        return size;
    }

    public final void b(ac acVar) {
        synchronized (this.a) {
            this.a.remove(acVar);
        }
    }

    public final void a(ac acVar) {
        synchronized (this.a) {
            this.a.addLast(acVar);
        }
    }

    public final ac a(String str) {
        synchronized (this.a) {
            for (ac acVar : this.a) {
                UMessage uMessage = acVar.f7944b;
                if (uMessage != null && TextUtils.equals(str, uMessage.getMsgId())) {
                    return acVar;
                }
            }
            return null;
        }
    }
}
