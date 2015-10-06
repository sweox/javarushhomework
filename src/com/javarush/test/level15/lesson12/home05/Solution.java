package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали
конструкторам класса Solution.
*/

public class Solution {
    private Solution(char c) {}
    private Solution(Character g) {}
    private Solution(Float F) {}

    Solution() {}
    Solution(double d) {}
    Solution(Double D) {}

    public Solution(int i) {}
    public Solution(Integer I) {}
    public Solution(float f) {}

    protected Solution(String g) {}
    protected Solution(Object O) {}
    protected Solution(boolean b) {}
}
/*
Ты меня не понял. Конструктор по умолчанию — это конструктор без параметров. В моем
родительском классе не было такого, а т.к. конструктор с нужной мне сигнатурой у
родителя невиден (т.к. он private), то мой наследник обращается к родительскому
конструктору по умолчанию, а он у меня не был определен. Вот и вся проблема.)))
Модификатор доступа тут не при чем.
*/

/*
public class Solution {
}
*/

