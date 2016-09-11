package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder where = new StringBuilder();
        for (Map.Entry<String, String> m : params.entrySet()) {
            if (m.getValue() != null ) {
                if (where.toString().equals("")) {
                    where.append(m.getKey()).append(" = '").append(m.getValue()).append("'");
                } else
                    where.append(" and ").append(m.getKey()).append(" = '").append(m.getValue()).append("'");
            }
        }
        return where;
    }

}
