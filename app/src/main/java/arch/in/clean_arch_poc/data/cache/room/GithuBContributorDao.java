package arch.in.clean_arch_poc.data.cache.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import arch.in.clean_arch_poc.domain.model.GithubContributor;
import io.reactivex.Flowable;

@Dao
public interface GithuBContributorDao {

    @Query("SELECT * FROM githubcontributor ORDER BY contributions DESC")
    Flowable<List<GithubContributor>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<GithubContributor> users);

    @Delete
    void delete(GithubContributor user);

    @Query("SELECT count(*) FROM githubcontributor")
    Flowable<Integer> getCount();

}