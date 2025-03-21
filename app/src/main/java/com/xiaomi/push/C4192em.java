package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.push.em */
/* loaded from: classes2.dex */
final class C4192em {

    /* renamed from: com.xiaomi.push.em$a */
    static class a {

        /* renamed from: a */
        EnumC4188ei f15183a;

        /* renamed from: a */
        String f15184a;

        a() {
        }
    }

    /* renamed from: a */
    private static void m14646a(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Throwable] */
    /* renamed from: b */
    static a m14647b(Exception exc) {
        Throwable cause;
        m14646a(exc);
        boolean z = exc instanceof C4215fi;
        Exception exc2 = exc;
        if (z) {
            C4215fi c4215fi = (C4215fi) exc;
            exc2 = exc;
            if (c4215fi.m14814a() != null) {
                exc2 = c4215fi.m14814a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int m14795a = C4209fc.m14795a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (m14795a != 0) {
            aVar.f15183a = EnumC4188ei.m14599a(EnumC4188ei.CONN_SUCCESS.m14600a() + m14795a);
            if (aVar.f15183a == EnumC4188ei.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f15183a = EnumC4188ei.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f15183a = EnumC4188ei.CONN_XMPP_ERR;
        }
        EnumC4188ei enumC4188ei = aVar.f15183a;
        if (enumC4188ei == EnumC4188ei.CONN_TCP_ERR_OTHER || enumC4188ei == EnumC4188ei.CONN_XMPP_ERR || enumC4188ei == EnumC4188ei.CONN_BOSH_ERR) {
            aVar.f15184a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    /* renamed from: c */
    static a m14648c(Exception exc) {
        m14646a(exc);
        boolean z = exc instanceof C4215fi;
        Exception exc2 = exc;
        if (z) {
            C4215fi c4215fi = (C4215fi) exc;
            exc2 = exc;
            if (c4215fi.m14814a() != null) {
                exc2 = c4215fi.m14814a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int m14795a = C4209fc.m14795a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (m14795a == 105) {
            aVar.f15183a = EnumC4188ei.BIND_TCP_READ_TIMEOUT;
        } else if (m14795a == 199) {
            aVar.f15183a = EnumC4188ei.BIND_TCP_ERR;
        } else if (m14795a == 499) {
            aVar.f15183a = EnumC4188ei.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f15183a = EnumC4188ei.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (m14795a == 109) {
            aVar.f15183a = EnumC4188ei.BIND_TCP_CONNRESET;
        } else if (m14795a != 110) {
            aVar.f15183a = EnumC4188ei.BIND_XMPP_ERR;
        } else {
            aVar.f15183a = EnumC4188ei.BIND_TCP_BROKEN_PIPE;
        }
        EnumC4188ei enumC4188ei = aVar.f15183a;
        if (enumC4188ei == EnumC4188ei.BIND_TCP_ERR || enumC4188ei == EnumC4188ei.BIND_XMPP_ERR || enumC4188ei == EnumC4188ei.BIND_BOSH_ERR) {
            aVar.f15184a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Throwable] */
    /* renamed from: d */
    static a m14649d(Exception exc) {
        m14646a(exc);
        boolean z = exc instanceof C4215fi;
        Exception exc2 = exc;
        if (z) {
            C4215fi c4215fi = (C4215fi) exc;
            exc2 = exc;
            if (c4215fi.m14814a() != null) {
                exc2 = c4215fi.m14814a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int m14795a = C4209fc.m14795a(exc2);
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (m14795a == 105) {
            aVar.f15183a = EnumC4188ei.CHANNEL_TCP_READTIMEOUT;
        } else if (m14795a == 199) {
            aVar.f15183a = EnumC4188ei.CHANNEL_TCP_ERR;
        } else if (m14795a == 499) {
            aVar.f15183a = EnumC4188ei.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f15183a = EnumC4188ei.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (m14795a == 109) {
            aVar.f15183a = EnumC4188ei.CHANNEL_TCP_CONNRESET;
        } else if (m14795a != 110) {
            aVar.f15183a = EnumC4188ei.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.f15183a = EnumC4188ei.CHANNEL_TCP_BROKEN_PIPE;
        }
        EnumC4188ei enumC4188ei = aVar.f15183a;
        if (enumC4188ei == EnumC4188ei.CHANNEL_TCP_ERR || enumC4188ei == EnumC4188ei.CHANNEL_XMPPEXCEPTION || enumC4188ei == EnumC4188ei.CHANNEL_BOSH_EXCEPTION) {
            aVar.f15184a = str;
        }
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Throwable] */
    /* renamed from: a */
    static a m14645a(Exception exc) {
        m14646a(exc);
        boolean z = exc instanceof C4215fi;
        Exception exc2 = exc;
        if (z) {
            C4215fi c4215fi = (C4215fi) exc;
            exc2 = exc;
            if (c4215fi.m14814a() != null) {
                exc2 = c4215fi.m14814a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int m14795a = C4209fc.m14795a(exc2);
        if (m14795a != 0) {
            aVar.f15183a = EnumC4188ei.m14599a(EnumC4188ei.GSLB_REQUEST_SUCCESS.m14600a() + m14795a);
        }
        if (aVar.f15183a == null) {
            aVar.f15183a = EnumC4188ei.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f15183a == EnumC4188ei.GSLB_TCP_ERR_OTHER) {
            aVar.f15184a = str;
        }
        return aVar;
    }
}
