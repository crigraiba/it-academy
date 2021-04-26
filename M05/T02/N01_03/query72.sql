USE dbsegundo;

SELECT
	d.DNAME,
	AVG(e.SAL*12) AS 'AVG(SAL_MENSUAL)',
	COUNT(*) AS NUM_EMP
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