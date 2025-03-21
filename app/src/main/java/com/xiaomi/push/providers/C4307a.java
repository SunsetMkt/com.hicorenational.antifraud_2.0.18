package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.providers.a */
/* loaded from: classes2.dex */
public class C4307a extends SQLiteOpenHelper {

    /* renamed from: a */
    private static int f16392a = 1;

    /* renamed from: a */
    public static final Object f16393a = new Object();

    /* renamed from: a */
    private static final String[] f16394a = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", C3351bh.f11568T, " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", Constants.KEY_IMSI, "TEXT"};

    public C4307a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f16392a);
    }

    /* renamed from: a */
    private void m15712a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i2 = 0; i2 < f16394a.length - 1; i2 += 2) {
            if (i2 != 0) {
                sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(f16394a[i2]);
            sb.append(AbstractC1191a.f2568g);
            sb.append(f16394a[i2 + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f16393a) {
            try {
                m15712a(sQLiteDatabase);
            } catch (SQLException e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
