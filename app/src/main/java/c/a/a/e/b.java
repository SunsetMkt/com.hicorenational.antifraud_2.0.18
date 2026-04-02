package c.a.a.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import c.a.a.e.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CarNumberPicker.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends f<c.a.a.d.c, c.a.a.d.b, Void> {
    private static final String[] x0 = {"\u4eac", "\u6d25", "\u5180", "\u664b", "\u8499", "\u8fbd", "\u5409", "\u9ed1", "\u6caa", "\u82cf", "\u6d59", "\u7696", "\u95fd", "\u8d63", "\u9c81", "\u8c6b", "\u9102", "\u6e58", "\u7ca4", "\u6842", "\u743c", "\u6e1d", "\u5ddd", "\u8d35", "\u4e91", "\u85cf", "\u9655", "\u7518", "\u9752", "\u5b81", "\u65b0"};

    /* JADX INFO: compiled from: CarNumberPicker.java */
    private static class a implements f.k<c.a.a.d.c, c.a.a.d.b, Void> {
        private List<c.a.a.d.c> a = new ArrayList();

        a() {
            for (String str : b.x0) {
                this.a.add(new c.a.a.d.c(str));
            }
        }

        @Override // c.a.a.e.f.k
        @NonNull
        public List<c.a.a.d.c> a() {
            return this.a;
        }

        @Override // c.a.a.e.f.k
        public boolean b() {
            return true;
        }

        @Override // c.a.a.e.f.k
        @NonNull
        public List<c.a.a.d.b> a(int i2) {
            return this.a.get(i2).getSeconds();
        }

        @Override // c.a.a.e.f.k
        @NonNull
        public List<Void> a(int i2, int i3) {
            return new ArrayList();
        }
    }

    public b(Activity activity) {
        super(activity, new a());
    }
}
