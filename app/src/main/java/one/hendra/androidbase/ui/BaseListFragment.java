package one.hendra.androidbase.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseListFragment<B extends ViewDataBinding, V extends ViewModel, M, A extends BaseListAdapter> extends BaseFragment<B, V> {

    private A mAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = adapter();
        mAdapter.setListener(listener());
        startCodeHere();
    }

    protected abstract void startCodeHere();

    protected abstract A adapter();

    public A getAdapter() {
        return mAdapter;
    }

    protected abstract BaseListListener<M> listener();
}
