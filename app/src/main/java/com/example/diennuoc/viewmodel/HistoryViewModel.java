package com.example.diennuoc.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistoryViewModel extends ViewModel {
    private MutableLiveData<Boolean> clickedBack = new MutableLiveData<>();
    private MutableLiveData<Boolean> clickedDelete = new MutableLiveData<>();

    public MutableLiveData<Boolean> getClickedBack() {
        return clickedBack;
    }

    public MutableLiveData<Boolean> getClickedDelete() {
        return clickedDelete;
    }

    public void onClickBack() {
        clickedBack.setValue(true);
    }

    public void onClickDelete() {
        clickedDelete.setValue(true);
    }
}
