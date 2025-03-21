package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;
import p286h.C5226e1;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p304m2.C5432l;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _ArraysJvm.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\b\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\n\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\f\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u000e\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u0010\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u0012\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0014\u001aU\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001c\u001a9\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001d\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a2\u0010\u001e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\f¢\u0006\u0004\b \u0010!\u001a\"\u0010\"\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0004\b'\u0010(\u001a0\u0010)\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\f¢\u0006\u0002\u0010!\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0087\f\u001a \u0010*\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u0010$\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0006H\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\bH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\nH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\fH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u000eH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0010H\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0012H\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0014H\u0087\b\u001a \u0010+\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u0010(\u001a\r\u0010+\u001a\u00020&*\u00020\u0006H\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\bH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\nH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\fH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u000eH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0010H\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0012H\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0014H\u0087\b\u001aQ\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007¢\u0006\u0002\u00101\u001a2\u0010,\u001a\u00020\u0006*\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\b*\u00020\b2\u0006\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\f*\u00020\f2\u0006\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0010*\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0012*\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0014*\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a$\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u00103\u001a.\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u00104\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\u00105\u001a\r\u00102\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0006*\u00020\u00062\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\b*\u00020\bH\u0087\b\u001a\u0015\u00102\u001a\u00020\b*\u00020\b2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\n*\u00020\nH\u0087\b\u001a\u0015\u00102\u001a\u00020\n*\u00020\n2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\f*\u00020\fH\u0087\b\u001a\u0015\u00102\u001a\u00020\f*\u00020\f2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u000e*\u00020\u000eH\u0087\b\u001a\u0015\u00102\u001a\u00020\u000e*\u00020\u000e2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u0010*\u00020\u0010H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0010*\u00020\u00102\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u0012*\u00020\u0012H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0012*\u00020\u00122\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u0014*\u00020\u0014H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0014*\u00020\u00142\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a6\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b7\u00108\u001a\"\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a5\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0004\b6\u00108\u001a!\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a(\u0010:\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010;\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\u0010<\u001a\u0015\u0010:\u001a\u00020\u0005*\u00020\u00062\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0007*\u00020\b2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\t*\u00020\n2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u000b*\u00020\f2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\r*\u00020\u000e2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u000f*\u00020\u00102\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0011*\u00020\u00122\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0013*\u00020\u00142\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a7\u0010=\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010?\u001a&\u0010=\u001a\u00020>*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a-\u0010@\u001a\b\u0012\u0004\u0012\u0002HA0\u0001\"\u0004\b\u0000\u0010A*\u0006\u0012\u0002\b\u00030\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0C¢\u0006\u0002\u0010D\u001aA\u0010E\u001a\u0002HF\"\u0010\b\u0000\u0010F*\n\u0012\u0006\b\u0000\u0012\u0002HA0G\"\u0004\b\u0001\u0010A*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010-\u001a\u0002HF2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0C¢\u0006\u0002\u0010H\u001a,\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010J\u001a4\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0086\u0002¢\u0006\u0002\u0010L\u001a2\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u00020MH\u0086\u0002¢\u0006\u0002\u0010N\u001a\u0015\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0005H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0006*\u00020\u00062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\b*\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\b*\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\n*\u00020\n2\u0006\u0010\u0016\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\n*\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\f*\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\f*\u00020\f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010K\u001a\u00020\u000eH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u000e*\u00020\u000e2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\r0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000fH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0010*\u00020\u00102\u0006\u0010K\u001a\u00020\u0010H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0010*\u00020\u00102\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0011H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0012*\u00020\u00122\u0006\u0010K\u001a\u00020\u0012H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0012*\u00020\u00122\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0013H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0014*\u00020\u00142\u0006\u0010K\u001a\u00020\u0014H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0014*\u00020\u00142\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130MH\u0086\u0002\u001a,\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010J\u001a\u001d\u0010P\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010Q\u001a*\u0010P\u001a\u00020>\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020R*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u0010S\u001a1\u0010P\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010T\u001a\n\u0010P\u001a\u00020>*\u00020\b\u001a\u001e\u0010P\u001a\u00020>*\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\n\u001a\u001e\u0010P\u001a\u00020>*\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\f\u001a\u001e\u0010P\u001a\u00020>*\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u000e\u001a\u001e\u0010P\u001a\u00020>*\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0010\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0012\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0014\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a9\u0010U\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010V\u001aM\u0010U\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010W\u001a-\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u00020Y\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020R*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010Z\u001a?\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u00020Y\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010[\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050Y*\u00020\u0006\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00070Y*\u00020\b\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0Y*\u00020\n\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0Y*\u00020\f\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0Y*\u00020\u000e\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0Y*\u00020\u0010\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00110Y*\u00020\u0012\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00130Y*\u00020\u0014\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u0006¢\u0006\u0002\u0010]\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\b¢\u0006\u0002\u0010^\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\n¢\u0006\u0002\u0010_\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003*\u00020\f¢\u0006\u0002\u0010`\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\r0\u0003*\u00020\u000e¢\u0006\u0002\u0010a\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003*\u00020\u0010¢\u0006\u0002\u0010b\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\u0012¢\u0006\u0002\u0010c\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003*\u00020\u0014¢\u0006\u0002\u0010d¨\u0006e"}, m23546d2 = {"asList", "", ExifInterface.GPS_DIRECTION_TRUE, "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", DispatchConstants.OTHER, "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentEquals", "contentHashCode", "contentToString", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/collections/ArraysKt")
/* renamed from: h.g2.q */
/* loaded from: classes2.dex */
public class C5291q extends C5288p {

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$a */
    public static final class a extends AbstractC5252d<Byte> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ byte[] f20150a;

        a(byte[] bArr) {
            this.f20150a = bArr;
        }

        /* renamed from: a */
        public boolean m20356a(byte b2) {
            return C5294r.m20980b(this.f20150a, b2);
        }

        /* renamed from: b */
        public int m20357b(byte b2) {
            return C5294r.m21023c(this.f20150a, b2);
        }

        /* renamed from: c */
        public int m20358c(byte b2) {
            return C5294r.m21151d(this.f20150a, b2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return m20356a(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20150a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return m20357b(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20150a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return m20358c(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Byte get(int i2) {
            return Byte.valueOf(this.f20150a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$b */
    public static final class b extends AbstractC5252d<Short> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ short[] f20151a;

        b(short[] sArr) {
            this.f20151a = sArr;
        }

        /* renamed from: a */
        public boolean m20359a(short s) {
            return C5294r.m21000b(this.f20151a, s);
        }

        /* renamed from: b */
        public int m20360b(short s) {
            return C5294r.m21029c(this.f20151a, s);
        }

        /* renamed from: c */
        public int m20361c(short s) {
            return C5294r.m21158d(this.f20151a, s);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Short) {
                return m20359a(((Number) obj).shortValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20151a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Short) {
                return m20360b(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20151a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Short) {
                return m20361c(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Short get(int i2) {
            return Short.valueOf(this.f20151a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$c */
    public static final class c extends AbstractC5252d<Integer> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ int[] f20152a;

        c(int[] iArr) {
            this.f20152a = iArr;
        }

        /* renamed from: a */
        public boolean m20362a(int i2) {
            return C5294r.m20837a(this.f20152a, i2);
        }

        /* renamed from: b */
        public int m20363b(int i2) {
            return C5294r.m21284g(this.f20152a, i2);
        }

        /* renamed from: c */
        public int m20364c(int i2) {
            return C5294r.m21314h(this.f20152a, i2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return m20362a(((Number) obj).intValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20152a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return m20363b(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20152a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return m20364c(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Integer get(int i2) {
            return Integer.valueOf(this.f20152a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$d */
    public static final class d extends AbstractC5252d<Long> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ long[] f20153a;

        d(long[] jArr) {
            this.f20153a = jArr;
        }

        /* renamed from: a */
        public boolean m20365a(long j2) {
            return C5294r.m20994b(this.f20153a, j2);
        }

        /* renamed from: b */
        public int m20366b(long j2) {
            return C5294r.m21027c(this.f20153a, j2);
        }

        /* renamed from: c */
        public int m20367c(long j2) {
            return C5294r.m21156d(this.f20153a, j2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Long) {
                return m20365a(((Number) obj).longValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20153a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Long) {
                return m20366b(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20153a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return m20367c(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Long get(int i2) {
            return Long.valueOf(this.f20153a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$e */
    public static final class e extends AbstractC5252d<Float> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ float[] f20154a;

        e(float[] fArr) {
            this.f20154a = fArr;
        }

        /* renamed from: a */
        public boolean m20368a(float f2) {
            return C5294r.m20989b(this.f20154a, f2);
        }

        /* renamed from: b */
        public int m20369b(float f2) {
            return C5294r.m21026c(this.f20154a, f2);
        }

        /* renamed from: c */
        public int m20370c(float f2) {
            return C5294r.m21154d(this.f20154a, f2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return m20368a(((Number) obj).floatValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20154a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return m20369b(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20154a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return m20370c(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Float get(int i2) {
            return Float.valueOf(this.f20154a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$f */
    public static final class f extends AbstractC5252d<Double> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ double[] f20155a;

        f(double[] dArr) {
            this.f20155a = dArr;
        }

        /* renamed from: a */
        public boolean m20371a(double d2) {
            return C5294r.m20986b(this.f20155a, d2);
        }

        /* renamed from: b */
        public int m20372b(double d2) {
            return C5294r.m21025c(this.f20155a, d2);
        }

        /* renamed from: c */
        public int m20373c(double d2) {
            return C5294r.m21153d(this.f20155a, d2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return m20371a(((Number) obj).doubleValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20155a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return m20372b(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20155a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return m20373c(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Double get(int i2) {
            return Double.valueOf(this.f20155a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$g */
    public static final class g extends AbstractC5252d<Boolean> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ boolean[] f20156a;

        g(boolean[] zArr) {
            this.f20156a = zArr;
        }

        /* renamed from: a */
        public boolean m20374a(boolean z) {
            return C5294r.m21005b(this.f20156a, z);
        }

        /* renamed from: b */
        public int m20375b(boolean z) {
            return C5294r.m21030c(this.f20156a, z);
        }

        /* renamed from: c */
        public int m20376c(boolean z) {
            return C5294r.m21159d(this.f20156a, z);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return m20374a(((Boolean) obj).booleanValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20156a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return m20375b(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20156a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return m20376c(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Boolean get(int i2) {
            return Boolean.valueOf(this.f20156a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    /* renamed from: h.g2.q$h */
    public static final class h extends AbstractC5252d<Character> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ char[] f20157a;

        h(char[] cArr) {
            this.f20157a = cArr;
        }

        /* renamed from: a */
        public boolean m20377a(char c2) {
            return C5294r.m20983b(this.f20157a, c2);
        }

        /* renamed from: b */
        public int m20378b(char c2) {
            return C5294r.m21024c(this.f20157a, c2);
        }

        /* renamed from: c */
        public int m20379c(char c2) {
            return C5294r.m21152d(this.f20157a, c2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Character) {
                return m20377a(((Character) obj).charValue());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20157a.length;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Character) {
                return m20378b(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return this.f20157a.length == 0;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return m20379c(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public Character get(int i2) {
            return Character.valueOf(this.f20157a[i2]);
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <R> List<R> m20167a(@InterfaceC5816d Object[] objArr, @InterfaceC5816d Class<R> cls) {
        C5544i0.m22546f(objArr, "$this$filterIsInstance");
        C5544i0.m22546f(cls, "klass");
        return (List) m20160a(objArr, new ArrayList(), cls);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final byte m20244b(@InterfaceC5816d byte[] bArr, int i2) {
        return bArr[i2];
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final <T> T m20298c(@InterfaceC5816d T[] tArr, int i2) {
        return tArr[i2];
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static <T> List<T> m20317d(@InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(tArr, "$this$asList");
        List<T> m21674a = C5297s.m21674a(tArr);
        C5544i0.m22521a((Object) m21674a, "ArraysUtilJVM.asList(this)");
        return m21674a;
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "contentDeepHashCodeInline")
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: e */
    private static final <T> int m20327e(@InterfaceC5816d T[] tArr) {
        return C5432l.m22181a(1, 3, 0) ? C5285o.m20123a(tArr) : Arrays.deepHashCode(tArr);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "contentDeepToStringInline")
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: f */
    private static final <T> String m20336f(@InterfaceC5816d T[] tArr) {
        if (C5432l.m22181a(1, 3, 0)) {
            return C5288p.m20135c(tArr);
        }
        String deepToString = Arrays.deepToString(tArr);
        C5544i0.m22521a((Object) deepToString, "java.util.Arrays.deepToString(this)");
        return deepToString;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: g */
    private static final <T> int m20345g(@InterfaceC5816d T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: h */
    private static final <T> String m20353h(@InterfaceC5816d T[] tArr) {
        String arrays = Arrays.toString(tArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final <T> T[] m20354i(@InterfaceC5816d T[] tArr) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        C5544i0.m22521a((Object) tArr2, "java.util.Arrays.copyOf(this, size)");
        return tArr2;
    }

    /* renamed from: j */
    public static final <T> void m20355j(@InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <C extends Collection<? super R>, R> C m20160a(@InterfaceC5816d Object[] objArr, @InterfaceC5816d C c2, @InterfaceC5816d Class<R> cls) {
        C5544i0.m22546f(objArr, "$this$filterIsInstanceTo");
        C5544i0.m22546f(c2, "destination");
        C5544i0.m22546f(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final short m20260b(@InterfaceC5816d short[] sArr, int i2) {
        return sArr[i2];
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final <T> boolean m20315c(@InterfaceC5816d T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final byte[] m20318d(@InterfaceC5816d byte[] bArr) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final Byte[] m20346g(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$toTypedArray");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Byte> m20161a(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$asList");
        return new a(bArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m20253b(@InterfaceC5816d int[] iArr, int i2) {
        return iArr[i2];
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20299c(@InterfaceC5816d byte[] bArr) {
        String arrays = Arrays.toString(bArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final short[] m20325d(@InterfaceC5816d short[] sArr) {
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Short> m20168a(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$asList");
        return new b(sArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final long m20257b(@InterfaceC5816d long[] jArr, int i2) {
        return jArr[i2];
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20305c(@InterfaceC5816d short[] sArr) {
        String arrays = Arrays.toString(sArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int[] m20322d(@InterfaceC5816d int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: e */
    public static final void m20333e(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$sort");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final Boolean[] m20344f(@InterfaceC5816d boolean[] zArr) {
        C5544i0.m22546f(zArr, "$this$toTypedArray");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        return boolArr;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Integer> m20165a(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$asList");
        return new c(iArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final float m20247b(@InterfaceC5816d float[] fArr, int i2) {
        return fArr[i2];
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20303c(@InterfaceC5816d int[] iArr) {
        String arrays = Arrays.toString(iArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long[] m20323d(@InterfaceC5816d long[] jArr) {
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: e */
    public static final void m20334e(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$sort");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final Short[] m20352g(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$toTypedArray");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            shArr[i2] = Short.valueOf(sArr[i2]);
        }
        return shArr;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Long> m20166a(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$asList");
        return new d(jArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final double m20246b(@InterfaceC5816d double[] dArr, int i2) {
        return dArr[i2];
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20304c(@InterfaceC5816d long[] jArr) {
        String arrays = Arrays.toString(jArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final float[] m20321d(@InterfaceC5816d float[] fArr) {
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: e */
    public static final void m20329e(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$sort");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Float> m20164a(@InterfaceC5816d float[] fArr) {
        C5544i0.m22546f(fArr, "$this$asList");
        return new e(fArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final boolean m20278b(@InterfaceC5816d boolean[] zArr, int i2) {
        return zArr[i2];
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20302c(@InterfaceC5816d float[] fArr) {
        String arrays = Arrays.toString(fArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final double[] m20320d(@InterfaceC5816d double[] dArr) {
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: e */
    public static final void m20335e(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$sort");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final SortedSet<Byte> m20337f(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21050c(bArr, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Double> m20163a(@InterfaceC5816d double[] dArr) {
        C5544i0.m22546f(dArr, "$this$asList");
        return new f(dArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final char m20245b(@InterfaceC5816d char[] cArr, int i2) {
        return cArr[i2];
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20301c(@InterfaceC5816d double[] dArr) {
        String arrays = Arrays.toString(dArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final boolean[] m20326d(@InterfaceC5816d boolean[] zArr) {
        boolean[] copyOf = Arrays.copyOf(zArr, zArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: e */
    public static final void m20331e(@InterfaceC5816d double[] dArr) {
        C5544i0.m22546f(dArr, "$this$sort");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final SortedSet<Short> m20343f(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21065c(sArr, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final Integer[] m20350g(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$toTypedArray");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Boolean> m20169a(@InterfaceC5816d boolean[] zArr) {
        C5544i0.m22546f(zArr, "$this$asList");
        return new g(zArr);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "contentDeepEqualsInline")
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final <T> boolean m20277b(@InterfaceC5816d T[] tArr, T[] tArr2) {
        if (C5432l.m22181a(1, 3, 0)) {
            return C5288p.m20134a(tArr, tArr2);
        }
        return Arrays.deepEquals(tArr, tArr2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20306c(@InterfaceC5816d boolean[] zArr) {
        String arrays = Arrays.toString(zArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final char[] m20319d(@InterfaceC5816d char[] cArr) {
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: e */
    public static final void m20332e(@InterfaceC5816d float[] fArr) {
        C5544i0.m22546f(fArr, "$this$sort");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final SortedSet<Integer> m20341f(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21058c(iArr, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<Character> m20162a(@InterfaceC5816d char[] cArr) {
        C5544i0.m22546f(cArr, "$this$asList");
        return new h(cArr);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final String m20300c(@InterfaceC5816d char[] cArr) {
        String arrays = Arrays.toString(cArr);
        C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <T> T[] m20324d(@InterfaceC5816d T[] tArr, @InterfaceC5816d T[] tArr2) {
        C5544i0.m22546f(tArr, "$this$plus");
        C5544i0.m22546f(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        C5544i0.m22521a((Object) tArr3, "result");
        return tArr3;
    }

    /* renamed from: e */
    public static final void m20330e(@InterfaceC5816d char[] cArr) {
        C5544i0.m22546f(cArr, "$this$sort");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final SortedSet<Long> m20342f(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21060c(jArr, new TreeSet());
    }

    /* renamed from: a */
    public static /* synthetic */ int m20157a(Object[] objArr, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return m20156a(objArr, obj, (Comparator<? super Object>) comparator, i2, i3);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static int[] m20316c(@InterfaceC5816d int[] iArr, int i2) {
        C5544i0.m22546f(iArr, "$this$plus");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i2;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final SortedSet<Boolean> m20328e(@InterfaceC5816d boolean[] zArr) {
        C5544i0.m22546f(zArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21067c(zArr, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final SortedSet<Float> m20340f(@InterfaceC5816d float[] fArr) {
        C5544i0.m22546f(fArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21056c(fArr, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final Long[] m20351g(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$toTypedArray");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    /* renamed from: a */
    public static final <T> int m20156a(@InterfaceC5816d T[] tArr, T t, @InterfaceC5816d Comparator<? super T> comparator, int i2, int i3) {
        C5544i0.m22546f(tArr, "$this$binarySearch");
        C5544i0.m22546f(comparator, "comparator");
        return Arrays.binarySearch(tArr, i2, i3, t, comparator);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20248b(@InterfaceC5816d byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final SortedSet<Double> m20339f(@InterfaceC5816d double[] dArr) {
        C5544i0.m22546f(dArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21054c(dArr, new TreeSet());
    }

    /* renamed from: a */
    public static /* synthetic */ int m20155a(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        return m20154a(objArr, obj, i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20255b(@InterfaceC5816d short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final SortedSet<Character> m20338f(@InterfaceC5816d char[] cArr) {
        C5544i0.m22546f(cArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21052c(cArr, new TreeSet());
    }

    /* renamed from: a */
    public static final <T> int m20154a(@InterfaceC5816d T[] tArr, T t, int i2, int i3) {
        C5544i0.m22546f(tArr, "$this$binarySearch");
        return Arrays.binarySearch(tArr, i2, i3, t);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20252b(@InterfaceC5816d int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final Float[] m20349g(@InterfaceC5816d float[] fArr) {
        C5544i0.m22546f(fArr, "$this$toTypedArray");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ int m20143a(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return m20142a(bArr, b2, i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20254b(@InterfaceC5816d long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* renamed from: c */
    public static final <T> void m20313c(@InterfaceC5816d T[] tArr, int i2, int i3) {
        C5544i0.m22546f(tArr, "$this$sort");
        Arrays.sort(tArr, i2, i3);
    }

    /* renamed from: a */
    public static final int m20142a(@InterfaceC5816d byte[] bArr, byte b2, int i2, int i3) {
        C5544i0.m22546f(bArr, "$this$binarySearch");
        return Arrays.binarySearch(bArr, i2, i3, b2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20251b(@InterfaceC5816d float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: c */
    public static final void m20307c(@InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(bArr, "$this$sort");
        Arrays.sort(bArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ int m20159a(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        return m20158a(sArr, s, i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20250b(@InterfaceC5816d double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    /* renamed from: c */
    public static final void m20314c(@InterfaceC5816d short[] sArr, int i2, int i3) {
        C5544i0.m22546f(sArr, "$this$sort");
        Arrays.sort(sArr, i2, i3);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final Double[] m20348g(@InterfaceC5816d double[] dArr) {
        C5544i0.m22546f(dArr, "$this$toTypedArray");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    /* renamed from: a */
    public static final int m20158a(@InterfaceC5816d short[] sArr, short s, int i2, int i3) {
        C5544i0.m22546f(sArr, "$this$binarySearch");
        return Arrays.binarySearch(sArr, i2, i3, s);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20256b(@InterfaceC5816d boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    /* renamed from: c */
    public static final void m20311c(@InterfaceC5816d int[] iArr, int i2, int i3) {
        C5544i0.m22546f(iArr, "$this$sort");
        Arrays.sort(iArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ int m20151a(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        return m20150a(iArr, i2, i3, i4);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final int m20249b(@InterfaceC5816d char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    /* renamed from: c */
    public static final void m20312c(@InterfaceC5816d long[] jArr, int i2, int i3) {
        C5544i0.m22546f(jArr, "$this$sort");
        Arrays.sort(jArr, i2, i3);
    }

    /* renamed from: a */
    public static final int m20150a(@InterfaceC5816d int[] iArr, int i2, int i3, int i4) {
        C5544i0.m22546f(iArr, "$this$binarySearch");
        return Arrays.binarySearch(iArr, i3, i4, i2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> T[] m20291b(@InterfaceC5816d T[] tArr, int i2) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i2);
        C5544i0.m22521a((Object) tArr2, "java.util.Arrays.copyOf(this, newSize)");
        return tArr2;
    }

    /* renamed from: c */
    public static final void m20310c(@InterfaceC5816d float[] fArr, int i2, int i3) {
        C5544i0.m22546f(fArr, "$this$sort");
        Arrays.sort(fArr, i2, i3);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final Character[] m20347g(@InterfaceC5816d char[] cArr) {
        C5544i0.m22546f(cArr, "$this$toTypedArray");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            chArr[i2] = Character.valueOf(cArr[i2]);
        }
        return chArr;
    }

    /* renamed from: a */
    public static /* synthetic */ int m20153a(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        return m20152a(jArr, j2, i2, i3);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final <T> T[] m20292b(@InterfaceC5816d T[] tArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return (T[]) C5282n.m20058a(tArr, i2, i3);
        }
        if (i3 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
            C5544i0.m22521a((Object) tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return tArr2;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + tArr.length);
    }

    /* renamed from: c */
    public static final void m20309c(@InterfaceC5816d double[] dArr, int i2, int i3) {
        C5544i0.m22546f(dArr, "$this$sort");
        Arrays.sort(dArr, i2, i3);
    }

    /* renamed from: a */
    public static final int m20152a(@InterfaceC5816d long[] jArr, long j2, int i2, int i3) {
        C5544i0.m22546f(jArr, "$this$binarySearch");
        return Arrays.binarySearch(jArr, i2, i3, j2);
    }

    /* renamed from: c */
    public static final void m20308c(@InterfaceC5816d char[] cArr, int i2, int i3) {
        C5544i0.m22546f(cArr, "$this$sort");
        Arrays.sort(cArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ int m20149a(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        return m20148a(fArr, f2, i2, i3);
    }

    /* renamed from: a */
    public static final int m20148a(@InterfaceC5816d float[] fArr, float f2, int i2, int i3) {
        C5544i0.m22546f(fArr, "$this$binarySearch");
        return Arrays.binarySearch(fArr, i2, i3, f2);
    }

    /* renamed from: a */
    public static /* synthetic */ int m20147a(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        return m20146a(dArr, d2, i2, i3);
    }

    /* renamed from: a */
    public static final int m20146a(@InterfaceC5816d double[] dArr, double d2, int i2, int i3) {
        C5544i0.m22546f(dArr, "$this$binarySearch");
        return Arrays.binarySearch(dArr, i2, i3, d2);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final byte[] m20279b(@InterfaceC5816d byte[] bArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20194a(bArr, i2, i3);
        }
        if (i3 <= bArr.length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + bArr.length);
    }

    /* renamed from: a */
    public static /* synthetic */ int m20145a(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        return m20144a(cArr, c2, i2, i3);
    }

    /* renamed from: a */
    public static final int m20144a(@InterfaceC5816d char[] cArr, char c2, int i2, int i3) {
        C5544i0.m22546f(cArr, "$this$binarySearch");
        return Arrays.binarySearch(cArr, i2, i3, c2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20184a(@InterfaceC5816d byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20190a(@InterfaceC5816d short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20188a(@InterfaceC5816d int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final short[] m20294b(@InterfaceC5816d short[] sArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20233a(sArr, i2, i3);
        }
        if (i3 <= sArr.length) {
            short[] copyOfRange = Arrays.copyOfRange(sArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + sArr.length);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20189a(@InterfaceC5816d long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20187a(@InterfaceC5816d float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20186a(@InterfaceC5816d double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20191a(@InterfaceC5816d boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    private static final boolean m20185a(@InterfaceC5816d char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final int[] m20287b(@InterfaceC5816d int[] iArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20217a(iArr, i2, i3);
        }
        if (i3 <= iArr.length) {
            int[] copyOfRange = Arrays.copyOfRange(iArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + iArr.length);
    }

    /* renamed from: a */
    public static /* synthetic */ Object[] m20231a(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return m20230a(objArr, objArr2, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> T[] m20230a(@InterfaceC5816d T[] tArr, @InterfaceC5816d T[] tArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(tArr, "$this$copyInto");
        C5544i0.m22546f(tArr2, "destination");
        System.arraycopy(tArr, i3, tArr2, i2, i4 - i3);
        return tArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ byte[] m20197a(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        return m20196a(bArr, bArr2, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static byte[] m20196a(@InterfaceC5816d byte[] bArr, @InterfaceC5816d byte[] bArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(bArr, "$this$copyInto");
        C5544i0.m22546f(bArr2, "destination");
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
        return bArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ short[] m20237a(short[] sArr, short[] sArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sArr.length;
        }
        return m20236a(sArr, sArr2, i2, i3, i4);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final long[] m20289b(@InterfaceC5816d long[] jArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20222a(jArr, i2, i3);
        }
        if (i3 <= jArr.length) {
            long[] copyOfRange = Arrays.copyOfRange(jArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + jArr.length);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static short[] m20236a(@InterfaceC5816d short[] sArr, @InterfaceC5816d short[] sArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(sArr, "$this$copyInto");
        C5544i0.m22546f(sArr2, "destination");
        System.arraycopy(sArr, i3, sArr2, i2, i4 - i3);
        return sArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ int[] m20220a(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = iArr.length;
        }
        return m20219a(iArr, iArr2, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static int[] m20219a(@InterfaceC5816d int[] iArr, @InterfaceC5816d int[] iArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(iArr, "$this$copyInto");
        C5544i0.m22546f(iArr2, "destination");
        System.arraycopy(iArr, i3, iArr2, i2, i4 - i3);
        return iArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ long[] m20226a(long[] jArr, long[] jArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = jArr.length;
        }
        return m20225a(jArr, jArr2, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static long[] m20225a(@InterfaceC5816d long[] jArr, @InterfaceC5816d long[] jArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(jArr, "$this$copyInto");
        C5544i0.m22546f(jArr2, "destination");
        System.arraycopy(jArr, i3, jArr2, i2, i4 - i3);
        return jArr2;
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final float[] m20285b(@InterfaceC5816d float[] fArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20212a(fArr, i2, i3);
        }
        if (i3 <= fArr.length) {
            float[] copyOfRange = Arrays.copyOfRange(fArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + fArr.length);
    }

    /* renamed from: a */
    public static /* synthetic */ float[] m20215a(float[] fArr, float[] fArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = fArr.length;
        }
        return m20214a(fArr, fArr2, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final float[] m20214a(@InterfaceC5816d float[] fArr, @InterfaceC5816d float[] fArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(fArr, "$this$copyInto");
        C5544i0.m22546f(fArr2, "destination");
        System.arraycopy(fArr, i3, fArr2, i2, i4 - i3);
        return fArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ double[] m20209a(double[] dArr, double[] dArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = dArr.length;
        }
        return m20208a(dArr, dArr2, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final double[] m20208a(@InterfaceC5816d double[] dArr, @InterfaceC5816d double[] dArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(dArr, "$this$copyInto");
        C5544i0.m22546f(dArr2, "destination");
        System.arraycopy(dArr, i3, dArr2, i2, i4 - i3);
        return dArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean[] m20243a(boolean[] zArr, boolean[] zArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = zArr.length;
        }
        return m20242a(zArr, zArr2, i2, i3, i4);
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final double[] m20283b(@InterfaceC5816d double[] dArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20206a(dArr, i2, i3);
        }
        if (i3 <= dArr.length) {
            double[] copyOfRange = Arrays.copyOfRange(dArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + dArr.length);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final boolean[] m20242a(@InterfaceC5816d boolean[] zArr, @InterfaceC5816d boolean[] zArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(zArr, "$this$copyInto");
        C5544i0.m22546f(zArr2, "destination");
        System.arraycopy(zArr, i3, zArr2, i2, i4 - i3);
        return zArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ char[] m20203a(char[] cArr, char[] cArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = cArr.length;
        }
        return m20202a(cArr, cArr2, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final char[] m20202a(@InterfaceC5816d char[] cArr, @InterfaceC5816d char[] cArr2, int i2, int i3, int i4) {
        C5544i0.m22546f(cArr, "$this$copyInto");
        C5544i0.m22546f(cArr2, "destination");
        System.arraycopy(cArr, i3, cArr2, i2, i4 - i3);
        return cArr2;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final byte[] m20193a(@InterfaceC5816d byte[] bArr, int i2) {
        byte[] copyOf = Arrays.copyOf(bArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final short[] m20232a(@InterfaceC5816d short[] sArr, int i2) {
        short[] copyOf = Arrays.copyOf(sArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final boolean[] m20296b(@InterfaceC5816d boolean[] zArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20239a(zArr, i2, i3);
        }
        if (i3 <= zArr.length) {
            boolean[] copyOfRange = Arrays.copyOfRange(zArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + zArr.length);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int[] m20216a(@InterfaceC5816d int[] iArr, int i2) {
        int[] copyOf = Arrays.copyOf(iArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final long[] m20221a(@InterfaceC5816d long[] jArr, int i2) {
        long[] copyOf = Arrays.copyOf(jArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final float[] m20211a(@InterfaceC5816d float[] fArr, int i2) {
        float[] copyOf = Arrays.copyOf(fArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final double[] m20205a(@InterfaceC5816d double[] dArr, int i2) {
        double[] copyOf = Arrays.copyOf(dArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final boolean[] m20238a(@InterfaceC5816d boolean[] zArr, int i2) {
        boolean[] copyOf = Arrays.copyOf(zArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5426f
    @InterfaceC5481e(name = "copyOfRangeInline")
    /* renamed from: b */
    private static final char[] m20281b(@InterfaceC5816d char[] cArr, int i2, int i3) {
        if (C5432l.m22181a(1, 3, 0)) {
            return m20200a(cArr, i2, i3);
        }
        if (i3 <= cArr.length) {
            char[] copyOfRange = Arrays.copyOfRange(cArr, i2, i3);
            C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + cArr.length);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final char[] m20199a(@InterfaceC5816d char[] cArr, int i2) {
        char[] copyOf = Arrays.copyOf(cArr, i2);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> T[] m20227a(@InterfaceC5816d T[] tArr, int i2, int i3) {
        C5544i0.m22546f(tArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
        C5544i0.m22521a((Object) tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static byte[] m20194a(@InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(bArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static /* synthetic */ void m20274b(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        m20273b(objArr, obj, i2, i3);
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static short[] m20233a(@InterfaceC5816d short[] sArr, int i2, int i3) {
        C5544i0.m22546f(sArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static final <T> void m20273b(@InterfaceC5816d T[] tArr, T t, int i2, int i3) {
        C5544i0.m22546f(tArr, "$this$fill");
        Arrays.fill(tArr, i2, i3, t);
    }

    /* renamed from: b */
    public static /* synthetic */ void m20262b(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        m20261b(bArr, b2, i2, i3);
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static int[] m20217a(@InterfaceC5816d int[] iArr, int i2, int i3) {
        C5544i0.m22546f(iArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static void m20261b(@InterfaceC5816d byte[] bArr, byte b2, int i2, int i3) {
        C5544i0.m22546f(bArr, "$this$fill");
        Arrays.fill(bArr, i2, i3, b2);
    }

    /* renamed from: b */
    public static /* synthetic */ void m20276b(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        m20275b(sArr, s, i2, i3);
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static long[] m20222a(@InterfaceC5816d long[] jArr, int i2, int i3) {
        C5544i0.m22546f(jArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static void m20275b(@InterfaceC5816d short[] sArr, short s, int i2, int i3) {
        C5544i0.m22546f(sArr, "$this$fill");
        Arrays.fill(sArr, i2, i3, s);
    }

    /* renamed from: b */
    public static /* synthetic */ void m20270b(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        m20269b(iArr, i2, i3, i4);
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static final float[] m20212a(@InterfaceC5816d float[] fArr, int i2, int i3) {
        C5544i0.m22546f(fArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static void m20269b(@InterfaceC5816d int[] iArr, int i2, int i3, int i4) {
        C5544i0.m22546f(iArr, "$this$fill");
        Arrays.fill(iArr, i3, i4, i2);
    }

    /* renamed from: b */
    public static /* synthetic */ void m20272b(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        m20271b(jArr, j2, i2, i3);
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static final double[] m20206a(@InterfaceC5816d double[] dArr, int i2, int i3) {
        C5544i0.m22546f(dArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static void m20271b(@InterfaceC5816d long[] jArr, long j2, int i2, int i3) {
        C5544i0.m22546f(jArr, "$this$fill");
        Arrays.fill(jArr, i2, i3, j2);
    }

    /* renamed from: b */
    public static /* synthetic */ void m20268b(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        m20267b(fArr, f2, i2, i3);
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static final boolean[] m20239a(@InterfaceC5816d boolean[] zArr, int i2, int i3) {
        C5544i0.m22546f(zArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static final void m20267b(@InterfaceC5816d float[] fArr, float f2, int i2, int i3) {
        C5544i0.m22546f(fArr, "$this$fill");
        Arrays.fill(fArr, i2, i3, f2);
    }

    /* renamed from: b */
    public static /* synthetic */ void m20266b(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        m20265b(dArr, d2, i2, i3);
    }

    @InterfaceC5481e(name = "copyOfRange")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: a */
    public static final char[] m20200a(@InterfaceC5816d char[] cArr, int i2, int i3) {
        C5544i0.m22546f(cArr, "$this$copyOfRangeImpl");
        C5285o.m20125a(i3, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i2, i3);
        C5544i0.m22521a((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static final void m20265b(@InterfaceC5816d double[] dArr, double d2, int i2, int i3) {
        C5544i0.m22546f(dArr, "$this$fill");
        Arrays.fill(dArr, i2, i3, d2);
    }

    /* renamed from: b */
    public static /* synthetic */ void m20264b(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        m20263b(cArr, c2, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20183a(boolean[] zArr, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = zArr.length;
        }
        m20182a(zArr, z, i2, i3);
    }

    /* renamed from: b */
    public static final void m20263b(@InterfaceC5816d char[] cArr, char c2, int i2, int i3) {
        C5544i0.m22546f(cArr, "$this$fill");
        Arrays.fill(cArr, i2, i3, c2);
    }

    /* renamed from: a */
    public static final void m20182a(@InterfaceC5816d boolean[] zArr, boolean z, int i2, int i3) {
        C5544i0.m22546f(zArr, "$this$fill");
        Arrays.fill(zArr, i2, i3, z);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static byte[] m20280b(@InterfaceC5816d byte[] bArr, @InterfaceC5816d byte[] bArr2) {
        C5544i0.m22546f(bArr, "$this$plus");
        C5544i0.m22546f(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> T[] m20228a(@InterfaceC5816d T[] tArr, T t) {
        C5544i0.m22546f(tArr, "$this$plus");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t;
        C5544i0.m22521a((Object) tArr2, "result");
        return tArr2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static byte[] m20192a(@InterfaceC5816d byte[] bArr, byte b2) {
        C5544i0.m22546f(bArr, "$this$plus");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b2;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static short[] m20295b(@InterfaceC5816d short[] sArr, @InterfaceC5816d short[] sArr2) {
        C5544i0.m22546f(sArr, "$this$plus");
        C5544i0.m22546f(sArr2, "elements");
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] copyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static short[] m20235a(@InterfaceC5816d short[] sArr, short s) {
        C5544i0.m22546f(sArr, "$this$plus");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, length + 1);
        copyOf[length] = s;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static int[] m20288b(@InterfaceC5816d int[] iArr, @InterfaceC5816d int[] iArr2) {
        C5544i0.m22546f(iArr, "$this$plus");
        C5544i0.m22546f(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static long[] m20223a(@InterfaceC5816d long[] jArr, long j2) {
        C5544i0.m22546f(jArr, "$this$plus");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        copyOf[length] = j2;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static long[] m20290b(@InterfaceC5816d long[] jArr, @InterfaceC5816d long[] jArr2) {
        C5544i0.m22546f(jArr, "$this$plus");
        C5544i0.m22546f(jArr2, "elements");
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final float[] m20210a(@InterfaceC5816d float[] fArr, float f2) {
        C5544i0.m22546f(fArr, "$this$plus");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        copyOf[length] = f2;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final float[] m20286b(@InterfaceC5816d float[] fArr, @InterfaceC5816d float[] fArr2) {
        C5544i0.m22546f(fArr, "$this$plus");
        C5544i0.m22546f(fArr2, "elements");
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final double[] m20204a(@InterfaceC5816d double[] dArr, double d2) {
        C5544i0.m22546f(dArr, "$this$plus");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, length + 1);
        copyOf[length] = d2;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final boolean[] m20241a(@InterfaceC5816d boolean[] zArr, boolean z) {
        C5544i0.m22546f(zArr, "$this$plus");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        copyOf[length] = z;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final double[] m20284b(@InterfaceC5816d double[] dArr, @InterfaceC5816d double[] dArr2) {
        C5544i0.m22546f(dArr, "$this$plus");
        C5544i0.m22546f(dArr2, "elements");
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] copyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final char[] m20198a(@InterfaceC5816d char[] cArr, char c2) {
        C5544i0.m22546f(cArr, "$this$plus");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, length + 1);
        copyOf[length] = c2;
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final boolean[] m20297b(@InterfaceC5816d boolean[] zArr, @InterfaceC5816d boolean[] zArr2) {
        C5544i0.m22546f(zArr, "$this$plus");
        C5544i0.m22546f(zArr2, "elements");
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> T[] m20229a(@InterfaceC5816d T[] tArr, @InterfaceC5816d Collection<? extends T> collection) {
        C5544i0.m22546f(tArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        C5544i0.m22521a((Object) tArr2, "result");
        return tArr2;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final char[] m20282b(@InterfaceC5816d char[] cArr, @InterfaceC5816d char[] cArr2) {
        C5544i0.m22546f(cArr, "$this$plus");
        C5544i0.m22546f(cArr2, "elements");
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] copyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, copyOf, length, length2);
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m20195a(@InterfaceC5816d byte[] bArr, @InterfaceC5816d Collection<Byte> collection) {
        C5544i0.m22546f(bArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, collection.size() + length);
        Iterator<Byte> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().byteValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> T[] m20293b(@InterfaceC5816d T[] tArr, T t) {
        return (T[]) m20228a(tArr, t);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final short[] m20234a(@InterfaceC5816d short[] sArr, @InterfaceC5816d Collection<Short> collection) {
        C5544i0.m22546f(sArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, collection.size() + length);
        Iterator<Short> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().shortValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T extends Comparable<? super T>> SortedSet<T> m20258b(@InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(tArr, "$this$toSortedSet");
        return (SortedSet) C5294r.m21231e((Object[]) tArr, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> SortedSet<T> m20259b(@InterfaceC5816d T[] tArr, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(tArr, "$this$toSortedSet");
        C5544i0.m22546f(comparator, "comparator");
        return (SortedSet) C5294r.m21231e((Object[]) tArr, new TreeSet(comparator));
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final int[] m20218a(@InterfaceC5816d int[] iArr, @InterfaceC5816d Collection<Integer> collection) {
        C5544i0.m22546f(iArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, collection.size() + length);
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().intValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final long[] m20224a(@InterfaceC5816d long[] jArr, @InterfaceC5816d Collection<Long> collection) {
        C5544i0.m22546f(jArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, collection.size() + length);
        Iterator<Long> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().longValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final float[] m20213a(@InterfaceC5816d float[] fArr, @InterfaceC5816d Collection<Float> collection) {
        C5544i0.m22546f(fArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, collection.size() + length);
        Iterator<Float> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().floatValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final double[] m20207a(@InterfaceC5816d double[] dArr, @InterfaceC5816d Collection<Double> collection) {
        C5544i0.m22546f(dArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, collection.size() + length);
        Iterator<Double> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().doubleValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final boolean[] m20240a(@InterfaceC5816d boolean[] zArr, @InterfaceC5816d Collection<Boolean> collection) {
        C5544i0.m22546f(zArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, collection.size() + length);
        Iterator<Boolean> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().booleanValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final char[] m20201a(@InterfaceC5816d char[] cArr, @InterfaceC5816d Collection<Character> collection) {
        C5544i0.m22546f(cArr, "$this$plus");
        C5544i0.m22546f(collection, "elements");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, collection.size() + length);
        Iterator<Character> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().charValue();
            length++;
        }
        C5544i0.m22521a((Object) copyOf, "result");
        return copyOf;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T extends Comparable<? super T>> void m20176a(@InterfaceC5816d T[] tArr) {
        if (tArr == null) {
            throw new C5226e1("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        m20355j(tArr);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20177a(Object[] objArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = objArr.length;
        }
        m20313c(objArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20170a(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        m20307c(bArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20181a(short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = sArr.length;
        }
        m20314c(sArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20174a(int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = iArr.length;
        }
        m20311c(iArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20175a(long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = jArr.length;
        }
        m20312c(jArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20173a(float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = fArr.length;
        }
        m20310c(fArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20172a(double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = dArr.length;
        }
        m20309c(dArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ void m20171a(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        m20308c(cArr, i2, i3);
    }

    /* renamed from: a */
    public static final <T> void m20178a(@InterfaceC5816d T[] tArr, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(tArr, "$this$sortWith");
        C5544i0.m22546f(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m20180a(Object[] objArr, Comparator comparator, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        m20179a(objArr, comparator, i2, i3);
    }

    /* renamed from: a */
    public static final <T> void m20179a(@InterfaceC5816d T[] tArr, @InterfaceC5816d Comparator<? super T> comparator, int i2, int i3) {
        C5544i0.m22546f(tArr, "$this$sortWith");
        C5544i0.m22546f(comparator, "comparator");
        Arrays.sort(tArr, i2, i3, comparator);
    }
}
