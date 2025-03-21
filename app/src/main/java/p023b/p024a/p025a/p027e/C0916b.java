package p023b.p024a.p025a.p027e;

import android.app.Activity;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import p023b.p024a.p025a.p026d.C0904b;
import p023b.p024a.p025a.p026d.C0905c;
import p023b.p024a.p025a.p027e.C0920f;

/* compiled from: CarNumberPicker.java */
/* renamed from: b.a.a.e.b */
/* loaded from: classes.dex */
public class C0916b extends C0920f<C0905c, C0904b, Void> {

    /* renamed from: x0 */
    private static final String[] f1392x0 = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新"};

    /* compiled from: CarNumberPicker.java */
    /* renamed from: b.a.a.e.b$a */
    private static class a implements C0920f.k<C0905c, C0904b, Void> {

        /* renamed from: a */
        private List<C0905c> f1393a = new ArrayList();

        a() {
            for (String str : C0916b.f1392x0) {
                this.f1393a.add(new C0905c(str));
            }
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<C0905c> mo850a() {
            return this.f1393a;
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        /* renamed from: b */
        public boolean mo853b() {
            return true;
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<C0904b> mo851a(int i2) {
            return this.f1393a.get(i2).getSeconds();
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<Void> mo852a(int i2, int i3) {
            return new ArrayList();
        }
    }

    public C0916b(Activity activity) {
        super(activity, new a());
    }
}
