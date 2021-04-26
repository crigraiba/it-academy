USE dbsegundo;

SELECT
	*
FROM
	empleados
WHERE
	SAL > (
		SELECT
			SAL
		FROM
			empleados
		WHERE
			EMPNO = 7934
		)
ORDER BY
	SAL;