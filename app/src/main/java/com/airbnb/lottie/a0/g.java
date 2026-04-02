package com.airbnb.lottie.a0;

import androidx.annotation.Nullable;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* JADX INFO: compiled from: ContentModelParser.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    private static c.a a = c.a.a("ty", "d");

    private g() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c1  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.airbnb.lottie.y.k.b a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        com.airbnb.lottie.y.k.b bVarA;
        String strM;
        cVar.d();
        int iK = 2;
        while (true) {
            bVarA = null;
            if (!cVar.h()) {
                strM = null;
                break;
            }
            int iA = cVar.a(a);
            if (iA == 0) {
                strM = cVar.m();
                break;
            }
            if (iA != 1) {
                cVar.n();
                cVar.o();
            } else {
                iK = cVar.k();
            }
        }
        if (strM == null) {
            return null;
        }
        switch (strM) {
            case "gr":
                bVarA = g0.a(cVar, gVar);
                break;
            case "st":
                bVarA = i0.a(cVar, gVar);
                break;
            case "gs":
                bVarA = n.a(cVar, gVar);
                break;
            case "fl":
                bVarA = f0.a(cVar, gVar);
                break;
            case "gf":
                bVarA = m.a(cVar, gVar);
                break;
            case "tr":
                bVarA = c.a(cVar, gVar);
                break;
            case "sh":
                bVarA = h0.a(cVar, gVar);
                break;
            case "el":
                bVarA = e.a(cVar, gVar, iK);
                break;
            case "rc":
                bVarA = b0.a(cVar, gVar);
                break;
            case "tm":
                bVarA = j0.a(cVar, gVar);
                break;
            case "sr":
                bVarA = a0.a(cVar, gVar);
                break;
            case "mm":
                bVarA = w.a(cVar);
                gVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case "rp":
                bVarA = c0.a(cVar, gVar);
                break;
            default:
                com.airbnb.lottie.b0.d.b("Unknown shape type " + strM);
                break;
        }
        while (cVar.h()) {
            cVar.o();
        }
        cVar.f();
        return bVarA;
    }
}
