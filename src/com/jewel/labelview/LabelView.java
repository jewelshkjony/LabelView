package com.jewel.labelview;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;

import android.view.ViewGroup;

public class LabelView extends AndroidNonvisibleComponent {

  public LabelView(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleProperty(description = "")
  public int StyleNormal() {
    return 0;
  }

  @SimpleProperty(description = "")
  public int StyleItalic() {
    return 1;
  }

  @SimpleProperty(description = "")
  public int StyleBold() {
    return 2;
  }

  @SimpleProperty(description = "")
  public int DirectionTopLeft() {
    return -45;
  }

  @SimpleProperty(description = "")
  public int DirectionTopRight() {
    return 45;
  }

  @SimpleFunction(description = "A simple label control supports custom text size,\n"
      + "spacing (Top/Center/Bottom Padding), background color, and direction, etc.")
  public void CreateLabel(AndroidViewComponent view, String text,
      float textSize, int textStyle, int textColor, String number, int numberStyle, float numberSize, int numberColor,
      int direction, float topPadding, float centerPadding, float bottomPadding, int backgroundColor) {
    ViewGroup viewGroup = (ViewGroup) view.getView();
    ViewLabel labelView = new ViewLabel(form.getApplicationContext());
    labelView.setText(text);
    labelView.setTextSize(textSize);
    labelView.setTextStyle(textStyle);
    labelView.setTextColor(textColor);
    labelView.setNum(number);
    labelView.setNumStyle(numberStyle);
    labelView.setNumSize(numberSize);
    labelView.setNumberColor(numberColor);
    labelView.setDirection(direction);
    labelView.setTopPadding(topPadding);
    labelView.setCenterPadding(centerPadding);
    labelView.setBottomPadding(bottomPadding);
    labelView.setBackGroundColor(backgroundColor);
    viewGroup.removeAllViews();
    viewGroup.addView(labelView);
  }
}
