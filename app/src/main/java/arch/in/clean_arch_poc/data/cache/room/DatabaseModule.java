package arch.in.clean_arch_poc.data.cache.room;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import arch.in.clean_arch_poc.data.cache.list.ArticleListCacheImpl;
import dagger.Module;
import dagger.Provides;


@Module
public class DatabaseModule {
  private static final String DATABASE = "database_name";

  @Provides
  @Named(DATABASE)
  String provideDatabaseName() {
    return DATABASE;
  }

  @Provides
  @Singleton
  AppDatabase provideStackOverflowDao(Context context, @Named(DATABASE) String databaseName) {
    return Room.databaseBuilder(context, AppDatabase.class, databaseName).build();
  }

  @Provides
  @Singleton
  ArticleListCacheImpl.GithuBContributorDao provideQuestionDao(AppDatabase appDatabase) {
    return appDatabase.userDao();
  }
}