package com.github.x3333.mashbox.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker interface for Mashbox's GwtEvent parameters.
 *
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface MashGwtEventParam {

  int value();

}
