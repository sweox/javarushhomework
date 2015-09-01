package com.javarush.test.level13.lesson11.home05;

/* Neo
1. ����������� ��������� DBObject � ������ User.
2. ����������� ����� initializeIdAndName ���, ����� ��������� �������� � �������� �� ����� "User has name Neo, id = 1".
3. ����� toString � ����� main ������ ������.
4. �������, ��� ������ ���������� ����� initializeIdAndName � ������ User.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(Matrix.NEO);
    }

    static class Matrix
    {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject
    {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject
    {
        long id;
        String name;

        public DBObject initializeIdAndName(long id, String name) {
            User.this.id = id;
            User.this.name = name;
            //return new User(); // return Matrix.NEO; ������ ��� �������� ����� �� �� ���� ��.
            return User.this;
        }

        @Override
        public String toString()
        {
            return String.format("User has name %s, id = %d", name, id);
        }
    }
}
/*
public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
NEO ��� ��������� ���������� ���� DBObject, ������� ������ ������ �� ������ User.
------
�������� ����������� �� ��� ������

public DBObject initializeIdAndName(long id, String name) {
            this.id = id;
            this.name = name;
            return new User(); // return Matrix.NEO; ������ ��� �������� ����� �� �� ���� ��.
        }
������ �� 2 �������, ��� ���� =)
1. ���������� ������ ���� ���������� ���� �����?
�������� ����������� ���� (NEO ��� ��������� ���������� ���� DBObject, ������� ������ ������ ��
������ User.)
2. ��� ���������� ����� this?
� ��� � ���� ��������� =)
prestigio multipad 4 diamond 7.85 pmp7079d
*/