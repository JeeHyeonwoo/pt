package com.pt.domain;

import java.util.Arrays;

public interface Meta {
    String getDescription();

    default String[] constants() {
        return (String[]) Arrays.stream(this.getClass().getEnumConstants()).map(Meta::getDescription).toArray(
                (x) -> {
                    return new String[x];
        });
    }
}
