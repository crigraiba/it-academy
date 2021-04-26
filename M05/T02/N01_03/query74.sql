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
	d.LOC IN ('DALLAS', 'NEW YORK');