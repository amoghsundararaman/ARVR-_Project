package com.google.p000vr.cardboard.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
/* renamed from: com.google.vr.cardboard.annotations.UsedByReflection */
public @interface UsedByReflection {
    String value();
}
