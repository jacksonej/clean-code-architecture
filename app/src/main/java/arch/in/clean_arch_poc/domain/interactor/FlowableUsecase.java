package arch.in.clean_arch_poc.domain.interactor;

import android.database.Observable;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;


public abstract class FlowableUsecase<T,C> {

    private final CompositeDisposable disposables;

      FlowableUsecase() {
        this.disposables = new CompositeDisposable();
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link FlowableUsecase}.
     */
    abstract Flowable<T> buildUseCaseObservable(C params);


    //public abstract Flowable<T> getUseCaseObservable(Params params);

    /**
     * Executes the current use case.
     *  @param observer {@link DisposableObserver} which will be listening to the observable build
     */
    public void execute(DisposableSubscriber<T> observer,C params) {

        final Flowable observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        addDisposable((Disposable) observable.subscribeWith(observer));
    }


    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}