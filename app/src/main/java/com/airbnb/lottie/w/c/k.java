package com.airbnb.lottie.w.c;

import java.util.List;

/* JADX INFO: compiled from: ScaleKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends f<com.airbnb.lottie.c0.k> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.c0.k f2366i;

    public k(List<com.airbnb.lottie.c0.a<com.airbnb.lottie.c0.k>> list) {
        super(list);
        this.f2366i = new com.airbnb.lottie.c0.k();
    }

    @Override // com.airbnb.lottie.w.c.a
    public /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.c0.a aVar, float f2) {
        return a((com.airbnb.lottie.c0.a<com.airbnb.lottie.c0.k>) aVar, f2);
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
    public com.airbnb.lottie.c0.k a(com.airbnb.lottie.c0.a<com.airbnb.lottie.c0.k> aVar, float f2) {
        com.airbnb.lottie.c0.k kVar;
        com.airbnb.lottie.c0.k kVar2;
        com.airbnb.lottie.c0.k kVar3 = aVar.f2111b;
        if (kVar3 == null || (kVar = aVar.f2112c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.c0.k kVar4 = kVar3;
        com.airbnb.lottie.c0.k kVar5 = kVar;
        com.airbnb.lottie.c0.j<A> jVar = this.f2350e;
        if (jVar != 0 && (kVar2 = (com.airbnb.lottie.c0.k) jVar.a(aVar.f2116g, aVar.f2117h.floatValue(), kVar4, kVar5, f2, d(), e())) != null) {
            return kVar2;
        }
        this.f2366i.b(com.airbnb.lottie.b0.g.c(kVar4.a(), kVar5.a(), f2), com.airbnb.lottie.b0.g.c(kVar4.b(), kVar5.b(), f2));
        return this.f2366i;
    }
}
