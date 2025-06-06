/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 10:58 PM
 */
package com.ceyentra.sm.config.throttling_config;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EndpointMethod {

    private final Class targetClass;
    private final String targetMethod;

    public EndpointMethod(Class targetClass, String targetMethod) {
        this.targetClass = targetClass;
        this.targetMethod = targetMethod;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EndpointMethod that = (EndpointMethod) o;

        return new EqualsBuilder()
                .append(targetClass, that.targetClass)
                .append(targetMethod, that.targetMethod)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(targetClass)
                .append(targetMethod)
                .toHashCode();
    }

}
