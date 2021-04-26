USE dbsegundo;

SELECT
	DNAME
FROM
	departamentos
GROUP BY
	DEPTNO
HAVING
	DEPTNO NOT IN(
		SELECT
			DISTINCT DEPTNO
		FROM
			empleados
	);