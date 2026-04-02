package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.sina.weibo.BuildConfig;
import com.sina.weibo.sdk.b.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0158 A[Catch: all -> 0x015c, Exception -> 0x015f, TRY_ENTER, TryCatch #10 {Exception -> 0x015f, all -> 0x015c, blocks: (B:3:0x0005, B:5:0x000d, B:6:0x000f, B:9:0x0017, B:23:0x0098, B:33:0x00c0, B:35:0x00c6, B:39:0x00dd, B:40:0x00e4, B:31:0x00bc, B:68:0x0158, B:69:0x015b), top: B:100:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0187 A[Catch: Exception -> 0x0183, TRY_LEAVE, TryCatch #12 {Exception -> 0x0183, blocks: (B:78:0x017f, B:82:0x0187), top: B:93:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static String a(Context context, Uri uri, int i2) throws Throwable {
        FileOutputStream fileOutputStream;
        String str;
        Calendar calendar;
        Cursor cursorQuery;
        String string;
        File file;
        BufferedInputStream bufferedInputStream = null;
        try {
            a.C0109a c0109aE = com.sina.weibo.sdk.b.a.e(context);
            String str2 = c0109aE != null ? c0109aE.packageName : "";
            if (TextUtils.isEmpty(str2)) {
                str2 = BuildConfig.APPLICATION_ID;
            }
            str = "/Android/data/" + str2 + "/files/.composerTem/";
            new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str).mkdirs();
            calendar = Calendar.getInstance();
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            if (!"file".equals(uri.getScheme())) {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        try {
                            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")) : null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        com.sina.weibo.sdk.b.c.b("WBShareTag", "share util and exception is " + e.getMessage());
                        e.printStackTrace();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        string = null;
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
            string = calendar.getTimeInMillis() + uri.getLastPathSegment();
            cursorQuery = null;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e5) {
            e = e5;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
            if (cursorQuery != null) {
            }
            throw th;
        }
        if (TextUtils.isEmpty(string)) {
            StringBuilder sb = new StringBuilder();
            sb.append(Calendar.getInstance().getTimeInMillis());
            sb.append(i2 == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
            string = sb.toString();
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
        try {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str + string);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1444];
            while (true) {
                int i3 = bufferedInputStream2.read(bArr);
                if (i3 == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i3);
            }
            String path = file.getPath();
            try {
                bufferedInputStream2.close();
                fileOutputStream.close();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            return path;
        } catch (Exception e8) {
            e = e8;
            bufferedInputStream = bufferedInputStream2;
            try {
                com.sina.weibo.sdk.b.c.b("WBShareTag", "share util and error is " + e.getMessage());
                throw new Throwable(e);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = bufferedInputStream2;
            if (bufferedInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }
}
