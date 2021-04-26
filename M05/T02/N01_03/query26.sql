USE dbsegundo;

SELECT
	*
FROM
	empleados
WHERE
	ASCII(ENAME) >= ASCII('J');