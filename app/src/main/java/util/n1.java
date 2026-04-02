package util;

import android.graphics.BitmapFactory;

/* JADX INFO: compiled from: ImageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class n1 {

    /* JADX INFO: compiled from: ImageUtils.java */
    public static class a {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14985b;

        public int a() {
            return this.f14985b;
        }

        public int b() {
            return this.a;
        }

        public void a(int i2) {
            this.f14985b = i2;
        }

        public void b(int i2) {
            this.a = i2;
        }
    }

    public static a a(String str) {
        a aVar = new a();
        if (str != null && !str.isEmpty()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outWidth;
            if (i2 > 0 && options.outHeight > 0) {
                aVar.b(i2);
                aVar.a(options.outHeight);
            }
        }
        return aVar;
    }
}
