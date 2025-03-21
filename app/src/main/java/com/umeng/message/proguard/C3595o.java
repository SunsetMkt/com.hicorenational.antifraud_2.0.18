package com.umeng.message.proguard;

import anet.channel.util.ALog;
import com.taobao.accs.utl.ALog;
import com.umeng.message.common.UPLog;
import java.net.SocketTimeoutException;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.umeng.message.proguard.o */
/* loaded from: classes2.dex */
public final class C3595o implements ALog.ILog, ALog.ILog {
    @Override // anet.channel.util.ALog.ILog
    /* renamed from: d */
    public final void mo456d(String str, String str2) {
        UPLog.m12142d(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: e */
    public final void mo457e(String str, String str2) {
        UPLog.m12144e(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: i */
    public final void mo459i(String str, String str2) {
        UPLog.m12145i(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public final boolean isPrintLog(int i2) {
        return true;
    }

    @Override // anet.channel.util.ALog.ILog
    public final boolean isValid() {
        return true;
    }

    @Override // anet.channel.util.ALog.ILog
    public final void setLogLevel(int i2) {
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: w */
    public final void mo460w(String str, String str2) {
        UPLog.m12147w(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: e */
    public final void mo458e(String str, String str2, Throwable th) {
        if (th instanceof SocketTimeoutException) {
            UPLog.m12145i(str, str2 + AbstractC1191a.f2568g + th.getMessage());
            return;
        }
        UPLog.m12142d(str, str2, UPLog.getStackTrace(th));
        UPLog.m12144e(str, str2 + AbstractC1191a.f2568g + th.getMessage());
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: w */
    public final void mo461w(String str, String str2, Throwable th) {
        UPLog.m12142d(str, str2, UPLog.getStackTrace(th));
        UPLog.m12147w(str, str2 + AbstractC1191a.f2568g + th.getMessage());
    }
}
