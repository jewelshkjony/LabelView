package com.jewel.labelview.helpers;

import java.util.HashMap;
import java.util.Map;

import com.google.appinventor.components.common.OptionList;

public enum LabelViewStyle implements OptionList<Integer> {
  Normal(0),
  Italic(1),
  Bold(2);

  private int value;

  LabelViewStyle(int value) {
    this.value = value;
  }

  public Integer toUnderlyingValue() {
    return value;
  }

  private static final Map<Integer, LabelViewStyle> lookup = new HashMap<>();

  static {
    for (LabelViewStyle value : values()) {
      lookup.put(value.toUnderlyingValue(), value);
    }
  }

  public static LabelViewStyle fromUnderlyingValue(Integer value) {
    return lookup.get(value);
  }

}
