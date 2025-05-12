package com.jewel.labelview;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.HVArrangement;
import com.jewel.labelview.helpers.LabelViewDirection;
import com.jewel.labelview.helpers.LabelViewStyle;

import android.content.Context;
import android.view.ViewGroup;

@DesignerComponent(
  version = 13,
  versionName = "1.1",
  description = "Developed by Jewel Shikder Jony<br><br>"
    + "<a href='https://t.me/jewelshkjony/' target='_blank'>Telegram</a> | "
    + "<a href='https://wa.me/8801775668913' target='_blank'>WhatsApp</a><br>"
    + "<a href='https://fb.com/jewelshkjony/' target='_blank'>Facebook</a> | "
    + "<a href='https://m.me/jewelshkjony/' target='_blank'>Messenger</a><br>"
    + "<a href='https://m.youtube.com/c/JewelShikderJony?sub_confirmation=1' target='_blank'>YouTube</a> "
    + "<a href='https://github.com/jewelshkjony/Extensions' target='_blank'> 🧩 Aix Store</a><br>"
    + "<a href='https://github.com/jewelshkjony/Extensions/blob/main/LICENSE.md#terms-and-conditions-for-the-extension' target='_blank'>"
    + "<small><u>Terms & Conditions</u></small></a>",
  licenseName = "https://github.com/jewelshkjony/LabelView/blob/main/LICENSE",
  helpUrl = "https://github.com/jewelshkjony/LabelView",
  iconName = "icon.png"
)
public class LabelView extends AndroidNonvisibleComponent {
  private final Context context;

  public LabelView(ComponentContainer container) {
    super(container.$form());
    context = container.$context().getApplicationContext();
  }

  @SimpleFunction(description = "A simple label control supports custom text size,\n"
      + "spacing (Top/Center/Bottom Padding), background color, and direction, etc.")
  public void CreateLabel(HVArrangement arrangement, String text, float textSize, LabelViewStyle textStyle,
      int textColor, String number, LabelViewStyle numberStyle, float numberSize, int numberColor,
      LabelViewDirection direction, float topPadding, float centerPadding, float bottomPadding, int backgroundColor) {
    ViewGroup viewGroup = (ViewGroup) arrangement.getView();
    ViewLabel labelView = new ViewLabel(context);
    labelView.setText(text);
    labelView.setTextSize(textSize);
    labelView.setTextStyle(textStyle.toUnderlyingValue().intValue());
    labelView.setTextColor(textColor);
    labelView.setNum(number);
    labelView.setNumStyle(numberStyle.toUnderlyingValue().intValue());
    labelView.setNumSize(numberSize);
    labelView.setNumberColor(numberColor);
    labelView.setDirection(direction.toUnderlyingValue().intValue());
    labelView.setTopPadding(topPadding);
    labelView.setCenterPadding(centerPadding);
    labelView.setBottomPadding(bottomPadding);
    labelView.setBackGroundColor(backgroundColor);
    viewGroup.removeAllViews();
    viewGroup.addView(labelView);
  }
}
