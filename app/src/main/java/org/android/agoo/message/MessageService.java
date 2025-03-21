package org.android.agoo.message;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.UTMini;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MessageService {
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";

    /* renamed from: a */
    private static Context f21510a;

    /* renamed from: c */
    private static LruCache<String, Integer> f21511c;

    /* renamed from: b */
    private volatile SQLiteOpenHelper f21512b = null;

    /* compiled from: Taobao */
    /* renamed from: org.android.agoo.message.MessageService$a */
    private static class C6032a extends SQLiteOpenHelper {
        public C6032a(Context context) {
            super(context, "message_accs_db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        /* renamed from: a */
        private String m24970a() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table accs_message");
            stringBuffer.append("(");
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state text,");
            stringBuffer.append("message text,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        /* renamed from: b */
        private String m24971b() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table message");
            stringBuffer.append("(");
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state integer,");
            stringBuffer.append("body_code integer,");
            stringBuffer.append("report long,");
            stringBuffer.append("target_time long,");
            stringBuffer.append("interval integer,");
            stringBuffer.append("type text,");
            stringBuffer.append("message text,");
            stringBuffer.append("notify integer,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (C3042j.m9246a(super.getWritableDatabase().getPath(), 102400)) {
                return super.getWritableDatabase();
            }
            return null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL(m24971b());
                    sQLiteDatabase.execSQL("CREATE INDEX id_index ON message(id)");
                    sQLiteDatabase.execSQL("CREATE INDEX body_code_index ON message(body_code)");
                    sQLiteDatabase.execSQL(m24970a());
                } catch (Throwable th) {
                    ALog.m9181e("MessageService", "messagedbhelper create", th, new Object[0]);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                } catch (Throwable th) {
                    try {
                        ALog.m9181e("MessageService", "messagedbhelper create", th, new Object[0]);
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(m24970a());
                            return;
                        } catch (Throwable th2) {
                            ALog.m9181e("MessageService", "MessageService onUpgrade is error", th2, new Object[0]);
                            return;
                        }
                    } catch (Throwable th3) {
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(m24970a());
                        } catch (Throwable th4) {
                            ALog.m9181e("MessageService", "MessageService onUpgrade is error", th4, new Object[0]);
                        }
                        throw th3;
                    }
                }
            }
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                sQLiteDatabase.execSQL(m24970a());
            } catch (Throwable th5) {
                ALog.m9181e("MessageService", "MessageService onUpgrade is error", th5, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public void m24963a(Context context) {
        f21511c = new LruCache<>(100);
        f21510a = context;
        this.f21512b = new C6032a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0143 A[Catch: all -> 0x0186, TRY_LEAVE, TryCatch #4 {all -> 0x0186, blocks: (B:66:0x013b, B:68:0x0143), top: B:65:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0164 A[Catch: all -> 0x0160, TRY_LEAVE, TryCatch #0 {all -> 0x0160, blocks: (B:80:0x015c, B:72:0x0164), top: B:79:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<org.android.agoo.common.MsgDO> m24969b() {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.m24969b():java.util.ArrayList");
    }

    /* renamed from: a */
    public void m24964a(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i("MessageService", "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + "]", new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
        } catch (Throwable th) {
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.m9182e("MessageService", "updateAccsMessage error,e--->[" + th + "],ex=" + th.getStackTrace().toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", C3042j.m9247b(f21510a), "updateAccsMessageFailed", th.toString());
                if (0 == 0) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sQLiteDatabase = this.f21512b.getWritableDatabase();
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null) {
                    return;
                } else {
                    return;
                }
            }
            if (TextUtils.equals(str2, "1")) {
                sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
            } else {
                sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
            }
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.close();
        }
    }

    /* renamed from: a */
    public void m24965a(String str, String str2, String str3) {
        SQLiteDatabase sQLiteDatabase;
        Cursor rawQuery;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i("MessageService", "addAccsMessage sqlite3--->[" + str + ",message=" + str2 + ",state=" + str3 + "]", new Object[0]);
        }
        Cursor cursor = null;
        try {
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sQLiteDatabase = this.f21512b.getWritableDatabase();
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    return;
                }
                return;
            }
            try {
                rawQuery = sQLiteDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.m9182e("MessageService", "addAccsMessage error,e--->[" + th + "],ex=" + m24958a(th), new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", C3042j.m9247b(f21510a), "addAccsMessageFailed", th.toString());
                    if (sQLiteDatabase == null) {
                        return;
                    }
                } finally {
                    if (0 != 0) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                }
            }
            if (rawQuery != null && rawQuery.moveToFirst() && rawQuery.getInt(0) > 0) {
                rawQuery.close();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    return;
                }
                return;
            }
            sQLiteDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (sQLiteDatabase == null) {
            }
        }
    }

    /* renamed from: a */
    private String m24958a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private MsgDO m24961b(String str, String str2) {
        int i2;
        int i3;
        String str3;
        boolean z;
        String str4 = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i("MessageService", "msgRecevie,message--->[" + str + "],utdid=" + C3042j.m9247b(f21510a), new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", C3042j.m9247b(f21510a), "message==null");
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.m9183i("MessageService", "handleMessage message==null,utdid=" + C3042j.m9247b(f21510a), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            new Bundle();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            String str5 = null;
            int i4 = 0;
            while (i4 < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                if (jSONObject == null) {
                    i2 = length;
                    str3 = str4;
                    i3 = i4;
                } else {
                    String string = jSONObject.getString(C3351bh.f11576aA);
                    String string2 = jSONObject.getString(C3351bh.f11581aF);
                    String string3 = jSONObject.getString("b");
                    int i5 = i4;
                    long j2 = jSONObject.getLong("f");
                    sb.append(string2);
                    if (!jSONObject.isNull(str4)) {
                        str5 = jSONObject.getString(str4);
                    }
                    int i6 = length - 1;
                    i2 = length;
                    i3 = i5;
                    if (i3 < i6) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    msgDO.msgIds = string2;
                    msgDO.extData = str5;
                    str3 = str4;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = "11";
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = "12";
                    } else if (j2 == -1) {
                        msgDO.errorCode = "13";
                    } else if (!m24960a(f21510a, string)) {
                        ALog.m9180d("MessageService", "ondata checkpackage is del,pack=" + string, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", C3042j.m9247b(f21510a), "deletePack", string);
                        sb3.append(string);
                        sb2.append(string2);
                        msgDO.removePacks = string;
                        if (i3 < i6) {
                            sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    } else {
                        String string4 = m24957a(j2, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!f21510a.getPackageName().equals(string)) {
                            z = true;
                        } else if (TextUtils.equals(Integer.toString(0), string4) || TextUtils.equals(Integer.toString(4), string4)) {
                            z = false;
                        } else {
                            msgDO.errorCode = "15";
                            ALog.m9182e("MessageService", "error encrypted: " + string4, new Object[0]);
                        }
                        msgDO.agooFlag = z;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                            i4 = i3 + 1;
                            length = i2;
                            str4 = str3;
                        }
                    }
                }
                i4 = i3 + 1;
                length = i2;
                str4 = str3;
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.m9182e("MessageService", "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    /* renamed from: a */
    public void m24966a(String str, String str2, String str3, int i2) {
        m24959a(str, str2, str3, 1, -1L, -1, i2);
    }

    /* renamed from: a */
    private void m24959a(String str, String str2, String str3, int i2, long j2, int i3, int i4) {
        Throwable th;
        String str4;
        int hashCode;
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("add sqlite3--->[");
        sb.append(str);
        sb.append("]");
        ALog.m9180d("MessageService", sb.toString(), new Object[0]);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            str4 = "";
            if (TextUtils.isEmpty(str2)) {
                hashCode = -1;
                str5 = "";
            } else {
                hashCode = str2.hashCode();
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str4 = str3;
            }
            if (f21511c.get(str) == null) {
                f21511c.put(str, Integer.valueOf(hashCode));
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.m9183i("MessageService", "addMessage,messageId=" + str + ", mCache size:" + f21511c.size(), new Object[0]);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            SQLiteDatabase writableDatabase = this.f21512b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                        return;
                    } catch (Throwable th3) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.m9182e("MessageService", "addMessage,db.close(),error,e--->[" + th3 + "]", new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", C3042j.m9247b(f21510a), "addMessageDBcloseFailed", th3.toString());
                        return;
                    }
                }
                return;
            }
            writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(hashCode), 0, Long.valueOf(j2), Integer.valueOf(i3), str4, str5, Integer.valueOf(i4)});
            if (writableDatabase != null) {
                try {
                    writableDatabase.close();
                } catch (Throwable th4) {
                    th = th4;
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.m9182e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", C3042j.m9247b(f21510a), "addMessageDBcloseFailed", th.toString());
                }
            }
        } catch (Throwable th5) {
            th = th5;
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.m9182e("MessageService", "addMessage error,e--->[" + th + "]", new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", C3042j.m9247b(f21510a), "addMessageFailed", th.toString());
                if (0 != 0) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable th6) {
                        th = th6;
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.m9182e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", C3042j.m9247b(f21510a), "addMessageDBcloseFailed", th.toString());
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: a */
    public void m24962a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f21512b.getWritableDatabase();
        } catch (Throwable th) {
            try {
                ALog.m9181e("MessageService", "deleteCacheMessage sql Throwable", th, new Object[0]);
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
        if (sQLiteDatabase == null) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            return;
        }
        sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
        sQLiteDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        if (r4 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006b, code lost:
    
        if (r4 != null) goto L25;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m24967a(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            android.util.LruCache<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.f21511c     // Catch: java.lang.Throwable -> L64
            java.lang.Object r2 = r2.get(r8)     // Catch: java.lang.Throwable -> L64
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L64
            r3 = 1
            if (r2 == 0) goto L2f
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch: java.lang.Throwable -> L64
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L2d
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = "hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch: java.lang.Throwable -> L64
            r4.append(r8)     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L64
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L64
            com.taobao.accs.utl.ALog.m9182e(r2, r4, r5)     // Catch: java.lang.Throwable -> L64
        L2d:
            r2 = 1
            goto L30
        L2f:
            r2 = 0
        L30:
            android.database.sqlite.SQLiteOpenHelper r4 = r7.f21512b     // Catch: java.lang.Throwable -> L62
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L62
            if (r4 != 0) goto L3e
            if (r4 == 0) goto L3d
            r4.close()     // Catch: java.lang.Throwable -> L3d
        L3d:
            return r2
        L3e:
            java.lang.String r5 = "select count(1) from message where id = ?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L66
            r6[r1] = r8     // Catch: java.lang.Throwable -> L66
            android.database.Cursor r0 = r4.rawQuery(r5, r6)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L57
            boolean r8 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L66
            if (r8 == 0) goto L57
            int r8 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L66
            if (r8 <= 0) goto L57
            r2 = 1
        L57:
            if (r0 == 0) goto L5c
            r0.close()     // Catch: java.lang.Throwable -> L6e
        L5c:
            if (r4 == 0) goto L6e
        L5e:
            r4.close()     // Catch: java.lang.Throwable -> L6e
            goto L6e
        L62:
            r4 = r0
            goto L66
        L64:
            r4 = r0
            r2 = 0
        L66:
            if (r0 == 0) goto L6b
            r0.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            if (r4 == 0) goto L6e
            goto L5e
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.m24967a(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        if (r4 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0085, code lost:
    
        if (r4 != null) goto L27;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m24968a(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            android.util.LruCache<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.f21511c     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r2 = r2.get(r9)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L7e
            r3 = 1
            if (r2 == 0) goto L35
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r10 != r2) goto L35
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch: java.lang.Throwable -> L7e
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> L7e
            if (r2 == 0) goto L33
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r4.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r5 = "hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch: java.lang.Throwable -> L7e
            r4.append(r9)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L7e
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L7e
            com.taobao.accs.utl.ALog.m9182e(r2, r4, r5)     // Catch: java.lang.Throwable -> L7e
        L33:
            r2 = 1
            goto L36
        L35:
            r2 = 0
        L36:
            android.database.sqlite.SQLiteOpenHelper r4 = r8.f21512b     // Catch: java.lang.Throwable -> L7c
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L7c
            if (r4 != 0) goto L44
            if (r4 == 0) goto L43
            r4.close()     // Catch: java.lang.Throwable -> L43
        L43:
            return r2
        L44:
            java.lang.String r5 = "select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L80
            r6[r1] = r9     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r9.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = ""
            r9.append(r7)     // Catch: java.lang.Throwable -> L80
            r9.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L80
            r6[r3] = r9     // Catch: java.lang.Throwable -> L80
            android.database.Cursor r0 = r4.rawQuery(r5, r6)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L71
            boolean r9 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L80
            if (r9 == 0) goto L71
            int r9 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L80
            if (r9 <= 0) goto L71
            r2 = 1
        L71:
            if (r0 == 0) goto L76
            r0.close()     // Catch: java.lang.Throwable -> L88
        L76:
            if (r4 == 0) goto L88
        L78:
            r4.close()     // Catch: java.lang.Throwable -> L88
            goto L88
        L7c:
            r4 = r0
            goto L80
        L7e:
            r4 = r0
            r2 = 0
        L80:
            if (r0 == 0) goto L85
            r0.close()     // Catch: java.lang.Throwable -> L88
        L85:
            if (r4 == 0) goto L88
            goto L78
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.m24968a(java.lang.String, int):boolean");
    }

    /* renamed from: a */
    public static final boolean m24960a(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    /* renamed from: a */
    private static Bundle m24957a(long j2, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j2).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }
}
