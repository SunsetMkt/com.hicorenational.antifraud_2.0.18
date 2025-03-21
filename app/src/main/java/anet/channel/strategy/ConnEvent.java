package anet.channel.strategy;

import p286h.p309q2.p311t.C5556m0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConnEvent {
    public boolean isSuccess = false;
    public long connTime = C5556m0.f20396b;
    public boolean isAccs = false;

    public String toString() {
        return this.isSuccess ? "ConnEvent#Success" : "ConnEvent#Fail";
    }
}
