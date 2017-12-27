package com.example.sbp.utils;

@FunctionalInterface
public interface FunctionalProperty<T> {
    String getValue(T t);
}
