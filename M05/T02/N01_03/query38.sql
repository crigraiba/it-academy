USE dbsegundo;

SELECT
	*
FROM
	empleados
WHERE
	LENGTH(ENAME) >= 5;