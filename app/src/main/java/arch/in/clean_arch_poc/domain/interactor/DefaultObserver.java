package arch.in.clean_arch_poc.domain.interactor;

import io.reactivex.subscribers.DisposableSubscriber;

public class DefaultObserver<T> extends DisposableSubscriber<T> {
  @Override public void onNext(T t) {
    // no-op by default.
  }

  @Override public void onComplete() {
    // no-op by default.
  }

  @Override public void onError(Throwable exception) {
    // no-op by default.
  }
}