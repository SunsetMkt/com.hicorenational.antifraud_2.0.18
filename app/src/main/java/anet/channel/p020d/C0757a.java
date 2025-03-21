package anet.channel.p020d;

import anet.channel.util.ALog;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* renamed from: anet.channel.d.a */
/* loaded from: classes.dex */
public class C0757a implements ALog.ILog {
    /* renamed from: a */
    private int m455a(char c2) {
        if (c2 == 'D') {
            return 1;
        }
        if (c2 == 'E') {
            return 4;
        }
        if (c2 == 'I') {
            return 2;
        }
        if (c2 != 'V') {
            return c2 != 'W' ? 5 : 3;
        }
        return 0;
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: d */
    public void mo456d(String str, String str2) {
        AdapterForTLog.logd(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: e */
    public void mo457e(String str, String str2) {
        AdapterForTLog.loge(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: i */
    public void mo459i(String str, String str2) {
        AdapterForTLog.logi(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    public boolean isPrintLog(int i2) {
        return i2 >= m455a(AdapterForTLog.getLogLevel().charAt(0));
    }

    @Override // anet.channel.util.ALog.ILog
    public boolean isValid() {
        return AdapterForTLog.isValid();
    }

    @Override // anet.channel.util.ALog.ILog
    public void setLogLevel(int i2) {
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: w */
    public void mo460w(String str, String str2) {
        AdapterForTLog.logw(str, str2);
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: e */
    public void mo458e(String str, String str2, Throwable th) {
        AdapterForTLog.loge(str, str2, th);
    }

    @Override // anet.channel.util.ALog.ILog
    /* renamed from: w */
    public void mo461w(String str, String str2, Throwable th) {
        AdapterForTLog.logw(str, str2, th);
    }
}
