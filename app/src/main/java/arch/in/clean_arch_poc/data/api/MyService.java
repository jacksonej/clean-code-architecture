package arch.in.clean_arch_poc.data.api;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyService {
    private final String apiService="hai";


    Context context;

    @Inject
    public MyService(Context context) {
        this.context=context;
    }

    public String getString(){
        Log.e("hai","jinka jinka"+context.getPackageName());
        return  apiService;
    }


}