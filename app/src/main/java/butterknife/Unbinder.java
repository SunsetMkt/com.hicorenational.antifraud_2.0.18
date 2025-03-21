package butterknife;

import androidx.annotation.UiThread;

/* loaded from: classes.dex */
public interface Unbinder {
    public static final Unbinder EMPTY = new Unbinder() { // from class: butterknife.a
        @Override // butterknife.Unbinder
        public final void unbind() {
            C0944b.m1176a();
        }
    };

    @UiThread
    void unbind();
}
