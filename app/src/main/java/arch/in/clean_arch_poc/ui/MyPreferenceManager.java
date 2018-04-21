package arch.in.clean_arch_poc.ui;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

public class MyPreferenceManager {

    Context context;


    @Inject
    public MyPreferenceManager(Context context) {
        this.context = context;
    }

    public void getPackage()
    {
        Log.e("hai",context.getPackageName()+"sss");

    }

}
