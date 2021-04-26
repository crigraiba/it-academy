USE dbsegundo;

SELECT
	COUNT(*) AS NUM_EMP
FROM
	empleados
WHERE
	DEPTNO = 20;