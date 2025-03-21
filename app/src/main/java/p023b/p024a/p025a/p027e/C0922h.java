package p023b.p024a.p025a.p027e;

import android.app.Activity;
import java.util.List;
import p023b.p024a.p025a.p027e.C0923i;

/* compiled from: OptionPicker.java */
/* renamed from: b.a.a.e.h */
/* loaded from: classes.dex */
public class C0922h extends C0923i<String> {

    /* compiled from: OptionPicker.java */
    /* renamed from: b.a.a.e.h$a */
    public static abstract class a implements C0923i.b<String> {
        /* renamed from: b */
        public abstract void mo971b(int i2, String str);

        @Override // p023b.p024a.p025a.p027e.C0923i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final void mo970a(int i2, String str) {
            mo971b(i2, str);
        }
    }

    /* compiled from: OptionPicker.java */
    /* renamed from: b.a.a.e.h$b */
    public interface b extends C0923i.c<String> {
    }

    public C0922h(Activity activity, String[] strArr) {
        super(activity, strArr);
    }

    public void setOnOptionPickListener(a aVar) {
        super.setOnItemPickListener(aVar);
    }

    public void setOnWheelListener(b bVar) {
        super.setOnWheelListener((C0923i.c) bVar);
    }

    public C0922h(Activity activity, List<String> list) {
        super(activity, list);
    }
}
