package com.gzhennaxia.demo.recursive_param.impl;

import com.gzhennaxia.demo.recursive_param.Pizza;

/**
 * @author bo li
 * @date 2020-09-21 14:33
 */
public class Calzone extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder {
        private boolean sauceInside;

        public Builder sauceInside() {
            sauceInside = true;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        protected Calzone build() {
            return new Calzone(this);
        }
    }

    protected Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
