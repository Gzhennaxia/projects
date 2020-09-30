package com.gzhennaxia.demo.recursive_param;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author bo li
 * @date 2020-09-21 13:48
 */
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    protected abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();

        protected abstract Pizza build();
    }

    protected Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
