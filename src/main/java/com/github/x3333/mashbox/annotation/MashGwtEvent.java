package com.github.x3333.mashbox.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker interface for Mashbox's GwtEvent base classes.
 *
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface MashGwtEvent {

}
