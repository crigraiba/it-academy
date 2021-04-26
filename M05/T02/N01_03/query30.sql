USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE NOT (
	SAL > 1000
	AND MGR = 7698
);