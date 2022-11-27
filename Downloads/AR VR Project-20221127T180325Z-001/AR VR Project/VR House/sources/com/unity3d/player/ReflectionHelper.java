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
import java.util.Arrays;
import java.util.Iterator;

final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* renamed from: a */
    private static C0114a[] f62a = new C0114a[4096];

    /* renamed from: com.unity3d.player.ReflectionHelper$a */
    private static class C0114a {

        /* renamed from: a */
        public volatile Member f65a;

        /* renamed from: b */
        private final Class f66b;

        /* renamed from: c */
        private final String f67c;

        /* renamed from: d */
        private final String f68d;

        /* renamed from: e */
        private final int f69e = (((((this.f66b.hashCode() + 527) * 31) + this.f67c.hashCode()) * 31) + this.f68d.hashCode());

        C0114a(Class cls, String str, String str2) {
            this.f66b = cls;
            this.f67c = str;
            this.f68d = str2;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0114a)) {
                return false;
            }
            C0114a aVar = (C0114a) obj;
            return this.f69e == aVar.f69e && this.f68d.equals(aVar.f68d) && this.f67c.equals(aVar.f67c) && this.f66b.equals(aVar.f66b);
        }

        public final int hashCode() {
            return this.f69e;
        }
    }

    ReflectionHelper() {
    }

    /* renamed from: a */
    private static float m40a(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (!cls.isPrimitive() && !cls2.isPrimitive()) {
            try {
                if (cls.asSubclass(cls2) != null) {
                    return 0.5f;
                }
            } catch (ClassCastException e) {
            }
            try {
                if (cls2.asSubclass(cls) != null) {
                    return 0.1f;
                }
            } catch (ClassCastException e2) {
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    private static float m41a(Class cls, Class[] clsArr, Class[] clsArr2) {
        int i = 0;
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            while (i < length) {
                f *= m40a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return f * m40a(cls, clsArr2[clsArr2.length - 1]);
    }

    /* renamed from: a */
    private static Class m42a(String str, int[] iArr) {
        while (true) {
            if (iArr[0] >= str.length()) {
                break;
            }
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf != -1) {
                        String substring = str.substring(iArr[0], indexOf);
                        iArr[0] = indexOf + 1;
                        try {
                            return Class.forName(substring.replace('/', '.'));
                        } catch (ClassNotFoundException e) {
                        }
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
                        return Array.newInstance(m42a(str, iArr), 0).getClass();
                    }
                    C0160g.Log(5, "! parseType; " + charAt + " is not known!");
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m46a(C0114a aVar, Member member) {
        aVar.f65a = member;
        f62a[aVar.hashCode() & (f62a.length - 1)] = aVar;
    }

    /* renamed from: a */
    private static boolean m47a(C0114a aVar) {
        C0114a aVar2 = f62a[aVar.hashCode() & (f62a.length - 1)];
        if (!aVar.equals(aVar2)) {
            return false;
        }
        aVar.f65a = aVar2.f65a;
        return true;
    }

    /* renamed from: a */
    private static Class[] m48a(String str) {
        Class a;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (a = m42a(str, iArr)) != null) {
            arrayList.add(a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor constructor;
        Constructor constructor2;
        if (LOG) {
            C0160g.Log(3, "? getConstructorID(\"" + cls.getName() + "\", \"" + str + "\")");
        }
        Constructor constructor3 = null;
        C0114a aVar = new C0114a(cls, "", str);
        if (m47a(aVar)) {
            constructor = (Constructor) aVar.f65a;
        } else {
            Class[] a = m48a(str);
            float f = 0.0f;
            Constructor[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = constructor3;
                    break;
                }
                constructor = constructors[i];
                float a2 = m41a(Void.TYPE, constructor.getParameterTypes(), a);
                if (a2 > f) {
                    if (a2 == 1.0f) {
                        break;
                    }
                    constructor2 = constructor;
                } else {
                    a2 = f;
                    constructor2 = constructor3;
                }
                i++;
                constructor3 = constructor2;
                f = a2;
            }
            m46a(aVar, (Member) constructor);
        }
        if (constructor == null) {
            throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
        }
        if (LOG) {
            StringBuilder sb = new StringBuilder();
            for (Class cls2 : constructor.getParameterTypes()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(cls2.getSimpleName());
            }
            C0160g.Log(3, "! " + constructor.getName() + "(" + sb.toString() + ");");
        }
        return constructor;
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        float f;
        Field field2;
        if (LOG) {
            C0160g.Log(3, "? getFieldID(\"" + cls.getName() + "\", \"" + str + "\", \"" + str2 + "\", " + (z ? "static)" : "non-static)"));
        }
        C0114a aVar = new C0114a(cls, str, str2);
        if (m47a(aVar)) {
            field = (Field) aVar.f65a;
        } else {
            Class[] a = m48a(str2);
            field = null;
            float f2 = 0.0f;
            while (cls != null) {
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                Field field3 = field;
                while (true) {
                    if (i >= length) {
                        field = field3;
                        break;
                    }
                    Field field4 = declaredFields[i];
                    if (z == Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str) == 0) {
                        f = m41a((Class) field4.getType(), (Class[]) null, a);
                        if (f > f2) {
                            if (f == 1.0f) {
                                f2 = f;
                                field = field4;
                                break;
                            }
                            field2 = field4;
                            i++;
                            field3 = field2;
                            f2 = f;
                        }
                    }
                    f = f2;
                    field2 = field3;
                    i++;
                    field3 = field2;
                    f2 = f;
                }
                if (f2 == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            m46a(aVar, (Member) field);
        }
        if (field == null) {
            Object[] objArr = new Object[4];
            objArr[0] = z ? "static" : "non-static";
            objArr[1] = str;
            objArr[2] = str2;
            objArr[3] = cls.getName();
            throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
        }
        if (LOG) {
            C0160g.Log(3, "! " + field.getType().getSimpleName() + " " + field.getDeclaringClass().getSimpleName() + "." + field.getName() + ";");
        }
        return field;
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        float f;
        Method method2;
        if (LOG) {
            C0160g.Log(3, "? getMethodID(\"" + cls.getName() + "\", \"" + str + "\", \"" + str2 + "\", " + (z ? "static)" : "non-static)"));
        }
        C0114a aVar = new C0114a(cls, str, str2);
        if (m47a(aVar)) {
            method = (Method) aVar.f65a;
        } else {
            Class[] a = m48a(str2);
            Method method3 = null;
            float f2 = 0.0f;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                Method method4 = method3;
                while (true) {
                    if (i >= length) {
                        method3 = method4;
                        break;
                    }
                    Method method5 = declaredMethods[i];
                    if (z == Modifier.isStatic(method5.getModifiers()) && method5.getName().compareTo(str) == 0) {
                        f = m41a((Class) method5.getReturnType(), method5.getParameterTypes(), a);
                        if (f > f2) {
                            if (f == 1.0f) {
                                f2 = f;
                                method3 = method5;
                                break;
                            }
                            method2 = method5;
                            i++;
                            method4 = method2;
                            f2 = f;
                        }
                    }
                    f = f2;
                    method2 = method4;
                    i++;
                    method4 = method2;
                    f2 = f;
                }
                if (f2 == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            m46a(aVar, (Member) method3);
            method = method3;
        }
        if (method == null) {
            Object[] objArr = new Object[4];
            objArr[0] = z ? "static" : "non-static";
            objArr[1] = str;
            objArr[2] = str2;
            objArr[3] = cls.getName();
            throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
        }
        if (LOG) {
            StringBuilder sb = new StringBuilder();
            for (Class cls2 : method.getParameterTypes()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(cls2.getSimpleName());
            }
            C0160g.Log(3, "! " + method.getReturnType().getSimpleName() + " " + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "(" + sb.toString() + ");");
        }
        return method;
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
        if (LOG) {
            C0160g.Log(3, String.format("ReflectionHelper.Proxy(%d,%s)", new Object[]{Integer.valueOf(i), Arrays.asList(clsArr)}));
        }
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new InvocationHandler() {
            /* renamed from: a */
            private static Object m49a(Object obj, Method method, Object[] objArr) {
                if (objArr == null) {
                    try {
                        objArr = new Object[0];
                    } catch (NoClassDefFoundError e) {
                        C0160g.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
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
                    if (ReflectionHelper.LOG) {
                        C0160g.Log(3, String.format("ReflectionHelper.Proxy.finilize(%d, %s)", new Object[]{Integer.valueOf(i), Arrays.asList(clsArr)}));
                    }
                    ReflectionHelper.nativeProxyFinalize(i);
                } finally {
                    super.finalize();
                }
            }

            public final Object invoke(Object obj, Method method, Object[] objArr) {
                if (ReflectionHelper.LOG) {
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = Integer.valueOf(i);
                    objArr2[1] = Arrays.asList(clsArr);
                    objArr2[2] = method.getName();
                    objArr2[3] = objArr == null ? "<null>" : Arrays.asList(objArr);
                    C0160g.Log(3, String.format("ReflectionHelper.Proxy.invoke(%d, %s, %s, %s)", objArr2));
                }
                Object a = ReflectionHelper.nativeProxyInvoke(i, method.getName(), objArr);
                if (a != null) {
                    return a;
                }
                if ((method.getModifiers() & 1024) == 0) {
                    return m49a(obj, method, objArr);
                }
                ReflectionHelper.nativeProxyLogJNIInvokeException();
                return a;
            }
        });
    }
}
