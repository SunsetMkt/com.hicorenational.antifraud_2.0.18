package p286h.p293j2;

import bean.SurveyH5Bean;
import p286h.InterfaceC5418m;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p304m2.InterfaceC5422b;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ContractBuilder.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, m23546d2 = {"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", SurveyH5Bean.VALUE, "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5347f
@InterfaceC5422b
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.j2.c */
/* loaded from: classes2.dex */
public interface InterfaceC5344c {

    /* compiled from: ContractBuilder.kt */
    /* renamed from: h.j2.c$a */
    public static final class a {
        /* renamed from: a */
        public static /* synthetic */ InterfaceC5342a m21973a(InterfaceC5344c interfaceC5344c, InterfaceC5418m interfaceC5418m, EnumC5348g enumC5348g, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i2 & 2) != 0) {
                enumC5348g = EnumC5348g.UNKNOWN;
            }
            return interfaceC5344c.m21969a(interfaceC5418m, enumC5348g);
        }
    }

    @InterfaceC5422b
    @InterfaceC5816d
    /* renamed from: a */
    <R> InterfaceC5342a m21969a(@InterfaceC5816d InterfaceC5418m<? extends R> interfaceC5418m, @InterfaceC5816d EnumC5348g enumC5348g);

    @InterfaceC5422b
    @InterfaceC5816d
    /* renamed from: a */
    InterfaceC5349h m21970a();

    @InterfaceC5422b
    @InterfaceC5816d
    /* renamed from: a */
    InterfaceC5349h m21971a(@InterfaceC5817e Object obj);

    @InterfaceC5422b
    @InterfaceC5816d
    /* renamed from: b */
    InterfaceC5350i m21972b();
}
