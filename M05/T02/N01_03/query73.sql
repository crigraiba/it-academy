USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE
	DEPTNO = 30
ORDER BY
	COMM DESC;