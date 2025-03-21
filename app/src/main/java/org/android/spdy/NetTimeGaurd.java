package org.android.spdy;

/* loaded from: classes2.dex */
public class NetTimeGaurd {
    public static final int CREATE = 0;
    public static final int ERROR = 2;
    public static final int PING = 1;
    public static final int STREAM = 3;
    private static final long calltime = 10;
    private static final long total = 50;
    private static long[] totaltime = new long[4];

    static long begin() {
        if (SpdyAgent.enableTimeGaurd) {
            return System.currentTimeMillis();
        }
        return 0L;
    }

    static void end(String str, int i2, long j2) {
        if (SpdyAgent.enableTimeGaurd) {
            long currentTimeMillis = System.currentTimeMillis() - j2;
            long[] jArr = totaltime;
            jArr[i2] = jArr[i2] + currentTimeMillis;
            String str2 = "NetTimeGaurd[end]" + str + " time=" + currentTimeMillis + " total=" + totaltime[i2];
            if (currentTimeMillis <= calltime) {
                return;
            }
            throw new SpdyErrorException("CallBack:" + str + " timeconsuming:" + currentTimeMillis + "  mustlessthan:" + calltime, -1);
        }
    }

    static void finish(int i2) {
        if (SpdyAgent.enableTimeGaurd) {
            String str = "NetTimeGaurd[finish]:time=" + totaltime[i2];
            if (totaltime[i2] <= total) {
                return;
            }
            throw new SpdyErrorException("CallBack totaltimeconsuming:" + totaltime[i2] + "  mustlessthan:" + total, -1);
        }
    }

    static void start(int i2) {
        if (SpdyAgent.enableTimeGaurd) {
            totaltime[i2] = 0;
        }
    }
}
