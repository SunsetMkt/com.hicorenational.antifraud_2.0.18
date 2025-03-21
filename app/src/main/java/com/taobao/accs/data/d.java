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
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.s;
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
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public int f8451b;

    /* renamed from: c, reason: collision with root package name */
    protected TrafficsMonitor f8452c;

    /* renamed from: d, reason: collision with root package name */
    public FlowControl f8453d;

    /* renamed from: e, reason: collision with root package name */
    public AntiBrush f8454e;

    /* renamed from: i, reason: collision with root package name */
    private Context f8458i;

    /* renamed from: j, reason: collision with root package name */
    private com.taobao.accs.ut.a.d f8459j;

    /* renamed from: k, reason: collision with root package name */
    private Message f8460k;

    /* renamed from: l, reason: collision with root package name */
    private com.taobao.accs.net.a f8461l;

    /* renamed from: m, reason: collision with root package name */
    private String f8462m;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentMap<Message.Id, Message> f8456g = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentMap<String, ScheduledFuture<?>> f8450a = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f8457h = false;

    /* renamed from: f, reason: collision with root package name */
    public String f8455f = "";
    private LinkedHashMap<String, String> n = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };
    private Map<String, a> o = new HashMap();
    private Runnable p = new f(this);

    public d(Context context, com.taobao.accs.net.a aVar) {
        String str;
        this.f8462m = "MsgRecv_";
        this.f8458i = context;
        this.f8461l = aVar;
        this.f8452c = new TrafficsMonitor(this.f8458i);
        this.f8453d = new FlowControl(this.f8458i);
        this.f8454e = new AntiBrush(this.f8458i);
        if (aVar == null) {
            str = this.f8462m;
        } else {
            str = this.f8462m + aVar.f8512m;
        }
        this.f8462m = str;
        i();
        h();
    }

    private boolean b(int i2) {
        return i2 == -1 || i2 == -9 || i2 == -10 || i2 == -11;
    }

    private void i() {
        try {
            File file = new File(this.f8458i.getDir("accs", 0), "message" + this.f8461l.i());
            if (!file.exists()) {
                ALog.d(this.f8462m, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return;
                }
                this.n.put(readLine, readLine);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f8458i.getDir("accs", 0), "message" + this.f8461l.i()));
            fileWriter.write("");
            Iterator<String> it = this.n.keySet().iterator();
            while (it.hasNext()) {
                fileWriter.append((CharSequence) it.next()).append((CharSequence) "\r\n");
            }
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, (String) null);
    }

    public void b() {
        ALog.d(this.f8462m, "onRcvPing", new Object[0]);
        synchronized (d.class) {
            this.f8457h = false;
        }
    }

    public boolean c() {
        return this.f8457h;
    }

    public int d() {
        return this.f8456g.size();
    }

    public Collection<Message> e() {
        return this.f8456g.values();
    }

    public Set<Message.Id> f() {
        return this.f8456g.keySet();
    }

    public com.taobao.accs.ut.a.d g() {
        return this.f8459j;
    }

    public void h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.p);
        } catch (Throwable th) {
            ALog.e(this.f8462m, "restoreTraffics", th, new Object[0]);
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.n.containsKey(str);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str) || this.n.containsKey(str)) {
            return;
        }
        this.n.put(str, str);
        j();
    }

    public void a(byte[] bArr, String str) throws IOException {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.f8462m, "onMessage", Constants.KEY_HOST, str);
        }
        s sVar = new s(bArr);
        try {
            int a2 = sVar.a();
            int i2 = (a2 & 240) >> 4;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f8462m, "version:" + i2, new Object[0]);
            }
            int i3 = a2 & 15;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f8462m, "compress:" + i3, new Object[0]);
            }
            sVar.a();
            int b2 = sVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f8462m, "totalLen:" + b2, new Object[0]);
            }
            int i4 = 0;
            while (i4 < b2) {
                int b3 = sVar.b();
                int i5 = i4 + 2;
                if (b3 <= 0) {
                    throw new IOException("data format error");
                }
                byte[] bArr2 = new byte[b3];
                sVar.read(bArr2);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f8462m, "buf len:" + bArr2.length, new Object[0]);
                }
                i4 = i5 + bArr2.length;
                a(i3, bArr2, str, i2);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.f8434m);
        intent.putExtra("command", message.command);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.serviceId);
        intent.putExtra("userInfo", message.userinfo);
        Integer num = message.command;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        NetPerformanceMonitor netPerformanceMonitor = message.G;
        if (netPerformanceMonitor != null) {
            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
        }
        return intent;
    }

    public void b(Message message) {
        if (this.f8456g.keySet().size() > 0) {
            Iterator<Message.Id> it = this.f8456g.keySet().iterator();
            while (it.hasNext()) {
                Message message2 = this.f8456g.get(it.next());
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
                    ALog.e(this.f8462m, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    public Message b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f8456g.remove(new Message.Id(0, str));
    }

    private void b(Message message, int i2) {
        if (message == null) {
            return;
        }
        String j2 = UtilityImpl.j(this.f8458i);
        String str = System.currentTimeMillis() + "";
        boolean z = i2 == 200;
        int intValue = message.command.intValue();
        if (intValue == 1) {
            com.taobao.accs.ut.a.a aVar = new com.taobao.accs.ut.a.a();
            aVar.f8569a = j2;
            aVar.f8570b = str;
            aVar.f8571c = z;
            aVar.a(i2);
            aVar.a();
            return;
        }
        if (intValue != 3) {
            return;
        }
        com.taobao.accs.ut.a.b bVar = new com.taobao.accs.ut.a.b();
        bVar.f8575a = j2;
        bVar.f8576b = str;
        bVar.f8577c = z;
        bVar.f8579e = message.userinfo;
        bVar.a(i2);
        bVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0633 A[Catch: Exception -> 0x067b, TryCatch #2 {Exception -> 0x067b, blocks: (B:122:0x0623, B:124:0x0633, B:187:0x064e), top: B:104:0x03ba }] */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02fa A[Catch: Exception -> 0x067d, TryCatch #0 {Exception -> 0x067d, blocks: (B:44:0x01a1, B:47:0x01b3, B:50:0x01c3, B:55:0x021e, B:57:0x0222, B:59:0x0226, B:61:0x0239, B:63:0x0241, B:67:0x0270, B:69:0x0276, B:70:0x027d, B:72:0x0281, B:73:0x02ae, B:75:0x02fa, B:77:0x0300, B:79:0x0310, B:82:0x0316, B:84:0x0330, B:87:0x034f, B:91:0x0357, B:93:0x0362, B:95:0x036c, B:97:0x0377, B:99:0x037f, B:100:0x0395, B:102:0x0399, B:103:0x039e, B:106:0x03bc, B:108:0x03c0, B:109:0x03c6, B:111:0x03d0, B:136:0x03f3, B:138:0x03f9, B:142:0x0409, B:144:0x041a, B:145:0x0439, B:146:0x043e, B:193:0x029c, B:200:0x02c6, B:202:0x01d4), top: B:43:0x01a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x034f A[Catch: Exception -> 0x067d, TryCatch #0 {Exception -> 0x067d, blocks: (B:44:0x01a1, B:47:0x01b3, B:50:0x01c3, B:55:0x021e, B:57:0x0222, B:59:0x0226, B:61:0x0239, B:63:0x0241, B:67:0x0270, B:69:0x0276, B:70:0x027d, B:72:0x0281, B:73:0x02ae, B:75:0x02fa, B:77:0x0300, B:79:0x0310, B:82:0x0316, B:84:0x0330, B:87:0x034f, B:91:0x0357, B:93:0x0362, B:95:0x036c, B:97:0x0377, B:99:0x037f, B:100:0x0395, B:102:0x0399, B:103:0x039e, B:106:0x03bc, B:108:0x03c0, B:109:0x03c6, B:111:0x03d0, B:136:0x03f3, B:138:0x03f9, B:142:0x0409, B:144:0x041a, B:145:0x0439, B:146:0x043e, B:193:0x029c, B:200:0x02c6, B:202:0x01d4), top: B:43:0x01a1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r42, byte[] r43, java.lang.String r44, int r45) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.d.a(int, byte[], java.lang.String, int):void");
    }

    private byte[] a(InputStream inputStream) throws IOException {
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
            ALog.e(this.f8462m, "uncompress data error " + e2.toString(), new Object[0]);
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.f8451b + " uncompress data error " + e2.toString());
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return null;
        }
    }

    private void a(Message message, byte[] bArr, byte[] bArr2, String str) {
        JSONArray jSONArray;
        int i2 = -8;
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f8462m, "handleControlMessage parse", "json", jSONObject.toString());
                }
                i2 = message.command.intValue() == 100 ? 200 : jSONObject.getInt("code");
                if (i2 == 200) {
                    int intValue = message.command.intValue();
                    if (intValue == 1) {
                        UtilityImpl.c(Constants.SP_FILE_NAME, this.f8458i);
                        try {
                            this.f8461l.j().a(this.f8458i.getPackageName());
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            this.f8455f = p.a(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                            if (jSONObject2 != null && (jSONArray = jSONObject2.getJSONArray(Constants.KEY_PACKAGE_NAMES)) != null) {
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    String string = jSONArray.getString(i3);
                                    if (UtilityImpl.a(this.f8458i, string)) {
                                        this.f8461l.j().a(message.f8434m);
                                    } else {
                                        ALog.d(this.f8462m, "unbind app", "pkg", string);
                                        this.f8461l.b(Message.buildUnbindApp(this.f8461l.b((String) null), string), true);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            ALog.i(this.f8462m, "no token/invalid app", th);
                        }
                    } else if (intValue == 2) {
                        this.f8461l.j().b(message.f8434m);
                    } else if (intValue == 3) {
                        this.f8461l.j().a(message.f8434m, message.userinfo);
                    } else if (intValue != 4) {
                        if (intValue == 100 && (this.f8461l instanceof com.taobao.accs.net.k) && "4|sal|accs-iot".equals(message.f8430i)) {
                            ((com.taobao.accs.net.k) this.f8461l).a(jSONObject);
                        }
                    } else {
                        this.f8461l.j().e(message.f8434m);
                    }
                } else if (message.command.intValue() == 3 && i2 == 300) {
                    this.f8461l.j().b(message.f8434m);
                }
            } catch (Throwable th2) {
                th = th2;
                ALog.e(this.f8462m, "handleControlMessage", th, new Object[0]);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.f8451b + th.toString());
                a(message, i2, null, bArr, null);
                a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
            }
        } catch (Throwable th3) {
            th = th3;
        }
        a(message, i2, null, bArr, null);
        a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
    }

    private Map<Integer, String> a(s sVar) {
        HashMap hashMap;
        if (sVar == null) {
            return null;
        }
        try {
            int b2 = sVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f8462m, "extHeaderLen:" + b2, new Object[0]);
            }
            hashMap = null;
            int i2 = 0;
            while (i2 < b2) {
                try {
                    int b3 = sVar.b();
                    int i3 = (64512 & b3) >> 10;
                    int i4 = b3 & Message.EXT_HEADER_VALUE_MAX_LEN;
                    String a2 = sVar.a(i4);
                    i2 = i2 + 2 + i4;
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(Integer.valueOf(i3), a2);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.d(this.f8462m, "", "extHeaderType", Integer.valueOf(i3), SurveyH5Bean.VALUE, a2);
                    }
                } catch (Exception e2) {
                    e = e2;
                    ALog.e(this.f8462m, "parseExtHeader", e, new Object[0]);
                    return hashMap;
                }
            }
        } catch (Exception e3) {
            e = e3;
            hashMap = null;
        }
        return hashMap;
    }

    public void a(Message message, int i2) {
        a(message, i2, null, null, null);
    }

    public void a(Message message, int i2, Map<Integer, String> map) {
        a(message, i2, null, null, map);
    }

    public void a(Message message, int i2, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        if (message.command != null && message.getType() >= 0 && message.getType() != 2) {
            String str = message.cunstomDataId;
            if (str != null) {
                this.f8450a.remove(str);
            }
            if (this.f8454e.checkAntiBrush(message.host, map)) {
                i2 = ErrorCode.SERVIER_ANTI_BRUSH;
                reqType = null;
                bArr = null;
                map = null;
            }
            int a2 = this.f8453d.a(map, message.serviceId);
            if (a2 != 0) {
                i2 = a2 == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : a2 == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
                reqType = null;
                bArr = null;
                map = null;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f8462m, "onResult", "command", message.command, "erorcode", Integer.valueOf(i2));
            }
            if (message.command.intValue() == 102) {
                return;
            }
            if (!message.isCancel) {
                if (b(i2) && message.command.intValue() != 100 && message.retryTimes <= Message.CONTROL_MAX_RETRY_TIMES) {
                    message.startSendTime = System.currentTimeMillis();
                    message.retryTimes++;
                    ALog.d(this.f8462m, "onResult", "retryTimes", Integer.valueOf(message.retryTimes));
                    this.f8461l.b(message, true);
                    a(message, i2, true);
                } else {
                    a(message, i2, false);
                    Intent c2 = c(message);
                    c2.putExtra(Constants.KEY_ERROR_CODE, i2);
                    Message.ReqType valueOf = Message.ReqType.valueOf((message.f8427f >> 13) & 3);
                    if (reqType == Message.ReqType.RES || valueOf == Message.ReqType.REQ) {
                        c2.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                    }
                    if (i2 == 200) {
                        c2.putExtra("data", bArr);
                    }
                    c2.putExtra("appKey", this.f8461l.f8501b);
                    c2.putExtra(Constants.KEY_CONFIG_TAG, this.f8461l.f8512m);
                    a(map, c2);
                    g.a().b(this.f8458i, c2);
                    if (!TextUtils.isEmpty(message.serviceId)) {
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + i2 + " dataId=" + message.dataId, 221);
                        StringBuilder sb = new StringBuilder();
                        sb.append("1commandId=");
                        sb.append(message.command);
                        sb.append("serviceId=");
                        sb.append(message.serviceId);
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                    }
                }
            } else {
                ALog.e(this.f8462m, "onResult message is cancel", "command", message.command);
                a(message, i2, true);
            }
            b(message, i2);
            return;
        }
        ALog.d(this.f8462m, "onError, skip ping/ack", new Object[0]);
    }

    private void a(Message message, int i2, boolean z) {
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
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                } else {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, url);
                }
            } else {
                if (message.retryTimes > 0) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + i2, 0.0d);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                } else if (i2 != -13) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, url, UtilityImpl.a(i2), this.f8451b + message.serviceId + message.timeout);
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
            ALog.e(this.f8462m, "monitorPerf", th, new Object[0]);
        }
    }

    public void a() {
        ALog.d(this.f8462m, "onSendPing", new Object[0]);
        synchronized (d.class) {
            this.f8457h = true;
        }
    }

    public void a(Message message) {
        String str;
        Message message2 = this.f8460k;
        if (message2 != null && (str = message.cunstomDataId) != null && message.serviceId != null && message2.cunstomDataId.equals(str) && this.f8460k.serviceId.equals(message.serviceId)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() == -1 || message.getType() == 2 || message.isAck) {
            return;
        }
        this.f8456g.put(message.getMsgId(), message);
    }

    public void a(int i2) {
        this.f8457h = false;
        Message.Id[] idArr = (Message.Id[]) this.f8456g.keySet().toArray(new Message.Id[0]);
        if (idArr.length > 0) {
            ALog.d(this.f8462m, "onNetworkFail", new Object[0]);
            for (Message.Id id : idArr) {
                Message remove = this.f8456g.remove(id);
                if (remove != null) {
                    a(remove, i2);
                }
            }
        }
    }

    public Message a(String str) {
        return this.f8456g.get(new Message.Id(0, str));
    }

    private byte[] a(String str, Map<Integer, String> map, byte[] bArr) {
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
                            ALog.w(this.f8462m, "putBurstMessage", th, new Object[0]);
                        }
                        a aVar = this.o.get(str);
                        if (aVar == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.f8462m, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(parseInt2));
                            }
                            aVar = new a(str, parseInt2, str2);
                            aVar.a(j2);
                            this.o.put(str, aVar);
                        }
                        return aVar.a(parseInt, parseInt2, bArr);
                    }
                    throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(parseInt2), Integer.valueOf(parseInt)));
                }
            } catch (Throwable th2) {
                ALog.w(this.f8462m, "putBurstMessage", th2, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void a(Map<Integer, String> map, Intent intent) {
        if (map == null || intent == null) {
            return;
        }
        intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
    }

    private void a(Intent intent, String str, String str2, short s) {
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

    private void a(String str, String str2) {
        com.taobao.accs.ut.a.e eVar = new com.taobao.accs.ut.a.e();
        eVar.f8604a = UtilityImpl.j(this.f8458i);
        eVar.f8606c = str;
        eVar.f8607d = "" + System.currentTimeMillis();
        eVar.f8609f = "";
        eVar.f8608e = str2;
        eVar.f8605b = "";
        eVar.a();
    }

    public void a(TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(this, aVar));
        } catch (Throwable th) {
            ALog.e(this.f8462m, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
