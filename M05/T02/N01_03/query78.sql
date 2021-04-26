USE dbsegundo;

SELECT
	d.DNAME,
	SUM(e.SAL)
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
GROUP BY
	e.DEPTNO
ORDER BY
	SUM(e.SAL) DESC
LIMIT
	1;