package one.hendra.androidbase.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

public abstract class BaseListAdapter<M, B extends ViewDataBinding, L extends BaseListListener<M>> extends ListAdapter<M, BaseListViewHolder<M>> {

    private L mListener;

    public BaseListAdapter(@NonNull DiffUtil.ItemCallback<M> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    protected abstract Integer layoutView();

    protected abstract void bindData(M m, B b);

    public void setListener(L listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public BaseListViewHolder<M> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            final B b = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutView(), parent, false);
            return new BaseListViewHolder<M>(b) {
                @Override
                public void bind(final M m) {
                    if (mListener != null) {
                        itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mListener.onClick(m);
                            }
                        });
                        itemView.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                mListener.onLongClick(m);
                                return true;
                            }
                        });
                    }
                    bindData(m, b);
                }
            };
    }

    @Override
    public void onBindViewHolder(@NonNull BaseListViewHolder<M> holder, int position) {
            holder.bind(getItem(position));
    }

}
