package org.kobjects.htmlview2;

import elemental.dom.Element;
import elemental.dom.Node;
import org.kobjects.css.CssStylableElement;
import org.kobjects.css.CssStyle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class VirtualElement implements Element, CssStylableElement {
  private final String name;
  ArrayList<VirtualElement> children = new ArrayList<>();
  LinkedHashMap<String,String> attributes = new LinkedHashMap<>();
  CssStyle style;

  public VirtualElement(String name) {
    this.name = name;
  }

  @Override
  public Node appendChild(Node childNode) {
    children.add((VirtualElement) childNode);
    return childNode;
  }

  @Override
  public String getAttribute(String name) {
    return attributes.get(name);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getLocalName() {
    return name;
  }

  @Override
  public Iterator<? extends CssStylableElement> getChildElementIterator() {
    return children.iterator();
  }

  @Override
  public void setAttribute(String name, String value) {
    attributes.put(name, value);
  }

  @Override
  public void setComputedStyle(CssStyle style) {
    this.style = style;
  }
}
