package androidx.camera.core.impl.utils;

import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

/* loaded from: classes.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T mReference;

    Present(T t) {
        this.mReference = t;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Present) {
            return this.mReference.equals(((Present) obj).mReference);
        }
        return false;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T get() {
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    /* renamed from: or */
    public T mo373or(T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T orNull() {
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public String toString() {
        return "Optional.of(" + this.mReference + ")";
    }

    @Override // androidx.camera.core.impl.utils.Optional
    /* renamed from: or */
    public Optional<T> mo371or(Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    /* renamed from: or */
    public T mo372or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.mReference;
    }
}
