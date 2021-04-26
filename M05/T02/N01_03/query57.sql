USE dbsegundo;

SELECT
	e.DEPTNO,
	d.DNAME,
	AVG(e.SAL)
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	e.SAL < 5000
GROUP BY
	e.DEPTNO
HAVING
	MIN(e.SAL) > 900;