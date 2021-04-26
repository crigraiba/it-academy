USE dbsegundo;

-- e1 jefes
-- e2 empleados

SELECT
	e1.ENAME,
	e1.EMPNO,
	COUNT(e2.EMPNO) AS NUM_EMP
FROM
	empleados e1
RIGHT JOIN
	empleados e2
ON
	e1.EMPNO = e2.MGR
GROUP BY
	e1.EMPNO;