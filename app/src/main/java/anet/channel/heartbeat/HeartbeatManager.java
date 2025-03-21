package anet.channel.heartbeat;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HeartbeatManager {
    public static IHeartbeat getDefaultBackgroundAccsHeartbeat() {
        return new RunnableC0789a();
    }

    public static IHeartbeat getDefaultHeartbeat() {
        return new RunnableC0790b();
    }
}
