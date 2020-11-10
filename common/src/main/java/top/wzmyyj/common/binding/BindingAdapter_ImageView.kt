package top.wzmyyj.common.binding

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.File

/**
 * Created on 2020/11/05.
 *
 * BindingAdapter of ImageView.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 * @see ImageView
 */
@BindingAdapter(
    value = ["binding_src_url", "binding_src_placeholder", "binding_src_error"],
    requireAll = false
)
fun ImageView.bindingImageUrl(url: String?, placeholder: Drawable?, error: Drawable?) {
    Glide.with(this)
        .load(url)
        .placeholder(placeholder)
        .apply(RequestOptions().fitCenter().error(error))
        .into(this)
}

@BindingAdapter("binding_src_url_circle")
fun ImageView.bindingCircleImageUrl(url: String?) {
    //todo
}

@BindingAdapter("binding_src_file")
fun ImageView.bindingFileToImage(file: File?) {
    if (file != null) {
        val uri = Uri.fromFile(file)
        this.setImageURI(uri)
    }
}

@BindingAdapter("binding_src_filePath")
fun ImageView.bindingFileToImageFromPath(path: String?) {
    if (path.isNullOrEmpty().not()) {
        val uri = Uri.parse(path)
        this.setImageURI(uri)
    }
}

@BindingAdapter("binding_img_res")
fun ImageView.bindingImageResource(res: Int) {
    this.setImageResource(res)
}

@BindingAdapter("binding_src_drawable")
fun ImageView.bindingImageDrawable(drawable: Drawable) {
    this.setImageDrawable(drawable)
}

@BindingAdapter("binding_src_load_drawable")
fun ImageView.bindingLoadImageDrawable(drawable: Drawable) {
    //todo
}


