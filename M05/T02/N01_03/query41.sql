USE dbsegundo;

SELECT
	ENAME,
	SAL,
	COMM
FROM
	empleados
WHERE
	SAL BETWEEN COMM/2 AND COMM;