package p286h.p323z2;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p286h.C5218c1;
import p286h.C5226e1;
import p286h.C5334i0;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5306v;
import p286h.p289g2.C5291q;
import p286h.p289g2.C5294r;
import p286h.p289g2.C5309w;
import p286h.p289g2.C5312x;
import p286h.p289g2.C5318z;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5640i;
import p286h.p319v2.C5642k;
import p286h.p319v2.C5648q;
import p286h.p321x2.C5707u;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Strings.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0086\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\u0087\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\u0087\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\u0087\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, m23546d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", DispatchConstants.OTHER, "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", RequestParameters.PREFIX, "removeRange", "range", "removeSuffix", "removeSurrounding", RequestParameters.DELIMITER, "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/text/StringsKt")
/* renamed from: h.z2.c0 */
/* loaded from: classes2.dex */
public class C5726c0 extends C5724b0 {

    /* compiled from: Strings.kt */
    /* renamed from: h.z2.c0$a */
    public static final class a extends AbstractC5306v {

        /* renamed from: a */
        private int f20670a;

        /* renamed from: b */
        final /* synthetic */ CharSequence f20671b;

        a(CharSequence charSequence) {
            this.f20671b = charSequence;
        }

        @Override // p286h.p289g2.AbstractC5306v
        /* renamed from: b */
        public char mo21708b() {
            CharSequence charSequence = this.f20671b;
            int i2 = this.f20670a;
            this.f20670a = i2 + 1;
            return charSequence.charAt(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20670a < this.f20671b.length();
        }
    }

    /* compiled from: Strings.kt */
    /* renamed from: h.z2.c0$b */
    static final class b extends AbstractC5547j0 implements InterfaceC5510p<CharSequence, Integer, C5334i0<? extends Integer, ? extends Integer>> {
        final /* synthetic */ char[] $delimiters;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(char[] cArr, boolean z) {
            super(2);
            this.$delimiters = cArr;
            this.$ignoreCase = z;
        }

        @InterfaceC5817e
        public final C5334i0<Integer, Integer> invoke(@InterfaceC5816d CharSequence charSequence, int i2) {
            C5544i0.m22546f(charSequence, "$receiver");
            int m23655a = C5726c0.m23655a(charSequence, this.$delimiters, i2, this.$ignoreCase);
            if (m23655a < 0) {
                return null;
            }
            return C5218c1.m18838a(Integer.valueOf(m23655a), 1);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5510p
        public /* bridge */ /* synthetic */ C5334i0<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    /* renamed from: h.z2.c0$c */
    static final class c extends AbstractC5547j0 implements InterfaceC5510p<CharSequence, Integer, C5334i0<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, boolean z) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z;
        }

        @InterfaceC5817e
        public final C5334i0<Integer, Integer> invoke(@InterfaceC5816d CharSequence charSequence, int i2) {
            C5544i0.m22546f(charSequence, "$receiver");
            C5334i0 m23716b = C5726c0.m23716b(charSequence, (Collection<String>) this.$delimitersList, i2, this.$ignoreCase, false);
            if (m23716b != null) {
                return C5218c1.m18838a(m23716b.getFirst(), Integer.valueOf(((String) m23716b.getSecond()).length()));
            }
            return null;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5510p
        public /* bridge */ /* synthetic */ C5334i0<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    /* renamed from: h.z2.c0$d */
    static final class d extends AbstractC5547j0 implements InterfaceC5506l<C5642k, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d C5642k c5642k) {
            C5544i0.m22546f(c5642k, "it");
            return C5726c0.m23759c(this.$this_splitToSequence, c5642k);
        }
    }

    /* compiled from: Strings.kt */
    /* renamed from: h.z2.c0$e */
    static final class e extends AbstractC5547j0 implements InterfaceC5506l<C5642k, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d C5642k c5642k) {
            C5544i0.m22546f(c5642k, "it");
            return C5726c0.m23759c(this.$this_splitToSequence, c5642k);
        }
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final CharSequence m23724b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d InterfaceC5506l<? super Character, Boolean> interfaceC5506l) {
        C5544i0.m22546f(charSequence, "$this$trimEnd");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (interfaceC5506l.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final CharSequence m23756c(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d InterfaceC5506l<? super Character, Boolean> interfaceC5506l) {
        C5544i0.m22546f(charSequence, "$this$trimStart");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!interfaceC5506l.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final boolean m23785d(@InterfaceC5816d CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final boolean m23790e(@InterfaceC5816d CharSequence charSequence) {
        return !C5724b0.m23599a(charSequence);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final boolean m23793f(@InterfaceC5816d CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final boolean m23794g(@InterfaceC5817e CharSequence charSequence) {
        return charSequence == null || C5724b0.m23599a(charSequence);
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final boolean m23795h(@InterfaceC5817e CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    @InterfaceC5816d
    /* renamed from: i */
    public static final AbstractC5306v m23796i(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$this$iterator");
        return new a(charSequence);
    }

    @InterfaceC5816d
    /* renamed from: j */
    public static final InterfaceC5699m<String> m23797j(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$this$lineSequence");
        return m23721b(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    @InterfaceC5816d
    /* renamed from: k */
    public static final List<String> m23798k(@InterfaceC5816d CharSequence charSequence) {
        List<String> m23391L;
        C5544i0.m22546f(charSequence, "$this$lines");
        m23391L = C5707u.m23391L(m23797j(charSequence));
        return m23391L;
    }

    @InterfaceC5816d
    /* renamed from: l */
    public static CharSequence m23799l(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean m23823p = C5727d.m23823p(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!m23823p) {
                    break;
                }
                length--;
            } else if (m23823p) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @InterfaceC5816d
    /* renamed from: m */
    public static final CharSequence m23800m(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$this$trimEnd");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (C5727d.m23823p(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    @InterfaceC5816d
    /* renamed from: n */
    public static final CharSequence m23801n(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$this$trimStart");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!C5727d.m23823p(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @InterfaceC5426f
    /* renamed from: n */
    private static final String m23802n(@InterfaceC5817e String str) {
        return str != null ? str : "";
    }

    @InterfaceC5426f
    /* renamed from: o */
    private static final String m23803o(@InterfaceC5816d String str) {
        if (str != null) {
            return m23799l((CharSequence) str).toString();
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InterfaceC5426f
    /* renamed from: p */
    private static final String m23804p(@InterfaceC5816d String str) {
        if (str != null) {
            return m23800m((CharSequence) str).toString();
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InterfaceC5426f
    /* renamed from: q */
    private static final String m23805q(@InterfaceC5816d String str) {
        if (str != null) {
            return m23801n((CharSequence) str).toString();
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23668a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d InterfaceC5506l<? super Character, Boolean> interfaceC5506l) {
        C5544i0.m22546f(charSequence, "$this$trim");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = interfaceC5506l.invoke(Character.valueOf(charSequence.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    /* renamed from: d */
    public static /* synthetic */ String m23782d(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return m23781d(str, str2, str3);
    }

    /* renamed from: e */
    public static /* synthetic */ String m23789e(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return m23788e(str, str2, str3);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final String m23781d(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$substringBefore");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23654a = m23654a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (m23654a == -1) {
            return str3;
        }
        String substring = str.substring(0, m23654a);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final String m23788e(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$substringBeforeLast");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23711b = m23711b((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (m23711b == -1) {
            return str3;
        }
        String substring = str.substring(0, m23711b);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: b */
    public static /* synthetic */ CharSequence m23723b(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return m23722b(charSequence, i2, c2);
    }

    /* renamed from: c */
    public static final int m23753c(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    /* renamed from: a */
    public static /* synthetic */ CharSequence m23665a(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return m23664a(charSequence, i2, c2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final CharSequence m23722b(@InterfaceC5816d CharSequence charSequence, int i2, char c2) {
        C5544i0.m22546f(charSequence, "$this$padStart");
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            int length = i2 - charSequence.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23759c(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d C5642k c5642k) {
        C5544i0.m22546f(charSequence, "$this$substring");
        C5544i0.m22546f(c5642k, "range");
        return charSequence.subSequence(c5642k.getStart().intValue(), c5642k.getEndInclusive().intValue() + 1).toString();
    }

    /* renamed from: d */
    public static /* synthetic */ String m23778d(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return m23777d(str, c2, str2);
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m23792e(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23791e(charSequence, charSequence2, z);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23664a(@InterfaceC5816d CharSequence charSequence, int i2, char c2) {
        C5544i0.m22546f(charSequence, "$this$padEnd");
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            sb.append(charSequence);
            int length = i2 - charSequence.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    /* renamed from: c */
    public static /* synthetic */ String m23761c(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return m23760c(str, c2, str2);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final String m23777d(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2) {
        C5544i0.m22546f(str, "$this$substringBeforeLast");
        C5544i0.m22546f(str2, "missingDelimiterValue");
        int m23709b = m23709b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (m23709b == -1) {
            return str2;
        }
        String substring = str.substring(0, m23709b);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: e */
    public static final boolean m23791e(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$startsWith");
        C5544i0.m22546f(charSequence2, RequestParameters.PREFIX);
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return C5724b0.m23635d((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return m23751b(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23760c(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2) {
        C5544i0.m22546f(str, "$this$substringBefore");
        C5544i0.m22546f(str2, "missingDelimiterValue");
        int m23650a = m23650a((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (m23650a == -1) {
            return str2;
        }
        String substring = str.substring(0, m23650a);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: d */
    public static /* synthetic */ String m23780d(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return m23779d(str, c2, str2, str3);
    }

    /* renamed from: c */
    public static /* synthetic */ String m23767c(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return m23766c(str, str2, str3);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final String m23779d(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$replaceBeforeLast");
        C5544i0.m22546f(str2, "replacement");
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23709b = m23709b((CharSequence) str, c2, 0, false, 6, (Object) null);
        return m23709b == -1 ? str3 : m23667a((CharSequence) str, 0, m23709b, (CharSequence) str2).toString();
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23766c(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$substringAfterLast");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23711b = m23711b((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (m23711b == -1) {
            return str3;
        }
        String substring = str.substring(m23711b + str2.length(), str.length());
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: d */
    public static /* synthetic */ String m23784d(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return m23783d(str, str2, str3, str4);
    }

    /* renamed from: b */
    public static /* synthetic */ String m23739b(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return m23738b(str, i2, c2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final CharSequence m23757c(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2) {
        C5544i0.m22546f(charSequence, "$this$removeSurrounding");
        C5544i0.m22546f(charSequence2, RequestParameters.DELIMITER);
        return m23672a(charSequence, charSequence2, charSequence2);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final String m23783d(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3, @InterfaceC5816d String str4) {
        C5544i0.m22546f(str, "$this$replaceBeforeLast");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "replacement");
        C5544i0.m22546f(str4, "missingDelimiterValue");
        int m23711b = m23711b((CharSequence) str, str2, 0, false, 6, (Object) null);
        return m23711b == -1 ? str4 : m23667a((CharSequence) str, 0, m23711b, (CharSequence) str3).toString();
    }

    /* renamed from: a */
    public static /* synthetic */ String m23685a(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return m23684a(str, i2, c2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static String m23738b(@InterfaceC5816d String str, int i2, char c2) {
        C5544i0.m22546f(str, "$this$padStart");
        return m23722b((CharSequence) str, i2, c2).toString();
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23765c(@InterfaceC5816d String str, @InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(str, "$this$removeSurrounding");
        C5544i0.m22546f(charSequence, RequestParameters.DELIMITER);
        return m23692a(str, charSequence, charSequence);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23684a(@InterfaceC5816d String str, int i2, char c2) {
        C5544i0.m22546f(str, "$this$padEnd");
        return m23664a((CharSequence) str, i2, c2).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: b */
    private static final <C extends CharSequence & R, R> R m23729b(C c2, InterfaceC5495a<? extends R> interfaceC5495a) {
        return c2.length() == 0 ? interfaceC5495a.invoke() : c2;
    }

    /* renamed from: c */
    public static /* synthetic */ String m23763c(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return m23762c(str, c2, str2, str3);
    }

    /* renamed from: d */
    public static /* synthetic */ boolean m23787d(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23786d(charSequence, charSequence2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <C extends CharSequence & R, R> R m23674a(C c2, InterfaceC5495a<? extends R> interfaceC5495a) {
        return C5724b0.m23599a(c2) ? interfaceC5495a.invoke() : c2;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5642k m23717b(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$this$indices");
        return new C5642k(0, charSequence.length() - 1);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23762c(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$replaceBefore");
        C5544i0.m22546f(str2, "replacement");
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23650a = m23650a((CharSequence) str, c2, 0, false, 6, (Object) null);
        return m23650a == -1 ? str3 : m23667a((CharSequence) str, 0, m23650a, (CharSequence) str2).toString();
    }

    /* renamed from: d */
    public static final boolean m23786d(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$endsWith");
        C5544i0.m22546f(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return C5724b0.m23627b((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return m23751b(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    /* renamed from: a */
    static /* synthetic */ String m23675a(CharSequence charSequence, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = charSequence.length();
        }
        return charSequence.subSequence(i2, i3).toString();
    }

    /* renamed from: b */
    public static final boolean m23750b(@InterfaceC5816d CharSequence charSequence, int i2) {
        C5544i0.m22546f(charSequence, "$this$hasSurrogatePairAt");
        return i2 >= 0 && charSequence.length() + (-2) >= i2 && Character.isHighSurrogate(charSequence.charAt(i2)) && Character.isLowSurrogate(charSequence.charAt(i2 + 1));
    }

    /* renamed from: c */
    public static /* synthetic */ String m23769c(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return m23768c(str, str2, str3, str4);
    }

    /* renamed from: a */
    public static /* synthetic */ String m23681a(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return m23680a(str, c2, str2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23768c(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3, @InterfaceC5816d String str4) {
        C5544i0.m22546f(str, "$this$replaceBefore");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "replacement");
        C5544i0.m22546f(str4, "missingDelimiterValue");
        int m23654a = m23654a((CharSequence) str, str2, 0, false, 6, (Object) null);
        return m23654a == -1 ? str4 : m23667a((CharSequence) str, 0, m23654a, (CharSequence) str3).toString();
    }

    /* renamed from: d */
    public static /* synthetic */ int m23776d(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = m23753c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23775d(charSequence, (Collection<String>) collection, i2, z);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23680a(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2) {
        C5544i0.m22546f(str, "$this$substringAfter");
        C5544i0.m22546f(str2, "missingDelimiterValue");
        int m23650a = m23650a((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (m23650a == -1) {
            return str2;
        }
        String substring = str.substring(m23650a + 1, str.length());
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23741b(@InterfaceC5816d String str, @InterfaceC5816d C5642k c5642k) {
        C5544i0.m22546f(str, "$this$substring");
        C5544i0.m22546f(c5642k, "range");
        String substring = str.substring(c5642k.getStart().intValue(), c5642k.getEndInclusive().intValue() + 1);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: d */
    public static final int m23775d(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d Collection<String> collection, int i2, boolean z) {
        Integer first;
        C5544i0.m22546f(charSequence, "$this$lastIndexOfAny");
        C5544i0.m22546f(collection, "strings");
        C5334i0<Integer, String> m23716b = m23716b(charSequence, collection, i2, z, true);
        if (m23716b == null || (first = m23716b.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final CharSequence m23725b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d C5642k c5642k) {
        C5544i0.m22546f(charSequence, "$this$subSequence");
        C5544i0.m22546f(c5642k, "range");
        return charSequence.subSequence(c5642k.getStart().intValue(), c5642k.getEndInclusive().intValue() + 1);
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m23772c(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23771c(charSequence, c2, z);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23667a(@InterfaceC5816d CharSequence charSequence, int i2, int i3, @InterfaceC5816d CharSequence charSequence2) {
        C5544i0.m22546f(charSequence, "$this$replaceRange");
        C5544i0.m22546f(charSequence2, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i2);
            C5544i0.m22521a((Object) sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i3, charSequence.length());
            C5544i0.m22521a((Object) sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    @InterfaceC5426f
    @InterfaceC5216c(message = "Use parameters named startIndex and endIndex.", replaceWith = @InterfaceC5467o0(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    /* renamed from: b */
    private static final CharSequence m23728b(@InterfaceC5816d String str, int i2, int i3) {
        return str.subSequence(i2, i3);
    }

    /* renamed from: c */
    public static final boolean m23771c(@InterfaceC5816d CharSequence charSequence, char c2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$startsWith");
        return charSequence.length() > 0 && C5729e.m23830a(charSequence.charAt(0), c2, z);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final String m23730b(@InterfaceC5816d CharSequence charSequence, int i2, int i3) {
        return charSequence.subSequence(i2, i3).toString();
    }

    /* renamed from: c */
    public static /* synthetic */ int m23755c(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23754c(charSequence, (Collection<String>) collection, i2, z);
    }

    /* renamed from: b */
    public static /* synthetic */ String m23744b(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return m23743b(str, str2, str3);
    }

    /* renamed from: c */
    public static final int m23754c(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d Collection<String> collection, int i2, boolean z) {
        Integer first;
        C5544i0.m22546f(charSequence, "$this$indexOfAny");
        C5544i0.m22546f(collection, "strings");
        C5334i0<Integer, String> m23716b = m23716b(charSequence, collection, i2, z, false);
        if (m23716b == null || (first = m23716b.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23743b(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$substringAfter");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23654a = m23654a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (m23654a == -1) {
            return str3;
        }
        String substring = str.substring(m23654a + str2.length(), str.length());
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m23774c(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23773c(charSequence, charSequence2, z);
    }

    /* renamed from: c */
    public static final boolean m23773c(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$contains");
        C5544i0.m22546f(charSequence2, DispatchConstants.OTHER);
        if (charSequence2 instanceof String) {
            if (m23654a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (m23652a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23687a(@InterfaceC5816d String str, int i2, int i3, CharSequence charSequence) {
        if (str != null) {
            return m23667a((CharSequence) str, i2, i3, charSequence).toString();
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: b */
    public static /* synthetic */ String m23735b(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return m23734b(str, c2, str2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23670a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d C5642k c5642k, @InterfaceC5816d CharSequence charSequence2) {
        C5544i0.m22546f(charSequence, "$this$replaceRange");
        C5544i0.m22546f(c5642k, "range");
        C5544i0.m22546f(charSequence2, "replacement");
        return m23667a(charSequence, c5642k.getStart().intValue(), c5642k.getEndInclusive().intValue() + 1, charSequence2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static String m23734b(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2) {
        C5544i0.m22546f(str, "$this$substringAfterLast");
        C5544i0.m22546f(str2, "missingDelimiterValue");
        int m23709b = m23709b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (m23709b == -1) {
            return str2;
        }
        String substring = str.substring(m23709b + 1, str.length());
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23690a(@InterfaceC5816d String str, C5642k c5642k, CharSequence charSequence) {
        if (str != null) {
            return m23670a((CharSequence) str, c5642k, charSequence).toString();
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23764c(@InterfaceC5816d String str, @InterfaceC5816d InterfaceC5506l<? super Character, Boolean> interfaceC5506l) {
        CharSequence charSequence;
        C5544i0.m22546f(str, "$this$trimStart");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequence = "";
                break;
            }
            if (!interfaceC5506l.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                charSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequence.toString();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23666a(@InterfaceC5816d CharSequence charSequence, int i2, int i3) {
        C5544i0.m22546f(charSequence, "$this$removeRange");
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
        }
        if (i3 == i2) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i3 - i2));
        sb.append(charSequence, 0, i2);
        C5544i0.m22521a((Object) sb, "this.append(value, startIndex, endIndex)");
        sb.append(charSequence, i3, charSequence.length());
        C5544i0.m22521a((Object) sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final CharSequence m23726b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2) {
        C5544i0.m22546f(charSequence, "$this$removeSuffix");
        C5544i0.m22546f(charSequence2, "suffix");
        if (m23787d(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23742b(@InterfaceC5816d String str, @InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(str, "$this$removeSuffix");
        C5544i0.m22546f(charSequence, "suffix");
        if (!m23787d((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final CharSequence m23758c(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d char... cArr) {
        C5544i0.m22546f(charSequence, "$this$trimStart");
        C5544i0.m22546f(cArr, "chars");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!C5294r.m20983b(cArr, charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23686a(@InterfaceC5816d String str, int i2, int i3) {
        if (str != null) {
            return m23666a((CharSequence) str, i2, i3).toString();
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: b */
    public static /* synthetic */ String m23746b(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return m23745b(str, str2, str3, str4);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23669a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d C5642k c5642k) {
        C5544i0.m22546f(charSequence, "$this$removeRange");
        C5544i0.m22546f(c5642k, "range");
        return m23666a(charSequence, c5642k.getStart().intValue(), c5642k.getEndInclusive().intValue() + 1);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23745b(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3, @InterfaceC5816d String str4) {
        C5544i0.m22546f(str, "$this$replaceAfterLast");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "replacement");
        C5544i0.m22546f(str4, "missingDelimiterValue");
        int m23711b = m23711b((CharSequence) str, str2, 0, false, 6, (Object) null);
        return m23711b == -1 ? str4 : m23667a((CharSequence) str, m23711b + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23689a(@InterfaceC5816d String str, C5642k c5642k) {
        if (str != null) {
            return m23669a((CharSequence) str, c5642k).toString();
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m23770c(@InterfaceC5816d String str, @InterfaceC5816d char... cArr) {
        CharSequence charSequence;
        C5544i0.m22546f(str, "$this$trimStart");
        C5544i0.m22546f(cArr, "chars");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequence = "";
                break;
            }
            if (!C5294r.m20983b(cArr, str.charAt(i2))) {
                charSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequence.toString();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23671a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2) {
        C5544i0.m22546f(charSequence, "$this$removePrefix");
        C5544i0.m22546f(charSequence2, RequestParameters.PREFIX);
        if (m23792e(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    /* renamed from: b */
    public static /* synthetic */ String m23737b(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return m23736b(str, c2, str2, str3);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23736b(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$replaceAfterLast");
        C5544i0.m22546f(str2, "replacement");
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23709b = m23709b((CharSequence) str, c2, 0, false, 6, (Object) null);
        return m23709b == -1 ? str3 : m23667a((CharSequence) str, m23709b + 1, str.length(), (CharSequence) str2).toString();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23691a(@InterfaceC5816d String str, @InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(str, "$this$removePrefix");
        C5544i0.m22546f(charSequence, RequestParameters.PREFIX);
        if (!m23792e((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        C5544i0.m22521a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final String m23731b(@InterfaceC5816d CharSequence charSequence, C5744o c5744o, String str) {
        return c5744o.replaceFirst(charSequence, str);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final boolean m23752b(@InterfaceC5816d CharSequence charSequence, C5744o c5744o) {
        return c5744o.matches(charSequence);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23672a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2, @InterfaceC5816d CharSequence charSequence3) {
        C5544i0.m22546f(charSequence, "$this$removeSurrounding");
        C5544i0.m22546f(charSequence2, RequestParameters.PREFIX);
        C5544i0.m22546f(charSequence3, "suffix");
        if (charSequence.length() >= charSequence2.length() + charSequence3.length() && m23792e(charSequence, charSequence2, false, 2, (Object) null) && m23787d(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    /* renamed from: b */
    public static final boolean m23751b(@InterfaceC5816d CharSequence charSequence, int i2, @InterfaceC5816d CharSequence charSequence2, int i3, int i4, boolean z) {
        C5544i0.m22546f(charSequence, "$this$regionMatchesImpl");
        C5544i0.m22546f(charSequence2, DispatchConstants.OTHER);
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!C5729e.m23830a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m23749b(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23748b(charSequence, c2, z);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23692a(@InterfaceC5816d String str, @InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2) {
        C5544i0.m22546f(str, "$this$removeSurrounding");
        C5544i0.m22546f(charSequence, RequestParameters.PREFIX);
        C5544i0.m22546f(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !m23792e((CharSequence) str, charSequence, false, 2, (Object) null) || !m23787d((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: b */
    public static final boolean m23748b(@InterfaceC5816d CharSequence charSequence, char c2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$endsWith");
        return charSequence.length() > 0 && C5729e.m23830a(charSequence.charAt(m23753c(charSequence)), c2, z);
    }

    /* renamed from: b */
    public static /* synthetic */ String m23733b(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23732b(charSequence, charSequence2, z);
    }

    /* renamed from: a */
    public static /* synthetic */ String m23683a(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return m23682a(str, c2, str2, str3);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23732b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$commonSuffixWith");
        C5544i0.m22546f(charSequence2, DispatchConstants.OTHER);
        int length = charSequence.length();
        int min = Math.min(length, charSequence2.length());
        int i2 = 0;
        while (i2 < min && C5729e.m23830a(charSequence.charAt((length - i2) - 1), charSequence2.charAt((r1 - i2) - 1), z)) {
            i2++;
        }
        if (m23750b(charSequence, (length - i2) - 1) || m23750b(charSequence2, (r1 - i2) - 1)) {
            i2--;
        }
        return charSequence.subSequence(length - i2, length).toString();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23682a(@InterfaceC5816d String str, char c2, @InterfaceC5816d String str2, @InterfaceC5816d String str3) {
        C5544i0.m22546f(str, "$this$replaceAfter");
        C5544i0.m22546f(str2, "replacement");
        C5544i0.m22546f(str3, "missingDelimiterValue");
        int m23650a = m23650a((CharSequence) str, c2, 0, false, 6, (Object) null);
        return m23650a == -1 ? str3 : m23667a((CharSequence) str, m23650a + 1, str.length(), (CharSequence) str2).toString();
    }

    /* renamed from: a */
    public static /* synthetic */ String m23694a(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return m23693a(str, str2, str3, str4);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23693a(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3, @InterfaceC5816d String str4) {
        C5544i0.m22546f(str, "$this$replaceAfter");
        C5544i0.m22546f(str2, RequestParameters.DELIMITER);
        C5544i0.m22546f(str3, "replacement");
        C5544i0.m22546f(str4, "missingDelimiterValue");
        int m23654a = m23654a((CharSequence) str, str2, 0, false, 6, (Object) null);
        return m23654a == -1 ? str4 : m23667a((CharSequence) str, m23654a + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23677a(@InterfaceC5816d CharSequence charSequence, C5744o c5744o, String str) {
        return c5744o.replace(charSequence, str);
    }

    /* renamed from: b */
    public static /* synthetic */ int m23713b(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = m23753c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23712b(charSequence, cArr, i2, z);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23676a(@InterfaceC5816d CharSequence charSequence, C5744o c5744o, InterfaceC5506l<? super InterfaceC5742m, ? extends CharSequence> interfaceC5506l) {
        return c5744o.replace(charSequence, interfaceC5506l);
    }

    /* renamed from: b */
    public static final int m23712b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d char[] cArr, int i2, boolean z) {
        int m23101b;
        char m20461E;
        C5544i0.m22546f(charSequence, "$this$lastIndexOfAny");
        C5544i0.m22546f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            m20461E = C5294r.m20461E(cArr);
            return ((String) charSequence).lastIndexOf(m20461E, i2);
        }
        for (m23101b = C5648q.m23101b(i2, m23753c(charSequence)); m23101b >= 0; m23101b--) {
            char charAt = charSequence.charAt(m23101b);
            int length = cArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (C5729e.m23830a(cArr[i3], charAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return m23101b;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m23707a(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23706a(charSequence, charSequence2, i2, z);
    }

    /* renamed from: a */
    public static final boolean m23706a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2, int i2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$startsWith");
        C5544i0.m22546f(charSequence2, RequestParameters.PREFIX);
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return C5724b0.m23606a((String) charSequence, (String) charSequence2, i2, false, 4, (Object) null);
        }
        return m23751b(charSequence, i2, charSequence2, 0, charSequence2.length(), z);
    }

    /* renamed from: a */
    public static /* synthetic */ String m23679a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23678a(charSequence, charSequence2, z);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23678a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d CharSequence charSequence2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$commonPrefixWith");
        C5544i0.m22546f(charSequence2, DispatchConstants.OTHER);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < min && C5729e.m23830a(charSequence.charAt(i2), charSequence2.charAt(i2), z)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (m23750b(charSequence, i3) || m23750b(charSequence2, i3)) {
            i2--;
        }
        return charSequence.subSequence(0, i2).toString();
    }

    /* renamed from: b */
    public static final C5334i0<Integer, String> m23716b(@InterfaceC5816d CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        int m23101b;
        C5640i m23137c;
        Object obj;
        Object obj2;
        int m23050a;
        if (!z && collection.size() == 1) {
            String str = (String) C5309w.m21709C(collection);
            int m23654a = !z2 ? m23654a(charSequence, str, i2, false, 4, (Object) null) : m23711b(charSequence, str, i2, false, 4, (Object) null);
            if (m23654a < 0) {
                return null;
            }
            return C5218c1.m18838a(Integer.valueOf(m23654a), str);
        }
        if (z2) {
            m23101b = C5648q.m23101b(i2, m23753c(charSequence));
            m23137c = C5648q.m23137c(m23101b, 0);
        } else {
            m23050a = C5648q.m23050a(i2, 0);
            m23137c = new C5642k(m23050a, charSequence.length());
        }
        if (charSequence instanceof String) {
            int first = m23137c.getFirst();
            int last = m23137c.getLast();
            int m23021b = m23137c.m23021b();
            if (m23021b < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (C5724b0.m23602a(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += m23021b;
                    } else {
                        return C5218c1.m18838a(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = m23137c.getFirst();
            int last2 = m23137c.getLast();
            int m23021b2 = m23137c.m23021b();
            if (m23021b2 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (m23751b(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += m23021b2;
                    } else {
                        return C5218c1.m18838a(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static /* synthetic */ int m23656a(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23655a(charSequence, cArr, i2, z);
    }

    /* renamed from: a */
    public static final int m23655a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d char[] cArr, int i2, boolean z) {
        int m23050a;
        boolean z2;
        char m20461E;
        C5544i0.m22546f(charSequence, "$this$indexOfAny");
        C5544i0.m22546f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            m20461E = C5294r.m20461E(cArr);
            return ((String) charSequence).indexOf(m20461E, i2);
        }
        m23050a = C5648q.m23050a(i2, 0);
        int m23753c = m23753c(charSequence);
        if (m23050a > m23753c) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(m23050a);
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (C5729e.m23830a(cArr[i3], charAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return m23050a;
            }
            if (m23050a == m23753c) {
                return -1;
            }
            m23050a++;
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m23652a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return m23651a(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    /* renamed from: a */
    private static final int m23651a(@InterfaceC5816d CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        int m23101b;
        int m23050a;
        C5640i m23137c;
        int m23050a2;
        int m23101b2;
        if (!z2) {
            m23050a2 = C5648q.m23050a(i2, 0);
            m23101b2 = C5648q.m23101b(i3, charSequence.length());
            m23137c = new C5642k(m23050a2, m23101b2);
        } else {
            m23101b = C5648q.m23101b(i2, m23753c(charSequence));
            m23050a = C5648q.m23050a(i3, 0);
            m23137c = C5648q.m23137c(m23101b, m23050a);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = m23137c.getFirst();
            int last = m23137c.getLast();
            int m23021b = m23137c.m23021b();
            if (m23021b >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!C5724b0.m23602a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += m23021b;
            }
            return first;
        }
        int first2 = m23137c.getFirst();
        int last2 = m23137c.getLast();
        int m23021b2 = m23137c.m23021b();
        if (m23021b2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!m23751b(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += m23021b2;
        }
        return first2;
    }

    /* renamed from: b */
    public static /* synthetic */ C5334i0 m23715b(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = m23753c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23714b(charSequence, (Collection<String>) collection, i2, z);
    }

    @InterfaceC5817e
    /* renamed from: b */
    public static final C5334i0<Integer, String> m23714b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d Collection<String> collection, int i2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$findLastAnyOf");
        C5544i0.m22546f(collection, "strings");
        return m23716b(charSequence, collection, i2, z, true);
    }

    /* renamed from: b */
    public static /* synthetic */ int m23709b(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = m23753c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23708b(charSequence, c2, i2, z);
    }

    /* renamed from: b */
    public static final int m23708b(@InterfaceC5816d CharSequence charSequence, char c2, int i2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return m23712b(charSequence, new char[]{c2}, i2, z);
    }

    /* renamed from: a */
    public static /* synthetic */ C5334i0 m23658a(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23657a(charSequence, (Collection<String>) collection, i2, z);
    }

    @InterfaceC5817e
    /* renamed from: a */
    public static final C5334i0<Integer, String> m23657a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d Collection<String> collection, int i2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$findAnyOf");
        C5544i0.m22546f(collection, "strings");
        return m23716b(charSequence, collection, i2, z, false);
    }

    /* renamed from: b */
    public static /* synthetic */ int m23711b(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = m23753c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23710b(charSequence, str, i2, z);
    }

    /* renamed from: a */
    public static /* synthetic */ int m23650a(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23649a(charSequence, c2, i2, z);
    }

    /* renamed from: b */
    public static final int m23710b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d String str, int i2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$lastIndexOf");
        C5544i0.m22546f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return m23651a(charSequence, (CharSequence) str, i2, 0, z, true);
    }

    /* renamed from: a */
    public static final int m23649a(@InterfaceC5816d CharSequence charSequence, char c2, int i2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return m23655a(charSequence, new char[]{c2}, i2, z);
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC5699m m23721b(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return m23720b(charSequence, strArr, z, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ int m23654a(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23653a(charSequence, str, i2, z);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final InterfaceC5699m<String> m23720b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d String[] strArr, boolean z, int i2) {
        C5544i0.m22546f(charSequence, "$this$splitToSequence");
        C5544i0.m22546f(strArr, "delimiters");
        return C5707u.m23502w(m23663a(charSequence, strArr, 0, z, i2, 2, (Object) null), new d(charSequence));
    }

    /* renamed from: a */
    public static final int m23653a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d String str, int i2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$indexOf");
        C5544i0.m22546f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return m23652a(charSequence, (CharSequence) str, i2, charSequence.length(), z, false, 16, (Object) null);
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC5699m m23719b(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return m23718b(charSequence, cArr, z, i2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final InterfaceC5699m<String> m23718b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d char[] cArr, boolean z, int i2) {
        C5544i0.m22546f(charSequence, "$this$splitToSequence");
        C5544i0.m22546f(cArr, "delimiters");
        return C5707u.m23502w(m23661a(charSequence, cArr, 0, z, i2, 2, (Object) null), new e(charSequence));
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23740b(@InterfaceC5816d String str, @InterfaceC5816d InterfaceC5506l<? super Character, Boolean> interfaceC5506l) {
        CharSequence charSequence;
        C5544i0.m22546f(str, "$this$trimEnd");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            }
            if (!interfaceC5506l.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                charSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m23704a(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23703a(charSequence, c2, z);
    }

    /* renamed from: a */
    public static final boolean m23703a(@InterfaceC5816d CharSequence charSequence, char c2, boolean z) {
        C5544i0.m22546f(charSequence, "$this$contains");
        return m23650a(charSequence, c2, 0, z, 2, (Object) null) >= 0;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final boolean m23705a(@InterfaceC5816d CharSequence charSequence, C5744o c5744o) {
        C5544i0.m22546f(charSequence, "$this$contains");
        return c5744o.containsMatchIn(charSequence);
    }

    /* renamed from: a */
    static /* synthetic */ InterfaceC5699m m23661a(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return m23660a(charSequence, cArr, i2, z, i3);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final CharSequence m23727b(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d char... cArr) {
        C5544i0.m22546f(charSequence, "$this$trimEnd");
        C5544i0.m22546f(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (C5294r.m20983b(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    /* renamed from: a */
    private static final InterfaceC5699m<C5642k> m23660a(@InterfaceC5816d CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new C5735h(charSequence, i2, i3, new b(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    /* renamed from: a */
    static /* synthetic */ InterfaceC5699m m23663a(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return m23662a(charSequence, strArr, i2, z, i3);
    }

    /* renamed from: a */
    private static final InterfaceC5699m<C5642k> m23662a(@InterfaceC5816d CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new C5735h(charSequence, i2, i3, new c(C5291q.m20317d((Object[]) strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23747b(@InterfaceC5816d String str, @InterfaceC5816d char... cArr) {
        CharSequence charSequence;
        C5544i0.m22546f(str, "$this$trimEnd");
        C5544i0.m22546f(cArr, "chars");
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            }
            if (!C5294r.m20983b(cArr, str.charAt(length))) {
                charSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: a */
    public static /* synthetic */ List m23702a(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return m23701a(charSequence, strArr, z, i2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<String> m23701a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d String[] strArr, boolean z, int i2) {
        Iterable m23470g;
        C5544i0.m22546f(charSequence, "$this$split");
        C5544i0.m22546f(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return m23698a(charSequence, str, z, i2);
            }
        }
        m23470g = C5707u.m23470g(m23663a(charSequence, strArr, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(C5318z.m21796a(m23470g, 10));
        Iterator it = m23470g.iterator();
        while (it.hasNext()) {
            arrayList.add(m23759c(charSequence, (C5642k) it.next()));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static /* synthetic */ List m23700a(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return m23699a(charSequence, cArr, z, i2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<String> m23699a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d char[] cArr, boolean z, int i2) {
        Iterable m23470g;
        C5544i0.m22546f(charSequence, "$this$split");
        C5544i0.m22546f(cArr, "delimiters");
        if (cArr.length == 1) {
            return m23698a(charSequence, String.valueOf(cArr[0]), z, i2);
        }
        m23470g = C5707u.m23470g(m23661a(charSequence, cArr, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(C5318z.m21796a(m23470g, 10));
        Iterator it = m23470g.iterator();
        while (it.hasNext()) {
            arrayList.add(m23759c(charSequence, (C5642k) it.next()));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static final List<String> m23698a(@InterfaceC5816d CharSequence charSequence, String str, boolean z, int i2) {
        int i3 = 0;
        if (i2 >= 0) {
            int m23653a = m23653a(charSequence, str, 0, z);
            if (m23653a != -1 && i2 != 1) {
                boolean z2 = i2 > 0;
                ArrayList arrayList = new ArrayList(z2 ? C5648q.m23101b(i2, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(i3, m23653a).toString());
                    i3 = str.length() + m23653a;
                    if (z2 && arrayList.size() == i2 - 1) {
                        break;
                    }
                    m23653a = m23653a(charSequence, str, i3, z);
                } while (m23653a != -1);
                arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
                return arrayList;
            }
            return C5312x.m21750a(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final List<String> m23696a(@InterfaceC5816d CharSequence charSequence, C5744o c5744o, int i2) {
        return c5744o.split(charSequence, i2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23688a(@InterfaceC5816d String str, @InterfaceC5816d InterfaceC5506l<? super Character, Boolean> interfaceC5506l) {
        C5544i0.m22546f(str, "$this$trim");
        C5544i0.m22546f(interfaceC5506l, "predicate");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = interfaceC5506l.invoke(Character.valueOf(str.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final CharSequence m23673a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d char... cArr) {
        C5544i0.m22546f(charSequence, "$this$trim");
        C5544i0.m22546f(cArr, "chars");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean m20983b = C5294r.m20983b(cArr, charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!m20983b) {
                    break;
                }
                length--;
            } else if (m20983b) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23695a(@InterfaceC5816d String str, @InterfaceC5816d char... cArr) {
        C5544i0.m22546f(str, "$this$trim");
        C5544i0.m22546f(cArr, "chars");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean m20983b = C5294r.m20983b(cArr, str.charAt(!z ? i2 : length));
            if (z) {
                if (!m20983b) {
                    break;
                }
                length--;
            } else if (m20983b) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    /* renamed from: a */
    static /* synthetic */ List m23697a(CharSequence charSequence, C5744o c5744o, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return c5744o.split(charSequence, i2);
    }
}
