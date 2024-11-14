package com.group11.mapapi.utils;

import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class EnumUtil {
    private static final Random RANDOM = new Random();

    public static <T extends Enum<?>> T randomEnum(Class<T> enumType) {
        int x = RANDOM.nextInt(enumType.getEnumConstants().length);
        return enumType.getEnumConstants()[x];
    }
}
