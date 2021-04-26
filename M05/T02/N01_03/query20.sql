USE dbsegundo;

SELECT
	ENAME,
	SAL+1000
FROM
	empleados
WHERE
	DEPTNO = 30;