package core.db;

import org.jooq.Record;

public interface Pc365Key {

  interface Factory<T> {
    Pc365Key newKey(T t);

    Pc365Key newKey(Record rs);
  }

  long[] getPKValues();

  interface LongKeyFactory<T> extends Factory<T> {
    @Override
    Pc365Key newKey(Record rs);

    Pc365Key newKey(long id);

  }

  interface LinkKeyFactory<T> extends Factory<T> {
    Pc365Key newKey(long idA, long idB);
  }
}
