USE dbsegundo;

SELECT
	ENAME,
	SAL,
	SAL+1000 AS NUEVO_SALARIO
FROM
	empleados
WHERE
	DEPTNO = 30;