USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE
	SAL > 1000
	AND MGR = 7698;