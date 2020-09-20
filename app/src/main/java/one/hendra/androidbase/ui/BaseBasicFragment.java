package one.hendra.androidbase.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseBasicFragment<B extends ViewDataBinding, V extends ViewModel> extends BaseFragment<B, V> {

    protected abstract void startCodeHere();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startCodeHere();
    }

}
