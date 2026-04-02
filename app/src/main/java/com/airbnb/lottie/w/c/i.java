package com.airbnb.lottie.w.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: PathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends f<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f2361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f2362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PathMeasure f2363k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private h f2364l;

    public i(List<? extends com.airbnb.lottie.c0.a<PointF>> list) {
        super(list);
        this.f2361i = new PointF();
        this.f2362j = new float[2];
        this.f2363k = new PathMeasure();
    }

    @Override // com.airbnb.lottie.w.c.a
    public /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<PointF>) aVar, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.airbnb.lottie.w.c.a
    public PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path pathI = hVar.i();
        if (pathI == null) {
            return aVar.f2111b;
        }
        com.airbnb.lottie.c0.j<A> jVar = this.f2350e;
        if (jVar != 0 && (pointF = (PointF) jVar.a(hVar.f2116g, hVar.f2117h.floatValue(), hVar.f2111b, hVar.f2112c, d(), f2, e())) != null) {
            return pointF;
        }
        if (this.f2364l != hVar) {
            this.f2363k.setPath(pathI, false);
            this.f2364l = hVar;
        }
        PathMeasure pathMeasure = this.f2363k;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f2362j, null);
        PointF pointF2 = this.f2361i;
        float[] fArr = this.f2362j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f2361i;
    }
}
