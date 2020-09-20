package one.hendra.androidbase.ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseFragment<B extends ViewDataBinding, V extends ViewModel> extends Fragment {

    private V mViewModel;
    private B mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, layoutView(), container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getViewModelFactory() == null)
            mViewModel = (V) new ViewModelProvider(this).get(viewModelClass());
        else
            mViewModel = (V) new ViewModelProvider(this, getViewModelFactory()).get(viewModelClass());
    }

    @NonNull
    protected abstract Class viewModelClass();

    @NonNull
    protected abstract Integer layoutView();

    public V getViewModel() {
        return mViewModel;
    }

    public B getBinding() {
        return mBinding;
    }

    public ViewModelProvider.AndroidViewModelFactory getViewModelFactory() {
        return null;
    }

}
