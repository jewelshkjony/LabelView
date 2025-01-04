package com.jewel.labelview.helpers;

import java.util.HashMap;
import java.util.Map;

import com.google.appinventor.components.common.OptionList;

public enum LabelViewDirection implements OptionList<Integer> {
  TopLeft(-45),
  TopRight(45);

  private int value;

  LabelViewDirection(int value) {
    this.value = value;
  }

  public Integer toUnderlyingValue() {
    return value;
  }

  private static final Map<Integer, LabelViewDirection> lookup = new HashMap<>();

  static {
    for (LabelViewDirection value : values()) {
      lookup.put(value.toUnderlyingValue(), value);
    }
  }

  public static LabelViewDirection fromUnderlyingValue(Integer value) {
    return lookup.get(value);
  }

}
