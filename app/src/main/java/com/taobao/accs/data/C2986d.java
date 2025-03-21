package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import bean.SurveyH5Bean;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.net.AbstractC3001a;
import com.taobao.accs.net.C3011k;
import com.taobao.accs.p199ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.p199ut.monitor.TrafficsMonitor;
import com.taobao.accs.p199ut.p200a.C3026a;
import com.taobao.accs.p199ut.p200a.C3027b;
import com.taobao.accs.p199ut.p200a.C3029d;
import com.taobao.accs.p199ut.p200a.C3030e;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.C3048p;
import com.taobao.accs.utl.C3051s;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.d */
/* loaded from: classes2.dex */
public class C2986d {

    /* renamed from: b */
    public int f9468b;

    /* renamed from: c */
    protected TrafficsMonitor f9469c;

    /* renamed from: d */
    public FlowControl f9470d;

    /* renamed from: e */
    public AntiBrush f9471e;

    /* renamed from: i */
    private Context f9475i;

    /* renamed from: j */
    private C3029d f9476j;

    /* renamed from: k */
    private Message f9477k;

    /* renamed from: l */
    private AbstractC3001a f9478l;

    /* renamed from: m */
    private String f9479m;

    /* renamed from: g */
    private ConcurrentMap<Message.C2982Id, Message> f9473g = new ConcurrentHashMap();

    /* renamed from: a */
    public ConcurrentMap<String, ScheduledFuture<?>> f9467a = new ConcurrentHashMap();

    /* renamed from: h */
    private boolean f9474h = false;

    /* renamed from: f */
    public String f9472f = "";

    /* renamed from: n */
    private LinkedHashMap<String, String> f9480n = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };

    /* renamed from: o */
    private Map<String, C2983a> f9481o = new HashMap();

    /* renamed from: p */
    private Runnable f9482p = new RunnableC2988f(this);

    public C2986d(Context context, AbstractC3001a abstractC3001a) {
        String str;
        this.f9479m = "MsgRecv_";
        this.f9475i = context;
        this.f9478l = abstractC3001a;
        this.f9469c = new TrafficsMonitor(this.f9475i);
        this.f9470d = new FlowControl(this.f9475i);
        this.f9471e = new AntiBrush(this.f9475i);
        if (abstractC3001a == null) {
            str = this.f9479m;
        } else {
            str = this.f9479m + abstractC3001a.f9533m;
        }
        this.f9479m = str;
        m9020i();
        m9040h();
    }

    /* renamed from: b */
    private boolean m9016b(int i2) {
        return i2 == -1 || i2 == -9 || i2 == -10 || i2 == -11;
    }

    /* renamed from: i */
    private void m9020i() {
        try {
            File file = new File(this.f9475i.getDir("accs", 0), "message" + this.f9478l.m9105i());
            if (!file.exists()) {
                ALog.m9180d(this.f9479m, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return;
                }
                this.f9480n.put(readLine, readLine);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: j */
    private void m9021j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f9475i.getDir("accs", 0), "message" + this.f9478l.m9105i()));
            fileWriter.write("");
            Iterator<String> it = this.f9480n.keySet().iterator();
            while (it.hasNext()) {
                fileWriter.append((CharSequence) it.next()).append((CharSequence) "\r\n");
            }
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m9030a(byte[] bArr) throws IOException {
        m9031a(bArr, (String) null);
    }

    /* renamed from: b */
    public void m9033b() {
        ALog.m9180d(this.f9479m, "onRcvPing", new Object[0]);
        synchronized (C2986d.class) {
            this.f9474h = false;
        }
    }

    /* renamed from: c */
    public boolean m9035c() {
        return this.f9474h;
    }

    /* renamed from: d */
    public int m9036d() {
        return this.f9473g.size();
    }

    /* renamed from: e */
    public Collection<Message> m9037e() {
        return this.f9473g.values();
    }

    /* renamed from: f */
    public Set<Message.C2982Id> m9038f() {
        return this.f9473g.keySet();
    }

    /* renamed from: g */
    public C3029d m9039g() {
        return this.f9476j;
    }

    /* renamed from: h */
    public void m9040h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.f9482p);
        } catch (Throwable th) {
            ALog.m9181e(this.f9479m, "restoreTraffics", th, new Object[0]);
        }
    }

    /* renamed from: c */
    private boolean m9018c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9480n.containsKey(str);
    }

    /* renamed from: d */
    private void m9019d(String str) {
        if (TextUtils.isEmpty(str) || this.f9480n.containsKey(str)) {
            return;
        }
        this.f9480n.put(str, str);
        m9021j();
    }

    /* renamed from: a */
    public void m9031a(byte[] bArr, String str) throws IOException {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i(this.f9479m, "onMessage", Constants.KEY_HOST, str);
        }
        C3051s c3051s = new C3051s(bArr);
        try {
            int m9269a = c3051s.m9269a();
            int i2 = (m9269a & 240) >> 4;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(this.f9479m, "version:" + i2, new Object[0]);
            }
            int i3 = m9269a & 15;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(this.f9479m, "compress:" + i3, new Object[0]);
            }
            c3051s.m9269a();
            int m9271b = c3051s.m9271b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(this.f9479m, "totalLen:" + m9271b, new Object[0]);
            }
            int i4 = 0;
            while (i4 < m9271b) {
                int m9271b2 = c3051s.m9271b();
                int i5 = i4 + 2;
                if (m9271b2 <= 0) {
                    throw new IOException("data format error");
                }
                byte[] bArr2 = new byte[m9271b2];
                c3051s.read(bArr2);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.m9180d(this.f9479m, "buf len:" + bArr2.length, new Object[0]);
                }
                i4 = i5 + bArr2.length;
                m9007a(i3, bArr2, str, i2);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: c */
    private Intent m9017c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.f9438m);
        intent.putExtra("command", message.command);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.serviceId);
        intent.putExtra("userInfo", message.userinfo);
        Integer num = message.command;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        NetPerformanceMonitor netPerformanceMonitor = message.f9424G;
        if (netPerformanceMonitor != null) {
            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
        }
        return intent;
    }

    /* renamed from: b */
    public void m9034b(Message message) {
        if (this.f9473g.keySet().size() > 0) {
            Iterator<Message.C2982Id> it = this.f9473g.keySet().iterator();
            while (it.hasNext()) {
                Message message2 = this.f9473g.get(it.next());
                if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.m9182e(this.f9479m, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    /* renamed from: b */
    public Message m9032b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f9473g.remove(new Message.C2982Id(0, str));
    }

    /* renamed from: b */
    private void m9015b(Message message, int i2) {
        if (message == null) {
            return;
        }
        String m9228j = UtilityImpl.m9228j(this.f9475i);
        String str = System.currentTimeMillis() + "";
        boolean z = i2 == 200;
        int intValue = message.command.intValue();
        if (intValue == 1) {
            C3026a c3026a = new C3026a();
            c3026a.f9630a = m9228j;
            c3026a.f9631b = str;
            c3026a.f9632c = z;
            c3026a.m9166a(i2);
            c3026a.m9165a();
            return;
        }
        if (intValue != 3) {
            return;
        }
        C3027b c3027b = new C3027b();
        c3027b.f9636a = m9228j;
        c3027b.f9637b = str;
        c3027b.f9638c = z;
        c3027b.f9640e = message.userinfo;
        c3027b.m9170a(i2);
        c3027b.m9169a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0633 A[Catch: Exception -> 0x067b, TryCatch #2 {Exception -> 0x067b, blocks: (B:122:0x0623, B:124:0x0633, B:187:0x064e), top: B:104:0x03ba }] */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02fa A[Catch: Exception -> 0x067d, TryCatch #0 {Exception -> 0x067d, blocks: (B:44:0x01a1, B:47:0x01b3, B:50:0x01c3, B:55:0x021e, B:57:0x0222, B:59:0x0226, B:61:0x0239, B:63:0x0241, B:67:0x0270, B:69:0x0276, B:70:0x027d, B:72:0x0281, B:73:0x02ae, B:75:0x02fa, B:77:0x0300, B:79:0x0310, B:82:0x0316, B:84:0x0330, B:87:0x034f, B:91:0x0357, B:93:0x0362, B:95:0x036c, B:97:0x0377, B:99:0x037f, B:100:0x0395, B:102:0x0399, B:103:0x039e, B:106:0x03bc, B:108:0x03c0, B:109:0x03c6, B:111:0x03d0, B:136:0x03f3, B:138:0x03f9, B:142:0x0409, B:144:0x041a, B:145:0x0439, B:146:0x043e, B:193:0x029c, B:200:0x02c6, B:202:0x01d4), top: B:43:0x01a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x034f A[Catch: Exception -> 0x067d, TryCatch #0 {Exception -> 0x067d, blocks: (B:44:0x01a1, B:47:0x01b3, B:50:0x01c3, B:55:0x021e, B:57:0x0222, B:59:0x0226, B:61:0x0239, B:63:0x0241, B:67:0x0270, B:69:0x0276, B:70:0x027d, B:72:0x0281, B:73:0x02ae, B:75:0x02fa, B:77:0x0300, B:79:0x0310, B:82:0x0316, B:84:0x0330, B:87:0x034f, B:91:0x0357, B:93:0x0362, B:95:0x036c, B:97:0x0377, B:99:0x037f, B:100:0x0395, B:102:0x0399, B:103:0x039e, B:106:0x03bc, B:108:0x03c0, B:109:0x03c6, B:111:0x03d0, B:136:0x03f3, B:138:0x03f9, B:142:0x0409, B:144:0x041a, B:145:0x0439, B:146:0x043e, B:193:0x029c, B:200:0x02c6, B:202:0x01d4), top: B:43:0x01a1 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m9007a(int r42, byte[] r43, java.lang.String r44, int r45) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.C2986d.m9007a(int, byte[], java.lang.String, int):void");
    }

    /* renamed from: a */
    private byte[] m9013a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                return byteArrayOutputStream.toByteArray();
            } finally {
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            ALog.m9182e(this.f9479m, "uncompress data error " + e2.toString(), new Object[0]);
            C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.f9468b + " uncompress data error " + e2.toString());
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return null;
        }
    }

    /* renamed from: a */
    private void m9010a(Message message, byte[] bArr, byte[] bArr2, String str) {
        JSONArray jSONArray;
        int i2 = -8;
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.m9180d(this.f9479m, "handleControlMessage parse", "json", jSONObject.toString());
                }
                i2 = message.command.intValue() == 100 ? 200 : jSONObject.getInt("code");
                if (i2 == 200) {
                    int intValue = message.command.intValue();
                    if (intValue == 1) {
                        UtilityImpl.m9212c(Constants.SP_FILE_NAME, this.f9475i);
                        try {
                            this.f9478l.m9106j().m8982a(this.f9475i.getPackageName());
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            this.f9472f = C3048p.m9259a(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                            if (jSONObject2 != null && (jSONArray = jSONObject2.getJSONArray(Constants.KEY_PACKAGE_NAMES)) != null) {
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    String string = jSONArray.getString(i3);
                                    if (UtilityImpl.m9205a(this.f9475i, string)) {
                                        this.f9478l.m9106j().m8982a(message.f9438m);
                                    } else {
                                        ALog.m9180d(this.f9479m, "unbind app", "pkg", string);
                                        this.f9478l.m9096b(Message.buildUnbindApp(this.f9478l.mo9091b((String) null), string), true);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            ALog.m9183i(this.f9479m, "no token/invalid app", th);
                        }
                    } else if (intValue == 2) {
                        this.f9478l.m9106j().m8984b(message.f9438m);
                    } else if (intValue == 3) {
                        this.f9478l.m9106j().m8983a(message.f9438m, message.userinfo);
                    } else if (intValue != 4) {
                        if (intValue == 100 && (this.f9478l instanceof C3011k) && "4|sal|accs-iot".equals(message.f9434i)) {
                            ((C3011k) this.f9478l).m9132a(jSONObject);
                        }
                    } else {
                        this.f9478l.m9106j().m8988e(message.f9438m);
                    }
                } else if (message.command.intValue() == 3 && i2 == 300) {
                    this.f9478l.m9106j().m8984b(message.f9438m);
                }
            } catch (Throwable th2) {
                th = th2;
                ALog.m9181e(this.f9479m, "handleControlMessage", th, new Object[0]);
                C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.f9468b + th.toString());
                m9027a(message, i2, null, bArr, null);
                m9029a(new TrafficsMonitor.C3032a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
            }
        } catch (Throwable th3) {
            th = th3;
        }
        m9027a(message, i2, null, bArr, null);
        m9029a(new TrafficsMonitor.C3032a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
    }

    /* renamed from: a */
    private Map<Integer, String> m9006a(C3051s c3051s) {
        HashMap hashMap;
        if (c3051s == null) {
            return null;
        }
        try {
            int m9271b = c3051s.m9271b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(this.f9479m, "extHeaderLen:" + m9271b, new Object[0]);
            }
            hashMap = null;
            int i2 = 0;
            while (i2 < m9271b) {
                try {
                    int m9271b2 = c3051s.m9271b();
                    int i3 = (64512 & m9271b2) >> 10;
                    int i4 = m9271b2 & Message.EXT_HEADER_VALUE_MAX_LEN;
                    String m9270a = c3051s.m9270a(i4);
                    i2 = i2 + 2 + i4;
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(Integer.valueOf(i3), m9270a);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.m9180d(this.f9479m, "", "extHeaderType", Integer.valueOf(i3), SurveyH5Bean.VALUE, m9270a);
                    }
                } catch (Exception e2) {
                    e = e2;
                    ALog.m9181e(this.f9479m, "parseExtHeader", e, new Object[0]);
                    return hashMap;
                }
            }
        } catch (Exception e3) {
            e = e3;
            hashMap = null;
        }
        return hashMap;
    }

    /* renamed from: a */
    public void m9026a(Message message, int i2) {
        m9027a(message, i2, null, null, null);
    }

    /* renamed from: a */
    public void m9028a(Message message, int i2, Map<Integer, String> map) {
        m9027a(message, i2, null, null, map);
    }

    /* renamed from: a */
    public void m9027a(Message message, int i2, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        if (message.command != null && message.getType() >= 0 && message.getType() != 2) {
            String str = message.cunstomDataId;
            if (str != null) {
                this.f9467a.remove(str);
            }
            if (this.f9471e.checkAntiBrush(message.host, map)) {
                i2 = ErrorCode.SERVIER_ANTI_BRUSH;
                reqType = null;
                bArr = null;
                map = null;
            }
            int m9055a = this.f9470d.m9055a(map, message.serviceId);
            if (m9055a != 0) {
                i2 = m9055a == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : m9055a == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
                reqType = null;
                bArr = null;
                map = null;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d(this.f9479m, "onResult", "command", message.command, "erorcode", Integer.valueOf(i2));
            }
            if (message.command.intValue() == 102) {
                return;
            }
            if (!message.isCancel) {
                if (m9016b(i2) && message.command.intValue() != 100 && message.retryTimes <= Message.CONTROL_MAX_RETRY_TIMES) {
                    message.startSendTime = System.currentTimeMillis();
                    message.retryTimes++;
                    ALog.m9180d(this.f9479m, "onResult", "retryTimes", Integer.valueOf(message.retryTimes));
                    this.f9478l.m9096b(message, true);
                    m9009a(message, i2, true);
                } else {
                    m9009a(message, i2, false);
                    Intent m9017c = m9017c(message);
                    m9017c.putExtra(Constants.KEY_ERROR_CODE, i2);
                    Message.ReqType valueOf = Message.ReqType.valueOf((message.f9431f >> 13) & 3);
                    if (reqType == Message.ReqType.RES || valueOf == Message.ReqType.REQ) {
                        m9017c.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                    }
                    if (i2 == 200) {
                        m9017c.putExtra("data", bArr);
                    }
                    m9017c.putExtra("appKey", this.f9478l.f9522b);
                    m9017c.putExtra(Constants.KEY_CONFIG_TAG, this.f9478l.f9533m);
                    m9012a(map, m9017c);
                    C2989g.m9041a().m9052b(this.f9475i, m9017c);
                    if (!TextUtils.isEmpty(message.serviceId)) {
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + i2 + " dataId=" + message.dataId, 221);
                        StringBuilder sb = new StringBuilder();
                        sb.append("1commandId=");
                        sb.append(message.command);
                        sb.append("serviceId=");
                        sb.append(message.serviceId);
                        C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                    }
                }
            } else {
                ALog.m9182e(this.f9479m, "onResult message is cancel", "command", message.command);
                m9009a(message, i2, true);
            }
            m9015b(message, i2);
            return;
        }
        ALog.m9180d(this.f9479m, "onError, skip ping/ack", new Object[0]);
    }

    /* renamed from: a */
    private void m9009a(Message message, int i2, boolean z) {
        boolean z2;
        try {
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor == null) {
                return;
            }
            netPermanceMonitor.onToBizDate();
            String url = message.host == null ? null : message.host.toString();
            if (i2 == 200) {
                z2 = true;
                if (message.retryTimes > 0) {
                    C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                    C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                } else {
                    C3043k.m9249a("accs", BaseMonitor.ALARM_POINT_REQUEST, url);
                }
            } else {
                if (message.retryTimes > 0) {
                    C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + i2, 0.0d);
                    C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                } else if (i2 != -13) {
                    C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQUEST, url, UtilityImpl.m9194a(i2), this.f9468b + message.serviceId + message.timeout);
                }
                netPermanceMonitor.setFailReason(i2);
                z2 = false;
            }
            netPermanceMonitor.setRet(z2);
            if (z) {
                if (message.isCancel) {
                    netPermanceMonitor.setRet(false);
                    netPermanceMonitor.setFailReason("msg cancel");
                }
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        } catch (Throwable th) {
            ALog.m9181e(this.f9479m, "monitorPerf", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public void m9023a() {
        ALog.m9180d(this.f9479m, "onSendPing", new Object[0]);
        synchronized (C2986d.class) {
            this.f9474h = true;
        }
    }

    /* renamed from: a */
    public void m9025a(Message message) {
        String str;
        Message message2 = this.f9477k;
        if (message2 != null && (str = message.cunstomDataId) != null && message.serviceId != null && message2.cunstomDataId.equals(str) && this.f9477k.serviceId.equals(message.serviceId)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() == -1 || message.getType() == 2 || message.isAck) {
            return;
        }
        this.f9473g.put(message.getMsgId(), message);
    }

    /* renamed from: a */
    public void m9024a(int i2) {
        this.f9474h = false;
        Message.C2982Id[] c2982IdArr = (Message.C2982Id[]) this.f9473g.keySet().toArray(new Message.C2982Id[0]);
        if (c2982IdArr.length > 0) {
            ALog.m9180d(this.f9479m, "onNetworkFail", new Object[0]);
            for (Message.C2982Id c2982Id : c2982IdArr) {
                Message remove = this.f9473g.remove(c2982Id);
                if (remove != null) {
                    m9026a(remove, i2);
                }
            }
        }
    }

    /* renamed from: a */
    public Message m9022a(String str) {
        return this.f9473g.get(new Message.C2982Id(0, str));
    }

    /* renamed from: a */
    private byte[] m9014a(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int parseInt = Integer.parseInt(map.get(17));
                    int parseInt2 = Integer.parseInt(map.get(16));
                    if (parseInt2 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    }
                    if (parseInt >= 0 && parseInt < parseInt2) {
                        String str2 = map.get(18);
                        long j2 = 0;
                        try {
                            String str3 = map.get(15);
                            if (!TextUtils.isEmpty(str3)) {
                                j2 = Long.parseLong(str3);
                            }
                        } catch (Throwable th) {
                            ALog.m9185w(this.f9479m, "putBurstMessage", th, new Object[0]);
                        }
                        C2983a c2983a = this.f9481o.get(str);
                        if (c2983a == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.m9183i(this.f9479m, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(parseInt2));
                            }
                            c2983a = new C2983a(str, parseInt2, str2);
                            c2983a.m9003a(j2);
                            this.f9481o.put(str, c2983a);
                        }
                        return c2983a.m9004a(parseInt, parseInt2, bArr);
                    }
                    throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(parseInt2), Integer.valueOf(parseInt)));
                }
            } catch (Throwable th2) {
                ALog.m9185w(this.f9479m, "putBurstMessage", th2, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    /* renamed from: a */
    private void m9012a(Map<Integer, String> map, Intent intent) {
        if (map == null || intent == null) {
            return;
        }
        intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
    }

    /* renamed from: a */
    private void m9008a(Intent intent, String str, String str2, short s) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(Constants.KEY_TARGET, str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s);
        }
    }

    /* renamed from: a */
    private void m9011a(String str, String str2) {
        C3030e c3030e = new C3030e();
        c3030e.f9665a = UtilityImpl.m9228j(this.f9475i);
        c3030e.f9667c = str;
        c3030e.f9668d = "" + System.currentTimeMillis();
        c3030e.f9670f = "";
        c3030e.f9669e = str2;
        c3030e.f9666b = "";
        c3030e.m9174a();
    }

    /* renamed from: a */
    public void m9029a(TrafficsMonitor.C3032a c3032a) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new RunnableC2987e(this, c3032a));
        } catch (Throwable th) {
            ALog.m9181e(this.f9479m, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
