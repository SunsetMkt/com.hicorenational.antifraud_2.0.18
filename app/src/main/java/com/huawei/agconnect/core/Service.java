package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class Service {
    private final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f4335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4339f;

    public static class Builder {
        Class<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Class<?> f4340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f4341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4344f;

        public Service build() {
            Class<?> cls = this.a;
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
            Class<?> cls2 = this.f4340b;
            if (cls2 == null) {
                Object obj = this.f4341c;
                if (obj == null) {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
                Service service2 = new Service(cls, obj);
                service2.f4337d = this.f4342d;
                return service2;
            }
            if (cls2.isInterface() || !Modifier.isPublic(this.f4340b.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            Service service3 = new Service((Class) this.a, (Class) this.f4340b);
            service3.f4337d = this.f4342d;
            service3.f4338e = this.f4343e;
            service3.f4339f = this.f4344f;
            return service3;
        }

        public Builder isAutoCreated(boolean z) {
            this.f4344f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.f4343e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.f4342d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.f4340b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f4341c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.a = cls;
        this.f4335b = cls2;
        this.f4336c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.a = cls;
        this.f4335b = null;
        this.f4336c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f4336c;
    }

    public Class<?> getInterface() {
        return this.a;
    }

    public Class<?> getType() {
        return this.f4335b;
    }

    public boolean isAutoCreated() {
        return this.f4339f;
    }

    public boolean isSharedInstance() {
        return this.f4338e;
    }

    public boolean isSingleton() {
        return this.f4337d;
    }
}
