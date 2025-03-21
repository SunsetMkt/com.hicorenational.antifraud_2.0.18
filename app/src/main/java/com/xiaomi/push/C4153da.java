package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4372ax;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.da */
/* loaded from: classes2.dex */
class C4153da {

    /* renamed from: a */
    private static String f14839a = "/MiPushLog";

    /* renamed from: a */
    private int f14840a;

    /* renamed from: a */
    private boolean f14843a;

    /* renamed from: b */
    private String f14845b;

    /* renamed from: c */
    private String f14846c;

    /* renamed from: a */
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat f14841a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: b */
    private int f14844b = 2097152;

    /* renamed from: a */
    private ArrayList<File> f14842a = new ArrayList<>();

    C4153da() {
    }

    /* renamed from: a */
    C4153da m14257a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f14845b = this.f14841a.format(date2);
            this.f14846c = this.f14841a.format(date);
        } else {
            this.f14845b = this.f14841a.format(date);
            this.f14846c = this.f14841a.format(date2);
        }
        return this;
    }

    /* renamed from: a */
    void m14259a(int i2) {
        if (i2 != 0) {
            this.f14844b = i2;
        }
    }

    /* renamed from: a */
    C4153da m14256a(File file) {
        if (file.exists()) {
            this.f14842a.add(file);
        }
        return this;
    }

    /* renamed from: a */
    private void m14254a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= read || !matcher.find(i2)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f14845b.length() + start);
                if (!this.f14843a) {
                    if (substring.compareTo(this.f14845b) >= 0) {
                        this.f14843a = true;
                        i3 = start;
                    }
                } else if (substring.compareTo(this.f14846c) > 0) {
                    read = start;
                    z = true;
                    break;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f14845b.length();
                }
                i2 = start + indexOf;
            }
            if (this.f14843a) {
                int i4 = read - i3;
                this.f14840a += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                } else {
                    bufferedWriter.write(cArr, i3, i4);
                    if (this.f14840a > this.f14844b) {
                        return;
                    }
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* renamed from: a */
    private void m14255a(File file) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader = null;
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedWriter = null;
            }
            try {
                bufferedWriter.write("model :" + C4301k.m15694a() + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + C4372ax.m16018a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                this.f14840a = 0;
                Iterator<File> it = this.f14842a.iterator();
                while (it.hasNext()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                    try {
                        m14254a(bufferedReader, bufferedWriter, compile);
                        bufferedReader.close();
                        bufferedReader2 = bufferedReader;
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedReader2 = bufferedWriter;
                        AbstractC4022b.m13359c("LOG: filter error = " + e.getMessage());
                        C4408w.m16356a(bufferedReader2);
                        C4408w.m16356a(bufferedReader);
                        return;
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader2 = bufferedWriter;
                        AbstractC4022b.m13359c("LOG: filter error = " + e.getMessage());
                        C4408w.m16356a(bufferedReader2);
                        C4408w.m16356a(bufferedReader);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        C4408w.m16356a(bufferedWriter);
                        C4408w.m16356a(bufferedReader2);
                        throw th;
                    }
                }
                bufferedWriter.write(C4132cg.m14066a().m14089c());
                C4408w.m16356a(bufferedWriter);
                C4408w.m16356a(bufferedReader2);
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = bufferedReader2;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = bufferedReader2;
            } catch (Throwable th3) {
                th = th3;
                C4408w.m16356a(bufferedWriter);
                C4408w.m16356a(bufferedReader2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = bufferedReader2;
        }
    }

    /* renamed from: a */
    File m14258a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = C4151cz.m14245a(context);
            if (file2 == null) {
                return null;
            }
            m14256a(new File(file2, "xmsf.log.1"));
            m14256a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(context.getFilesDir() + f14839a);
            if (!C4407v.m16354a(file3)) {
                return null;
            }
            m14256a(new File(file3, "log0.txt"));
            m14256a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        m14257a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        m14255a(file5);
        AbstractC4022b.m13359c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            C4408w.m16357a(file4, file5);
            AbstractC4022b.m13359c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }
}
