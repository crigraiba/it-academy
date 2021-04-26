USE dbsegundo;

-- e1 jefes
-- e2 empleados

SELECT
	e1.ENAME
FROM
	empleados e1
JOIN
	empleados e2
ON
	e1.EMPNO = e2.MGR
GROUP BY
	e1.EMPNO
ORDER BY
	e1.ENAME DESC;