package com.javarush.test.level10.lesson11.Bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* ����� �������� � ��������� ����� ����������������
������: ��������� ������ � ���������� ���� (����� � ������) � ������� �� �� �����.
����� ������: ��������� ������ � ���������� ���� (����� � ������), ��������� �� � HashMap.
������ ������ � ����� ����� ������. ����� ���� �����������. ������ ������ ���������.
��������� ������ �� ������ ����������!
����� ��������� ������� ���������� HashMap �� �����.

������ �����:
1
����
2
����
1
����

������ ������:
1 ����
2 ����
1 ����
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> cons = new HashMap<String, Integer>();
        while (true)
        {
            String r = reader.readLine();
            if (r.isEmpty()) break;
            else
            {
                int id = Integer.parseInt(r);
                String name = reader.readLine();
                if (name.isEmpty()) break;
                cons.put(name, id);
            }
        }

        for (Map.Entry<String, Integer> map:cons.entrySet())
        {
            System.out.println(map.getValue() + " " + map.getKey());
        }
    }
}

