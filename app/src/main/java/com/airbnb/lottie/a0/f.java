package com.airbnb.lottie.a0;

import android.graphics.Color;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f implements k0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final f f3338a = new f();

    private f() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public Integer a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        boolean z = cVar.peek() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.c();
        }
        double j2 = cVar.j();
        double j3 = cVar.j();
        double j4 = cVar.j();
        double j5 = cVar.peek() == c.b.NUMBER ? cVar.j() : 1.0d;
        if (z) {
            cVar.e();
        }
        if (j2 <= 1.0d && j3 <= 1.0d && j4 <= 1.0d) {
            j2 *= 255.0d;
            j3 *= 255.0d;
            j4 *= 255.0d;
            if (j5 <= 1.0d) {
                j5 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) j5, (int) j2, (int) j3, (int) j4));
    }
}
