package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* renamed from: a */
    private static C0008a[] f33a = new C0008a[4096];
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static long f34b = 0;

    /* renamed from: com.unity3d.player.ReflectionHelper$a */
    private static class C0008a {

        /* renamed from: a */
        public volatile Member f38a;

        /* renamed from: b */
        private final Class f39b;

        /* renamed from: c */
        private final String f40c;

        /* renamed from: d */
        private final String f41d;

        /* renamed from: e */
        private final int f42e = (((((this.f39b.hashCode() + 527) * 31) + this.f40c.hashCode()) * 31) + this.f41d.hashCode());

        C0008a(Class cls, String str, String str2) {
            this.f39b = cls;
            this.f40c = str;
            this.f41d = str2;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0008a) {
                C0008a aVar = (C0008a) obj;
                return this.f42e == aVar.f42e && this.f41d.equals(aVar.f41d) && this.f40c.equals(aVar.f40c) && this.f39b.equals(aVar.f39b);
            }
        }

        public final int hashCode() {
            return this.f42e;
        }
    }

    ReflectionHelper() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|(1:10)|11|12|(1:14)(1:19)) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return 0.0f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float m26a(java.lang.Class r1, java.lang.Class r2) {
        /*
            boolean r0 = r1.equals(r2)
            if (r0 == 0) goto L_0x0009
            r1 = 1065353216(0x3f800000, float:1.0)
            return r1
        L_0x0009:
            boolean r0 = r1.isPrimitive()
            if (r0 != 0) goto L_0x0028
            boolean r0 = r2.isPrimitive()
            if (r0 != 0) goto L_0x0028
            java.lang.Class r0 = r1.asSubclass(r2)     // Catch:{ ClassCastException -> 0x001e }
            if (r0 == 0) goto L_0x001e
            r1 = 1056964608(0x3f000000, float:0.5)
            return r1
        L_0x001e:
            java.lang.Class r1 = r2.asSubclass(r1)     // Catch:{ ClassCastException -> 0x0028 }
            if (r1 == 0) goto L_0x0028
            r1 = 1036831949(0x3dcccccd, float:0.1)
            return r1
        L_0x0028:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.m26a(java.lang.Class, java.lang.Class):float");
    }

    /* renamed from: a */
    private static float m27a(Class cls, Class[] clsArr, Class[] clsArr2) {
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        int i = 0;
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            while (i < length) {
                f *= m26a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return f * m26a(cls, clsArr2[clsArr2.length - 1]);
    }

    /* renamed from: a */
    private static Class m29a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf == -1) {
                        return null;
                    }
                    String substring = str.substring(iArr[0], indexOf);
                    iArr[0] = indexOf + 1;
                    try {
                        return Class.forName(substring.replace('/', '.'));
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                } else if (charAt == 'Z') {
                    return Boolean.TYPE;
                } else {
                    if (charAt == 'I') {
                        return Integer.TYPE;
                    }
                    if (charAt == 'F') {
                        return Float.TYPE;
                    }
                    if (charAt == 'V') {
                        return Void.TYPE;
                    }
                    if (charAt == 'B') {
                        return Byte.TYPE;
                    }
                    if (charAt == 'C') {
                        return Character.TYPE;
                    }
                    if (charAt == 'S') {
                        return Short.TYPE;
                    }
                    if (charAt == 'J') {
                        return Long.TYPE;
                    }
                    if (charAt == 'D') {
                        return Double.TYPE;
                    }
                    if (charAt == '[') {
                        return Array.newInstance(m29a(str, iArr), 0).getClass();
                    }
                    C0057g.Log(5, "! parseType; " + charAt + " is not known!");
                    return null;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m32a(C0008a aVar, Member member) {
        aVar.f38a = member;
        f33a[aVar.hashCode() & (f33a.length - 1)] = aVar;
    }

    /* renamed from: a */
    private static boolean m33a(C0008a aVar) {
        C0008a aVar2 = f33a[aVar.hashCode() & (f33a.length - 1)];
        if (!aVar.equals(aVar2)) {
            return false;
        }
        aVar.f38a = aVar2.f38a;
        return true;
    }

    /* renamed from: a */
    private static Class[] m34a(String str) {
        Class a;
        int i = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (a = m29a(str, iArr)) != null) {
            arrayList.add(a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static void endUnityLaunch() {
        f34b++;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor constructor;
        C0008a aVar = new C0008a(cls, "", str);
        if (m33a(aVar)) {
            constructor = (Constructor) aVar.f38a;
        } else {
            Class[] a = m34a(str);
            float f = 0.0f;
            Constructor[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i = 0;
            Constructor constructor2 = null;
            while (true) {
                if (i >= length) {
                    break;
                }
                Constructor constructor3 = constructors[i];
                float a2 = m27a(Void.TYPE, constructor3.getParameterTypes(), a);
                if (a2 > f) {
                    if (a2 == 1.0f) {
                        constructor2 = constructor3;
                        break;
                    }
                    constructor2 = constructor3;
                    f = a2;
                }
                i++;
            }
            m32a(aVar, (Member) constructor2);
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        Class cls2 = cls;
        C0008a aVar = new C0008a(cls2, str3, str4);
        if (m33a(aVar)) {
            field = (Field) aVar.f38a;
        } else {
            Class[] a = m34a(str2);
            float f = 0.0f;
            Field field2 = null;
            while (cls2 != null) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                Field field3 = field2;
                float f2 = f;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        f = f2;
                        field2 = field3;
                        break;
                    }
                    Field field4 = declaredFields[i];
                    if (z2 == Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str3) == 0) {
                        float a2 = m27a((Class) field4.getType(), (Class[]) null, a);
                        if (a2 > f2) {
                            if (a2 == 1.0f) {
                                field2 = field4;
                                f = a2;
                                break;
                            }
                            field3 = field4;
                            f2 = a2;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
            m32a(aVar, (Member) field2);
            field = field2;
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z2 ? "static" : "non-static";
        objArr[1] = str3;
        objArr[2] = str4;
        objArr[3] = cls2.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        C0008a aVar = new C0008a(cls, str, str2);
        if (m33a(aVar)) {
            method = (Method) aVar.f38a;
        } else {
            Class[] a = m34a(str2);
            float f = 0.0f;
            Method method2 = null;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                Method method3 = method2;
                float f2 = f;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        f = f2;
                        method2 = method3;
                        break;
                    }
                    Method method4 = declaredMethods[i];
                    if (z == Modifier.isStatic(method4.getModifiers()) && method4.getName().compareTo(str) == 0) {
                        float a2 = m27a((Class) method4.getReturnType(), method4.getParameterTypes(), a);
                        if (a2 > f2) {
                            if (a2 == 1.0f) {
                                method2 = method4;
                                f = a2;
                                break;
                            }
                            method3 = method4;
                            f2 = a2;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            m32a(aVar, (Member) method2);
            method = method2;
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* access modifiers changed from: private */
    public static native void nativeProxyFinalize(int i);

    /* access modifiers changed from: private */
    public static native Object nativeProxyInvoke(int i, String str, Object[] objArr);

    /* access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException();

    protected static Object newProxyInstance(int i, Class cls) {
        return newProxyInstance(i, new Class[]{cls});
    }

    protected static Object newProxyInstance(final int i, final Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new InvocationHandler() {

            /* renamed from: c */
            private long f37c = ReflectionHelper.f34b;

            /* renamed from: a */
            private static Object m36a(Object obj, Method method, Object[] objArr) {
                if (objArr == null) {
                    try {
                        objArr = new Object[0];
                    } catch (NoClassDefFoundError unused) {
                        C0057g.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                        ReflectionHelper.nativeProxyLogJNIInvokeException();
                        return null;
                    }
                }
                Class<?> declaringClass = method.getDeclaringClass();
                Constructor<MethodHandles.Lookup> declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[]{declaringClass, 2}).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                try {
                    if (this.f37c == ReflectionHelper.f34b) {
                        ReflectionHelper.nativeProxyFinalize(i);
                    }
                } finally {
                    super.finalize();
                }
            }

            public final Object invoke(Object obj, Method method, Object[] objArr) {
                if (this.f37c != ReflectionHelper.f34b) {
                    C0057g.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
                    return null;
                }
                Object a = ReflectionHelper.nativeProxyInvoke(i, method.getName(), objArr);
                if (a == null) {
                    if ((method.getModifiers() & 1024) == 0) {
                        return m36a(obj, method, objArr);
                    }
                    ReflectionHelper.nativeProxyLogJNIInvokeException();
                }
                return a;
            }
        });
    }
}
