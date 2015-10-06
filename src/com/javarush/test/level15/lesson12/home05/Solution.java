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
public class Solution {
}
*/

