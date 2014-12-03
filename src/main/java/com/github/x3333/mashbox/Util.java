package com.github.x3333.mashbox;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.VariableElement;

/**
 * Utilities methods for Generators.
 *
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
public class Util {

  private Util() {
  }

  public static PackageElement getPackage(Element type) {
    while (type.getKind() != ElementKind.PACKAGE) {
      type = type.getEnclosingElement();
    }
    return (PackageElement) type;
  }

  public static String getGenericType(final String canonicalName, final String... parameters) {
    if (parameters.length == 0) {
      return canonicalName;
    }
    final StringBuilder result = new StringBuilder();
    result.append(canonicalName);
    result.append("<");
    result.append(parameters[0]);
    for (int i = 1; i < parameters.length; i++) {
      result.append(", ");
      result.append(parameters[i]);
    }
    result.append(">");
    return result.toString();
  }

  public static String getVariableGetter(final VariableElement variable) {
    String name = variable.getSimpleName().toString();
    name = name.substring(0, 1).toUpperCase() + name.substring(1);
    return "get" + name;
  }

}
