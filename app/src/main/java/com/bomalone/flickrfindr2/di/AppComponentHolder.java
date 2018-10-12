package com.bomalone.flickrfindr2.di;

public class AppComponentHolder {

    private ApplicationComponent mApplicationComponent;

    private static final AppComponentHolder COMPONENT_HOLDER = new AppComponentHolder();

    private AppComponentHolder() {
    }

    public static AppComponentHolder getInstance() {
        return COMPONENT_HOLDER;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.mApplicationComponent = applicationComponent;
    }
}
