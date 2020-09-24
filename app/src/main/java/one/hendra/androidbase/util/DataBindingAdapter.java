package one.hendra.androidbase.util;

import com.google.android.material.textfield.TextInputLayout;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapter {

    @BindingAdapter("errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

}
