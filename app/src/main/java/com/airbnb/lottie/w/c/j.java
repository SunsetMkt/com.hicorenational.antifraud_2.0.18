package com.airbnb.lottie.w.c;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: PointKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends f<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f2365i;

    public j(List<com.airbnb.lottie.c0.a<PointF>> list) {
        super(list);
        this.f2365i = new PointF();
    }

    @Override // com.airbnb.lottie.w.c.a
    public /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<PointF>) aVar, f2);
    }

    @Override // com.airbnb.lottie.w.c.a
    protected /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2, float f3, float f4) {
        return a((com.airbnb.lottie.c0.a<PointF>) aVar, f2, f3, f4);
    }

    @Override // com.airbnb.lottie.w.c.a
    public PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2) {
        return a(aVar, f2, f2, f2);
    }

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
    protected PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2, float f3, float f4) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f2111b;
        if (pointF3 != null && (pointF = aVar.f2112c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            com.airbnb.lottie.c0.j<A> jVar = this.f2350e;
            if (jVar != 0 && (pointF2 = (PointF) jVar.a(aVar.f2116g, aVar.f2117h.floatValue(), pointF4, pointF5, f2, d(), e())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f2365i;
            float f5 = pointF4.x;
            float f6 = f5 + (f3 * (pointF5.x - f5));
            float f7 = pointF4.y;
            pointF6.set(f6, f7 + (f4 * (pointF5.y - f7)));
            return this.f2365i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
