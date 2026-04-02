package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class dc implements LoggerInterface {
    private LoggerInterface a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoggerInterface f8854b;

    public dc(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.a = null;
        this.f8854b = null;
        this.a = loggerInterface;
        this.f8854b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f8854b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f8854b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }
}
