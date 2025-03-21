package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.p114d.C1515b;
import com.alibaba.sdk.android.httpdns.p114d.C1516c;
import com.alibaba.sdk.android.httpdns.p115e.C1518a;
import com.heytap.mcssdk.constant.C2084a;

/* renamed from: com.alibaba.sdk.android.httpdns.n */
/* loaded from: classes.dex */
public class C1527n {

    /* renamed from: a */
    private static volatile C1527n f3942a = null;

    /* renamed from: d */
    private static boolean f3943d = false;

    /* renamed from: e */
    private static long f3944e = 0;

    /* renamed from: g */
    private static String f3945g = "https://";

    /* renamed from: h */
    private static String f3946h = null;

    /* renamed from: h */
    public static boolean f3947h = false;

    /* renamed from: c */
    private String f3950c;

    /* renamed from: e */
    private boolean f3952e;

    /* renamed from: e */
    private int f3951e = 0;

    /* renamed from: a */
    private SharedPreferences f3948a = null;

    /* renamed from: f */
    private long f3954f = 0;

    /* renamed from: g */
    private long f3956g = 0;

    /* renamed from: f */
    private int f3953f = 0;

    /* renamed from: f */
    private boolean f3955f = false;

    /* renamed from: g */
    private boolean f3957g = true;

    /* renamed from: i */
    private String f3958i = null;

    /* renamed from: a */
    private Handler f3949a = null;

    private C1527n() {
    }

    /* renamed from: a */
    public static C1527n m3536a() {
        if (f3942a == null) {
            synchronized (C1527n.class) {
                if (f3942a == null) {
                    f3942a = new C1527n();
                }
            }
        }
        return f3942a;
    }

    /* renamed from: a */
    private void m3538a(String str, long j2) {
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                m3486a.m3490a(str, j2, C1516c.m3506a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3539d() {
        C1522i.m3525d("update server ips from StartIp schedule center.");
        this.f3956g = System.currentTimeMillis();
        this.f3951e = 0;
        this.f3953f = 0;
        this.f3955f = false;
        this.f3952e = true;
        this.f3957g = true;
        f3947h = false;
        CallableC1526m.m3533a().m3534a(C1519f.f3923b.length - 1);
        C1511c.m3462a().submit(CallableC1526m.m3533a());
        this.f3949a = null;
    }

    /* renamed from: d */
    private void m3540d(Throwable th) {
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                int m3507a = C1516c.m3507a(th);
                m3486a.m3492a(m3550d(), String.valueOf(m3507a), th.getMessage(), C1516c.m3506a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e */
    private String m3541e() {
        return (this.f3952e || this.f3955f) ? C1519f.f3923b[this.f3953f] : C1519f.f3922a[this.f3951e];
    }

    /* renamed from: e */
    private void m3542e() {
        int i2 = this.f3951e;
        this.f3951e = i2 < C1519f.f3922a.length + (-1) ? i2 + 1 : 0;
    }

    /* renamed from: f */
    private void m3543f() {
        int i2 = this.f3953f;
        this.f3953f = i2 < C1519f.f3923b.length + (-1) ? i2 + 1 : 0;
    }

    /* renamed from: a */
    synchronized void m3544a(Context context, String str) {
        try {
            if (!f3943d) {
                synchronized (C1527n.class) {
                    if (!f3943d) {
                        setAccountId(str);
                        if (context != null) {
                            this.f3948a = context.getSharedPreferences("httpdns_config_cache", 0);
                        }
                        this.f3952e = this.f3948a.getBoolean("httpdns_first_start", true);
                        f3946h = this.f3948a.getString("httpdns_server_ips", null);
                        this.f3958i = this.f3948a.getString("httpdns_region", null);
                        if (f3946h != null) {
                            C1519f.m3520a(f3946h.split(";"));
                        }
                        f3944e = this.f3948a.getLong("schedule_center_last_request_time", 0L);
                        if (f3944e == 0 || System.currentTimeMillis() - f3944e >= 86400000) {
                            C1542t.m3580a().m3583c(false);
                            m3548c();
                        }
                        f3943d = true;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    synchronized void m3545a(C1530o c1530o, long j2) {
        try {
            m3538a(m3550d(), j2);
            this.f3951e = 0;
            this.f3953f = 0;
            this.f3955f = false;
            this.f3957g = true;
            HttpDns.switchDnsService(c1530o.isEnabled());
            if (m3546a(c1530o.m3557b())) {
                C1522i.m3525d("StartIp Scheduler center update success    StartIp isFirstStart：" + this.f3952e);
                f3947h = true;
                this.f3954f = System.currentTimeMillis();
                C1543u.m3598i();
                if (this.f3952e) {
                    SharedPreferences.Editor edit = this.f3948a.edit();
                    edit.putBoolean("httpdns_first_start", false);
                    edit.commit();
                    this.f3952e = false;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    synchronized boolean m3546a(String[] strArr) {
        try {
            if (!C1519f.m3520a(strArr)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
            if (this.f3948a == null) {
                return false;
            }
            SharedPreferences.Editor edit = this.f3948a.edit();
            edit.putString("httpdns_server_ips", sb.toString());
            edit.putLong("schedule_center_last_request_time", System.currentTimeMillis());
            edit.commit();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    synchronized void m3547b(Context context, String str) {
        try {
            if (str.equals(this.f3958i)) {
                C1522i.m3526e("region should be different");
            } else {
                this.f3958i = str;
                if (System.currentTimeMillis() - this.f3956g >= 300000) {
                    m3539d();
                } else {
                    long currentTimeMillis = 300000 - (System.currentTimeMillis() - this.f3956g);
                    C1522i.m3526e("The call time should be greater than 5 minutes. SDK will initiate an update request after " + (currentTimeMillis / C2084a.f6122d) + " minutes.");
                    if (this.f3949a == null) {
                        this.f3949a = new Handler();
                        this.f3949a.postDelayed(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.n.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C1527n.this.m3539d();
                            }
                        }, currentTimeMillis);
                    }
                }
                if (this.f3948a == null) {
                    if (context == null) {
                        C1522i.m3527f("sp failed to save, does not affect the current settings");
                        return;
                    }
                    this.f3948a = context.getSharedPreferences("httpdns_config_cache", 0);
                }
                SharedPreferences.Editor edit = this.f3948a.edit();
                edit.putString("httpdns_region", this.f3958i);
                edit.putBoolean("httpdns_first_start", true);
                edit.putLong("schedule_center_last_request_time", 0L);
                edit.commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: c */
    synchronized void m3548c() {
        CallableC1526m m3533a;
        int length;
        if (System.currentTimeMillis() - this.f3954f >= 300000) {
            C1522i.m3525d("update server ips from StartIp schedule center.");
            this.f3951e = 0;
            this.f3953f = 0;
            this.f3955f = false;
            this.f3957g = true;
            f3947h = false;
            if (this.f3952e) {
                m3533a = CallableC1526m.m3533a();
                length = C1519f.f3923b.length;
            } else {
                m3533a = CallableC1526m.m3533a();
                length = C1519f.f3922a.length;
            }
            m3533a.m3534a(length - 1);
            C1511c.m3462a().submit(CallableC1526m.m3533a());
        } else {
            C1522i.m3525d("update server ips from StartIp schedule center too often, give up. ");
            C1543u.m3599j();
        }
    }

    /* renamed from: c */
    synchronized void m3549c(Throwable th) {
        try {
            f3947h = false;
            m3540d(th);
            if (this.f3952e) {
                m3543f();
            } else {
                if (!this.f3955f) {
                    m3542e();
                }
                if (this.f3951e == 0) {
                    this.f3955f = true;
                    if (this.f3957g) {
                        this.f3957g = false;
                        this.f3953f = 0;
                        C1522i.m3525d("StartIp Scheduler center update from StartIp");
                        CallableC1526m.m3533a().m3534a(C1519f.f3923b.length - 1);
                        C1511c.m3462a().submit(CallableC1526m.m3533a());
                    } else {
                        m3543f();
                        if (this.f3953f == 0) {
                            this.f3954f = System.currentTimeMillis();
                            C1522i.m3527f("StartIp Scheduler center update failed");
                            C1543u.m3599j();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: d */
    synchronized String m3550d() {
        StringBuilder sb;
        String str;
        try {
            sb = new StringBuilder();
            sb.append(f3945g);
            sb.append(m3541e());
            sb.append("/");
            sb.append(this.f3950c == null ? C1519f.f3924c : this.f3950c);
            sb.append("/ss?platform=android&sdk_version=");
            sb.append("1.3.2.3-no-bssid-ssid");
            sb.append("&sid=");
            sb.append(C1518a.m3516a().getSessionId());
            sb.append("&net=");
            sb.append(C1518a.m3516a().m3517l());
            if (TextUtils.isEmpty(this.f3958i)) {
                str = "";
            } else {
                str = "&region=" + this.f3958i;
            }
            sb.append(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    public void setAccountId(String str) {
        this.f3950c = str;
    }
}
