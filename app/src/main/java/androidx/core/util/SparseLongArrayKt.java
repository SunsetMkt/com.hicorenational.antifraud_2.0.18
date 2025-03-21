package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5304u0;
import p286h.p289g2.AbstractC5307v0;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SparseLongArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0087\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0087\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, m23546d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", SurveyH5Bean.VALUE, "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@InterfaceC5816d SparseLongArray sparseLongArray, int i2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@InterfaceC5816d SparseLongArray sparseLongArray, int i2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@InterfaceC5816d SparseLongArray sparseLongArray, long j2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return sparseLongArray.indexOfValue(j2) != -1;
    }

    @RequiresApi(18)
    public static final void forEach(@InterfaceC5816d SparseLongArray sparseLongArray, @InterfaceC5816d InterfaceC5510p<? super Integer, ? super Long, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        C5544i0.m22546f(interfaceC5510p, "action");
        int size = sparseLongArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            interfaceC5510p.invoke(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@InterfaceC5816d SparseLongArray sparseLongArray, int i2, long j2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return sparseLongArray.get(i2, j2);
    }

    @RequiresApi(18)
    public static final long getOrElse(@InterfaceC5816d SparseLongArray sparseLongArray, int i2, @InterfaceC5816d InterfaceC5495a<Long> interfaceC5495a) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        return indexOfKey != -1 ? sparseLongArray.valueAt(indexOfKey) : interfaceC5495a.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@InterfaceC5816d SparseLongArray sparseLongArray) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@InterfaceC5816d SparseLongArray sparseLongArray) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@InterfaceC5816d SparseLongArray sparseLongArray) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    @InterfaceC5816d
    public static final AbstractC5304u0 keyIterator(@InterfaceC5816d final SparseLongArray sparseLongArray) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return new AbstractC5304u0() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // p286h.p289g2.AbstractC5304u0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(18)
    @InterfaceC5816d
    public static final SparseLongArray plus(@InterfaceC5816d SparseLongArray sparseLongArray, @InterfaceC5816d SparseLongArray sparseLongArray2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        C5544i0.m22546f(sparseLongArray2, DispatchConstants.OTHER);
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(@InterfaceC5816d SparseLongArray sparseLongArray, @InterfaceC5816d SparseLongArray sparseLongArray2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        C5544i0.m22546f(sparseLongArray2, DispatchConstants.OTHER);
        int size = sparseLongArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i2), sparseLongArray2.valueAt(i2));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@InterfaceC5816d SparseLongArray sparseLongArray, int i2, long j2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        if (indexOfKey == -1 || j2 != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(@InterfaceC5816d SparseLongArray sparseLongArray, int i2, long j2) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        sparseLongArray.put(i2, j2);
    }

    @RequiresApi(18)
    @InterfaceC5816d
    public static final AbstractC5307v0 valueIterator(@InterfaceC5816d final SparseLongArray sparseLongArray) {
        C5544i0.m22546f(sparseLongArray, "$receiver");
        return new AbstractC5307v0() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // p286h.p289g2.AbstractC5307v0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
