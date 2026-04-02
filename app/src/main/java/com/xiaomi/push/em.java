package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
final class em {

    static class a {
        ei a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f449a;

        a() {
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m378a(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }

    static a b(Exception exc) {
        Throwable cause;
        m378a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = fc.a(thA);
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA != 0) {
            aVar.a = ei.a(ei.CONN_SUCCESS.a() + iA);
            if (aVar.a == ei.CONN_BOSH_ERR && (cause = thA.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.a = ei.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.a = ei.CONN_XMPP_ERR;
        }
        ei eiVar = aVar.a;
        if (eiVar == ei.CONN_TCP_ERR_OTHER || eiVar == ei.CONN_XMPP_ERR || eiVar == ei.CONN_BOSH_ERR) {
            aVar.f449a = str;
        }
        return aVar;
    }

    static a c(Exception exc) {
        m378a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = fc.a(thA);
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.a = ei.BIND_TCP_READ_TIMEOUT;
        } else if (iA == 199) {
            aVar.a = ei.BIND_TCP_ERR;
        } else if (iA == 499) {
            aVar.a = ei.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.a = ei.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (iA == 109) {
            aVar.a = ei.BIND_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.a = ei.BIND_XMPP_ERR;
        } else {
            aVar.a = ei.BIND_TCP_BROKEN_PIPE;
        }
        ei eiVar = aVar.a;
        if (eiVar == ei.BIND_TCP_ERR || eiVar == ei.BIND_XMPP_ERR || eiVar == ei.BIND_BOSH_ERR) {
            aVar.f449a = str;
        }
        return aVar;
    }

    static a d(Exception exc) {
        m378a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        int iA = fc.a(thA);
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (iA == 105) {
            aVar.a = ei.CHANNEL_TCP_READTIMEOUT;
        } else if (iA == 199) {
            aVar.a = ei.CHANNEL_TCP_ERR;
        } else if (iA == 499) {
            aVar.a = ei.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.a = ei.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (iA == 109) {
            aVar.a = ei.CHANNEL_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.a = ei.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.a = ei.CHANNEL_TCP_BROKEN_PIPE;
        }
        ei eiVar = aVar.a;
        if (eiVar == ei.CHANNEL_TCP_ERR || eiVar == ei.CHANNEL_XMPPEXCEPTION || eiVar == ei.CHANNEL_BOSH_EXCEPTION) {
            aVar.f449a = str;
        }
        return aVar;
    }

    static a a(Exception exc) {
        m378a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        String str = thA.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int iA = fc.a(thA);
        if (iA != 0) {
            aVar.a = ei.a(ei.GSLB_REQUEST_SUCCESS.a() + iA);
        }
        if (aVar.a == null) {
            aVar.a = ei.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == ei.GSLB_TCP_ERR_OTHER) {
            aVar.f449a = str;
        }
        return aVar;
    }
}
