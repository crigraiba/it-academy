USE dbsegundo;

SELECT
	*
FROM
	empleados
WHERE
	JOB = 'CLERK'
ORDER BY
	ENAME;