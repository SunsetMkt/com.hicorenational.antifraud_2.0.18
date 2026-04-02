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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected TrafficsMonitor f5765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlowControl f5766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AntiBrush f5767e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f5771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.taobao.accs.ut.a.d f5772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Message f5773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.taobao.accs.net.a f5774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f5775m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentMap<Message.Id, Message> f5769g = new ConcurrentHashMap();
    public ConcurrentMap<String, ScheduledFuture<?>> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5770h = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5768f = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LinkedHashMap<String, String> f5776n = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };
    private Map<String, a> o = new HashMap();
    private Runnable p = new f(this);

    public d(Context context, com.taobao.accs.net.a aVar) {
        String str;
        this.f5775m = "MsgRecv_";
        this.f5771i = context;
        this.f5774l = aVar;
        this.f5765c = new TrafficsMonitor(this.f5771i);
        this.f5766d = new FlowControl(this.f5771i);
        this.f5767e = new AntiBrush(this.f5771i);
        if (aVar == null) {
            str = this.f5775m;
        } else {
            str = this.f5775m + aVar.f5810m;
        }
        this.f5775m = str;
        i();
        h();
    }

    private boolean b(int i2) {
        return i2 == -1 || i2 == -9 || i2 == -10 || i2 == -11;
    }

    private void i() {
        try {
            File file = new File(this.f5771i.getDir("accs", 0), "message" + this.f5774l.i());
            if (!file.exists()) {
                ALog.d(this.f5775m, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                this.f5776n.put(line, line);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f5771i.getDir("accs", 0), "message" + this.f5774l.i()));
            fileWriter.write("");
            Iterator<String> it = this.f5776n.keySet().iterator();
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
        ALog.d(this.f5775m, "onRcvPing", new Object[0]);
        synchronized (d.class) {
            this.f5770h = false;
        }
    }

    public boolean c() {
        return this.f5770h;
    }

    public int d() {
        return this.f5769g.size();
    }

    public Collection<Message> e() {
        return this.f5769g.values();
    }

    public Set<Message.Id> f() {
        return this.f5769g.keySet();
    }

    public com.taobao.accs.ut.a.d g() {
        return this.f5772j;
    }

    public void h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.p);
        } catch (Throwable th) {
            ALog.e(this.f5775m, "restoreTraffics", th, new Object[0]);
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f5776n.containsKey(str);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str) || this.f5776n.containsKey(str)) {
            return;
        }
        this.f5776n.put(str, str);
        j();
    }

    public void a(byte[] bArr, String str) throws IOException {
        int i2;
        int i3;
        int iB;
        int length;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.f5775m, "onMessage", Constants.KEY_HOST, str);
        }
        s sVar = new s(bArr);
        try {
            int iA = sVar.a();
            i2 = (iA & 240) >> 4;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f5775m, "version:" + i2, new Object[0]);
            }
            i3 = iA & 15;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f5775m, "compress:" + i3, new Object[0]);
            }
            sVar.a();
            iB = sVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f5775m, "totalLen:" + iB, new Object[0]);
            }
            length = 0;
        } finally {
            try {
            } finally {
            }
        }
        while (length < iB) {
            int iB2 = sVar.b();
            int i4 = length + 2;
            if (iB2 <= 0) {
                throw new IOException("data format error");
            }
            byte[] bArr2 = new byte[iB2];
            sVar.read(bArr2);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f5775m, "buf len:" + bArr2.length, new Object[0]);
            }
            length = i4 + bArr2.length;
            a(i3, bArr2, str, i2);
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.f5753m);
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
        if (this.f5769g.keySet().size() > 0) {
            Iterator<Message.Id> it = this.f5769g.keySet().iterator();
            while (it.hasNext()) {
                Message message2 = this.f5769g.get(it.next());
                if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                            }
                            break;
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                            }
                            break;
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                            }
                            break;
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.e(this.f5775m, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    public Message b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f5769g.remove(new Message.Id(0, str));
    }

    private void b(Message message, int i2) {
        if (message == null) {
            return;
        }
        String strJ = UtilityImpl.j(this.f5771i);
        String str = System.currentTimeMillis() + "";
        boolean z = i2 == 200;
        int iIntValue = message.command.intValue();
        if (iIntValue == 1) {
            com.taobao.accs.ut.a.a aVar = new com.taobao.accs.ut.a.a();
            aVar.a = strJ;
            aVar.f5845b = str;
            aVar.f5846c = z;
            aVar.a(i2);
            aVar.a();
            return;
        }
        if (iIntValue != 3) {
            return;
        }
        com.taobao.accs.ut.a.b bVar = new com.taobao.accs.ut.a.b();
        bVar.a = strJ;
        bVar.f5850b = str;
        bVar.f5851c = z;
        bVar.f5853e = message.userinfo;
        bVar.a(i2);
        bVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.taobao.accs.data.d] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private void a(int i2, byte[] bArr, String str, int i3) throws JSONException, IOException {
        String str2;
        Map<Integer, String> map;
        byte[] bArr2;
        boolean z;
        ?? r5;
        String str3;
        String str4;
        Map<Integer, String> map2;
        String str5;
        boolean z2;
        int i4;
        int i5;
        byte[] bArr3;
        Message.ReqType reqType;
        String str6;
        int i6;
        String str7;
        Map<Integer, String> map3;
        Object obj;
        ?? r52;
        Message.ReqType reqType2;
        byte[] bArr4;
        ?? r53;
        Message.ReqType reqType3;
        byte[] bArrA;
        String str8;
        String str9;
        long j2;
        String str10;
        String str11;
        Map<Integer, String> map4;
        long j3;
        String str12;
        int i7;
        Message.ReqType reqType4;
        String str13;
        boolean z3;
        Map<Integer, String> map5;
        byte[] bArrC;
        s sVar = new s(bArr);
        long jB = sVar.b();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.f5775m, "flag:" + Integer.toHexString((int) jB), new Object[0]);
        }
        String strA = sVar.a(sVar.a());
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.f5775m, "target:" + strA, new Object[0]);
        }
        String strA2 = sVar.a(sVar.a());
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.f5775m, "source:" + strA2, new Object[0]);
        }
        try {
            String strA3 = sVar.a(sVar.a());
            if (ALog.isPrintLog(ALog.Level.D)) {
                str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                ALog.d(this.f5775m, "dataId:" + strA3, new Object[0]);
            } else {
                str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
            }
            if (!strA2.contains(Constants.TARGET_SERVICE_ST) && !strA2.contains(Constants.TARGET_FORE) && !strA2.contains(Constants.TARGET_BACK)) {
                String str14 = strA2 + strA3;
                if (sVar.available() > 0) {
                    if (i3 == 2) {
                        Map<Integer, String> mapA = a(sVar);
                        if (mapA != null && mapA.containsKey(16) && mapA.containsKey(17)) {
                            map5 = mapA;
                            z3 = true;
                        } else {
                            map5 = mapA;
                            z3 = false;
                        }
                    } else {
                        z3 = false;
                        map5 = null;
                    }
                    if (i2 == 0 || z3) {
                        bArrC = sVar.c();
                    } else if (i2 == 1) {
                        bArrC = a(sVar);
                    } else {
                        z = z3;
                        map = map5;
                        bArr2 = null;
                    }
                    byte[] bArr5 = bArrC;
                    z = z3;
                    map = map5;
                    bArr2 = bArr5;
                } else {
                    map = null;
                    bArr2 = null;
                    z = false;
                }
                sVar.close();
                try {
                    if (bArr2 == null) {
                        map2 = map;
                        str5 = strA2;
                        ALog.d(this.f5775m, "oriData is null", new Object[0]);
                    } else {
                        map2 = map;
                        str5 = strA2;
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(this.f5775m, "oriData:" + String.valueOf(bArr2), new Object[0]);
                        }
                    }
                    int iValueOf = Message.MsgType.valueOf((int) ((jB >> 15) & 1));
                    Message.ReqType reqTypeValueOf = Message.ReqType.valueOf((int) ((jB >> 13) & 3));
                    int i8 = (int) ((jB >> 12) & 1);
                    try {
                        int iValueOf2 = Message.MsgResType.valueOf((int) ((jB >> 11) & 1));
                        boolean z4 = ((int) ((jB >> 6) & 1)) == 1;
                        if (ALog.isPrintLog(ALog.Level.I) || strA.contains("accs-impaas")) {
                            z2 = z4;
                            ALog.e(this.f5775m, "handleMessage", Constants.KEY_DATA_ID, strA3, "type", Message.MsgType.name(iValueOf), "reqType", reqTypeValueOf.name(), "resType", Message.MsgResType.name(iValueOf2), Constants.KEY_TARGET, strA);
                            i4 = iValueOf;
                            i5 = 1;
                        } else {
                            z2 = z4;
                            i4 = iValueOf;
                            i5 = 1;
                        }
                        if (i4 == i5 && (reqTypeValueOf == Message.ReqType.ACK || reqTypeValueOf == Message.ReqType.RES)) {
                            Message messageRemove = this.f5769g.remove(new Message.Id(0, strA3));
                            if (messageRemove != null) {
                                if (ALog.isPrintLog(ALog.Level.D)) {
                                    str12 = strA3;
                                    i6 = iValueOf2;
                                    ALog.d(this.f5775m, "handleMessage reqMessage not null", new Object[0]);
                                } else {
                                    str12 = strA3;
                                    i6 = iValueOf2;
                                }
                                if (i8 == 1) {
                                    try {
                                        i7 = new JSONObject(new String(bArr2)).getInt("code");
                                    } catch (Exception unused) {
                                        i7 = -3;
                                    }
                                } else {
                                    i7 = 200;
                                }
                                if (messageRemove.getNetPermanceMonitor() != null) {
                                    messageRemove.getNetPermanceMonitor().onRecAck();
                                }
                                if (reqTypeValueOf == Message.ReqType.RES) {
                                    map3 = map2;
                                    byte[] bArr6 = bArr2;
                                    obj = Constants.KEY_TARGET;
                                    str13 = str12;
                                    reqType4 = reqTypeValueOf;
                                    str7 = str5;
                                    bArr3 = bArr6;
                                    str6 = strA;
                                    a(messageRemove, i7, reqTypeValueOf, bArr6, map3);
                                } else {
                                    map3 = map2;
                                    bArr3 = bArr2;
                                    reqType4 = reqTypeValueOf;
                                    obj = Constants.KEY_TARGET;
                                    str7 = str5;
                                    str6 = strA;
                                    str13 = str12;
                                    a(messageRemove, i7, map3);
                                }
                                String str15 = messageRemove.serviceId;
                                boolean zIsAppBackground = GlobalAppRuntimeInfo.isAppBackground();
                                long length = bArr.length;
                                a(new TrafficsMonitor.a(str15, zIsAppBackground, str, length));
                                str3 = str13;
                                r52 = length;
                                reqType = reqType4;
                            } else {
                                bArr3 = bArr2;
                                reqType = reqTypeValueOf;
                                i6 = iValueOf2;
                                str7 = str5;
                                str6 = strA;
                                map3 = map2;
                                obj = Constants.KEY_TARGET;
                                str3 = strA3;
                                ALog.e(this.f5775m, "handleMessage data ack/res reqMessage is null", Constants.KEY_DATA_ID, str3);
                                r52 = reqTypeValueOf;
                            }
                        } else {
                            bArr3 = bArr2;
                            reqType = reqTypeValueOf;
                            str6 = strA;
                            i6 = iValueOf2;
                            str7 = str5;
                            map3 = map2;
                            str3 = strA3;
                            obj = Constants.KEY_TARGET;
                            r52 = reqTypeValueOf;
                        }
                        if (i4 == 0) {
                            Message.ReqType reqType5 = reqType;
                            reqType2 = reqType5;
                            if (reqType5 == Message.ReqType.RES) {
                                Message messageRemove2 = this.f5769g.remove(new Message.Id(0, str3));
                                if (messageRemove2 != null) {
                                    a(messageRemove2, bArr3, bArr, str);
                                    return;
                                }
                                bArr4 = bArr3;
                                String str16 = this.f5775m;
                                Object[] objArr = {Constants.KEY_DATA_ID, str3};
                                ALog.e(str16, "handleMessage contorl ACK reqMessage is null", objArr);
                                reqType3 = reqType5;
                                r53 = objArr;
                                if (ALog.isPrintLog(ALog.Level.D)) {
                                    String str17 = this.f5775m;
                                    Object[] objArr2 = {"body", new String(bArr4)};
                                    ALog.d(str17, "handleMessage not handled", objArr2);
                                    reqType3 = reqType5;
                                    r53 = objArr2;
                                }
                            }
                            if (i4 == 1 || reqType3 != Message.ReqType.DATA) {
                            }
                            String str18 = str6;
                            if (str18 == null) {
                                ALog.e(this.f5775m, "handleMessage target is null", new Object[0]);
                                return;
                            }
                            String[] strArrSplit = str18.split("\\|");
                            if (strArrSplit.length < 2) {
                                ALog.e(this.f5775m, "handleMessage target length is invalid", new Object[0]);
                                return;
                            }
                            r5 = r53;
                            if (ALog.isPrintLog(ALog.Level.D)) {
                                String str19 = this.f5775m;
                                Object[] objArr3 = {"isBurstData", Boolean.valueOf(z)};
                                ALog.d(str19, "handleMessage onPush", objArr3);
                                r5 = objArr3;
                            }
                            if (this.f5772j != null) {
                                this.f5772j.a();
                            }
                            this.f5772j = new com.taobao.accs.ut.a.d();
                            this.f5772j.f5867c = String.valueOf(System.currentTimeMillis());
                            Context context = this.f5771i;
                            str4 = strArrSplit[1];
                            try {
                                if (UtilityImpl.a(context, str4)) {
                                    String str20 = strArrSplit.length >= 3 ? strArrSplit[2] : null;
                                    this.f5772j.f5869e = str20;
                                    if (c(str14)) {
                                        ALog.e(this.f5775m, "handleMessage msg duplicate", Constants.KEY_DATA_ID, str3);
                                        this.f5772j.f5872h = true;
                                        map4 = map3;
                                        j3 = jB;
                                        str11 = "";
                                        str8 = "accs";
                                    } else {
                                        if (z) {
                                            bArrA = a(str14, map3, bArr4);
                                            if (bArrA == null) {
                                                ALog.e(this.f5775m, "handleMessage completeOriData is null", new Object[0]);
                                                return;
                                            } else if (i2 == 1) {
                                                s sVar2 = new s(bArrA);
                                                bArrA = a(sVar2);
                                                if (ALog.isPrintLog(ALog.Level.D)) {
                                                    ALog.d(this.f5775m, "handleMessage gzip completeOriData", Constants.KEY_DATA_ID, str14, "length", Integer.valueOf(bArrA.length));
                                                }
                                                sVar2.close();
                                            }
                                        } else {
                                            bArrA = bArr4;
                                        }
                                        d(str14);
                                        str8 = "accs";
                                        try {
                                            if (str8.equals(str20)) {
                                                ALog.e(this.f5775m, "handleMessage try deliverMsg", Constants.KEY_DATA_ID, str3, obj, strArrSplit[1], Constants.KEY_SERVICE_ID, str20);
                                            } else if (ALog.isPrintLog(ALog.Level.I)) {
                                                ALog.i(this.f5775m, "handleMessage try deliverMsg", Constants.KEY_DATA_ID, str3, obj, strArrSplit[1], Constants.KEY_SERVICE_ID, str20);
                                            }
                                            Intent intent = new Intent(Constants.ACTION_RECEIVE);
                                            intent.setPackage(strArrSplit[1]);
                                            intent.putExtra("command", 101);
                                            if (strArrSplit.length >= 3) {
                                                intent.putExtra(Constants.KEY_SERVICE_ID, strArrSplit[2]);
                                            }
                                            if (strArrSplit.length >= 4) {
                                                str9 = strArrSplit[3];
                                                intent.putExtra("userInfo", str9);
                                            } else {
                                                str9 = "";
                                            }
                                            intent.putExtra("data", bArrA);
                                            intent.putExtra(Constants.KEY_DATA_ID, str3);
                                            intent.putExtra(Constants.KEY_PACKAGE_NAME, this.f5771i.getPackageName());
                                            intent.putExtra(Constants.KEY_HOST, str);
                                            intent.putExtra(Constants.KEY_CONN_TYPE, this.f5764b);
                                            boolean z5 = z2;
                                            intent.putExtra(Constants.KEY_NEED_BUSINESS_ACK, z5);
                                            intent.putExtra("appKey", this.f5774l.i());
                                            intent.putExtra(Constants.KEY_CONFIG_TAG, this.f5774l.f5810m);
                                            NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
                                            netPerformanceMonitor.setMsgType(4);
                                            netPerformanceMonitor.onReceiveData();
                                            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
                                            a(map3, intent);
                                            if (z5) {
                                                j2 = jB;
                                                z2 = z5;
                                                str10 = str7;
                                                a(intent, str10, str18, (short) j2);
                                            } else {
                                                z2 = z5;
                                                j2 = jB;
                                                str10 = str7;
                                            }
                                            long j4 = j2;
                                            g.a().b(this.f5771i, intent);
                                            UTMini.getInstance().commitEvent(66001, "MsgToBussPush", "commandId=101", "serviceId=" + str20 + " dataId=" + str3, 221);
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("1commandId=101serviceId=");
                                            sb.append(str20);
                                            com.taobao.accs.utl.k.a(str8, BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                                            this.f5772j.f5866b = str3;
                                            this.f5772j.f5873i = str9;
                                            com.taobao.accs.ut.a.d dVar = this.f5772j;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(bArrA == null ? 0 : bArrA.length);
                                            try {
                                                sb2.append("");
                                                dVar.f5870f = sb2.toString();
                                                this.f5772j.a = UtilityImpl.j(this.f5771i);
                                                this.f5772j.f5868d = String.valueOf(System.currentTimeMillis());
                                                str11 = "";
                                                str7 = str10;
                                                map4 = map3;
                                                j3 = j4;
                                            } catch (Exception e2) {
                                                e = e2;
                                                str3 = "";
                                                r5 = str8;
                                                str4 = str2;
                                                ALog.e(this.f5775m, "handleMessage", e, new Object[0]);
                                                com.taobao.accs.utl.k.a(r5, str4, str3, "1", this.f5764b + e.toString());
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            r5 = str8;
                                            str4 = str2;
                                            str3 = "";
                                            ALog.e(this.f5775m, "handleMessage", e, new Object[0]);
                                            com.taobao.accs.utl.k.a(r5, str4, str3, "1", this.f5764b + e.toString());
                                            return;
                                        }
                                        try {
                                            a(new TrafficsMonitor.a(str20, GlobalAppRuntimeInfo.isAppBackground(), str, bArr.length));
                                        } catch (Exception e4) {
                                            e = e4;
                                            r5 = str8;
                                            str4 = str2;
                                            str3 = str11;
                                            ALog.e(this.f5775m, "handleMessage", e, new Object[0]);
                                            com.taobao.accs.utl.k.a(r5, str4, str3, "1", this.f5764b + e.toString());
                                            return;
                                        }
                                    }
                                    if (i6 != 1) {
                                        return;
                                    }
                                    if (!str8.equals(str20) && !"accs-impaas".equals(str20)) {
                                        ALog.i(this.f5775m, "handleMessage try sendAck dataId", Constants.KEY_DATA_ID, str3);
                                    } else {
                                        ALog.e(this.f5775m, "handleMessage try sendAck dataId", Constants.KEY_DATA_ID, str3);
                                    }
                                    boolean z6 = z2;
                                    String str21 = str8;
                                    String str22 = str3;
                                    str3 = str11;
                                    String str23 = str20;
                                    str4 = str2;
                                    Message messageBuildPushAck = Message.buildPushAck(this.f5774l.b((String) null), this.f5774l.d(), str18, str7, str22, false, (short) j3, str, map4);
                                    this.f5774l.b(messageBuildPushAck, true);
                                    a(messageBuildPushAck.dataId, str23);
                                    r5 = str21;
                                    if (z6) {
                                        com.taobao.accs.utl.k.a(str21, BaseMonitor.COUNT_ACK, str3, 0.0d);
                                        r5 = str21;
                                    }
                                } else {
                                    str4 = str2;
                                    str3 = "";
                                    r5 = "accs";
                                    ALog.e(this.f5775m, "handleMessage not exist, unbind it", "package", strArrSplit[1]);
                                    this.f5774l.b(Message.buildUnbindApp(this.f5774l.b((String) null), strArrSplit[1]), true);
                                }
                                return;
                            } catch (Exception e5) {
                                e = e5;
                            }
                        } else {
                            reqType2 = reqType;
                        }
                        bArr4 = bArr3;
                        reqType3 = reqType2;
                        r53 = r52;
                        if (i4 == 1) {
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str4 = str2;
                        str3 = "";
                        r5 = "accs";
                    }
                } catch (Exception e7) {
                    e = e7;
                    r5 = "accs";
                    str3 = "";
                }
            } else {
                ALog.e(this.f5775m, "ignore source 4|sal|sg/fg/bg message dataId:" + strA3, new Object[0]);
                this.f5769g.remove(new Message.Id(0, strA3));
            }
        } catch (Exception e8) {
            ALog.e(this.f5775m, "dataId read error " + e8.toString(), new Object[0]);
            sVar.close();
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.f5764b + "data id read error" + e8.toString());
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr;
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                bArr = new byte[8192];
            } finally {
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
            }
            while (true) {
                int i2 = gZIPInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            ALog.e(this.f5775m, "uncompress data error " + e2.toString(), new Object[0]);
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.f5764b + " uncompress data error " + e2.toString());
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
                    ALog.d(this.f5775m, "handleControlMessage parse", "json", jSONObject.toString());
                }
                i2 = message.command.intValue() == 100 ? 200 : jSONObject.getInt("code");
                if (i2 == 200) {
                    int iIntValue = message.command.intValue();
                    if (iIntValue == 1) {
                        UtilityImpl.c(Constants.SP_FILE_NAME, this.f5771i);
                        try {
                            this.f5774l.j().a(this.f5771i.getPackageName());
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            this.f5768f = p.a(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                            if (jSONObject2 != null && (jSONArray = jSONObject2.getJSONArray(Constants.KEY_PACKAGE_NAMES)) != null) {
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    String string = jSONArray.getString(i3);
                                    if (UtilityImpl.a(this.f5771i, string)) {
                                        this.f5774l.j().a(message.f5753m);
                                    } else {
                                        ALog.d(this.f5775m, "unbind app", "pkg", string);
                                        this.f5774l.b(Message.buildUnbindApp(this.f5774l.b((String) null), string), true);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            ALog.i(this.f5775m, "no token/invalid app", th);
                        }
                    } else if (iIntValue == 2) {
                        this.f5774l.j().b(message.f5753m);
                    } else if (iIntValue == 3) {
                        this.f5774l.j().a(message.f5753m, message.userinfo);
                    } else if (iIntValue != 4) {
                        if (iIntValue == 100 && (this.f5774l instanceof com.taobao.accs.net.k) && "4|sal|accs-iot".equals(message.f5749i)) {
                            ((com.taobao.accs.net.k) this.f5774l).a(jSONObject);
                        }
                    } else {
                        this.f5774l.j().e(message.f5753m);
                    }
                } else if (message.command.intValue() == 3 && i2 == 300) {
                    this.f5774l.j().b(message.f5753m);
                }
            } catch (Throwable th2) {
                th = th2;
                ALog.e(this.f5775m, "handleControlMessage", th, new Object[0]);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.f5764b + th.toString());
            }
        } catch (Throwable th3) {
            th = th3;
        }
        a(message, i2, null, bArr, null);
        a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
    }

    private Map<Integer, String> a(s sVar) {
        HashMap map;
        if (sVar == null) {
            return null;
        }
        try {
            int iB = sVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f5775m, "extHeaderLen:" + iB, new Object[0]);
            }
            map = null;
            int i2 = 0;
            while (i2 < iB) {
                try {
                    int iB2 = sVar.b();
                    int i3 = (64512 & iB2) >> 10;
                    int i4 = iB2 & 1023;
                    String strA = sVar.a(i4);
                    i2 = i2 + 2 + i4;
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(Integer.valueOf(i3), strA);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.d(this.f5775m, "", "extHeaderType", Integer.valueOf(i3), SurveyH5Bean.VALUE, strA);
                    }
                } catch (Exception e2) {
                    e = e2;
                    ALog.e(this.f5775m, "parseExtHeader", e, new Object[0]);
                    return map;
                }
            }
        } catch (Exception e3) {
            e = e3;
            map = null;
        }
        return map;
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
                this.a.remove(str);
            }
            if (this.f5767e.checkAntiBrush(message.host, map)) {
                i2 = ErrorCode.SERVIER_ANTI_BRUSH;
                reqType = null;
                bArr = null;
                map = null;
            }
            int iA = this.f5766d.a(map, message.serviceId);
            if (iA != 0) {
                i2 = iA == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : iA == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
                reqType = null;
                bArr = null;
                map = null;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f5775m, "onResult", "command", message.command, "erorcode", Integer.valueOf(i2));
            }
            if (message.command.intValue() == 102) {
                return;
            }
            if (!message.isCancel) {
                if (b(i2) && message.command.intValue() != 100 && message.retryTimes <= Message.CONTROL_MAX_RETRY_TIMES) {
                    message.startSendTime = System.currentTimeMillis();
                    message.retryTimes++;
                    ALog.d(this.f5775m, "onResult", "retryTimes", Integer.valueOf(message.retryTimes));
                    this.f5774l.b(message, true);
                    a(message, i2, true);
                } else {
                    a(message, i2, false);
                    Intent intentC = c(message);
                    intentC.putExtra(Constants.KEY_ERROR_CODE, i2);
                    Message.ReqType reqTypeValueOf = Message.ReqType.valueOf((message.f5746f >> 13) & 3);
                    if (reqType == Message.ReqType.RES || reqTypeValueOf == Message.ReqType.REQ) {
                        intentC.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                    }
                    if (i2 == 200) {
                        intentC.putExtra("data", bArr);
                    }
                    intentC.putExtra("appKey", this.f5774l.f5799b);
                    intentC.putExtra(Constants.KEY_CONFIG_TAG, this.f5774l.f5810m);
                    a(map, intentC);
                    g.a().b(this.f5771i, intentC);
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
                ALog.e(this.f5775m, "onResult message is cancel", "command", message.command);
                a(message, i2, true);
            }
            b(message, i2);
            return;
        }
        ALog.d(this.f5775m, "onError, skip ping/ack", new Object[0]);
    }

    private void a(Message message, int i2, boolean z) {
        boolean z2;
        try {
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor == null) {
                return;
            }
            netPermanceMonitor.onToBizDate();
            String string = message.host == null ? null : message.host.toString();
            if (i2 == 200) {
                z2 = true;
                if (message.retryTimes > 0) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                } else {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, string);
                }
            } else {
                if (message.retryTimes > 0) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail\uff3f" + i2, 0.0d);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                } else if (i2 != -13) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, string, UtilityImpl.a(i2), this.f5764b + message.serviceId + message.timeout);
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
            ALog.e(this.f5775m, "monitorPerf", th, new Object[0]);
        }
    }

    public void a() {
        ALog.d(this.f5775m, "onSendPing", new Object[0]);
        synchronized (d.class) {
            this.f5770h = true;
        }
    }

    public void a(Message message) {
        String str;
        Message message2 = this.f5773k;
        if (message2 != null && (str = message.cunstomDataId) != null && message.serviceId != null && message2.cunstomDataId.equals(str) && this.f5773k.serviceId.equals(message.serviceId)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() == -1 || message.getType() == 2 || message.isAck) {
            return;
        }
        this.f5769g.put(message.getMsgId(), message);
    }

    public void a(int i2) {
        this.f5770h = false;
        Message.Id[] idArr = (Message.Id[]) this.f5769g.keySet().toArray(new Message.Id[0]);
        if (idArr.length > 0) {
            ALog.d(this.f5775m, "onNetworkFail", new Object[0]);
            for (Message.Id id : idArr) {
                Message messageRemove = this.f5769g.remove(id);
                if (messageRemove != null) {
                    a(messageRemove, i2);
                }
            }
        }
    }

    public Message a(String str) {
        return this.f5769g.get(new Message.Id(0, str));
    }

    private byte[] a(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int i2 = Integer.parseInt(map.get(17));
                    int i3 = Integer.parseInt(map.get(16));
                    if (i3 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    }
                    if (i2 >= 0 && i2 < i3) {
                        String str2 = map.get(18);
                        long j2 = 0;
                        try {
                            String str3 = map.get(15);
                            if (!TextUtils.isEmpty(str3)) {
                                j2 = Long.parseLong(str3);
                            }
                        } catch (Throwable th) {
                            ALog.w(this.f5775m, "putBurstMessage", th, new Object[0]);
                        }
                        a aVar = this.o.get(str);
                        if (aVar == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.f5775m, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(i3));
                            }
                            aVar = new a(str, i3, str2);
                            aVar.a(j2);
                            this.o.put(str, aVar);
                        }
                        return aVar.a(i2, i3, bArr);
                    }
                    throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(i3), Integer.valueOf(i2)));
                }
            } catch (Throwable th2) {
                ALog.w(this.f5775m, "putBurstMessage", th2, new Object[0]);
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
        eVar.a = UtilityImpl.j(this.f5771i);
        eVar.f5877c = str;
        eVar.f5878d = "" + System.currentTimeMillis();
        eVar.f5880f = "";
        eVar.f5879e = str2;
        eVar.f5876b = "";
        eVar.a();
    }

    public void a(TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(this, aVar));
        } catch (Throwable th) {
            ALog.e(this.f5775m, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
