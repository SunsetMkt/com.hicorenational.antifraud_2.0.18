package com.xiaomi.push;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.push.fc */
/* loaded from: classes2.dex */
public class C4209fc {
    /* renamed from: a */
    public static int m14795a(Throwable th) {
        boolean z = th instanceof C4215fi;
        if (z) {
            C4215fi c4215fi = (C4215fi) th;
            if (c4215fi.m14814a() != null) {
                th = c4215fi.m14814a();
            }
        }
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        if (th instanceof SocketTimeoutException) {
            return 105;
        }
        if (!(th instanceof SocketException)) {
            if (th instanceof UnknownHostException) {
                return 107;
            }
            return z ? 399 : 0;
        }
        if (message.indexOf("Network is unreachable") != -1) {
            return 102;
        }
        if (message.indexOf("Connection refused") != -1) {
            return 103;
        }
        if (message.indexOf("Connection timed out") != -1) {
            return 105;
        }
        if (message.endsWith("EACCES (Permission denied)")) {
            return 101;
        }
        if (message.indexOf("Connection reset by peer") != -1) {
            return 109;
        }
        if (message.indexOf("Broken pipe") != -1) {
            return 110;
        }
        if (message.indexOf("No route to host") != -1) {
            return 104;
        }
        return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
    }
}
