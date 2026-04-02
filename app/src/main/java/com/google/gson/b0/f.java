package com.google.gson.b0;

/* JADX INFO: compiled from: JavaVersion.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final int a = a();

    private f() {
    }

    private static int a() {
        return b(System.getProperty("java.version"));
    }

    static int b(String str) {
        int iC = c(str);
        if (iC == -1) {
            iC = a(str);
        }
        if (iC == -1) {
            return 6;
        }
        return iC;
    }

    private static int c(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i2 = Integer.parseInt(strArrSplit[0]);
            return (i2 != 1 || strArrSplit.length <= 1) ? i2 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int b() {
        return a;
    }

    public static boolean c() {
        return a >= 9;
    }
}
