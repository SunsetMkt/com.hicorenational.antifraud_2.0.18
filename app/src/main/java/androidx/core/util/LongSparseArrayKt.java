package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5307v0;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: LongSparseArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0087\b\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0087\b¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0018\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0002\u001a&\u0010 \u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010!\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010$\u001a\u001e\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'"}, m23546d2 = {"size", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "containsKey", "containsValue", SurveyH5Bean.VALUE, "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(@InterfaceC5816d LongSparseArray<T> longSparseArray, long j2) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return longSparseArray.indexOfKey(j2) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@InterfaceC5816d LongSparseArray<T> longSparseArray, long j2) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return longSparseArray.indexOfKey(j2) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@InterfaceC5816d LongSparseArray<T> longSparseArray, T t) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return longSparseArray.indexOfValue(t) != -1;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@InterfaceC5816d LongSparseArray<T> longSparseArray, @InterfaceC5816d InterfaceC5510p<? super Long, ? super T, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        C5544i0.m22546f(interfaceC5510p, "action");
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            interfaceC5510p.invoke(Long.valueOf(longSparseArray.keyAt(i2)), longSparseArray.valueAt(i2));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@InterfaceC5816d LongSparseArray<T> longSparseArray, long j2, T t) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        T t2 = longSparseArray.get(j2);
        return t2 != null ? t2 : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@InterfaceC5816d LongSparseArray<T> longSparseArray, long j2, @InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        T t = longSparseArray.get(j2);
        return t != null ? t : interfaceC5495a.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(@InterfaceC5816d LongSparseArray<T> longSparseArray) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@InterfaceC5816d LongSparseArray<T> longSparseArray) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@InterfaceC5816d LongSparseArray<T> longSparseArray) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    @InterfaceC5816d
    public static final <T> AbstractC5307v0 keyIterator(@InterfaceC5816d final LongSparseArray<T> longSparseArray) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return new AbstractC5307v0() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // p286h.p289g2.AbstractC5307v0
            public long nextLong() {
                LongSparseArray longSparseArray2 = longSparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return longSparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(16)
    @InterfaceC5816d
    public static final <T> LongSparseArray<T> plus(@InterfaceC5816d LongSparseArray<T> longSparseArray, @InterfaceC5816d LongSparseArray<T> longSparseArray2) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        C5544i0.m22546f(longSparseArray2, DispatchConstants.OTHER);
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@InterfaceC5816d LongSparseArray<T> longSparseArray, @InterfaceC5816d LongSparseArray<T> longSparseArray2) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        C5544i0.m22546f(longSparseArray2, DispatchConstants.OTHER);
        int size = longSparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            longSparseArray.put(longSparseArray2.keyAt(i2), longSparseArray2.valueAt(i2));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(@InterfaceC5816d LongSparseArray<T> longSparseArray, long j2, T t) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        int indexOfKey = longSparseArray.indexOfKey(j2);
        if (indexOfKey == -1 || !C5544i0.m22531a(t, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(@InterfaceC5816d LongSparseArray<T> longSparseArray, long j2, T t) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        longSparseArray.put(j2, t);
    }

    @RequiresApi(16)
    @InterfaceC5816d
    public static final <T> Iterator<T> valueIterator(@InterfaceC5816d LongSparseArray<T> longSparseArray) {
        C5544i0.m22546f(longSparseArray, "$receiver");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
