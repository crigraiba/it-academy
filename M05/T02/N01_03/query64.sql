USE dbsegundo;

SELECT
	DEPTNO,
	COUNT(*) AS NUM_EMP
FROM
	empleados
GROUP BY
	DEPTNO
HAVING
	COUNT(*) > 3;