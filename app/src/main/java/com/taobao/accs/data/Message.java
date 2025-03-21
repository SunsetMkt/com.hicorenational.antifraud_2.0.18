package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.AbstractC3001a;
import com.taobao.accs.p199ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.C3047o;
import com.taobao.accs.utl.C3048p;
import com.taobao.accs.utl.C3050r;
import com.taobao.accs.utl.UtilityImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.p309q2.p311t.C5558n;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Message implements Serializable {
    public static int CONTROL_MAX_RETRY_TIMES = 5;
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;

    /* renamed from: a */
    static long f9417a = 1;

    /* renamed from: D */
    byte[] f9421D;

    /* renamed from: E */
    int f9422E;

    /* renamed from: F */
    long f9423F;

    /* renamed from: G */
    transient NetPerformanceMonitor f9424G;

    /* renamed from: I */
    C2982Id f9426I;
    public String cunstomDataId;

    /* renamed from: d */
    short f9429d;
    public String dataId;

    /* renamed from: e */
    short f9430e;

    /* renamed from: f */
    short f9431f;

    /* renamed from: g */
    byte f9432g;

    /* renamed from: h */
    byte f9433h;
    public URL host;

    /* renamed from: i */
    String f9434i;

    /* renamed from: j */
    String f9435j;

    /* renamed from: l */
    Map<Integer, String> f9437l;
    public long startSendTime;
    public boolean isAck = false;
    public boolean force = false;
    public boolean isCancel = false;

    /* renamed from: b */
    byte f9427b = 0;

    /* renamed from: c */
    byte f9428c = 0;

    /* renamed from: k */
    int f9436k = -1;

    /* renamed from: m */
    String f9438m = null;
    public Integer command = null;

    /* renamed from: n */
    Integer f9439n = 0;

    /* renamed from: o */
    String f9440o = null;
    public String appSign = null;

    /* renamed from: p */
    Integer f9441p = null;

    /* renamed from: q */
    String f9442q = null;

    /* renamed from: r */
    String f9443r = null;

    /* renamed from: s */
    String f9444s = null;

    /* renamed from: t */
    String f9445t = null;

    /* renamed from: u */
    String f9446u = null;

    /* renamed from: v */
    Integer f9447v = null;

    /* renamed from: w */
    String f9448w = null;

    /* renamed from: x */
    String f9449x = null;
    public String userinfo = null;
    public String serviceId = null;

    /* renamed from: y */
    String f9450y = null;

    /* renamed from: z */
    String f9451z = null;

    /* renamed from: A */
    String f9418A = null;

    /* renamed from: B */
    String f9419B = null;

    /* renamed from: C */
    String f9420C = null;
    public long delyTime = 0;
    public int retryTimes = 0;
    public int timeout = AbstractC3001a.ACCS_RECEIVE_TIMEOUT;
    public String bizId = null;

    /* renamed from: H */
    String f9425H = null;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.data.Message$Id */
    public static class C2982Id implements Serializable {

        /* renamed from: a */
        private int f9452a;

        /* renamed from: b */
        private String f9453b;

        public C2982Id(int i2, String str) {
            this.f9452a = i2;
            this.f9453b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C2982Id.class != obj.getClass()) {
                return false;
            }
            C2982Id c2982Id = (C2982Id) obj;
            return this.f9452a == c2982Id.getId() || this.f9453b.equals(c2982Id.getDataId());
        }

        public String getDataId() {
            return this.f9453b;
        }

        public int getId() {
            return this.f9452a;
        }

        public int hashCode() {
            return this.f9453b.hashCode();
        }
    }

    /* compiled from: Taobao */
    public static class MsgResType implements Serializable {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static String name(int i2) {
            return i2 != 0 ? i2 != 1 ? "INVALID" : "NEED_ACK" : "NO_ACK";
        }

        public static int valueOf(int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 != 1) {
            }
            return 1;
        }
    }

    /* compiled from: Taobao */
    public static class MsgType implements Serializable {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static String name(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "INVALID" : "HANDSHAKE" : "PING" : "DATA" : "CONTROL";
        }

        public static int valueOf(int i2) {
            if (i2 == 0) {
                return 0;
            }
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    i3 = 3;
                    if (i2 != 3) {
                        return 0;
                    }
                }
            }
            return i3;
        }
    }

    /* compiled from: Taobao */
    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? DATA : RES : REQ : ACK : DATA;
        }
    }

    private Message() {
        synchronized (Message.class) {
            this.startSendTime = System.currentTimeMillis();
            this.dataId = this.startSendTime + "." + f9417a;
            long j2 = f9417a;
            f9417a = 1 + j2;
            this.f9426I = new C2982Id((int) j2, this.dataId);
        }
    }

    public static Message BuildPing(boolean z, int i2) {
        Message message = new Message();
        message.f9436k = 2;
        message.command = 201;
        message.force = z;
        message.delyTime = i2;
        return message;
    }

    public static Message buildBackground(String str) {
        Message message = new Message();
        message.m8989a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f9434i = Constants.TARGET_BACK;
        m8991a(str, message);
        return message;
    }

    @Deprecated
    public static Message buildBindApp(AbstractC3001a abstractC3001a, Context context, Intent intent) {
        return buildBindApp(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, context, intent);
    }

    @Deprecated
    public static Message buildBindService(AbstractC3001a abstractC3001a, Context context, Intent intent) {
        return buildBindService(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, intent);
    }

    @Deprecated
    public static Message buildBindUser(AbstractC3001a abstractC3001a, Context context, Intent intent) {
        return buildBindUser(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, intent);
    }

    public static Message buildErrorReportMessage(String str, String str2, String str3, int i2) {
        Message message = new Message();
        try {
            message.host = new URL(str3);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        message.f9434i = Constants.TARGET_SERVICE_ST;
        message.m8989a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f9421D = (0 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + C3042j.m9247b(GlobalClientInfo.getContext()) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2).getBytes();
        return message;
    }

    public static Message buildForeground(String str) {
        Message message = new Message();
        message.m8989a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f9434i = Constants.TARGET_FORE;
        m8991a(str, message);
        return message;
    }

    public static Message buildHandshake(String str) {
        Message message = new Message();
        message.m8989a(3, ReqType.DATA, 1);
        message.f9438m = str;
        message.f9434i = Constants.TARGET_CONTROL;
        message.command = 200;
        return message;
    }

    public static Message buildParameterError(String str, int i2) {
        Message message = new Message();
        message.m8989a(1, ReqType.ACK, 0);
        message.command = Integer.valueOf(i2);
        message.f9438m = str;
        return message;
    }

    @Deprecated
    public static Message buildPushAck(AbstractC3001a abstractC3001a, String str, String str2, String str3, boolean z, short s, String str4, Map<Integer, String> map) {
        return buildPushAck(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, str, str2, str3, z, s, str4, map);
    }

    @Deprecated
    public static Message buildRequest(AbstractC3001a abstractC3001a, Context context, String str, String str2, String str3, ACCSManager.AccsRequest accsRequest, boolean z) {
        return buildRequest(context, abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, abstractC3001a.f9529i.getStoreId(), str, str2, accsRequest, z);
    }

    @Deprecated
    public static Message buildSendData(AbstractC3001a abstractC3001a, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, abstractC3001a.f9529i.getStoreId(), context, str, accsRequest, true);
    }

    @Deprecated
    public static Message buildUnbindApp(AbstractC3001a abstractC3001a, Context context, Intent intent) {
        return buildUnbindApp(abstractC3001a.mo9091b((String) null), intent);
    }

    @Deprecated
    public static Message buildUnbindService(AbstractC3001a abstractC3001a, Context context, Intent intent) {
        return buildUnbindService(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, intent);
    }

    @Deprecated
    public static Message buildUnbindUser(AbstractC3001a abstractC3001a, Context context, Intent intent) {
        return buildUnbindUser(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, intent);
    }

    /* renamed from: c */
    private String m8994c() {
        return "Msg" + AbstractC1191a.f2606s1 + this.f9425H;
    }

    /* renamed from: a */
    short m8995a(Map<Integer, String> map) {
        short s = 0;
        if (map != null) {
            try {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    String str = map.get(Integer.valueOf(it.next().intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        s = (short) (s + ((short) (str.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN)) + 2);
                    }
                }
            } catch (Exception e2) {
                e2.toString();
            }
        }
        return s;
    }

    /* renamed from: b */
    void m8997b() throws JSONException, UnsupportedEncodingException {
        Integer num = this.command;
        if (num == null || num.intValue() == 100 || this.command.intValue() == 102) {
            return;
        }
        this.f9421D = new C3048p.a().m9260a("command", this.command.intValue() == 100 ? null : this.command).m9262a("appKey", this.f9440o).m9260a(Constants.KEY_OS_TYPE, this.f9441p).m9262a("sign", this.appSign).m9260a("sdkVersion", this.f9447v).m9262a("appVersion", this.f9446u).m9262a(Constants.KEY_TTID, this.f9448w).m9262a(Constants.KEY_MODEL, this.f9450y).m9262a("brand", this.f9451z).m9262a("imei", this.f9418A).m9262a(Constants.KEY_IMSI, this.f9419B).m9262a(Constants.KYE_MAC_ADDRESS, this.f9449x).m9262a("os", this.f9442q).m9262a(Constants.KEY_EXTS, this.f9445t).m9263a().toString().getBytes("utf-8");
    }

    public byte[] build(Context context, int i2) {
        byte[] bytes;
        try {
            m8997b();
        } catch (UnsupportedEncodingException e2) {
            ALog.m9181e(m8994c(), "build2", e2, new Object[0]);
        } catch (JSONException e3) {
            ALog.m9181e(m8994c(), "build1", e3, new Object[0]);
        }
        byte[] bArr = this.f9421D;
        String str = bArr != null ? new String(bArr) : "";
        m8996a();
        if (!this.isAck) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilityImpl.m9228j(context));
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(this.f9438m);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            String str2 = this.serviceId;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            String str3 = this.userinfo;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            this.f9435j = sb.toString();
        }
        try {
            bytes = (this.dataId + "").getBytes("utf-8");
            this.f9433h = (byte) this.f9435j.getBytes("utf-8").length;
            this.f9432g = (byte) this.f9434i.getBytes("utf-8").length;
        } catch (Exception e4) {
            e4.printStackTrace();
            ALog.m9181e(m8994c(), "build3", e4, new Object[0]);
            bytes = (this.dataId + "").getBytes();
            this.f9433h = (byte) this.f9435j.getBytes().length;
            this.f9432g = (byte) this.f9434i.getBytes().length;
        }
        short m8995a = m8995a(this.f9437l);
        int length = this.f9432g + 3 + 1 + this.f9433h + 1 + bytes.length;
        byte[] bArr2 = this.f9421D;
        this.f9430e = (short) (length + (bArr2 == null ? 0 : bArr2.length) + m8995a + 2);
        this.f9429d = (short) (this.f9430e + 2);
        C3050r c3050r = new C3050r(this.f9429d + 2 + 4);
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.m9180d(m8994c(), "Build Message", Constants.KEY_DATA_ID, new String(bytes));
        }
        try {
            c3050r.m9267a((byte) (this.f9427b | 32));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\tversion:2 compress:" + ((int) this.f9427b), new Object[0]);
            }
            if (i2 == 0) {
                c3050r.m9267a(C5558n.f20401a);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.m9180d(m8994c(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                c3050r.m9267a((byte) 64);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.m9180d(m8994c(), "\tflag: 0x40", new Object[0]);
                }
            }
            c3050r.m9268a(this.f9429d);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\ttotalLength:" + ((int) this.f9429d), new Object[0]);
            }
            c3050r.m9268a(this.f9430e);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\tdataLength:" + ((int) this.f9430e), new Object[0]);
            }
            c3050r.m9268a(this.f9431f);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\tflags:" + Integer.toHexString(this.f9431f), new Object[0]);
            }
            c3050r.m9267a(this.f9432g);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\ttargetLength:" + ((int) this.f9432g), new Object[0]);
            }
            c3050r.write(this.f9434i.getBytes("utf-8"));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\ttarget:" + this.f9434i, new Object[0]);
            }
            c3050r.m9267a(this.f9433h);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\tsourceLength:" + ((int) this.f9433h), new Object[0]);
            }
            c3050r.write(this.f9435j.getBytes("utf-8"));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\tsource:" + this.f9435j, new Object[0]);
            }
            c3050r.m9267a((byte) bytes.length);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            c3050r.write(bytes);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\tdataId:" + new String(bytes), new Object[0]);
            }
            c3050r.m9268a(m8995a);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\textHeader len:" + ((int) m8995a), new Object[0]);
            }
            if (this.f9437l != null) {
                Iterator<Integer> it = this.f9437l.keySet().iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    String str4 = this.f9437l.get(Integer.valueOf(intValue));
                    if (!TextUtils.isEmpty(str4)) {
                        c3050r.m9268a((short) ((((short) intValue) << 10) | ((short) (str4.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN))));
                        c3050r.write(str4.getBytes("utf-8"));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.m9180d(m8994c(), "\textHeader key:" + intValue + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            if (this.f9421D != null) {
                c3050r.write(this.f9421D);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(m8994c(), "\toriData:" + str, new Object[0]);
            }
            c3050r.flush();
        } catch (IOException e5) {
            ALog.m9181e(m8994c(), "build4", e5, new Object[0]);
        }
        byte[] byteArray = c3050r.toByteArray();
        try {
            c3050r.close();
        } catch (IOException e6) {
            ALog.m9181e(m8994c(), "build5", e6, new Object[0]);
        }
        return byteArray;
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getDelyTime() {
        return this.delyTime;
    }

    public C2982Id getMsgId() {
        return this.f9426I;
    }

    public NetPerformanceMonitor getNetPermanceMonitor() {
        return this.f9424G;
    }

    public int getNode() {
        return this.f9422E;
    }

    public String getPackageName() {
        String str = this.f9438m;
        return str == null ? "" : str;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getType() {
        return this.f9436k;
    }

    public boolean isControlFrame() {
        return Constants.TARGET_CONTROL.equals(this.f9434i);
    }

    public boolean isTimeOut() {
        boolean z = (System.currentTimeMillis() - this.startSendTime) + this.delyTime >= ((long) this.timeout);
        if (z) {
            ALog.m9182e(m8994c(), "delay time:" + this.delyTime + " beforeSendTime:" + (System.currentTimeMillis() - this.startSendTime) + " timeout" + this.timeout, new Object[0]);
        }
        return z;
    }

    public void setSendTime(long j2) {
        this.f9423F = j2;
    }

    public static Message buildBindApp(String str, String str2, Context context, Intent intent) {
        Message message = null;
        try {
            message = buildBindApp(context, str2, intent.getStringExtra("appKey"), intent.getStringExtra("app_sercet"), intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_TTID), intent.getStringExtra("appVersion"));
            m8991a(str, message);
            return message;
        } catch (Exception e2) {
            ALog.m9182e("Msg", "buildBindApp", e2.getMessage());
            return message;
        }
    }

    public static Message buildBindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            message.f9425H = str2;
            m8991a(str, message);
            return message;
        } catch (Exception e2) {
            ALog.m9181e("Msg", "buildBindService", e2, new Object[0]);
            e2.printStackTrace();
            return message;
        }
    }

    public static Message buildBindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra("userInfo"));
            if (message != null) {
                message.f9425H = str2;
                m8991a(str, message);
            }
        } catch (Exception e2) {
            ALog.m9181e("Msg", "buildBindUser", e2, new Object[0]);
            e2.printStackTrace();
        }
        return message;
    }

    public static Message buildPushAck(String str, String str2, String str3, String str4, String str5, boolean z, short s, String str6, Map<Integer, String> map) {
        Message message = new Message();
        message.f9422E = 1;
        message.m8993a(s, z);
        message.f9435j = str3;
        message.f9434i = str4;
        message.dataId = str5;
        message.isAck = true;
        message.f9437l = map;
        try {
            try {
                if (TextUtils.isEmpty(str6)) {
                    message.host = new URL(str);
                } else {
                    message.host = new URL(str6);
                }
                message.f9425H = str2;
                if (message.host == null) {
                    message.host = new URL(str);
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ALog.m9181e("Msg", "buildPushAck", th, new Object[0]);
                if (message.host == null) {
                    message.host = new URL(str);
                }
            } catch (Throwable th2) {
                if (message.host == null) {
                    try {
                        message.host = new URL(str);
                    } catch (MalformedURLException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th2;
            }
        }
        return message;
    }

    public static Message buildRequest(Context context, String str, String str2, String str3, String str4, String str5, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.f9422E = 1;
        message.m8989a(1, ReqType.REQ, 1);
        message.command = 100;
        message.f9438m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.f9421D = accsRequest.data;
        String str6 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(str6);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        String str7 = accsRequest.target;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        message.f9434i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        message.f9425H = str2;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.timeout = i2;
        }
        if (z) {
            m8992a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        m8990a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f9388c, accsRequest.businessId, accsRequest.tag);
        message.f9424G = new NetPerformanceMonitor();
        message.f9424G.setDataId(accsRequest.dataId);
        message.f9424G.setServiceId(accsRequest.serviceId);
        message.f9424G.setHost(message.host.toString());
        message.f9425H = str2;
        return message;
    }

    @Deprecated
    public static Message buildSendData(AbstractC3001a abstractC3001a, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z) {
        return buildSendData(abstractC3001a.mo9091b((String) null), abstractC3001a.f9533m, abstractC3001a.f9529i.getStoreId(), context, str, accsRequest, z);
    }

    public static Message buildUnbindApp(String str, Intent intent) {
        ALog.m9182e("Msg", "buildUnbindApp1" + UtilityImpl.m9198a(new Exception()), new Object[0]);
        Message message = null;
        try {
            message = buildUnbindApp(str, intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            m8991a(str, message);
            return message;
        } catch (Exception e2) {
            ALog.m9182e("Msg", "buildUnbindApp1", e2.getMessage());
            return message;
        }
    }

    public static Message buildUnbindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            message.f9425H = str2;
            m8991a(str, message);
            return message;
        } catch (Exception e2) {
            ALog.m9181e("Msg", "buildUnbindService", e2, new Object[0]);
            e2.printStackTrace();
            return message;
        }
    }

    public static Message buildUnbindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            message.f9425H = str2;
            m8991a(str, message);
            return message;
        } catch (Exception e2) {
            ALog.m9181e("Msg", "buildUnbindUser", e2, new Object[0]);
            e2.printStackTrace();
            return message;
        }
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(str, str2, str3, context, str4, accsRequest, true);
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.f9422E = 1;
        message.m8989a(1, ReqType.DATA, 1);
        message.command = 100;
        message.f9438m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.f9421D = accsRequest.data;
        String str5 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TARGET_SERVICE_PRE);
        sb.append(str5);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        String str6 = accsRequest.target;
        if (str6 == null) {
            str6 = "";
        }
        sb.append(str6);
        message.f9434i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.timeout = i2;
        }
        if (z) {
            m8992a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        m8990a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f9388c, accsRequest.businessId, accsRequest.tag);
        message.f9424G = new NetPerformanceMonitor();
        message.f9424G.setMsgType(0);
        message.f9424G.setDataId(accsRequest.dataId);
        message.f9424G.setServiceId(accsRequest.serviceId);
        message.f9424G.setHost(message.host.toString());
        message.f9425H = str2;
        return message;
    }

    /* renamed from: a */
    void m8996a() {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
            } catch (Throwable th2) {
                gZIPOutputStream = null;
                th = th2;
                byteArrayOutputStream = null;
            }
            if (this.f9421D == null) {
                return;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th3) {
                gZIPOutputStream = null;
                th = th3;
            }
            try {
                gZIPOutputStream.write(this.f9421D);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray != null && byteArray.length < this.f9421D.length) {
                    this.f9421D = byteArray;
                    this.f9427b = (byte) 1;
                }
                gZIPOutputStream.close();
            } catch (Throwable th4) {
                th = th4;
                try {
                    m8994c();
                    th.toString();
                    th.printStackTrace();
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    if (byteArrayOutputStream == null) {
                        return;
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                            throw th5;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th5;
                }
            }
            byteArrayOutputStream.close();
        } catch (Exception unused2) {
        }
    }

    @Deprecated
    public static Message buildUnbindApp(AbstractC3001a abstractC3001a, Context context, String str, String str2, String str3, String str4) {
        return buildUnbindApp(abstractC3001a.mo9091b((String) null), str);
    }

    public static Message buildUnbindApp(String str, String str2) {
        Message message;
        try {
            ALog.m9180d("Msg", "buildUnbindApp", new Object[0]);
        } catch (Exception e2) {
            e = e2;
            message = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        message = new Message();
        try {
            message.f9422E = 1;
            message.m8989a(1, ReqType.DATA, 1);
            message.f9438m = str2;
            message.f9434i = Constants.TARGET_CONTROL;
            message.command = 2;
            message.f9438m = str2;
            message.f9447v = 221;
            message.cunstomDataId = KEY_UNBINDAPP;
            m8991a(str, message);
        } catch (Exception e3) {
            e = e3;
            ALog.m9182e("Msg", "buildUnbindApp", e.getMessage());
            return message;
        }
        return message;
    }

    @Deprecated
    public static Message buildUnbindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildUnbindUser(str);
    }

    @Deprecated
    public static Message buildBindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildBindService(str, str3);
    }

    @Deprecated
    public static Message buildBindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildBindUser(str, str4);
    }

    @Deprecated
    public static Message buildUnbindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildUnbindService(str, str3);
    }

    public static Message buildUnbindUser(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.f9422E = 1;
        message.m8989a(1, ReqType.DATA, 1);
        message.f9438m = str;
        message.f9434i = Constants.TARGET_CONTROL;
        message.command = 4;
        message.f9447v = 221;
        message.cunstomDataId = KEY_UNBINDUSER;
        return message;
    }

    @Deprecated
    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return buildBindApp(context, str, str2, str3, str4, str5, str6);
    }

    public static Message buildBindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.f9422E = 1;
        message.m8989a(1, ReqType.DATA, 1);
        message.f9438m = str;
        message.serviceId = str2;
        message.f9434i = Constants.TARGET_CONTROL;
        message.command = 5;
        message.f9438m = str;
        message.serviceId = str2;
        message.f9447v = 221;
        message.cunstomDataId = KEY_BINDSERVICE;
        return message;
    }

    public static Message buildBindUser(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.f9422E = 1;
        message.m8989a(1, ReqType.DATA, 1);
        message.f9438m = str;
        message.userinfo = str2;
        message.f9434i = Constants.TARGET_CONTROL;
        message.command = 3;
        message.f9438m = str;
        message.userinfo = str2;
        message.f9447v = 221;
        message.cunstomDataId = KEY_BINDUSER;
        return message;
    }

    public static Message buildUnbindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.f9422E = 1;
        message.m8989a(1, ReqType.DATA, 1);
        message.f9438m = str;
        message.serviceId = str2;
        message.f9434i = Constants.TARGET_CONTROL;
        message.command = 6;
        message.f9438m = str;
        message.serviceId = str2;
        message.f9447v = 221;
        message.cunstomDataId = KEY_UNBINDSERVICE;
        return message;
    }

    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.f9422E = 1;
        message.m8989a(1, ReqType.DATA, 1);
        message.f9441p = 1;
        message.f9442q = Build.VERSION.SDK_INT + "";
        message.f9438m = str4;
        message.f9434i = Constants.TARGET_CONTROL;
        message.command = 1;
        message.f9440o = str2;
        message.appSign = UtilityImpl.m9197a(str2, str3, UtilityImpl.m9228j(context));
        message.f9447v = 221;
        message.f9446u = str6;
        message.f9438m = str4;
        message.f9448w = str5;
        message.f9450y = Build.MODEL;
        message.f9451z = Build.BRAND;
        message.cunstomDataId = KEY_BINDAPP;
        message.f9425H = str;
        message.f9445t = new C3048p.a().m9262a("notifyEnable", UtilityImpl.m9233o(context)).m9262a("romInfo", new C3047o().mo9258a()).m9263a().toString();
        UtilityImpl.m9202a(context, Constants.SP_FILE_NAME, UtilityImpl.m9233o(context));
        return message;
    }

    /* renamed from: a */
    private static void m8992a(String str, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.host = new URL(str);
                return;
            } catch (MalformedURLException e2) {
                ALog.m9181e("Msg", "setUnit", e2, new Object[0]);
                e2.printStackTrace();
                return;
            }
        }
        message.host = url;
    }

    /* renamed from: a */
    private static void m8991a(String str, Message message) {
        try {
            message.host = new URL(str);
        } catch (Exception e2) {
            ALog.m9181e("Msg", "setControlHost", e2, new Object[0]);
        }
    }

    /* renamed from: a */
    private static void m8990a(Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str6) && str4 == null) {
            return;
        }
        message.f9437l = new HashMap();
        if (str5 != null && UtilityImpl.m9193a(str5) <= 1023) {
            message.f9437l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
        }
        if (str != null && UtilityImpl.m9193a(str) <= 1023) {
            message.f9437l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
        }
        if (str2 != null && UtilityImpl.m9193a(str2) <= 1023) {
            message.f9437l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
        }
        if (str6 != null && UtilityImpl.m9193a(str6) <= 1023) {
            message.f9437l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
        }
        if (str4 != null && UtilityImpl.m9193a(str4) <= 1023) {
            message.f9437l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
        }
        if (str3 == null || UtilityImpl.m9193a(str3) > 1023) {
            return;
        }
        message.f9437l.put(19, str3);
    }

    /* renamed from: a */
    private void m8989a(int i2, ReqType reqType, int i3) {
        this.f9436k = i2;
        if (i2 != 2) {
            this.f9431f = (short) (((((i2 & 1) << 4) | (reqType.ordinal() << 2)) | i3) << 11);
        }
    }

    /* renamed from: a */
    private void m8993a(short s, boolean z) {
        this.f9436k = 1;
        this.f9431f = s;
        this.f9431f = (short) (this.f9431f & (-16385));
        this.f9431f = (short) (this.f9431f | 8192);
        this.f9431f = (short) (this.f9431f & (-2049));
        this.f9431f = (short) (this.f9431f & (-65));
        if (z) {
            this.f9431f = (short) (this.f9431f | 32);
        }
    }
}
