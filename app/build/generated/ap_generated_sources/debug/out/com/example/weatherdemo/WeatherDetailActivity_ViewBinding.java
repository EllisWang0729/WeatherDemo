// Generated code from Butter Knife. Do not modify!
package com.example.weatherdemo;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WeatherDetailActivity_ViewBinding implements Unbinder {
  private WeatherDetailActivity target;

  @UiThread
  public WeatherDetailActivity_ViewBinding(WeatherDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WeatherDetailActivity_ViewBinding(WeatherDetailActivity target, View source) {
    this.target = target;

    target.tvInfo = Utils.findRequiredViewAsType(source, R.id.tv_info, "field 'tvInfo'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WeatherDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvInfo = null;
  }
}
