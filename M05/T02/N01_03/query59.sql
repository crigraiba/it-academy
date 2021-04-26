USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE
	SAL >= (
		SELECT
			AVG(SAL)
		FROM
			empleados
	);