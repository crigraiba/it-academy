USE dbsegundo;

SELECT
	ENAME,
	JOB,
	SAL
FROM
	empleados
WHERE
	SAL > (
		SELECT
			SAL
		FROM
			empleados
		WHERE
			ENAME = 'Allen'
		)
	OR ENAME = 'Allen';