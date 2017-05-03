package maskips.id.rnd;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import maskips.id.rnd.db.DaoMaster;
import maskips.id.rnd.db.DaoSession;

/**
 * Created by nurhidayat
 * on 5/3/17.
 */

public class AppController extends Application {
    public static final boolean ENCRYPTED = true;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "users-db-encrypted" : "users-db"); //name of db
        Database database = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret"): helper.getWritableDb(); //password if db encrypted
        daoSession = new DaoMaster(database).newSession();
    }


    public DaoSession getDaoSession() {
        return daoSession;
    }
}
