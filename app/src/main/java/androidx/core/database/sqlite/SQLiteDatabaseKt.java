package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SQLiteDatabase.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, m23546d2 = {"transaction", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@InterfaceC5816d SQLiteDatabase sQLiteDatabase, boolean z, @InterfaceC5816d InterfaceC5506l<? super SQLiteDatabase, ? extends T> interfaceC5506l) {
        C5544i0.m22546f(sQLiteDatabase, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = interfaceC5506l.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            C5535f0.m22474b(1);
            sQLiteDatabase.endTransaction();
            C5535f0.m22471a(1);
        }
    }

    public static /* bridge */ /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        C5544i0.m22546f(sQLiteDatabase, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = interfaceC5506l.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            C5535f0.m22474b(1);
            sQLiteDatabase.endTransaction();
            C5535f0.m22471a(1);
        }
    }
}
