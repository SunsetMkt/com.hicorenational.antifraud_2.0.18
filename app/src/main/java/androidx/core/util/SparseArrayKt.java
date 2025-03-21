package androidx.core.util;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5304u0;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SparseArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a!\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a&\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\f\u001aQ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001a.\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\b¢\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010\u001f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002¢\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006&"}, m23546d2 = {"size", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", "", "key", "containsKey", "containsValue", SurveyH5Bean.VALUE, "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@InterfaceC5816d SparseArray<T> sparseArray, int i2) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsKey(@InterfaceC5816d SparseArray<T> sparseArray, int i2) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsValue(@InterfaceC5816d SparseArray<T> sparseArray, T t) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return sparseArray.indexOfValue(t) != -1;
    }

    public static final <T> void forEach(@InterfaceC5816d SparseArray<T> sparseArray, @InterfaceC5816d InterfaceC5510p<? super Integer, ? super T, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(sparseArray, "$receiver");
        C5544i0.m22546f(interfaceC5510p, "action");
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            interfaceC5510p.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(@InterfaceC5816d SparseArray<T> sparseArray, int i2, T t) {
        C5544i0.m22546f(sparseArray, "$receiver");
        T t2 = sparseArray.get(i2);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(@InterfaceC5816d SparseArray<T> sparseArray, int i2, @InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(sparseArray, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        T t = sparseArray.get(i2);
        return t != null ? t : interfaceC5495a.invoke();
    }

    public static final <T> int getSize(@InterfaceC5816d SparseArray<T> sparseArray) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@InterfaceC5816d SparseArray<T> sparseArray) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@InterfaceC5816d SparseArray<T> sparseArray) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return sparseArray.size() != 0;
    }

    @InterfaceC5816d
    public static final <T> AbstractC5304u0 keyIterator(@InterfaceC5816d final SparseArray<T> sparseArray) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return new AbstractC5304u0() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // p286h.p289g2.AbstractC5304u0
            public int nextInt() {
                SparseArray sparseArray2 = sparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @InterfaceC5816d
    public static final <T> SparseArray<T> plus(@InterfaceC5816d SparseArray<T> sparseArray, @InterfaceC5816d SparseArray<T> sparseArray2) {
        C5544i0.m22546f(sparseArray, "$receiver");
        C5544i0.m22546f(sparseArray2, DispatchConstants.OTHER);
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@InterfaceC5816d SparseArray<T> sparseArray, @InterfaceC5816d SparseArray<T> sparseArray2) {
        C5544i0.m22546f(sparseArray, "$receiver");
        C5544i0.m22546f(sparseArray2, DispatchConstants.OTHER);
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.put(sparseArray2.keyAt(i2), sparseArray2.valueAt(i2));
        }
    }

    public static final <T> boolean remove(@InterfaceC5816d SparseArray<T> sparseArray, int i2, T t) {
        C5544i0.m22546f(sparseArray, "$receiver");
        int indexOfKey = sparseArray.indexOfKey(i2);
        if (indexOfKey == -1 || !C5544i0.m22531a(t, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(@InterfaceC5816d SparseArray<T> sparseArray, int i2, T t) {
        C5544i0.m22546f(sparseArray, "$receiver");
        sparseArray.put(i2, t);
    }

    @InterfaceC5816d
    public static final <T> Iterator<T> valueIterator(@InterfaceC5816d SparseArray<T> sparseArray) {
        C5544i0.m22546f(sparseArray, "$receiver");
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
