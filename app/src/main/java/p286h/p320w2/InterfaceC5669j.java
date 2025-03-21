package p286h.p320w2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.tencent.open.SocialConstants;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p320w2.InterfaceC5667h;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: KProperty.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u000eJ\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\rR\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, m23546d2 = {"Lkotlin/reflect/KMutableProperty1;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty1$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty1$Setter;", "set", "", SocialConstants.PARAM_RECEIVER, SurveyH5Bean.VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.w2.j */
/* loaded from: classes2.dex */
public interface InterfaceC5669j<T, R> extends InterfaceC5674o<T, R>, InterfaceC5667h<R> {

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.j$a */
    public interface a<T, R> extends InterfaceC5667h.a<R>, InterfaceC5510p<T, R, C5715y1> {
    }

    @Override // p286h.p320w2.InterfaceC5667h
    @InterfaceC5816d
    a<T, R> getSetter();

    void set(T t, R r);
}
