package arch.in.clean_arch_poc.data.cache.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import arch.in.clean_arch_poc.domain.model.GithubContributor;

@Database(entities = {GithubContributor.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GithuBContributorDao userDao();
}