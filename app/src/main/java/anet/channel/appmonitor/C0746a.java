package anet.channel.appmonitor;

import android.text.TextUtils;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p000a.p001a.p003k.C0014b;

/* compiled from: Taobao */
/* renamed from: anet.channel.appmonitor.a */
/* loaded from: classes.dex */
public class C0746a implements IAppMonitor {

    /* renamed from: a */
    private static boolean f748a = false;

    /* renamed from: b */
    private static Map<Class<?>, List<Field>> f749b = new ConcurrentHashMap();

    /* renamed from: c */
    private static Map<Class<?>, List<Field>> f750c = new ConcurrentHashMap();

    /* renamed from: d */
    private static Map<Field, String> f751d = new ConcurrentHashMap();

    /* renamed from: e */
    private static Random f752e = new Random();

    /* renamed from: f */
    private static Set<Class<?>> f753f = Collections.newSetFromMap(new ConcurrentHashMap());

    public C0746a() {
        try {
            Class.forName("com.alibaba.mtl.appmonitor.AppMonitor");
            f748a = true;
        } catch (Exception unused) {
            f748a = false;
        }
    }

    /* renamed from: a */
    synchronized void m443a(Class<?> cls) {
        if (cls != null) {
            if (f748a) {
                try {
                } catch (Exception e2) {
                    ALog.m714e("awcn.DefaultAppMonitor", "register fail", null, e2, new Object[0]);
                }
                if (f753f.contains(cls)) {
                    return;
                }
                Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
                if (monitor == null) {
                    return;
                }
                Field[] fields = cls.getFields();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                DimensionSet create = DimensionSet.create();
                MeasureSet create2 = MeasureSet.create();
                for (Field field : fields) {
                    Dimension dimension = (Dimension) field.getAnnotation(Dimension.class);
                    if (dimension != null) {
                        field.setAccessible(true);
                        arrayList.add(field);
                        String name = dimension.name().equals("") ? field.getName() : dimension.name();
                        f751d.put(field, name);
                        create.addDimension(name);
                    } else {
                        Measure measure = (Measure) field.getAnnotation(Measure.class);
                        if (measure != null) {
                            field.setAccessible(true);
                            arrayList2.add(field);
                            String name2 = measure.name().equals("") ? field.getName() : measure.name();
                            f751d.put(field, name2);
                            if (measure.max() != Double.MAX_VALUE) {
                                create2.addMeasure(new com.alibaba.mtl.appmonitor.model.Measure(name2, Double.valueOf(measure.constantValue()), Double.valueOf(measure.min()), Double.valueOf(measure.max())));
                            } else {
                                create2.addMeasure(name2);
                            }
                        }
                    }
                }
                f749b.put(cls, arrayList);
                f750c.put(cls, arrayList2);
                com.alibaba.mtl.appmonitor.AppMonitor.register(monitor.module(), monitor.monitorPoint(), create2, create);
                f753f.add(cls);
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitAlarm(AlarmObject alarmObject) {
        if (!f748a || alarmObject == null || TextUtils.isEmpty(alarmObject.module) || TextUtils.isEmpty(alarmObject.modulePoint)) {
            return;
        }
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.DefaultAppMonitor", "commit alarm: " + alarmObject, null, new Object[0]);
        }
        if (alarmObject.isSuccess) {
            AppMonitor.Alarm.commitSuccess(alarmObject.module, alarmObject.modulePoint, StringUtils.stringNull2Empty(alarmObject.arg));
        } else {
            AppMonitor.Alarm.commitFail(alarmObject.module, alarmObject.modulePoint, StringUtils.stringNull2Empty(alarmObject.arg), StringUtils.stringNull2Empty(alarmObject.errorCode), StringUtils.stringNull2Empty(alarmObject.errorMsg));
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitCount(CountObject countObject) {
        if (!f748a || countObject == null || TextUtils.isEmpty(countObject.module) || TextUtils.isEmpty(countObject.modulePoint)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.m716i("awcn.DefaultAppMonitor", "commit count: " + countObject, null, new Object[0]);
        }
        AppMonitor.Counter.commit(countObject.module, countObject.modulePoint, StringUtils.stringNull2Empty(countObject.arg), countObject.value);
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitStat(StatObject statObject) {
        if (!f748a || statObject == null) {
            return;
        }
        Class<?> cls = statObject.getClass();
        Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
        if (monitor == null) {
            return;
        }
        if (!f753f.contains(cls)) {
            m443a(cls);
        }
        if (statObject.beforeCommit()) {
            if (monitor.monitorPoint().equals("network")) {
                int m73b = C0014b.m73b();
                if (m73b > 10000 || m73b < 0) {
                    m73b = 10000;
                }
                if (m73b != 10000 && f752e.nextInt(10000) >= m73b) {
                    return;
                }
            }
            try {
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                List<Field> list = f749b.get(cls);
                HashMap hashMap = ALog.isPrintLog(1) ? new HashMap() : null;
                if (list != null) {
                    for (Field field : list) {
                        Object obj = field.get(statObject);
                        create.setValue(f751d.get(field), obj == null ? "" : obj.toString());
                    }
                    for (Field field2 : f750c.get(cls)) {
                        Double valueOf = Double.valueOf(field2.getDouble(statObject));
                        create2.setValue(f751d.get(field2), valueOf.doubleValue());
                        if (hashMap != null) {
                            hashMap.put(f751d.get(field2), valueOf);
                        }
                    }
                }
                AppMonitor.Stat.commit(monitor.module(), monitor.monitorPoint(), create, create2);
                if (ALog.isPrintLog(1)) {
                    ALog.m713d("awcn.DefaultAppMonitor", "commit stat: " + monitor.monitorPoint(), null, "\nDimensions", create.getMap().toString(), "\nMeasures", hashMap.toString());
                }
            } catch (Throwable th) {
                ALog.m714e("awcn.DefaultAppMonitor", "commit monitor point failed", null, th, new Object[0]);
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register() {
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register(Class<?> cls) {
    }
}
