package test.Foof;

/**
 * Created by Belshina on 06.03.16.
 */
public final class Foof //не может быть унаследован
{
    final int size = 3; //нельзя изменить переменные экземпляра
    final int whufe;

    Foof () {
        whufe = 42;
    }

    void doStuff (final int x) {}   //нельзя изменить аргумент

    void doMore() {
        final int z = 7;    //нельзя изменить локальную переменную
    }

    final void calcFoof() {}    //нельзя переопределить
}
