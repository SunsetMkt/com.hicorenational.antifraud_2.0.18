package com.lxj.easyadapter;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.accs.utl.BaseMonitor;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: EasyAdapter.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0006H$¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m23546d2 = {"Lcom/lxj/easyadapter/EasyAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lxj/easyadapter/MultiItemTypeAdapter;", "data", "", "mLayoutId", "", "(Ljava/util/List;I)V", "getMLayoutId", "()I", "setMLayoutId", "(I)V", BaseMonitor.ALARM_POINT_BIND, "", "holder", "Lcom/lxj/easyadapter/ViewHolder;", "t", "position", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;I)V", "easy-adapter_release"}, m23547k = 1, m23548mv = {1, 1, 13})
/* loaded from: classes.dex */
public abstract class EasyAdapter<T> extends MultiItemTypeAdapter<T> {

    /* renamed from: i */
    private int f8478i;

    /* compiled from: EasyAdapter.kt */
    /* renamed from: com.lxj.easyadapter.EasyAdapter$a */
    public static final class C2746a implements InterfaceC2756b<T> {
        C2746a() {
        }

        @Override // com.lxj.easyadapter.InterfaceC2756b
        /* renamed from: a */
        public int mo8203a() {
            return EasyAdapter.this.m8202g();
        }

        @Override // com.lxj.easyadapter.InterfaceC2756b
        /* renamed from: a */
        public boolean mo8205a(T t, int i2) {
            return true;
        }

        @Override // com.lxj.easyadapter.InterfaceC2756b
        /* renamed from: a */
        public void mo8204a(@InterfaceC5816d ViewHolder viewHolder, T t, int i2) {
            C5544i0.m22546f(viewHolder, "holder");
            EasyAdapter.this.mo8200a(viewHolder, (ViewHolder) t, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasyAdapter(@InterfaceC5816d List<? extends T> list, int i2) {
        super(list);
        C5544i0.m22546f(list, "data");
        this.f8478i = i2;
        m8212a(new C2746a());
    }

    /* renamed from: a */
    protected abstract void mo8200a(@InterfaceC5816d ViewHolder viewHolder, T t, int i2);

    /* renamed from: b */
    protected final void m8201b(int i2) {
        this.f8478i = i2;
    }

    /* renamed from: g */
    protected final int m8202g() {
        return this.f8478i;
    }
}
