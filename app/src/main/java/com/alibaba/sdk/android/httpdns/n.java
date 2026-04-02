package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private static volatile n a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2583d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f2584e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f2585g = "https://";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f2586h = null;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static boolean f24h = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2587c;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private boolean f28e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private int f27e = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f25a = null;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private long f29f = 0;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private long f31g = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2588f = 0;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private boolean f30f = false;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private boolean f32g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2589i = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f26a = null;

    private n() {
    }

    public static n a() {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new n();
                }
            }
        }
        return a;
    }

    private void a(String str, long j2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.a(str, j2, com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        i.d("update server ips from StartIp schedule center.");
        this.f31g = System.currentTimeMillis();
        this.f27e = 0;
        this.f2588f = 0;
        this.f30f = false;
        this.f28e = true;
        this.f32g = true;
        f24h = false;
        m.a().a(f.f2572b.length - 1);
        c.a().submit(m.a());
        this.f26a = null;
    }

    private void d(Throwable th) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                int iA = com.alibaba.sdk.android.httpdns.d.c.a(th);
                bVarA.a(m25d(), String.valueOf(iA), th.getMessage(), com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String e() {
        return (this.f28e || this.f30f) ? f.f2572b[this.f2588f] : f.f19a[this.f27e];
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    private void m24e() {
        int i2 = this.f27e;
        this.f27e = i2 < f.f19a.length + (-1) ? i2 + 1 : 0;
    }

    private void f() {
        int i2 = this.f2588f;
        this.f2588f = i2 < f.f2572b.length + (-1) ? i2 + 1 : 0;
    }

    synchronized void a(Context context, String str) {
        try {
            if (!f2583d) {
                synchronized (n.class) {
                    if (!f2583d) {
                        setAccountId(str);
                        if (context != null) {
                            this.f25a = context.getSharedPreferences("httpdns_config_cache", 0);
                        }
                        this.f28e = this.f25a.getBoolean("httpdns_first_start", true);
                        f2586h = this.f25a.getString("httpdns_server_ips", null);
                        this.f2589i = this.f25a.getString("httpdns_region", null);
                        if (f2586h != null) {
                            f.a(f2586h.split(";"));
                        }
                        f2584e = this.f25a.getLong("schedule_center_last_request_time", 0L);
                        if (f2584e == 0 || System.currentTimeMillis() - f2584e >= 86400000) {
                            t.a().c(false);
                            c();
                        }
                        f2583d = true;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    synchronized void a(o oVar, long j2) {
        try {
            a(m25d(), j2);
            this.f27e = 0;
            this.f2588f = 0;
            this.f30f = false;
            this.f32g = true;
            HttpDns.switchDnsService(oVar.isEnabled());
            if (a(oVar.b())) {
                i.d("StartIp Scheduler center update success    StartIp isFirstStart\uff1a" + this.f28e);
                f24h = true;
                this.f29f = System.currentTimeMillis();
                u.i();
                if (this.f28e) {
                    SharedPreferences.Editor editorEdit = this.f25a.edit();
                    editorEdit.putBoolean("httpdns_first_start", false);
                    editorEdit.commit();
                    this.f28e = false;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    synchronized boolean a(String[] strArr) {
        try {
            if (!f.a(strArr)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
            if (this.f25a == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = this.f25a.edit();
            editorEdit.putString("httpdns_server_ips", sb.toString());
            editorEdit.putLong("schedule_center_last_request_time", System.currentTimeMillis());
            editorEdit.commit();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    synchronized void b(Context context, String str) {
        try {
            if (str.equals(this.f2589i)) {
                i.e("region should be different");
            } else {
                this.f2589i = str;
                if (System.currentTimeMillis() - this.f31g >= 300000) {
                    d();
                } else {
                    long jCurrentTimeMillis = 300000 - (System.currentTimeMillis() - this.f31g);
                    i.e("The call time should be greater than 5 minutes. SDK will initiate an update request after " + (jCurrentTimeMillis / com.heytap.mcssdk.constant.a.f3868d) + " minutes.");
                    if (this.f26a == null) {
                        this.f26a = new Handler();
                        this.f26a.postDelayed(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.n.1
                            @Override // java.lang.Runnable
                            public void run() {
                                n.this.d();
                            }
                        }, jCurrentTimeMillis);
                    }
                }
                if (this.f25a == null) {
                    if (context == null) {
                        i.f("sp failed to save, does not affect the current settings");
                        return;
                    }
                    this.f25a = context.getSharedPreferences("httpdns_config_cache", 0);
                }
                SharedPreferences.Editor editorEdit = this.f25a.edit();
                editorEdit.putString("httpdns_region", this.f2589i);
                editorEdit.putBoolean("httpdns_first_start", true);
                editorEdit.putLong("schedule_center_last_request_time", 0L);
                editorEdit.commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    synchronized void c() {
        m mVarA;
        int length;
        if (System.currentTimeMillis() - this.f29f >= 300000) {
            i.d("update server ips from StartIp schedule center.");
            this.f27e = 0;
            this.f2588f = 0;
            this.f30f = false;
            this.f32g = true;
            f24h = false;
            if (this.f28e) {
                mVarA = m.a();
                length = f.f2572b.length;
            } else {
                mVarA = m.a();
                length = f.f19a.length;
            }
            mVarA.a(length - 1);
            c.a().submit(m.a());
        } else {
            i.d("update server ips from StartIp schedule center too often, give up. ");
            u.j();
        }
    }

    synchronized void c(Throwable th) {
        try {
            f24h = false;
            d(th);
            if (this.f28e) {
                f();
            } else {
                if (!this.f30f) {
                    m24e();
                }
                if (this.f27e == 0) {
                    this.f30f = true;
                    if (this.f32g) {
                        this.f32g = false;
                        this.f2588f = 0;
                        i.d("StartIp Scheduler center update from StartIp");
                        m.a().a(f.f2572b.length - 1);
                        c.a().submit(m.a());
                    } else {
                        f();
                        if (this.f2588f == 0) {
                            this.f29f = System.currentTimeMillis();
                            i.f("StartIp Scheduler center update failed");
                            u.j();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    synchronized String m25d() {
        StringBuilder sb;
        String str;
        try {
            sb = new StringBuilder();
            sb.append(f2585g);
            sb.append(e());
            sb.append("/");
            sb.append(this.f2587c == null ? f.f2573c : this.f2587c);
            sb.append("/ss?platform=android&sdk_version=");
            sb.append("1.3.2.3-no-bssid-ssid");
            sb.append("&sid=");
            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
            sb.append("&net=");
            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
            if (TextUtils.isEmpty(this.f2589i)) {
                str = "";
            } else {
                str = "&region=" + this.f2589i;
            }
            sb.append(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    public void setAccountId(String str) {
        this.f2587c = str;
    }
}
