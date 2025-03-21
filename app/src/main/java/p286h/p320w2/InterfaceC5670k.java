package p286h.p320w2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p320w2.InterfaceC5667h;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: KProperty.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001\u0010J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u000fR$\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, m23546d2 = {"Lkotlin/reflect/KMutableProperty2;", "D", ExifInterface.LONGITUDE_EAST, "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty2$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty2$Setter;", "set", "", "receiver1", "receiver2", SurveyH5Bean.VALUE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.w2.k */
/* loaded from: classes2.dex */
public interface InterfaceC5670k<D, E, R> extends InterfaceC5675p<D, E, R>, InterfaceC5667h<R> {

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.k$a */
    public interface a<D, E, R> extends InterfaceC5667h.a<R>, InterfaceC5511q<D, E, R, C5715y1> {
    }

    @Override // p286h.p320w2.InterfaceC5667h
    @InterfaceC5816d
    a<D, E, R> getSetter();

    void set(D d2, E e2, R r);
}
