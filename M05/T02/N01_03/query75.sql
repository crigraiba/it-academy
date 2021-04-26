USE dbsegundo;

-- e1 empleados
-- e2 jefes

SELECT
	e1.ENAME AS EMPLEADO,
	e2.ENAME AS JEFE
FROM
	empleados e1
LEFT JOIN
	empleados e2
ON
	e1.MGR = e2.EMPNO
ORDER BY
	e2.ENAME;