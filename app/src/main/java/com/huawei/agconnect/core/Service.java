package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public class Service {

    /* renamed from: a */
    private final Class<?> f6913a;

    /* renamed from: b */
    private final Class<?> f6914b;

    /* renamed from: c */
    private final Object f6915c;

    /* renamed from: d */
    private boolean f6916d;

    /* renamed from: e */
    private boolean f6917e;

    /* renamed from: f */
    private boolean f6918f;

    public static class Builder {

        /* renamed from: a */
        Class<?> f6919a;

        /* renamed from: b */
        Class<?> f6920b;

        /* renamed from: c */
        Object f6921c;

        /* renamed from: d */
        private boolean f6922d;

        /* renamed from: e */
        private boolean f6923e;

        /* renamed from: f */
        private boolean f6924f;

        public Service build() {
            Class<?> cls = this.f6919a;
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
            Class<?> cls2 = this.f6920b;
            if (cls2 == null) {
                Object obj = this.f6921c;
                if (obj == null) {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
                Service service2 = new Service(cls, obj);
                service2.f6916d = this.f6922d;
                return service2;
            }
            if (cls2.isInterface() || !Modifier.isPublic(this.f6920b.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            Service service3 = new Service((Class) this.f6919a, (Class) this.f6920b);
            service3.f6916d = this.f6922d;
            service3.f6917e = this.f6923e;
            service3.f6918f = this.f6924f;
            return service3;
        }

        public Builder isAutoCreated(boolean z) {
            this.f6924f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.f6923e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.f6922d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.f6920b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f6919a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f6921c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f6913a = cls;
        this.f6914b = cls2;
        this.f6915c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.f6913a = cls;
        this.f6914b = null;
        this.f6915c = obj;
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
        return this.f6915c;
    }

    public Class<?> getInterface() {
        return this.f6913a;
    }

    public Class<?> getType() {
        return this.f6914b;
    }

    public boolean isAutoCreated() {
        return this.f6918f;
    }

    public boolean isSharedInstance() {
        return this.f6917e;
    }

    public boolean isSingleton() {
        return this.f6916d;
    }
}
