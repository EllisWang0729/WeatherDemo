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

public class WeatherAdapter$ContentViewHolder_ViewBinding implements Unbinder {
  private WeatherAdapter.ContentViewHolder target;

  @UiThread
  public WeatherAdapter$ContentViewHolder_ViewBinding(WeatherAdapter.ContentViewHolder target,
      View source) {
    this.target = target;

    target.tvTime = Utils.findRequiredViewAsType(source, R.id.time, "field 'tvTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WeatherAdapter.ContentViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTime = null;
  }
}
