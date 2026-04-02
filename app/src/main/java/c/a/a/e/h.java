package c.a.a.e;

import android.app.Activity;
import c.a.a.e.i;
import java.util.List;

/* JADX INFO: compiled from: OptionPicker.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends i<String> {

    /* JADX INFO: compiled from: OptionPicker.java */
    public static abstract class a implements i.b<String> {
        public abstract void b(int i2, String str);

        @Override // c.a.a.e.i.b
        public final void a(int i2, String str) {
            b(i2, str);
        }
    }

    /* JADX INFO: compiled from: OptionPicker.java */
    public interface b extends i.c<String> {
    }

    public h(Activity activity, String[] strArr) {
        super(activity, strArr);
    }

    public void setOnOptionPickListener(a aVar) {
        super.setOnItemPickListener(aVar);
    }

    public void setOnWheelListener(b bVar) {
        super.setOnWheelListener((i.c) bVar);
    }

    public h(Activity activity, List<String> list) {
        super(activity, list);
    }
}
