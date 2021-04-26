USE dbsegundo;

SELECT
	d.DNAME,
	SUM(e.SAL) AS 'SUM(SAL)'
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
GROUP BY
	e.DEPTNO
ORDER BY
	d.DNAME;