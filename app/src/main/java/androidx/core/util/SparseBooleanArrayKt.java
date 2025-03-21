package androidx.core.util;

import android.util.SparseBooleanArray;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5300t;
import p286h.p289g2.AbstractC5304u0;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SparseBooleanArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006 "}, m23546d2 = {"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", "key", "containsKey", "containsValue", SurveyH5Bean.VALUE, "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, int i2) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, int i2) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, boolean z) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.indexOfValue(z) != -1;
    }

    public static final void forEach(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, @InterfaceC5816d InterfaceC5510p<? super Integer, ? super Boolean, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        C5544i0.m22546f(interfaceC5510p, "action");
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            interfaceC5510p.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
        }
    }

    public static final boolean getOrDefault(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.get(i2, z);
    }

    public static final boolean getOrElse(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, int i2, @InterfaceC5816d InterfaceC5495a<Boolean> interfaceC5495a) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        return indexOfKey != -1 ? sparseBooleanArray.valueAt(indexOfKey) : interfaceC5495a.invoke().booleanValue();
    }

    public static final int getSize(@InterfaceC5816d SparseBooleanArray sparseBooleanArray) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@InterfaceC5816d SparseBooleanArray sparseBooleanArray) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(@InterfaceC5816d SparseBooleanArray sparseBooleanArray) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.size() != 0;
    }

    @InterfaceC5816d
    public static final AbstractC5304u0 keyIterator(@InterfaceC5816d final SparseBooleanArray sparseBooleanArray) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return new AbstractC5304u0() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // p286h.p289g2.AbstractC5304u0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @InterfaceC5816d
    public static final SparseBooleanArray plus(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, @InterfaceC5816d SparseBooleanArray sparseBooleanArray2) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        C5544i0.m22546f(sparseBooleanArray2, DispatchConstants.OTHER);
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, @InterfaceC5816d SparseBooleanArray sparseBooleanArray2) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        C5544i0.m22546f(sparseBooleanArray2, DispatchConstants.OTHER);
        int size = sparseBooleanArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i2), sparseBooleanArray2.valueAt(i2));
        }
    }

    public static final boolean remove(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        if (indexOfKey == -1 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i2);
        return true;
    }

    public static final void set(@InterfaceC5816d SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        sparseBooleanArray.put(i2, z);
    }

    @InterfaceC5816d
    public static final AbstractC5300t valueIterator(@InterfaceC5816d final SparseBooleanArray sparseBooleanArray) {
        C5544i0.m22546f(sparseBooleanArray, "$receiver");
        return new AbstractC5300t() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // p286h.p289g2.AbstractC5300t
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
