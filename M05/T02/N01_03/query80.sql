USE dbsegundo;
	
-- LOC mín 4 EMP y sin DEPT sin EMP

SELECT
	d.LOC,
	COUNT(e.EMPNO) AS NUM_EMP
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	d.LOC NOT IN(
		SELECT
			d.LOC
		FROM
			empleados e
		RIGHT JOIN
			departamentos d
		ON
			e.DEPTNO = d.DEPTNO
		GROUP BY
			e.DEPTNO
		HAVING
			COUNT(e.EMPNO) = 0
	)
GROUP BY
	e.DEPTNO
HAVING
	NUM_EMP >= 4;