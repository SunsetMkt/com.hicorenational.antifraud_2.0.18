package anet.channel.strategy;

import i.q2.t.m0;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ConnEvent {
    public boolean isSuccess = false;
    public long connTime = m0.f12222b;
    public boolean isAccs = false;

    public String toString() {
        return this.isSuccess ? "ConnEvent#Success" : "ConnEvent#Fail";
    }
}
