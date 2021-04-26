USE dbsegundo;

SELECT
	ENAME,
	SAL
FROM
	empleados
WHERE
	SAL IN (
		(
			SELECT
				MIN(SAL)
			FROM
				empleados
		), (
			SELECT
				MAX(SAL)
			FROM
				empleados
		)
	);