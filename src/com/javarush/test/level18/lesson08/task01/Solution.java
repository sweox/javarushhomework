package com.javarush.test.level18.lesson08.task01;

/* Wrapper (Decorator)
Разберись, что делает программа
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl
*/

public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }
    public static class DecoratorMyRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorMyRunnableImpl(Runnable component) {
            this.component = component;
        }
        @Override
        public void run() {
            System.out.print("DecoratorMyRunnableImpl body ");
            component.run();
        }
    }
}

 /*
    Сила этого примера не столько в создаваемом нашими руками классе, согласно заданию, сколько в принципе стека.
        new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl())))

        я так понимаю работу компилятора:

        1 — создать объект new RunnableImpl() — компилятор создает этот объект.
        компилятор отправляется в класс этого инстанса и видит там поля и методы, в частности, метод run(). Тут
        компилятору взять да и выполнить бы этот метод, но еще не инициализированы (то есть не прочитаны и не
        просчитаны, и не созданы, если вдруг есть, другие объекты) другие конструкции этого кода. Придется их
        сначала прочитать и инициализировать.

        2 — создать объект new DecoratorMyRunnableImpl с объектом new RunnableImpl(). Та же самая логика —
        выполнить бы прям щяс код, принадлежащий текущему инстансу, но у нас текущий инстанс является
        аргументов для другого инстанса. Едем дальше.

        3 — создать объект new DecoratorRunnableImpl с аргументом (new DecoratorMyRunnableImpl
        (new RunnableImpl())) — самое интересное (если я прально все понял) — хоть строчка кода и начинается
        с создания этого объекта, этот объект у нас создается лишь третьим в очереди. Т.о. методы этого объекта,
        созданного в последнюю очередь, оказываются на вершине стека, и именно с вершины стека начинается
        раскручиваться выполнение всех методов вниз во стеку.

        Код, вне всяких сомняшечек, достоин быть распечатанным с комментами и повешенным на стену для
        периодического втыкания.
=====================================
        Задумайся над тем что объединяет все эти классы включая Thread!!! Thread оборачивает
        new DecoratorRunnableImpl, DecoratorRunnableImpl оборачивает new DecoratorMyRunnableImpl,
        DecoratorMyRunnableImpl оборачивает new RunnableImp.
*/

/*

public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }

}
*/
