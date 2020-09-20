package one.hendra.androidbase.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseListViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseListViewHolder(@NonNull ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
    }

    public abstract void bind(T t);

}
