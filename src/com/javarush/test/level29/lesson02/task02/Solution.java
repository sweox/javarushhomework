package com.javarush.test.level29.lesson02.task02;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Рефакторинг в соответствии с Naming and Code Convention 2
Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга)
Не оставлять комментариев, проверяется строгое соответствие стандарту
*/

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        Solution solution = new Solution();
        String fileNameToBeOpenedByNotepad = solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = solution.getProcessStartNotepad(fileNameToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public Process getProcessStartNotepad(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

    public Path getAbsolutePathToDefaultTxtFile() {
        String packageName = Solution.class.getPackage().getName().replaceAll("[.]", "\\\\");
        String fileName = "src\\" + packageName + "\\file.txt";
        Path path = Paths.get(fileName);
        return path.toAbsolutePath();
    }
}

/*

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        Solution Solution = new Solution();
        String file_name_to_be_opened_by_notepad = Solution.Getabsolutepathtodefaulttxtfile().toString();
        Process NOTEPAD = Solution.getprocessstartnotepad(file_name_to_be_opened_by_notepad);
        NOTEPAD.waitFor();
    }

    public Process getprocessstartnotepad(String FILE_NAME) throws IOException {
        String[] cmd_array = new String[]{"notepad.exe", FILE_NAME};
        return Runtime.getRuntime().exec(cmd_array);
    }

    public Path Getabsolutepathtodefaulttxtfile() {
        String PackageName = Solution.class.getPackage().getName().replaceAll("[.]", "\\\\");
        String FileName = "src\\" + PackageName + "\\file.txt";
        Path PATH = Paths.get(FileName);
        return PATH.toAbsolutePath();
    }
}
*/
