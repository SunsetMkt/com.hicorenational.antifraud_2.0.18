package com.alibaba.sdk.android.httpdns.probe;

import com.alibaba.sdk.android.httpdns.i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
class g implements Runnable {
    private CountDownLatch a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f2601b;
    private String o;
    private int port;

    public g(String str, int i2, CountDownLatch countDownLatch, ConcurrentHashMap<String, Long> concurrentHashMap) {
        this.a = null;
        this.o = str;
        this.port = i2;
        this.a = countDownLatch;
        this.f2601b = concurrentHashMap;
    }

    private long a(String str, int i2) throws Throwable {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Socket socket = null;
        try {
            try {
                Socket socket2 = new Socket();
                try {
                    socket2.connect(new InetSocketAddress(str, i2), 5000);
                    jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        socket2.close();
                    } catch (IOException e2) {
                        i.f("socket close failed:" + e2.toString());
                    }
                } catch (IOException e3) {
                    e = e3;
                    socket = socket2;
                    i.f("connect failed:" + e.toString());
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e4) {
                            i.f("socket close failed:" + e4.toString());
                        }
                    }
                    jCurrentTimeMillis = 2147483647L;
                } catch (Throwable th) {
                    th = th;
                    socket = socket2;
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e5) {
                            i.f("socket close failed:" + e5.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
        if (jCurrentTimeMillis == 2147483647L) {
            return 2147483647L;
        }
        return jCurrentTimeMillis - jCurrentTimeMillis2;
    }

    private boolean a(int i2) {
        return i2 >= 1 && i2 <= 65535;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (this.o == null || !a(this.port)) {
                i.f("invalid params, give up");
            } else {
                long jA = a(this.o, this.port);
                i.d("connect cost for ip:" + this.o + " is " + jA);
                if (this.f2601b != null) {
                    this.f2601b.put(this.o, Long.valueOf(jA));
                }
            }
            if (this.a != null) {
                this.a.countDown();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
