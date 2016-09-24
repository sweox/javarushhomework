package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Solution.Constants.SERVER_NOT_ACCESSIBLE_EXCEPTION);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Solution.Constants.SERVER_NOT_ACCESSIBLE_EXCEPTION, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UNAUTHORIZED_USER_EXCEPTION);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UNAUTHORIZED_USER_EXCEPTION, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BANNED_USER_EXCEPTION);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BANNED_USER_EXCEPTION, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RESTRICTION_EXCEPTION);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RESTRICTION_EXCEPTION, cause);
        }
    }

    public static final class Constants {
        static final String SERVER_NOT_ACCESSIBLE_EXCEPTION = "Server is not accessible for now.";
        static final String UNAUTHORIZED_USER_EXCEPTION = "User is not authorized.";
        static final String BANNED_USER_EXCEPTION = "User is banned.";
        static final String RESTRICTION_EXCEPTION = "Access is denied.";
    }
}


/*

public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("Server is not accessible for now.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("Server is not accessible for now.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("User is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("User is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("User is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("User is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }
}
*/
