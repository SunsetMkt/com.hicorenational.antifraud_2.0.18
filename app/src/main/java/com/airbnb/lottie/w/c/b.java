package com.airbnb.lottie.w.c;

import java.util.List;

/* JADX INFO: compiled from: ColorKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.c0.a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.w.c.a
    /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<Integer>) aVar, f2);
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
    public int b(com.airbnb.lottie.c0.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f2111b;
        if (num2 == null || aVar.f2112c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = aVar.f2112c.intValue();
        com.airbnb.lottie.c0.j<A> jVar = this.f2350e;
        return (jVar == 0 || (num = (Integer) jVar.a(aVar.f2116g, aVar.f2117h.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f2, d(), e())) == null) ? com.airbnb.lottie.b0.b.a(com.airbnb.lottie.b0.g.a(f2, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    public int i() {
        return b(a(), c());
    }

    @Override // com.airbnb.lottie.w.c.a
    Integer a(com.airbnb.lottie.c0.a<Integer> aVar, float f2) {
        return Integer.valueOf(b(aVar, f2));
    }
}
