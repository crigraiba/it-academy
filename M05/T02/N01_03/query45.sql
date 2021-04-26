USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE
	LENGTH(ENAME) <= 5;