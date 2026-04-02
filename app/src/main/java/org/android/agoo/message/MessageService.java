package org.android.agoo.message;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class MessageService {
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";
    private static Context a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static LruCache<String, Integer> f12888c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile SQLiteOpenHelper f12889b = null;

    /* JADX INFO: compiled from: Taobao */
    private static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "message_accs_db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        private String a() {
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

        private String b() {
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
            if (j.a(super.getWritableDatabase().getPath(), 102400)) {
                return super.getWritableDatabase();
            }
            return null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL(b());
                    sQLiteDatabase.execSQL("CREATE INDEX id_index ON message(id)");
                    sQLiteDatabase.execSQL("CREATE INDEX body_code_index ON message(body_code)");
                    sQLiteDatabase.execSQL(a());
                } catch (Throwable th) {
                    ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
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
                        ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(a());
                            return;
                        } catch (Throwable th2) {
                            ALog.e("MessageService", "MessageService onUpgrade is error", th2, new Object[0]);
                            return;
                        }
                    } catch (Throwable th3) {
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(a());
                        } catch (Throwable th4) {
                            ALog.e("MessageService", "MessageService onUpgrade is error", th4, new Object[0]);
                        }
                        throw th3;
                    }
                }
            }
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                sQLiteDatabase.execSQL(a());
            } catch (Throwable th5) {
                ALog.e("MessageService", "MessageService onUpgrade is error", th5, new Object[0]);
            }
        }
    }

    public void a(Context context) {
        f12888c = new LruCache<>(100);
        a = context;
        this.f12889b = new a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0143 A[Catch: all -> 0x0186, TRY_LEAVE, TryCatch #4 {all -> 0x0186, blocks: (B:61:0x013b, B:63:0x0143), top: B:96:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0164 A[Catch: all -> 0x0160, TRY_LEAVE, TryCatch #0 {all -> 0x0160, blocks: (B:65:0x015c, B:69:0x0164), top: B:88:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<MsgDO> b() {
        SQLiteDatabase readableDatabase;
        ArrayList<MsgDO> arrayList;
        Cursor cursorRawQuery;
        int i2;
        int i3;
        try {
            readableDatabase = this.f12889b.getReadableDatabase();
        } catch (Throwable th) {
            th = th;
            readableDatabase = null;
        }
        if (readableDatabase == null) {
            if (readableDatabase != null) {
                try {
                    readableDatabase.close();
                } catch (Throwable th2) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th2, new Object[0]);
                    }
                }
            }
            return null;
        }
        try {
            arrayList = new ArrayList<>();
        } catch (Throwable th3) {
            th = th3;
            arrayList = null;
            cursorRawQuery = null;
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                }
                if (cursorRawQuery != null) {
                }
                if (readableDatabase != null) {
                }
                return arrayList;
            } finally {
            }
        }
        try {
            cursorRawQuery = readableDatabase.rawQuery("select * from accs_message where state = ? or state = ? or state = ?", new String[]{"0", "2", "3"});
            if (cursorRawQuery != null) {
                try {
                    int columnIndex = cursorRawQuery.getColumnIndex("id");
                    int columnIndex2 = cursorRawQuery.getColumnIndex("state");
                    int columnIndex3 = cursorRawQuery.getColumnIndex("message");
                    int columnIndex4 = cursorRawQuery.getColumnIndex("create_time");
                    while (cursorRawQuery.moveToNext() && !TextUtils.isEmpty(cursorRawQuery.getString(columnIndex3))) {
                        String string = cursorRawQuery.getString(columnIndex2);
                        String string2 = cursorRawQuery.getString(columnIndex3);
                        if (ALog.isPrintLog(ALog.Level.I)) {
                            StringBuilder sb = new StringBuilder();
                            i3 = columnIndex2;
                            sb.append("state: ");
                            sb.append(string);
                            sb.append(" ,cursor.message:");
                            sb.append(string2);
                            sb.append(" ,cursor.id:");
                            sb.append(cursorRawQuery.getString(columnIndex));
                            sb.append(" ,cursor.time:");
                            sb.append(cursorRawQuery.getString(columnIndex4));
                            i2 = columnIndex;
                            ALog.i("MessageService", sb.toString(), new Object[0]);
                        } else {
                            i2 = columnIndex;
                            i3 = columnIndex2;
                        }
                        String str = TextUtils.equals("0", string) ? "4" : TextUtils.equals("2", string) ? "8" : TextUtils.equals("3", string) ? "9" : null;
                        new MsgDO();
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(str)) {
                            MsgDO msgDOB = b(string2, str);
                            msgDOB.messageSource = "cache";
                            arrayList.add(msgDOB);
                        }
                        columnIndex2 = i3;
                        columnIndex = i2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (ALog.isPrintLog(ALog.Level.E)) {
                    }
                    if (cursorRawQuery != null) {
                    }
                    if (readableDatabase != null) {
                    }
                }
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th5) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th5, new Object[0]);
                    }
                }
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
        } catch (Throwable th6) {
            th = th6;
            cursorRawQuery = null;
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("MessageService", "getUnReportMsg, e: " + th, new Object[0]);
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th7) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th7, new Object[0]);
                    }
                }
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            return arrayList;
        }
        return arrayList;
    }

    public void a(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + "]", new Object[0]);
        }
        SQLiteDatabase writableDatabase = null;
        try {
        } catch (Throwable th) {
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "updateAccsMessage error,e--->[" + th + "],ex=" + th.getStackTrace().toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(a), "updateAccsMessageFailed", th.toString());
                if (0 == 0) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    writableDatabase.close();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            writableDatabase = this.f12889b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    return;
                } else {
                    return;
                }
            }
            if (TextUtils.equals(str2, "1")) {
                writableDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
            } else {
                writableDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
            }
            if (writableDatabase == null) {
                return;
            }
            writableDatabase.close();
        }
    }

    public void a(String str, String str2, String str3) {
        SQLiteDatabase writableDatabase;
        Cursor cursorRawQuery;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "addAccsMessage sqlite3--->[" + str + ",message=" + str2 + ",state=" + str3 + "]", new Object[0]);
        }
        Cursor cursor = null;
        try {
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            writableDatabase = this.f12889b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    writableDatabase.close();
                    return;
                }
                return;
            }
            try {
                cursorRawQuery = writableDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "addAccsMessage error,e--->[" + th + "],ex=" + a(th), new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(a), "addAccsMessageFailed", th.toString());
                    if (writableDatabase == null) {
                        return;
                    }
                } finally {
                    if (0 != 0) {
                        cursor.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                }
            }
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst() && cursorRawQuery.getInt(0) > 0) {
                cursorRawQuery.close();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (writableDatabase != null) {
                    writableDatabase.close();
                    return;
                }
                return;
            }
            writableDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (writableDatabase == null) {
            }
        }
    }

    private String a(Throwable th) {
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

    private MsgDO b(String str, String str2) {
        int i2;
        int i3;
        String str3;
        boolean z;
        String str4 = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "msgRecevie,message--->[" + str + "],utdid=" + j.b(a), new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", j.b(a), "message==null");
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i("MessageService", "handleMessage message==null,utdid=" + j.b(a), new Object[0]);
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
            String string = null;
            int i4 = 0;
            while (i4 < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                if (jSONObject == null) {
                    i2 = length;
                    str3 = str4;
                    i3 = i4;
                } else {
                    String string2 = jSONObject.getString(bh.aA);
                    String string3 = jSONObject.getString(bh.aF);
                    String string4 = jSONObject.getString("b");
                    int i5 = i4;
                    long j2 = jSONObject.getLong("f");
                    sb.append(string3);
                    if (!jSONObject.isNull(str4)) {
                        string = jSONObject.getString(str4);
                    }
                    int i6 = length - 1;
                    i2 = length;
                    i3 = i5;
                    if (i3 < i6) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    msgDO.msgIds = string3;
                    msgDO.extData = string;
                    str3 = str4;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string4)) {
                        msgDO.errorCode = "11";
                    } else if (TextUtils.isEmpty(string2)) {
                        msgDO.errorCode = "12";
                    } else if (j2 == -1) {
                        msgDO.errorCode = "13";
                    } else if (!a(a, string2)) {
                        ALog.d("MessageService", "ondata checkpackage is del,pack=" + string2, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", j.b(a), "deletePack", string2);
                        sb3.append(string2);
                        sb2.append(string3);
                        msgDO.removePacks = string2;
                        if (i3 < i6) {
                            sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    } else {
                        String string5 = a(j2, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!a.getPackageName().equals(string2)) {
                            z = true;
                        } else if (TextUtils.equals(Integer.toString(0), string5) || TextUtils.equals(Integer.toString(4), string5)) {
                            z = false;
                        } else {
                            msgDO.errorCode = "15";
                            ALog.e("MessageService", "error encrypted: " + string5, new Object[0]);
                        }
                        msgDO.agooFlag = z;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                        i4 = i3 + 1;
                        length = i2;
                        str4 = str3;
                    }
                }
                i4 = i3 + 1;
                length = i2;
                str4 = str3;
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("MessageService", "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    public void a(String str, String str2, String str3, int i2) {
        a(str, str2, str3, 1, -1L, -1, i2);
    }

    private void a(String str, String str2, String str3, int i2, long j2, int i3, int i4) {
        Throwable th;
        String str4;
        int iHashCode;
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("add sqlite3--->[");
        sb.append(str);
        sb.append("]");
        ALog.d("MessageService", sb.toString(), new Object[0]);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            str4 = "";
            if (TextUtils.isEmpty(str2)) {
                iHashCode = -1;
                str5 = "";
            } else {
                iHashCode = str2.hashCode();
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str4 = str3;
            }
            if (f12888c.get(str) == null) {
                f12888c.put(str, Integer.valueOf(iHashCode));
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("MessageService", "addMessage,messageId=" + str + ", mCache size:" + f12888c.size(), new Object[0]);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            SQLiteDatabase writableDatabase = this.f12889b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                        return;
                    } catch (Throwable th3) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th3 + "]", new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(a), "addMessageDBcloseFailed", th3.toString());
                        return;
                    }
                }
                return;
            }
            writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(iHashCode), 0, Long.valueOf(j2), Integer.valueOf(i3), str4, str5, Integer.valueOf(i4)});
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.close();
                return;
            } catch (Throwable th4) {
                th = th4;
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                }
            }
        } catch (Throwable th5) {
            th = th5;
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "addMessage error,e--->[" + th + "]", new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(a), "addMessageFailed", th.toString());
                if (0 == 0) {
                    return;
                }
                try {
                    sQLiteDatabase.close();
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                    }
                }
            } finally {
            }
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(a), "addMessageDBcloseFailed", th.toString());
    }

    public void a() {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.f12889b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            writableDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
            writableDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.e("MessageService", "deleteCacheMessage sql Throwable", th, new Object[0]);
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        writableDatabase.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        try {
            writableDatabase.close();
        } catch (Throwable unused3) {
        }
    }

    public boolean a(String str) {
        boolean z;
        SQLiteDatabase readableDatabase;
        Cursor cursorRawQuery = null;
        try {
            try {
                if (f12888c.get(str) != null) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "hasMessageDuplicate,msgid=" + str, new Object[0]);
                    }
                    z = true;
                } else {
                    z = false;
                }
                try {
                    readableDatabase = this.f12889b.getReadableDatabase();
                } catch (Throwable unused) {
                    readableDatabase = null;
                }
            } catch (Throwable unused2) {
                readableDatabase = null;
                z = false;
            }
        } catch (Throwable unused3) {
        }
        if (readableDatabase == null) {
            if (readableDatabase != null) {
                try {
                    readableDatabase.close();
                } catch (Throwable unused4) {
                }
            }
            return z;
        }
        try {
            cursorRawQuery = readableDatabase.rawQuery("select count(1) from message where id = ?", new String[]{str});
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                if (cursorRawQuery.getInt(0) > 0) {
                    z = true;
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable unused5) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (readableDatabase != null) {
            }
            return z;
        }
        if (readableDatabase != null) {
            readableDatabase.close();
        }
        return z;
    }

    public boolean a(String str, int i2) {
        SQLiteDatabase readableDatabase;
        boolean z;
        Cursor cursorRawQuery = null;
        try {
            try {
                Integer num = f12888c.get(str);
                if (num == null || i2 != num.intValue()) {
                    z = false;
                } else {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "hasMessageDuplicate,msgid=" + str, new Object[0]);
                    }
                    z = true;
                }
                try {
                    readableDatabase = this.f12889b.getReadableDatabase();
                } catch (Throwable unused) {
                    readableDatabase = null;
                }
            } catch (Throwable unused2) {
                readableDatabase = null;
                z = false;
            }
        } catch (Throwable unused3) {
        }
        if (readableDatabase == null) {
            if (readableDatabase != null) {
                try {
                    readableDatabase.close();
                } catch (Throwable unused4) {
                }
            }
            return z;
        }
        try {
            cursorRawQuery = readableDatabase.rawQuery("select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')", new String[]{str, "" + i2});
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                if (cursorRawQuery.getInt(0) > 0) {
                    z = true;
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable unused5) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (readableDatabase != null) {
            }
            return z;
        }
        if (readableDatabase != null) {
            readableDatabase.close();
        }
        return z;
    }

    public static final boolean a(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private static Bundle a(long j2, MsgDO msgDO) {
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
