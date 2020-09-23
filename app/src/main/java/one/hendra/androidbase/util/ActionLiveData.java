package one.hendra.androidbase.util;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class ActionLiveData<T> extends MutableLiveData<T> {

    private boolean mHasBeenHandled;

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull final Observer<? super T> observer) {
        super.observe(owner, new Observer<T>() {
            @Override
            public void onChanged(T t) {
                if (mHasBeenHandled){
                    return;
                }
                mHasBeenHandled = true;
                observer.onChanged(t);
            }
        });
    }

    public void sendAction(T t){
        mHasBeenHandled = false;
        setValue(t);
    }

    public void sendAction(){
        mHasBeenHandled = false;
        setValue(null);
    }

    public class ActionData{

    }

}
