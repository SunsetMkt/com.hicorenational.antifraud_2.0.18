package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* renamed from: com.xiaomi.push.dc */
/* loaded from: classes2.dex */
public class C4155dc implements LoggerInterface {

    /* renamed from: a */
    private LoggerInterface f14870a;

    /* renamed from: b */
    private LoggerInterface f14871b;

    public C4155dc(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f14870a = null;
        this.f14871b = null;
        this.f14870a = loggerInterface;
        this.f14871b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f14870a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f14871b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f14870a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f14871b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }
}
