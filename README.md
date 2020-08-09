# result
2020-08-09 10:55:39.586  WARN 11680 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning

2020-08-09 10:57:53.424 ERROR 11680 --- [nio-8215-exec-2] o.h.engine.jdbc.spi.SqlExceptionHelper   : Field 'id' doesn't have a default value
2020-08-09 10:57:53.446 ERROR 11680 --- [nio-8215-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.orm.jpa.JpaSystemException: could not execute statement; nested exception is org.hibernate.exception.GenericJDBCException: could not execute statement] with root cause

java.sql.SQLException: Field 'id' doesn't have a default value
