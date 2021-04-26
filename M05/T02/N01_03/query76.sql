USE dbsegundo;

SELECT
	e.ENAME,
	e.SAL,
	d.DNAME
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	SAL IN (
		SELECT
			MAX(SAL)
		FROM
			empleados
		GROUP BY
			DEPTNO
	);