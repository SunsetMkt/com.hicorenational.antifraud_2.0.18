package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    private static class BuilderImpl {
        private final WindowInsetsCompat mInsets;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        @NonNull
        WindowInsetsCompat build() {
            return this.mInsets;
        }

        void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        void setMandatorySystemGestureInsets(@NonNull Insets insets) {
        }

        void setStableInsets(@NonNull Insets insets) {
        }

        void setSystemGestureInsets(@NonNull Insets insets) {
        }

        void setSystemWindowInsets(@NonNull Insets insets) {
        }

        void setTappableElementInsets(@NonNull Insets insets) {
        }

        BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }
    }

    private static class Impl {
        final WindowInsetsCompat mHost;

        Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        @NonNull
        WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        @NonNull
        WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        @NonNull
        WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) && ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) && ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout());
        }

        @Nullable
        DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        @NonNull
        Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        Insets getStableInsets() {
            return Insets.NONE;
        }

        @NonNull
        Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        @NonNull
        Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        @NonNull
        WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.CONSUMED;
        }

        boolean isConsumed() {
            return false;
        }

        boolean isRound() {
            return false;
        }
    }

    @RequiresApi(28)
    private static class Impl28 extends Impl21 {
        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Impl28) {
                return Objects.equals(this.mPlatformInsets, ((Impl28) obj).mPlatformInsets);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }

        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
            return;
        }
        if (i2 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
            return;
        }
        if (i2 >= 21) {
            this.mImpl = new Impl21(this, windowInsets);
        } else if (i2 >= 20) {
            this.mImpl = new Impl20(this, windowInsets);
        } else {
            this.mImpl = new Impl(this);
        }
    }

    static Insets insetInsets(Insets insets, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, insets.left - i2);
        int max2 = Math.max(0, insets.top - i3);
        int max3 = Math.max(0, insets.right - i4);
        int max4 = Math.max(0, insets.bottom - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? insets : Insets.m385of(max, max2, max3, max4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
    }

    @NonNull
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @NonNull
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @NonNull
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    public int getStableInsetBottom() {
        return getStableInsets().bottom;
    }

    public int getStableInsetLeft() {
        return getStableInsets().left;
    }

    public int getStableInsetRight() {
        return getStableInsets().right;
    }

    public int getStableInsetTop() {
        return getStableInsets().top;
    }

    @NonNull
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @NonNull
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    public int getSystemWindowInsetBottom() {
        return getSystemWindowInsets().bottom;
    }

    public int getSystemWindowInsetLeft() {
        return getSystemWindowInsets().left;
    }

    public int getSystemWindowInsetRight() {
        return getSystemWindowInsets().right;
    }

    public int getSystemWindowInsetTop() {
        return getSystemWindowInsets().top;
    }

    @NonNull
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @NonNull
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        return (!hasSystemWindowInsets() && !hasStableInsets() && getDisplayCutout() == null && getSystemGestureInsets().equals(Insets.NONE) && getMandatorySystemGestureInsets().equals(Insets.NONE) && getTappableElementInsets().equals(Insets.NONE)) ? false : true;
    }

    public boolean hasStableInsets() {
        return !getStableInsets().equals(Insets.NONE);
    }

    public boolean hasSystemWindowInsets() {
        return !getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i2, int i3, int i4, int i5) {
        return new Builder(this).setSystemWindowInsets(Insets.m385of(i2, i3, i4, i5)).build();
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    @RequiresApi(api = 20)
    private static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mInsets;

        BuilderImpl20() {
            this.mInsets = createWindowInsetsInstance();
        }

        @Nullable
        private static WindowInsets createWindowInsetsInstance() {
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        WindowInsetsCompat build() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemWindowInsets(@NonNull Insets insets) {
            WindowInsets windowInsets = this.mInsets;
            if (windowInsets != null) {
                this.mInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    private static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        WindowInsetsCompat build() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mPlatBuilder.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setStableInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemGestureInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemWindowInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setTappableElementInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }

        BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.mPlatBuilder = builder;
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mStableInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.m385of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.mStableInsets = null;
        }
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        return this.mImpl.inset(i2, i3, i4, i5);
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {

        @NonNull
        final WindowInsets mPlatformInsets;
        private Insets mSystemWindowInsets;

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.m385of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i2, i3, i4, i5));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i2, i3, i4, i5));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
        }
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets getTappableElementInsets() {
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(i2, i3, i4, i5));
        }

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.m386of(rect)).build();
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                this.mImpl = new BuilderImpl29();
            } else if (i2 >= 20) {
                this.mImpl = new BuilderImpl20();
            } else {
                this.mImpl = new BuilderImpl();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.setDisplayCutout(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @NonNull
        public Builder setStableInsets(@NonNull Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        @NonNull
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @NonNull
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @NonNull
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                this.mImpl = new BuilderImpl29(windowInsetsCompat);
            } else if (i2 >= 20) {
                this.mImpl = new BuilderImpl20(windowInsetsCompat);
            } else {
                this.mImpl = new BuilderImpl(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.mImpl;
            if (Build.VERSION.SDK_INT >= 29 && (impl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) impl);
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (impl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) impl);
                return;
            }
            if (Build.VERSION.SDK_INT >= 21 && (impl instanceof Impl21)) {
                this.mImpl = new Impl21(this, (Impl21) impl);
                return;
            } else if (Build.VERSION.SDK_INT >= 20 && (impl instanceof Impl20)) {
                this.mImpl = new Impl20(this, (Impl20) impl);
                return;
            } else {
                this.mImpl = new Impl(this);
                return;
            }
        }
        this.mImpl = new Impl(this);
    }
}
