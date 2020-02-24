// Generated code from Butter Knife. Do not modify!
package com.example.weatherdemo;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WeatherAdapter$ImageViewHolder_ViewBinding implements Unbinder {
  private WeatherAdapter.ImageViewHolder target;

  @UiThread
  public WeatherAdapter$ImageViewHolder_ViewBinding(WeatherAdapter.ImageViewHolder target,
      View source) {
    this.target = target;

    target.ivImage = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'ivImage'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WeatherAdapter.ImageViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivImage = null;
  }
}
