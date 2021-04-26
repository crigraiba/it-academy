USE dbsegundo;

SELECT
	e.ENAME
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	LENGTH(d.LOC) > 5
ORDER BY
	d.LOC DESC,
	e.ENAME;